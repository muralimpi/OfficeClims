package com.serole.claims.model.Elseco;

import org.springframework.stereotype.Component;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimParticipant_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsParticipant  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_ID")
	private int claimId;  						//"CLAIM_ID"
	
	@Column(name = "CLAIM_BUNDLE_ID")
	private int claimBundleId; 					//"CLAIM_BUNDLE_ID"
	
	@Column(name = "CLAIM_HEADER_ID")			//CLAIM_HEADER_ID
	private int claimHeaderId;
	
	@Column(name = "PARTICIPANT")
	private String participant  = ""; 			//"PARTICIPANT"
	
	@Column(name = "SUBOBJ_CATG")
	private String subObjCatg  = ""; 			//"SUBOBJ_CATG"
	
	@Column(name = "SUBOBJECT_NO")
	private String subObjNumber  = "";			//"SUBOBJECT_NO"
	
	@Column(name = "ROLE_CD")
	private String roleCode  = ""; 				//"ROLE_CD"
	
	@Column(name = "VERSION")
	private String version  = ""; 				//"VERSION"
	
	@Column(name = "CHNG_INDICATOR")
	private String changeIndicator  = ""; 		//"CHNG_INDICATOR"
	
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;					//"EFFECTIVE_DATE"
	
	@Column(name = "REFERENCE")
	private String reference  = "";				//"REFERENCE"
	
	@Column(name = "RELTYPE")
	private String relType  = "";				//"RELTYPE"
	
	@Column(name = "PART_TEXT01")
	private String partText01  = "";			//"PART_TEXT01"
	
	@Column(name = "DT_FILE_REQUESTED")
	private Date dateFileRequested; 			//"DT_FILE_REQUESTED"
	
	@Column(name = "PARTTYPE")
	private String partType  = "";				//"PARTTYPE"
	
	@Column(name = "SEAT")
	private String seat  = "";					//"SEAT"
	
	@Column(name = "FLG_SALESTAX")
	private String flagSalesTax  = "";			//"FLG_SALESTAX"
		
	@Column(name = "LIABILITY_RATE", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal liabilityRate;			//"LIABILITY_RATE"
	
	@Column(name = "FLG_INTRACOMPANY")
	private String flagIntraCompany  = "";		//"FLG_INTRACOMPANY"
	
	@Column(name = "FLG_NOT_INS")
	private String flagNotIns  = "";			//"FLG_NOT_INS"
	
	@Column(name = "FLG_WITNES_CNF")
	private String flagWitnessConf  = "";		//"FLG_WITNES_CNF"
	
	@Column(name = "JUDGEMENT")
	private String judgement  = "";				//"JUDGEMENT"
	
	@Column(name = "FLG_KNOWN2DRIVER")
	private String flagKnown2Driver  = "";		//"FLG_KNOWN2DRIVER"
	
	@Column(name = "DRVER_AGE")
	private String driverAge  = "";				//"DRVER_AGE"
	
	@Column(name = "DT_DRVL_ISSUE")
	private Date dateDrvlIssue;					//"DT_DRVL_ISSUE"
	
	@Column(name = "DT_OF_BIRTH")
	private Date dateOfBirth;					//"DT_OF_BIRTH"
	
	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 			//DELETE_FLAG
	
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
	 * @return the claimBundleId
	 */
	public int getClaimBundleId() {
		return claimBundleId;
	}
	/**
	 * @param claimBundleId the claimBundleId to set
	 */
	public void setClaimBundleId(int claimBundleId) {
		this.claimBundleId = claimBundleId;
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
	 * @return the participant
	 */
	public String getParticipant() {
		return participant;
	}
	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	/**
	 * @return the subObjCatg
	 */
	public String getSubObjCatg() {
		return subObjCatg;
	}
	/**
	 * @param subObjCatg the subObjCatg to set
	 */
	public void setSubObjCatg(String subObjCatg) {
		this.subObjCatg = subObjCatg;
	}
	/**
	 * @return the subObjNumber
	 */
	public String getSubObjNumber() {
		return subObjNumber;
	}
	/**
	 * @param subObjNumber the subObjNumber to set
	 */
	public void setSubObjNumber(String subObjNumber) {
		this.subObjNumber = subObjNumber;
	}
	/**
	 * @return the roleCode
	 */
	public String getRoleCode() {
		return roleCode;
	}
	/**
	 * @param roleCode the roleCode to set
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	/**
	 * @return the relType
	 */
	public String getRelType() {
		return relType;
	}
	/**
	 * @param relType the relType to set
	 */
	public void setRelType(String relType) {
		this.relType = relType;
	}
	/**
	 * @return the partText01
	 */
	public String getPartText01() {
		return partText01;
	}
	/**
	 * @param partText01 the partText01 to set
	 */
	public void setPartText01(String partText01) {
		this.partText01 = partText01;
	}
	/**
	 * @return the dateFileRequested
	 */
	public Date getDateFileRequested() {
		return dateFileRequested;
	}
	/**
	 * @param dateFileRequested the dateFileRequested to set
	 */
	public void setDateFileRequested(Date dateFileRequested) {
		this.dateFileRequested = dateFileRequested;
	}
	/**
	 * @return the partType
	 */
	public String getPartType() {
		return partType;
	}
	/**
	 * @param partType the partType to set
	 */
	public void setPartType(String partType) {
		this.partType = partType;
	}
	/**
	 * @return the seat
	 */
	public String getSeat() {
		return seat;
	}
	/**
	 * @param seat the seat to set
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}
	/**
	 * @return the flagSalesTax
	 */
	public String getFlagSalesTax() {
		return flagSalesTax;
	}
	/**
	 * @param flagSalesTax the flagSalesTax to set
	 */
	public void setFlagSalesTax(String flagSalesTax) {
		this.flagSalesTax = flagSalesTax;
	}
	/**
	 * @return the liabilityRate
	 */
	public BigDecimal getLiabilityRate() {
		return liabilityRate;
	}
	/**
	 * @param liabilityRate the liabilityRate to set
	 */
	public void setLiabilityRate(BigDecimal liabilityRate) {
		this.liabilityRate = liabilityRate;
	}
	/**
	 * @return the flagIntraCompany
	 */
	public String getFlagIntraCompany() {
		return flagIntraCompany;
	}
	/**
	 * @param flagIntraCompany the flagIntraCompany to set
	 */
	public void setFlagIntraCompany(String flagIntraCompany) {
		this.flagIntraCompany = flagIntraCompany;
	}
	/**
	 * @return the flagNotIns
	 */
	public String getFlagNotIns() {
		return flagNotIns;
	}
	/**
	 * @param flagNotIns the flagNotIns to set
	 */
	public void setFlagNotIns(String flagNotIns) {
		this.flagNotIns = flagNotIns;
	}
	/**
	 * @return the flagWitnessConf
	 */
	public String getFlagWitnessConf() {
		return flagWitnessConf;
	}
	/**
	 * @param flagWitnessConf the flagWitnessConf to set
	 */
	public void setFlagWitnessConf(String flagWitnessConf) {
		this.flagWitnessConf = flagWitnessConf;
	}
	/**
	 * @return the judgement
	 */
	public String getJudgement() {
		return judgement;
	}
	/**
	 * @param judgement the judgement to set
	 */
	public void setJudgement(String judgement) {
		this.judgement = judgement;
	}
	/**
	 * @return the flagKnown2Driver
	 */
	public String getFlagKnown2Driver() {
		return flagKnown2Driver;
	}
	/**
	 * @param flagKnown2Driver the flagKnown2Driver to set
	 */
	public void setFlagKnown2Driver(String flagKnown2Driver) {
		this.flagKnown2Driver = flagKnown2Driver;
	}
	/**
	 * @return the driverAge
	 */
	public String getDriverAge() {
		return driverAge;
	}
	/**
	 * @param driverAge the driverAge to set
	 */
	public void setDriverAge(String driverAge) {
		this.driverAge = driverAge;
	}
	/**
	 * @return the dateDrvlIssue
	 */
	public Date getDateDrvlIssue() {
		return dateDrvlIssue;
	}
	/**
	 * @param dateDrvlIssue the dateDrvlIssue to set
	 */
	public void setDateDrvlIssue(Date dateDrvlIssue) {
		this.dateDrvlIssue = dateDrvlIssue;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		return "ElsecoClaimsParticipant [claimId=" + claimId + ", claimBundleId=" + claimBundleId + ", "
				+ (participant != null ? "participant=" + participant + ", " : "")
				+ (subObjCatg != null ? "subObjCatg=" + subObjCatg + ", " : "")
				+ (subObjNumber != null ? "subObjNumber=" + subObjNumber + ", " : "")
				+ (roleCode != null ? "roleCode=" + roleCode + ", " : "")
				+ (version != null ? "version=" + version + ", " : "")
				+ (changeIndicator != null ? "changeIndicator=" + changeIndicator + ", " : "")
				+ (effectiveDate != null ? "effectiveDate=" + effectiveDate + ", " : "")
				+ (reference != null ? "reference=" + reference + ", " : "")
				+ (relType != null ? "relType=" + relType + ", " : "")
				+ (partText01 != null ? "partText01=" + partText01 + ", " : "")
				+ (dateFileRequested != null ? "dateFileRequested=" + dateFileRequested + ", " : "")
				+ (partType != null ? "partType=" + partType + ", " : "") + (seat != null ? "seat=" + seat + ", " : "")
				+ (flagSalesTax != null ? "flagSalesTax=" + flagSalesTax + ", " : "")
				+ (liabilityRate != null ? "liabilityRate=" + liabilityRate + ", " : "")
				+ (flagIntraCompany != null ? "flagIntraCompany=" + flagIntraCompany + ", " : "")
				+ (flagNotIns != null ? "flagNotIns=" + flagNotIns + ", " : "")
				+ (flagWitnessConf != null ? "flagWitnessConf=" + flagWitnessConf + ", " : "")
				+ (judgement != null ? "judgement=" + judgement + ", " : "")
				+ (flagKnown2Driver != null ? "flagKnown2Driver=" + flagKnown2Driver + ", " : "")
				+ (driverAge != null ? "driverAge=" + driverAge + ", " : "")
				+ (dateDrvlIssue != null ? "dateDrvlIssue=" + dateDrvlIssue + ", " : "")
				+ (dateOfBirth != null ? "dateOfBirth=" + dateOfBirth + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}
	
}
