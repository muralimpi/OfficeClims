package com.serole.claims.model.Elseco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_HybrisPayHistory_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoHybrisPayHistory {
	public ElsecoHybrisPayHistory(){  }
	  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PAYHISTORY_ID")
	private String payHistoryId;   					//PAYHISTORY_ID
	
	@Column(name = "CLAIM_HEADER_ID")
	private String claimHeaderId;   				//CLAIM_HEADER_ID	
	
	@Column(name = "CLAIM_DETAIL_ID")
	private String claimDetailId;   				//CLAIM_DETAIL_ID
	
	@Column(name = "CLAIM_TRANSACTION_ID")			//CLAIM_TRANSACTION_ID
	private String claimTransId;
			
	@Column(name = "CLAIM_INTREF_ID")				//CLAIM_INTREF_ID
	private String claimIntRefId;
	
	@Column(name = "MEMBER_ID")						//MEMBER_ID
	private String memberId;
	
	@Column(name = "PAYER_ID")						//PAYER_ID
	private String payerId;
	
	@Column(name = "UCR")
	private String ucr  = "";  						//UCR
	
	@Column(name = "UMR")
	private String umr  = "";						//UMR
	
	@Column(name = "EL_CLAIM_ID")
	private String elClaimId  = "";					//EL_CLAIM_ID
	
	@Column(name = "SETTLEMENT_AM_INDEM")			//SETTLEMENT_AM_INDEM
	private String settlementAmtIndem;
	
	@Column(name = "SETTLEMENT_AM_FEES")			//SETTLEMENT_AM_FEES
	private String settlementAmtFees;
	
	@Column(name = "SETTLEMENT_AM_EXP")				//SETTLEMENT_AM_EXP
	private String settlementAmtExpense;
	
	@Column(name = "RESERVE_AM_INDEM")				//RESERVE_AM_INDEM
	private String reserveAmtIndem;
	
	@Column(name = "RESERVE_AM_FEES")				//RESERVE_AM_FEES
	private String reserveAmtFees;
	
	@Column(name = "RESERVE_AM_EXP")				//RESERVE_AM_EXP
	private String reserveAmtExpense;
	
	@Column(name = "INCURRED_AM")					//INCURRED_AM
	private String incurredAmt;
	
	@Column(name = "CURRENCY")						//CURRENCY
	private String currency;				
	
	@Column(name = "PAYMT_TYP")						//PMT_TYP
	private String paymentType;
	
	@Column(name = "STATUS")						//STATUS
	private String status;
			
	@Column(name = "IS_COLLECTED")					//IS_COLLECTED
	private String isCollected = "";

	/**
	 * @return the payHistoryId
	 */
	public String getPayHistoryId() {
		return payHistoryId;
	}

	/**
	 * @param payHistoryId the payHistoryId to set
	 */
	public void setPayHistoryId(String payHistoryId) {
		this.payHistoryId = payHistoryId;
	}

	/**
	 * @return the claimHeaderId
	 */
	public String getClaimHeaderId() {
		return claimHeaderId;
	}

	/**
	 * @param claimHeaderId the claimHeaderId to set
	 */
	public void setClaimHeaderId(String claimHeaderId) {
		this.claimHeaderId = claimHeaderId;
	}

	/**
	 * @return the claimDetailId
	 */
	public String getClaimDetailId() {
		return claimDetailId;
	}

	/**
	 * @param claimDetailId the claimDetailId to set
	 */
	public void setClaimDetailId(String claimDetailId) {
		this.claimDetailId = claimDetailId;
	}

	/**
	 * @return the claimTransId
	 */
	public String getClaimTransId() {
		return claimTransId;
	}

	/**
	 * @param claimTransId the claimTransId to set
	 */
	public void setClaimTransId(String claimTransId) {
		this.claimTransId = claimTransId;
	}

	/**
	 * @return the claimIntRefId
	 */
	public String getClaimIntRefId() {
		return claimIntRefId;
	}

	/**
	 * @param claimIntRefId the claimIntRefId to set
	 */
	public void setClaimIntRefId(String claimIntRefId) {
		this.claimIntRefId = claimIntRefId;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	 * @return the ucr
	 */
	public String getUcr() {
		return ucr;
	}

	/**
	 * @param ucr the ucr to set
	 */
	public void setUcr(String ucr) {
		this.ucr = ucr;
	}

	/**
	 * @return the umr
	 */
	public String getUmr() {
		return umr;
	}

	/**
	 * @param umr the umr to set
	 */
	public void setUmr(String umr) {
		this.umr = umr;
	}

	/**
	 * @return the elClaimId
	 */
	public String getElClaimId() {
		return elClaimId;
	}

	/**
	 * @param elClaimId the elClaimId to set
	 */
	public void setElClaimId(String elClaimId) {
		this.elClaimId = elClaimId;
	}

	/**
	 * @return the settlementAmtIndem
	 */
	public String getSettlementAmtIndem() {
		return settlementAmtIndem;
	}

	/**
	 * @param settlementAmtIndem the settlementAmtIndem to set
	 */
	public void setSettlementAmtIndem(String settlementAmtIndem) {
		this.settlementAmtIndem = settlementAmtIndem;
	}

	/**
	 * @return the settlementAmtFees
	 */
	public String getSettlementAmtFees() {
		return settlementAmtFees;
	}

	/**
	 * @param settlementAmtFees the settlementAmtFees to set
	 */
	public void setSettlementAmtFees(String settlementAmtFees) {
		this.settlementAmtFees = settlementAmtFees;
	}

	/**
	 * @return the settlementAmtExpense
	 */
	public String getSettlementAmtExpense() {
		return settlementAmtExpense;
	}

	/**
	 * @param settlementAmtExpense the settlementAmtExpense to set
	 */
	public void setSettlementAmtExpense(String settlementAmtExpense) {
		this.settlementAmtExpense = settlementAmtExpense;
	}

	/**
	 * @return the reserveAmtIndem
	 */
	public String getReserveAmtIndem() {
		return reserveAmtIndem;
	}

	/**
	 * @param reserveAmtIndem the reserveAmtIndem to set
	 */
	public void setReserveAmtIndem(String reserveAmtIndem) {
		this.reserveAmtIndem = reserveAmtIndem;
	}

	/**
	 * @return the reserveAmtFees
	 */
	public String getReserveAmtFees() {
		return reserveAmtFees;
	}

	/**
	 * @param reserveAmtFees the reserveAmtFees to set
	 */
	public void setReserveAmtFees(String reserveAmtFees) {
		this.reserveAmtFees = reserveAmtFees;
	}

	/**
	 * @return the reserveAmtExpense
	 */
	public String getReserveAmtExpense() {
		return reserveAmtExpense;
	}

	/**
	 * @param reserveAmtExpense the reserveAmtExpense to set
	 */
	public void setReserveAmtExpense(String reserveAmtExpense) {
		this.reserveAmtExpense = reserveAmtExpense;
	}

	/**
	 * @return the incurredAmt
	 */
	public String getIncurredAmt() {
		return incurredAmt;
	}

	/**
	 * @param incurredAmt the incurredAmt to set
	 */
	public void setIncurredAmt(String incurredAmt) {
		this.incurredAmt = incurredAmt;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoHybrisPayHistory [" + (payHistoryId != null ? "payHistoryId=" + payHistoryId + ", " : "")
				+ (claimHeaderId != null ? "claimHeaderId=" + claimHeaderId + ", " : "")
				+ (claimDetailId != null ? "claimDetailId=" + claimDetailId + ", " : "")
				+ (claimTransId != null ? "claimTransId=" + claimTransId + ", " : "")
				+ (claimIntRefId != null ? "claimIntRefId=" + claimIntRefId + ", " : "")
				+ (memberId != null ? "memberId=" + memberId + ", " : "")
				+ (payerId != null ? "payerId=" + payerId + ", " : "") + (ucr != null ? "ucr=" + ucr + ", " : "")
				+ (umr != null ? "umr=" + umr + ", " : "") + (elClaimId != null ? "elClaimId=" + elClaimId + ", " : "")
				+ (settlementAmtIndem != null ? "settlementAmtIndem=" + settlementAmtIndem + ", " : "")
				+ (settlementAmtFees != null ? "settlementAmtFees=" + settlementAmtFees + ", " : "")
				+ (settlementAmtExpense != null ? "settlementAmtExpense=" + settlementAmtExpense + ", " : "")
				+ (reserveAmtIndem != null ? "reserveAmtIndem=" + reserveAmtIndem + ", " : "")
				+ (reserveAmtFees != null ? "reserveAmtFees=" + reserveAmtFees + ", " : "")
				+ (reserveAmtExpense != null ? "reserveAmtExpense=" + reserveAmtExpense + ", " : "")
				+ (incurredAmt != null ? "incurredAmt=" + incurredAmt + ", " : "")
				+ (currency != null ? "currency=" + currency + ", " : "")
				+ (paymentType != null ? "paymentType=" + paymentType + ", " : "")
				+ (status != null ? "status=" + status + ", " : "")
				+ (isCollected != null ? "isCollected=" + isCollected : "") + "]";
	}	
}
