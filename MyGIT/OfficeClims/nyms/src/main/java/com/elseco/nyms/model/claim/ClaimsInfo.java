
package com.elseco.nyms.model.claim;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "claimHeaderId",
    "version",
    "changeIndicator",
    "effectiveDate",
    "ucrNumber",
    "ucrName",
    "eventCategory",
    "eventType",
    "eventId",
    "eventFromDate",
    "eventToDate",
    "eventDescription",
    "lossType",
    "dateOfLoss",
    "timeOfLoss",
    "lossTimeZone",
    "causeOfLoss",
    "street",
    "houseNumber",
    "zipCode",
    "city",
    "country",
    "region",
    "status",
    "nextStatus",
    "claimHandler",
    "dealId",
    "dealType",
    "productCode",
    "umrNumber",
    "lobCode",
    "claimReporter",
    "insured",
    "reinsured",
    "insuredId",
    "reinsuredId",
    "location",
    "extRefNo",
    "lloydsRiskCode",
    "submissionId",
    "brokerId",
    "eventDateNotif",
    "riskExpiryDate",
    "riskInceptionDate",
    "sectionName",
    "newRecordIn",
    "elsecoRiskCd",
    "leaderName",
    "leaderLineVl",
    "riskDomicileFg",
    "riskLocationCode",
    "elsecoLeaderFlag",
    "inceptionDate",
    "expiryDate",
    "limitCurrencyCode",
    "deleteFlag",
    "marketTransactionsInfo",
    "claimsCheckListInfo",
    "claimNotesInfo",
    "claimDetailsInfo",
    "claimRiskInfo",
    "claimPartyInfo"
})
public class ClaimsInfo {

    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("version")
    private String version;
    @JsonProperty("changeIndicator")
    private String changeIndicator;
    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("ucrNumber")
    private String ucrNumber;
    @JsonProperty("ucrName")
    private String ucrName;
    @JsonProperty("eventCategory")
    private String eventCategory;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("eventId")
    private BigInteger eventId;
    @JsonProperty("eventFromDate")
    private Object eventFromDate;
    @JsonProperty("eventToDate")
    private String eventToDate;
    @JsonProperty("eventDescription")
    private String eventDescription;
    @JsonProperty("lossType")
    private String lossType;
    @JsonProperty("dateOfLoss")
    private String dateOfLoss;
    @JsonProperty("timeOfLoss")
    private String timeOfLoss;
    @JsonProperty("lossTimeZone")
    private String lossTimeZone;
    @JsonProperty("causeOfLoss")
    private String causeOfLoss;
    @JsonProperty("street")
    private String street;
    @JsonProperty("houseNumber")
    private String houseNumber;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("region")
    private String region;
    @JsonProperty("status")
    private String status;
    @JsonProperty("nextStatus")
    private String nextStatus;
    @JsonProperty("claimHandler")
    private String claimHandler;
    @JsonProperty("dealId")
    private BigInteger dealId;
    @JsonProperty("dealType")
    private String dealType;
    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("umrNumber")
    private String umrNumber;
    @JsonProperty("lobCode")
    private String lobCode;
    @JsonProperty("claimReporter")
    private String claimReporter;
    @JsonProperty("insured")
    private String insured;
    @JsonProperty("reinsured")
    private String reinsured;
    @JsonProperty("insuredId")
    private String insuredId;
    @JsonProperty("reinsuredId")
    private String reinsuredId;
    @JsonProperty("location")
    private String location;
    @JsonProperty("extRefNo")
    private String extRefNo;
    @JsonProperty("lloydsRiskCode")
    private String lloydsRiskCode;
    @JsonProperty("submissionId")
    private BigInteger submissionId;
    @JsonProperty("brokerId")
    private BigInteger brokerId;
    @JsonProperty("eventDateNotif")
    private String eventDateNotif;
    @JsonProperty("riskExpiryDate")
    private Object riskExpiryDate;
    @JsonProperty("riskInceptionDate")
    private Object riskInceptionDate;
    @JsonProperty("sectionName")
    private String sectionName;
    @JsonProperty("newRecordIn")
    private String newRecordIn;
    @JsonProperty("elsecoRiskCd")
    private String elsecoRiskCd;
    @JsonProperty("leaderName")
    private String leaderName;
    @JsonProperty("leaderLineVl")
    private String leaderLineVl;
    @JsonProperty("riskDomicileFg")
    private String riskDomicileFg;
    @JsonProperty("riskLocationCode")
    private String riskLocationCode;
    @JsonProperty("elsecoLeaderFlag")
    private String elsecoLeaderFlag;
    @JsonProperty("inceptionDate")
    private String inceptionDate;
    @JsonProperty("expiryDate")
    private String expiryDate;
    @JsonProperty("limitCurrencyCode")
    private String limitCurrencyCode;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    @JsonProperty("marketTransactionsInfo")
    private List<MarketTransactionsInfo> marketTransactionsInfo = new ArrayList<MarketTransactionsInfo>();
    @JsonProperty("claimsCheckListInfo")
    private List<ClaimsCheckListInfo> claimsCheckListInfo = new ArrayList<ClaimsCheckListInfo>();
    @JsonProperty("claimNotesInfo")
    private List<ClaimNotesInfo> claimNotesInfo = new ArrayList<ClaimNotesInfo>();
    @JsonProperty("claimDetailsInfo")
    private List<ClaimDetailsInfo> claimDetailsInfo = new ArrayList<ClaimDetailsInfo>();
    @JsonProperty("claimRiskInfo")
    private List<ClaimRiskInfo> claimRiskInfo = new ArrayList<ClaimRiskInfo>();
    @JsonProperty("claimPartyInfo")
    private List<Object> claimPartyInfo = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("claimHeaderId")
    public BigInteger getClaimHeaderId() {
        return claimHeaderId;
    }

