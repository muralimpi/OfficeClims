package com.elseco.nyms.services;

import java.io.BufferedReader;
import java.io.File;
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

import com.elseco.nyms.exception.ReportGenerationException;
import com.elseco.nyms.model.Member;
import com.elseco.nyms.model.NymsResponse;
import com.elseco.nyms.model.claim.hybris.InboundHybris;
import com.elseco.nyms.model.notify.RecipientsAttachments;
import com.elseco.nyms.model.notify.RecipientsMap;
import com.elseco.nyms.utils.EmailUtil;
import com.elseco.nyms.utils.HTML2TextOutput;
import com.elseco.nyms.utils.JsonUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.sun.org.apache.bcel.internal.generic.ISUB;

/**
 * 
 * @author sonjoy
 *
 */
@Component
@PropertySource({ "application.yml", "file:${nymsConfigFileLocation}/${nymsConfigFileName}.yml" })
public class Claims2HybrisService extends PdfPageEventHelper {
	private static final Logger LOG = LoggerFactory.getLogger(Claims2HybrisService.class);

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private Configuration freemarkerConfig;

	private Template sampleTemplate = null;
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
			templateMap.put("collectFundEmailAttachmentTemplate",
					freemarkerConfig.getTemplate("claim_collect_fund_notify_member_attachment.ftl"));
			templateMap.put("collectFundEmailBodyTemplate",
					freemarkerConfig.getTemplate("claim_collect_fund_notify_member_body.ftl"));
			templateMap.put("releasePaymentEmailAttachmentTemplate",
					freemarkerConfig.getTemplate("claim_release_payment_notify_member_attachment.ftl"));
			templateMap.put("releasePaymentEmailBodyTemplate",
					freemarkerConfig.getTemplate("claim_release_payment_notify_member_body.ftl"));

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

