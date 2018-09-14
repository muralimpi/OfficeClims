package com.elseco.mims.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermanentUploadResponse {

	private String title;
	private String escapedTitleWithID;
	private String displayID;
	private Integer classValue;
	private String checkedOutAtUtc;
	private String checkedOutAt;
	private String lastModifiedUtc;
	private String lastModified;
	private Boolean objectCheckedOut;
	private Boolean objectCheckedOutToThisUser;
	private Integer checkedOutTo;
	private Boolean singleFile;
	private Boolean thisVersionLatestToThisUser;
	private String createdUtc;
	private String created;

	private List<Files> files;
	private ObjVer ObjVer;

	private Boolean visibleAfterOperation;

	private String pathInIDView;
	private String lastModifiedDisplayValue;
	private String checkedOutAtDisplayValue;
	private String createdDisplayValue;
	private Integer objectVersionFlags;
	private Integer score;
	private String lastAccessedByMe;
	private String accessedByMeUtc;
	private String accessedByMe;
	private String objectGUID;

	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("EscapedTitleWithID")
	public String getEscapedTitleWithID() {
		return escapedTitleWithID;
	}

	public void setEscapedTitleWithID(String escapedTitleWithID) {
		this.escapedTitleWithID = escapedTitleWithID;
	}

	@JsonProperty("DisplayID")
	public String getDisplayID() {
		return displayID;
	}

	public void setDisplayID(String displayID) {
		this.displayID = displayID;
	}

	@JsonProperty("Class")
	public Integer getClassValue() {
		return classValue;
	}

	public void setClassValue(Integer classValue) {
		this.classValue = classValue;
	}

	@JsonProperty("CheckedOutAtUtc")
	public String getCheckedOutAtUtc() {
		return checkedOutAtUtc;
	}

	public void setCheckedOutAtUtc(String checkedOutAtUtc) {
		this.checkedOutAtUtc = checkedOutAtUtc;
	}

	@JsonProperty("CheckedOutAt")
	public String getCheckedOutAt() {
		return checkedOutAt;
	}

	public void setCheckedOutAt(String checkedOutAt) {
		this.checkedOutAt = checkedOutAt;
	}

	@JsonProperty("LastModifiedUtc")
	public String getLastModifiedUtc() {
		return lastModifiedUtc;
	}

	public void setLastModifiedUtc(String lastModifiedUtc) {
		this.lastModifiedUtc = lastModifiedUtc;
	}

	@JsonProperty("LastModified")
	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	@JsonProperty("ObjectCheckedOut")
	public Boolean getObjectCheckedOut() {
		return objectCheckedOut;
	}

	public void setObjectCheckedOut(Boolean objectCheckedOut) {
		this.objectCheckedOut = objectCheckedOut;
	}

	@JsonProperty("ObjectCheckedOutToThisUser")
	public Boolean getObjectCheckedOutToThisUser() {
		return objectCheckedOutToThisUser;
	}

	public void setObjectCheckedOutToThisUser(Boolean objectCheckedOutToThisUser) {
		this.objectCheckedOutToThisUser = objectCheckedOutToThisUser;
	}

	@JsonProperty("CheckedOutTo")
	public Integer getCheckedOutTo() {
		return checkedOutTo;
	}

	public void setCheckedOutTo(Integer checkedOutTo) {
		this.checkedOutTo = checkedOutTo;
	}

	@JsonProperty("SingleFile")
	public Boolean getSingleFile() {
		return singleFile;
	}

	public void setSingleFile(Boolean singleFile) {
		this.singleFile = singleFile;
	}

	@JsonProperty("ThisVersionLatestToThisUser")
	public Boolean getThisVersionLatestToThisUser() {
		return thisVersionLatestToThisUser;
	}

	public void setThisVersionLatestToThisUser(Boolean thisVersionLatestToThisUser) {
		this.thisVersionLatestToThisUser = thisVersionLatestToThisUser;
	}

	@JsonProperty("CreatedUtc")
	public String getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(String createdUtc) {
		this.createdUtc = createdUtc;
	}

	@JsonProperty("Created")
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	@JsonProperty("Files")
	public List<Files> getFiles() {
		return files;
	}

	public void setFiles(List<Files> files) {
		this.files = files;
	}

	@JsonProperty("ObjVer")
	public ObjVer getObjVer() {
		return ObjVer;
	}

	public void setObjVer(ObjVer objVer) {
		ObjVer = objVer;
	}

	@JsonProperty("VisibleAfterOperation")
	public Boolean getVisibleAfterOperation() {
		return visibleAfterOperation;
	}

	public void setVisibleAfterOperation(Boolean visibleAfterOperation) {
		this.visibleAfterOperation = visibleAfterOperation;
	}

	@JsonProperty("PathInIDView")
	public String getPathInIDView() {
		return pathInIDView;
	}

	public void setPathInIDView(String pathInIDView) {
		this.pathInIDView = pathInIDView;
	}

	@JsonProperty("LastModifiedDisplayValue")
	public String getLastModifiedDisplayValue() {
		return lastModifiedDisplayValue;
	}

	public void setLastModifiedDisplayValue(String lastModifiedDisplayValue) {
		this.lastModifiedDisplayValue = lastModifiedDisplayValue;
	}

	@JsonProperty("CheckedOutAtDisplayValue")
	public String getCheckedOutAtDisplayValue() {
		return checkedOutAtDisplayValue;
	}

	public void setCheckedOutAtDisplayValue(String checkedOutAtDisplayValue) {
		this.checkedOutAtDisplayValue = checkedOutAtDisplayValue;
	}

	@JsonProperty("CreatedDisplayValue")
	public String getCreatedDisplayValue() {
		return createdDisplayValue;
	}

	public void setCreatedDisplayValue(String createdDisplayValue) {
		this.createdDisplayValue = createdDisplayValue;
	}

	@JsonProperty("ObjectVersionFlags")
	public Integer getObjectVersionFlags() {
		return objectVersionFlags;
	}

	public void setObjectVersionFlags(Integer objectVersionFlags) {
		this.objectVersionFlags = objectVersionFlags;
	}

	@JsonProperty("Score")
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@JsonProperty("LastAccessedByMe")
	public String getLastAccessedByMe() {
		return lastAccessedByMe;
	}

	public void setLastAccessedByMe(String lastAccessedByMe) {
		this.lastAccessedByMe = lastAccessedByMe;
	}

	@JsonProperty("AccessedByMeUtc")
	public String getAccessedByMeUtc() {
		return accessedByMeUtc;
	}

	public void setAccessedByMeUtc(String accessedByMeUtc) {
		this.accessedByMeUtc = accessedByMeUtc;
	}

	@JsonProperty("AccessedByMe")
	public String getAccessedByMe() {
		return accessedByMe;
	}

	public void setAccessedByMe(String accessedByMe) {
		this.accessedByMe = accessedByMe;
	}

	@JsonProperty("ObjectGUID")
	public String getObjectGUID() {
		return objectGUID;
	}

	public void setObjectGUID(String objectGUID) {
		this.objectGUID = objectGUID;
	}

	@Override
	public String toString() {
		return "PermanentUploadResponse [title=" + title + ", escapedTitleWithID=" + escapedTitleWithID + ", displayID="
				+ displayID + ", classValue=" + classValue + ", checkedOutAtUtc=" + checkedOutAtUtc + ", checkedOutAt="
				+ checkedOutAt + ", lastModifiedUtc=" + lastModifiedUtc + ", lastModified=" + lastModified
				+ ", objectCheckedOut=" + objectCheckedOut + ", objectCheckedOutToThisUser="
				+ objectCheckedOutToThisUser + ", checkedOutTo=" + checkedOutTo + ", singleFile=" + singleFile
				+ ", thisVersionLatestToThisUser=" + thisVersionLatestToThisUser + ", createdUtc=" + createdUtc
				+ ", created=" + created + ", files=" + files + ", ObjVer=" + ObjVer + ", visibleAfterOperation="
				+ visibleAfterOperation + ", pathInIDView=" + pathInIDView + ", lastModifiedDisplayValue="
				+ lastModifiedDisplayValue + ", checkedOutAtDisplayValue=" + checkedOutAtDisplayValue
				+ ", createdDisplayValue=" + createdDisplayValue + ", objectVersionFlags=" + objectVersionFlags
				+ ", score=" + score + ", lastAccessedByMe=" + lastAccessedByMe + ", accessedByMeUtc=" + accessedByMeUtc
				+ ", accessedByMe=" + accessedByMe + ", objectGUID=" + objectGUID + "]";
	}
	
	

}
