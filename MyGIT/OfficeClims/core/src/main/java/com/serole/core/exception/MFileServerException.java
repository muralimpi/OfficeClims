package com.serole.core.exception;

/**
 * 
 * @author vadivel
 *
 */
@SuppressWarnings("serial")
public class MFileServerException extends RuntimeException {

	public MFileServerException(String message) {
		super(message);
	}

	public MFileServerException(Throwable cause) {
		super(cause);
	}

}
