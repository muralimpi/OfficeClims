package com.elseco.mims.model;

/**
 * 
 * @author vadivel
 *
 */
public class SearchDocResponse {
	private String fileName;
	private String downloadUrl;
	private String objectVersionId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getObjectVersionId() {
		return objectVersionId;
	}

	public void setObjectVersionId(String objectVersionId) {
		this.objectVersionId = objectVersionId;
	}

}
