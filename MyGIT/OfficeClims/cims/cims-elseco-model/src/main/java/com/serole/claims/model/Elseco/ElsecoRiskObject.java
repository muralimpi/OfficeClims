package com.serole.claims.model.Elseco;

import java.math.BigDecimal;
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
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_RiskObject_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoRiskObject  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "RISKOBJ_ID")
	private int riskObjId;  			//"RISKOBJ_ID"
	
	@Column(name = "RISKOBJ_NAME")
	private String riskObjName = ""; 		//"RISKOBJ_NAME"
	
	@Column(name = "RISKOBJ_DESC")
	private String riskObjDesc = ""; 		//"RISKOBJ_DESC"
	
	@Column(name = "RISKOBJ_REGNO")
	private String riskObjRegNo = ""; 		//"RISKOBJ_REGNO"
	
	@Column(name = "RISKOBJ_START_DATE")
	private Date riskObjStDt;//"RISKOBJ_START_DATE"
	
	@Column(name = "RISKOBJ_END_DATE")
	private Date riskObjEdDt; //"RISKOBJ_END_DATE"
	
	@Column(name = "RISKSUMINSURED", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal riskSumInsured; //"RISKSUMINSURED"
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId; //"CLAIM_HEADER_ID"
	
	@Column(name = "UCR_NO")
	private String ucrNo = "";		//"UCR_NO"
	
	@Column(name = "CLAIM_DETAIL_ID")
	private int claimDetailId;//"CLAIM_DETAIL_ID"
	
	@Column(name = "EXTREFNO")
	private String externalRefNo = "";//"EXTREFNO"
	
	@Column(name = "CREATED_DATE")
	private Date createdDt;//"CREATED_DATE"
	
	@Column(name = "CREATED_BY")
	private String createdBy = ""; //"CREATED_BY"
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;//"MODIFIED_DATE"
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy = "";//"MODIFIED_DATE"
		
	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = " "; //DELETE_FLAG

	/**
	 * @return the riskObjId
	 */
	public int getRiskObjId() {
		return riskObjId;
	}

	/**
	 * @param riskObjId the riskObjId to set
	 */
	public void setRiskObjId(int riskObjId) {
		this.riskObjId = riskObjId;
	}

	/**
	 * @return the riskObjName
	 */
	public String getRiskObjName() {
		return riskObjName;
	}

	/**
	 * @param riskObjName the riskObjName to set
	 */
	public void setRiskObjName(String riskObjName) {
		this.riskObjName = riskObjName;
	}

	/**
	 * @return the riskObjDesc
	 */
	public String getRiskObjDesc() {
		return riskObjDesc;
	}

	/**
	 * @param riskObjDesc the riskObjDesc to set
	 */
	public void setRiskObjDesc(String riskObjDesc) {
		this.riskObjDesc = riskObjDesc;
	}

	/**
	 * @return the riskObjRegNo
	 */
	public String getRiskObjRegNo() {
		return riskObjRegNo;
	}

	/**
	 * @param riskObjRegNo the riskObjRegNo to set
	 */
	public void setRiskObjRegNo(String riskObjRegNo) {
		this.riskObjRegNo = riskObjRegNo;
	}

	/**
	 * @return the riskObjStDt
	 */
	public Date getRiskObjStDt() {
		return riskObjStDt;
	}

	/**
	 * @param riskObjStDt the riskObjStDt to set
	 */
	public void setRiskObjStDt(Date riskObjStDt) {
		this.riskObjStDt = riskObjStDt;
	}

	/**
	 * @return the riskObjEdDt
	 */
	public Date getRiskObjEdDt() {
		return riskObjEdDt;
	}

	/**
	 * @param riskObjEdDt the riskObjEdDt to set
	 */
	public void setRiskObjEdDt(Date riskObjEdDt) {
		this.riskObjEdDt = riskObjEdDt;
	}

	/**
	 * @return the riskSumInsured
	 */
	public BigDecimal getRiskSumInsured() {
		return riskSumInsured;
	}

	/**
	 * @param riskSumInsured the riskSumInsured to set
	 */
	public void setRiskSumInsured(BigDecimal riskSumInsured) {
		this.riskSumInsured = riskSumInsured;
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
	 * @return the ucrNo
	 */
	public String getUcrNo() {
		return ucrNo;
	}

	/**
	 * @param ucrNo the ucrNo to set
	 */
	public void setUcrNo(String ucrNo) {
		this.ucrNo = ucrNo;
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
	 * @return the externalRefNo
	 */
	public String getExternalRefNo() {
		return externalRefNo;
	}

	/**
	 * @param externalRefNo the externalRefNo to set
	 */
	public void setExternalRefNo(String externalRefNo) {
		this.externalRefNo = externalRefNo;
	}

	/**
	 * @return the createdDt
	 */
	public Date getCreatedDt() {
		return createdDt;
	}

	/**
	 * @param createdDt the createdDt to set
	 */
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
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
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
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
		return "ElsecoRiskObject [riskObjId=" + riskObjId + ", "
				+ (riskObjName != null ? "riskObjName=" + riskObjName + ", " : "")
				+ (riskObjDesc != null ? "riskObjDesc=" + riskObjDesc + ", " : "")
				+ (riskObjRegNo != null ? "riskObjRegNo=" + riskObjRegNo + ", " : "")
				+ (riskObjStDt != null ? "riskObjStDt=" + riskObjStDt + ", " : "")
				+ (riskObjEdDt != null ? "riskObjEdDt=" + riskObjEdDt + ", " : "")
				+ (riskSumInsured != null ? "riskSumInsured=" + riskSumInsured + ", " : "") + "claimHeaderId="
				+ claimHeaderId + ", " + (ucrNo != null ? "ucrNo=" + ucrNo + ", " : "") + "claimDetailId="
				+ claimDetailId + ", " + (externalRefNo != null ? "externalRefNo=" + externalRefNo + ", " : "")
				+ (createdDt != null ? "createdDt=" + createdDt + ", " : "")
				+ (createdBy != null ? "createdBy=" + createdBy + ", " : "")
				+ (modifiedDate != null ? "modifiedDate=" + modifiedDate + ", " : "")
				+ (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}
