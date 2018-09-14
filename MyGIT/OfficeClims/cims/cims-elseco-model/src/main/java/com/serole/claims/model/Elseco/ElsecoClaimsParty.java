package com.serole.claims.model.Elseco;

import java.sql.Date;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimParty_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsParty {

	public ElsecoClaimsParty() { }
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PARTY_ID")
	private int partyId;  
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId; 
		
	@Column(name = "PARTY_BP_ID")
	private int partyBpId;
	
	@Column(name = "UCR_NO")
	private String ucrNumber  = ""; 
	
	@Column(name = "EXTERNAL_REF_NO")
	private String extRefNo = ""; 
	
	@Column(name = "PARTY_NAME")
	private String partyName  = ""; 
	
	@Transient
	private String partyEmail  = ""; 
	
	@Column(name = "PARTY_DESCRIPTION")
	private String partyDescription= ""; 
	
	@Column(name = "PARTY_INV_SOURCE")
	private String partyInvSource = ""; 
	
	@Column(name = "PARTY_INTRODUCER_ID")
	private int partyIntroducerID  ;
	
	@Column(name = "PARTY_INTRODUCER_NAME")
	private String partyIntroducerName = ""; 
	
	@Column(name = "PARTY_SERVICE_AMT_INCURED")
	private BigDecimal partySrvceAmtIncured ; 
	
	@Column(name = "PARTY_PERC_SERVICE_CHRG_INV1")
	private BigDecimal partyPercSrvChrgInv1 ; 
	
	@Column(name = "PARTY_PERC_SERVICE_CHRG_INV2")
	private BigDecimal partyPercSrvChrgInv2 ; 
	
	@Column(name = "PARTY_PERC_SERVICE_CHRG_INV3")
	private BigDecimal partyPercSrvChrgInv3 ; 
	
	@Column(name = "PARTY_PERC_SERVICE_CHRG_INV4")
	private BigDecimal partyPercSrvChrgInv4 ; 
	
	@Column(name = "PARTY_SERVICE_AMT_ADDSUBCHRG")
	private BigDecimal partyAmtAddSubChrg ; 
	
	@Column(name = "PARTY_SERVICE_AMT_PREVPAID")
	private BigDecimal partySrvcAmtPrevPaid; 
	
	@Column(name = "PARTY_SERVICE_AMT_SETTLED")
	private BigDecimal partySrvcAmtSettled; 
	
	@Column(name = "PARTY_SERVICE_DETAILS")
	private String partySrvcDetails; 
		
	@Column(name = "PARTY_INV_INTERNAL_STATUS")
	private String partyInvInternalStatus  = ""; 
	
	@Column(name = "PARTY_INV_EXTERNAL_STATUS")
	private String partyInvExternalStatus  = ""; 
	
	@Column(name = "PARTY_INV_DATE")
	private Date partyInvDate  ; 
		
	@Column(name = "PARTY_REMITANCE_ACCT_DTS")
	private String partyRemitanceAcctDts  ; 
	
	@Column(name = "PARTY_INV_APPROVAL")
	private String partyInvApporval;
	
	@Column(name = "COLLECTION_TYPE")
	private String collectionType ;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 
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

	/**
	 * @return the partyId
	 */
	public int getPartyId() {
		return partyId;
	}

	/**
	 * @param partyId the partyId to set
	 */
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	/**
	 * @return the partyBpId
	 */
	public int getPartyBpId() {
		return partyBpId;
	}

	/**
	 * @param partyBpId the partyBpId to set
	 */
	public void setPartyBpId(int partyBpId) {
		this.partyBpId = partyBpId;
	}

	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * @return the partyDescription
	 */
	public String getPartyDescription() {
		return partyDescription;
	}

	/**
	 * @param partyDescription the partyDescription to set
	 */
	public void setPartyDescription(String partyDescription) {
		this.partyDescription = partyDescription;
	}

	/**
	 * @return the partyInvSource
	 */
	public String getPartyInvSource() {
		return partyInvSource;
	}

	/**
	 * @param partyInvSource the partyInvSource to set
	 */
	public void setPartyInvSource(String partyInvSource) {
		this.partyInvSource = partyInvSource;
	}

	/**
	 * @return the partyIntroducerID
	 */
	public int getPartyIntroducerID() {
		return partyIntroducerID;
	}

	/**
	 * @param partyIntroducerID the partyIntroducerID to set
	 */
	public void setPartyIntroducerID(int partyIntroducerID) {
		this.partyIntroducerID = partyIntroducerID;
	}

	/**
	 * @return the partyIntroducerName
	 */
	public String getPartyIntroducerName() {
		return partyIntroducerName;
	}

	/**
	 * @param partyIntroducerName the partyIntroducerName to set
	 */
	public void setPartyIntroducerName(String partyIntroducerName) {
		this.partyIntroducerName = partyIntroducerName;
	}

	/**
	 * @return the partySrvceAmtIncured
	 */
	public BigDecimal getPartySrvceAmtIncured() {
		return partySrvceAmtIncured;
	}

	/**
	 * @param partySrvceAmtIncured the partySrvceAmtIncured to set
	 */
	public void setPartySrvceAmtIncured(BigDecimal partySrvceAmtIncured) {
		this.partySrvceAmtIncured = partySrvceAmtIncured;
	}
	
	/**
	 * @return the partyPercSrvChrgInv1
	 */
	public BigDecimal getPartyPercSrvChrgInv1() {
		return partyPercSrvChrgInv1;
	}

	/**
	 * @param partyPercSrvChrgInv1 the partyPercSrvChrgInv1 to set
	 */
	public void setPartyPercSrvChrgInv1(BigDecimal partyPercSrvChrgInv1) {
		this.partyPercSrvChrgInv1 = partyPercSrvChrgInv1;
	}

	/**
	 * @return the partyPercSrvChrgInv2
	 */
	public BigDecimal getPartyPercSrvChrgInv2() {
		return partyPercSrvChrgInv2;
	}

	/**
	 * @param partyPercSrvChrgInv2 the partyPercSrvChrgInv2 to set
	 */
	public void setPartyPercSrvChrgInv2(BigDecimal partyPercSrvChrgInv2) {
		this.partyPercSrvChrgInv2 = partyPercSrvChrgInv2;
	}

	/**
	 * @return the partyPercSrvChrgInv3
	 */
	public BigDecimal getPartyPercSrvChrgInv3() {
		return partyPercSrvChrgInv3;
	}

	/**
	 * @param partyPercSrvChrgInv3 the partyPercSrvChrgInv3 to set
	 */
	public void setPartyPercSrvChrgInv3(BigDecimal partyPercSrvChrgInv3) {
		this.partyPercSrvChrgInv3 = partyPercSrvChrgInv3;
	}

	/**
	 * @return the partyPercSrvChrgInv4
	 */
	public BigDecimal getPartyPercSrvChrgInv4() {
		return partyPercSrvChrgInv4;
	}

	/**
	 * @param partyPercSrvChrgInv4 the partyPercSrvChrgInv4 to set
	 */
	public void setPartyPercSrvChrgInv4(BigDecimal partyPercSrvChrgInv4) {
		this.partyPercSrvChrgInv4 = partyPercSrvChrgInv4;
	}

	/**
	 * @return the partyAmtAddSubChrg
	 */
	public BigDecimal getPartyAmtAddSubChrg() {
		return partyAmtAddSubChrg;
	}

	/**
	 * @param partyAmtAddSubChrg the partyAmtAddSubChrg to set
	 */
	public void setPartyAmtAddSubChrg(BigDecimal partyAmtAddSubChrg) {
		this.partyAmtAddSubChrg = partyAmtAddSubChrg;
	}

	/**
	 * @return the partySrvcAmtPrevPaid
	 */
	public BigDecimal getPartySrvcAmtPrevPaid() {
		return partySrvcAmtPrevPaid;
	}

	/**
	 * @param partySrvcAmtPrevPaid the partySrvcAmtPrevPaid to set
	 */
	public void setPartySrvcAmtPrevPaid(BigDecimal partySrvcAmtPrevPaid) {
		this.partySrvcAmtPrevPaid = partySrvcAmtPrevPaid;
	}

	/**
	 * @return the partySrvcAmtSettled
	 */
	public BigDecimal getPartySrvcAmtSettled() {
		return partySrvcAmtSettled;
	}

	/**
	 * @param partySrvcAmtSettled the partySrvcAmtSettled to set
	 */
	public void setPartySrvcAmtSettled(BigDecimal partySrvcAmtSettled) {
		this.partySrvcAmtSettled = partySrvcAmtSettled;
	}

	/**
	 * @return the partySrvcDetails
	 */
	public String getPartySrvcDetails() {
		return partySrvcDetails;
	}

	/**
	 * @param partySrvcDetails the partySrvcDetails to set
	 */
	public void setPartySrvcDetails(String partySrvcDetails) {
		this.partySrvcDetails = partySrvcDetails;
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
	 * @return the extRefNo
	 */
	public String getExtRefNo() {
		return extRefNo;
	}

	/**
	 * @param extRefNo the extRefNo to set
	 */
	public void setExtRefNo(String extRefNo) {
		this.extRefNo = extRefNo;
	}

	/**
	 * @return the partyInvInternalStatus
	 */
	public String getPartyInvInternalStatus() {
		return partyInvInternalStatus;
	}

	/**
	 * @param partyInvInternalStatus the partyInvInternalStatus to set
	 */
	public void setPartyInvInternalStatus(String partyInvInternalStatus) {
		this.partyInvInternalStatus = partyInvInternalStatus;
	}

	/**
	 * @return the partyInvExternalStatus
	 */
	public String getPartyInvExternalStatus() {
		return partyInvExternalStatus;
	}

	/**
	 * @param partyInvExternalStatus the partyInvExternalStatus to set
	 */
	public void setPartyInvExternalStatus(String partyInvExternalStatus) {
		this.partyInvExternalStatus = partyInvExternalStatus;
	}

	/**
	 * @return the partyInvDate
	 */
	public Date getPartyInvDate() {
		return partyInvDate;
	}

	/**
	 * @param partyInvDate the partyInvDate to set
	 */
	public void setPartyInvDate(Date partyInvDate) {
		this.partyInvDate = partyInvDate;
	}

	/**
	 * @return the partyEmail
	 */
	public String getPartyEmail() {
		return partyEmail;
	}

	/**
	 * @param partyEmail the partyEmail to set
	 */
	public void setPartyEmail(String partyEmail) {
		this.partyEmail = partyEmail;
	}

	/**
	 * @return the partyRemitanceAcctDts
	 */
	public String getPartyRemitanceAcctDts() {
		return partyRemitanceAcctDts;
	}

	/**
	 * @param partyRemitanceAcctDts the partyRemitanceAcctDts to set
	 */
	public void setPartyRemitanceAcctDts(String partyRemitanceAcctDts) {
		this.partyRemitanceAcctDts = partyRemitanceAcctDts;
	}

	/**
	 * @return the partyInvApporval
	 */
	public String getPartyInvApporval() {
		return partyInvApporval;
	}

	/**
	 * @param partyInvApporval the partyInvApporval to set
	 */
	public void setPartyInvApporval(String partyInvApporval) {
		this.partyInvApporval = partyInvApporval;
	}

	/**
	 * @return the collectionType
	 */
	public String getCollectionType() {
		return collectionType;
	}

	/**
	 * @param collectionType the collectionType to set
	 */
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimsParty [partyId=" + partyId + ", claimHeaderId=" + claimHeaderId + ", partyBpId=" + partyBpId
				+ ", " + (ucrNumber != null ? "ucrNumber=" + ucrNumber + ", " : "")
				+ (extRefNo != null ? "extRefNo=" + extRefNo + ", " : "")
				+ (partyName != null ? "partyName=" + partyName + ", " : "")
				+ (partyEmail != null ? "partyEmail=" + partyEmail + ", " : "")
				+ (partyDescription != null ? "partyDescription=" + partyDescription + ", " : "")
				+ (partyInvSource != null ? "partyInvSource=" + partyInvSource + ", " : "") + "partyIntroducerID="
				+ partyIntroducerID + ", "
				+ (partyIntroducerName != null ? "partyIntroducerName=" + partyIntroducerName + ", " : "")
				+ (partySrvceAmtIncured != null ? "partySrvceAmtIncured=" + partySrvceAmtIncured + ", " : "")
				+ (partyPercSrvChrgInv1 != null ? "partyPercSrvChrgInv1=" + partyPercSrvChrgInv1 + ", " : "")
				+ (partyPercSrvChrgInv2 != null ? "partyPercSrvChrgInv2=" + partyPercSrvChrgInv2 + ", " : "")
				+ (partyPercSrvChrgInv3 != null ? "partyPercSrvChrgInv3=" + partyPercSrvChrgInv3 + ", " : "")
				+ (partyPercSrvChrgInv4 != null ? "partyPercSrvChrgInv4=" + partyPercSrvChrgInv4 + ", " : "")
				+ (partyAmtAddSubChrg != null ? "partyAmtAddSubChrg=" + partyAmtAddSubChrg + ", " : "")
				+ (partySrvcAmtPrevPaid != null ? "partySrvcAmtPrevPaid=" + partySrvcAmtPrevPaid + ", " : "")
				+ (partySrvcAmtSettled != null ? "partySrvcAmtSettled=" + partySrvcAmtSettled + ", " : "")
				+ (partySrvcDetails != null ? "partySrvcDetails=" + partySrvcDetails + ", " : "")
				+ (partyInvInternalStatus != null ? "partyInvInternalStatus=" + partyInvInternalStatus + ", " : "")
				+ (partyInvExternalStatus != null ? "partyInvExternalStatus=" + partyInvExternalStatus + ", " : "")
				+ (partyInvDate != null ? "partyInvDate=" + partyInvDate + ", " : "")
				+ (partyRemitanceAcctDts != null ? "partyRemitanceAcctDts=" + partyRemitanceAcctDts + ", " : "")
				+ (partyInvApporval != null ? "partyInvApporval=" + partyInvApporval + ", " : "")
				+ (collectionType != null ? "collectionType=" + collectionType + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}
}
