package com.serole.core.exception;

/**
 * 
 * @author vadivel
 *
 */
@SuppressWarnings("serial")
public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
