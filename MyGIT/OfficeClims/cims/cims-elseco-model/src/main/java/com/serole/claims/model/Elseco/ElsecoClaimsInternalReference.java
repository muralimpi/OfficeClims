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


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_InternalReference_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsInternalReference{            
	public ElsecoClaimsInternalReference(){  }
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "INTREF_ID")
	private int intRefId;   						//INTREF_ID	
	
	@Column(name = "STAMP_ID")						//STAMP_ID
	private int stampId;  		
	
	@Column(name = "CLAIM_ID")						//CLAIM_ID
	private int claimId;   		
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId;   					//CLAIM_HEADER_ID
	
	@Column(name = "POLICY_TRANSACTION_ID")			//POLICY_TRANSACTION_ID
	private int policyTransactionId; 
	
	@Column(name = "MARKET_TRANSACTION_ID")			//MARKET_TRANSACTION_ID
	private int marketTransactionId; 
			
	@Column(name = "ELSECO_RISK_CD")				//ELSECO_RISK_CD
	private String elsecoRiskCode = ""; 				
		
	@Column(name = "INTERNAL_REFERENCE_NO")			//INTERNAL_REFERENCE_NO
	private String intReferenceNo = "";  	
	
	@Column(name = "SPLIT_CLAIM_PERC_VL")
	private String splitClaimPercVl  = "";			//"SPLIT_CLAIM_PERC_VL"
	
	@Column(name = "SPLIT_CLAIM_PERC_AMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal splitClaimPercAmt ;			//"SPLIT_CLAIM_PERC_AMT"
	
	@Column(name = "PREMIUM_SPLIT_VL")				//PREMIUM_SPLIT_VL
	private String premiumSplitVl = "";  	
		
	@Column(name = "STAMP_NAME")					//STAMP_NAME
	private String stampName = ""; 
	
	@Column(name = "FUNDS_COLLECTED")				//FUNDS_COLLECTED
	private String fundsCollected = ""; 
	
	@Column(name = "IS_COLLECTED")					//IS_COLLECTED
	private String isCollected = ""; 
	
	@Column(name = "COLLECT_PAY_ENABLED")			//COLLECT_PAY_ENABLED
	private String collectPayEnabled  = ""; 
	
	@Column(name = "TRANSACTIONTYPE")				//TRANSACTIONTYPE
	private String transactionType = "";  	
	
	@Column(name = "TRANSACTIONSUBTYPE")			//TRANSACTIONSUBTYPE
	private String transactionSubType = "";  	
		
	@Column(name = "NWINCURDCLAMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal nwincurdclamt;  				//NWINCURDCLAMT	
		
	@Column(name = "SETLMNTCLAMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal setlmntclamt;
	
	@Column(name = "COMMENT")						//COMMENT
	private String comment = "";  	
	
	@Column(name = "PREVPDCLAMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpdclamt;  				//PREVPDCLAMT	
	
	@Column(name = "ORIGINALCURRENCY")				//ORIGINALCURRENCY
	private String originalCurrency = "";
		
	@Column(name = "DUEDATE")
	private Date dueDate = null;  					//DUEDATE
		
	@Column(name = "PREVPDCLAMT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtIndemnityIR;  				//PREVPDCLAMT_INDEMNITY
	
	@Column(name = "PREVPDCLAMT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtFeesIR;  					//PREVPDCLAMT_FEES
	
	@Column(name = "PREVPDCLAMT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtExpensesIR;  				//PREVPDCLAMT_EXPENSES
	
	@Column(name = "SETLMNTCLAMT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtIndemnityIR;				//SETLMNTCLAMT_INDEMNITY
	
	@Column(name = "SETLMNTCLAMT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtFeesIR;					//SETLMNTCLAMT_FEES
	
	@Column(name = "SETLMNTCLAMT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtExpensesIR;				//SETLMNTCLAMT_EXPENSES
	
	@Column(name = "RESERVEAMOUNT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountIndemnityIR ;  			//RESERVEAMOUNT_INDEMNITY
	
	@Column(name = "RESERVEAMOUNT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountFeesIR ; 					//RESERVEAMOUNT_FEES
	
	@Column(name = "RESERVEAMOUNT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountExpensesIR;				//RESERVEAMOUNT_EXPENSES
	
	@Column(name = "DELETEFLAG")					//DELETE_FLAG
	private String deleteFlag  = "";
		
	@Transient
	private List<ElsecoMemberInfo> memberInfo; 		//Include Member Info under Internal Reference
	
	@Transient
	private List<ElsecoHybrisPayHistory> hybrisPayHistoryInfo; 		//Include Hybris Payment History under Internal Reference

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
	 * @return the elsecoRiskCode
	 */
	public String getElsecoRiskCode() {
		return elsecoRiskCode;
	}

	/**
	 * @param elsecoRiskCode the elsecoRiskCode to set
	 */
	public void setElsecoRiskCode(String elsecoRiskCode) {
		this.elsecoRiskCode = elsecoRiskCode;
	}

	/**
	 * @return the intReferenceNo
	 */
	public String getIntReferenceNo() {
		return intReferenceNo;
	}

	/**
	 * @param intReferenceNo the intReferenceNo to set
	 */
	public void setIntReferenceNo(String intReferenceNo) {
		this.intReferenceNo = intReferenceNo;
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
	 * @return the premiumSplitVl
	 */
	public String getPremiumSplitVl() {
		return premiumSplitVl;
	}

	/**
	 * @param premiumSplitVl the premiumSplitVl to set
	 */
	public void setPremiumSplitVl(String premiumSplitVl) {
		this.premiumSplitVl = premiumSplitVl;
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
	 * @return the fundsCollected
	 */
	public String getFundsCollected() {
		return fundsCollected;
	}

	/**
	 * @param fundsCollected the fundsCollected to set
	 */
	public void setFundsCollected(String fundsCollected) {
		this.fundsCollected = fundsCollected;
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
	 * @return the collectPayEnabled
	 */
	public String getCollectPayEnabled() {
		return collectPayEnabled;
	}

	/**
	 * @param collectPayEnabled the collectPayEnabled to set
	 */
	public void setCollectPayEnabled(String collectPayEnabled) {
		this.collectPayEnabled = collectPayEnabled;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionSubType
	 */
	public String getTransactionSubType() {
		return transactionSubType;
	}

	/**
	 * @param transactionSubType the transactionSubType to set
	 */
	public void setTransactionSubType(String transactionSubType) {
		this.transactionSubType = transactionSubType;
	}

	/**
	 * @return the nwincurdclamt
	 */
	public BigDecimal getNwincurdclamt() {
		return nwincurdclamt;
	}

	/**
	 * @param nwincurdclamt the nwincurdclamt to set
	 */
	public void setNwincurdclamt(BigDecimal nwincurdclamt) {
		this.nwincurdclamt = nwincurdclamt;
	}

	/**
	 * @return the setlmntclamt
	 */
	public BigDecimal getSetlmntclamt() {
		return setlmntclamt;
	}

	/**
	 * @param setlmntclamt the setlmntclamt to set
	 */
	public void setSetlmntclamt(BigDecimal setlmntclamt) {
		this.setlmntclamt = setlmntclamt;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the prevpdclamt
	 */
	public BigDecimal getPrevpdclamt() {
		return prevpdclamt;
	}

	/**
	 * @param prevpdclamt the prevpdclamt to set
	 */
	public void setPrevpdclamt(BigDecimal prevpdclamt) {
		this.prevpdclamt = prevpdclamt;
	}

	/**
	 * @return the originalCurrency
	 */
	public String getOriginalCurrency() {
		return originalCurrency;
	}

	/**
	 * @param originalCurrency the originalCurrency to set
	 */
	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
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
	 * @return the prevpaidAmtIndemnityIR
	 */
	public BigDecimal getPrevpaidAmtIndemnityIR() {
		return prevpaidAmtIndemnityIR;
	}

	/**
	 * @param prevpaidAmtIndemnityIR the prevpaidAmtIndemnityIR to set
	 */
	public void setPrevpaidAmtIndemnityIR(BigDecimal prevpaidAmtIndemnityIR) {
		this.prevpaidAmtIndemnityIR = prevpaidAmtIndemnityIR;
	}

	/**
	 * @return the prevpaidAmtFeesIR
	 */
	public BigDecimal getPrevpaidAmtFeesIR() {
		return prevpaidAmtFeesIR;
	}

	/**
	 * @param prevpaidAmtFeesIR the prevpaidAmtFeesIR to set
	 */
	public void setPrevpaidAmtFeesIR(BigDecimal prevpaidAmtFeesIR) {
		this.prevpaidAmtFeesIR = prevpaidAmtFeesIR;
	}

	/**
	 * @return the prevpaidAmtExpensesIR
	 */
	public BigDecimal getPrevpaidAmtExpensesIR() {
		return prevpaidAmtExpensesIR;
	}

	/**
	 * @param prevpaidAmtExpensesIR the prevpaidAmtExpensesIR to set
	 */
	public void setPrevpaidAmtExpensesIR(BigDecimal prevpaidAmtExpensesIR) {
		this.prevpaidAmtExpensesIR = prevpaidAmtExpensesIR;
	}

	/**
	 * @return the settlementAmtIndemnityIR
	 */
	public BigDecimal getSettlementAmtIndemnityIR() {
		return settlementAmtIndemnityIR;
	}

	/**
	 * @param settlementAmtIndemnityIR the settlementAmtIndemnityIR to set
	 */
	public void setSettlementAmtIndemnityIR(BigDecimal settlementAmtIndemnityIR) {
		this.settlementAmtIndemnityIR = settlementAmtIndemnityIR;
	}

	/**
	 * @return the settlementAmtFeesIR
	 */
	public BigDecimal getSettlementAmtFeesIR() {
		return settlementAmtFeesIR;
	}

	/**
	 * @param settlementAmtFeesIR the settlementAmtFeesIR to set
	 */
	public void setSettlementAmtFeesIR(BigDecimal settlementAmtFeesIR) {
		this.settlementAmtFeesIR = settlementAmtFeesIR;
	}

	/**
	 * @return the settlementAmtExpensesIR
	 */
	public BigDecimal getSettlementAmtExpensesIR() {
		return settlementAmtExpensesIR;
	}

	/**
	 * @param settlementAmtExpensesIR the settlementAmtExpensesIR to set
	 */
	public void setSettlementAmtExpensesIR(BigDecimal settlementAmtExpensesIR) {
		this.settlementAmtExpensesIR = settlementAmtExpensesIR;
	}

	/**
	 * @return the reserveAmountIndemnityIR
	 */
	public BigDecimal getReserveAmountIndemnityIR() {
		return reserveAmountIndemnityIR;
	}

	/**
	 * @param reserveAmountIndemnityIR the reserveAmountIndemnityIR to set
	 */
	public void setReserveAmountIndemnityIR(BigDecimal reserveAmountIndemnityIR) {
		this.reserveAmountIndemnityIR = reserveAmountIndemnityIR;
	}

	/**
	 * @return the reserveAmountFeesIR
	 */
	public BigDecimal getReserveAmountFeesIR() {
		return reserveAmountFeesIR;
	}

	/**
	 * @param reserveAmountFeesIR the reserveAmountFeesIR to set
	 */
	public void setReserveAmountFeesIR(BigDecimal reserveAmountFeesIR) {
		this.reserveAmountFeesIR = reserveAmountFeesIR;
	}

	/**
	 * @return the reserveAmountExpensesIR
	 */
	public BigDecimal getReserveAmountExpensesIR() {
		return reserveAmountExpensesIR;
	}

	/**
	 * @param reserveAmountExpensesIR the reserveAmountExpensesIR to set
	 */
	public void setReserveAmountExpensesIR(BigDecimal reserveAmountExpensesIR) {
		this.reserveAmountExpensesIR = reserveAmountExpensesIR;
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
	 * @return the memberInfo
	 */
	public List<ElsecoMemberInfo> getMemberInfo() {
		return memberInfo;
	}

	/**
	 * @param memberInfo the memberInfo to set
	 */
	public void setMemberInfo(List<ElsecoMemberInfo> memberInfo) {
		this.memberInfo = memberInfo;
	}

	/**
	 * @return the hybrisPayHistoryInfo
	 */
	public List<ElsecoHybrisPayHistory> getHybrisPayHistoryInfo() {
		return hybrisPayHistoryInfo;
	}

	/**
	 * @param hybrisPayHistoryInfo the hybrisPayHistoryInfo to set
	 */
	public void setHybrisPayHistoryInfo(List<ElsecoHybrisPayHistory> hybrisPayHistoryInfo) {
		this.hybrisPayHistoryInfo = hybrisPayHistoryInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimsInternalReference [intRefId=" + intRefId + ", stampId=" + stampId + ", claimId=" + claimId
				+ ", claimHeaderId=" + claimHeaderId + ", policyTransactionId=" + policyTransactionId
				+ ", marketTransactionId=" + marketTransactionId + ", "
				+ (elsecoRiskCode != null ? "elsecoRiskCode=" + elsecoRiskCode + ", " : "")
				+ (intReferenceNo != null ? "intReferenceNo=" + intReferenceNo + ", " : "")
				+ (splitClaimPercVl != null ? "splitClaimPercVl=" + splitClaimPercVl + ", " : "")
				+ (splitClaimPercAmt != null ? "splitClaimPercAmt=" + splitClaimPercAmt + ", " : "")
				+ (premiumSplitVl != null ? "premiumSplitVl=" + premiumSplitVl + ", " : "")
				+ (stampName != null ? "stampName=" + stampName + ", " : "")
				+ (fundsCollected != null ? "fundsCollected=" + fundsCollected + ", " : "")
				+ (isCollected != null ? "isCollected=" + isCollected + ", " : "")
				+ (collectPayEnabled != null ? "collectPayEnabled=" + collectPayEnabled + ", " : "")
				+ (transactionType != null ? "transactionType=" + transactionType + ", " : "")
				+ (transactionSubType != null ? "transactionSubType=" + transactionSubType + ", " : "")
				+ (nwincurdclamt != null ? "nwincurdclamt=" + nwincurdclamt + ", " : "")
				+ (setlmntclamt != null ? "setlmntclamt=" + setlmntclamt + ", " : "")
				+ (comment != null ? "comment=" + comment + ", " : "")
				+ (prevpdclamt != null ? "prevpdclamt=" + prevpdclamt + ", " : "")
				+ (originalCurrency != null ? "originalCurrency=" + originalCurrency + ", " : "")
				+ (dueDate != null ? "dueDate=" + dueDate + ", " : "")
				+ (prevpaidAmtIndemnityIR != null ? "prevpaidAmtIndemnityIR=" + prevpaidAmtIndemnityIR + ", " : "")
				+ (prevpaidAmtFeesIR != null ? "prevpaidAmtFeesIR=" + prevpaidAmtFeesIR + ", " : "")
				+ (prevpaidAmtExpensesIR != null ? "prevpaidAmtExpensesIR=" + prevpaidAmtExpensesIR + ", " : "")
				+ (settlementAmtIndemnityIR != null ? "settlementAmtIndemnityIR=" + settlementAmtIndemnityIR + ", "
						: "")
				+ (settlementAmtFeesIR != null ? "settlementAmtFeesIR=" + settlementAmtFeesIR + ", " : "")
				+ (settlementAmtExpensesIR != null ? "settlementAmtExpensesIR=" + settlementAmtExpensesIR + ", " : "")
				+ (reserveAmountIndemnityIR != null ? "reserveAmountIndemnityIR=" + reserveAmountIndemnityIR + ", "
						: "")
				+ (reserveAmountFeesIR != null ? "reserveAmountFeesIR=" + reserveAmountFeesIR + ", " : "")
				+ (reserveAmountExpensesIR != null ? "reserveAmountExpensesIR=" + reserveAmountExpensesIR + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag + ", " : "")
				+ (memberInfo != null ? "memberInfo=" + memberInfo + ", " : "")
				+ (hybrisPayHistoryInfo != null ? "hybrisPayHistoryInfo=" + hybrisPayHistoryInfo : "") + "]";
	}	
}	