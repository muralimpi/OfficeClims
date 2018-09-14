package com.serole.core.controllers;

import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.serole.core.exception.CoreFailure;
import com.serole.core.exception.DecodeUrlException;
import com.serole.core.exception.FileNotFoundException;
import com.serole.core.exception.MFileGenericException;
import com.serole.core.exception.MFileServerException;

import io.swagger.annotations.Api;

/**
 * 
 * @author vadivel
 *
 */
@Api("MIMS Abstract Controller")
@RestController
public abstract class SeroleAbstractController {
	private static final Logger LOG = LoggerFactory.getLogger(SeroleAbstractController.class);

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SocketException.class)
	public CoreFailure handleConnectionTimeoutException(final SocketException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new CoreFailure(CoreFailure.Type.INTERNAL_SERVER_ERROR,
				"Unable to connect due to network time out. Please try after some time");
	}

	/*@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(FileNotFoundException.class)
	public CoreFailure handleFileNotFound(final FileNotFoundException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new CoreFailure(CoreFailure.Type.FILE_NOT_FOUND, "File not found");
	}*/

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public CoreFailure handleGenericException(final Exception e) {
		LOG.error("Unable to process request due to...{}", e);
		return new CoreFailure(CoreFailure.Type.INTERNAL_SERVER_ERROR,
				"Unable to process your request. Please contact administrator");
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ DecodeUrlException.class, FileNotFoundException.class })
	public CoreFailure handleNoDataError(final DecodeUrlException e, final FileNotFoundException e1) {
		LOG.error("Unable to process request due to...{}", e);
		return new CoreFailure(CoreFailure.Type.NOT_FOUND, "Unable to decode the url");
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(MFileServerException.class)
	public CoreFailure handleAuthenticationError(final MFileServerException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new CoreFailure(CoreFailure.Type.UN_AUTHORIZED, "Unable to authorize");
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(HttpClientErrorException.class)
	public CoreFailure handleAuthenticationError(final HttpClientErrorException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new CoreFailure(CoreFailure.Type.FORBIDDEN, "Invalid access");
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MFileGenericException.class)
	public CoreFailure handleFileNotfoundExcepton(final MFileGenericException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new CoreFailure(CoreFailure.Type.BAD_REQUEST, e.getMessage());
	}
}