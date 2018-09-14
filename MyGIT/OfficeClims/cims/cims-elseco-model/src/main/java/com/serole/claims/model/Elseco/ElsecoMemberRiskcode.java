package com.serole.claims.model.Elseco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.serole.claims.model.ClaimsItems;

@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_MemberRiskcode_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoMemberRiskcode extends ClaimsItems {
	public ElsecoMemberRiskcode(){  }
	  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "LLRISKCODE_ID")
	private int llRiskCodeId;   				//LLRISKCODE_ID
	
	@Column(name = "RESULT_ID")
	private int resultId;   					//RESULT_ID
	
	@Column(name = "MEMBER_ID")
	private int memberId;   					//MEMBER_ID
	
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
	
	@Column(name = "ELRISK_CODE")
	private String elRiskCode = "";   			//ELRISK_CODE	
	
	@Column(name = "ELRISK_DESCRIPTION")
	private String elRiskDescription = "";   	//ELRISK_DESCRIPTION	
		
	@Column(name = "LOB_ID")
	private int lobId; 							//LOB_ID	
	
	@Column(name = "SEGMENT_ID")
	private int segmentId; 						//SEGMENT_ID		
	
	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 			//DELETE_FLAG

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
	 * @return the llRiskCodeId
	 */
	public int getLlRiskCodeId() {
		return llRiskCodeId;
	}

	/**
	 * @param llRiskCodeId the llRiskCodeId to set
	 */
	public void setLlRiskCodeId(int llRiskCodeId) {
		this.llRiskCodeId = llRiskCodeId;
	}

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
	 * @return the elRiskCode
	 */
	public String getElRiskCode() {
		return elRiskCode;
	}

	/**
	 * @param elRiskCode the elRiskCode to set
	 */
	public void setElRiskCode(String elRiskCode) {
		this.elRiskCode = elRiskCode;
	}

	/**
	 * @return the elRiskDescription
	 */
	public String getElRiskDescription() {
		return elRiskDescription;
	}

	/**
	 * @param elRiskDescription the elRiskDescription to set
	 */
	public void setElRiskDescription(String elRiskDescription) {
		this.elRiskDescription = elRiskDescription;
	}

	/**
	 * @return the lobId
	 */
	public int getLobId() {
		return lobId;
	}

	/**
	 * @param lobId the lobId to set
	 */
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}

	/**
	 * @return the segmentId
	 */
	public int getSegmentId() {
		return segmentId;
	}

	/**
	 * @param segmentId the segmentId to set
	 */
	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoMemberRiskcode [llRiskCodeId=" + llRiskCodeId + ", resultId=" + resultId + ", memberId="
				+ memberId + ", intRefId=" + intRefId + ", policyTransactionId=" + policyTransactionId
				+ ", marketTransactionId=" + marketTransactionId + ", claimId=" + claimId + ", claimHeaderId="
				+ claimHeaderId + ", " + (elRiskCode != null ? "elRiskCode=" + elRiskCode + ", " : "")
				+ (elRiskDescription != null ? "elRiskDescription=" + elRiskDescription + ", " : "") + "lobId=" + lobId
				+ ", segmentId=" + segmentId + ", " + (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}
