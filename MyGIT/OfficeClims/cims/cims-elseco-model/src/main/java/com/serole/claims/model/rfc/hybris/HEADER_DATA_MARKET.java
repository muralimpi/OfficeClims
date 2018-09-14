package com.serole.claims.model.rfc.hybris;

public class HEADER_DATA_MARKET {
		
	public String TR_ID = "";	
	public String TR_TYP = "";
	public String SETTLEMENT_AM_INDEM = "";		
	public String SETTLEMENT_AM_FEES = "";	
	public String SETTLEMENT_AM_EXP = "";	
	public String RESERVE_AM_INDEM = "";	
	public String RESERVE_AM_FEES = "";	
	public String RESERVE_AM_EXP = "";	
	public String INCURRED_AM = "";
	public String CURRENCY = "";
	
	public HEADER_DATA_EXT HEADER_DATA_EXT;
	
	/**
	 * @return the tR_ID
	 */
	public String getTR_ID() {
		return TR_ID;
	}
	/**
	 * @param tR_ID the tR_ID to set
	 */
	public void setTR_ID(String tR_ID) {
		TR_ID = tR_ID;
	}
	/**
	 * @return the tR_TYP
	 */
	public String getTR_TYP() {
		return TR_TYP;
	}
	/**
	 * @param tR_TYP the tR_TYP to set
	 */
	public void setTR_TYP(String tR_TYP) {
		TR_TYP = tR_TYP;
	}	
	/**
	 * @return the sETTLEMENT_AM_INDEM
	 */
	public String getSETTLEMENT_AM_INDEM() {
		return SETTLEMENT_AM_INDEM;
	}
	/**
	 * @param sETTLEMENT_AM_INDEM the sETTLEMENT_AM_INDEM to set
	 */
	public void setSETTLEMENT_AM_INDEM(String sETTLEMENT_AM_INDEM) {
		SETTLEMENT_AM_INDEM = sETTLEMENT_AM_INDEM;
	}
	/**
	 * @return the sETTLEMENT_AM_FEES
	 */
	public String getSETTLEMENT_AM_FEES() {
		return SETTLEMENT_AM_FEES;
	}
	/**
	 * @param sETTLEMENT_AM_FEES the sETTLEMENT_AM_FEES to set
	 */
	public void setSETTLEMENT_AM_FEES(String sETTLEMENT_AM_FEES) {
		SETTLEMENT_AM_FEES = sETTLEMENT_AM_FEES;
	}
	/**
	 * @return the sETTLEMENT_AM_EXP
	 */
	public String getSETTLEMENT_AM_EXP() {
		return SETTLEMENT_AM_EXP;
	}
	/**
	 * @param sETTLEMENT_AM_EXP the sETTLEMENT_AM_EXP to set
	 */
	public void setSETTLEMENT_AM_EXP(String sETTLEMENT_AM_EXP) {
		SETTLEMENT_AM_EXP = sETTLEMENT_AM_EXP;
	}
	/**
	 * @return the rESERVE_AM_INDEM
	 */
	public String getRESERVE_AM_INDEM() {
		return RESERVE_AM_INDEM;
	}
	/**
	 * @param rESERVE_AM_INDEM the rESERVE_AM_INDEM to set
	 */
	public void setRESERVE_AM_INDEM(String rESERVE_AM_INDEM) {
		RESERVE_AM_INDEM = rESERVE_AM_INDEM;
	}
	/**
	 * @return the rESERVE_AM_FEES
	 */
	public String getRESERVE_AM_FEES() {
		return RESERVE_AM_FEES;
	}
	/**
	 * @param rESERVE_AM_FEES the rESERVE_AM_FEES to set
	 */
	public void setRESERVE_AM_FEES(String rESERVE_AM_FEES) {
		RESERVE_AM_FEES = rESERVE_AM_FEES;
	}
	/**
	 * @return the rESERVE_AM_EXP
	 */
	public String getRESERVE_AM_EXP() {
		return RESERVE_AM_EXP;
	}
	/**
	 * @param rESERVE_AM_EXP the rESERVE_AM_EXP to set
	 */
	public void setRESERVE_AM_EXP(String rESERVE_AM_EXP) {
		RESERVE_AM_EXP = rESERVE_AM_EXP;
	}
	/**
	 * @return the iNCURRED_AM
	 */
	public String getINCURRED_AM() {
		return INCURRED_AM;
	}
	/**
	 * @param iNCURRED_AM the iNCURRED_AM to set
	 */
	public void setINCURRED_AM(String iNCURRED_AM) {
		INCURRED_AM = iNCURRED_AM;
	}
	/**
	 * @return the cURRENCY
	 */
	public String getCURRENCY() {
		return CURRENCY;
	}
	/**
	 * @param cURRENCY the cURRENCY to set
	 */
	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}
	/**
	 * @return the hEADER_DATA_EXT
	 */
	public HEADER_DATA_EXT getHEADER_DATA_EXT() {
		return HEADER_DATA_EXT;
	}
	/**
	 * @param hEADER_DATA_EXT the hEADER_DATA_EXT to set
	 */
	public void setHEADER_DATA_EXT(HEADER_DATA_EXT hEADER_DATA_EXT) {
		HEADER_DATA_EXT = hEADER_DATA_EXT;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HEADER_DATA_MARKET [" + (TR_ID != null ? "TR_ID=" + TR_ID + ", " : "")
				+ (TR_TYP != null ? "TR_TYP=" + TR_TYP + ", " : "")
				+ (SETTLEMENT_AM_INDEM != null ? "SETTLEMENT_AM_INDEM=" + SETTLEMENT_AM_INDEM + ", " : "")
				+ (SETTLEMENT_AM_FEES != null ? "SETTLEMENT_AM_FEES=" + SETTLEMENT_AM_FEES + ", " : "")
				+ (SETTLEMENT_AM_EXP != null ? "SETTLEMENT_AM_EXP=" + SETTLEMENT_AM_EXP + ", " : "")
				+ (RESERVE_AM_INDEM != null ? "RESERVE_AM_INDEM=" + RESERVE_AM_INDEM + ", " : "")
				+ (RESERVE_AM_FEES != null ? "RESERVE_AM_FEES=" + RESERVE_AM_FEES + ", " : "")
				+ (RESERVE_AM_EXP != null ? "RESERVE_AM_EXP=" + RESERVE_AM_EXP + ", " : "")
				+ (INCURRED_AM != null ? "INCURRED_AM=" + INCURRED_AM + ", " : "")
				+ (CURRENCY != null ? "CURRENCY=" + CURRENCY + ", " : "")
				+ (HEADER_DATA_EXT != null ? "HEADER_DATA_EXT=" + HEADER_DATA_EXT : "") + "]";
	}		
}
