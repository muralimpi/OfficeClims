package com.serole.claims.model.Elseco;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_CheckList_T\"", schema="${cims.hana.datasource.package}")          
	
public class ElsecoCheckList {
	public ElsecoCheckList(){  }
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CHECKLIST_ID")						//CHECKLIST_ID
	private int checkListId;   							
	
	@Column(name = "CHECKLIST_NAME")					//CHECKLIST_NAME
	private String checkListName = "";   					
	
	@Column(name = "CHECKLIST_GROUP")					//CHECKLIST_GROUP
	private String checkListGroup = "";   					
	
	@Column(name = "CLAIM_HEADER_ID")					//CLAIM_HEADER_ID
	private int claimHeaderId;  
	
	@Column(name = "CLAIM_DETAIL_ID")					//CLAIM_DETAIL_ID
	private int claimDetailId; 
	
	@Column(name = "CLAIM_FILE_ID")						//CLAIM_FILE_ID
	private int claimFileId;  
	
	@Column(name = "CLAIM_ITEM_ID")						//CLAIM_ITEM_ID
	private int claimItemId;  

	@Column(name = "UCR_NO")							//UCR_NO
	private String ucrNumber  = "";  			
	
	@Column(name = "EXTERNAL_REF")						//EXTERNAL_REF
	private String externalRef  = ""; 					

	@Column(name = "LEVEL")								//LEVEL
	private String level = ""; 		
	
	@Column(name = "IS_CHECKED")						//IS_CHECKED
	private String isChecked = ""; 		
	
	@Column(name = "CHECKED_BY")						//CHECKED_BY
	private String checkedBy = ""; 		
	
	@Column(name = "CHECKED_DATE")						//CHECKED_DATE
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone="Asia/Kolkata")
	private Timestamp checkedDate;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 					//DELETE_FLAG
	
	/**
	 * @return the checkListId
	 */
	public int getCheckListId() {
		return checkListId;
	}

	/**
	 * @param checkListId the checkListId to set
	 */
	public void setCheckListId(int checkListId) {
		this.checkListId = checkListId;
	}

	/**
	 * @return the checkListName
	 */
	public String getCheckListName() {
		return checkListName;
	}

	/**
	 * @param checkListName the checkListName to set
	 */
	public void setCheckListName(String checkListName) {
		this.checkListName = checkListName;
	}

	/**
	 * @return the checkListGroup
	 */
	public String getCheckListGroup() {
		return checkListGroup;
	}

	/**
	 * @param checkListGroup the checkListGroup to set
	 */
	public void setCheckListGroup(String checkListGroup) {
		this.checkListGroup = checkListGroup;
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
	 * @return the claimDetailId
	 */
	public int getClaimDetailId() {
		return claimDetailId;
	}

	/**
	 * @param claimDetailId the claimDetailId to set
	 */
	public void setClaimDetailId(int claimDetailId) {
		this.claimDetailId = claimDetailId;
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
	 * @return the ucrNumber
	 */
	public String getUcrNumber() {
		return ucrNumber;
	}

	/**
	 * @param ucrNumber the ucrNumber to set
	 */
	public void setUcrNumber(String ucrNumber) {
		this.ucrNumber = ucrNumber;
	}

	/**
	 * @return the externalRef
	 */
	public String getExternalRef() {
		return externalRef;
	}

	/**
	 * @param externalRef the externalRef to set
	 */
	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the isChecked
	 */
	public String getIsChecked() {
		return isChecked;
	}

	/**
	 * @param isChecked the isChecked to set
	 */
	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	/**
	 * @return the checkedBy
	 */
	public String getCheckedBy() {
		return checkedBy;
	}

	/**
	 * @param checkedBy the checkedBy to set
	 */
	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}

	/**
	 * @return the checkedDate
	 */
	public Timestamp getCheckedDate() {
		return checkedDate;
	}

	/**
	 * @param checkedDate the checkedDate to set
	 */
	public void setCheckedDate(Timestamp checkedDate) {
		this.checkedDate = checkedDate;
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
		return "ElsecoCheckList [checkListId=" + checkListId + ", "
				+ (checkListName != null ? "checkListName=" + checkListName + ", " : "")
				+ (checkListGroup != null ? "checkListGroup=" + checkListGroup + ", " : "") + "claimHeaderId="
				+ claimHeaderId + ", claimDetailId=" + claimDetailId + ", claimFileId=" + claimFileId + ", claimItemId="
				+ claimItemId + ", " + (ucrNumber != null ? "ucrNumber=" + ucrNumber + ", " : "")
				+ (externalRef != null ? "externalRef=" + externalRef + ", " : "")
				+ (level != null ? "level=" + level + ", " : "")
				+ (isChecked != null ? "isChecked=" + isChecked + ", " : "")
				+ (checkedBy != null ? "checkedBy=" + checkedBy + ", " : "")
				+ (checkedDate != null ? "checkedDate=" + checkedDate : "") + "]";
	}
}
