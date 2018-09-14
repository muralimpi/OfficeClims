package com.serole.claims.model.Elseco;

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
@Table(name = "\""+"${cims.hana.datasource.schema}"+"::EL_ClaimHeader_T\"", schema="${cims.hana.datasource.package}")
public class ElsecoClaimsHeader 	{			//extends Claims {
	public ElsecoClaimsHeader(){  }
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLAIM_HEADER_ID")
	private int claimHeaderId;   			//CLAIM_HEADER_ID	
		
	@Column(name = "VERSION")
	private String version  = "";   		//VERSION	
	
	@Column(name = "CHNG_INDICATOR")
	private String changeIndicator  = ""; 	//CHNG_INDICATOR	
	
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;  			//EFFECTIVE_DATE	
	
	@Column(name = "UCR_NO")
	private String ucrNumber  = "";  		//UCR_NO	
	
	@Column(name = "UCR_NAME")
	private String ucrName  = "";  			//UCR_NAME	
	
	@Column(name = "EVENT_CATEGORY")
	private String eventCategory  = "";  	//EVENT_CATEGORY	
	
	@Column(name = "EVENT_TYPE")
	private String eventType  = "";  		//EVENT_TYPE	
	
	@Column(name = "EVENT_ID")
	private int eventId;  					//EVENT_ID	
	
	@Column(name = "DT_EVENT_FROM")
	private Date eventFromDate;  			//DT_EVENT_FROM	
	
	@Column(name = "DT_EVENT_TO")
	private Date eventToDate;  				//DT_EVENT_TO
	
	@Column(name = "EVENT_DESCRIPTION")
	private String eventDescription  = "";	//EVENT_DESCRIPTION
	
	@Column(name = "EVENTDATENOTIF")
	private Date eventDateNotif;			//EVENTDATENOTIF
	
	@Column(name = "LOSS_TYPE")
	private String lossType  = ""; 			//LOSS_TYPE
	
	@Column(name = "DT_OF_LOSS")
	private Date dateOfLoss;  				//DT_OF_LOSS
	
	@Column(name = "TIME_OF_LOSS")
	private String timeOfLoss  = ""; 		//TIME_OF_LOSS
	
	@Column(name = "LOSS_TIME_ZONE")
	private String lossTimeZone  = ""; 		//LOSS_TIME_ZONE
	
	@Column(name = "CAUSE_OF_LOSS")
	private String causeOfLoss  = ""; 		//CAUSE_OF_LOSS
	
	@Column(name = "STREET")
	private String street  = ""; 			//STREET
	
	@Column(name = "HOUSE_NUM")
	private String houseNumber  = ""; 		//HOUSE_NUM
	
	@Column(name = "ZIP_CODE")
	private String zipCode  = "";  			//ZIP_CODE
	
	@Column(name = "CITY")
	private String city  = "";  			//CITY
	
	@Column(name = "COUNTRY")
	private String country  = ""; 			//COUNTRY
	
	@Column(name = "REGION")
	private String region  = "";  			//REGION
	
	@Column(name = "STATUS")
	private String status  = "Open";  		//STATUS
	
	@Column(name = "NEXT_STATUS")			//NEXT_STATUS
	private String nextStatus = "";
	
	@Column(name = "CLAIM_HANDLER")
	private String claimHandler  = ""; 		//CLAIM_HANDLER
	
	@Column(name = "DEAL_ID")
	private int dealId;  					//DEAL_ID
	
	@Column(name = "DEAL_TYPE")
	private String dealType  = "";			//"DEAL_TYPE"
	
	@Column(name = "PRODUCT_CD")
	private String productCode  = ""; 		//PRODUCT_CD
	
	@Column(name = "UMR_NO")
	private String umrNumber  = "";			//UMR_NO
	
	@Column(name = "LOB_CD")
	private String lobCode  = ""; 			//LOB_CD
	
	@Column(name = "CLAIM_REPORTER")
	private String claimReporter  = "";   	//CLAIM_REPORTER
	
	@Column(name = "INSURED")
	private String insured  = "";   		//INSURED
	
	@Column(name = "REINSURED")
	private String reinsured  = "";   		//REINSURED
	
	@Column(name = "INSURED_ID")
	private String insuredId  = "";   		//INSURED_ID
	
	@Column(name = "REINSURED_ID")
	private String reinsuredId  = "";   	//REINSURED_ID
	
	@Column(name = "LOCATION")
	private String location  = "";   		//LOCATION
		
	@Column(name = "SUBMISSION_ID")
	private int submissionId; 				//SUBMISSION_ID
	
	@Column(name = "BROKER_ID")
	private int brokerId; 					//BROKER_ID
	
	@Column(name = "LLOYDS_RISK_CD")
	private String lloydsRiskCode  = "";	//"LLOYDS_RISK_CD"
	
	@Column(name = "RISK_EXPIRY_DT")
	private Date riskExpiryDate; 			//"RISK_EXPIRY_DT"
	
	@Column(name = "RISK_INCEPTION_DT")
	private Date riskInceptionDate; 		//"RISK_INCEPTION_DT"
	
	@Column(name = "SECTION_NAME")
	private String sectionName  = "";		//"SECTION_NAME"
	
	@Column(name = "NEW_RECORD_IN")
	private String newRecordIn  = ""; 		//"NEW_RECORD_IN"
	
	@Column(name = "ELSECO_RISK_CD")
	private String elsecoRiskCd  = ""; 		//"ELSECO_RISK_CD"
	
	@Column(name = "LEADER_NAME")
	private String leaderName  = "";		//"LEADER_NAME"
	
	@Column(name = "LEADER_LINE_VL")
	private String leaderLineVl  = "";		//"LEADER_LINE_VL"
	
