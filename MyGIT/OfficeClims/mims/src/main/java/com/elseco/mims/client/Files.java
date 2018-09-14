package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Files {
	private String Name;

	private String Extension;

	private String ChangeTime;

	private String EscapedName;

	private Integer ID;

	private String LastModifiedDisplayValue;

	private String CreatedDisplayValue;

	private String LastModified;

	private Integer Version;

	private String FileGUID;

	private String CreatedUtc;

	private String ChangeTimeUtc;

	private Long Size;

	@JsonProperty("Name")
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	@JsonProperty("Extension")
	public String getExtension() {
		return Extension;
	}

	public void setExtension(String Extension) {
		this.Extension = Extension;
	}

	public String getChangeTime() {
		return ChangeTime;
	}

	@JsonProperty("ChangeTime")
	public void setChangeTime(String ChangeTime) {
		this.ChangeTime = ChangeTime;
	}

	@JsonProperty("EscapedName")
	public String getEscapedName() {
		return EscapedName;
	}

	public void setEscapedName(String EscapedName) {
		this.EscapedName = EscapedName;
	}

	@JsonProperty("ID")
	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	@JsonProperty("LastModifiedDisplayValue")
	public String getLastModifiedDisplayValue() {
		return LastModifiedDisplayValue;
	}

	public void setLastModifiedDisplayValue(String LastModifiedDisplayValue) {
		this.LastModifiedDisplayValue = LastModifiedDisplayValue;
	}

	@JsonProperty("CreatedDisplayValue")
	public String getCreatedDisplayValue() {
		return CreatedDisplayValue;
	}

	public void setCreatedDisplayValue(String CreatedDisplayValue) {
		this.CreatedDisplayValue = CreatedDisplayValue;
	}

	public String getLastModified() {
		return LastModified;
	}

	@JsonProperty("LastModified")
	public void setLastModified(String LastModified) {
		this.LastModified = LastModified;
	}

	@JsonProperty("Version")
	public Integer getVersion() {
		return Version;
	}

	public void setVersion(Integer Version) {
		this.Version = Version;
	}

	@JsonProperty("FileGUID")
	public String getFileGUID() {
		return FileGUID;
	}

	public void setFileGUID(String FileGUID) {
		this.FileGUID = FileGUID;
	}

	@JsonProperty("CreatedUtc")
	public String getCreatedUtc() {
		return CreatedUtc;
	}

	public void setCreatedUtc(String CreatedUtc) {
		this.CreatedUtc = CreatedUtc;
	}

	@JsonProperty("ChangeTimeUtc")
	public String getChangeTimeUtc() {
		return ChangeTimeUtc;
	}

	public void setChangeTimeUtc(String ChangeTimeUtc) {
		this.ChangeTimeUtc = ChangeTimeUtc;
	}

	@JsonProperty("Size")
	public Long getSize() {
		return Size;
	}

	public void setSize(Long Size) {
		this.Size = Size;
	}

	@Override
	public String toString() {
		return "ClassPojo [Name = " + Name + ", Extension = " + Extension + ", ChangeTime = " + ChangeTime
				+ ", EscapedName = " + EscapedName + ", ID = " + ID + ", LastModifiedDisplayValue = "
				+ LastModifiedDisplayValue + ", CreatedDisplayValue = " + CreatedDisplayValue + ", LastModified = "
				+ LastModified + ", Version = " + Version + ", FileGUID = " + FileGUID + ", CreatedUtc = " + CreatedUtc
				+ ", ChangeTimeUtc = " + ChangeTimeUtc + ", Size = " + Size + "]";
	}
}
