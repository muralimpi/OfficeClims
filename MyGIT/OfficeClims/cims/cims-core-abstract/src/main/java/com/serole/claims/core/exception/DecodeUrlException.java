package com.serole.claims.core.exception;

public class DecodeUrlException extends RuntimeException{

	private static final long serialVersionUID = -1284075569633877927L;

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
