package com.serole.claims.core.config;

import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.serole.claims.core.exception.ClaimsCoreFailure;
import com.serole.claims.core.exception.ClaimsMgmtServerException;
import com.serole.claims.core.exception.DecodeUrlException;
import com.serole.claims.core.exception.JsonParserException;

import io.swagger.annotations.Api;

@Api("Abstract Claims Controller")
@RestController
public abstract class AbstractClaimsController {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractClaimsController.class);

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SocketException.class)
	public ClaimsCoreFailure handleConnectionTimeoutException(final SocketException e) {
		 LOG.error("Unable to process request due to...{}", e);
		return new ClaimsCoreFailure(ClaimsCoreFailure.Type.INTERNAL_SERVER_ERROR,
				"Unable to connect due to network time out. Please try after some time");
	}	

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ClaimsCoreFailure handleGenericException(final Exception e) {
		LOG.error("Unable to process request due to...{}", e);
		return new ClaimsCoreFailure(ClaimsCoreFailure.Type.INTERNAL_SERVER_ERROR,
				"Unable to process your request. Please contact administrator");
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(DecodeUrlException.class)
	public ClaimsCoreFailure handleNoDataError(final DecodeUrlException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new ClaimsCoreFailure(ClaimsCoreFailure.Type.NOT_FOUND, "Unable to decode the url");
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(ClaimsMgmtServerException.class)
	public ClaimsCoreFailure handleAuthenticationError(final ClaimsMgmtServerException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new ClaimsCoreFailure(ClaimsCoreFailure.Type.UN_AUTHORIZED, "Unable to authorize");
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(HttpClientErrorException.class)
	public ClaimsCoreFailure handleAuthenticationError(final HttpClientErrorException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new ClaimsCoreFailure(ClaimsCoreFailure.Type.FORBIDDEN, "Invalid access");
	}
	
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(IllegalStateException.class)
	public ClaimsCoreFailure handleJsonError(final JsonParserException e) {
		LOG.error("Unable to process request due to...{}", e);
		return new ClaimsCoreFailure(ClaimsCoreFailure.Type.IMPROPER_DATA_FORMAT, "Improper Data Format as a Request Response");
	}
}