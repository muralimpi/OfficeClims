package com.serole.core.exception;

/**
 * 
 * @author vadivel
 *
 */
@SuppressWarnings("serial")
public class MFileGenericException extends RuntimeException {

	public MFileGenericException(String message) {
		super(message);
	}

	public MFileGenericException(Throwable cause) {
		super(cause);
	}

}
