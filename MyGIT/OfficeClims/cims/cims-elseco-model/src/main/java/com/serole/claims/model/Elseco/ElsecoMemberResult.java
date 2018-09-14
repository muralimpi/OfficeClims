package com.serole.claims.model.Elseco;

import java.math.BigDecimal;

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
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_MemberResult_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoMemberResult extends ClaimsItems {
	public ElsecoMemberResult(){  }
	  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "RESULT_ID")
	private int resultId;   						//RESULT_ID
	
	@Column(name = "MEMBER_ID")
	private int memberId;   						//MEMBER_ID
		
	@Column(name = "STAMP_ID")
	private int stampId;   							//STAMP_ID
	
	@Column(name = "INTREF_ID")
	private int intRefId;   						//INTREF_ID
	
	@Column(name = "POLICY_TRANSACTION_ID")			//POLICY_TRANSACTION_ID
	private int policyTransactionId; 
	
	@Column(name = "MARKET_TRANSACTION_ID")			//MARKET_TRANSACTION_ID
	private int marketTransactionId; 
	
	@Column(name = "CLAIM_ID")
	private int claimId;   							//CLAIM_ID
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId;   					//CLAIM_HEADER_ID
	
	@Column(name = "ELRISKCODE_ID")
	private int ElRiskCodeId;   					//ELRISKCODE_ID
	
	@Column(name = "MEMBER_BPID")
	private int memberBpId;   						//MEMBER_BPID
	
	@Column(name = "MEMBER_NAME")
	private String memberName = "";   				//MEMBER_NAME	
	
	@Column(name = "TOTAL_CAPACITY_AMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal totalCapacityAmount; 		//TOTAL_CAPACITY_AMT
	
	@Column(name = "TOTAL_SHARE_VL")
	private String totalShareVl = "";   			//TOTAL_SHARE_VL	
		
	@Column(name = "OWN_CAPACITY_AMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal ownCapacityAmt; 				//OWN_CAPACITY_AMT	
	
	@Column(name = "OWN_SHARE_VL")
	private String ownShareVl = ""; 				//OWN_SHARE_VL	
	
	@Column(name = "PAY_PREMIUM_TO_BPID")
	private int payPremiumToBpId; 					//PAY_PREMIUM_TO_BPID	
	
	@Column(name = "PAY_POLICY_BR_TO_BPID")
	private int payPolicyBRtoBpId; 					//PAY_POLICY_BR_TO_BPID	
	
	@Column(name = "PAY_FF_TO_BPID")
	private int payFFtoBpId; 						//PAY_FF_TO_BPID
	
	@Column(name = "PAY_PB_TO_BPID")
	private int payPBtoBpId; 						//PAY_PB_TO_BPID
	
	@Column(name = "PAY_RIB_TO_BPID")
	private int payRibToBpId; 						//PAY_RIB_TO_BPID
	
	@Column(name = "POLICY_BROKERAGE_VL")
	private String policyBrokerageVl = ""; 			//POLICY_BROKERAGE_VL
	
	@Column(name = "ELSECO_COMMISSION_VL")
	private String elsecoCommissionVl = ""; 		//ELSECO_COMMISSION_VL	
		
	@Column(name = "FF_VL")
	private String ffVl = ""; 						//FF_VL
	
	@Column(name = "PB_VL")
	private String pbVl = ""; 						//PB_VL
	
	@Column(name = "RIB_VL")
	private String ribVl = ""; 						//RIB_VL
		
	@Column(name = "PROFIT_COMMISSION_VL")
	private String profitCommisionVl = ""; 			//PROFIT_COMMISSION_VL
	
	@Column(name = "PB_BASIS")
	private String pbBasis = ""; 					//PB_BASIS
	
	@Column(name = "FF_BASIS")
	private String ffBasis = ""; 					//FF_BASIS
	
	@Column(name = "RIB_BASIS")
	private String ribBasis = ""; 					//RIB_BASIS

	@Column(name = "AGREEMENT_ID")
	private int agreementId; 						//AGREEMENT_ID
	
	@Transient	
	private String memberEmail; 					//Temporary Field to send Member EmailId from properties file
	
	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 				//DELETE_FLAG

	@Transient
	private ElsecoMemberRiskcode MemberRiskCodeInfo;

	/**
	 * @return the resultId
	 */
	public int getResultId() {
		return resultId;
	}

	/**
	 * @param resultId the resultId to set
	 */
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

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
	 * @return the elRiskCodeId
	 */
	public int getElRiskCodeId() {
		return ElRiskCodeId;
	}

	/**
	 * @param elRiskCodeId the elRiskCodeId to set
	 */
	public void setElRiskCodeId(int elRiskCodeId) {
		ElRiskCodeId = elRiskCodeId;
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
	 * @return the totalCapacityAmount
	 */
	public BigDecimal getTotalCapacityAmount() {
		return totalCapacityAmount;
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
	 * @param totalCapacityAmount the totalCapacityAmount to set
	 */
	public void setTotalCapacityAmount(BigDecimal totalCapacityAmount) {
		this.totalCapacityAmount = totalCapacityAmount;
	}

	/**
	 * @return the totalShareVl
	 */
	public String getTotalShareVl() {
		return totalShareVl;
	}

	/**
	 * @param totalShareVl the totalShareVl to set
	 */
	public void setTotalShareVl(String totalShareVl) {
		this.totalShareVl = totalShareVl;
	}

	/**
	 * @return the ownCapacityAmt
	 */
	public BigDecimal getOwnCapacityAmt() {
		return ownCapacityAmt;
	}

	/**
	 * @param ownCapacityAmt the ownCapacityAmt to set
	 */
	public void setOwnCapacityAmt(BigDecimal ownCapacityAmt) {
		this.ownCapacityAmt = ownCapacityAmt;
	}

	/**
	 * @return the ownShareVl
	 */
	public String getOwnShareVl() {
		return ownShareVl;
	}

	/**
	 * @param ownShareVl the ownShareVl to set
	 */
	public void setOwnShareVl(String ownShareVl) {
		this.ownShareVl = ownShareVl;
	}

	/**
	 * @return the payPremiumToBpId
	 */
	public int getPayPremiumToBpId() {
		return payPremiumToBpId;
	}

	/**
	 * @param payPremiumToBpId the payPremiumToBpId to set
	 */
	public void setPayPremiumToBpId(int payPremiumToBpId) {
		this.payPremiumToBpId = payPremiumToBpId;
	}

	/**
	 * @return the payPolicyBRtoBpId
	 */
	public int getPayPolicyBRtoBpId() {
		return payPolicyBRtoBpId;
	}

	/**
	 * @param payPolicyBRtoBpId the payPolicyBRtoBpId to set
	 */
	public void setPayPolicyBRtoBpId(int payPolicyBRtoBpId) {
		this.payPolicyBRtoBpId = payPolicyBRtoBpId;
	}

	/**
	 * @return the payFFtoBpId
	 */
	public int getPayFFtoBpId() {
		return payFFtoBpId;
	}

	/**
	 * @param payFFtoBpId the payFFtoBpId to set
	 */
	public void setPayFFtoBpId(int payFFtoBpId) {
		this.payFFtoBpId = payFFtoBpId;
	}

	/**
	 * @return the payPBtoBpId
	 */
	public int getPayPBtoBpId() {
		return payPBtoBpId;
	}

	/**
	 * @param payPBtoBpId the payPBtoBpId to set
	 */
	public void setPayPBtoBpId(int payPBtoBpId) {
		this.payPBtoBpId = payPBtoBpId;
	}

	/**
	 * @return the payRibToBpId
	 */
	public int getPayRibToBpId() {
		return payRibToBpId;
	}

	/**
	 * @param payRibToBpId the payRibToBpId to set
	 */
	public void setPayRibToBpId(int payRibToBpId) {
		this.payRibToBpId = payRibToBpId;
	}

	/**
	 * @return the policyBrokerageVl
	 */
	public String getPolicyBrokerageVl() {
		return policyBrokerageVl;
	}

	/**
	 * @param policyBrokerageVl the policyBrokerageVl to set
	 */
	public void setPolicyBrokerageVl(String policyBrokerageVl) {
		this.policyBrokerageVl = policyBrokerageVl;
	}

	/**
	 * @return the elsecoCommissionVl
	 */
	public String getElsecoCommissionVl() {
		return elsecoCommissionVl;
	}

	/**
	 * @param elsecoCommissionVl the elsecoCommissionVl to set
	 */
	public void setElsecoCommissionVl(String elsecoCommissionVl) {
		this.elsecoCommissionVl = elsecoCommissionVl;
	}

	/**
	 * @return the ffVl
	 */
	public String getFfVl() {
		return ffVl;
	}

	/**
	 * @param ffVl the ffVl to set
	 */
	public void setFfVl(String ffVl) {
		this.ffVl = ffVl;
	}

	/**
	 * @return the pbVl
	 */
	public String getPbVl() {
		return pbVl;
	}

	/**
	 * @param pbVl the pbVl to set
	 */
	public void setPbVl(String pbVl) {
		this.pbVl = pbVl;
	}

	/**
	 * @return the ribVl
	 */
	public String getRibVl() {
		return ribVl;
	}

	/**
	 * @param ribVl the ribVl to set
	 */
	public void setRibVl(String ribVl) {
		this.ribVl = ribVl;
	}

	/**
	 * @return the profitCommisionVl
	 */
	public String getProfitCommisionVl() {
		return profitCommisionVl;
	}

	/**
	 * @param profitCommisionVl the profitCommisionVl to set
	 */
	public void setProfitCommisionVl(String profitCommisionVl) {
		this.profitCommisionVl = profitCommisionVl;
	}

	/**
	 * @return the pbBasis
	 */
	public String getPbBasis() {
		return pbBasis;
	}

	/**
	 * @param pbBasis the pbBasis to set
	 */
	public void setPbBasis(String pbBasis) {
		this.pbBasis = pbBasis;
	}

	/**
	 * @return the ffBasis
	 */
	public String getFfBasis() {
		return ffBasis;
	}

	/**
	 * @param ffBasis the ffBasis to set
	 */
	public void setFfBasis(String ffBasis) {
		this.ffBasis = ffBasis;
	}

	/**
	 * @return the ribBasis
	 */
	public String getRibBasis() {
		return ribBasis;
	}

	/**
	 * @param ribBasis the ribBasis to set
	 */
	public void setRibBasis(String ribBasis) {
		this.ribBasis = ribBasis;
	}

	/**
	 * @return the agreementId
	 */
	public int getAgreementId() {
		return agreementId;
	}

	/**
	 * @param agreementId the agreementId to set
	 */
	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
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
	 * @return the memberRiskCodeInfo
	 */
	public ElsecoMemberRiskcode getMemberRiskCodeInfo() {
		return MemberRiskCodeInfo;
	}

	/**
	 * @param memberRiskCodeInfo the memberRiskCodeInfo to set
	 */
	public void setMemberRiskCodeInfo(ElsecoMemberRiskcode memberRiskCodeInfo) {
		MemberRiskCodeInfo = memberRiskCodeInfo;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoMemberResult [resultId=" + resultId + ", memberId=" + memberId + ", stampId=" + stampId
				+ ", intRefId=" + intRefId + ", policyTransactionId=" + policyTransactionId + ", marketTransactionId="
				+ marketTransactionId + ", claimId=" + claimId + ", claimHeaderId=" + claimHeaderId + ", ElRiskCodeId="
				+ ElRiskCodeId + ", memberBpId=" + memberBpId + ", "
				+ (memberName != null ? "memberName=" + memberName + ", " : "")
				+ (totalCapacityAmount != null ? "totalCapacityAmount=" + totalCapacityAmount + ", " : "")
				+ (totalShareVl != null ? "totalShareVl=" + totalShareVl + ", " : "")
				+ (ownCapacityAmt != null ? "ownCapacityAmt=" + ownCapacityAmt + ", " : "")
				+ (ownShareVl != null ? "ownShareVl=" + ownShareVl + ", " : "") + "payPremiumToBpId=" + payPremiumToBpId
				+ ", payPolicyBRtoBpId=" + payPolicyBRtoBpId + ", payFFtoBpId=" + payFFtoBpId + ", payPBtoBpId="
				+ payPBtoBpId + ", payRibToBpId=" + payRibToBpId + ", "
				+ (policyBrokerageVl != null ? "policyBrokerageVl=" + policyBrokerageVl + ", " : "")
				+ (elsecoCommissionVl != null ? "elsecoCommissionVl=" + elsecoCommissionVl + ", " : "")
				+ (ffVl != null ? "ffVl=" + ffVl + ", " : "") + (pbVl != null ? "pbVl=" + pbVl + ", " : "")
				+ (ribVl != null ? "ribVl=" + ribVl + ", " : "")
				+ (profitCommisionVl != null ? "profitCommisionVl=" + profitCommisionVl + ", " : "")
				+ (pbBasis != null ? "pbBasis=" + pbBasis + ", " : "")
				+ (ffBasis != null ? "ffBasis=" + ffBasis + ", " : "")
				+ (ribBasis != null ? "ribBasis=" + ribBasis + ", " : "") + "agreementId=" + agreementId + ", "
				+ (memberEmail != null ? "memberEmail=" + memberEmail + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag + ", " : "")
				+ (MemberRiskCodeInfo != null ? "MemberRiskCodeInfo=" + MemberRiskCodeInfo : "") + "]";
	}
}
