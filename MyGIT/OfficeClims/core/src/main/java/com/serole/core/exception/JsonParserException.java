package com.serole.core.exception;

/**
 * 
 * @author vadivel
 *
 */
@SuppressWarnings("serial")
public class JsonParserException extends RuntimeException {

	public JsonParserException(String message) {
		super(message);
	}

	public JsonParserException(Throwable cause) {
		super(cause);
	}

}
