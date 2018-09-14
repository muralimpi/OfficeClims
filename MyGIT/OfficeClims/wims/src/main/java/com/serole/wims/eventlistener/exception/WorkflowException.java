package com.serole.wims.eventlistener.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serole.wims.eventlistener.controller.WorkflowController;

/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
@SuppressWarnings("serial")
public class WorkflowException extends RuntimeException {

	private static final Logger LOG = LoggerFactory.getLogger(WorkflowException.class);

    public WorkflowException(String message) {
        super(message);
    }

    public WorkflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
