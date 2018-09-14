package com.serole.claims.model.rfc.hybris;

public class  ElsecoCrmPqm{
	
	private String bpId;
	private String availPrmAmount = "0";
	/**
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}
	/**
	 * @param bpId the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}
	/**
	 * @return the availPrmAmount
	 */
	public String getAvailPrmAmount() {
		return availPrmAmount;
	}
	/**
	 * @param availPrmAmount the availPrmAmount to set
	 */
	public void setAvailPrmAmount(String availPrmAmount) {
		this.availPrmAmount = availPrmAmount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoCrmPqm [" + (bpId != null ? "bpId=" + bpId + ", " : "")
				+ (availPrmAmount != null ? "availPrmAmount=" + availPrmAmount : "") + "]";
	}
	
}
