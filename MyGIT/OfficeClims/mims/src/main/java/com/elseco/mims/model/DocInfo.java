package com.elseco.mims.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocInfo {
	private Integer objectType;
	private Integer objectId;
	private Integer objectVersion;
	private Integer fileId;
	private String fileName;
	private String fileExtention;
	private String escapedName;

	public Integer getObjectType() {
		return objectType;
	}

	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public Integer getObjectVersion() {
		return objectVersion;
	}

	public void setObjectVersion(Integer objectVersion) {
		this.objectVersion = objectVersion;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExtention() {
		return fileExtention;
	}

	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}

	public String getEscapedName() {
		return escapedName;
	}

	public void setEscapedName(String escapedName) {
		this.escapedName = escapedName;
	}

}
