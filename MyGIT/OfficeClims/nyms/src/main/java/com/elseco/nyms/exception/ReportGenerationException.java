package com.elseco.nyms.exception;

/**
 * 
 * @author vadivel
 *
 */
@SuppressWarnings("serial")
public class ReportGenerationException extends RuntimeException {

    public ReportGenerationException(String message) {
        super(message);
    }

    public ReportGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
