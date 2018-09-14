package com.serole.claims.model.rfc.hybris;

import java.util.ArrayList;

public class HEADER_DATA_INT {	
	
	public String INT_REF = "";	
	
	public String TR_ID = "";	
	
	public String SPLIT_VL = "";	
	
	public String DUE_DATE = "";
	
	public String STAMP_ID = "";

	public String SECTION = "";
	
	public ArrayList<HEADER_DATA_STAMP_MEMBER> HEADER_DATA_STAMP_MEMBER;

	/**
	 * @return the iNT_REF
	 */
	public String getINT_REF() {
		return INT_REF;
	}

	/**
	 * @param iNT_REF the iNT_REF to set
	 */
	public void setINT_REF(String iNT_REF) {
		INT_REF = iNT_REF;
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
	 * @return the sPLIT_VL
	 */
	public String getSPLIT_VL() {
		return SPLIT_VL;
	}

	/**
	 * @param sPLIT_VL the sPLIT_VL to set
	 */
	public void setSPLIT_VL(String sPLIT_VL) {
		SPLIT_VL = sPLIT_VL;
	}

	/**
	 * @return the dUE_DATE
	 */
	public String getDUE_DATE() {
		return DUE_DATE;
	}

	/**
	 * @param dUE_DATE the dUE_DATE to set
	 */
	public void setDUE_DATE(String dUE_DATE) {
		DUE_DATE = dUE_DATE;
	}

	/**
	 * @return the sTAMP_ID
	 */
	public String getSTAMP_ID() {
		return STAMP_ID;
	}

	/**
	 * @param sTAMP_ID the sTAMP_ID to set
	 */
	public void setSTAMP_ID(String sTAMP_ID) {
		STAMP_ID = sTAMP_ID;
	}

	/**
	 * @return the sECTION
	 */
	public String getSECTION() {
		return SECTION;
	}

	/**
	 * @param sECTION the sECTION to set
	 */
	public void setSECTION(String sECTION) {
		SECTION = sECTION;
	}

	/**
	 * @return the hEADER_DATA_STAMP_MEMBER
	 */
	public ArrayList<HEADER_DATA_STAMP_MEMBER> getHEADER_DATA_STAMP_MEMBER() {
		return HEADER_DATA_STAMP_MEMBER;
	}

	/**
	 * @param hEADER_DATA_STAMP_MEMBER the hEADER_DATA_STAMP_MEMBER to set
	 */
	public void setHEADER_DATA_STAMP_MEMBER(ArrayList<HEADER_DATA_STAMP_MEMBER> hEADER_DATA_STAMP_MEMBER) {
		HEADER_DATA_STAMP_MEMBER = hEADER_DATA_STAMP_MEMBER;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HEADER_DATA_INT [" + (INT_REF != null ? "INT_REF=" + INT_REF + ", " : "")
				+ (TR_ID != null ? "TR_ID=" + TR_ID + ", " : "")
				+ (SPLIT_VL != null ? "SPLIT_VL=" + SPLIT_VL + ", " : "")
				+ (DUE_DATE != null ? "DUE_DATE=" + DUE_DATE + ", " : "")
				+ (STAMP_ID != null ? "STAMP_ID=" + STAMP_ID + ", " : "")
				+ (SECTION != null ? "SECTION=" + SECTION + ", " : "")
				+ (HEADER_DATA_STAMP_MEMBER != null ? "HEADER_DATA_STAMP_MEMBER=" + HEADER_DATA_STAMP_MEMBER : "")
				+ "]";
	}
}
