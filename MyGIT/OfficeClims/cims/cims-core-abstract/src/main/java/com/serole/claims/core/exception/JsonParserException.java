package com.serole.claims.core.exception;

/**
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
