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
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimNotes_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsNotes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_NOTES_ID")
	private int claimNotesId;   					//CLAIM_NOTES_ID
	
	@Column(name = "CLAIM_NOTES_VERSION")
	private String claimNotesVersion = "";   		//CLAIM_NOTES_VERSION	
	
	@Column(name = "CLAIM_HEADER_ID")		
	private int claimHeaderId;   					//CLAIM_HEADER_ID	
	
	@Column(name = "CLAIM_HEADER_VERSION")
	private String claimHeaderVersion  = ""; 		//CLAIM_HEADER_VERSION	
	
	@Column(name = "CLAIM_ID")
	private int claimDtlId;  						//CLAIM_ID	
	
	@Column(name = "CLAIM_VERSION")
	private String claimVersion  = "";  					//CLAIM_VERSION
	
	@Column(name = "CLAIM_ITEM_ID")
	private int claimItemId;  						//CLAIM_ITEM_ID	
	
	@Column(name = "CLAIM_ITEM_VERSION")
	private String claimItemVersion  = "";  				//CLAIM_ITEM_VERSION
	
	@Column(name = "CLAIM_FILE_ID")
	private int claimFileId;  						//CLAIM_FILE_ID	
	
	@Column(name = "CLAIM_FILE_VERSION")
	private String claimFileVersion  = "";  				//CLAIM_FILE_VERSION
	
	@Column(name = "CLAIM_RESERVE_ID")
	private int claimReserveId;  					//CLAIM_RESERVE_ID	
	
	@Column(name = "CLAIM_RESERVE_VERSION")
	private String claimReserveVersion  = "";  			//CLAIM_RESERVE_VERSION
	
	@Column(name = "CLAIM_TRANS_ID")
	private int claimTransId;  						//CLAIM_TRANS_ID	
	
	@Column(name = "CLAIM_TRANS_VERSION")
	private String claimTransVersion  = "";  				//CLAIM_TRANS_VERSION
	
	@Column(name = "NOTES_MESSAGE")
	private String notesMessage  = "";  					//NOTES_MESSAGE	
	
	@Column(name = "NOTES_DESC")
	private String notesDesc  = "";  						//NOTES_DESC

	@Column(name = "CREATEDBY")
	private String createdBy  = "";  						//CREATEDBY
	
	@Column(name = "CREATEDDATE")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone="Asia/Kolkata")
	private Timestamp createdDate;  						//CREATEDDATE
	
	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 						//DELETE_FLAG

	/**
	 * @return the claimNotesId
	 */
	public int getClaimNotesId() {
		return claimNotesId;
	}

	/**
	 * @param claimNotesId the claimNotesId to set
	 */
	public void setClaimNotesId(int claimNotesId) {
		this.claimNotesId = claimNotesId;
	}

	/**
	 * @return the claimNotesVersion
	 */
	public String getClaimNotesVersion() {
		return claimNotesVersion;
	}

	/**
	 * @param claimNotesVersion the claimNotesVersion to set
	 */
	public void setClaimNotesVersion(String claimNotesVersion) {
		this.claimNotesVersion = claimNotesVersion;
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
	 * @return the claimHeaderVersion
	 */
	public String getClaimHeaderVersion() {
		return claimHeaderVersion;
	}

	/**
	 * @param claimHeaderVersion the claimHeaderVersion to set
	 */
	public void setClaimHeaderVersion(String claimHeaderVersion) {
		this.claimHeaderVersion = claimHeaderVersion;
	}	

	/**
	 * @return the claimDtlId
	 */
	public int getClaimDtlId() {
		return claimDtlId;
	}

	/**
	 * @param claimDtlId the claimDtlId to set
	 */
	public void setClaimDtlId(int claimDtlId) {
		this.claimDtlId = claimDtlId;
	}

	/**
	 * @return the claimVersion
	 */
	public String getClaimVersion() {
		return claimVersion;
	}

	/**
	 * @param claimVersion the claimVersion to set
	 */
	public void setClaimVersion(String claimVersion) {
		this.claimVersion = claimVersion;
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
	 * @return the claimItemVersion
	 */
	public String getClaimItemVersion() {
		return claimItemVersion;
	}

	/**
	 * @param claimItemVersion the claimItemVersion to set
	 */
	public void setClaimItemVersion(String claimItemVersion) {
		this.claimItemVersion = claimItemVersion;
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
	 * @return the claimFileVersion
	 */
	public String getClaimFileVersion() {
		return claimFileVersion;
	}

	/**
	 * @param claimFileVersion the claimFileVersion to set
	 */
	public void setClaimFileVersion(String claimFileVersion) {
		this.claimFileVersion = claimFileVersion;
	}

	/**
	 * @return the claimReserveId
	 */
	public int getClaimReserveId() {
		return claimReserveId;
	}

	/**
	 * @param claimReserveId the claimReserveId to set
	 */
	public void setClaimReserveId(int claimReserveId) {
		this.claimReserveId = claimReserveId;
	}

	/**
	 * @return the claimReserveVersion
	 */
	public String getClaimReserveVersion() {
		return claimReserveVersion;
	}

	/**
	 * @param claimReserveVersion the claimReserveVersion to set
	 */
	public void setClaimReserveVersion(String claimReserveVersion) {
		this.claimReserveVersion = claimReserveVersion;
	}

	/**
	 * @return the claimTransId
	 */
	public int getClaimTransId() {
		return claimTransId;
	}

	/**
	 * @param claimTransId the claimTransId to set
	 */
	public void setClaimTransId(int claimTransId) {
		this.claimTransId = claimTransId;
	}

	/**
	 * @return the claimTransVersion
	 */
	public String getClaimTransVersion() {
		return claimTransVersion;
	}

	/**
	 * @param claimTransVersion the claimTransVersion to set
	 */
	public void setClaimTransVersion(String claimTransVersion) {
		this.claimTransVersion = claimTransVersion;
	}

	/**
	 * @return the notesMessage
	 */
	public String getNotesMessage() {
		return notesMessage;
	}

	/**
	 * @param notesMessage the notesMessage to set
	 */
	public void setNotesMessage(String notesMessage) {
		this.notesMessage = notesMessage;
	}

	/**
	 * @return the notesDesc
	 */
	public String getNotesDesc() {
		return notesDesc;
	}

	/**
	 * @param notesDesc the notesDesc to set
	 */
	public void setNotesDesc(String notesDesc) {
		this.notesDesc = notesDesc;
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
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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
		return "ElsecoClaimsNotes [claimNotesId=" + claimNotesId + ", "
				+ (claimNotesVersion != null ? "claimNotesVersion=" + claimNotesVersion + ", " : "") + "claimHeaderId="
				+ claimHeaderId + ", "
				+ (claimHeaderVersion != null ? "claimHeaderVersion=" + claimHeaderVersion + ", " : "") + "claimDtlId="
				+ claimDtlId + ", " + (claimVersion != null ? "claimVersion=" + claimVersion + ", " : "")
				+ "claimItemId=" + claimItemId + ", "
				+ (claimItemVersion != null ? "claimItemVersion=" + claimItemVersion + ", " : "") + "claimFileId="
				+ claimFileId + ", " + (claimFileVersion != null ? "claimFileVersion=" + claimFileVersion + ", " : "")
				+ "claimReserveId=" + claimReserveId + ", "
				+ (claimReserveVersion != null ? "claimReserveVersion=" + claimReserveVersion + ", " : "")
				+ "claimTransId=" + claimTransId + ", "
				+ (claimTransVersion != null ? "claimTransVersion=" + claimTransVersion + ", " : "")
				+ (notesMessage != null ? "notesMessage=" + notesMessage + ", " : "")
				+ (notesDesc != null ? "notesDesc=" + notesDesc + ", " : "")
				+ (createdBy != null ? "createdBy=" + createdBy + ", " : "")
				+ (createdDate != null ? "createdDate=" + createdDate + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}

