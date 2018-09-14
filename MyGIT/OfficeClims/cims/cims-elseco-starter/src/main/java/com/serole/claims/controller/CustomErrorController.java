package com.serole.claims.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.serole.claims.service.exception.ExceptionResponse;

/**
 * A Controller to avoid the WhiteLabel Error when invoking the Rest Services 
 * This controller is not included on swagger Api as its part of Configuration and Error Handling only
 * 
 * @author Serole_Vijay
 *
 */
@RestController
public class CustomErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * Handler to catch the error responses when some failure occurs
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/error")
    public Object error(HttpServletRequest request, HttpServletResponse response) {
    	ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorCode("INVALID HTTP REQUEST");
		exceptionResponse.setErrorMessage("Requested with a Invalid Http Request");
		return exceptionResponse;
    }

    @Override
	public String getErrorPath() {		
		return "/error";
	}
    
    @SuppressWarnings("unused")
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

}