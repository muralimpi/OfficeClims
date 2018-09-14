package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Item {
	private String downloadUrl;

	private String CheckedOutAtDisplayValue;

	private String AccessedByMeUtc;

	private String ObjectCheckedOutToThisUser;

	private String ThisVersionLatestToThisUser;

	private String AccessedByMe;

	private String Created;

	private Files[] Files;

	private String DisplayID;

	private String CreatedDisplayValue;

	private String Score;

	private String CreatedUtc;

	private String ObjectCheckedOut;

	private String LastAccessedByMe;

	private String VisibleAfterOperation;

	private String LastModifiedUtc;

	private String SingleFile;

	private String Title;

	private String ObjectGUID;

	private ObjVer ObjVer;

	private String ObjectVersionFlags;

	private String EscapedTitleWithID;

	private String classValue;

	private String CheckedOutTo;

	private String CheckedOutAt;

	private String LastModifiedDisplayValue;

	private String PathInIDView;

	private String LastModified;

	private String CheckedOutAtUtc;

	public String getCheckedOutAtDisplayValue() {
		return CheckedOutAtDisplayValue;
	}

	public void setCheckedOutAtDisplayValue(String CheckedOutAtDisplayValue) {
		this.CheckedOutAtDisplayValue = CheckedOutAtDisplayValue;
	}

	public String getAccessedByMeUtc() {
		return AccessedByMeUtc;
	}

	public void setAccessedByMeUtc(String AccessedByMeUtc) {
		this.AccessedByMeUtc = AccessedByMeUtc;
	}

	public String getObjectCheckedOutToThisUser() {
		return ObjectCheckedOutToThisUser;
	}

	public void setObjectCheckedOutToThisUser(String ObjectCheckedOutToThisUser) {
		this.ObjectCheckedOutToThisUser = ObjectCheckedOutToThisUser;
	}

	public String getThisVersionLatestToThisUser() {
		return ThisVersionLatestToThisUser;
	}

	public void setThisVersionLatestToThisUser(String ThisVersionLatestToThisUser) {
		this.ThisVersionLatestToThisUser = ThisVersionLatestToThisUser;
	}

	public String getAccessedByMe() {
		return AccessedByMe;
	}

	public void setAccessedByMe(String AccessedByMe) {
		this.AccessedByMe = AccessedByMe;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String Created) {
		this.Created = Created;
	}

	@JsonProperty("Files")
	public Files[] getFiles() {
		return Files;
	}

	public void setFiles(Files[] Files) {
		this.Files = Files;
	}

	public String getDisplayID() {
		return DisplayID;
	}

	public void setDisplayID(String DisplayID) {
		this.DisplayID = DisplayID;
	}

	public String getCreatedDisplayValue() {
		return CreatedDisplayValue;
	}

	public void setCreatedDisplayValue(String CreatedDisplayValue) {
		this.CreatedDisplayValue = CreatedDisplayValue;
	}

	public String getScore() {
		return Score;
	}

	public void setScore(String Score) {
		this.Score = Score;
	}

	public String getCreatedUtc() {
		return CreatedUtc;
	}

	public void setCreatedUtc(String CreatedUtc) {
		this.CreatedUtc = CreatedUtc;
	}

	public String getObjectCheckedOut() {
		return ObjectCheckedOut;
	}

	public void setObjectCheckedOut(String ObjectCheckedOut) {
		this.ObjectCheckedOut = ObjectCheckedOut;
	}

	public String getLastAccessedByMe() {
		return LastAccessedByMe;
	}

	public void setLastAccessedByMe(String LastAccessedByMe) {
		this.LastAccessedByMe = LastAccessedByMe;
	}

	public String getVisibleAfterOperation() {
		return VisibleAfterOperation;
	}

	public void setVisibleAfterOperation(String VisibleAfterOperation) {
		this.VisibleAfterOperation = VisibleAfterOperation;
	}

	public String getLastModifiedUtc() {
		return LastModifiedUtc;
	}

	public void setLastModifiedUtc(String LastModifiedUtc) {
		this.LastModifiedUtc = LastModifiedUtc;
	}

	public String getSingleFile() {
		return SingleFile;
	}

	public void setSingleFile(String SingleFile) {
		this.SingleFile = SingleFile;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getObjectGUID() {
		return ObjectGUID;
	}

	public void setObjectGUID(String ObjectGUID) {
		this.ObjectGUID = ObjectGUID;
	}

	@JsonProperty("ObjVer")
	public ObjVer getObjVer() {
		return ObjVer;
	}

	public void setObjVer(ObjVer ObjVer) {
		this.ObjVer = ObjVer;
	}

	public String getObjectVersionFlags() {
		return ObjectVersionFlags;
	}

	public void setObjectVersionFlags(String ObjectVersionFlags) {
		this.ObjectVersionFlags = ObjectVersionFlags;
	}

	public String getEscapedTitleWithID() {
		return EscapedTitleWithID;
	}

	public void setEscapedTitleWithID(String EscapedTitleWithID) {
		this.EscapedTitleWithID = EscapedTitleWithID;
	}

	/*
	 * public String getClass() { return classValue; }
	 * 
	 * public void setClass(String Class) { this.classValue = Class; }
	 */

	public String getCheckedOutTo() {
		return CheckedOutTo;
	}

	@JsonProperty("Class")
	public String getClassValue() {
		return classValue;
	}

	public void setClassValue(String classValue) {
		this.classValue = classValue;
	}

	public void setCheckedOutTo(String CheckedOutTo) {
		this.CheckedOutTo = CheckedOutTo;
	}

	public String getCheckedOutAt() {
		return CheckedOutAt;
	}

	public void setCheckedOutAt(String CheckedOutAt) {
		this.CheckedOutAt = CheckedOutAt;
	}

	public String getLastModifiedDisplayValue() {
		return LastModifiedDisplayValue;
	}

	public void setLastModifiedDisplayValue(String LastModifiedDisplayValue) {
		this.LastModifiedDisplayValue = LastModifiedDisplayValue;
	}

	public String getPathInIDView() {
		return PathInIDView;
	}

	public void setPathInIDView(String PathInIDView) {
		this.PathInIDView = PathInIDView;
	}

	public String getLastModified() {
		return LastModified;
	}

	public void setLastModified(String LastModified) {
		this.LastModified = LastModified;
	}

	public String getCheckedOutAtUtc() {
		return CheckedOutAtUtc;
	}

	public void setCheckedOutAtUtc(String CheckedOutAtUtc) {
		this.CheckedOutAtUtc = CheckedOutAtUtc;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	@Override
	public String toString() {
		return "ClassPojo [CheckedOutAtDisplayValue = " + CheckedOutAtDisplayValue + ", AccessedByMeUtc = "
				+ AccessedByMeUtc + ", ObjectCheckedOutToThisUser = " + ObjectCheckedOutToThisUser
				+ ", ThisVersionLatestToThisUser = " + ThisVersionLatestToThisUser + ", AccessedByMe = " + AccessedByMe
				+ ", Created = " + Created + ", Files = " + Files + ", DisplayID = " + DisplayID
				+ ", CreatedDisplayValue = " + CreatedDisplayValue + ", Score = " + Score + ", CreatedUtc = "
				+ CreatedUtc + ", ObjectCheckedOut = " + ObjectCheckedOut + ", LastAccessedByMe = " + LastAccessedByMe
				+ ", VisibleAfterOperation = " + VisibleAfterOperation + ", LastModifiedUtc = " + LastModifiedUtc
				+ ", SingleFile = " + SingleFile + ", Title = " + Title + ", ObjectGUID = " + ObjectGUID + ", ObjVer = "
				+ ObjVer + ", ObjectVersionFlags = " + ObjectVersionFlags + ", EscapedTitleWithID = "
				+ EscapedTitleWithID + ", Class = " + classValue + ", CheckedOutTo = " + CheckedOutTo
				+ ", CheckedOutAt = " + CheckedOutAt + ", LastModifiedDisplayValue = " + LastModifiedDisplayValue
				+ ", PathInIDView = " + PathInIDView + ", LastModified = " + LastModified + ", CheckedOutAtUtc = "
				+ CheckedOutAtUtc + "]";
	}
}
