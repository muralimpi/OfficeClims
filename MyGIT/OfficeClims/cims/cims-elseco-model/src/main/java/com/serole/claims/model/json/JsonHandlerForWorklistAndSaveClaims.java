package com.serole.claims.model.json;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.serole.claims.model.Elseco.ElsecoCheckList;
import com.serole.claims.model.Elseco.ElsecoClaimsNotes;
import com.serole.claims.model.Elseco.ElsecoClaimsParty;
import com.serole.claims.model.Elseco.ElsecoClaimsTransaction;
import com.serole.claims.model.Elseco.ElsecoRiskObject;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
public class JsonHandlerForWorklistAndSaveClaims {
	public JsonHandlerForWorklistAndSaveClaims(){  }
	     
	private int claimHeaderId;   			//CLAIM_HEADER_ID	
	
	private String version = "";   			//VERSION	
	
	private String changeIndicator = ""; 	//CHNG_INDICATOR	
	
	private Date effectiveDate;  			//EFFECTIVE_DATE	
	
	private String ucrNumber = "";  		//UCR_NO	
	
	private String ucrName = "";  			//UCR_NAME	
	
	private String eventCategory = "";  	//EVENT_CATEGORY	
	
	private String eventType = "";  		//EVENT_TYPE	
	
	private int eventId;  					//EVENT_ID	
	
	private Date eventFromDate;  			//DT_EVENT_FROM	
	
	private Date eventToDate;  				//DT_EVENT_TO
	
	private String eventDescription = "";	//EVENT_DESCRIPTION
	
	private String lossType = ""; 			//LOSS_TYPE
	
	private Date dateOfLoss;  				//DT_OF_LOSS
	
	private String timeOfLoss = ""; 		//TIME_OF_LOSS
	
	private String lossTimeZone = ""; 		//LOSS_TIME_ZONE
	
	private String causeOfLoss = ""; 		//CAUSE_OF_LOSS
	
	private String street = ""; 			//STREET
	
	private String houseNumber = ""; 		//HOUSE_NUM
	
	private String zipCode = "";  			//ZIP_CODE
	
	private String city = "";  				//CITY
	
	private String country = ""; 			//COUNTRY
	
	private String region = "";  			//REGION
	
	private String status = "Open";  		//STATUS
	
	private String nextStatus = "";  		//NEXT_STATUS
	
	private String claimHandler = ""; 		//CLAIM_HANDLER
	
	private int dealId;  					//DEAL_ID
	
	private String dealType = "";  			//DEAL_TYPE
	
	private String productCode = ""; 		//PRODUCT_CD
	
	private String umrNumber = "";			//UMR_NO
	
	private String lobCode = ""; 			//LOB_CD
	
	private String claimReporter = ""; 		//CLAIM_REPORTER
	
	private String insured = "";   			//INSURED
	
	private String reinsured = ""; 			//REINSURED
	
	private String insuredId = "";   		//INSURED_ID
	
	private String reinsuredId = ""; 		//REINSURED_ID
	
	private String location = "";   		//LOCATION
	
	private String extRefNo = "";			//EXTREFNO
		
	private String lloydsRiskCode = "";		//Lloyds Risk Code
	
	private int submissionId = 0;   		//SUBMISSION_ID
	
	private int brokerId;					//BROKER_ID
	
	private Date eventDateNotif;   			//EVENTDATENOTIF	
	
	private Date riskExpiryDate; 			//"RISK_EXPIRY_DT"	
	
	private Date riskInceptionDate; 		//"RISK_INCEPTION_DT"
	
	private String sectionName = "";		//"SECTION_NAME"
	
	private String newRecordIn = ""; 			//"NEW_RECORD_IN"
	
	private String elsecoRiskCd = ""; 			//"ELSECO_RISK_CD"
	
	private String leaderName = "";				//"LEADER_NAME"
	
	private String leaderLineVl = "";			//"LEADER_LINE_VL"
	
	private String riskDomicileFg = "";			//"RISK_DOMICILE_FG"
	
	private String riskLocationCode = ""; 		//"RISK_LOCATION_CD"
	
	private String elsecoLeaderFlag = ""; 		//ELSECO_LEADER_FLAG
	
	private Date inceptionDate;  				//INCEPTION_DATE
	
	private Date expiryDate;  					//EXPIRY_DATE
	
	private String limitCurrencyCode;			//LIMIT_CURRENCY_CD
	
