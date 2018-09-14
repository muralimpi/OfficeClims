package com.serole.claims.model.Elseco;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
@Entity
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimDetail_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimDetails 	{            
	public ElsecoClaimDetails(){  }
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_ID")
	private int claimId;   							//CLAIM_ID
	
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId;   					//CLAIM_HEADER_ID		
	
	@Column(name = "VERSION")
	private String version  = "";   				//VERSION	
	
	@Column(name = "CHNG_INDICATOR")
	private String changeIndicator  = ""; 			//CHNG_INDICATOR	
	
	@Column(name = "EFFECTIVE_DATE")
	private Date effctiveDate;  					//EFFECTIVE_DATE	
	
	@Column(name = "CLAIM_REFERENCE_NO")
	private String claimReferenceNo  = "";  		//CLAIM_REFERENCE_NO
	
	@Column(name = "FLG_AUTH_REPORTED")
	private String flagAuthReported  = "";  		//FLG_AUTH_REPORTED	
	
	@Column(name = "CLAIM_DETAIL_STATUS")
	private String claimDetailStatus = "Open";  	//CLAIM_DETAIL_STATUS	
	
	@Column(name = "NEXT_STATUS")					//NEXT_STATUS
	private String nextStatus = "";
	
	@Column(name = "CLAIM_REPORTER")
	private String claimReporter  = "";  			//CLAIM_REPORTER	
	
	@Column(name = "CLAIM_AUTHORITY")
	private String claimAuthority  = "";  			//CLAIM_AUTHORITY	
		
	@Column(name = "LOSS_TYPE")
	private String lossType  = ""; 					//LOSS_TYPE
	
	@Column(name = "POLICY_TYPE")
	private String policyType  = ""; 				//POLICY_TYPE
	
	@Column(name = "DT_OF_LOSS")
	private Date dateOfLoss;  						//DT_OF_LOSS
	
	@Column(name = "TIME_OF_LOSS")
	private String timeOfLoss  = ""; 				//TIME_OF_LOSS
	
	@Column(name = "LOSS_TIME_ZONE")
	private Date lossTimeZone; 						//LOSS_TIME_ZONE
	
	@Column(name = "CAUSE_OF_LOSS")
	private String causeOfLoss  = ""; 				//CAUSE_OF_LOSS
	
	@Column(name = "STREET")
	private String street  = ""; 					//STREET
	
	@Column(name = "HOUSE_NUM")
	private String houseNumber  = ""; 				//HOUSE_NUM
	
	@Column(name = "ZIP_CODE")
	private String zipCode  = "";  					//ZIP_CODE
	
	@Column(name = "CITY")
	private String city  = "";  					//CITY
	
	@Column(name = "COUNTRY")
	private String country  = ""; 					//COUNTRY
	
	@Column(name = "REGION")
	private String region  = "";  					//REGION
	
	@Column(name = "STATUS_CHNG_REASON")
	private String statusChangeReason  = "";  		//STATUS_CHNG_REASON
	
	@Column(name = "CLM_AUTH_GRP")
	private String claimAuthGroup  = ""; 			//CLM_AUTH_GRP
	
	@Column(name = "COMPLEXITY")
	private int complexity;  						//COMPLEXITY
	
	@Column(name = "DT_CLAIM_OPEN")
	private Date dateClaimOpen; 					//DT_CLAIM_OPEN
	
	@Column(name = "DT_CLAIM_EXPIRY")
	private Date dateClaimExpiry; 					//DT_CLAIM_EXPIRY
	
	@Column(name = "DT_LOSS_REPT_COMPANY")
	private Date dateLossReptCompany;				//DT_LOSS_REPT_COMPANY
	
	@Column(name = "DT_LOSS_REPORTED_AGENT")
	private Date dateLossReportedAgent; 			//DT_LOSS_REPORTED_AGENT

	@Column(name = "CLAIM_PROC_TIME")
	private String claimProcTime  = ""; 			//CLAIM_PROC_TIME
	
	@Column(name = "STATUSCHG")
	private int statusChg; 							//STATUSCHG

	@Column(name = "FLG_SENSITIVE")
	private String flagSensitive  = ""; 			//FLG_SENSITIVE
	
	@Column(name = "FLG_COVERED")
	private String flagCovered  = ""; 				//FLG_COVERED

	@Column(name = "DT_EFFECTIVE")
	private Date dtEffctive; 						//DT_EFFECTIVE

	@Column(name = "DT_LOSS_REPORTED")
	private Date dateLossReported; 					//DT_LOSS_REPORTED

	@Column(name = "EXTREFNO")
	private String extRefNo  = ""; 					//"EXTREFNO"

	@Column(name = "LLOYDS_RISK_CD")
	private String lloydsRiskCode  = ""; 			//LLOYDS_RISK_CD

	@Column(name = "LOB_CD")
	private String lobCode  = "";  					//LOB_CD
	
	@Column(name = "SECTION_NAME")
	private String sectionName  = "";  				//SECTION_NAME
	
	@Column(name = "INCEPTION_DATE")
	private Date inceptionDate;  					//INCEPTION_DATE
	
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;  						//EXPIRY_DATE
	
	@Column(name = "SUBJECT")
	private String subject  = ""; 					//"SUBJECT"
			
	@Column(name = "TOTAL_PRICE_AM", columnDefinition="decimal", precision=15, scale=0)	
	private BigDecimal totalPriceAm;				//"TOTAL_PRICE_AM"
	
	@Column(name = "ORDER_PREC_VL")
	private String orderPrecVl  = "";				//"ORDER_PREC_VL"
	
	@Column(name = "SIGNING_PERC_VL")
	private String signingPercVl  = "";				//"SIGNING_PERC_VL"	
	
	@Column(name = "ESTIMATED_PREMIUM_AM", columnDefinition="decimal", precision=15, scale=0)	
	private BigDecimal estimatedPremiumAM; 			//"ESTIMATED_PREMIUM_AM"
	
	@Column(name = "TEMP_LLOYDS_RISK_CD")
	private String tempLloydsRiskCd  = "";			//"TEMP_LLOYDS_RISK_CD"

	@Column(name = "LINE_SIZE_VL")
	private String lineSizeVl  = "";				//"LINE_SIZE_VL"
	
	@Column(name = "PRM_SPLIT_PERC_VL")
	private String prmSplitPercVl  = "";			//"PRM_SPLIT_PERC_VL"
	
	@Column(name = "PREMIUM_AMT", columnDefinition="decimal", precision=15, scale=0)	
	private BigDecimal premiumAmt;					//"PREMIUM_AMT"

	@Column(name = "BUTTON_INDICATOR")
	private String buttonIndicator  = "";			//"BUTTON_INDICATOR"
	
	@Column(name = "SETTLEMENT_DATE")
	private Date settlementDate;  					//SETTLEMENT_DATE	
	
	@Column(name = "PREVPDCLAMT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtIndemnityER;  				//PREVPDCLAMT_INDEMNITY
	
	@Column(name = "PREVPDCLAMT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtFeesER;  					//PREVPDCLAMT_FEES
	
	@Column(name = "PREVPDCLAMT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal prevpaidAmtExpensesER;  				//PREVPDCLAMT_EXPENSES
	
	@Column(name = "SETLMNTCLAMT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtIndemnityER;				//SETLMNTCLAMT_INDEMNITY
	
	@Column(name = "SETLMNTCLAMT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtFeesER;					//SETLMNTCLAMT_FEES
	
	@Column(name = "SETLMNTCLAMT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal settlementAmtExpensesER;				//SETLMNTCLAMT_EXPENSES
	
	@Column(name = "RESERVEAMOUNT_INDEMNITY", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountIndemnityER;  			//RESERVEAMOUNT_INDEMNITY
	
	@Column(name = "RESERVEAMOUNT_FEES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountFeesER; 					//RESERVEAMOUNT_FEES
	
	@Column(name = "RESERVEAMOUNT_EXPENSES", columnDefinition="decimal", precision=15, scale=0)
	private BigDecimal reserveAmountExpensesER;				//RESERVEAMOUNT_EXPENSES
	
	@Column(name = "DELETE_FLAG")
	private String deleteFlag  = ""; 				//DELETE_FLAG	
	
	public ElsecoClaimDetails(int claimsId, int claimHeaderId, String version) {
		this.claimId = claimsId;
		this.claimHeaderId = claimHeaderId;
		this.version = version;		
	}

	/**
	 * @return the claimId
	 */
	public int getClaimId() {
		return claimId;
	}

	/**
	 * @param claimId the claimId to set
	 */
	public void setClaimId(int claimId) {
		this.claimId = claimId;
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
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the changeIndicator
	 */
	public String getChangeIndicator() {
		return changeIndicator;
	}

	/**
	 * @param changeIndicator the changeIndicator to set
	 */
	public void setChangeIndicator(String changeIndicator) {
		this.changeIndicator = changeIndicator;
	}

	/**
	 * @return the effctiveDate
	 */
	public Date getEffctiveDate() {
		return effctiveDate;
	}

	/**
	 * @param effctiveDate the effctiveDate to set
	 */
	public void setEffctiveDate(Date effctiveDate) {
		this.effctiveDate = effctiveDate;
	}

	/**
	 * @return the claimReferenceNo
	 */
	public String getClaimReferenceNo() {
		return claimReferenceNo;
	}

	/**
	 * @param claimReferenceNo the claimReferenceNo to set
	 */
	public void setClaimReferenceNo(String claimReferenceNo) {
		this.claimReferenceNo = claimReferenceNo;
	}

	/**
	 * @return the flagAuthReported
	 */
	public String getFlagAuthReported() {
		return flagAuthReported;
	}

	/**
	 * @param flagAuthReported the flagAuthReported to set
	 */
	public void setFlagAuthReported(String flagAuthReported) {
		this.flagAuthReported = flagAuthReported;
	}

	/**
	 * @return the claimDetailStatus
	 */
	public String getClaimDetailStatus() {
		return claimDetailStatus;
	}

	/**
	 * @param claimDetailStatus the claimDetailStatus to set
	 */
	public void setClaimDetailStatus(String claimDetailStatus) {
		this.claimDetailStatus = claimDetailStatus;
	}

	/**
	 * @return the nextStatus
	 */
	public String getNextStatus() {
		return nextStatus;
	}

	/**
	 * @param nextStatus the nextStatus to set
	 */
	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
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
	 * @return the claimAuthority
	 */
	public String getClaimAuthority() {
		return claimAuthority;
	}

	/**
	 * @param claimAuthority the claimAuthority to set
	 */
	public void setClaimAuthority(String claimAuthority) {
		this.claimAuthority = claimAuthority;
	}

	/**
	 * @return the lossType
	 */
	public String getLossType() {
		return lossType;
	}

	/**
	 * @param lossType the lossType to set
	 */
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	/**
	 * @return the policyType
	 */
	public String getPolicyType() {
		return policyType;
	}

	/**
	 * @param policyType the policyType to set
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
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
	 * @return the timeOfLoss
	 */
	public String getTimeOfLoss() {
		return timeOfLoss;
	}

	/**
	 * @param timeOfLoss the timeOfLoss to set
	 */
	public void setTimeOfLoss(String timeOfLoss) {
		this.timeOfLoss = timeOfLoss;
	}

	/**
	 * @return the lossTimeZone
	 */
	public Date getLossTimeZone() {
		return lossTimeZone;
	}

	/**
	 * @param lossTimeZone the lossTimeZone to set
	 */
	public void setLossTimeZone(Date lossTimeZone) {
		this.lossTimeZone = lossTimeZone;
	}

	/**
	 * @return the causeOfLoss
	 */
	public String getCauseOfLoss() {
		return causeOfLoss;
	}

	/**
	 * @param causeOfLoss the causeOfLoss to set
	 */
	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the statusChangeReason
	 */
	public String getStatusChangeReason() {
		return statusChangeReason;
	}

	/**
	 * @param statusChangeReason the statusChangeReason to set
	 */
	public void setStatusChangeReason(String statusChangeReason) {
		this.statusChangeReason = statusChangeReason;
	}

	/**
	 * @return the claimAuthGroup
	 */
	public String getClaimAuthGroup() {
		return claimAuthGroup;
	}

	/**
	 * @param claimAuthGroup the claimAuthGroup to set
	 */
	public void setClaimAuthGroup(String claimAuthGroup) {
		this.claimAuthGroup = claimAuthGroup;
	}

	/**
	 * @return the complexity
	 */
	public int getComplexity() {
		return complexity;
	}

	/**
	 * @param complexity the complexity to set
	 */
	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	/**
	 * @return the dateClaimOpen
	 */
	public Date getDateClaimOpen() {
		return dateClaimOpen;
	}

	/**
	 * @param dateClaimOpen the dateClaimOpen to set
	 */
	public void setDateClaimOpen(Date dateClaimOpen) {
		this.dateClaimOpen = dateClaimOpen;
	}

	/**
	 * @return the dateClaimExpiry
	 */
	public Date getDateClaimExpiry() {
		return dateClaimExpiry;
	}

	/**
	 * @param dateClaimExpiry the dateClaimExpiry to set
	 */
	public void setDateClaimExpiry(Date dateClaimExpiry) {
		this.dateClaimExpiry = dateClaimExpiry;
	}

	/**
	 * @return the dateLossReptCompany
	 */
	public Date getDateLossReptCompany() {
		return dateLossReptCompany;
	}

	/**
	 * @param dateLossReptCompany the dateLossReptCompany to set
	 */
	public void setDateLossReptCompany(Date dateLossReptCompany) {
		this.dateLossReptCompany = dateLossReptCompany;
	}

	/**
	 * @return the dateLossReportedAgent
	 */
	public Date getDateLossReportedAgent() {
		return dateLossReportedAgent;
	}

	/**
	 * @param dateLossReportedAgent the dateLossReportedAgent to set
	 */
	public void setDateLossReportedAgent(Date dateLossReportedAgent) {
		this.dateLossReportedAgent = dateLossReportedAgent;
	}

	/**
	 * @return the claimProcTime
	 */
	public String getClaimProcTime() {
		return claimProcTime;
	}

	/**
	 * @param claimProcTime the claimProcTime to set
	 */
	public void setClaimProcTime(String claimProcTime) {
		this.claimProcTime = claimProcTime;
	}

	/**
	 * @return the statusChg
	 */
	public int getStatusChg() {
		return statusChg;
	}

	/**
	 * @param statusChg the statusChg to set
	 */
	public void setStatusChg(int statusChg) {
		this.statusChg = statusChg;
	}

	/**
	 * @return the flagSensitive
	 */
	public String getFlagSensitive() {
		return flagSensitive;
	}

	/**
	 * @param flagSensitive the flagSensitive to set
	 */
	public void setFlagSensitive(String flagSensitive) {
		this.flagSensitive = flagSensitive;
	}

	/**
	 * @return the flagCovered
	 */
	public String getFlagCovered() {
		return flagCovered;
	}

	/**
	 * @param flagCovered the flagCovered to set
	 */
	public void setFlagCovered(String flagCovered) {
		this.flagCovered = flagCovered;
	}

	/**
	 * @return the dtEffctive
	 */
	public Date getDtEffctive() {
		return dtEffctive;
	}

	/**
	 * @param dtEffctive the dtEffctive to set
	 */
	public void setDtEffctive(Date dtEffctive) {
		this.dtEffctive = dtEffctive;
	}

	/**
	 * @return the dateLossReported
	 */
	public Date getDateLossReported() {
		return dateLossReported;
	}

	/**
	 * @param dateLossReported the dateLossReported to set
	 */
	public void setDateLossReported(Date dateLossReported) {
		this.dateLossReported = dateLossReported;
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
	 * @return the sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName the sectionName to set
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @return the inceptionDate
	 */
	public Date getInceptionDate() {
		return inceptionDate;
	}

	/**
	 * @param inceptionDate the inceptionDate to set
	 */
	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the totalPriceAm
	 */
	public BigDecimal getTotalPriceAm() {
		return totalPriceAm;
	}

	/**
	 * @param totalPriceAm the totalPriceAm to set
	 */
	public void setTotalPriceAm(BigDecimal totalPriceAm) {
		this.totalPriceAm = totalPriceAm;
	}

	/**
	 * @return the orderPrecVl
	 */
	public String getOrderPrecVl() {
		return orderPrecVl;
	}

	/**
	 * @param orderPrecVl the orderPrecVl to set
	 */
	public void setOrderPrecVl(String orderPrecVl) {
		this.orderPrecVl = orderPrecVl;
	}

	/**
	 * @return the signingPercVl
	 */
	public String getSigningPercVl() {
		return signingPercVl;
	}

	/**
	 * @param signingPercVl the signingPercVl to set
	 */
	public void setSigningPercVl(String signingPercVl) {
		this.signingPercVl = signingPercVl;
	}

	/**
	 * @return the estimatedPremiumAM
	 */
	public BigDecimal getEstimatedPremiumAM() {
		return estimatedPremiumAM;
	}

	/**
	 * @param estimatedPremiumAM the estimatedPremiumAM to set
	 */
	public void setEstimatedPremiumAM(BigDecimal estimatedPremiumAM) {
		this.estimatedPremiumAM = estimatedPremiumAM;
	}

	/**
	 * @return the tempLloydsRiskCd
	 */
	public String getTempLloydsRiskCd() {
		return tempLloydsRiskCd;
	}

	/**
	 * @param tempLloydsRiskCd the tempLloydsRiskCd to set
	 */
	public void setTempLloydsRiskCd(String tempLloydsRiskCd) {
		this.tempLloydsRiskCd = tempLloydsRiskCd;
	}

	/**
	 * @return the lineSizeVl
	 */
	public String getLineSizeVl() {
		return lineSizeVl;
	}

	/**
	 * @param lineSizeVl the lineSizeVl to set
	 */
	public void setLineSizeVl(String lineSizeVl) {
		this.lineSizeVl = lineSizeVl;
	}

	/**
	 * @return the prmSplitPercVl
	 */
	public String getPrmSplitPercVl() {
		return prmSplitPercVl;
	}

	/**
	 * @param prmSplitPercVl the prmSplitPercVl to set
	 */
	public void setPrmSplitPercVl(String prmSplitPercVl) {
		this.prmSplitPercVl = prmSplitPercVl;
	}

	/**
	 * @return the premiumAmt
	 */
	public BigDecimal getPremiumAmt() {
		return premiumAmt;
	}

	/**
	 * @param premiumAmt the premiumAmt to set
	 */
	public void setPremiumAmt(BigDecimal premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	/**
	 * @return the buttonIndicator
	 */
	public String getButtonIndicator() {
		return buttonIndicator;
	}

	/**
	 * @param buttonIndicator the buttonIndicator to set
	 */
	public void setButtonIndicator(String buttonIndicator) {
		this.buttonIndicator = buttonIndicator;
	}

	/**
	 * @return the settlementDate
	 */
	public Date getSettlementDate() {
		return settlementDate;
	}

	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	/**
	 * @return the prevpaidAmtIndemnityER
	 */
	public BigDecimal getPrevpaidAmtIndemnityER() {
		return prevpaidAmtIndemnityER;
	}

	/**
	 * @param prevpaidAmtIndemnityER the prevpaidAmtIndemnityER to set
	 */
	public void setPrevpaidAmtIndemnityER(BigDecimal prevpaidAmtIndemnityER) {
		this.prevpaidAmtIndemnityER = prevpaidAmtIndemnityER;
	}

	/**
	 * @return the prevpaidAmtFeesER
	 */
	public BigDecimal getPrevpaidAmtFeesER() {
		return prevpaidAmtFeesER;
	}

	/**
	 * @param prevpaidAmtFeesER the prevpaidAmtFeesER to set
	 */
	public void setPrevpaidAmtFeesER(BigDecimal prevpaidAmtFeesER) {
		this.prevpaidAmtFeesER = prevpaidAmtFeesER;
	}

	/**
	 * @return the prevpaidAmtExpensesER
	 */
	public BigDecimal getPrevpaidAmtExpensesER() {
		return prevpaidAmtExpensesER;
	}

	/**
	 * @param prevpaidAmtExpensesER the prevpaidAmtExpensesER to set
	 */
	public void setPrevpaidAmtExpensesER(BigDecimal prevpaidAmtExpensesER) {
		this.prevpaidAmtExpensesER = prevpaidAmtExpensesER;
	}

	/**
	 * @return the settlementAmtIndemnityER
	 */
	public BigDecimal getSettlementAmtIndemnityER() {
		return settlementAmtIndemnityER;
	}

	/**
	 * @param settlementAmtIndemnityER the settlementAmtIndemnityER to set
	 */
	public void setSettlementAmtIndemnityER(BigDecimal settlementAmtIndemnityER) {
		this.settlementAmtIndemnityER = settlementAmtIndemnityER;
	}

	/**
	 * @return the settlementAmtFeesER
	 */
	public BigDecimal getSettlementAmtFeesER() {
		return settlementAmtFeesER;
	}

	/**
	 * @param settlementAmtFeesER the settlementAmtFeesER to set
	 */
	public void setSettlementAmtFeesER(BigDecimal settlementAmtFeesER) {
		this.settlementAmtFeesER = settlementAmtFeesER;
	}

	/**
	 * @return the settlementAmtExpensesER
	 */
	public BigDecimal getSettlementAmtExpensesER() {
		return settlementAmtExpensesER;
	}

	/**
	 * @param settlementAmtExpensesER the settlementAmtExpensesER to set
	 */
	public void setSettlementAmtExpensesER(BigDecimal settlementAmtExpensesER) {
		this.settlementAmtExpensesER = settlementAmtExpensesER;
	}

	/**
	 * @return the reserveAmountIndemnityER
	 */
	public BigDecimal getReserveAmountIndemnityER() {
		return reserveAmountIndemnityER;
	}

	/**
	 * @param reserveAmountIndemnityER the reserveAmountIndemnityER to set
	 */
	public void setReserveAmountIndemnityER(BigDecimal reserveAmountIndemnityER) {
		this.reserveAmountIndemnityER = reserveAmountIndemnityER;
	}

	/**
	 * @return the reserveAmountFeesER
	 */
	public BigDecimal getReserveAmountFeesER() {
		return reserveAmountFeesER;
	}

	/**
	 * @param reserveAmountFeesER the reserveAmountFeesER to set
	 */
	public void setReserveAmountFeesER(BigDecimal reserveAmountFeesER) {
		this.reserveAmountFeesER = reserveAmountFeesER;
	}

	/**
	 * @return the reserveAmountExpensesER
	 */
	public BigDecimal getReserveAmountExpensesER() {
		return reserveAmountExpensesER;
	}

	/**
	 * @param reserveAmountExpensesER the reserveAmountExpensesER to set
	 */
	public void setReserveAmountExpensesER(BigDecimal reserveAmountExpensesER) {
		this.reserveAmountExpensesER = reserveAmountExpensesER;
	}

	/**
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElsecoClaimDetails [claimId=" + claimId + ", claimHeaderId=" + claimHeaderId + ", "
				+ (version != null ? "version=" + version + ", " : "")
				+ (changeIndicator != null ? "changeIndicator=" + changeIndicator + ", " : "")
				+ (effctiveDate != null ? "effctiveDate=" + effctiveDate + ", " : "")
				+ (claimReferenceNo != null ? "claimReferenceNo=" + claimReferenceNo + ", " : "")
				+ (flagAuthReported != null ? "flagAuthReported=" + flagAuthReported + ", " : "")
				+ (claimDetailStatus != null ? "claimDetailStatus=" + claimDetailStatus + ", " : "")
				+ (nextStatus != null ? "nextStatus=" + nextStatus + ", " : "")
				+ (claimReporter != null ? "claimReporter=" + claimReporter + ", " : "")
				+ (claimAuthority != null ? "claimAuthority=" + claimAuthority + ", " : "")
				+ (lossType != null ? "lossType=" + lossType + ", " : "")
				+ (policyType != null ? "policyType=" + policyType + ", " : "")
				+ (dateOfLoss != null ? "dateOfLoss=" + dateOfLoss + ", " : "")
				+ (timeOfLoss != null ? "timeOfLoss=" + timeOfLoss + ", " : "")
				+ (lossTimeZone != null ? "lossTimeZone=" + lossTimeZone + ", " : "")
				+ (causeOfLoss != null ? "causeOfLoss=" + causeOfLoss + ", " : "")
				+ (street != null ? "street=" + street + ", " : "")
				+ (houseNumber != null ? "houseNumber=" + houseNumber + ", " : "")
				+ (zipCode != null ? "zipCode=" + zipCode + ", " : "") + (city != null ? "city=" + city + ", " : "")
				+ (country != null ? "country=" + country + ", " : "")
				+ (region != null ? "region=" + region + ", " : "")
				+ (statusChangeReason != null ? "statusChangeReason=" + statusChangeReason + ", " : "")
				+ (claimAuthGroup != null ? "claimAuthGroup=" + claimAuthGroup + ", " : "") + "complexity=" + complexity
				+ ", " + (dateClaimOpen != null ? "dateClaimOpen=" + dateClaimOpen + ", " : "")
				+ (dateClaimExpiry != null ? "dateClaimExpiry=" + dateClaimExpiry + ", " : "")
				+ (dateLossReptCompany != null ? "dateLossReptCompany=" + dateLossReptCompany + ", " : "")
				+ (dateLossReportedAgent != null ? "dateLossReportedAgent=" + dateLossReportedAgent + ", " : "")
				+ (claimProcTime != null ? "claimProcTime=" + claimProcTime + ", " : "") + "statusChg=" + statusChg
				+ ", " + (flagSensitive != null ? "flagSensitive=" + flagSensitive + ", " : "")
				+ (flagCovered != null ? "flagCovered=" + flagCovered + ", " : "")
				+ (dtEffctive != null ? "dtEffctive=" + dtEffctive + ", " : "")
				+ (dateLossReported != null ? "dateLossReported=" + dateLossReported + ", " : "")
				+ (extRefNo != null ? "extRefNo=" + extRefNo + ", " : "")
				+ (lloydsRiskCode != null ? "lloydsRiskCode=" + lloydsRiskCode + ", " : "")
				+ (lobCode != null ? "lobCode=" + lobCode + ", " : "")
				+ (sectionName != null ? "sectionName=" + sectionName + ", " : "")
				+ (inceptionDate != null ? "inceptionDate=" + inceptionDate + ", " : "")
				+ (expiryDate != null ? "expiryDate=" + expiryDate + ", " : "")
				+ (subject != null ? "subject=" + subject + ", " : "")
				+ (totalPriceAm != null ? "totalPriceAm=" + totalPriceAm + ", " : "")
				+ (orderPrecVl != null ? "orderPrecVl=" + orderPrecVl + ", " : "")
				+ (signingPercVl != null ? "signingPercVl=" + signingPercVl + ", " : "")
				+ (estimatedPremiumAM != null ? "estimatedPremiumAM=" + estimatedPremiumAM + ", " : "")
				+ (tempLloydsRiskCd != null ? "tempLloydsRiskCd=" + tempLloydsRiskCd + ", " : "")
				+ (lineSizeVl != null ? "lineSizeVl=" + lineSizeVl + ", " : "")
				+ (prmSplitPercVl != null ? "prmSplitPercVl=" + prmSplitPercVl + ", " : "")
				+ (premiumAmt != null ? "premiumAmt=" + premiumAmt + ", " : "")
				+ (buttonIndicator != null ? "buttonIndicator=" + buttonIndicator + ", " : "")
				+ (settlementDate != null ? "settlementDate=" + settlementDate + ", " : "")
				+ (prevpaidAmtIndemnityER != null ? "prevpaidAmtIndemnityER=" + prevpaidAmtIndemnityER + ", " : "")
				+ (prevpaidAmtFeesER != null ? "prevpaidAmtFeesER=" + prevpaidAmtFeesER + ", " : "")
				+ (prevpaidAmtExpensesER != null ? "prevpaidAmtExpensesER=" + prevpaidAmtExpensesER + ", " : "")
				+ (settlementAmtIndemnityER != null ? "settlementAmtIndemnityER=" + settlementAmtIndemnityER + ", "
						: "")
				+ (settlementAmtFeesER != null ? "settlementAmtFeesER=" + settlementAmtFeesER + ", " : "")
				+ (settlementAmtExpensesER != null ? "settlementAmtExpensesER=" + settlementAmtExpensesER + ", " : "")
				+ (reserveAmountIndemnityER != null ? "reserveAmountIndemnityER=" + reserveAmountIndemnityER + ", "
						: "")
				+ (reserveAmountFeesER != null ? "reserveAmountFeesER=" + reserveAmountFeesER + ", " : "")
				+ (reserveAmountExpensesER != null ? "reserveAmountExpensesER=" + reserveAmountExpensesER + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}