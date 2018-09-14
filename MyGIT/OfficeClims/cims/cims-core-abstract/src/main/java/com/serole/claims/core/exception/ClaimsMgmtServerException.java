package com.serole.claims.core.exception;

public class ClaimsMgmtServerException extends RuntimeException {

	private static final long serialVersionUID = -2147688846562170020L;

	public ClaimsMgmtServerException(String message) {
		super(message);
	}

	public ClaimsMgmtServerException(Throwable cause) {
		super(cause);
	}

}
