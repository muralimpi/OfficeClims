package com.serole.claims.model.rfc.hybris;

import java.util.ArrayList;

public class HEADER_DATA_EXT {
	
	public String EXT_REF = "";	
	
	public String TR_ID = "";		
	
	public String LINE_SPLIT_VL = "";	
	
	public String TR_TYP = "";			
	
	public String PMT_TYP = "";		
	
	public String PARTICIPATION_ID = "";	
	
	public String POLICY_TYPE  = "";
	
	public ArrayList<HEADER_DATA_PAY> HEADER_DATA_PAY;
	
	public ArrayList<HEADER_DATA_INT> HEADER_DATA_INT;

	/**
	 * @return the eXT_REF
	 */
	public String getEXT_REF() {
		return EXT_REF;
	}

	/**
	 * @param eXT_REF the eXT_REF to set
	 */
	public void setEXT_REF(String eXT_REF) {
		EXT_REF = eXT_REF;
	}

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
	 * @return the lINE_SPLIT_VL
	 */
	public String getLINE_SPLIT_VL() {
		return LINE_SPLIT_VL;
	}

	/**
	 * @param lINE_SPLIT_VL the lINE_SPLIT_VL to set
	 */
	public void setLINE_SPLIT_VL(String lINE_SPLIT_VL) {
		LINE_SPLIT_VL = lINE_SPLIT_VL;
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
	 * @return the pMT_TYP
	 */
	public String getPMT_TYP() {
		return PMT_TYP;
	}

	/**
	 * @param pMT_TYP the pMT_TYP to set
	 */
	public void setPMT_TYP(String pMT_TYP) {
		PMT_TYP = pMT_TYP;
	}	

	/**
	 * @return the pARTICIPATION_ID
	 */
	public String getPARTICIPATION_ID() {
		return PARTICIPATION_ID;
	}

	/**
	 * @param pARTICIPATION_ID the pARTICIPATION_ID to set
	 */
	public void setPARTICIPATION_ID(String pARTICIPATION_ID) {
		PARTICIPATION_ID = pARTICIPATION_ID;
	}

	/**
	 * @return the pOLICY_TYPE
	 */
	public String getPOLICY_TYPE() {
		return POLICY_TYPE;
	}

	/**
	 * @param pOLICY_TYPE the pOLICY_TYPE to set
	 */
	public void setPOLICY_TYPE(String pOLICY_TYPE) {
		POLICY_TYPE = pOLICY_TYPE;
	}

	/**
	 * @return the hEADER_DATA_PAY
	 */
	public ArrayList<HEADER_DATA_PAY> getHEADER_DATA_PAY() {
		return HEADER_DATA_PAY;
	}

	/**
	 * @param hEADER_DATA_PAY the hEADER_DATA_PAY to set
	 */
	public void setHEADER_DATA_PAY(ArrayList<HEADER_DATA_PAY> hEADER_DATA_PAY) {
		HEADER_DATA_PAY = hEADER_DATA_PAY;
	}

	/**
	 * @return the hEADER_DATA_INT
	 */
	public ArrayList<HEADER_DATA_INT> getHEADER_DATA_INT() {
		return HEADER_DATA_INT;
	}

	/**
	 * @param hEADER_DATA_INT the hEADER_DATA_INT to set
	 */
	public void setHEADER_DATA_INT(ArrayList<HEADER_DATA_INT> hEADER_DATA_INT) {
		HEADER_DATA_INT = hEADER_DATA_INT;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HEADER_DATA_EXT [" + (EXT_REF != null ? "EXT_REF=" + EXT_REF + ", " : "")
				+ (TR_ID != null ? "TR_ID=" + TR_ID + ", " : "")
				+ (LINE_SPLIT_VL != null ? "LINE_SPLIT_VL=" + LINE_SPLIT_VL + ", " : "")
				+ (TR_TYP != null ? "TR_TYP=" + TR_TYP + ", " : "")
				+ (PMT_TYP != null ? "PMT_TYP=" + PMT_TYP + ", " : "")
				+ (PARTICIPATION_ID != null ? "PARTICIPATION_ID=" + PARTICIPATION_ID + ", " : "")
				+ (POLICY_TYPE != null ? "POLICY_TYPE=" + POLICY_TYPE + ", " : "")
				+ (HEADER_DATA_PAY != null ? "HEADER_DATA_PAY=" + HEADER_DATA_PAY + ", " : "")
				+ (HEADER_DATA_INT != null ? "HEADER_DATA_INT=" + HEADER_DATA_INT : "") + "]";
	}	
}