	public Claims2HybrisService() throws IOException {
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
			// ct.setSimpleColumn(new Rectangle(36, 10, 559, 52));
			ct.setSimpleColumn(new Rectangle(36, 50, 600, 32));
			for (Element e : footer) {
				ct.addElement(e);
			}
			ct.go();
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	/**
	 * 
	 * @param requestData
	 * @return
	 */
	public NymsResponse collectFundNNotify(final Map<String, Object> requestData) {
		LOG.info("generateDocNUploadNSendMail : Start");

		String responseMessage = "generating Attachment and Sending Mail ..";
		InboundHybris oInput = null;
		// creating the request object from inbound json message

		try {
			oInput = JsonUtils.convertMapToInboundHybrisReqObj(requestData);
			NymsResponse oNymsResponse = collectFundNNotifyNSendMail(oInput);
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
	public NymsResponse collectFundNNotifyNSendMail(InboundHybris oInput) {
		LOG.info("generateDocNUploadNSendMail : Start");

		// Mail mail = null;
		String responseMessage = "generating Attachment and Sending Mail ..";

		Template reportTemplateForAttachment = null;
		Template reportTemplateForEmailBody = null;

		InputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		Writer fileWriter = null;

		try {
			String templateNameForAttachment = "collectFundEmailAttachmentTemplate";
			String templateNameForEmailBody = "collectFundEmailBodyTemplate";

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
			List<RecipientsMap> oRecipientsMapList = new ArrayList<RecipientsMap>();
			List<Map<String, String>> oMap = new ArrayList<Map<String, String>>();
			Map<String, String> oMapi = new HashMap<String, String>();
			
			try {
				if (templateNameForAttachment != null) {
					oMapi = mappingElementsForCollectFund(oInput, oRecipientsMapList,
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

			for (RecipientsMap oRecipientsMap : oRecipientsMapList) {

				Map<String, RecipientsAttachments> oRA = new HashMap<String, RecipientsAttachments>();

				Map<String, String> inputForAttachments = oRecipientsMap.getHtmlMapElementsForAttachments();
				String html = FreeMarkerTemplateUtils.processTemplateIntoString(reportTemplateForAttachment,
						inputForAttachments);

				Map<String, String> inputEmailBody = oRecipientsMap.getHtmlMapElementsForEmailBody();
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
					writer.setPageEvent(new Claims2HybrisService());
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

				FileSystemResource fileSystemResource = new FileSystemResource(nymsAttachmentLocation + fName + "result.pdf");
				oFileSystemResourceList.add(fileSystemResource);
				LOG.info("HTML Attachment Created!");

				String emailSubject = "Claim raised UCR # " + oRecipientsMap.getSubjectElements().get("ucr")
						+ " under policy UMR # " + oRecipientsMap.getSubjectElements().get("umr")
						+ " with an Fund Value to be collected from you as "
						+ oRecipientsMap.getSubjectElements().get("currency") + " "
						+ oRecipientsMap.getSubjectElements().get("individualamount");

				RecipientsAttachments oRecipientsAttachments = new RecipientsAttachments(
						oRecipientsMap.getRecipients().getMemberEmail().split(" "), emailSubject, htmlEmailBody,
						fileSystemResource);

				oRecipientsAttachmentsList.add(oRecipientsAttachments);

			}


			String succErr = sendMailWithAttachment(oRecipientsAttachmentsList, oMapi);

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
	public Map<String, String> mappingElementsForCollectFund(InboundHybris oInput,
			List<RecipientsMap> oRecipientsMapList, String templateNameForAttachment, String templateNameForEmailBody) {
		String succErr = "Error";

		Map<String, String> oMap = new HashMap<String, String>();

		int internalRefsSize = 0;
		int internalRefsMembersSize = 0;

		if (oInput.getIMHEADERDATA() != null) {
			if (oInput.getIMHEADERDATA().getHEADERDATAMARKET() != null) {
				if (oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT() != null) {
					if (oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT().getHEADERDATAINT() != null) {
						if (oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT().getHEADERDATAINT()
								.size() > 0) {

							internalRefsSize = oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT()
									.getHEADERDATAINT().size();

							for (int loop = 0; loop < internalRefsSize; loop++) {
								internalRefsMembersSize = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
										.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
										.size();

								for (int member = 0; member < internalRefsMembersSize; member++) {
									String memberId = oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT()
											.getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER().get(member)
											.getMEMBERID().toString();
									String memberName = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
											.get(member).getMEMBERNAME();
									String memberSplit = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
											.get(member).getMEMBERSPLIT();
									String memberEmail = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
											.get(member).getMEMBEREMAIL();
									String memberCollectionType = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
											.get(member).getCOLLTYPE();

									String extSplit = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getLINESPLITVL();
									String intSplit = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getSPLITVL();

									Member oMember = new Member(memberId, memberName, memberSplit, memberEmail,
											memberCollectionType);

									Map<String, String> subjectElements = new HashMap<String, String>();
									Map<String, String> htmlMapElementsForAttachments = new HashMap<String, String>();
									Map<String, String> htmlMapElementsForEmailBody = new HashMap<String, String>();

									htmlMapElementsForAttachments.put("currency",
											oInput.getIMHEADERDATA().getHEADERDATAMARKET().getCURRENCY() != null
													? oInput.getIMHEADERDATA().getHEADERDATAMARKET().getCURRENCY()
															.toString()
													: "");

									htmlMapElementsForAttachments.put("umr",
											oInput.getIMHEADERDATA().getUMR() != null
													? oInput.getIMHEADERDATA().getUMR().toString()
													: "");

									htmlMapElementsForAttachments.put("ucr",
											oInput.getIMHEADERDATA().getUCR() != null
													? oInput.getIMHEADERDATA().getUCR().toString()
													: "");

									if (!oMap.containsKey("umr")) {
										oMap.put("umr",
												oInput.getIMHEADERDATA().getUMR() != null
														? oInput.getIMHEADERDATA().getUMR().toString()
														: "");
									}
									
									if (!oMap.containsKey("ucr")) {
										oMap.put("ucr",
												oInput.getIMHEADERDATA().getUCR() != null
														? oInput.getIMHEADERDATA().getUCR().toString()
														: "");
									}

									if (oInput.getIMHEADERDATA().getHEADERDATAMARKET().getINCURREDAM() != null) {
										
										Float marketIncurredAmount = (Float
												.valueOf(oInput.getIMHEADERDATA().getHEADERDATAMARKET().getINCURREDAM())
												.floatValue());
										Float extSplitVal = (extSplit!=null || !extSplit.isEmpty()? (Float.valueOf(extSplit).floatValue()): (Float.valueOf(1)));
										Float extIncurredAmount = (extSplitVal!=(Float.valueOf(1))?(Float.valueOf((marketIncurredAmount*extSplitVal/100))):(Float.valueOf((marketIncurredAmount))));
										
										Float intSplitVal = (intSplit!=null || !intSplit.isEmpty()? (Float.valueOf(intSplit).floatValue()): (Float.valueOf(1)));
										Float intIncurredAmount = (intSplitVal!=(Float.valueOf(1))?(Float.valueOf((extIncurredAmount*intSplitVal/100))):(Float.valueOf((extIncurredAmount))));
										
										Float memberSplitVal = (memberSplit!=null || !memberSplit.isEmpty()? (Float.valueOf(memberSplit).floatValue()): (Float.valueOf(1)));
										Float memberIncurredAmount = (memberSplitVal!=(Float.valueOf(1))?(Float.valueOf((intIncurredAmount*memberSplitVal/100))):(Float.valueOf((intIncurredAmount))));
										
										String d = memberIncurredAmount.toString();
										htmlMapElementsForAttachments.put("individualamount", d);
									}

									htmlMapElementsForAttachments.put("totalincuredamount",
											oInput.getIMHEADERDATA().getHEADERDATAMARKET().getINCURREDAM() != null
													? oInput.getIMHEADERDATA().getHEADERDATAMARKET().getINCURREDAM()
															.toString()
													: "");

									htmlMapElementsForAttachments.put("externalref",
											oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT()
													.getEXTREF() != null
															? oInput.getIMHEADERDATA().getHEADERDATAMARKET()
																	.getHEADERDATAEXT().getEXTREF().toString()
															: "");

									htmlMapElementsForAttachments.put("internalref",
											oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT()
													.getHEADERDATAINT().get(loop).getINTREF() != null
															? oInput.getIMHEADERDATA().getHEADERDATAMARKET()
																	.getHEADERDATAEXT().getHEADERDATAINT().get(loop)
																	.getINTREF().toString()
															: "");

									htmlMapElementsForAttachments.put("member",
											memberName != null ? memberName.toString() : "");

									subjectElements = htmlMapElementsForAttachments;
									htmlMapElementsForEmailBody = htmlMapElementsForAttachments;
									RecipientsMap oRecipientsMap = new RecipientsMap(oMember,
											htmlMapElementsForEmailBody, htmlMapElementsForAttachments,
											subjectElements);
									oRecipientsMapList.add(oRecipientsMap);
									succErr = "Success";
								}
							}
						}
					}
				}
			}
		}

		return oMap;

	}

	/**
	 * 
	 * @param requestData
	 * @return
	 */
	public NymsResponse releasePaymentNNotify(final Map<String, Object> requestData) {
		LOG.info("generateDocNUploadNSendMail : Start");

		String responseMessage = "generating Attachment and Sending Mail ..";
		InboundHybris oInput = null;
		// creating the request object from inbound json message

		try {
			oInput = JsonUtils.convertMapToInboundHybrisReqObj(requestData);
			NymsResponse oNymsResponse = releasePaymentNNotifyNSendMail(oInput);
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
	public NymsResponse releasePaymentNNotifyNSendMail(InboundHybris oInput) {
		LOG.info("generateDocNUploadNSendMail : Start");

		// Mail mail = null;
		String responseMessage = "generating Attachment and Sending Mail ..";

		Template reportTemplateForAttachment = null;
		Template reportTemplateForEmailBody = null;

		InputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		Writer fileWriter = null;

		try {
			String templateNameForAttachment = "releasePaymentEmailAttachmentTemplate";
			String templateNameForEmailBody = "releasePaymentEmailBodyTemplate";

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
			List<RecipientsMap> oRecipientsMapList = new ArrayList<RecipientsMap>();
			List<Map<String, String>> oMap = new ArrayList<Map<String, String>>();
			Map<String, String> oMapi = new HashMap<String, String>();
			try {
				if (templateNameForAttachment != null) {
					oMapi = mappingElementsForReleasePayment(oInput, oRecipientsMapList,
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

			for (RecipientsMap oRecipientsMap : oRecipientsMapList) {

				Map<String, RecipientsAttachments> oRA = new HashMap<String, RecipientsAttachments>();

				Map<String, String> inputForAttachments = oRecipientsMap.getHtmlMapElementsForAttachments();
				String html = FreeMarkerTemplateUtils.processTemplateIntoString(reportTemplateForAttachment,
						inputForAttachments);

				Map<String, String> inputEmailBody = oRecipientsMap.getHtmlMapElementsForEmailBody();
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
					writer.setPageEvent(new Claims2HybrisService());
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

				FileSystemResource fileSystemResource = new FileSystemResource(nymsAttachmentLocation + fName + "result.pdf");
				oFileSystemResourceList.add(fileSystemResource);
				LOG.info("HTML Attachment Created!");

				String emailSubject = "Claim raised UCR # " + oRecipientsMap.getSubjectElements().get("ucr")
						+ " under policy UMR # " + oRecipientsMap.getSubjectElements().get("umr")
						+ " with an Fund Value to be released from you as "
						+ oRecipientsMap.getSubjectElements().get("currency") + " "
						+ oRecipientsMap.getSubjectElements().get("individualamount");

				RecipientsAttachments oRecipientsAttachments = new RecipientsAttachments(
						oRecipientsMap.getRecipients().getMemberEmail().split(" "), emailSubject, htmlEmailBody,
						fileSystemResource);

				oRecipientsAttachmentsList.add(oRecipientsAttachments);

			}

			String succErr = sendMailWithAttachment(oRecipientsAttachmentsList, oMapi);

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
	public Map<String, String> mappingElementsForReleasePayment(InboundHybris oInput, List<RecipientsMap> oRecipientsMapList,
			String templateNameForAttachment, String templateNameForEmailBody) {
		String succErr = "Error";

		Map<String, String> oMap = new HashMap<String, String>(); 
		
		int internalRefsSize = 0;
		int internalRefsMembersSize = 0;

		if (oInput.getIMHEADERDATA() != null) {
			if (oInput.getIMHEADERDATA().getHEADERDATAMARKET() != null) {
				if (oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT() != null) {
					if (oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT().getHEADERDATAINT() != null) {
						if (oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT().getHEADERDATAINT()
								.size() > 0) {

							internalRefsSize = oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT()
									.getHEADERDATAINT().size();

							for (int loop = 0; loop < internalRefsSize; loop++) {
								internalRefsMembersSize = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
										.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
										.size();

								for (int member = 0; member < internalRefsMembersSize; member++) {
									String memberId = oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT()
											.getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER().get(member)
											.getMEMBERID().toString();
									String memberName = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
											.get(member).getMEMBERNAME();
									String memberSplit = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
											.get(member).getMEMBERSPLIT();
									String memberEmail = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
											.get(member).getMEMBEREMAIL();
									String memberCollectionType = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getHEADERDATASTAMPMEMBER()
											.get(member).getCOLLTYPE();

									String extSplit = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getLINESPLITVL();
									String intSplit = oInput.getIMHEADERDATA().getHEADERDATAMARKET()
											.getHEADERDATAEXT().getHEADERDATAINT().get(loop).getSPLITVL();

									Member oMember = new Member(memberId, memberName, memberSplit, memberEmail,
											memberCollectionType);

									Map<String, String> subjectElements = new HashMap<String, String>();
									Map<String, String> htmlMapElementsForAttachments = new HashMap<String, String>();
									Map<String, String> htmlMapElementsForEmailBody = new HashMap<String, String>();

									htmlMapElementsForAttachments.put("currency",
											oInput.getIMHEADERDATA().getHEADERDATAMARKET().getCURRENCY() != null
													? oInput.getIMHEADERDATA().getHEADERDATAMARKET().getCURRENCY()
															.toString()
													: "");

									htmlMapElementsForAttachments.put("umr",
											oInput.getIMHEADERDATA().getUMR() != null
													? oInput.getIMHEADERDATA().getUMR().toString()
													: "");

									htmlMapElementsForAttachments.put("ucr",
											oInput.getIMHEADERDATA().getUCR() != null
													? oInput.getIMHEADERDATA().getUCR().toString()
													: "");

									if (!oMap.containsKey("umr")) {
										oMap.put("umr",
												oInput.getIMHEADERDATA().getUMR() != null
												? oInput.getIMHEADERDATA().getUMR().toString()
												: "");
									}
									
									if (!oMap.containsKey("ucr")) {
										oMap.put("ucr",
												oInput.getIMHEADERDATA().getUCR() != null
												? oInput.getIMHEADERDATA().getUCR().toString()
												: "");
									}

									
									
									if (oInput.getIMHEADERDATA().getHEADERDATAMARKET().getINCURREDAM() != null) {
										
										Float marketIncurredAmount = (Float
												.valueOf(oInput.getIMHEADERDATA().getHEADERDATAMARKET().getINCURREDAM())
												.floatValue());
										Float extSplitVal = (extSplit!=null || !extSplit.isEmpty()? (Float.valueOf(extSplit).floatValue()): (Float.valueOf(1)));
										Float extIncurredAmount = (extSplitVal!=(Float.valueOf(1))?(Float.valueOf((marketIncurredAmount*extSplitVal/100))):(Float.valueOf((marketIncurredAmount))));
										
										Float intSplitVal = (intSplit!=null || !intSplit.isEmpty()? (Float.valueOf(intSplit).floatValue()): (Float.valueOf(1)));
										Float intIncurredAmount = (intSplitVal!=(Float.valueOf(1))?(Float.valueOf((extIncurredAmount*intSplitVal/100))):(Float.valueOf((extIncurredAmount))));
										
										Float memberSplitVal = (memberSplit!=null || !memberSplit.isEmpty()? (Float.valueOf(memberSplit).floatValue()): (Float.valueOf(1)));
										Float memberIncurredAmount = (memberSplitVal!=(Float.valueOf(1))?(Float.valueOf((intIncurredAmount*memberSplitVal/100))):(Float.valueOf((intIncurredAmount))));
										
										String d = memberIncurredAmount.toString();
										htmlMapElementsForAttachments.put("individualamount", d);
									}

									htmlMapElementsForAttachments.put("totalincuredamount",
											oInput.getIMHEADERDATA().getHEADERDATAMARKET().getINCURREDAM() != null
													? oInput.getIMHEADERDATA().getHEADERDATAMARKET().getINCURREDAM()
															.toString()
													: "");

									htmlMapElementsForAttachments.put("externalref",
											oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT()
													.getEXTREF() != null
															? oInput.getIMHEADERDATA().getHEADERDATAMARKET()
																	.getHEADERDATAEXT().getEXTREF().toString()
															: "");

									htmlMapElementsForAttachments.put("internalref",
											oInput.getIMHEADERDATA().getHEADERDATAMARKET().getHEADERDATAEXT()
													.getHEADERDATAINT().get(loop).getINTREF() != null
															? oInput.getIMHEADERDATA().getHEADERDATAMARKET()
																	.getHEADERDATAEXT().getHEADERDATAINT().get(loop)
																	.getINTREF().toString()
															: "");

									htmlMapElementsForAttachments.put("member",
											memberName != null ? memberName.toString() : "");

									subjectElements = htmlMapElementsForAttachments;
									htmlMapElementsForEmailBody = htmlMapElementsForAttachments;
									RecipientsMap oRecipientsMap = new RecipientsMap(oMember,
											htmlMapElementsForEmailBody, htmlMapElementsForAttachments,
											subjectElements);
									oRecipientsMapList.add(oRecipientsMap);
									succErr = "Success";
								}
							}
						}
					}
				}
			}
		}

		return oMap;

	}

	/**
	 * 
	 * @param oReqObj
	 * @param oFileSystemResourceList
	 * @return
	 */
	public String sendMailWithAttachment(List<RecipientsAttachments> oRecipientsAttachmentsList, Map<String, String> oMapi) {
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
				helper.setSubject(oRecipientsAttachments.getEmailSubject());
				// helper.addAttachment(oRecipientsAttachments.getAttachments().getFilename(),
				// oRecipientsAttachments.getAttachments());
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
