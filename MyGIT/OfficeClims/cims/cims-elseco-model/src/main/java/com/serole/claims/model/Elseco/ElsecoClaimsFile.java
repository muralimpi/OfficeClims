package com.serole.claims.model.Elseco;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimFile_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsFile 	{            
	public ElsecoClaimsFile(){  }
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_FILE_ID")
	private int claimFileId;   				//CLAIM_FILE_ID
	
	@Column(name = "CLAIM_ID")
	private int claimId;   					//CLAIM_ID	
	
	@Column(name = "CLAIM_HEADER_ID")		//CLAIM_HEADER_ID
	private int claimHeaderId;
		
	@Column(name = "VERSION")
	private String version;   				//VERSION	
	
	@Column(name = "CLAIM_FILE_TYPE")
	private String claimFileType; 			//CLAIM_FILE_TYPE	
	
	@Column(name = "CHNG_INDICATOR")
	private String changeIndicator;  		//CHNG_INDICATOR	
	
	@Column(name = "STATUS_CHNG_REASON")
	private String statusChangeReason;  	//STATUS_CHNG_REASON
	
	@Column(name = "FILE_STATUS")
	private String fileStatus;  			//FILE_STATUS	
	
	@Column(name = "STATUSCHNG_BY")
	private String statusChangeBy;  		//STATUSCHNG_BY	
	
	@Column(name = "STATUSCHNG_TIME")
	private Date statusChangeTime;  		//STATUSCHNG_TIME	
		
	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 		//DELETE_FLAG
	
	@Transient
	//@JsonInclude(Include.NON_NULL)
	private List<ElsecoCheckList> ClaimsCheckListInfo;

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
	 * @return the claimFileType
	 */
	public String getClaimFileType() {
		return claimFileType;
	}

	/**
	 * @param claimFileType the claimFileType to set
	 */
	public void setClaimFileType(String claimFileType) {
		this.claimFileType = claimFileType;
	}

	/**
	 * @return the changeIndicator
	 */
	public String getChangeIndicator() {
		return changeIndicator;
	}

	/**
	 * @param changeIndicator the changeIndicator to set
	 */
	public void setChangeIndicator(String changeIndicator) {
		this.changeIndicator = changeIndicator;
	}

	/**
	 * @return the statusChangeReason
	 */
	public String getStatusChangeReason() {
		return statusChangeReason;
	}

	/**
	 * @param statusChangeReason the statusChangeReason to set
	 */
	public void setStatusChangeReason(String statusChangeReason) {
		this.statusChangeReason = statusChangeReason;
	}

	/**
	 * @return the fileStatus
	 */
	public String getFileStatus() {
		return fileStatus;
	}

	/**
	 * @param fileStatus the fileStatus to set
	 */
	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	/**
	 * @return the statusChangeBy
	 */
	public String getStatusChangeBy() {
		return statusChangeBy;
	}

	/**
	 * @param statusChangeBy the statusChangeBy to set
	 */
	public void setStatusChangeBy(String statusChangeBy) {
		this.statusChangeBy = statusChangeBy;
	}

	/**
	 * @return the statusChangeTime
	 */
	public Date getStatusChangeTime() {
		return statusChangeTime;
	}

	/**
	 * @param statusChangeTime the statusChangeTime to set
	 */
	public void setStatusChangeTime(Date statusChangeTime) {
		this.statusChangeTime = statusChangeTime;
	}

	/**
	 * @return the claimsCheckListInfo
	 */
	public List<ElsecoCheckList> getClaimsCheckListInfo() {
		return ClaimsCheckListInfo;
	}

	/**
	 * @param claimsCheckListInfo the claimsCheckListInfo to set
	 */
	public void setClaimsCheckListInfo(List<ElsecoCheckList> claimsCheckListInfo) {
		ClaimsCheckListInfo = claimsCheckListInfo;
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
		return "ElsecoClaimsFile [claimFileId=" + claimFileId + ", claimId=" + claimId + ", "
				+ (version != null ? "version=" + version + ", " : "")
				+ (claimFileType != null ? "claimFileType=" + claimFileType + ", " : "")
				+ (changeIndicator != null ? "changeIndicator=" + changeIndicator + ", " : "")
				+ (statusChangeReason != null ? "statusChangeReason=" + statusChangeReason + ", " : "")
				+ (fileStatus != null ? "fileStatus=" + fileStatus + ", " : "")
				+ (statusChangeBy != null ? "statusChangeBy=" + statusChangeBy + ", " : "")
				+ (statusChangeTime != null ? "statusChangeTime=" + statusChangeTime + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}			
}
