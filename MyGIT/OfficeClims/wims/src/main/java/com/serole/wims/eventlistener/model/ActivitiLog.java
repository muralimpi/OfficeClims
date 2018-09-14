package com.serole.wims.eventlistener.model;

/**
 * 
 * @author SONJOY CHAKRABORTY
 *
 */
public class ActivitiLog implements Cloneable {

	private String activityUniqueId; //delete
	private String entityUniqueId;   //delete
	private String productUniqueId;  //delete 
	private String moduleUniqueId;   //delete
	private String perishObjId;      //delete
	
	
	private String activityUniqueName;  
	
	private String productUniqueName; 	// hard coded to - elseco
	private String moduleUniqueName; 	// hard coded to - claims
	
	private String perishObjName;  	//delete
	
	private String manualProcess;
	private String activityPriority;
	
	private String perishObjVersion; 	//delete
	private String autoGenTaskCode;	//delete
	
	private String activityType;
	private String activityDetails;
	
	private String existingStatus; // pass the status code from claim service to wims
	private String expectedNewStatus; // pass the status code from claim service to wims
	private String existingUserGroupAssigned;
	private String expectedNewUserGroupToBeAssigned;
	private String sourceSystemIpAddress;
	private String isNotificationRequired;
	private String isNotificationSent;
	private String notificationRecipientEmails;
	private String createdBy;
	private String createdDate;
	private String lastModifiedBy;
	private String lastModifiedDate;

	/*
	
	private String activityuniqueid;
	private String productuniqueid;
	private String moduleuniqueid;
	private String activityuniquename;
	private String produniquename;
	private String moduleuniquename;
	private String activitytype;
	private String activitydetails;
	private String previousstatus;
	private String currentstatus;
	private String previoususergrpassigned;
	private String currentusergrpassigned;
	private String systemipaddress;
	private String notificationreqd;
	private String notificationsent;
	private String notificationrecipients;
	private String createdby;
	private String createddate;
	private String lastmodifiedby;
	private String lastmodifieddate;

*/

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * 
	 */
	public ActivitiLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the activityUniqueId
	 */
	public String getActivityUniqueId() {
		return activityUniqueId;
	}

	/**
	 * @param activityUniqueId the activityUniqueId to set
	 */
	public void setActivityUniqueId(String activityUniqueId) {
		this.activityUniqueId = activityUniqueId;
	}

	/**
	 * @return the entityUniqueId
	 */
	public String getEntityUniqueId() {
		return entityUniqueId;
	}

	/**
	 * @param entityUniqueId the entityUniqueId to set
	 */
	public void setEntityUniqueId(String entityUniqueId) {
		this.entityUniqueId = entityUniqueId;
	}

	/**
	 * @return the productUniqueId
	 */
	public String getProductUniqueId() {
		return productUniqueId;
	}

	/**
	 * @param productUniqueId the productUniqueId to set
	 */
	public void setProductUniqueId(String productUniqueId) {
		this.productUniqueId = productUniqueId;
	}

	/**
	 * @return the moduleUniqueId
	 */
	public String getModuleUniqueId() {
		return moduleUniqueId;
	}

	/**
	 * @param moduleUniqueId the moduleUniqueId to set
	 */
	public void setModuleUniqueId(String moduleUniqueId) {
		this.moduleUniqueId = moduleUniqueId;
	}

	/**
	 * @return the perishObjId
	 */
	public String getPerishObjId() {
		return perishObjId;
	}

	/**
	 * @param perishObjId the perishObjId to set
	 */
	public void setPerishObjId(String perishObjId) {
		this.perishObjId = perishObjId;
	}

	/**
	 * @return the activityUniqueName
	 */
	public String getActivityUniqueName() {
		return activityUniqueName;
	}

	/**
	 * @param activityUniqueName the activityUniqueName to set
	 */
	public void setActivityUniqueName(String activityUniqueName) {
		this.activityUniqueName = activityUniqueName;
	}

	/**
	 * @return the productUniqueName
	 */
	public String getProductUniqueName() {
		return productUniqueName;
	}

	/**
	 * @param productUniqueName the productUniqueName to set
	 */
	public void setProductUniqueName(String productUniqueName) {
		this.productUniqueName = productUniqueName;
	}

	/**
	 * @return the moduleUniqueName
	 */
	public String getModuleUniqueName() {
		return moduleUniqueName;
	}

	/**
	 * @param moduleUniqueName the moduleUniqueName to set
	 */
	public void setModuleUniqueName(String moduleUniqueName) {
		this.moduleUniqueName = moduleUniqueName;
	}

