package com.serole.core.exception;

/**
 * 
 * @author vadivel
 *
 */
@SuppressWarnings("serial")
public class XmlParserException extends RuntimeException {

	public XmlParserException(String message) {
		super(message);
	}

	public XmlParserException(Throwable cause) {
		super(cause);
	}

}
