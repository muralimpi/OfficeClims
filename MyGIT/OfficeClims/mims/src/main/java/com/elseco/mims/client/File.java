package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class File {
	private String extension;

	private Integer uploadID;

	private String title;

	private Long size;

	@JsonProperty("Extension")
	public String getExtension() {
		return extension;
	}

	public void setExtension(String Extension) {
		this.extension = Extension;
	}

	@JsonProperty("UploadID")
	public Integer getUploadID() {
		return uploadID;
	}

	public void setUploadID(Integer UploadID) {
		this.uploadID = UploadID;
	}

	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}

	@JsonProperty("Size")
	public Long getSize() {
		return size;
	}

	public void setSize(Long Size) {
		this.size = Size;
	}

	@Override
	public String toString() {
		return "ClassPojo [Extension = " + extension + ", UploadID = " + uploadID + ", Title = " + title + ", Size = "
				+ size + "]";
	}
}