	private String deleteFlag = "";
	
	ArrayList<JsonHandlerForClaimsDetails> ClaimDetailsInfo; 	
	
	ArrayList<ElsecoClaimsParty> ClaimPartyInfo; 
	
	ArrayList<ElsecoRiskObject> ClaimRiskInfo;
	
	ArrayList<ElsecoClaimsNotes> ClaimNotesInfo;
	
	ArrayList<ElsecoClaimsTransaction> marketTransactionsInfo;
	
	ArrayList<ElsecoCheckList> ClaimsCheckListInfo;

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
	 * @return the eventCategory
	 */
	public String getEventCategory() {
		return eventCategory;
	}

	/**
	 * @param eventCategory the eventCategory to set
	 */
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the brokerId
	 */
	public int getBrokerId() {
		return brokerId;
	}

	/**
	 * @param brokerId the brokerId to set
	 */
	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}

	/**
	 * @return the eventFromDate
	 */
	public Date getEventFromDate() {
		return eventFromDate;
	}

	/**
	 * @param eventFromDate the eventFromDate to set
	 */
	public void setEventFromDate(Date eventFromDate) {
		this.eventFromDate = eventFromDate;
	}

	/**
	 * @return the eventToDate
	 */
	public Date getEventToDate() {
		return eventToDate;
	}

	/**
	 * @param eventToDate the eventToDate to set
	 */
	public void setEventToDate(Date eventToDate) {
		this.eventToDate = eventToDate;
	}

	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}

	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
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
	public String getLossTimeZone() {
		return lossTimeZone;
	}

	/**
	 * @param lossTimeZone the lossTimeZone to set
	 */
	public void setLossTimeZone(String lossTimeZone) {
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
	 * @return the claimHandler
	 */
	public String getClaimHandler() {
		return claimHandler;
	}

	/**
	 * @param claimHandler the claimHandler to set
	 */
	public void setClaimHandler(String claimHandler) {
		this.claimHandler = claimHandler;
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
	 * @return the dealType
	 */
	public String getDealType() {
		return dealType;
	}

	/**
	 * @param dealType the dealType to set
	 */
	public void setDealType(String dealType) {
		this.dealType = dealType;
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
	 * @return the insured
	 */
	public String getInsured() {
		return insured;
	}

	/**
	 * @param insured the insured to set
	 */
	public void setInsured(String insured) {
		this.insured = insured;
	}

	/**
	 * @return the reinsured
	 */
	public String getReinsured() {
		return reinsured;
	}

	/**
	 * @param reinsured the reinsured to set
	 */
	public void setReinsured(String reinsured) {
		this.reinsured = reinsured;
	}

	/**
	 * @return the insuredId
	 */
	public String getInsuredId() {
		return insuredId;
	}

	/**
	 * @param insuredId the insuredId to set
	 */
	public void setInsuredId(String insuredId) {
		this.insuredId = insuredId;
	}

	/**
	 * @return the reinsuredId
	 */
	public String getReinsuredId() {
		return reinsuredId;
	}

	/**
	 * @param reinsuredId the reinsuredId to set
	 */
	public void setReinsuredId(String reinsuredId) {
		this.reinsuredId = reinsuredId;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @return the submissionId
	 */
	public int getSubmissionId() {
		return submissionId;
	}

	/**
	 * @param submissionId the submissionId to set
	 */
	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}

	/**
	 * @return the eventDateNotif
	 */
	public Date getEventDateNotif() {
		return eventDateNotif;
	}

	/**
	 * @param eventDateNotif the eventDateNotif to set
	 */
	public void setEventDateNotif(Date eventDateNotif) {
		this.eventDateNotif = eventDateNotif;
	}

	/**
	 * @return the riskExpiryDate
	 */
	public Date getRiskExpiryDate() {
		return riskExpiryDate;
	}

	/**
	 * @param riskExpiryDate the riskExpiryDate to set
	 */
	public void setRiskExpiryDate(Date riskExpiryDate) {
		this.riskExpiryDate = riskExpiryDate;
	}

	/**
	 * @return the riskInceptionDate
	 */
	public Date getRiskInceptionDate() {
		return riskInceptionDate;
	}

	/**
	 * @param riskInceptionDate the riskInceptionDate to set
	 */
	public void setRiskInceptionDate(Date riskInceptionDate) {
		this.riskInceptionDate = riskInceptionDate;
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
	 * @return the newRecordIn
	 */
	public String getNewRecordIn() {
		return newRecordIn;
	}

	/**
	 * @param newRecordIn the newRecordIn to set
	 */
	public void setNewRecordIn(String newRecordIn) {
		this.newRecordIn = newRecordIn;
	}

	/**
	 * @return the elsecoRiskCd
	 */
	public String getElsecoRiskCd() {
		return elsecoRiskCd;
	}

	/**
	 * @param elsecoRiskCd the elsecoRiskCd to set
	 */
	public void setElsecoRiskCd(String elsecoRiskCd) {
		this.elsecoRiskCd = elsecoRiskCd;
	}

	/**
	 * @return the leaderName
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * @param leaderName the leaderName to set
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	/**
	 * @return the leaderLineVl
	 */
	public String getLeaderLineVl() {
		return leaderLineVl;
	}

	/**
	 * @param leaderLineVl the leaderLineVl to set
	 */
	public void setLeaderLineVl(String leaderLineVl) {
		this.leaderLineVl = leaderLineVl;
	}

	/**
	 * @return the riskDomicileFg
	 */
	public String getRiskDomicileFg() {
		return riskDomicileFg;
	}

	/**
	 * @param riskDomicileFg the riskDomicileFg to set
	 */
	public void setRiskDomicileFg(String riskDomicileFg) {
		this.riskDomicileFg = riskDomicileFg;
	}

	/**
	 * @return the riskLocationCode
	 */
	public String getRiskLocationCode() {
		return riskLocationCode;
	}

	/**
	 * @param riskLocationCode the riskLocationCode to set
	 */
	public void setRiskLocationCode(String riskLocationCode) {
		this.riskLocationCode = riskLocationCode;
	}

	/**
	 * @return the elsecoLeaderFlag
	 */
	public String getElsecoLeaderFlag() {
		return elsecoLeaderFlag;
	}

	/**
	 * @param elsecoLeaderFlag the elsecoLeaderFlag to set
	 */
	public void setElsecoLeaderFlag(String elsecoLeaderFlag) {
		this.elsecoLeaderFlag = elsecoLeaderFlag;
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
	 * @return the claimDetailsInfo
	 */
	public ArrayList<JsonHandlerForClaimsDetails> getClaimDetailsInfo() {
		return ClaimDetailsInfo;
	}

	/**
	 * @param claimDetailsInfo the claimDetailsInfo to set
	 */
	public void setClaimDetailsInfo(ArrayList<JsonHandlerForClaimsDetails> claimDetailsInfo) {
		ClaimDetailsInfo = claimDetailsInfo;
	}

	/**
	 * @return the claimRiskInfo
	 */
	public ArrayList<ElsecoRiskObject> getClaimRiskInfo() {
		return ClaimRiskInfo;
	}

	/**
	 * @param claimRiskInfo the claimRiskInfo to set
	 */
	public void setClaimRiskInfo(ArrayList<ElsecoRiskObject> claimRiskInfo) {
		ClaimRiskInfo = claimRiskInfo;
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
	 * @return the marketTransactionsInfo
	 */
	public ArrayList<ElsecoClaimsTransaction> getMarketTransactionsInfo() {
		return marketTransactionsInfo;
	}

	/**
	 * @param marketTransactionsInfo the marketTransactionsInfo to set
	 */
	public void setMarketTransactionsInfo(ArrayList<ElsecoClaimsTransaction> marketTransactionsInfo) {
		this.marketTransactionsInfo = marketTransactionsInfo;
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
	 * @return the claimPartyInfo
	 */
	public ArrayList<ElsecoClaimsParty> getClaimPartyInfo() {
		return ClaimPartyInfo;
	}

	/**
	 * @param claimPartyInfo the claimPartyInfo to set
	 */
	public void setClaimPartyInfo(ArrayList<ElsecoClaimsParty> claimPartyInfo) {
		ClaimPartyInfo = claimPartyInfo;
	}

	/**
	 * @return the limitCurrencyCode
	 */
	public String getLimitCurrencyCode() {
		return limitCurrencyCode;
	}

	/**
	 * @param limitCurrencyCode the limitCurrencyCode to set
	 */
	public void setLimitCurrencyCode(String limitCurrencyCode) {
		this.limitCurrencyCode = limitCurrencyCode;
	}
	
}
