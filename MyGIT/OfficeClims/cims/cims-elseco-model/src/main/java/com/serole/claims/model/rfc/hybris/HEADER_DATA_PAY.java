package com.serole.claims.model.rfc.hybris;

public class HEADER_DATA_PAY {
	
	public String PAYEE = "";
	
	public String PAYEE_EMAIL = "";

	public String PAYEE_ACC = "";	
		
	public String PAYEE_AM = "";
	
	public String PAY_DT = "";

	/**
	 * @return the pAYEE
	 */
	public String getPAYEE() {
		return PAYEE;
	}

	/**
	 * @param pAYEE the pAYEE to set
	 */
	public void setPAYEE(String pAYEE) {
		PAYEE = pAYEE;
	}

	/**
	 * @return the pAYEE_ACC
	 */
	public String getPAYEE_ACC() {
		return PAYEE_ACC;
	}

	/**
	 * @param pAYEE_ACC the pAYEE_ACC to set
	 */
	public void setPAYEE_ACC(String pAYEE_ACC) {
		PAYEE_ACC = pAYEE_ACC;
	}
	
	/**
	 * @return the pAYEE_AM
	 */
	public String getPAYEE_AM() {
		return PAYEE_AM;
	}

	/**
	 * @param pAYEE_AM the pAYEE_AM to set
	 */
	public void setPAYEE_AM(String pAYEE_AM) {
		PAYEE_AM = pAYEE_AM;
	}

	/**
	 * @return the pAYEE_EMAIL
	 */
	public String getPAYEE_EMAIL() {
		return PAYEE_EMAIL;
	}

	/**
	 * @param pAYEE_EMAIL the pAYEE_EMAIL to set
	 */
	public void setPAYEE_EMAIL(String pAYEE_EMAIL) {
		PAYEE_EMAIL = pAYEE_EMAIL;
	}

	/**
	 * @return the pAY_DT
	 */
	public String getPAY_DT() {
		return PAY_DT;
	}

	/**
	 * @param pAY_DT the pAY_DT to set
	 */
	public void setPAY_DT(String pAY_DT) {
		PAY_DT = pAY_DT;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HEADER_DATA_PAY [" + (PAYEE != null ? "PAYEE=" + PAYEE + ", " : "")
				+ (PAYEE_EMAIL != null ? "PAYEE_EMAIL=" + PAYEE_EMAIL + ", " : "")
				+ (PAYEE_ACC != null ? "PAYEE_ACC=" + PAYEE_ACC + ", " : "")
				+ (PAYEE_AM != null ? "PAYEE_AM=" + PAYEE_AM + ", " : "") + (PAY_DT != null ? "PAY_DT=" + PAY_DT : "")
				+ "]";
	}	
}
