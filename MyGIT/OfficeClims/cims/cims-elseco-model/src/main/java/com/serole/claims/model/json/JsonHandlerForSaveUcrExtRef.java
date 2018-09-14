package com.serole.claims.model.json;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.serole.claims.model.Elseco.ElsecoClaimDetails;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
public class JsonHandlerForSaveUcrExtRef {
	public JsonHandlerForSaveUcrExtRef(){  }
	     
	private int claimHeaderId;   			//CLAIM_HEADER_ID	
			
	private String ucrNumber = "";  		//UCR_NO	
	
	private String ucrName = "";  			//UCR_NAME	
	
	private String umrNumber = "";			//UMR_NO
		
	ArrayList<ElsecoClaimDetails> ClaimDetailsInfo;

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
	 * @return the ucrName
	 */
	public String getUcrName() {
		return ucrName;
	}

	/**
	 * @param ucrName the ucrName to set
	 */
	public void setUcrName(String ucrName) {
		this.ucrName = ucrName;
	}

	/**
	 * @return the umrNumber
	 */
	public String getUmrNumber() {
		return umrNumber;
	}

	/**
	 * @param umrNumber the umrNumber to set
	 */
	public void setUmrNumber(String umrNumber) {
		this.umrNumber = umrNumber;
	}

	/**
	 * @return the claimDetailsInfo
	 */
	public ArrayList<ElsecoClaimDetails> getClaimDetailsInfo() {
		return ClaimDetailsInfo;
	}

	/**
	 * @param claimDetailsInfo the claimDetailsInfo to set
	 */
	public void setClaimDetailsInfo(ArrayList<ElsecoClaimDetails> claimDetailsInfo) {
		ClaimDetailsInfo = claimDetailsInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonHandlerForSaveUcrExtRef [claimHeaderId=" + claimHeaderId + ", "
				+ (ucrNumber != null ? "ucrNumber=" + ucrNumber + ", " : "")
				+ (ucrName != null ? "ucrName=" + ucrName + ", " : "")
				+ (umrNumber != null ? "umrNumber=" + umrNumber + ", " : "")
				+ (ClaimDetailsInfo != null ? "ClaimDetailsInfo=" + ClaimDetailsInfo : "") + "]";
	}
}
