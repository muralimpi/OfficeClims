package com.serole.claims.core.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Json based validation error model
 *
 */
@ApiModel
public class ClaimsCoreFailure {
	public enum Type {
		BAD_REQUEST, NOT_FOUND, UN_AUTHORIZED, FORBIDDEN, INTERNAL_SERVER_ERROR, UNABLE_TO_UPLOAD, UNABLE_GENERATE_REPORT, IMPROPER_DATA_FORMAT
	}

	private final Type type;
	private final String message;

	public ClaimsCoreFailure(@JsonProperty("type") final Type type, @JsonProperty("message") final String message) {
		this.type = type;
		this.message = message;
	}

	@ApiModelProperty(required = true)
	public Type getType() {
		return type;
	}

	@ApiModelProperty(required = true)
	public String getMessage() {
		return message;
	}
}