package com.elseco.nyms.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.multipart.MultipartFile;

import com.elseco.nyms.config.MailConfigMap;
import com.elseco.nyms.exception.ReportGenerationException;
import com.elseco.nyms.model.Mail;
import com.elseco.nyms.model.NymsResponse;
import com.elseco.nyms.model.claim.Inputclaim;
import com.elseco.nyms.model.notify.RecipientsAttachments;
import com.elseco.nyms.model.notify.RecipientsVsElementDataMap;
import com.elseco.nyms.utils.EmailUtil;
import com.elseco.nyms.utils.HTML2TextOutput;
import com.elseco.nyms.utils.JsonUtils;
import com.elseco.nyms.utils.XmlUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.serole.core.utils.CommonCoreUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * @author sonjoy
 *
 */
@Component
@PropertySource({ "application.yml", "file:${nymsConfigFileLocation}/${nymsConfigFileName}.yml" })
public class EmailService extends PdfPageEventHelper {
	private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);
	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	private Configuration freemarkerConfig;
	private Template sampleTemplate = null;

	@Autowired
	private MailConfigMap mailConfigMap;

	private Map<String, String> mailConfig = null;

	private static Map<String, Template> templateMap = null;

	private static final String XML = "xml";
	private static final String JSON = "json";

	@Value("${nymsAttachmentLocation}")
	public String nymsAttachmentLocation;

	@Value("${nyms.mail.service.to}")
	public String toRecipient;

	@Value("${nyms.mail.service.cc}")
	public String ccRecipient;

	@Value("${nyms.mail.service.from}")
	public String fromRecipient;

	@PostConstruct
	private void init() {
		try {
			templateMap = new HashMap<>();
			sampleTemplate = freemarkerConfig.getTemplate("email-template.ftl");
			mailConfig = mailConfigMap.getMailConfigMap();

			templateMap.put("companies", freemarkerConfig.getTemplate("customer-report.ftl"));
			templateMap.put("createClaimNotify", freemarkerConfig.getTemplate("email-template.ftl"));

			templateMap.put("createClaimEmailAttachment",
					freemarkerConfig.getTemplate("create_claim_notify_member.ftl"));
			templateMap.put("createClaimEmailBody",
					freemarkerConfig.getTemplate("create_claim_notify_member_mail_body.ftl"));

		} catch (final IOException e) {
			LOG.error("Error while creating template due to....{}", e);
			throw new ReportGenerationException("Unable to load all the templates");
		}
	}

	protected ElementList header;
	protected ElementList footer;

	public static final String DEST = "results/events/html_header_footer.pdf";
	public static final String HEADER = "<table width=\"100%\" border=\"0\" style=\"width: 100%;\"><tbody><tr style=\"height: 21px;\"><td style=\"width: 10%; height: 21px; text-align: left;\">&nbsp;</td><td style=\"width: 80%; height: 21px; text-align: center;\"><span>else</span><span style=\"color: #ff0000;\">co</span><span>&nbsp;Claim Collect Fund Notification</span></td><td style=\"width: 10%; height: 21px; text-align: right;\">&nbsp;</td></tr></tbody></table>";
	public static final String FOOTER = "<table width=\"100%\"><tbody><tr><td style=\"text-align: center;\"><p style=\"font-size:10px;\"><span>else</span><span style=\"color: #ff0000;\">co</span><span>&nbsp;limited a Company Limited by Shares under the Companies Law, DIFC Law No.3 of 2006.</span><br/><span> Address: Gate Village 8, Dubai International Financial Centre, PO Box: 506639, Dubai, UAE.</span></p></td></tr></tbody></table>";

	public EmailService() throws IOException {
		header = XMLWorkerHelper.parseToElementList(HEADER, null);
		footer = XMLWorkerHelper.parseToElementList(FOOTER, null);
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		try {
			ColumnText ct = new ColumnText(writer.getDirectContent());

			ct.setSimpleColumn(new Rectangle(36, 832, 559, 810));
			for (Element e : header) {
				ct.addElement(e);
			}
			ct.go();
			ct.setSimpleColumn(new Rectangle(36, 50, 600, 32));
			for (Element e : footer) {
				ct.addElement(e);
			}
			ct.go();
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	public void sendSimpleMessage(final Map<String, String> data) {
		LOG.info("Sending mail..");
		final MimeMessage message = emailSender.createMimeMessage();

		try {
			if (sampleTemplate == null) {
				LOG.error("Not able to create freemarker template");
				throw new ReportGenerationException("Unable to find template");
			}

			final MimeMessageHelper helper = new MimeMessageHelper(message,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

			final String html = FreeMarkerTemplateUtils.processTemplateIntoString(sampleTemplate, data);

			helper.setTo(data.get("to"));
			helper.setText(html, true);
			helper.setSubject(data.get("subject"));
			helper.setFrom(data.get("from"));

			emailSender.send(message);

		} catch (MessagingException | TemplateException | IOException e) {

			LOG.error("Unable to send mail due to {}", e);
			throw new ReportGenerationException("Unable to send mail");
		}

	}

	public void sendSimpleMessage(final Map<String, String> data, final Mail mail) {
		LOG.info("Sending mail..");
		data.put("to", mail.getTo());
		data.put("subject", mail.getSubject());
		data.put("content", (String) mail.getContent());
		sendSimpleMessage(data);
	}

	/**
	 * 
	 * @param mail
	 */
	public void sendReportMessage(final Mail mail) {
		LOG.info("Sending mail..");
		final MimeMessage message = emailSender.createMimeMessage();
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		Writer fileWriter = null;
		try {
			final String templateName = mail.getTemplateName();
			final Template reportTemplate = templateMap.get(templateName);
			if (reportTemplate == null) {
				LOG.error("Not able to create freemarker template");
				throw new ReportGenerationException("Unable to find template");
			}

			final Map<String, Object> input = new HashMap<String, Object>();
			input.put("title", mail.getContent());
			input.put(templateName, mail.getReports());
			final MimeMessageHelper helper = new MimeMessageHelper(message,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			final String html = FreeMarkerTemplateUtils.processTemplateIntoString(reportTemplate, input);

			final File file = new File("output.html");
			fileWriter = new FileWriter(file);
			reportTemplate.process(input, fileWriter);

			final Document document = new Document();
			fileOutputStream = new FileOutputStream("result.pdf");
			final PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);
			document.open();

			fileInputStream = new FileInputStream("output.html");

			XMLWorkerHelper.getInstance().parseXHtml(writer, document, fileInputStream);

			document.close();

			final FileSystemResource fileSystemResource = new FileSystemResource("result.pdf");

			helper.setTo(mail.getTo());
			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mailConfig.get("from"));
			helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

			emailSender.send(message);

			LOG.info("PDF Created!");

			LOG.info("Mail sent successfully....");

		} catch (MessagingException | TemplateException | DocumentException | IOException e) {
			LOG.error("Unable to send mail due to {}", e);
			throw new ReportGenerationException("Unable to generate report");
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}

				if (fileOutputStream != null) {
					fileOutputStream.close();

				}

				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (final Exception e) {
				LOG.error("Unable to send mail due to {}", e.getMessage());
				throw new ReportGenerationException("Unable to generate report");
			}

		}
	}

	/**
	 * 
	 * @param requestData
	 * @param reportFile
	 * @return
	 */
	public NymsResponse process(final Map<String, Object> requestData, final MultipartFile reportFile) {
		Mail mail = null;
		String responseMessage = null;

		try {
			String fileType = reportFile.getOriginalFilename();
			fileType = StringUtils.substringAfter(fileType, CommonCoreUtil.DOT);

			if (XML.equalsIgnoreCase(fileType)) {
				responseMessage = "Report generated and mail has been sent";
				mail = JsonUtils.convertMapToMail(requestData);
				mail.setReports(XmlUtils.parseXmlReportContent(reportFile.getInputStream()));
				sendReportMessage(mail);

			} else if (JSON.equalsIgnoreCase(fileType)) {
				responseMessage = "Report generated and mail has been sent";
				final String reportFileInput = new String(reportFile.getBytes());
				mail = JsonUtils.convertMail(requestData, reportFileInput);
				sendReportMessage(mail);
			} else {
				responseMessage = "File not found/Invalid chacters in File";
			}

		} catch (IOException e) {
			LOG.error("Error due to...{}", e);
			throw new ReportGenerationException(e.getMessage());
		}

		return new NymsResponse(responseMessage, requestData);
	}

	public NymsResponse generateNUploadNSendMail(final Map<String, Object> requestData) {
		LOG.info("generateDocNUploadNSendMail : Start");

		String responseMessage = "generating Attachment and Sending Mail ..";
		Inputclaim oInput = null;
		// creating the request object from inbound json message

		try {
			oInput = JsonUtils.convertMapToReqObj(requestData);
			NymsResponse oNymsResponse = generateDocNUploadNSendMail(oInput);
		} catch (Exception e) {
			LOG.error("Error due to...{}", e);
			throw new ReportGenerationException(e.getMessage());
		}

		LOG.info("generateDocNUploadNSendMail : End");
		return new NymsResponse(responseMessage, requestData);

	}

	/**
	 * 
	 * @param mail
	 */
	public NymsResponse generateDocNUploadNSendMail(Inputclaim oInput) {
		LOG.info("generateDocNUploadNSendMail : Start");

		// Mail mail = null;
		String responseMessage = "generating Attachment and Sending Mail ..";

		Template reportTemplateForAttachment = null;
		Template reportTemplateForEmailBody = null;

		InputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		Writer fileWriter = null;

		try {
			String templateNameForAttachment = "createClaimEmailAttachment";
			String templateNameForEmailBody = "createClaimEmailBody";

			// validating the availability of template from config

			if (templateMap == null) {
				init();
			}

			if (templateNameForAttachment != null) {
				reportTemplateForAttachment = templateMap.get(templateNameForAttachment);
				if (reportTemplateForAttachment == null) {
					LOG.error("Not able to create freemarker template");
					throw new ReportGenerationException("Unable to find template");
				}
			}

			if (templateNameForEmailBody != null) {
				reportTemplateForEmailBody = templateMap.get(templateNameForEmailBody);
				if (reportTemplateForEmailBody == null) {
					LOG.error("Not able to create freemarker template");
					throw new ReportGenerationException("Unable to find template");
				}
			}

			// creating map list of all those incoming
			List<RecipientsVsElementDataMap> oRecipientsVsElementDataMapList = new ArrayList<RecipientsVsElementDataMap>();
			List<Map<String, String>> oMap = new ArrayList<Map<String, String>>();
			Map<String, String> oMapi = new HashMap<String, String>();

			try {
				if (templateNameForAttachment != null) {
					oMapi = mappingElementsForCreateClaim(oInput, oRecipientsVsElementDataMapList,
							templateNameForAttachment, templateNameForEmailBody);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			List<String> oListHtml = new ArrayList<String>();
			List<FileSystemResource> oFileSystemResourceList = new ArrayList<FileSystemResource>();

			List<Map<String, RecipientsAttachments>> oRAList = new ArrayList<Map<String, RecipientsAttachments>>();

			final MimeMessage message = emailSender.createMimeMessage();
			final MimeMessageHelper helper = new MimeMessageHelper(message,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

			List<RecipientsAttachments> oRecipientsAttachmentsList = new ArrayList<RecipientsAttachments>();

			for (RecipientsVsElementDataMap oRecipientsVsElementDataMap : oRecipientsVsElementDataMapList) {

				Map<String, RecipientsAttachments> oRA = new HashMap<String, RecipientsAttachments>();

				Map<String, String> inputForAttachments = oRecipientsVsElementDataMap
						.getHtmlMapElementsForAttachments();
				String html = FreeMarkerTemplateUtils.processTemplateIntoString(reportTemplateForAttachment,
						inputForAttachments);

				Map<String, String> inputEmailBody = oRecipientsVsElementDataMap.getHtmlMapElementsForEmailBody();
				String htmlEmailBody = FreeMarkerTemplateUtils.processTemplateIntoString(reportTemplateForEmailBody,
						inputEmailBody);

				String fName = templateNameForAttachment + System.currentTimeMillis();

				File file = new File(nymsAttachmentLocation + fName + "output.html");
				fileWriter = new FileWriter(file);
				reportTemplateForAttachment.process(inputForAttachments, fileWriter);

				Document document = new Document(PageSize.A4, 36, 36, 36, 72);

				StringBuilder contentBuilder = new StringBuilder();

				PdfWriter writer;
				try {
					writer = PdfWriter.getInstance(document, new FileOutputStream(nymsAttachmentLocation + fName + "result.pdf"));
					writer.setPageEvent(new EmailService());
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				document.open();
				HTMLWorker oHTMLWorker = new HTMLWorker(document);
				String str = "";
				BufferedReader in = null;
				try {
					in = new BufferedReader(new FileReader(nymsAttachmentLocation + fName + "output.html"));
					while ((str = in.readLine()) != null) {
						contentBuilder.append(str);
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					in.close();
					System.gc();
				}
				String content = contentBuilder.toString();

				String Content = content.replaceAll("<a.*?>", "").replaceAll("<A.*?>", "");
				Content = content.replaceAll("</a>", "").replaceAll("</A>", "");

				oHTMLWorker.parse(new StringReader(Content));

				document.close();

				// fileInputStream = new FileInputStream(fName + "output.html");
				// fileInputStream = new ByteArrayInputStream(html.toString().getBytes());

				// document.add(new Paragraph(html));

				// XMLWorkerHelper.getInstance().parseXHtml(writer, document, fileInputStream);

				// fileSystemResource = new FileSystemResource(fName + "result.pdf");
				FileSystemResource fileSystemResource = new FileSystemResource(nymsAttachmentLocation + fName + "result.pdf");
				oFileSystemResourceList.add(fileSystemResource);
				LOG.info("HTML Attachment Created!");

				RecipientsAttachments oRecipientsAttachments = new RecipientsAttachments(
						oRecipientsVsElementDataMap.getRecipients(), null, htmlEmailBody, fileSystemResource);

				oRecipientsAttachmentsList.add(oRecipientsAttachments);

			}

			String succErr = sendMailWithAttachment(oInput, oRecipientsAttachmentsList,oMapi);

		} catch (MessagingException | TemplateException | IOException e) {
			LOG.error("Unable to send mail due to {}", e);
			// throw new ReportGenerationException("Unable to generate report");
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}

				if (fileOutputStream != null) {
					fileOutputStream.close();
				}

				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (final Exception e) {
				LOG.error("Unable to send mail due to {}", e.getMessage());
				// throw new ReportGenerationException("Unable to generate report");
			}

		}

		LOG.info("generateDocNUploadNSendMail : End");
		return new NymsResponse(responseMessage, responseMessage);
	}

	/**
	 * 
	 * @param oReqObj
	 * @param oMap
	 * @return
	 */
	public Map<String, String> mappingElementsForCreateClaim(Inputclaim oInput,
			List<RecipientsVsElementDataMap> oRecipientsVsElementDataMapList, String templateNameForAttachment,
			String templateNameForEmailBody) {
		String succErr = "Error";

		Map<String, String> oMapi = new HashMap<String, String>();

		int claimDetailsSize = 0;

		if (oInput.getClaimsInfo() != null && oInput.getClaimsInfo().getClaimDetailsInfo().size() > 0) {

			claimDetailsSize = oInput.getClaimsInfo().getClaimDetailsInfo().size();

			try {

				for (int loop = 0; loop < claimDetailsSize; loop++) {

					Map<String, RecipientsVsElementDataMap> oMap = new HashMap<String, RecipientsVsElementDataMap>();
					Map<String, String> htmlMapElementsForAttachments = new HashMap<String, String>();
					Map<String, String> htmlMapElementsForEmailBody = new HashMap<String, String>();
					List<String> recipientList = new ArrayList<String>();

					htmlMapElementsForAttachments.put("member", "<font color='red'></font>");
					htmlMapElementsForAttachments.put("aircraftName", "<font color='red'>aircraftName</font>");
					htmlMapElementsForAttachments.put("flightNo", "<font color='red'>flightNo</font>");
					htmlMapElementsForAttachments.put("operatorName", "<font color='red'>operatorName</font>");
					htmlMapElementsForAttachments.put("serviceStartYear", "<font color='red'>serviceStartYear</font>");
					htmlMapElementsForAttachments.put("operatingStartYear",
							"<font color='red'>operatingStartYear</font>");
					htmlMapElementsForAttachments.put("noOfSeatsInFlight",
							"<font color='red'>noOfSeatsInFlight</font>");
					htmlMapElementsForAttachments.put("currency", "<font color='red'>currency</font>");
					htmlMapElementsForAttachments.put("noOfParticipations",
							"<font color='red'>noOfParticipations</font>");
					htmlMapElementsForAttachments.put("grossPercentage", "<font color='red'>grossPercentage</font>");
					htmlMapElementsForAttachments.put("netPercentage", "<font color='red'>netPercentage</font>");
					htmlMapElementsForAttachments.put("limitAmount", "<font color='red'>limitAmount</font>");
					htmlMapElementsForAttachments.put("poolName", "<font color='red'>poolName</font>");
					htmlMapElementsForAttachments.put("internalReferenceNumber",
							"<font color='red'>internalReferenceNumber</font>");
					htmlMapElementsForAttachments.put("noOfParticipation",
							"<font color='red'>noOfParticipation</font>");

					htmlMapElementsForAttachments.put("claimDescription",
							oInput.getClaimsInfo().getEventDescription() != null
									? "<span style=\"background-color: #ffff00;\">"
											+ oInput.getClaimsInfo().getEventDescription().toString() + "</span>"
									: "");

					htmlMapElementsForAttachments.put("incidentDescription",
							oInput.getClaimsInfo().getEventDescription() != null
									? "<span style=\"background-color: #ffff00;\">"
											+ oInput.getClaimsInfo().getEventDescription().toString() + "</span>"
									: "");

					htmlMapElementsForAttachments.put("lobCode",
							oInput.getClaimsInfo().getLobCode() != null ? "<span style=\"background-color: #ffff00;\">"
									+ oInput.getClaimsInfo().getLobCode().toString() + "</span>" : "");

					htmlMapElementsForAttachments
							.put("incidentDate",
									oInput.getClaimsInfo().getDateOfLoss() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getDateOfLoss().toString() + "</span>"
											: "");

					htmlMapElementsForAttachments
							.put("brokerName",
									oInput.getClaimsInfo().getClaimReporter() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getClaimReporter().toString() + "</span>"
											: "");

					////////////////////////////////////////////////////////////////////////////////////////////

					/* setting the email attachment map elements */
					htmlMapElementsForAttachments
							.put("umrNumber",
									oInput.getClaimsInfo().getUmrNumber() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getUmrNumber().toString() + "</span>"
											: "");

					htmlMapElementsForAttachments
							.put("ucrNumber",
									oInput.getClaimsInfo().getUcrNumber() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getUcrNumber().toString() + "</span>"
											: "");

					if (!oMapi.containsKey("umr")) {
						oMapi.put("umr",
								oInput.getClaimsInfo().getUmrNumber() != null
										? oInput.getClaimsInfo().getUmrNumber().toString()
										: "");
					}

					if (!oMapi.containsKey("ucr")) {
						oMapi.put("ucr",
								oInput.getClaimsInfo().getUcrNumber() != null
										? oInput.getClaimsInfo().getUcrNumber().toString()
										: "");
					}

					htmlMapElementsForAttachments.put("effectiveDate",
							oInput.getClaimsInfo().getClaimDetailsInfo().get(loop).getInceptionDate() != null
									? "<span style=\"background-color: #ffff00;\">" + oInput.getClaimsInfo()
											.getClaimDetailsInfo().get(loop).getInceptionDate().toString() + "</span>"
									: "");

					htmlMapElementsForAttachments.put("dealType",
							oInput.getClaimsInfo().getDealType() != null ? "<span style=\"background-color: #ffff00;\">"
									+ oInput.getClaimsInfo().getDealType().toString() + "</span>" : "");

					htmlMapElementsForAttachments
							.put("sectionName",
									oInput.getClaimsInfo().getSectionName() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getSectionName().toString() + "</span>"
											: "");

					htmlMapElementsForAttachments.put("insured",
							oInput.getClaimsInfo().getInsured() != null ? "<span style=\"background-color: #ffff00;\">"
									+ oInput.getClaimsInfo().getInsured().toString() + "</span>" : "");

					htmlMapElementsForAttachments
							.put("reinsured",
									oInput.getClaimsInfo().getReinsured() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getReinsured().toString() + "</span>"
											: "");

					htmlMapElementsForAttachments
							.put("eventFromDate",
									oInput.getClaimsInfo().getEventFromDate() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getEventFromDate().toString() + "</span>"
											: "");

					htmlMapElementsForAttachments
							.put("eventToDate",
									oInput.getClaimsInfo().getEventToDate() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getEventToDate().toString() + "</span>"
											: "");

					htmlMapElementsForAttachments.put("dateOfLoss",
							oInput.getClaimsInfo().getClaimDetailsInfo().get(loop).getDateOfLoss() != null
									? "<span style=\"background-color: #ffff00;\">"
											+ oInput.getClaimsInfo().getClaimDetailsInfo().get(loop).getDateOfLoss()
											+ "</span>".toString()
									: "");

					htmlMapElementsForAttachments.put("ucrName",
							oInput.getClaimsInfo().getUcrName() != null ? "<span style=\"background-color: #ffff00;\">"
									+ oInput.getClaimsInfo().getUcrName().toString() + "</span>" : "");

					htmlMapElementsForAttachments
							.put("claimHandler",
									oInput.getClaimsInfo().getClaimHandler() != null
											? "<span style=\"background-color: #ffff00;\">"
													+ oInput.getClaimsInfo().getClaimHandler().toString() + "</span>"
											: "");

					/* finding member's emails */
					for (int a = 0; a <= loop; a++) {
						int size2 = oInput.getClaimsInfo().getClaimDetailsInfo().get(a).getPolicyTransactionsInfo()
								.size();
						for (int b = 0; b < size2; b++) {
							int size3 = oInput.getClaimsInfo().getClaimDetailsInfo().get(a).getPolicyTransactionsInfo()
									.get(b).getClaimsInternalRefInfo().size();

							/* setting the email body map elements */
							htmlMapElementsForEmailBody.put("approveLink",
									oInput.getClaimsInfo().getClaimDetailsInfo().get(a).getPolicyTransactionsInfo()
											.get(b).getApproveUrl() != null
													? oInput.getClaimsInfo().getClaimDetailsInfo().get(a)
															.getPolicyTransactionsInfo().get(b).getApproveUrl()
															.toString()
													: "");
							htmlMapElementsForEmailBody.put("rejectLink",
									oInput.getClaimsInfo().getClaimDetailsInfo().get(a).getPolicyTransactionsInfo()
											.get(b).getRejectUrl() != null
													? oInput.getClaimsInfo().getClaimDetailsInfo().get(a)
															.getPolicyTransactionsInfo().get(b).getRejectUrl()
															.toString()
													: "");

							/* Setting up the emails from the members for the specific stamp id */
							for (int c = 0; c < size3; c++) {
								int size4 = oInput.getClaimsInfo().getClaimDetailsInfo().get(a)
										.getPolicyTransactionsInfo().get(b).getClaimsInternalRefInfo().get(c)
										.getMemberInfo().size();
								for (int d = 0; d < size3; d++) {
									int size5 = oInput.getClaimsInfo().getClaimDetailsInfo().get(a)
											.getPolicyTransactionsInfo().get(b).getClaimsInternalRefInfo().get(c)
											.getMemberInfo().get(d).getMemberResultsInfo().size();
									for (int e = 0; e < size3; e++) {
										String memberEmail = oInput.getClaimsInfo().getClaimDetailsInfo().get(a)
												.getPolicyTransactionsInfo().get(b).getClaimsInternalRefInfo().get(c)
												.getMemberInfo().get(d).getMemberEmail();
										recipientList.add(memberEmail);
									}
								}
							}
						}
					}

					String[] recipients = new String[recipientList.size()];
					for (int j = 0; j < recipientList.size(); j++) {
						recipients[j] = recipientList.get(j);
					}

					htmlMapElementsForEmailBody = htmlMapElementsForAttachments;
					RecipientsVsElementDataMap oRecipientsVsElementDataMap = new RecipientsVsElementDataMap(recipients,
							htmlMapElementsForEmailBody, htmlMapElementsForAttachments);

					oRecipientsVsElementDataMapList.add(oRecipientsVsElementDataMap);
					succErr = "Success";
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return oMapi;
	}

	/**
	 * 
	 * @param oReqObj
	 * @param oFileSystemResourceList
	 * @return
	 */
	public String sendMailWithAttachment(Inputclaim oInput, List<RecipientsAttachments> oRecipientsAttachmentsList, Map<String, String> oMapi) {
		LOG.info("Sending mail..");
		String str = "Sending mail..";

		for (RecipientsAttachments oRecipientsAttachments : oRecipientsAttachmentsList) {

			try {

				final MimeMessage message = emailSender.createMimeMessage();
				final MimeMessageHelper helper = new MimeMessageHelper(message,
						MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

				String[] stringToArray = oRecipientsAttachments.getRecipients();
				if (stringToArray == null || stringToArray.length == 0) {
					stringToArray = toRecipient.split(",");
				}

				String[] stringCcArray = null;
				if (stringCcArray == null || stringCcArray.length == 0) {
					stringCcArray = ccRecipient.split(",");
				}

				helper.setCc(stringCcArray);

				if (stringToArray.length == 0) {
					helper.setTo(stringCcArray);
				} else {
					boolean isValid = EmailUtil.isEmailAddressValid(stringToArray.toString());
					if (isValid)
						helper.setTo(stringToArray);
					else
						helper.setTo(stringCcArray);
				}

				helper.setFrom(fromRecipient);

				helper.setText(HTML2TextOutput.html2text(oRecipientsAttachments.getEmailBody().toString()));
				helper.setSubject(
						"Claim " + oInput.getClaimsInfo().getUcrNumber() + "/" + oInput.getClaimsInfo().getUcrName()
								+ " is registered for your review, please read carefully.");
				helper.addAttachment(oMapi.get("umr")+"_"+oMapi.get("ucr")+"_"+".pdf", oRecipientsAttachments.getAttachments());
				emailSender.send(message);
				LOG.info("Mail sent successfully....");
				str = "Mail sent successfully....";

			} catch (MailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return str;
	}
}
