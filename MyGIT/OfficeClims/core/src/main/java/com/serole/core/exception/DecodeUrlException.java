package com.serole.core.exception;

/**
 * 
 * @author vadivel
 *
 */
@SuppressWarnings("serial")
public class DecodeUrlException extends RuntimeException{

	public DecodeUrlException() {
		super();
	}

	public DecodeUrlException(String message) {
		super(message);
	}

	public DecodeUrlException(Throwable cause) {
		super(cause);
	}

}