	@Column(name = "RISK_DOMICILE_FG")
	private String riskDomicileFg  = "";	//"RISK_DOMICILE_FG"
	
	@Column(name = "RISK_LOCATION_CD")
	private String riskLocationCode  = ""; 	//"RISK_LOCATION_CD"
	
	@Column(name = "INCEPTION_DATE")
	private Date inceptionDate;  			//INCEPTION_DATE
	
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;  				//EXPIRY_DATE
	
	@Column(name = "ELSECO_LEADER_FLAG")
	private String elsecoLeaderFlag = ""; 		//ELSECO_LEADER_FLAG
	
	@Column(name = "LIMIT_CURRENCY_CD")			//LIMIT_CURRENCY_CD
	private String limitCurrencyCode;
	
	@Column(name = "DELETE_FLAG")
	private String deleteFlag = ""; 		//DELETE_FLAG
	
	public ElsecoClaimsHeader(int claimHeaderId, String version, String eventDesc) {
		this.claimHeaderId = claimHeaderId;
		this.version = version;
		this.eventDescription = eventDesc;
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
		return "ElsecoClaimsHeader [claimHeaderId=" + claimHeaderId + ", "
				+ (version != null ? "version=" + version + ", " : "")
				+ (changeIndicator != null ? "changeIndicator=" + changeIndicator + ", " : "")
				+ (effectiveDate != null ? "effectiveDate=" + effectiveDate + ", " : "")
				+ (ucrNumber != null ? "ucrNumber=" + ucrNumber + ", " : "")
				+ (ucrName != null ? "ucrName=" + ucrName + ", " : "")
				+ (eventCategory != null ? "eventCategory=" + eventCategory + ", " : "")
				+ (eventType != null ? "eventType=" + eventType + ", " : "") + "eventId=" + eventId + ", "
				+ (eventFromDate != null ? "eventFromDate=" + eventFromDate + ", " : "")
				+ (eventToDate != null ? "eventToDate=" + eventToDate + ", " : "")
				+ (eventDescription != null ? "eventDescription=" + eventDescription + ", " : "")
				+ (eventDateNotif != null ? "eventDateNotif=" + eventDateNotif + ", " : "")
				+ (lossType != null ? "lossType=" + lossType + ", " : "")
				+ (dateOfLoss != null ? "dateOfLoss=" + dateOfLoss + ", " : "")
				+ (timeOfLoss != null ? "timeOfLoss=" + timeOfLoss + ", " : "")
				+ (lossTimeZone != null ? "lossTimeZone=" + lossTimeZone + ", " : "")
				+ (causeOfLoss != null ? "causeOfLoss=" + causeOfLoss + ", " : "")
				+ (street != null ? "street=" + street + ", " : "")
				+ (houseNumber != null ? "houseNumber=" + houseNumber + ", " : "")
				+ (zipCode != null ? "zipCode=" + zipCode + ", " : "") + (city != null ? "city=" + city + ", " : "")
				+ (country != null ? "country=" + country + ", " : "")
				+ (region != null ? "region=" + region + ", " : "") + (status != null ? "status=" + status + ", " : "")
				+ (nextStatus != null ? "nextStatus=" + nextStatus + ", " : "")
				+ (claimHandler != null ? "claimHandler=" + claimHandler + ", " : "") + "dealId=" + dealId + ", "
				+ (dealType != null ? "dealType=" + dealType + ", " : "")
				+ (productCode != null ? "productCode=" + productCode + ", " : "")
				+ (umrNumber != null ? "umrNumber=" + umrNumber + ", " : "")
				+ (lobCode != null ? "lobCode=" + lobCode + ", " : "")
				+ (claimReporter != null ? "claimReporter=" + claimReporter + ", " : "")
				+ (insured != null ? "insured=" + insured + ", " : "")
				+ (reinsured != null ? "reinsured=" + reinsured + ", " : "")
				+ (insuredId != null ? "insuredId=" + insuredId + ", " : "")
				+ (reinsuredId != null ? "reinsuredId=" + reinsuredId + ", " : "")
				+ (location != null ? "location=" + location + ", " : "") + "submissionId=" + submissionId
				+ ", brokerId=" + brokerId + ", "
				+ (lloydsRiskCode != null ? "lloydsRiskCode=" + lloydsRiskCode + ", " : "")
				+ (riskExpiryDate != null ? "riskExpiryDate=" + riskExpiryDate + ", " : "")
				+ (riskInceptionDate != null ? "riskInceptionDate=" + riskInceptionDate + ", " : "")
				+ (sectionName != null ? "sectionName=" + sectionName + ", " : "")
				+ (newRecordIn != null ? "newRecordIn=" + newRecordIn + ", " : "")
				+ (elsecoRiskCd != null ? "elsecoRiskCd=" + elsecoRiskCd + ", " : "")
				+ (leaderName != null ? "leaderName=" + leaderName + ", " : "")
				+ (leaderLineVl != null ? "leaderLineVl=" + leaderLineVl + ", " : "")
				+ (riskDomicileFg != null ? "riskDomicileFg=" + riskDomicileFg + ", " : "")
				+ (riskLocationCode != null ? "riskLocationCode=" + riskLocationCode + ", " : "")
				+ (inceptionDate != null ? "inceptionDate=" + inceptionDate + ", " : "")
				+ (expiryDate != null ? "expiryDate=" + expiryDate + ", " : "")
				+ (elsecoLeaderFlag != null ? "elsecoLeaderFlag=" + elsecoLeaderFlag + ", " : "")
				+ (limitCurrencyCode != null ? "limitCurrencyCode=" + limitCurrencyCode + ", " : "")
				+ (deleteFlag != null ? "deleteFlag=" + deleteFlag : "") + "]";
	}	
}
