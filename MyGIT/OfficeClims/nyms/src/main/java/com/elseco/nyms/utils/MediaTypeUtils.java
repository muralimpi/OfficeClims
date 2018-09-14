package com.elseco.nyms.utils;

import javax.servlet.ServletContext;

import org.springframework.http.MediaType;

public class MediaTypeUtils {

	public MediaTypeUtils() {
		// TODO Auto-generated constructor stub
	}

	 public static MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
	        // application/pdf
	        // application/xml
	        // image/gif, ...
	        String mineType = servletContext.getMimeType(fileName);
	        try {
	            MediaType mediaType = MediaType.parseMediaType(mineType);
	            return mediaType;
	        } catch (Exception e) {
	            return MediaType.APPLICATION_OCTET_STREAM;
	        }
	    }
	 
}
