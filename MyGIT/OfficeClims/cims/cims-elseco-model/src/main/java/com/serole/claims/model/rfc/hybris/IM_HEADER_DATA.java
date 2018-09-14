package com.serole.claims.model.rfc.hybris;

public class IM_HEADER_DATA {	
	
	public String UCR = "";	

	public String UMR = "";	
	
	public String EL_CLAIM_ID = "";	

	public String PARTNER_ID = "";	
	
	public String DATE_LOSS = "";
	
	public String APPOINTED_LOSS_ADJUSTER = "";
	
	public String DETAILS  = "";
	
	public HEADER_DATA_MARKET HEADER_DATA_MARKET;

	/**
	 * @return the uCR
	 */
	public String getUCR() {
		return UCR;
	}

	/**
	 * @param uCR the uCR to set
	 */
	public void setUCR(String uCR) {
		UCR = uCR;
	}

	/**
	 * @return the uMR
	 */
	public String getUMR() {
		return UMR;
	}

	/**
	 * @param uMR the uMR to set
	 */
	public void setUMR(String uMR) {
		UMR = uMR;
	}

	/**
	 * @return the eL_CLAIM_ID
	 */
	public String getEL_CLAIM_ID() {
		return EL_CLAIM_ID;
	}

	/**
	 * @param eL_CLAIM_ID the eL_CLAIM_ID to set
	 */
	public void setEL_CLAIM_ID(String eL_CLAIM_ID) {
		EL_CLAIM_ID = eL_CLAIM_ID;
	}

	/**
	 * @return the pARTNER_ID
	 */
	public String getPARTNER_ID() {
		return PARTNER_ID;
	}

	/**
	 * @param pARTNER_ID the pARTNER_ID to set
	 */
	public void setPARTNER_ID(String pARTNER_ID) {
		PARTNER_ID = pARTNER_ID;
	}

	/**
	 * @return the dATE_LOSS
	 */
	public String getDATE_LOSS() {
		return DATE_LOSS;
	}

	/**
	 * @param dATE_LOSS the dATE_LOSS to set
	 */
	public void setDATE_LOSS(String dATE_LOSS) {
		DATE_LOSS = dATE_LOSS;
	}

	/**
	 * @return the aPPOINTED_LOSS_ADJUSTER
	 */
	public String getAPPOINTED_LOSS_ADJUSTER() {
		return APPOINTED_LOSS_ADJUSTER;
	}

	/**
	 * @param aPPOINTED_LOSS_ADJUSTER the aPPOINTED_LOSS_ADJUSTER to set
	 */
	public void setAPPOINTED_LOSS_ADJUSTER(String aPPOINTED_LOSS_ADJUSTER) {
		APPOINTED_LOSS_ADJUSTER = aPPOINTED_LOSS_ADJUSTER;
	}

	/**
	 * @return the dETAILS
	 */
	public String getDETAILS() {
		return DETAILS;
	}

	/**
	 * @param dETAILS the dETAILS to set
	 */
	public void setDETAILS(String dETAILS) {
		DETAILS = dETAILS;
	}

	/**
	 * @return the hEADER_DATA_MARKET
	 */
	public HEADER_DATA_MARKET getHEADER_DATA_MARKET() {
		return HEADER_DATA_MARKET;
	}

	/**
	 * @param hEADER_DATA_MARKET the hEADER_DATA_MARKET to set
	 */
	public void setHEADER_DATA_MARKET(HEADER_DATA_MARKET hEADER_DATA_MARKET) {
		HEADER_DATA_MARKET = hEADER_DATA_MARKET;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IM_HEADER_DATA [" + (UCR != null ? "UCR=" + UCR + ", " : "") + (UMR != null ? "UMR=" + UMR + ", " : "")
				+ (EL_CLAIM_ID != null ? "EL_CLAIM_ID=" + EL_CLAIM_ID + ", " : "")
				+ (PARTNER_ID != null ? "PARTNER_ID=" + PARTNER_ID + ", " : "")
				+ (DATE_LOSS != null ? "DATE_LOSS=" + DATE_LOSS + ", " : "")
				+ (APPOINTED_LOSS_ADJUSTER != null ? "APPOINTED_LOSS_ADJUSTER=" + APPOINTED_LOSS_ADJUSTER + ", " : "")
				+ (DETAILS != null ? "DETAILS=" + DETAILS + ", " : "")
				+ (HEADER_DATA_MARKET != null ? "HEADER_DATA_MARKET=" + HEADER_DATA_MARKET : "") + "]";
	}
}
