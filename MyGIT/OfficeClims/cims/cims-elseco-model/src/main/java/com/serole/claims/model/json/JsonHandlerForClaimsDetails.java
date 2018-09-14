package com.serole.claims.model.json;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import com.serole.claims.model.Elseco.ElsecoCheckList;
import com.serole.claims.model.Elseco.ElsecoClaimReserve;
import com.serole.claims.model.Elseco.ElsecoClaimsFile;
import com.serole.claims.model.Elseco.ElsecoClaimsInternalReference;
import com.serole.claims.model.Elseco.ElsecoClaimsItems;
import com.serole.claims.model.Elseco.ElsecoClaimsNotes;
import com.serole.claims.model.Elseco.ElsecoClaimsParticipant;
import com.serole.claims.model.Elseco.ElsecoClaimsTransaction;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
public class JsonHandlerForClaimsDetails 	{            
	public JsonHandlerForClaimsDetails(){  }  
	
	private int claimId;   							//CLAIM_ID
	
	private int claimHeaderId;   					//CLAIM_HEADER_ID		
	
	private String version  = "";   				//VERSION	
	
	private String changeIndicator  = ""; 			//CHNG_INDICATOR	
	
	private Date effctiveDate;  					//EFFECTIVE_DATE	
	
	private String claimReferenceNo  = "";  		//CLAIM_REFERENCE_NO
	
	private String flagAuthReported  = "";  		//FLG_AUTH_REPORTED	
	
	private String claimDetailStatus = "Open";  	//CLAIM_STATUS	
	
	private String nextStatus = "";  				//NEXT_STATUS
	
	private String claimReporter  = "";  			//CLAIM_REPORTER	
	
	private String claimAuthority  = "";  			//CLAIM_AUTHORITY	
		
	private String lossType  = ""; 					//LOSS_TYPE
	
	private String policyType  = ""; 				//POLICY_TYPE
	
	private Date dateOfLoss;  						//DT_OF_LOSS
	
	private String timeOfLoss  = ""; 				//TIME_OF_LOSS
	
	private Date lossTimeZone; 						//LOSS_TIME_ZONE
	
	private String causeOfLoss  = ""; 				//CAUSE_OF_LOSS
	
	private String street  = ""; 					//STREET
	
	private String houseNumber  = ""; 				//HOUSE_NUM
	
	private String zipCode  = "";  					//ZIP_CODE
	
	private String city  = "";  					//CITY
	
	private String country  = ""; 					//COUNTRY
	
	private String region  = "";  					//REGION
	
	private String statusChangeReason  = "";  		//STATUS_CHNG_REASON
	
	private String claimAuthGroup  = ""; 			//CLM_AUTH_GRP
	
	private int complexity;  						//COMPLEXITY
	
	private Date dateClaimOpen; 					//DT_CLAIM_OPEN
	
	private Date dateClaimExpiry; 					//DT_CLAIM_EXPIRY
	
	private Date dateLossReptCompany;				//DT_LOSS_REPT_COMPANY
	
	private Date dateLossReportedAgent; 			//DT_LOSS_REPORTED_AGENT

	private String claimProcTime  = ""; 			//CLAIM_PROC_TIME
	
	private int statusChg; 							//STATUSCHG

	private String flagSensitive  = ""; 			//FLG_SENSITIVE
	
	private String flagCovered  = ""; 				//FLG_COVERED

	private Date dtEffctive; 						//DT_EFFECTIVE

	private Date dateLossReported; 					//DT_LOSS_REPORTED

	private String extRefNo  = ""; 					//"EXTREFNO"

	private String lloydsRiskCode  = ""; 			//LLOYDS_RISK_CD

	private String lobCode  = "";  					//LOB_CD
	
	private String sectionName  = "";  				//SECTION_NAME
	
	private Date inceptionDate;  					//INCEPTION_DATE
	
	private Date expiryDate;  						//EXPIRY_DATE
	
	private String subject  = ""; 					//"SUBJECT"
	
	private String lineSizeVl  = "";				//"LINE_SIZE_VL"
	
	//private String splitClaimPercVl  = "";			//"SPLIT_CLAIM_PERC_VL"
	
	//private BigDecimal splitClaimPercAmt ;			//"SPLIT_CLAIM_PERC_AMT"
	
	private BigDecimal totalPriceAm;				//"TOTAL_PRICE_AM"
	
	private String orderPrecVl  = "";				//"ORDER_PREC_VL"
	
	private String signingPercVl  = "";				//"SIGNING_PERC_VL"
	
	private BigDecimal estimatedPremiumAM; 			//"ESTIMATED_PREMIUM_AM"
	
	private String tempLloydsRiskCd  = "";			//"TEMP_LLOYDS_RISK_CD"

	private String prmSplitPercVl  = "";			//"PRM_SPLIT_PERC_VL"

	private BigDecimal premiumAmt;					//"PREMIUM_AMT"

	private String buttonIndicator  = "";			//"BUTTON_INDICATOR"
	
	private Date settlementDate;  					//SETTLEMENT_DATE	
	
	private BigDecimal prevpaidAmtIndemnityER;  	//PREVPDCLAMT_INDEMNITY	
	
	private BigDecimal prevpaidAmtFeesER;  			//PREVPDCLAMT_FEES
		
