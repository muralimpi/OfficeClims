package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadResponse {
	private Integer fileInformationType;
	private Integer uploadID;
	private Long size;

	@JsonProperty("FileInformationType")
	public Integer getFileInformationType() {
		return fileInformationType;
	}

	public void setFileInformationType(Integer fileInformationType) {
		this.fileInformationType = fileInformationType;
	}

	@JsonProperty("UploadID")
	public Integer getUploadID() {
		return uploadID;
	}

	public void setUploadID(Integer uploadID) {
		this.uploadID = uploadID;
	}

	@JsonProperty("Size")
	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "UploadResponse [fileInformationType=" + fileInformationType + ", uploadID=" + uploadID + ", size="
				+ size + "]";
	}

}
