package com.serole.claims.model.Elseco;

import java.math.BigDecimal;
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

import com.serole.claims.model.ClaimsItems;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_MemberInfo_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoMemberInfo extends ClaimsItems {
	public ElsecoMemberInfo(){  }
	  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private int memberId;   					//MEMBER_ID
	
	@Column(name = "STAMP_ID")
	private int stampId;   						//STAMP_ID
	
	@Column(name = "INTREF_ID")
	private int intRefId;   					//INTREF_ID
	
	@Column(name = "POLICY_TRANSACTION_ID")		//POLICY_TRANSACTION_ID
	private int policyTransactionId; 
	
	@Column(name = "MARKET_TRANSACTION_ID")		//MARKET_TRANSACTION_ID
	private int marketTransactionId; 
	
	@Column(name = "CLAIM_ID")
	private int claimId;   						//CLAIM_ID
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId;   				//CLAIM_HEADER_ID	
	
	@Column(name = "MEMBER_BP_ID")
	private int memberBpId;   				//MEMBER_BP_ID
	
	@Column(name = "STAMP_NAME")
	private String stampName  = "";   			//STAMP_NAME	
	
	@Column(name = "STAMPSTART_DT")
	private Date stampStartDate; 				//STAMPSTART_DT
	
	@Column(name = "STAMPEND_DT")
	private Date stampEndDate;   				//STAMPEND_DT	
		
	@Column(name = "STAMPSTATUS_ID")
	private int stampStatusId; 					//STAMPSTATUS_ID	
	
	@Column(name = "STAMP_DESCRIPTION")
	private String stampDescription  = ""; 		//STAMP_DESCRIPTION		 
	
	@Column(name = "COLLECTION_TYPE")			//COLLECTION_TYPE
	private String collectionType = "";
	
	@Column(name = "SPLIT_CLAIM_PERC_VL")
	private String splitClaimPercVl  = "";	//"SPLIT_CLAIM_PERC_VL"
	
	@Column(name = "SPLIT_CLAIM_PERC_AMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal splitClaimPercAmt ;		//"SPLIT_CLAIM_PERC_AMT"
	
	@Column(name = "FRONTIER")
	private String frontier  = ""; 				//FRONTIER
	
	@Column(name = "TRANSACTIONING")
	private String transactioning  = ""; 		//TRANSACTIONING
	
	@Column(name = "PAYER_ID")
	private String payerId  = ""; 				//PAYER_ID
	
	@Column(name = "PAYER_NAME")
	private String payerName  = ""; 			//PAYER_NAME
	
	@Column(name = "CREATEDON")
	private Date createdOn; 					//CREATEDON	
	
	@Column(name = "APPROVEDON")
	private Date approvedOn; 					//APPROVEDON	
	
	@Column(name = "CREATEDBY")
	private String createdBy  = ""; 			//CREATEDBY	
	
	@Column(name = "SUBMITTEDBY")
	private String submittedBy  = ""; 			//SUBMITTEDBY	
			
	@Column(name = "SUBMITTEDON")
	private Date submittedOn; 					//SUBMITTEDON
	
	@Column(name = "APPROVEDBY")
	private String approvedBy  = ""; 			//APPROVEDBY
	
	@Column(name = "POOLUWY_ID")
	private String poolUWYId  = ""; 			//POOLUWY_ID
	
	@Column(name = "PREVPDCLAMT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtIndemnityMI;  				//PREVPDCLAMT_INDEMNITY
	
	@Column(name = "PREVPDCLAMT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtFeesMI;  						//PREVPDCLAMT_FEES
	
	@Column(name = "PREVPDCLAMT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtExpensesMI;  					//PREVPDCLAMT_EXPENSES
	
	@Column(name = "SETLMNTCLAMT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtIndemnityMI;				//SETLMNTCLAMT_INDEMNITY
	
	@Column(name = "SETLMNTCLAMT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtFeesMI;						//SETLMNTCLAMT_FEES
	
	@Column(name = "SETLMNTCLAMT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtExpensesMI;					//SETLMNTCLAMT_EXPENSES
	
	@Column(name = "RESERVEAMOUNT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountIndemnityMI;  				//RESERVEAMOUNT_INDEMNITY
	
	@Column(name = "RESERVEAMOUNT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountFeesMI; 					//RESERVEAMOUNT_FEES
	
	@Column(name = "RESERVEAMOUNT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountExpensesMI;					//RESERVEAMOUNT_EXPENSES
		
	@Column(name = "AVAILCLM_FUND", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal availableClmFund;						//AVAILCLM_FUND
	
	@Column(name = "AVAILOFFSET_PRMIUM", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal availableOffSetPrm;						//AVAILOFFSET_PRMIUM 
	
	@Column(name = "MEMBER_NAME")
	private String memberName  = ""; 							//MEMBER_NAME
	
	@Column(name = "MEMBER_EMAIL")
	private String memberEmail  = ""; 							//MEMBER_EMAIL
	
	@Column(name = "DUE_DATE")
	private Date dueDate;										//DUE_DATE
	
	@Column(name = "COLLECTED_DATE")
	private Date collectedDate;									//COLLECTED_DATE
	
	@Column(name = "STATUS")									//STATUS
	private String status = "";
			
	@Column(name = "IS_COLLECTED")								//IS_COLLECTED
	private String isCollected = "";

	@Column(name = "NOTIFY_ENABLED")							//NOTIFY_ENABLED
	private String notifyEnabled = "";	
	
	@Transient
	private List<ElsecoMemberResult> MemberResultsInfo; 		//memberResultsInfo

	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 			//DELETE_FLAG

	/**
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the stampId
	 */
	public int getStampId() {
		return stampId;
	}

	/**
	 * @param stampId the stampId to set
	 */
	public void setStampId(int stampId) {
		this.stampId = stampId;
	}

	/**
	 * @return the intRefId
	 */
	public int getIntRefId() {
		return intRefId;
	}

	/**
	 * @param intRefId the intRefId to set
	 */
	public void setIntRefId(int intRefId) {
		this.intRefId = intRefId;
	}

	/**
	 * @return the policyTransactionId
	 */
	public int getPolicyTransactionId() {
		return policyTransactionId;
	}

	/**
	 * @param policyTransactionId the policyTransactionId to set
	 */
	public void setPolicyTransactionId(int policyTransactionId) {
		this.policyTransactionId = policyTransactionId;
	}

	/**
	 * @return the marketTransactionId
	 */
	public int getMarketTransactionId() {
		return marketTransactionId;
	}

	/**
	 * @param marketTransactionId the marketTransactionId to set
	 */
	public void setMarketTransactionId(int marketTransactionId) {
		this.marketTransactionId = marketTransactionId;
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
	 * @return the stampName
	 */
	public String getStampName() {
		return stampName;
	}

	/**
	 * @param stampName the stampName to set
	 */
	public void setStampName(String stampName) {
		this.stampName = stampName;
	}

	/**
	 * @return the stampStartDate
	 */
	public Date getStampStartDate() {
		return stampStartDate;
	}

	/**
	 * @param stampStartDate the stampStartDate to set
	 */
	public void setStampStartDate(Date stampStartDate) {
		this.stampStartDate = stampStartDate;
	}

	/**
	 * @return the stampEndDate
	 */
	public Date getStampEndDate() {
		return stampEndDate;
	}

	/**
	 * @param stampEndDate the stampEndDate to set
	 */
	public void setStampEndDate(Date stampEndDate) {
		this.stampEndDate = stampEndDate;
	}

	/**
	 * @return the stampStatusId
	 */
	public int getStampStatusId() {
		return stampStatusId;
	}

	/**
	 * @param stampStatusId the stampStatusId to set
	 */
	public void setStampStatusId(int stampStatusId) {
		this.stampStatusId = stampStatusId;
	}

	/**
	 * @return the stampDescription
	 */
	public String getStampDescription() {
		return stampDescription;
	}

	/**
	 * @param stampDescription the stampDescription to set
	 */
	public void setStampDescription(String stampDescription) {
		this.stampDescription = stampDescription;
	}

	/**
	 * @return the isCollected
	 */
	public String getIsCollected() {
		return isCollected;
	}

	/**
	 * @param isCollected the isCollected to set
	 */
	public void setIsCollected(String isCollected) {
		this.isCollected = isCollected;
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

	/**
	 * @return the splitClaimPercVl
	 */
	public String getSplitClaimPercVl() {
		return splitClaimPercVl;
	}

	/**
	 * @param splitClaimPercVl the splitClaimPercVl to set
	 */
	public void setSplitClaimPercVl(String splitClaimPercVl) {
		this.splitClaimPercVl = splitClaimPercVl;
	}

	/**
	 * @return the splitClaimPercAmt
	 */
	public BigDecimal getSplitClaimPercAmt() {
		return splitClaimPercAmt;
	}

	/**
	 * @param splitClaimPercAmt the splitClaimPercAmt to set
	 */
	public void setSplitClaimPercAmt(BigDecimal splitClaimPercAmt) {
		this.splitClaimPercAmt = splitClaimPercAmt;
	}

	/**
	 * @return the frontier
	 */
	public String getFrontier() {
		return frontier;
	}

	/**
	 * @param frontier the frontier to set
	 */
	public void setFrontier(String frontier) {
		this.frontier = frontier;
	}

	/**
	 * @return the transactioning
	 */
	public String getTransactioning() {
		return transactioning;
	}

	/**
	 * @param transactioning the transactioning to set
	 */
	public void setTransactioning(String transactioning) {
		this.transactioning = transactioning;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the approvedOn
	 */
	public Date getApprovedOn() {
		return approvedOn;
	}

	/**
	 * @param approvedOn the approvedOn to set
	 */
	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
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
	 * @return the submittedBy
	 */
	public String getSubmittedBy() {
		return submittedBy;
	}

	/**
	 * @param submittedBy the submittedBy to set
	 */
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	/**
	 * @return the submittedOn
	 */
	public Date getSubmittedOn() {
		return submittedOn;
	}

	/**
	 * @param submittedOn the submittedOn to set
	 */
	public void setSubmittedOn(Date submittedOn) {
		this.submittedOn = submittedOn;
	}

	/**
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * @return the poolUWYId
	 */
	public String getPoolUWYId() {
		return poolUWYId;
	}

	/**
	 * @param poolUWYId the poolUWYId to set
	 */
	public void setPoolUWYId(String poolUWYId) {
		this.poolUWYId = poolUWYId;
	}

	/**
	 * @return the prevpaidAmtIndemnityMI
	 */
	public BigDecimal getPrevpaidAmtIndemnityMI() {
		return prevpaidAmtIndemnityMI;
	}

	/**
	 * @param prevpaidAmtIndemnityMI the prevpaidAmtIndemnityMI to set
	 */
	public void setPrevpaidAmtIndemnityMI(BigDecimal prevpaidAmtIndemnityMI) {
		this.prevpaidAmtIndemnityMI = prevpaidAmtIndemnityMI;
	}

	/**
	 * @return the prevpaidAmtFeesMI
	 */
	public BigDecimal getPrevpaidAmtFeesMI() {
		return prevpaidAmtFeesMI;
	}

	/**
	 * @param prevpaidAmtFeesMI the prevpaidAmtFeesMI to set
	 */
	public void setPrevpaidAmtFeesMI(BigDecimal prevpaidAmtFeesMI) {
		this.prevpaidAmtFeesMI = prevpaidAmtFeesMI;
	}

	/**
	 * @return the prevpaidAmtExpensesMI
	 */
	public BigDecimal getPrevpaidAmtExpensesMI() {
		return prevpaidAmtExpensesMI;
	}

	/**
	 * @param prevpaidAmtExpensesMI the prevpaidAmtExpensesMI to set
	 */
	public void setPrevpaidAmtExpensesMI(BigDecimal prevpaidAmtExpensesMI) {
		this.prevpaidAmtExpensesMI = prevpaidAmtExpensesMI;
	}

	/**
	 * @return the settlementAmtIndemnityMI
	 */
	public BigDecimal getSettlementAmtIndemnityMI() {
		return settlementAmtIndemnityMI;
	}

	/**
	 * @param settlementAmtIndemnityMI the settlementAmtIndemnityMI to set
	 */
	public void setSettlementAmtIndemnityMI(BigDecimal settlementAmtIndemnityMI) {
		this.settlementAmtIndemnityMI = settlementAmtIndemnityMI;
	}

	/**
	 * @return the settlementAmtFeesMI
	 */
	public BigDecimal getSettlementAmtFeesMI() {
		return settlementAmtFeesMI;
	}

	/**
	 * @param settlementAmtFeesMI the settlementAmtFeesMI to set
	 */
	public void setSettlementAmtFeesMI(BigDecimal settlementAmtFeesMI) {
		this.settlementAmtFeesMI = settlementAmtFeesMI;
	}

	/**
	 * @return the settlementAmtExpensesMI
	 */
	public BigDecimal getSettlementAmtExpensesMI() {
		return settlementAmtExpensesMI;
	}

	/**
	 * @param settlementAmtExpensesMI the settlementAmtExpensesMI to set
	 */
	public void setSettlementAmtExpensesMI(BigDecimal settlementAmtExpensesMI) {
		this.settlementAmtExpensesMI = settlementAmtExpensesMI;
	}

	/**
	 * @return the reserveAmountIndemnityMI
	 */
	public BigDecimal getReserveAmountIndemnityMI() {
		return reserveAmountIndemnityMI;
	}

	/**
	 * @param reserveAmountIndemnityMI the reserveAmountIndemnityMI to set
	 */
	public void setReserveAmountIndemnityMI(BigDecimal reserveAmountIndemnityMI) {
		this.reserveAmountIndemnityMI = reserveAmountIndemnityMI;
	}

	/**
	 * @return the reserveAmountFeesMI
	 */
	public BigDecimal getReserveAmountFeesMI() {
		return reserveAmountFeesMI;
	}

	/**
	 * @param reserveAmountFeesMI the reserveAmountFeesMI to set
	 */
	public void setReserveAmountFeesMI(BigDecimal reserveAmountFeesMI) {
		this.reserveAmountFeesMI = reserveAmountFeesMI;
	}

	/**
	 * @return the reserveAmountExpensesMI
	 */
	public BigDecimal getReserveAmountExpensesMI() {
		return reserveAmountExpensesMI;
	}

	/**
	 * @param reserveAmountExpensesMI the reserveAmountExpensesMI to set
	 */
	public void setReserveAmountExpensesMI(BigDecimal reserveAmountExpensesMI) {
		this.reserveAmountExpensesMI = reserveAmountExpensesMI;
	}

	/**
	 * @return the memberResultsInfo
	 */
	public List<ElsecoMemberResult> getMemberResultsInfo() {
		return MemberResultsInfo;
	}

	/**
	 * @param memberResultsInfo the memberResultsInfo to set
	 */
	public void setMemberResultsInfo(List<ElsecoMemberResult> memberResultsInfo) {
		MemberResultsInfo = memberResultsInfo;
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

	/**
	 * @return the availableClmFund
	 */
	public BigDecimal getAvailableClmFund() {
		return availableClmFund;
	}

	/**
	 * @param availableClmFund the availableClmFund to set
	 */
	public void setAvailableClmFund(BigDecimal availableClmFund) {
		this.availableClmFund = availableClmFund;
	}

	/**
	 * @return the availableOffSetPrm
	 */
	public BigDecimal getAvailableOffSetPrm() {
		return availableOffSetPrm;
	}

	/**
	 * @param availableOffSetPrm the availableOffSetPrm to set
	 */
	public void setAvailableOffSetPrm(BigDecimal availableOffSetPrm) {
		this.availableOffSetPrm = availableOffSetPrm;
	}

	/**
	 * @return the notifyEnabled
	 */
	public String getNotifyEnabled() {
		return notifyEnabled;
	}

	/**
	 * @param notifyEnabled the notifyEnabled to set
	 */
	public void setNotifyEnabled(String notifyEnabled) {
		this.notifyEnabled = notifyEnabled;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the memberEmail
	 */
	public String getMemberEmail() {
		return memberEmail;
	}

	/**
	 * @param memberEmail the memberEmail to set
	 */
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the collectedDate
	 */
	public Date getCollectedDate() {
		return collectedDate;
	}

	/**
	 * @param collectedDate the collectedDate to set
	 */
	public void setCollectedDate(Date collectedDate) {
		this.collectedDate = collectedDate;
	}

	/**
	 * @return the memberBpId
	 */
	public int getMemberBpId() {
		return memberBpId;
	}

	/**
	 * @param memberBpId the memberBpId to set
	 */
	public void setMemberBpId(int memberBpId) {
		this.memberBpId = memberBpId;
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
	 * @return the payerId
	 */
	public String getPayerId() {
		return payerId;
	}

	/**
	 * @param payerId the payerId to set
	 */
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	/**
	 * @return the payerName
	 */
	public String getPayerName() {
		return payerName;
	}

	/**
	 * @param payerName the payerName to set
	 */
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoMemberInfo [memberId=" + memberId + ", stampId=" + stampId + ", intRefId=" + intRefId
				+ ", policyTransactionId=" + policyTransactionId + ", marketTransactionId=" + marketTransactionId
				+ ", claimId=" + claimId + ", claimHeaderId=" + claimHeaderId + ", memberBpId=" + memberBpId + ", "
				+ (stampName != null ? "stampName=" + stampName + ", " : "")
				+ (stampStartDate != null ? "stampStartDate=" + stampStartDate + ", " : "")
				+ (stampEndDate != null ? "stampEndDate=" + stampEndDate + ", " : "") + "stampStatusId=" + stampStatusId
				+ ", " + (stampDescription != null ? "stampDescription=" + stampDescription + ", " : "")
				+ (collectionType != null ? "collectionType=" + collectionType + ", " : "")
				+ (splitClaimPercVl != null ? "splitClaimPercVl=" + splitClaimPercVl + ", " : "")
				+ (splitClaimPercAmt != null ? "splitClaimPercAmt=" + splitClaimPercAmt + ", " : "")
				+ (frontier != null ? "frontier=" + frontier + ", " : "")
				+ (transactioning != null ? "transactioning=" + transactioning + ", " : "")
				+ (payerId != null ? "payerId=" + payerId + ", " : "")
				+ (payerName != null ? "payerName=" + payerName + ", " : "")
				+ (createdOn != null ? "createdOn=" + createdOn + ", " : "")
				+ (approvedOn != null ? "approvedOn=" + approvedOn + ", " : "")
				+ (createdBy != null ? "createdBy=" + createdBy + ", " : "")
				+ (submittedBy != null ? "submittedBy=" + submittedBy + ", " : "")
				+ (submittedOn != null ? "submittedOn=" + submittedOn + ", " : "")
				+ (approvedBy != null ? "approvedBy=" + approvedBy + ", " : "")
				+ (poolUWYId != null ? "poolUWYId=" + poolUWYId + ", " : "")
				+ (prevpaidAmtIndemnityMI != null ? "prevpaidAmtIndemnityMI=" + prevpaidAmtIndemnityMI + ", " : "")
				+ (prevpaidAmtFeesMI != null ? "prevpaidAmtFeesMI=" + prevpaidAmtFeesMI + ", " : "")
				+ (prevpaidAmtExpensesMI != null ? "prevpaidAmtExpensesMI=" + prevpaidAmtExpensesMI + ", " : "")
				+ (settlementAmtIndemnityMI != null ? "settlementAmtIndemnityMI=" + settlementAmtIndemnityMI + ", "
						: "")
				+ (settlementAmtFeesMI != null ? "settlementAmtFeesMI=" + settlementAmtFeesMI + ", " : "")
				+ (settlementAmtExpensesMI != null ? "settlementAmtExpensesMI=" + settlementAmtExpensesMI + ", " : "")
				+ (reserveAmountIndemnityMI != null ? "reserveAmountIndemnityMI=" + reserveAmountIndemnityMI + ", "
						: "")
				+ (reserveAmountFeesMI != null ? "reserveAmountFeesMI=" + reserveAmountFeesMI + ", " : "")
				+ (reserveAmountExpensesMI != null ? "reserveAmountExpensesMI=" + reserveAmountExpensesMI + ", " : "")
				+ (availableClmFund != null ? "availableClmFund=" + availableClmFund + ", " : "")
				+ (availableOffSetPrm != null ? "availableOffSetPrm=" + availableOffSetPrm + ", " : "")
				+ (memberName != null ? "memberName=" + memberName + ", " : "")
				+ (memberEmail != null ? "memberEmail=" + memberEmail + ", " : "")
				+ (dueDate != null ? "dueDate=" + dueDate + ", " : "")
				+ (collectedDate != null ? "collectedDate=" + collectedDate + ", " : "")
				+ (status != null ? "status=" + status + ", " : "")
				+ (isCollected != null ? "isCollected=" + isCollected + ", " : "")
				+ (notifyEnabled != null ? "notifyEnabled=" + notifyEnabled + ", " : "")
				+ (MemberResultsInfo != null ? "MemberResultsInfo=" + MemberResultsInfo + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}