	private BigDecimal prevpaidAmtExpensesER;  		//PREVPDCLAMT_EXPENSES
		
	private BigDecimal settlementAmtIndemnityER;	//SETLMNTCLAMT_INDEMNITY	
	
	private BigDecimal settlementAmtFeesER;			//SETLMNTCLAMT_FEES
		
	private BigDecimal settlementAmtExpensesER;		//SETLMNTCLAMT_EXPENSES	
	
	private BigDecimal reserveAmountIndemnityER;  	//RESERVEAMOUNT_INDEMNITY
		
	private BigDecimal reserveAmountFeesER; 		//RESERVEAMOUNT_FEES
		
	private BigDecimal reserveAmountExpensesER;		//RESERVEAMOUNT_EXPENSES
		
	private String deleteFlag  = "";
	
	ArrayList<ElsecoClaimsItems> ClaimsItemsInfo;
	
	ArrayList<ElsecoClaimsFile> ClaimsFileInfo;	
	
	ArrayList<ElsecoClaimReserve> ClaimReserveInfo;
	
	ArrayList<ElsecoClaimsNotes> ClaimNotesInfo;
		
	ArrayList<ElsecoClaimsParticipant> ClaimParticipantInfo; 
	
	ArrayList<ElsecoClaimsTransaction> policyTransactionsInfo;	
	
	ArrayList<ElsecoCheckList> ClaimsCheckListInfo;
	
	ArrayList<ElsecoClaimsInternalReference> ClaimDetailInternalReferenceInfo;

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

	/**
	 * @return the claimsItemsInfo
	 */
	public ArrayList<ElsecoClaimsItems> getClaimsItemsInfo() {
		return ClaimsItemsInfo;
	}

	/**
	 * @param claimsItemsInfo the claimsItemsInfo to set
	 */
	public void setClaimsItemsInfo(ArrayList<ElsecoClaimsItems> claimsItemsInfo) {
		ClaimsItemsInfo = claimsItemsInfo;
	}

	/**
	 * @return the claimsFileInfo
	 */
	public ArrayList<ElsecoClaimsFile> getClaimsFileInfo() {
		return ClaimsFileInfo;
	}

	/**
	 * @param claimsFileInfo the claimsFileInfo to set
	 */
	public void setClaimsFileInfo(ArrayList<ElsecoClaimsFile> claimsFileInfo) {
		ClaimsFileInfo = claimsFileInfo;
	}

	/**
	 * @return the claimReserveInfo
	 */
	public ArrayList<ElsecoClaimReserve> getClaimReserveInfo() {
		return ClaimReserveInfo;
	}

	/**
	 * @param claimReserveInfo the claimReserveInfo to set
	 */
	public void setClaimReserveInfo(ArrayList<ElsecoClaimReserve> claimReserveInfo) {
		ClaimReserveInfo = claimReserveInfo;
	}

	/**
	 * @return the claimNotesInfo
	 */
	public ArrayList<ElsecoClaimsNotes> getClaimNotesInfo() {
		return ClaimNotesInfo;
	}

	/**
	 * @param claimNotesInfo the claimNotesInfo to set
	 */
	public void setClaimNotesInfo(ArrayList<ElsecoClaimsNotes> claimNotesInfo) {
		ClaimNotesInfo = claimNotesInfo;
	}

	/**
	 * @return the claimParticipantInfo
	 */
	public ArrayList<ElsecoClaimsParticipant> getClaimParticipantInfo() {
		return ClaimParticipantInfo;
	}

	/**
	 * @param claimParticipantInfo the claimParticipantInfo to set
	 */
	public void setClaimParticipantInfo(ArrayList<ElsecoClaimsParticipant> claimParticipantInfo) {
		ClaimParticipantInfo = claimParticipantInfo;
	}

	/**
	 * @return the policyTransactionsInfo
	 */
	public ArrayList<ElsecoClaimsTransaction> getPolicyTransactionsInfo() {
		return policyTransactionsInfo;
	}

	/**
	 * @param policyTransactionsInfo the policyTransactionsInfo to set
	 */
	public void setPolicyTransactionsInfo(ArrayList<ElsecoClaimsTransaction> policyTransactionsInfo) {
		this.policyTransactionsInfo = policyTransactionsInfo;
	}

	/**
	 * @return the claimsCheckListInfo
	 */
	public ArrayList<ElsecoCheckList> getClaimsCheckListInfo() {
		return ClaimsCheckListInfo;
	}

	/**
	 * @param claimsCheckListInfo the claimsCheckListInfo to set
	 */
	public void setClaimsCheckListInfo(ArrayList<ElsecoCheckList> claimsCheckListInfo) {
		ClaimsCheckListInfo = claimsCheckListInfo;
	}

	/**
	 * @return the claimDetailInternalReferenceInfo
	 */
	public ArrayList<ElsecoClaimsInternalReference> getClaimDetailInternalReferenceInfo() {
		return ClaimDetailInternalReferenceInfo;
	}

	/**
	 * @param claimDetailInternalReferenceInfo the claimDetailInternalReferenceInfo to set
	 */
	public void setClaimDetailInternalReferenceInfo(
			ArrayList<ElsecoClaimsInternalReference> claimDetailInternalReferenceInfo) {
		ClaimDetailInternalReferenceInfo = claimDetailInternalReferenceInfo;
	}		
}