    @JsonProperty("claimHeaderId")
    public void setClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
    }

    public ClaimsInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public ClaimsInfo withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("changeIndicator")
    public String getChangeIndicator() {
        return changeIndicator;
    }

    @JsonProperty("changeIndicator")
    public void setChangeIndicator(String changeIndicator) {
        this.changeIndicator = changeIndicator;
    }

    public ClaimsInfo withChangeIndicator(String changeIndicator) {
        this.changeIndicator = changeIndicator;
        return this;
    }

    @JsonProperty("effectiveDate")
    public String getEffectiveDate() {
        return effectiveDate;
    }

    @JsonProperty("effectiveDate")
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public ClaimsInfo withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    @JsonProperty("ucrNumber")
    public String getUcrNumber() {
        return ucrNumber;
    }

    @JsonProperty("ucrNumber")
    public void setUcrNumber(String ucrNumber) {
        this.ucrNumber = ucrNumber;
    }

    public ClaimsInfo withUcrNumber(String ucrNumber) {
        this.ucrNumber = ucrNumber;
        return this;
    }

    @JsonProperty("ucrName")
    public String getUcrName() {
        return ucrName;
    }

    @JsonProperty("ucrName")
    public void setUcrName(String ucrName) {
        this.ucrName = ucrName;
    }

    public ClaimsInfo withUcrName(String ucrName) {
        this.ucrName = ucrName;
        return this;
    }

    @JsonProperty("eventCategory")
    public String getEventCategory() {
        return eventCategory;
    }

    @JsonProperty("eventCategory")
    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public ClaimsInfo withEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
        return this;
    }

    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("eventType")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public ClaimsInfo withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    @JsonProperty("eventId")
    public BigInteger getEventId() {
        return eventId;
    }

    @JsonProperty("eventId")
    public void setEventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public ClaimsInfo withEventId(BigInteger eventId) {
        this.eventId = eventId;
        return this;
    }

    @JsonProperty("eventFromDate")
    public Object getEventFromDate() {
        return eventFromDate;
    }

    @JsonProperty("eventFromDate")
    public void setEventFromDate(Object eventFromDate) {
        this.eventFromDate = eventFromDate;
    }

    public ClaimsInfo withEventFromDate(Object eventFromDate) {
        this.eventFromDate = eventFromDate;
        return this;
    }

    @JsonProperty("eventToDate")
    public String getEventToDate() {
        return eventToDate;
    }

    @JsonProperty("eventToDate")
    public void setEventToDate(String eventToDate) {
        this.eventToDate = eventToDate;
    }

    public ClaimsInfo withEventToDate(String eventToDate) {
        this.eventToDate = eventToDate;
        return this;
    }

    @JsonProperty("eventDescription")
    public String getEventDescription() {
        return eventDescription;
    }

    @JsonProperty("eventDescription")
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public ClaimsInfo withEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
        return this;
    }

    @JsonProperty("lossType")
    public String getLossType() {
        return lossType;
    }

    @JsonProperty("lossType")
    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public ClaimsInfo withLossType(String lossType) {
        this.lossType = lossType;
        return this;
    }

    @JsonProperty("dateOfLoss")
    public String getDateOfLoss() {
        return dateOfLoss;
    }

    @JsonProperty("dateOfLoss")
    public void setDateOfLoss(String dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public ClaimsInfo withDateOfLoss(String dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
        return this;
    }

    @JsonProperty("timeOfLoss")
    public String getTimeOfLoss() {
        return timeOfLoss;
    }

    @JsonProperty("timeOfLoss")
    public void setTimeOfLoss(String timeOfLoss) {
        this.timeOfLoss = timeOfLoss;
    }

    public ClaimsInfo withTimeOfLoss(String timeOfLoss) {
        this.timeOfLoss = timeOfLoss;
        return this;
    }

    @JsonProperty("lossTimeZone")
    public String getLossTimeZone() {
        return lossTimeZone;
    }

    @JsonProperty("lossTimeZone")
    public void setLossTimeZone(String lossTimeZone) {
        this.lossTimeZone = lossTimeZone;
    }

    public ClaimsInfo withLossTimeZone(String lossTimeZone) {
        this.lossTimeZone = lossTimeZone;
        return this;
    }

    @JsonProperty("causeOfLoss")
    public String getCauseOfLoss() {
        return causeOfLoss;
    }

    @JsonProperty("causeOfLoss")
    public void setCauseOfLoss(String causeOfLoss) {
        this.causeOfLoss = causeOfLoss;
    }

    public ClaimsInfo withCauseOfLoss(String causeOfLoss) {
        this.causeOfLoss = causeOfLoss;
        return this;
    }

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    public ClaimsInfo withStreet(String street) {
        this.street = street;
        return this;
    }

    @JsonProperty("houseNumber")
    public String getHouseNumber() {
        return houseNumber;
    }

    @JsonProperty("houseNumber")
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public ClaimsInfo withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ClaimsInfo withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public ClaimsInfo withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public ClaimsInfo withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    public ClaimsInfo withRegion(String region) {
        this.region = region;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public ClaimsInfo withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("nextStatus")
    public String getNextStatus() {
        return nextStatus;
    }

    @JsonProperty("nextStatus")
    public void setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
    }

    public ClaimsInfo withNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
        return this;
    }

    @JsonProperty("claimHandler")
    public String getClaimHandler() {
        return claimHandler;
    }

    @JsonProperty("claimHandler")
    public void setClaimHandler(String claimHandler) {
        this.claimHandler = claimHandler;
    }

    public ClaimsInfo withClaimHandler(String claimHandler) {
        this.claimHandler = claimHandler;
        return this;
    }

    @JsonProperty("dealId")
    public BigInteger getDealId() {
        return dealId;
    }

    @JsonProperty("dealId")
    public void setDealId(BigInteger dealId) {
        this.dealId = dealId;
    }

    public ClaimsInfo withDealId(BigInteger dealId) {
        this.dealId = dealId;
        return this;
    }

    @JsonProperty("dealType")
    public String getDealType() {
        return dealType;
    }

    @JsonProperty("dealType")
    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public ClaimsInfo withDealType(String dealType) {
        this.dealType = dealType;
        return this;
    }

    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("productCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public ClaimsInfo withProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    @JsonProperty("umrNumber")
    public String getUmrNumber() {
        return umrNumber;
    }

    @JsonProperty("umrNumber")
    public void setUmrNumber(String umrNumber) {
        this.umrNumber = umrNumber;
    }

    public ClaimsInfo withUmrNumber(String umrNumber) {
        this.umrNumber = umrNumber;
        return this;
    }

    @JsonProperty("lobCode")
    public String getLobCode() {
        return lobCode;
    }

    @JsonProperty("lobCode")
    public void setLobCode(String lobCode) {
        this.lobCode = lobCode;
    }

    public ClaimsInfo withLobCode(String lobCode) {
        this.lobCode = lobCode;
        return this;
    }

    @JsonProperty("claimReporter")
    public String getClaimReporter() {
        return claimReporter;
    }

    @JsonProperty("claimReporter")
    public void setClaimReporter(String claimReporter) {
        this.claimReporter = claimReporter;
    }

    public ClaimsInfo withClaimReporter(String claimReporter) {
        this.claimReporter = claimReporter;
        return this;
    }

    @JsonProperty("insured")
    public String getInsured() {
        return insured;
    }

    @JsonProperty("insured")
    public void setInsured(String insured) {
        this.insured = insured;
    }

    public ClaimsInfo withInsured(String insured) {
        this.insured = insured;
        return this;
    }

    @JsonProperty("reinsured")
    public String getReinsured() {
        return reinsured;
    }

    @JsonProperty("reinsured")
    public void setReinsured(String reinsured) {
        this.reinsured = reinsured;
    }

    public ClaimsInfo withReinsured(String reinsured) {
        this.reinsured = reinsured;
        return this;
    }

    @JsonProperty("insuredId")
    public String getInsuredId() {
        return insuredId;
    }

    @JsonProperty("insuredId")
    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId;
    }

    public ClaimsInfo withInsuredId(String insuredId) {
        this.insuredId = insuredId;
        return this;
    }

    @JsonProperty("reinsuredId")
    public String getReinsuredId() {
        return reinsuredId;
    }

    @JsonProperty("reinsuredId")
    public void setReinsuredId(String reinsuredId) {
        this.reinsuredId = reinsuredId;
    }

    public ClaimsInfo withReinsuredId(String reinsuredId) {
        this.reinsuredId = reinsuredId;
        return this;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    public ClaimsInfo withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("extRefNo")
    public String getExtRefNo() {
        return extRefNo;
    }

    @JsonProperty("extRefNo")
    public void setExtRefNo(String extRefNo) {
        this.extRefNo = extRefNo;
    }

    public ClaimsInfo withExtRefNo(String extRefNo) {
        this.extRefNo = extRefNo;
        return this;
    }

    @JsonProperty("lloydsRiskCode")
    public String getLloydsRiskCode() {
        return lloydsRiskCode;
    }

    @JsonProperty("lloydsRiskCode")
    public void setLloydsRiskCode(String lloydsRiskCode) {
        this.lloydsRiskCode = lloydsRiskCode;
    }

    public ClaimsInfo withLloydsRiskCode(String lloydsRiskCode) {
        this.lloydsRiskCode = lloydsRiskCode;
        return this;
    }

    @JsonProperty("submissionId")
    public BigInteger getSubmissionId() {
        return submissionId;
    }

    @JsonProperty("submissionId")
    public void setSubmissionId(BigInteger submissionId) {
        this.submissionId = submissionId;
    }

    public ClaimsInfo withSubmissionId(BigInteger submissionId) {
        this.submissionId = submissionId;
        return this;
    }

    @JsonProperty("brokerId")
    public BigInteger getBrokerId() {
        return brokerId;
    }

    @JsonProperty("brokerId")
    public void setBrokerId(BigInteger brokerId) {
        this.brokerId = brokerId;
    }

    public ClaimsInfo withBrokerId(BigInteger brokerId) {
        this.brokerId = brokerId;
        return this;
    }

    @JsonProperty("eventDateNotif")
    public String getEventDateNotif() {
        return eventDateNotif;
    }

    @JsonProperty("eventDateNotif")
    public void setEventDateNotif(String eventDateNotif) {
        this.eventDateNotif = eventDateNotif;
    }

    public ClaimsInfo withEventDateNotif(String eventDateNotif) {
        this.eventDateNotif = eventDateNotif;
        return this;
    }

    @JsonProperty("riskExpiryDate")
    public Object getRiskExpiryDate() {
        return riskExpiryDate;
    }

    @JsonProperty("riskExpiryDate")
    public void setRiskExpiryDate(Object riskExpiryDate) {
        this.riskExpiryDate = riskExpiryDate;
    }

    public ClaimsInfo withRiskExpiryDate(Object riskExpiryDate) {
        this.riskExpiryDate = riskExpiryDate;
        return this;
    }

    @JsonProperty("riskInceptionDate")
    public Object getRiskInceptionDate() {
        return riskInceptionDate;
    }

    @JsonProperty("riskInceptionDate")
    public void setRiskInceptionDate(Object riskInceptionDate) {
        this.riskInceptionDate = riskInceptionDate;
    }

    public ClaimsInfo withRiskInceptionDate(Object riskInceptionDate) {
        this.riskInceptionDate = riskInceptionDate;
        return this;
    }

    @JsonProperty("sectionName")
    public String getSectionName() {
        return sectionName;
    }

    @JsonProperty("sectionName")
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public ClaimsInfo withSectionName(String sectionName) {
        this.sectionName = sectionName;
        return this;
    }

    @JsonProperty("newRecordIn")
    public String getNewRecordIn() {
        return newRecordIn;
    }

    @JsonProperty("newRecordIn")
    public void setNewRecordIn(String newRecordIn) {
        this.newRecordIn = newRecordIn;
    }

    public ClaimsInfo withNewRecordIn(String newRecordIn) {
        this.newRecordIn = newRecordIn;
        return this;
    }

    @JsonProperty("elsecoRiskCd")
    public String getElsecoRiskCd() {
        return elsecoRiskCd;
    }

    @JsonProperty("elsecoRiskCd")
    public void setElsecoRiskCd(String elsecoRiskCd) {
        this.elsecoRiskCd = elsecoRiskCd;
    }

    public ClaimsInfo withElsecoRiskCd(String elsecoRiskCd) {
        this.elsecoRiskCd = elsecoRiskCd;
        return this;
    }

    @JsonProperty("leaderName")
    public String getLeaderName() {
        return leaderName;
    }

    @JsonProperty("leaderName")
    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public ClaimsInfo withLeaderName(String leaderName) {
        this.leaderName = leaderName;
        return this;
    }

    @JsonProperty("leaderLineVl")
    public String getLeaderLineVl() {
        return leaderLineVl;
    }

    @JsonProperty("leaderLineVl")
    public void setLeaderLineVl(String leaderLineVl) {
        this.leaderLineVl = leaderLineVl;
    }

    public ClaimsInfo withLeaderLineVl(String leaderLineVl) {
        this.leaderLineVl = leaderLineVl;
        return this;
    }

    @JsonProperty("riskDomicileFg")
    public String getRiskDomicileFg() {
        return riskDomicileFg;
    }

    @JsonProperty("riskDomicileFg")
    public void setRiskDomicileFg(String riskDomicileFg) {
        this.riskDomicileFg = riskDomicileFg;
    }

    public ClaimsInfo withRiskDomicileFg(String riskDomicileFg) {
        this.riskDomicileFg = riskDomicileFg;
        return this;
    }

    @JsonProperty("riskLocationCode")
    public String getRiskLocationCode() {
        return riskLocationCode;
    }

    @JsonProperty("riskLocationCode")
    public void setRiskLocationCode(String riskLocationCode) {
        this.riskLocationCode = riskLocationCode;
    }

    public ClaimsInfo withRiskLocationCode(String riskLocationCode) {
        this.riskLocationCode = riskLocationCode;
        return this;
    }

    @JsonProperty("elsecoLeaderFlag")
    public String getElsecoLeaderFlag() {
        return elsecoLeaderFlag;
    }

    @JsonProperty("elsecoLeaderFlag")
    public void setElsecoLeaderFlag(String elsecoLeaderFlag) {
        this.elsecoLeaderFlag = elsecoLeaderFlag;
    }

    public ClaimsInfo withElsecoLeaderFlag(String elsecoLeaderFlag) {
        this.elsecoLeaderFlag = elsecoLeaderFlag;
        return this;
    }

    @JsonProperty("inceptionDate")
    public String getInceptionDate() {
        return inceptionDate;
    }

    @JsonProperty("inceptionDate")
    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public ClaimsInfo withInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
        return this;
    }

    @JsonProperty("expiryDate")
    public String getExpiryDate() {
        return expiryDate;
    }

    @JsonProperty("expiryDate")
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ClaimsInfo withExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    @JsonProperty("limitCurrencyCode")
    public String getLimitCurrencyCode() {
        return limitCurrencyCode;
    }

    @JsonProperty("limitCurrencyCode")
    public void setLimitCurrencyCode(String limitCurrencyCode) {
        this.limitCurrencyCode = limitCurrencyCode;
    }

    public ClaimsInfo withLimitCurrencyCode(String limitCurrencyCode) {
        this.limitCurrencyCode = limitCurrencyCode;
        return this;
    }

    @JsonProperty("deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    @JsonProperty("deleteFlag")
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public ClaimsInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @JsonProperty("marketTransactionsInfo")
    public List<MarketTransactionsInfo> getMarketTransactionsInfo() {
        return marketTransactionsInfo;
    }

    @JsonProperty("marketTransactionsInfo")
    public void setMarketTransactionsInfo(List<MarketTransactionsInfo> marketTransactionsInfo) {
        this.marketTransactionsInfo = marketTransactionsInfo;
    }

    public ClaimsInfo withMarketTransactionsInfo(List<MarketTransactionsInfo> marketTransactionsInfo) {
        this.marketTransactionsInfo = marketTransactionsInfo;
        return this;
    }

    @JsonProperty("claimsCheckListInfo")
    public List<ClaimsCheckListInfo> getClaimsCheckListInfo() {
        return claimsCheckListInfo;
    }

    @JsonProperty("claimsCheckListInfo")
    public void setClaimsCheckListInfo(List<ClaimsCheckListInfo> claimsCheckListInfo) {
        this.claimsCheckListInfo = claimsCheckListInfo;
    }

    public ClaimsInfo withClaimsCheckListInfo(List<ClaimsCheckListInfo> claimsCheckListInfo) {
        this.claimsCheckListInfo = claimsCheckListInfo;
        return this;
    }

    @JsonProperty("claimNotesInfo")
    public List<ClaimNotesInfo> getClaimNotesInfo() {
        return claimNotesInfo;
    }

    @JsonProperty("claimNotesInfo")
    public void setClaimNotesInfo(List<ClaimNotesInfo> claimNotesInfo) {
        this.claimNotesInfo = claimNotesInfo;
    }

    public ClaimsInfo withClaimNotesInfo(List<ClaimNotesInfo> claimNotesInfo) {
        this.claimNotesInfo = claimNotesInfo;
        return this;
    }

    @JsonProperty("claimDetailsInfo")
    public List<ClaimDetailsInfo> getClaimDetailsInfo() {
        return claimDetailsInfo;
    }

    @JsonProperty("claimDetailsInfo")
    public void setClaimDetailsInfo(List<ClaimDetailsInfo> claimDetailsInfo) {
        this.claimDetailsInfo = claimDetailsInfo;
    }

    public ClaimsInfo withClaimDetailsInfo(List<ClaimDetailsInfo> claimDetailsInfo) {
        this.claimDetailsInfo = claimDetailsInfo;
        return this;
    }

    @JsonProperty("claimRiskInfo")
    public List<ClaimRiskInfo> getClaimRiskInfo() {
        return claimRiskInfo;
    }

    @JsonProperty("claimRiskInfo")
    public void setClaimRiskInfo(List<ClaimRiskInfo> claimRiskInfo) {
        this.claimRiskInfo = claimRiskInfo;
    }

    public ClaimsInfo withClaimRiskInfo(List<ClaimRiskInfo> claimRiskInfo) {
        this.claimRiskInfo = claimRiskInfo;
        return this;
    }

    @JsonProperty("claimPartyInfo")
    public List<Object> getClaimPartyInfo() {
        return claimPartyInfo;
    }

    @JsonProperty("claimPartyInfo")
    public void setClaimPartyInfo(List<Object> claimPartyInfo) {
        this.claimPartyInfo = claimPartyInfo;
    }

    public ClaimsInfo withClaimPartyInfo(List<Object> claimPartyInfo) {
        this.claimPartyInfo = claimPartyInfo;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
