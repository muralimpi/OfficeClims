package com.elseco.nyms.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author vadivel
 *
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class NymsResponse {
	private String message;
	private Object data;
	private Boolean status = true;

	public NymsResponse(String message, Object data, Boolean status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public NymsResponse() {
		super();
	}

	public NymsResponse(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	public NymsResponse(Object data) {
		super();
		this.data = data;
	}

	public NymsResponse(String message) {
		super();
		this.message = message;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
