package com.serole.claims.model.Elseco;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.serole.claims.model.json.JsonHandlerForAuditTrace;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_AuditTrail_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsAuditTrail {
	public ElsecoClaimsAuditTrail(){  }
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")	
	private int ID;   						//ID	
	
	@Column(name = "APPLICATIONHANDLE")	
	private String applicationHandle;   	//APPLICATIONHANDLE	
	
	@Column(name = "MODULEHANDLE")	
	private String moduleHandle;   			//MODULEHANDLE	
	
	@Column(name = "SCREENHANDLE")	
	private String screenHandle;   			//SCREENHANDLE	
	
	@Column(name = "CRUDENTITYHANDLE")	
	private String crudEntityHandle;   			//CRUDENTITYHANDLE	
	
	@Column(name = "UNIQUEID")
	private String uniqueId;  			//UNIQUEID
	
	@Column(name = "OPERATORTYPE")
	private String operatorType; 			//OPERATORTYPE	
	
	@Column(name = "OLDCLOBJSON")
	private String oldClobJson;  			//OLDCLOBJSON	
	
	@Column(name = "NEWCLOBJSON")
	private String newClobJson;  			//NEWCLOBJSON	
	
	@Column(name = "SOURCEIPADDRESS")
	private String sourceIPAddress;  		//SOURCEIPADDRESS	
	
	@Column(name = "CREATEDBY")
	private String createdBy;  				//CREATEDBY	
	
	@Column(name = "CREATEDDATETIME")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone="Asia/Kolkata")
	private Timestamp createdDateTime;  	//CREATEDDATETIME	
	
	@Transient
	private List<JsonHandlerForAuditTrace> fields;

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the applicationHandle
	 */
	public String getApplicationHandle() {
		return applicationHandle;
	}

	/**
	 * @param applicationHandle the applicationHandle to set
	 */
	public void setApplicationHandle(String applicationHandle) {
		this.applicationHandle = applicationHandle;
	}

	/**
	 * @return the moduleHandle
	 */
	public String getModuleHandle() {
		return moduleHandle;
	}

	/**
	 * @param moduleHandle the moduleHandle to set
	 */
	public void setModuleHandle(String moduleHandle) {
		this.moduleHandle = moduleHandle;
	}

	/**
	 * @return the screenHandle
	 */
	public String getScreenHandle() {
		return screenHandle;
	}

	/**
	 * @param screenHandle the screenHandle to set
	 */
	public void setScreenHandle(String screenHandle) {
		this.screenHandle = screenHandle;
	}

	/**
	 * @return the crudEntityHandle
	 */
	public String getCrudEntityHandle() {
		return crudEntityHandle;
	}

	/**
	 * @param crudEntityHandle the crudEntityHandle to set
	 */
	public void setCrudEntityHandle(String crudEntityHandle) {
		this.crudEntityHandle = crudEntityHandle;
	}

	/**
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * @return the operatorType
	 */
	public String getOperatorType() {
		return operatorType;
	}

	/**
	 * @param operatorType the operatorType to set
	 */
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	/**
	 * @return the oldClobJson
	 */
	public String getOldClobJson() {
		return oldClobJson;
	}

	/**
	 * @param oldClobJson the oldClobJson to set
	 */
	public void setOldClobJson(String oldClobJson) {
		this.oldClobJson = oldClobJson;
	}

	/**
	 * @return the newClobJson
	 */
	public String getNewClobJson() {
		return newClobJson;
	}

	/**
	 * @param newClobJson the newClobJson to set
	 */
	public void setNewClobJson(String newClobJson) {
		this.newClobJson = newClobJson;
	}

	/**
	 * @return the sourceIPAddress
	 */
	public String getSourceIPAddress() {
		return sourceIPAddress;
	}

	/**
	 * @param sourceIPAddress the sourceIPAddress to set
	 */
	public void setSourceIPAddress(String sourceIPAddress) {
		this.sourceIPAddress = sourceIPAddress;
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
	 * @return the createdDateTime
	 */
	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * @return the fields
	 */
	public List<JsonHandlerForAuditTrace> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<JsonHandlerForAuditTrace> fields) {
		this.fields = fields;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimsAuditTrail [ID=" + ID + ", "
				+ (applicationHandle != null ? "applicationHandle=" + applicationHandle + ", " : "")
				+ (moduleHandle != null ? "moduleHandle=" + moduleHandle + ", " : "")
				+ (screenHandle != null ? "screenHandle=" + screenHandle + ", " : "")
				+ (crudEntityHandle != null ? "crudEntityHandle=" + crudEntityHandle + ", " : "")
				+ (uniqueId != null ? "uniqueId=" + uniqueId + ", " : "")
				+ (operatorType != null ? "operatorType=" + operatorType + ", " : "")
				+ (oldClobJson != null ? "oldClobJson=" + oldClobJson + ", " : "")
				+ (newClobJson != null ? "newClobJson=" + newClobJson + ", " : "")
				+ (sourceIPAddress != null ? "sourceIPAddress=" + sourceIPAddress + ", " : "")
				+ (createdBy != null ? "createdBy=" + createdBy + ", " : "")
				+ (createdDateTime != null ? "createdDateTime=" + createdDateTime : "") + "]";
	}	
}
