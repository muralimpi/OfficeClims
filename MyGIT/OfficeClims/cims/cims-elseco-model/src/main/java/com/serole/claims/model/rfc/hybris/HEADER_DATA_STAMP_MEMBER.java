package com.serole.claims.model.rfc.hybris;

public class HEADER_DATA_STAMP_MEMBER {
	
	public String MEMBER_ID = "";
	
	public String PAYER_ID = "";
	
	public String COLL_TYPE = "";

	/**
	 * @return the mEMBER_ID
	 */
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}

	/**
	 * @param mEMBER_ID the mEMBER_ID to set
	 */
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	
	/**
	 * @return the pAYER_ID
	 */
	public String getPAYER_ID() {
		return PAYER_ID;
	}

	/**
	 * @param pAYER_ID the pAYER_ID to set
	 */
	public void setPAYER_ID(String pAYER_ID) {
		PAYER_ID = pAYER_ID;
	}

	/**
	 * @return the cOLL_TYPE
	 */
	public String getCOLL_TYPE() {
		return COLL_TYPE;
	}

	/**
	 * @param cOLL_TYPE the cOLL_TYPE to set
	 */
	public void setCOLL_TYPE(String cOLL_TYPE) {
		COLL_TYPE = cOLL_TYPE;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HEADER_DATA_STAMP_MEMBER [" + (MEMBER_ID != null ? "MEMBER_ID=" + MEMBER_ID + ", " : "")
				+ (PAYER_ID != null ? "PAYER_ID=" + PAYER_ID + ", " : "")
				+ (COLL_TYPE != null ? "COLL_TYPE=" + COLL_TYPE : "") + "]";
	}
}
