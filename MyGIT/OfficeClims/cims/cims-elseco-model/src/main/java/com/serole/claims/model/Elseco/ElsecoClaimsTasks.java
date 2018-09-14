package com.serole.claims.model.Elseco;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimTasks_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsTasks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_TASK_ID")
	private int claimTaskId;   				//CLAIM_TASK_ID
	
	@Column(name = "CLAIM_FILE_ID")
	private int claimFileId;   				//CLAIM_FILE_ID	
	
	@Column(name = "CLAIM_ITEM_ID")		
	private int claimItemId;   				//CLAIM_ITEM_ID	
	
	@Column(name = "CLAIM_ID")
	private int claimId; 					//CLAIM_ID	
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId;  			//CLAIM_HEADER_ID	
	
	@Column(name = "VERSION")
	private String version;  				//VERSION
	
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;  			//EFFECTIVE_DATE	
	
	@Column(name = "TASK_CD")
	private String taskCode;  				//TASK_CD
	
	@Column(name = "FLG_MANUAL")
	private String flgManual;  				//FLG_MANUAL	
	
	@Column(name = "STATUS")
	private String status;  				//STATUS
	
	@Column(name = "SUBOBJ_CATG")
	private String subObjCatgory;  			//SUBOBJ_CATG	
	
	@Column(name = "SUB_OBJECT")
	private String subObject;  				//SUB_OBJECT
	
	@Column(name = "TASK_NAME")
	private String taskName;  				//TASK_NAME	
	
	@Column(name = "TASK_DESC")
	private String taskDesc;  				//TASK_DESC

	@Column(name = "ACTIVITY_USED")
	private String activityUsed;  			//ACTIVITY_USED
	
	@Column(name = "DT_FIRST_SUBM")
	private Date dateFirstSubmitted;  		//DT_FIRST_SUBM
	
	@Column(name = "DT_LATEST_START")
	private Date dateLatestStart;  			//DT_LATEST_START
	
	@Column(name = "DT_LATEST_END")
	private Date dateLatestEnd;  			//DT_LATEST_END

	@Column(name = "DT_FIRST_SUBM_TIME")
	private Date dateFirstSubmittedTime;  	//DT_FIRST_SUBM_TIME
	
	@Column(name = "DT_LATEST_END_TIME")
	private Date dateLatestEndTime;  		//DT_LATEST_END_TIME
	
	@Column(name = "TASK_PRIORITY")
	private String taskPriority;  			//TASK_PRIORITY
	
	@Column(name = "TASK_HANDLR_CATG")
	private String taskHandlerCatgory;  	//TASK_HANDLR_CATG
	
	@Column(name = "TASK_HANDLER")
	private String taskHandler;  			//TASK_HANDLER
	
	@Column(name = "AUTH_GRP")
	private String authGroup;  				//AUTH_GRP
	
	@Column(name = "AUTH_USR")
	private String authUser;  				//AUTH_USR
	
	@Column(name = "NOTIFY_SENT")
	private String notifySent;  			//NOTIFY_SENT
	
	@Column(name = "NOTIFY_RECEIPIENTS")
	private String notifyReceipients;  		//NOTIFY_RECEIPIENTS
	
	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; //DELETE_FLAG

	/**
	 * @return the claimTaskId
	 */
	public int getClaimTaskId() {
		return claimTaskId;
	}

	/**
	 * @param claimTaskId the claimTaskId to set
	 */
	public void setClaimTaskId(int claimTaskId) {
		this.claimTaskId = claimTaskId;
	}

	/**
	 * @return the claimFileId
	 */
	public int getClaimFileId() {
		return claimFileId;
	}

	/**
	 * @param claimFileId the claimFileId to set
	 */
	public void setClaimFileId(int claimFileId) {
		this.claimFileId = claimFileId;
	}

	/**
	 * @return the claimItemId
	 */
	public int getClaimItemId() {
		return claimItemId;
	}

	/**
	 * @param claimItemId the claimItemId to set
	 */
	public void setClaimItemId(int claimItemId) {
		this.claimItemId = claimItemId;
	}

	/**
	 * @return the claimId
	 */
	public int getClaimId() {
		return claimId;
	}

	/**
	 * @param claimId the claimId to set
	 */
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	/**
	 * @return the claimHeaderId
	 */
	public int getClaimHeaderId() {
		return claimHeaderId;
	}

	/**
	 * @param claimHeaderId the claimHeaderId to set
	 */
	public void setClaimHeaderId(int claimHeaderId) {
		this.claimHeaderId = claimHeaderId;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the taskCode
	 */
	public String getTaskCode() {
		return taskCode;
	}

	/**
	 * @param taskCode the taskCode to set
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	/**
	 * @return the flgManual
	 */
	public String getFlgManual() {
		return flgManual;
	}

	/**
	 * @param flgManual the flgManual to set
	 */
	public void setFlgManual(String flgManual) {
		this.flgManual = flgManual;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the subObjCatgory
	 */
	public String getSubObjCatgory() {
		return subObjCatgory;
	}

	/**
	 * @param subObjCatgory the subObjCatgory to set
	 */
	public void setSubObjCatgory(String subObjCatgory) {
		this.subObjCatgory = subObjCatgory;
	}

	/**
	 * @return the subObject
	 */
	public String getSubObject() {
		return subObject;
	}

	/**
	 * @param subObject the subObject to set
	 */
	public void setSubObject(String subObject) {
		this.subObject = subObject;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the taskDesc
	 */
	public String getTaskDesc() {
		return taskDesc;
	}

	/**
	 * @param taskDesc the taskDesc to set
	 */
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	/**
	 * @return the activityUsed
	 */
	public String getActivityUsed() {
		return activityUsed;
	}

	/**
	 * @param activityUsed the activityUsed to set
	 */
	public void setActivityUsed(String activityUsed) {
		this.activityUsed = activityUsed;
	}

	/**
	 * @return the dateFirstSubmitted
	 */
	public Date getDateFirstSubmitted() {
		return dateFirstSubmitted;
	}

	/**
	 * @param dateFirstSubmitted the dateFirstSubmitted to set
	 */
	public void setDateFirstSubmitted(Date dateFirstSubmitted) {
		this.dateFirstSubmitted = dateFirstSubmitted;
	}

	/**
	 * @return the dateLatestStart
	 */
	public Date getDateLatestStart() {
		return dateLatestStart;
	}

	/**
	 * @param dateLatestStart the dateLatestStart to set
	 */
	public void setDateLatestStart(Date dateLatestStart) {
		this.dateLatestStart = dateLatestStart;
	}

	/**
	 * @return the dateLatestEnd
	 */
	public Date getDateLatestEnd() {
		return dateLatestEnd;
	}

	/**
	 * @param dateLatestEnd the dateLatestEnd to set
	 */
	public void setDateLatestEnd(Date dateLatestEnd) {
		this.dateLatestEnd = dateLatestEnd;
	}

	/**
	 * @return the dateFirstSubmittedTime
	 */
	public Date getDateFirstSubmittedTime() {
		return dateFirstSubmittedTime;
	}

	/**
	 * @param dateFirstSubmittedTime the dateFirstSubmittedTime to set
	 */
	public void setDateFirstSubmittedTime(Date dateFirstSubmittedTime) {
		this.dateFirstSubmittedTime = dateFirstSubmittedTime;
	}

	/**
	 * @return the dateLatestEndTime
	 */
	public Date getDateLatestEndTime() {
		return dateLatestEndTime;
	}

	/**
	 * @param dateLatestEndTime the dateLatestEndTime to set
	 */
	public void setDateLatestEndTime(Date dateLatestEndTime) {
		this.dateLatestEndTime = dateLatestEndTime;
	}

	/**
	 * @return the taskPriority
	 */
	public String getTaskPriority() {
		return taskPriority;
	}

	/**
	 * @param taskPriority the taskPriority to set
	 */
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	/**
	 * @return the taskHandlerCatgory
	 */
	public String getTaskHandlerCatgory() {
		return taskHandlerCatgory;
	}

	/**
	 * @param taskHandlerCatgory the taskHandlerCatgory to set
	 */
	public void setTaskHandlerCatgory(String taskHandlerCatgory) {
		this.taskHandlerCatgory = taskHandlerCatgory;
	}

	/**
	 * @return the taskHandler
	 */
	public String getTaskHandler() {
		return taskHandler;
	}

	/**
	 * @param taskHandler the taskHandler to set
	 */
	public void setTaskHandler(String taskHandler) {
		this.taskHandler = taskHandler;
	}

	/**
	 * @return the authGroup
	 */
	public String getAuthGroup() {
		return authGroup;
	}

	/**
	 * @param authGroup the authGroup to set
	 */
	public void setAuthGroup(String authGroup) {
		this.authGroup = authGroup;
	}

	/**
	 * @return the authUser
	 */
	public String getAuthUser() {
		return authUser;
	}

	/**
	 * @param authUser the authUser to set
	 */
	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}

	/**
	 * @return the notifySent
	 */
	public String getNotifySent() {
		return notifySent;
	}

	/**
	 * @param notifySent the notifySent to set
	 */
	public void setNotifySent(String notifySent) {
		this.notifySent = notifySent;
	}

	/**
	 * @return the notifyReceipients
	 */
	public String getNotifyReceipients() {
		return notifyReceipients;
	}

	/**
	 * @param notifyReceipients the notifyReceipients to set
	 */
	public void setNotifyReceipients(String notifyReceipients) {
		this.notifyReceipients = notifyReceipients;
	}	

	/**
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimsTasks [claimTaskId=" + claimTaskId + ", claimFileId=" + claimFileId + ", claimItemId="
				+ claimItemId + ", claimId=" + claimId + ", claimHeaderId=" + claimHeaderId + ", "
				+ (version != null ? "version=" + version + ", " : "")
				+ (effectiveDate != null ? "effectiveDate=" + effectiveDate + ", " : "")
				+ (taskCode != null ? "taskCode=" + taskCode + ", " : "") + "flgManual=" + flgManual + ", "
				+ (status != null ? "status=" + status + ", " : "")
				+ (subObjCatgory != null ? "subObjCatgory=" + subObjCatgory + ", " : "")
				+ (subObject != null ? "subObject=" + subObject + ", " : "")
				+ (taskName != null ? "taskName=" + taskName + ", " : "")
				+ (taskDesc != null ? "taskDesc=" + taskDesc + ", " : "")
				+ (activityUsed != null ? "activityUsed=" + activityUsed + ", " : "")
				+ (dateFirstSubmitted != null ? "dateFirstSubmitted=" + dateFirstSubmitted + ", " : "")
				+ (dateLatestStart != null ? "dateLatestStart=" + dateLatestStart + ", " : "")
				+ (dateLatestEnd != null ? "dateLatestEnd=" + dateLatestEnd + ", " : "")
				+ (dateFirstSubmittedTime != null ? "dateFirstSubmittedTime=" + dateFirstSubmittedTime + ", " : "")
				+ (dateLatestEndTime != null ? "dateLatestEndTime=" + dateLatestEndTime + ", " : "")
				+ (taskPriority != null ? "taskPriority=" + taskPriority + ", " : "")
				+ (taskHandlerCatgory != null ? "taskHandlerCatgory=" + taskHandlerCatgory + ", " : "")
				+ (taskHandler != null ? "taskHandler=" + taskHandler + ", " : "")
				+ (authGroup != null ? "authGroup=" + authGroup + ", " : "")
				+ (authUser != null ? "authUser=" + authUser + ", " : "")
				+ (notifySent != null ? "notifySent=" + notifySent + ", " : "")
				+ (notifyReceipients != null ? "notifyReceipients=" + notifyReceipients : "") + "]";
	}
	
}

