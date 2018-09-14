package com.serole.core.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Json based validation error model
 *
 * @author vadivel
 */
@ApiModel
public class CoreFailure {
	public enum Type {
		BAD_REQUEST, NOT_FOUND, UN_AUTHORIZED, FORBIDDEN, INTERNAL_SERVER_ERROR, UNABLE_TO_UPLOAD, UNABLE_GENERATE_REPORT, FILE_NOT_FOUND
	}

	private final Type type;
	private final String message;

	public CoreFailure(@JsonProperty("type") final Type type, @JsonProperty("message") final String message) {
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