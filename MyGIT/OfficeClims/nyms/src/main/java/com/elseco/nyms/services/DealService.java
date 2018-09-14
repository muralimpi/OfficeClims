package com.elseco.nyms.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.elseco.nyms.exception.ReportGenerationException;
import com.elseco.nyms.model.notify.RecipientsPolicyMap;
import com.elseco.nyms.model.policies.InputPolicies;
import com.elseco.nyms.utils.JsonUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * @author sonjoy
 *
 */
@Component
@PropertySource({ "application.yml", "file:${nymsConfigFileLocation}/${nymsConfigFileName}.yml" })
public class DealService {
	private static final Logger LOG = LoggerFactory.getLogger(DealService.class);

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
			templateMap.put("policyEmailAttachmentTemplate",
					freemarkerConfig.getTemplate("policy_email_attachment.ftl"));
			templateMap.put("policyEmailBodyTemplate",
					freemarkerConfig.getTemplate("policy_email_body.ftl"));
		} catch (final IOException e) {
			LOG.error("Error while creating template due to....{}", e);
			throw new ReportGenerationException("Unable to load all the templates");
		}
	}

	/**
	 * 
	 * @param requestData
	 * @return
	 */
	public File generatePolicyDoc(final Map<String, Object> requestData) throws Exception {
		LOG.info("generateDocNUploadNSendMail : Start");
		
		//Map<String, Object> oMap = new HashMap<String, Object>();
		
		String responseMessage = "generating Attachment and Sending Mail ..";
		InputPolicies oInput = null;
		
		// creating the request object from inbound json message
		oInput = JsonUtils.convertMapToInputPolicyReqObj(requestData);
		//byte[] oByteArray = generatePolicyDocPdf(oInput);
		File oFile = generatePolicyDocPdf(oInput);

		LOG.info("generateDocNUploadNSendMail : End");

		return oFile;

	}

	/**
	 * 
	 * @param mail
	 */
	public File generatePolicyDocPdf(InputPolicies oInput)  throws Exception {
		LOG.info("generatePolicyDocPdf : Start");

		// Mail mail = null;
		String responseMessage = "generating Attachment..";
		Template reportTemplateForAttachment = null;
		Template reportTemplateForEmailBody = null;
		FileSystemResource fileSystemResource = null;
		InputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		Writer fileWriter = null;

			String templateNameForAttachment = "policyEmailAttachmentTemplate";

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

			// creating map list of all those incoming
			List<RecipientsPolicyMap> oRecipientsPolicyMapList = new ArrayList<RecipientsPolicyMap>();
			List<Map<String, String>> oMap = new ArrayList<Map<String, String>>();

			try {
				if (templateNameForAttachment != null) {
					String succErr = mappingElementsForPolicies(oInput, oRecipientsPolicyMapList,
							templateNameForAttachment, null);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			File oFile = null;
			String fName = templateNameForAttachment + System.currentTimeMillis();
			
			
			Document document = new Document();
	        PdfCopy copy = new PdfCopy(document, new FileOutputStream(nymsAttachmentLocation + fName + "result.pdf"));
	        document.open();
	        PdfReader reader;
			
			for (RecipientsPolicyMap oRecipientsPolicyMap : oRecipientsPolicyMapList) {
				String html = FreeMarkerTemplateUtils.processTemplateIntoString(reportTemplateForAttachment,
						oRecipientsPolicyMap.getHtmlMapElementsForAttachments());
				
				 reader = new PdfReader(parseHtml(html, fName));
		            copy.addDocument(reader);
		            reader.close();
				
				
				//CreateHeaderBodyFooterContent.drawContent(html, fName);
			}
			
			 document.close();
			 
				//oFile = new File(nymsAttachmentLocation + fName + "result.pdf");
			 //oFile = new File(nymsAttachmentLocation + fName +"result.pdf");
			
			 File file = new File(nymsAttachmentLocation + fName + "result.pdf");
			 //NymsRestClient oNymsRestClient=new NymsRestClient();
			 //oNymsRestClient.uploadMfile("http://192.168.14.35:8081/mims/upload",file);
				//byte[] bFile = new byte[(int) ofile.length()];

				LOG.info("generateDocNUploadNSendMail : End");
		
		return file;
	}

	public byte[] parseHtml(String is, String fName) throws DocumentException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // step 1
        Document document = new Document(PageSize.LETTER.rotate());
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, baos);
       

       // Rotate rotation = new Rotate();
        //rotation.setRotation(PdfPage.LANDSCAPE);
        //writer.setPageEvent(rotation);
        // step 3
        document.open();
        
              
       // document.add(new Paragraph("PageSize.A4.rotate()"));
        //document.setPageSize(PageSize.A4);
        
       // step 4
        document.newPage();
        
        
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(is.getBytes("UTF-8")));
        //rotation.setRotation(PdfPage.LANDSCAPE);
        //writer.setPageEvent(rotation);
        // step 5
        document.close();
        // return the bytes of the PDF
        return baos.toByteArray();
    }
	
	
	/**
	 * 
	 * @param oReqObj
	 * @param oMap
	 * @return
	 */
	public String mappingElementsForPolicies(InputPolicies oInput,
			List<RecipientsPolicyMap> oRecipientsPolicyMapList, String templateNameForAttachment, String templateNameForEmailBody) {
		String succErr = "Error";
		if (oInput.getPOLICIES() != null) { 
			int policiesSize = oInput.getPOLICIES().size();
			for(int i=0; i<policiesSize;i++) {
				Map<String, String> subjectElements = new HashMap<String, String>(); 
				Map<String, Object> htmlMapElementsForAttachments = new HashMap<String, Object>();
				Map<String, String> htmlMapElementsForEmailBody= new HashMap<String, String>();

				htmlMapElementsForAttachments.put("RISK", oInput.getPOLICIES().get(i).getRISK());
				htmlMapElementsForAttachments.put("ORIGINALASSRED", oInput.getPOLICIES().get(i).getORIGINALASSRED());
				htmlMapElementsForAttachments.put("UMR", oInput.getPOLICIES().get(i).getUMR());
				htmlMapElementsForAttachments.put("ELSECOREFERENCE", oInput.getPOLICIES().get(i).getELSECOREFERENCE());
				htmlMapElementsForAttachments.put("MEMBERS", oInput.getPOLICIES().get(i).getMEMBERS());

				RecipientsPolicyMap oRecipientsPolicyMap = new RecipientsPolicyMap(null, null, htmlMapElementsForAttachments, null);
				oRecipientsPolicyMapList.add(oRecipientsPolicyMap);
			}
		}
		return succErr;
	}
	
}


