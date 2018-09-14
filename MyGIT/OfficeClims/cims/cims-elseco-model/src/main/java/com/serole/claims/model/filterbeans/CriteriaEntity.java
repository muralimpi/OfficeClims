package com.serole.claims.model.filterbeans;

import java.sql.Date;

public class CriteriaEntity {
	
	private String id;
	private int claimHeaderId;
	private int claimDetailId;
	private Date effectiveDate;
	private String ucrNumber;
	private String ucrName;
	private String umrNumber;
	private String status;
	private int dealId;
	private String lloydsRiskCode;
	private String lobCode;	
	private String productCode;	
	private String extRefNo;
	private Date dateOfLoss;
	private String claimReporter;
	private String tabHandler;
		
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
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
	 * @return the claimDetailId
	 */
	public int getClaimDetailId() {
		return claimDetailId;
	}
	/**
	 * @param claimDetailId the claimDetailId to set
	 */
	public void setClaimDetailId(int claimDetailId) {
		this.claimDetailId = claimDetailId;
	}
	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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
	/**
	 * @return the dealId
	 */
	public int getDealId() {
		return dealId;
	}
	/**
	 * @param dealId the dealId to set
	 */
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	/**
	 * @return the lloydsRiskCode
	 */
	public String getLloydsRiskCode() {
		return lloydsRiskCode;
	}
	/**
	 * @param lloydsRiskCode the lloydsRiskCode to set
	 */
	public void setLloydsRiskCode(String lloydsRiskCode) {
		this.lloydsRiskCode = lloydsRiskCode;
	}
	/**
	 * @return the lobCode
	 */
	public String getLobCode() {
		return lobCode;
	}
	/**
	 * @param lobCode the lobCode to set
	 */
	public void setLobCode(String lobCode) {
		this.lobCode = lobCode;
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the extRefNo
	 */
	public String getExtRefNo() {
		return extRefNo;
	}
	/**
	 * @param extRefNo the extRefNo to set
	 */
	public void setExtRefNo(String extRefNo) {
		this.extRefNo = extRefNo;
	}
	/**
	 * @return the dateOfLoss
	 */
	public Date getDateOfLoss() {
		return dateOfLoss;
	}
	/**
	 * @param dateOfLoss the dateOfLoss to set
	 */
	public void setDateOfLoss(Date dateOfLoss) {
		this.dateOfLoss = dateOfLoss;
	}
	/**
	 * @return the claimReporter
	 */
	public String getClaimReporter() {
		return claimReporter;
	}
	/**
	 * @param claimReporter the claimReporter to set
	 */
	public void setClaimReporter(String claimReporter) {
		this.claimReporter = claimReporter;
	}
	/**
	 * @return the tabHandler
	 */
	public String getTabHandler() {
		return tabHandler;
	}
	/**
	 * @param tabHandler the tabHandler to set
	 */
	public void setTabHandler(String tabHandler) {
		this.tabHandler = tabHandler;
	}
}
