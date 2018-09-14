package com.elseco.nyms.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elseco.nyms.config.MailConfigMap;
import com.elseco.nyms.model.Mail;
import com.elseco.nyms.model.NymsResponse;
import com.elseco.nyms.services.Claims2HybrisService;
import com.elseco.nyms.services.DealService;
import com.elseco.nyms.services.EmailService;
import com.elseco.nyms.utils.MediaTypeUtils;
import com.serole.core.controllers.SeroleAbstractController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author vadivel
 *
 */
@RestController
@RequestMapping(value = "/mail")
@Api(value = "Approval Process Service", description = "Mail Service API", tags = { "Mail Service" })
public class NotificationController extends SeroleAbstractController {
	private static final Logger LOG = LoggerFactory.getLogger(NotificationController.class);

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private EmailService service;

	@Autowired
	private Claims2HybrisService oClaims2HybrisService;

	@Autowired
	private DealService oDealService;

	@Autowired
	private MailConfigMap mailConfigMap;

	private static final String XML = "xml";
	private static final String JSON = "json";

	/**
	 * 
	 * @return
	 */
	@ApiOperation(produces = MediaType.ALL_VALUE, response = NymsResponse.class, responseContainer = "NymsResponse", value = "Sending test mail")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public NymsResponse sendMail() {
		LOG.info("Started to send mail....");
		final Map<String, String> mailData = mailConfigMap.getMailConfigMap();
		service.sendSimpleMessage(mailData);
		LOG.info("Mail send successfully....");
		return new NymsResponse(String.format("Mail send successfully to %s", mailData.get("to")));
	}

	/**
	 * 
	 * @param mail
	 * @return
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = NymsResponse.class, responseContainer = "NymsResponse", value = "Send Mail")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@RequestMapping(value = "/send", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public NymsResponse sendMail(
			@ApiParam(value = "The Information storing", required = true) @RequestBody final Mail mail) {

		LOG.info(String.format("%s /mail/send %s", RequestMethod.POST, mail));

		final Map<String, String> mailData = mailConfigMap.getMailConfigMap();
		service.sendSimpleMessage(mailData, mail);

		LOG.info("Mail send successfully....");
		final NymsResponse response = new NymsResponse("Mail send successfully");
		response.setData(mail);

		return response;
	}

	/**
	 * 
	 * @param mail
	 * @return
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "NymsResponse", value = "Generate, upload and send mail report")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public NymsResponse generateAndUploadReport(
			@ApiParam(value = "Information to send mail", required = true) @RequestBody Mail mail) {
		LOG.info("Generate and Upload document... POST /mail/report");
		LOG.info("Report: {}", mail.getReports());
		service.sendReportMessage(mail);
		return new NymsResponse("Repor generated and sent mail", mail);
	}

	/**
	 * 
	 * @param requestData
	 * @param reportFile
	 * @return
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "NymsResponse", value = "Generate, upload and send mail report")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/reportForm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public NymsResponse generateAndUploadReport(@RequestParam Map<String, Object> requestData,
			@RequestParam("reportFile") MultipartFile reportFile) {
		LOG.info("Generate and Upload document... POST /mail/reportForm  requestData: {}", requestData);

		return service.process(requestData, reportFile);
	}

	/**
	 * 
	 * @param requestData
	 * @param reportFile
	 * @return
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "NymsResponse", value = "Generate, upload and send mail report")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/create/claim/notify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public NymsResponse generateDocNUploadNSendMail(@RequestBody Map<String, Object> requestData) {
		LOG.info("Generate and Upload document... POST /mail/genattachment requestData: {}", requestData);

		return service.generateNUploadNSendMail(requestData);
	}

	/**
	 * 
	 * @param requestData
	 * @param reportFile
	 * @return
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "NymsResponse", value = "Generate, upload and send mail report")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/collect/fund/notify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public NymsResponse collectFundNNotify(@RequestBody Map<String, Object> requestData) {
		LOG.info("Generate and Upload document... POST /mail/genattachment requestData: {}", requestData);

		return oClaims2HybrisService.collectFundNNotify(requestData);
	}

	/**
	 * 
	 * @param requestData
	 * @param reportFile
	 * @return
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "NymsResponse", value = "Generate, upload and send mail report")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/release/payment/notify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public NymsResponse releasePaymentNNotify(@RequestBody Map<String, Object> requestData) {
		LOG.info("Generate and Upload document... POST /mail/genattachment requestData: {}", requestData);

		return oClaims2HybrisService.releasePaymentNNotify(requestData);
	}

	/**
	 * 
	 * @param requestData
	 * @param reportFile
	 * @return
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "NymsResponse", value = "Generate, upload and send mail report")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/reportForm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public NymsResponse generateAndUploadReportGet(@RequestParam Map<String, Object> requestData,
			@RequestParam("reportFile") MultipartFile reportFile) {
		LOG.info("Generate and Upload document... GET /mail/reportForm  requestData: {}", requestData);

		return service.process(requestData, reportFile);
	}


	/**
	 * 
	 * @param requestData
	 * @param reportFile
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(produces = MediaType.APPLICATION_JSON_VALUE, response = Map.class, responseContainer = "NymsResponse", value = "Generate, upload and send mail report")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid Request"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error") })
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/page/signature/notify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamSource> PageSignGenarateNNotify(@RequestBody Map<String, Object> requestData)
			throws Exception {
		
		LOG.info("Generate and Download document... ", requestData);


		File oFile = oDealService.generatePolicyDoc(requestData);
		
		byte[] bytesArray = new byte[(int)oFile.length()]; 

		  FileInputStream fis = new FileInputStream(oFile);
		  fis.read(bytesArray); //read file into bytes[]
		  fis.close();
		  final HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition","filename=" + oFile.getName());
		final ResponseEntity<InputStreamSource> response = new ResponseEntity<>(new ByteArrayResource(bytesArray), headers,
					HttpStatus.OK);
			LOG.info("File download completed...");
			return response;
					
		  
		//byte[] bFile = new byte[(int) oFile.length()];
		//ByteArrayResource resource = new ByteArrayResource(bFile);

		//MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, oFile.getName());

		//LOG.info("File download completed...");

		//return ResponseEntity.ok()
				// Content-Disposition
		//		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + oFile.getName())
				// Content-Type
				

	}

}