	/**
	 * @return the perishObjName
	 */
	public String getPerishObjName() {
		return perishObjName;
	}

	/**
	 * @param perishObjName the perishObjName to set
	 */
	public void setPerishObjName(String perishObjName) {
		this.perishObjName = perishObjName;
	}

	/**
	 * @return the manualProcess
	 */
	public String getManualProcess() {
		return manualProcess;
	}

	/**
	 * @param manualProcess the manualProcess to set
	 */
	public void setManualProcess(String manualProcess) {
		this.manualProcess = manualProcess;
	}

	/**
	 * @return the activityPriority
	 */
	public String getActivityPriority() {
		return activityPriority;
	}

	/**
	 * @param activityPriority the activityPriority to set
	 */
	public void setActivityPriority(String activityPriority) {
		this.activityPriority = activityPriority;
	}

	/**
	 * @return the perishObjVersion
	 */
	public String getPerishObjVersion() {
		return perishObjVersion;
	}

	/**
	 * @param perishObjVersion the perishObjVersion to set
	 */
	public void setPerishObjVersion(String perishObjVersion) {
		this.perishObjVersion = perishObjVersion;
	}

	/**
	 * @return the autoGenTaskCode
	 */
	public String getAutoGenTaskCode() {
		return autoGenTaskCode;
	}

	/**
	 * @param autoGenTaskCode the autoGenTaskCode to set
	 */
	public void setAutoGenTaskCode(String autoGenTaskCode) {
		this.autoGenTaskCode = autoGenTaskCode;
	}

	/**
	 * @return the activityType
	 */
	public String getActivityType() {
		return activityType;
	}

	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	/**
	 * @return the activityDetails
	 */
	public String getActivityDetails() {
		return activityDetails;
	}

	/**
	 * @param activityDetails the activityDetails to set
	 */
	public void setActivityDetails(String activityDetails) {
		this.activityDetails = activityDetails;
	}

	/**
	 * @return the existingStatus
	 */
	public String getExistingStatus() {
		return existingStatus;
	}

	/**
	 * @param existingStatus the existingStatus to set
	 */
	public void setExistingStatus(String existingStatus) {
		this.existingStatus = existingStatus;
	}

	/**
	 * @return the expectedNewStatus
	 */
	public String getExpectedNewStatus() {
		return expectedNewStatus;
	}

	/**
	 * @param expectedNewStatus the expectedNewStatus to set
	 */
	public void setExpectedNewStatus(String expectedNewStatus) {
		this.expectedNewStatus = expectedNewStatus;
	}

	/**
	 * @return the existingUserGroupAssigned
	 */
	public String getExistingUserGroupAssigned() {
		return existingUserGroupAssigned;
	}

	/**
	 * @param existingUserGroupAssigned the existingUserGroupAssigned to set
	 */
	public void setExistingUserGroupAssigned(String existingUserGroupAssigned) {
		this.existingUserGroupAssigned = existingUserGroupAssigned;
	}

	/**
	 * @return the expectedNewUserGroupToBeAssigned
	 */
	public String getExpectedNewUserGroupToBeAssigned() {
		return expectedNewUserGroupToBeAssigned;
	}

	/**
	 * @param expectedNewUserGroupToBeAssigned the expectedNewUserGroupToBeAssigned to set
	 */
	public void setExpectedNewUserGroupToBeAssigned(String expectedNewUserGroupToBeAssigned) {
		this.expectedNewUserGroupToBeAssigned = expectedNewUserGroupToBeAssigned;
	}

	/**
	 * @return the sourceSystemIpAddress
	 */
	public String getSourceSystemIpAddress() {
		return sourceSystemIpAddress;
	}

	/**
	 * @param sourceSystemIpAddress the sourceSystemIpAddress to set
	 */
	public void setSourceSystemIpAddress(String sourceSystemIpAddress) {
		this.sourceSystemIpAddress = sourceSystemIpAddress;
	}

	/**
	 * @return the isNotificationRequired
	 */
	public String getIsNotificationRequired() {
		return isNotificationRequired;
	}

	/**
	 * @param isNotificationRequired the isNotificationRequired to set
	 */
	public void setIsNotificationRequired(String isNotificationRequired) {
		this.isNotificationRequired = isNotificationRequired;
	}

	/**
	 * @return the isNotificationSent
	 */
	public String getIsNotificationSent() {
		return isNotificationSent;
	}

	/**
	 * @param isNotificationSent the isNotificationSent to set
	 */
	public void setIsNotificationSent(String isNotificationSent) {
		this.isNotificationSent = isNotificationSent;
	}

