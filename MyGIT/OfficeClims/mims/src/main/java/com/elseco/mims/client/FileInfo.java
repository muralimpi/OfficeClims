package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
public class FileInfo {
	private String title;
	private String displayId;
	private Integer classValue;

	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("DisplayID")
	public String getDisplayId() {
		return displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}

	@JsonProperty("Class")
	public Integer getClassValue() {
		return classValue;
	}

	public void setClassValue(Integer classValue) {
		this.classValue = classValue;
	}

}
