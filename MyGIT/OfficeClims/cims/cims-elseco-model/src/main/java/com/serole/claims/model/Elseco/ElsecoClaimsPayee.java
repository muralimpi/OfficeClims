package com.serole.claims.model.Elseco;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimPayee_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsPayee {

	public ElsecoClaimsPayee() { }
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PAYEE_ID")
	private int payeeId;  
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId; 
	
	@Column(name = "CLAIM_ID")
	private int claimId; 
	
	@Column(name = "CLAIM_TRANSACTION_ID")
	private int claimTransactionId;
		
	@Column(name = "UCR_NO")
	private String ucrNumber  = ""; 
	
	@Column(name = "EXTERNAL_REF_NO")
	private String extRefNo = ""; 
	
	@Column(name = "TRANSACTION_REF_NO")
	private String transRefNo = ""; 
	
	@Column(name = "PAYEE_BP_ID")
	private String payeeBpId;
	
	@Column(name = "PAYEE_NAME")
	private String payeeName  = ""; 
	
	@Column(name = "PAYEE_EMAIL")
	private String payeeEmail  = ""; 
	
	@Column(name = "PAYEE_ACCOUNT")
	private String payeeAccount  = "";
	
	@Column(name = "PAYEE_AMOUNT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal payeeAmount;
	
	@Column(name = "PAYEE_OUTSTNDING_AMOUNT")
	private String payeeOutStandingAmt= "";
	
	@Column(name = "PAYEE_CURRENCY")
	private String payeeCurrency = "";
	
	@Column(name = "PAYEE_TYPE")
	private String payeeType = "";
	
	@Column(name = "STATUS")
	private String status = "";

	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = "";

	/**
	 * @return the payeeId
	 */
	public int getPayeeId() {
		return payeeId;
	}

	/**
	 * @param payeeId the payeeId to set
	 */
	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
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
	 * @return the claimTransactionId
	 */
	public int getClaimTransactionId() {
		return claimTransactionId;
	}

	/**
	 * @param claimTransactionId the claimTransactionId to set
	 */
	public void setClaimTransactionId(int claimTransactionId) {
		this.claimTransactionId = claimTransactionId;
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
	 * @return the transRefNo
	 */
	public String getTransRefNo() {
		return transRefNo;
	}

	/**
	 * @param transRefNo the transRefNo to set
	 */
	public void setTransRefNo(String transRefNo) {
		this.transRefNo = transRefNo;
	}

	/**
	 * @return the payeeBpId
	 */
	public String getPayeeBpId() {
		return payeeBpId;
	}

	/**
	 * @param payeeBpId the payeeBpId to set
	 */
	public void setPayeeBpId(String payeeBpId) {
		this.payeeBpId = payeeBpId;
	}

	/**
	 * @return the payeeName
	 */
	public String getPayeeName() {
		return payeeName;
	}

	/**
	 * @param payeeName the payeeName to set
	 */
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	/**
	 * @return the payeeEmail
	 */
	public String getPayeeEmail() {
		return payeeEmail;
	}

	/**
	 * @param payeeEmail the payeeEmail to set
	 */
	public void setPayeeEmail(String payeeEmail) {
		this.payeeEmail = payeeEmail;
	}

	/**
	 * @return the payeeAccount
	 */
	public String getPayeeAccount() {
		return payeeAccount;
	}

	/**
	 * @param payeeAccount the payeeAccount to set
	 */
	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}	

	/**
	 * @return the payeeAmount
	 */
	public BigDecimal getPayeeAmount() {
		return payeeAmount;
	}

	/**
	 * @param payeeAmount the payeeAmount to set
	 */
	public void setPayeeAmount(BigDecimal payeeAmount) {
		this.payeeAmount = payeeAmount;
	}

	/**
	 * @return the payeeOutStandingAmt
	 */
	public String getPayeeOutStandingAmt() {
		return payeeOutStandingAmt;
	}

	/**
	 * @param payeeOutStandingAmt the payeeOutStandingAmt to set
	 */
	public void setPayeeOutStandingAmt(String payeeOutStandingAmt) {
		this.payeeOutStandingAmt = payeeOutStandingAmt;
	}

	/**
	 * @return the payeeCurrency
	 */
	public String getPayeeCurrency() {
		return payeeCurrency;
	}

	/**
	 * @param payeeCurrency the payeeCurrency to set
	 */
	public void setPayeeCurrency(String payeeCurrency) {
		this.payeeCurrency = payeeCurrency;
	}

	/**
	 * @return the payeeType
	 */
	public String getPayeeType() {
		return payeeType;
	}

	/**
	 * @param payeeType the payeeType to set
	 */
	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
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
		return "ElsecoClaimsPayee [payeeId=" + payeeId + ", claimHeaderId=" + claimHeaderId + ", claimId=" + claimId
				+ ", claimTransactionId=" + claimTransactionId + ", "
				+ (ucrNumber != null ? "ucrNumber=" + ucrNumber + ", " : "")
				+ (extRefNo != null ? "extRefNo=" + extRefNo + ", " : "")
				+ (transRefNo != null ? "transRefNo=" + transRefNo + ", " : "")
				+ (payeeBpId != null ? "payeeBpId=" + payeeBpId + ", " : "")
				+ (payeeName != null ? "payeeName=" + payeeName + ", " : "")
				+ (payeeEmail != null ? "payeeEmail=" + payeeEmail + ", " : "")
				+ (payeeAccount != null ? "payeeAccount=" + payeeAccount + ", " : "")
				+ (payeeAmount != null ? "payeeAmount=" + payeeAmount + ", " : "")
				+ (payeeOutStandingAmt != null ? "payeeOutStandingAmt=" + payeeOutStandingAmt + ", " : "")
				+ (payeeCurrency != null ? "payeeCurrency=" + payeeCurrency + ", " : "")
				+ (payeeType != null ? "payeeType=" + payeeType + ", " : "")
				+ (status != null ? "status=" + status + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}