	/**
	 * @return the notificationRecipientEmails
	 */
	public String getNotificationRecipientEmails() {
		return notificationRecipientEmails;
	}

	/**
	 * @param notificationRecipientEmails the notificationRecipientEmails to set
	 */
	public void setNotificationRecipientEmails(String notificationRecipientEmails) {
		this.notificationRecipientEmails = notificationRecipientEmails;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @param activityUniqueId
	 * @param entityUniqueId
	 * @param productUniqueId
	 * @param moduleUniqueId
	 * @param perishObjId
	 * @param activityUniqueName
	 * @param productUniqueName
	 * @param moduleUniqueName
	 * @param perishObjName
	 * @param manualProcess
	 * @param activityPriority
	 * @param perishObjVersion
	 * @param autoGenTaskCode
	 * @param activityType
	 * @param activityDetails
	 * @param existingStatus
	 * @param expectedNewStatus
	 * @param existingUserGroupAssigned
	 * @param expectedNewUserGroupToBeAssigned
	 * @param sourceSystemIpAddress
	 * @param isNotificationRequired
	 * @param isNotificationSent
	 * @param notificationRecipientEmails
	 * @param createdBy
	 * @param createdDate
	 * @param lastModifiedBy
	 * @param lastModifiedDate
	 */
	public ActivitiLog(String activityUniqueId, String entityUniqueId, String productUniqueId, String moduleUniqueId,
			String perishObjId, String activityUniqueName, String productUniqueName, String moduleUniqueName,
			String perishObjName, String manualProcess, String activityPriority, String perishObjVersion,
			String autoGenTaskCode, String activityType, String activityDetails, String existingStatus,
			String expectedNewStatus, String existingUserGroupAssigned, String expectedNewUserGroupToBeAssigned,
			String sourceSystemIpAddress, String isNotificationRequired, String isNotificationSent,
			String notificationRecipientEmails, String createdBy, String createdDate, String lastModifiedBy,
			String lastModifiedDate) {
		super();
		this.activityUniqueId = activityUniqueId;
		this.entityUniqueId = entityUniqueId;
		this.productUniqueId = productUniqueId;
		this.moduleUniqueId = moduleUniqueId;
		this.perishObjId = perishObjId;
		this.activityUniqueName = activityUniqueName;
		this.productUniqueName = productUniqueName;
		this.moduleUniqueName = moduleUniqueName;
		this.perishObjName = perishObjName;
		this.manualProcess = manualProcess;
		this.activityPriority = activityPriority;
		this.perishObjVersion = perishObjVersion;
		this.autoGenTaskCode = autoGenTaskCode;
		this.activityType = activityType;
		this.activityDetails = activityDetails;
		this.existingStatus = existingStatus;
		this.expectedNewStatus = expectedNewStatus;
		this.existingUserGroupAssigned = existingUserGroupAssigned;
		this.expectedNewUserGroupToBeAssigned = expectedNewUserGroupToBeAssigned;
		this.sourceSystemIpAddress = sourceSystemIpAddress;
		this.isNotificationRequired = isNotificationRequired;
		this.isNotificationSent = isNotificationSent;
		this.notificationRecipientEmails = notificationRecipientEmails;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActivitiLog [activityUniqueId=" + activityUniqueId + ", entityUniqueId=" + entityUniqueId
				+ ", productUniqueId=" + productUniqueId + ", moduleUniqueId=" + moduleUniqueId + ", perishObjId="
				+ perishObjId + ", activityUniqueName=" + activityUniqueName + ", productUniqueName="
				+ productUniqueName + ", moduleUniqueName=" + moduleUniqueName + ", perishObjName=" + perishObjName
				+ ", manualProcess=" + manualProcess + ", activityPriority=" + activityPriority + ", perishObjVersion="
				+ perishObjVersion + ", autoGenTaskCode=" + autoGenTaskCode + ", activityType=" + activityType
				+ ", activityDetails=" + activityDetails + ", existingStatus=" + existingStatus + ", expectedNewStatus="
				+ expectedNewStatus + ", existingUserGroupAssigned=" + existingUserGroupAssigned
				+ ", expectedNewUserGroupToBeAssigned=" + expectedNewUserGroupToBeAssigned + ", sourceSystemIpAddress="
				+ sourceSystemIpAddress + ", isNotificationRequired=" + isNotificationRequired + ", isNotificationSent="
				+ isNotificationSent + ", notificationRecipientEmails=" + notificationRecipientEmails + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}


}