/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
class HeaderFooterPageEvent extends PdfPageEventHelper {
	
	/**
	 * 
	 */
    public void onStartPage(PdfWriter writer,Document document) {
    	Rectangle rect = writer.getBoxSize("art");
        //ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Top Left"), rect.getLeft(), rect.getTop(), 0);
        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("elseco Aviation Policy Signature Page"), rect.getLeft(), rect.getTop(), 0);
        //ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Top Right"), rect.getRight(), rect.getTop(), 0);
    }
    
    /**
     * 
     */
    public void onEndPage(PdfWriter writer,Document document) {
    	Rectangle rect = writer.getBoxSize("art");
        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("elseco limited a Company Limited by Shares under the Companies Law, DIFC Law No.3 of 2006."), rect.getLeft(), rect.getBottom(), 0);
        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Address: Gate Village 8, Dubai International Financial Centre, PO Box: 506639, Dubai, UAE."), rect.getLeft(), rect.getBottom(), 0);
//        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Bottom Right"), rect.getRight(), rect.getBottom(), 0);
    }
    
} 

/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
@Component
@PropertySource({ "application.yml", "file:${nymsConfigFileLocation}/${nymsConfigFileName}.yml" })
class CreateHeaderBodyFooterContent {
	
	@Value("${nymsAttachmentLocation}")
	public static String nymsAttachmentLocation;
	
    public static void drawContent(String is, String fName) throws DocumentException, MalformedURLException, IOException {
	Document document = new Document();
	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nymsAttachmentLocation + fName + "result.pdf"));
//        Rectangle rect = new Rectangle(30, 30, 550, 800);
//        writer.setBoxSize("art", rect);
 /*       HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);*/
        document.open();
        //document.newPage();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(is.getBytes("UTF-8")));
        document.close();
    }
} 

