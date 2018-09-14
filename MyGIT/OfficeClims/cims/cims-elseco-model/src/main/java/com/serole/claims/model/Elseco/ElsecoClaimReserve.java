package com.serole.claims.model.Elseco;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimReserve_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimReserve 	{             
	public ElsecoClaimReserve(){  }
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_RESERVE_ID")
	private int claimReserveId;   				//CLAIM_RESERVE_ID
	
	@Column(name = "RESERVE_FLAG")
	private String reserveFlag;   				//RESERVE_FLAG	
	
	@Column(name = "RESERVE_AMT", columnDefinition="decimal", precision=15, scale=0)		
	private BigDecimal reserveAmt;   			//RESERVE_AMT	
	
	@Column(name = "BALANCE_AMT", columnDefinition="decimal", precision=15, scale=0)		
	private BigDecimal balanceAmt;   			//BALANCE_AMT	
	
	@Column(name = "INITIAL_DETAILS")
	private String initialDetails; 				//INITIAL_DETAILS	
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId;  				//CLAIMS_HEADER_ID	
	
	@Column(name = "CLAIM_ID")
	private int claimDetId;  					//CLAIM_ID	
	
	@Column(name = "RESERVE_TYPE")
	private String reserveType;  				//RESERVE_TYPE
	
	@Column(name = "POOL_NAME")
	private String poolName;  					//POOL_NAME	
	
	@Column(name = "MEMBER_NAME")
	private String memberName;  				//MEMBER_NAME	
	
	@Column(name = "ALLOCATION_PERCENT", columnDefinition="decimal", precision=15, scale=0)	
	private BigDecimal allocationPercent;  		//ALLOCATION_PERCENT	
	
	@Column(name = "PRIVILEDGE_TYPE")
	private String priviledgeType;  			//PRIVILEDGE_TYPE	
		
	@Column(name = "INDEMNITY_RESERVE_AMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal indemnityAmt; 			//"INDEMNITY_RESERVE_AMT"
		
	@Column(name = "FEE_RESERVE_AMT", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal feeReserveAmt; 			//"FEE_RESERVE_AMT"

	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 			//DELETE_FLAG
	
	/**
	 * @return the claimReserveId
	 */
	public int getClaimReserveId() {
		return claimReserveId;
	}

	/**
	 * @param claimReserveId the claimReserveId to set
	 */
	public void setClaimReserveId(int claimReserveId) {
		this.claimReserveId = claimReserveId;
	}

	/**
	 * @return the reserveFlag
	 */
	public String getReserveFlag() {
		return reserveFlag;
	}

	/**
	 * @param reserveFlag the reserveFlag to set
	 */
	public void setReserveFlag(String reserveFlag) {
		this.reserveFlag = reserveFlag;
	}

	/**
	 * @return the reserveAmt
	 */
	public BigDecimal getReserveAmt() {
		return reserveAmt;
	}

	/**
	 * @param reserveAmt the reserveAmt to set
	 */
	public void setReserveAmt(BigDecimal reserveAmt) {
		this.reserveAmt = reserveAmt;
	}

	/**
	 * @return the initialDetails
	 */
	public String getInitialDetails() {
		return initialDetails;
	}

	/**
	 * @param initialDetails the initialDetails to set
	 */
	public void setInitialDetails(String initialDetails) {
		this.initialDetails = initialDetails;
	}

	/**
	 * @return the claimsHeaderId
	 */
	public int getClaimHeaderId() {
		return claimHeaderId;
	}

	/**
	 * @param claimsHeaderId the claimsHeaderId to set
	 */
	public void setClaimHeaderId(int claimHeaderId) {
		this.claimHeaderId = claimHeaderId;
	}

	/**
	 * @return the reserverType
	 */
	public String getReserveType() {
		return reserveType;
	}

	/**
	 * @param reserveType the reserveType to set
	 */
	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}

	/**
	 * @return the poolId
	 */
	public String getPoolName() {
		return poolName;
	}

	/**
	 * @param poolId the poolId to set
	 */
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the allocationPercent
	 */
	public BigDecimal getAllocationPercent() {
		return allocationPercent;
	}

	/**
	 * @param allocationPercent the allocationPercent to set
	 */
	public void setAllocationPercent(BigDecimal allocationPercent) {
		this.allocationPercent = allocationPercent;
	}

	/**
	 * @return the priviledgeType
	 */
	public String getPriviledgeType() {
		return priviledgeType;
	}

	/**
	 * @param priviledgeType the priviledgeType to set
	 */
	public void setPriviledgeType(String priviledgeType) {
		this.priviledgeType = priviledgeType;
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
	 * @return the balanceAmt
	 */
	public BigDecimal getBalanceAmt() {
		return balanceAmt;
	}

	/**
	 * @param balanceAmt the balanceAmt to set
	 */
	public void setBalanceAmt(BigDecimal balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	/**
	 * @return the indemnityAmt
	 */
	public BigDecimal getIndemnityAmt() {
		return indemnityAmt;
	}

	/**
	 * @param indemnityAmt the indemnityAmt to set
	 */
	public void setIndemnityAmt(BigDecimal indemnityAmt) {
		this.indemnityAmt = indemnityAmt;
	}

	/**
	 * @return the feeReserveAmt
	 */
	public BigDecimal getFeeReserveAmt() {
		return feeReserveAmt;
	}

	/**
	 * @param feeReserveAmt the feeReserveAmt to set
	 */
	public void setFeeReserveAmt(BigDecimal feeReserveAmt) {
		this.feeReserveAmt = feeReserveAmt;
	}

	/**
	 * @return the claimDetId
	 */
	public int getClaimDetId() {
		return claimDetId;
	}

	/**
	 * @param claimDetId the claimDetId to set
	 */
	public void setClaimDetId(int claimDetId) {
		this.claimDetId = claimDetId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimReserve [claimReserveId=" + claimReserveId + ", "
				+ (reserveFlag != null ? "reserveFlag=" + reserveFlag + ", " : "")
				+ (reserveAmt != null ? "reserveAmt=" + reserveAmt + ", " : "")
				+ (balanceAmt != null ? "balanceAmt=" + balanceAmt + ", " : "")
				+ (initialDetails != null ? "initialDetails=" + initialDetails + ", " : "") + "claimHeaderId="
				+ claimHeaderId + ", claimDetId=" + claimDetId + ", "
				+ (reserveType != null ? "reserveType=" + reserveType + ", " : "")
				+ (poolName != null ? "poolName=" + poolName + ", " : "")
				+ (memberName != null ? "memberName=" + memberName + ", " : "")
				+ (allocationPercent != null ? "allocationPercent=" + allocationPercent + ", " : "")
				+ (priviledgeType != null ? "priviledgeType=" + priviledgeType + ", " : "")
				+ (indemnityAmt != null ? "indemnityAmt=" + indemnityAmt + ", " : "")
				+ (feeReserveAmt != null ? "feeReserveAmt=" + feeReserveAmt + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}
