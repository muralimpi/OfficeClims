package com.elseco.mims.model;

/**
 * 
 * @author vadivel
 *
 */
public class MimsResponse {
	private Boolean status = false;
	private String message = "No data found";
	private Object data;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public MimsResponse(final Boolean status, final String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public MimsResponse(final Boolean status, final String message, final Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public MimsResponse() {
		super();
	}

}