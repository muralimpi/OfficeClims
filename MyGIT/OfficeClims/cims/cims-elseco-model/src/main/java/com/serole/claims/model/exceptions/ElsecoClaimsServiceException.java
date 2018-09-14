package com.serole.claims.model.exceptions;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * A class with customized exceptions related to Service Layer
 * @author Serole_Vijay
 *
 */
@Component
public class ElsecoClaimsServiceException extends Exception {
	
	/**
	 * Expand with more customized exceptions as per the 
	 * 			exception handling usage in Service Layer
	 */
	private static final long serialVersionUID = 1L;
	private String message = null;
	 
    public ElsecoClaimsServiceException() {
        super();
    }
 
    public ElsecoClaimsServiceException(String message) {
        super(message);
        this.message = message;
    }
 
    public ElsecoClaimsServiceException(Throwable cause) {
        super(cause);
    }    
   

	public ElsecoClaimsServiceException(String message, Throwable cause) {
		super(message, cause);		
		this.message = message;
	}
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}
