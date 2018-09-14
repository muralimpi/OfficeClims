package com.elseco.nyms.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elseco.nyms.services.DealService;
import com.elseco.nyms.utils.MediaTypeUtils;
import com.serole.core.controllers.SeroleAbstractController;

@Controller
@RequestMapping("/file")
public class FileActionController extends SeroleAbstractController {

	private static final Logger LOG = LoggerFactory.getLogger(FileActionController.class);

	 @Autowired
	    private ServletContext servletContext;
	 
	 @Autowired
		private DealService oDealService;
	 
	public FileActionController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/download/pdf", method = RequestMethod.POST)
    public void download(HttpServletResponse response, @RequestBody Map<String, Object> requestData) throws Exception
    {
		
		LOG.info("Generate and Download document... ", requestData);


		File oFile = oDealService.generatePolicyDoc(requestData);
		byte[] bFile = new byte[(int) oFile.length()];
		ByteArrayResource resource = new ByteArrayResource(bFile);

		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, oFile.getName());

		LOG.info("File download completed...");

		  InputStream inputStream = new BufferedInputStream(new FileInputStream(oFile));
		  
	        //Copy bytes from source to destination(outputstream in this example), closes both streams.
	        FileCopyUtils.copy(inputStream, response.getOutputStream());
		
		
		
	/*	return ResponseEntity.ok()
				// Content-Disposition
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + oFile.getName())
				// Content-Type
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				// Content-Lengh
				.contentLength(bFile.length) //
				.body(resource);
*/
	}
}
