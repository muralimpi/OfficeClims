package com.serole.claims.model.filterbeans;

public class ProcessFilter {

	private String activityUniqueId; //"activityUniqueId"
	private String entityUniqueId;	 //"entityUniqueId"
	private String productUniqueId;  //"productUniqueId"
	private String moduleUniqueId;   //"moduleUniqueId"
	private String perishObjId; 	 // "perishObjId"
	private String activityUniqueName; //"activityUniqueName"
	private String productUniqueName; //"productUniqueName"
	private String moduleUniqueName; //"moduleUniqueName"
	private String activityType;        //"activityType"
	private String perishObjName; //"perishObjName"
	private String manualProcess; //"manualProcess"
	private String activityPriority; //"activityPriority"
	private String perishObjVersion; //"perishObjVersion"
	private String autoGenTaskCode; //"autoGenTaskCode"
	private String activityDetails; //"activityDetails"
	private String existingStatus; //"existingStatus"  		<----
	private String expectedNewStatus; //"expectedNewStatus"  <----
	private String existingUserGroupAssigned; //"existingUserGroupAssigned" <----ui
	private String expectedNewUserGroupToBeAssigned; //"expectedNewUserGroupToBeAssigned" <----ui
	private String sourceSystemIpAddress; //"sourceSystemIpAddress"  <---- ui
	private String isNotificationRequired; //"isNotificationRequired"<---- ui
	private String isNotificationSent; //"isNotificationSent"  <---from wims
	private String notificationRecipientEmails; //"notificationRecipientEmails" <----ui
	private String createdBy; //"createdBy" <---- ui
	private String createdDate; //"createdDate"<----systime
	private String lastModifiedBy; //"lastModifiedBy"  <---- copy above createdby 
	private String lastModifiedDate; //"lastModifiedDate"
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProcessFilter [" + (activityUniqueId != null ? "activityUniqueId=" + activityUniqueId + ", " : "")
				+ (entityUniqueId != null ? "entityUniqueId=" + entityUniqueId + ", " : "")
				+ (productUniqueId != null ? "productUniqueId=" + productUniqueId + ", " : "")
				+ (moduleUniqueId != null ? "moduleUniqueId=" + moduleUniqueId + ", " : "")
				+ (perishObjId != null ? "perishObjId=" + perishObjId + ", " : "")
				+ (activityUniqueName != null ? "activityUniqueName=" + activityUniqueName + ", " : "")
				+ (productUniqueName != null ? "productUniqueName=" + productUniqueName + ", " : "")
				+ (moduleUniqueName != null ? "moduleUniqueName=" + moduleUniqueName + ", " : "")
				+ (activityType != null ? "activityType=" + activityType + ", " : "")
				+ (perishObjName != null ? "perishObjName=" + perishObjName + ", " : "")
				+ (manualProcess != null ? "manualProcess=" + manualProcess + ", " : "")
				+ (activityPriority != null ? "activityPriority=" + activityPriority + ", " : "")
				+ (perishObjVersion != null ? "perishObjVersion=" + perishObjVersion + ", " : "")
				+ (autoGenTaskCode != null ? "autoGenTaskCode=" + autoGenTaskCode + ", " : "")
				+ (activityDetails != null ? "activityDetails=" + activityDetails + ", " : "")
				+ (existingStatus != null ? "existingStatus=" + existingStatus + ", " : "")
				+ (expectedNewStatus != null ? "expectedNewStatus=" + expectedNewStatus + ", " : "")
				+ (existingUserGroupAssigned != null ? "existingUserGroupAssigned=" + existingUserGroupAssigned + ", "
						: "")
				+ (expectedNewUserGroupToBeAssigned != null
						? "expectedNewUserGroupToBeAssigned=" + expectedNewUserGroupToBeAssigned + ", "
						: "")
				+ (sourceSystemIpAddress != null ? "sourceSystemIpAddress=" + sourceSystemIpAddress + ", " : "")
				+ (isNotificationRequired != null ? "isNotificationRequired=" + isNotificationRequired + ", " : "")
				+ (isNotificationSent != null ? "isNotificationSent=" + isNotificationSent + ", " : "")
				+ (notificationRecipientEmails != null
						? "notificationRecipientEmails=" + notificationRecipientEmails + ", "
						: "")
				+ (createdBy != null ? "createdBy=" + createdBy + ", " : "")
				+ (createdDate != null ? "createdDate=" + createdDate + ", " : "")
				+ (lastModifiedBy != null ? "lastModifiedBy=" + lastModifiedBy + ", " : "")
				+ (lastModifiedDate != null ? "lastModifiedDate=" + lastModifiedDate : "") + "]";
	}	
}
