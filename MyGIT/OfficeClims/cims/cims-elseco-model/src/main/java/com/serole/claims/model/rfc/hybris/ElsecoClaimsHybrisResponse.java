package com.serole.claims.model.rfc.hybris;

public class ElsecoClaimsHybrisResponse {
	
	//Payment Type sent to Hybris
	private String paymntType;
	
	//Log Number from Hybris response
	private String logNumber;
	
	//Return code  from Hybris response	
	private String responseCode;
	
	//Return code  from Hybris response	status
	private String status;
	
	/**
	 * @return the paymntType
	 */
	public String getPaymntType() {
		return paymntType;
	}

	/**
	 * @param paymntType the paymntType to set
	 */
	public void setPaymntType(String paymntType) {
		this.paymntType = paymntType;
	}

	/**
	 * @return the logNumber
	 */
	public String getLogNumber() {
		return logNumber;
	}

	/**
	 * @param logNumber the logNumber to set
	 */
	public void setLogNumber(String logNumber) {
		this.logNumber = logNumber;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimsHybrisResponse [" + (paymntType != null ? "paymntType=" + paymntType + ", " : "")
				+ (logNumber != null ? "logNumber=" + logNumber + ", " : "")
				+ (responseCode != null ? "responseCode=" + responseCode + ", " : "")
				+ (status != null ? "status=" + status : "") + "]";
	}	
}
