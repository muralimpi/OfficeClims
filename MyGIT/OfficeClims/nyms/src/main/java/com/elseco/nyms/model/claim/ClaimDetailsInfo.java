
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
    "claimId",
    "claimHeaderId",
    "version",
    "changeIndicator",
    "effctiveDate",
    "claimReferenceNo",
    "flagAuthReported",
    "claimDetailStatus",
    "nextStatus",
    "claimReporter",
    "claimAuthority",
    "lossType",
    "policyType",
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
    "statusChangeReason",
    "claimAuthGroup",
    "complexity",
    "dateClaimOpen",
    "dateClaimExpiry",
    "dateLossReptCompany",
    "dateLossReportedAgent",
    "claimProcTime",
    "statusChg",
    "flagSensitive",
    "flagCovered",
    "dtEffctive",
    "dateLossReported",
    "extRefNo",
    "lloydsRiskCode",
    "lobCode",
    "sectionName",
    "inceptionDate",
    "expiryDate",
    "subject",
    "lineSizeVl",
    "totalPriceAm",
    "orderPrecVl",
    "signingPercVl",
    "estimatedPremiumAM",
    "tempLloydsRiskCd",
    "prmSplitPercVl",
    "premiumAmt",
    "buttonIndicator",
    "settlementDate",
    "prevpaidAmtIndemnityER",
    "prevpaidAmtFeesER",
    "prevpaidAmtExpensesER",
    "settlementAmtIndemnityER",
    "settlementAmtFeesER",
    "settlementAmtExpensesER",
    "reserveAmountIndemnityER",
    "reserveAmountFeesER",
    "reserveAmountExpensesER",
    "deleteFlag",
    "policyTransactionsInfo",
    "claimsCheckListInfo",
    "claimsItemsInfo",
    "claimsFileInfo",
    "claimReserveInfo",
    "claimNotesInfo",
    "claimDetailInternalReferenceInfo",
    "claimParticipantInfo"
})
public class ClaimDetailsInfo {

    @JsonProperty("claimId")
    private BigInteger claimId;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("version")
    private String version;
    @JsonProperty("changeIndicator")
    private String changeIndicator;
    @JsonProperty("effctiveDate")
    private Object effctiveDate;
    @JsonProperty("claimReferenceNo")
    private String claimReferenceNo;
    @JsonProperty("flagAuthReported")
    private String flagAuthReported;
    @JsonProperty("claimDetailStatus")
    private String claimDetailStatus;
    @JsonProperty("nextStatus")
    private String nextStatus;
    @JsonProperty("claimReporter")
    private String claimReporter;
    @JsonProperty("claimAuthority")
    private String claimAuthority;
    @JsonProperty("lossType")
    private String lossType;
    @JsonProperty("policyType")
    private String policyType;
    @JsonProperty("dateOfLoss")
    private String dateOfLoss;
    @JsonProperty("timeOfLoss")
    private String timeOfLoss;
    @JsonProperty("lossTimeZone")
    private Object lossTimeZone;
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
    @JsonProperty("statusChangeReason")
    private String statusChangeReason;
    @JsonProperty("claimAuthGroup")
    private String claimAuthGroup;
    @JsonProperty("complexity")
    private BigInteger complexity;
    @JsonProperty("dateClaimOpen")
    private String dateClaimOpen;
    @JsonProperty("dateClaimExpiry")
    private Object dateClaimExpiry;
    @JsonProperty("dateLossReptCompany")
    private String dateLossReptCompany;
    @JsonProperty("dateLossReportedAgent")
    private String dateLossReportedAgent;
    @JsonProperty("claimProcTime")
    private String claimProcTime;
    @JsonProperty("statusChg")
    private BigInteger statusChg;
    @JsonProperty("flagSensitive")
    private String flagSensitive;
    @JsonProperty("flagCovered")
    private String flagCovered;
    @JsonProperty("dtEffctive")
    private Object dtEffctive;
    @JsonProperty("dateLossReported")
    private String dateLossReported;
    @JsonProperty("extRefNo")
    private String extRefNo;
    @JsonProperty("lloydsRiskCode")
    private String lloydsRiskCode;
    @JsonProperty("lobCode")
    private String lobCode;
    @JsonProperty("sectionName")
    private String sectionName;
    @JsonProperty("inceptionDate")
    private String inceptionDate;
    @JsonProperty("expiryDate")
    private String expiryDate;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("lineSizeVl")
    private String lineSizeVl;
    @JsonProperty("totalPriceAm")
    private Object totalPriceAm;
    @JsonProperty("orderPrecVl")
    private String orderPrecVl;
    @JsonProperty("signingPercVl")
    private String signingPercVl;
    @JsonProperty("estimatedPremiumAM")
    private BigInteger estimatedPremiumAM;
    @JsonProperty("tempLloydsRiskCd")
    private String tempLloydsRiskCd;
    @JsonProperty("prmSplitPercVl")
    private String prmSplitPercVl;
    @JsonProperty("premiumAmt")
    private BigInteger premiumAmt;
    @JsonProperty("buttonIndicator")
    private String buttonIndicator;
    @JsonProperty("settlementDate")
    private Object settlementDate;
    @JsonProperty("prevpaidAmtIndemnityER")
    private Object prevpaidAmtIndemnityER;
    @JsonProperty("prevpaidAmtFeesER")
    private Object prevpaidAmtFeesER;
    @JsonProperty("prevpaidAmtExpensesER")
    private Object prevpaidAmtExpensesER;
    @JsonProperty("settlementAmtIndemnityER")
    private BigInteger settlementAmtIndemnityER;
    @JsonProperty("settlementAmtFeesER")
    private BigInteger settlementAmtFeesER;
    @JsonProperty("settlementAmtExpensesER")
    private BigInteger settlementAmtExpensesER;
    @JsonProperty("reserveAmountIndemnityER")
    private Object reserveAmountIndemnityER;
    @JsonProperty("reserveAmountFeesER")
    private Object reserveAmountFeesER;
    @JsonProperty("reserveAmountExpensesER")
    private Object reserveAmountExpensesER;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    @JsonProperty("policyTransactionsInfo")
    private List<PolicyTransactionsInfo> policyTransactionsInfo = new ArrayList<PolicyTransactionsInfo>();
    @JsonProperty("claimsCheckListInfo")
    private List<ClaimsCheckListInfo_> claimsCheckListInfo = new ArrayList<ClaimsCheckListInfo_>();
    @JsonProperty("claimsItemsInfo")
    private List<Object> claimsItemsInfo = new ArrayList<Object>();
    @JsonProperty("claimsFileInfo")
    private List<Object> claimsFileInfo = new ArrayList<Object>();
    @JsonProperty("claimReserveInfo")
    private List<Object> claimReserveInfo = new ArrayList<Object>();
    @JsonProperty("claimNotesInfo")
    private List<ClaimNotesInfo_> claimNotesInfo = new ArrayList<ClaimNotesInfo_>();
    @JsonProperty("claimDetailInternalReferenceInfo")
    private List<Object> claimDetailInternalReferenceInfo = new ArrayList<Object>();
    @JsonProperty("claimParticipantInfo")
    private Object claimParticipantInfo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("claimId")
    public BigInteger getClaimId() {
        return claimId;
    }

    @JsonProperty("claimId")
    public void setClaimId(BigInteger claimId) {
        this.claimId = claimId;
    }

    public ClaimDetailsInfo withClaimId(BigInteger claimId) {
        this.claimId = claimId;
        return this;
    }

    @JsonProperty("claimHeaderId")
    public BigInteger getClaimHeaderId() {
        return claimHeaderId;
    }

    @JsonProperty("claimHeaderId")
    public void setClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
    }

    public ClaimDetailsInfo withClaimHeaderId(BigInteger claimHeaderId) {
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

    public ClaimDetailsInfo withVersion(String version) {
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

    public ClaimDetailsInfo withChangeIndicator(String changeIndicator) {
        this.changeIndicator = changeIndicator;
        return this;
    }

    @JsonProperty("effctiveDate")
    public Object getEffctiveDate() {
        return effctiveDate;
    }

    @JsonProperty("effctiveDate")
    public void setEffctiveDate(Object effctiveDate) {
        this.effctiveDate = effctiveDate;
    }

    public ClaimDetailsInfo withEffctiveDate(Object effctiveDate) {
        this.effctiveDate = effctiveDate;
        return this;
    }

    @JsonProperty("claimReferenceNo")
    public String getClaimReferenceNo() {
        return claimReferenceNo;
    }

    @JsonProperty("claimReferenceNo")
    public void setClaimReferenceNo(String claimReferenceNo) {
        this.claimReferenceNo = claimReferenceNo;
    }

    public ClaimDetailsInfo withClaimReferenceNo(String claimReferenceNo) {
        this.claimReferenceNo = claimReferenceNo;
        return this;
    }

    @JsonProperty("flagAuthReported")
    public String getFlagAuthReported() {
        return flagAuthReported;
    }

    @JsonProperty("flagAuthReported")
    public void setFlagAuthReported(String flagAuthReported) {
        this.flagAuthReported = flagAuthReported;
    }

    public ClaimDetailsInfo withFlagAuthReported(String flagAuthReported) {
        this.flagAuthReported = flagAuthReported;
        return this;
    }

    @JsonProperty("claimDetailStatus")
    public String getClaimDetailStatus() {
        return claimDetailStatus;
    }

    @JsonProperty("claimDetailStatus")
    public void setClaimDetailStatus(String claimDetailStatus) {
        this.claimDetailStatus = claimDetailStatus;
    }

    public ClaimDetailsInfo withClaimDetailStatus(String claimDetailStatus) {
        this.claimDetailStatus = claimDetailStatus;
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

    public ClaimDetailsInfo withNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
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

    public ClaimDetailsInfo withClaimReporter(String claimReporter) {
        this.claimReporter = claimReporter;
        return this;
    }

    @JsonProperty("claimAuthority")
    public String getClaimAuthority() {
        return claimAuthority;
    }

    @JsonProperty("claimAuthority")
    public void setClaimAuthority(String claimAuthority) {
        this.claimAuthority = claimAuthority;
    }

    public ClaimDetailsInfo withClaimAuthority(String claimAuthority) {
        this.claimAuthority = claimAuthority;
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

    public ClaimDetailsInfo withLossType(String lossType) {
        this.lossType = lossType;
        return this;
    }

    @JsonProperty("policyType")
    public String getPolicyType() {
        return policyType;
    }

    @JsonProperty("policyType")
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public ClaimDetailsInfo withPolicyType(String policyType) {
        this.policyType = policyType;
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

    public ClaimDetailsInfo withDateOfLoss(String dateOfLoss) {
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

    public ClaimDetailsInfo withTimeOfLoss(String timeOfLoss) {
        this.timeOfLoss = timeOfLoss;
        return this;
    }

    @JsonProperty("lossTimeZone")
    public Object getLossTimeZone() {
        return lossTimeZone;
    }

    @JsonProperty("lossTimeZone")
    public void setLossTimeZone(Object lossTimeZone) {
        this.lossTimeZone = lossTimeZone;
    }

    public ClaimDetailsInfo withLossTimeZone(Object lossTimeZone) {
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

    public ClaimDetailsInfo withCauseOfLoss(String causeOfLoss) {
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

    public ClaimDetailsInfo withStreet(String street) {
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

    public ClaimDetailsInfo withHouseNumber(String houseNumber) {
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

    public ClaimDetailsInfo withZipCode(String zipCode) {
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

    public ClaimDetailsInfo withCity(String city) {
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

    public ClaimDetailsInfo withCountry(String country) {
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

    public ClaimDetailsInfo withRegion(String region) {
        this.region = region;
        return this;
    }

    @JsonProperty("statusChangeReason")
    public String getStatusChangeReason() {
        return statusChangeReason;
    }

    @JsonProperty("statusChangeReason")
    public void setStatusChangeReason(String statusChangeReason) {
        this.statusChangeReason = statusChangeReason;
    }

    public ClaimDetailsInfo withStatusChangeReason(String statusChangeReason) {
        this.statusChangeReason = statusChangeReason;
        return this;
    }

    @JsonProperty("claimAuthGroup")
    public String getClaimAuthGroup() {
        return claimAuthGroup;
    }

    @JsonProperty("claimAuthGroup")
    public void setClaimAuthGroup(String claimAuthGroup) {
        this.claimAuthGroup = claimAuthGroup;
    }

    public ClaimDetailsInfo withClaimAuthGroup(String claimAuthGroup) {
        this.claimAuthGroup = claimAuthGroup;
        return this;
    }

    @JsonProperty("complexity")
    public BigInteger getComplexity() {
        return complexity;
    }

    @JsonProperty("complexity")
    public void setComplexity(BigInteger complexity) {
        this.complexity = complexity;
    }

    public ClaimDetailsInfo withComplexity(BigInteger complexity) {
        this.complexity = complexity;
        return this;
    }

    @JsonProperty("dateClaimOpen")
    public String getDateClaimOpen() {
        return dateClaimOpen;
    }

    @JsonProperty("dateClaimOpen")
    public void setDateClaimOpen(String dateClaimOpen) {
        this.dateClaimOpen = dateClaimOpen;
    }

    public ClaimDetailsInfo withDateClaimOpen(String dateClaimOpen) {
        this.dateClaimOpen = dateClaimOpen;
        return this;
    }

    @JsonProperty("dateClaimExpiry")
    public Object getDateClaimExpiry() {
        return dateClaimExpiry;
    }

    @JsonProperty("dateClaimExpiry")
    public void setDateClaimExpiry(Object dateClaimExpiry) {
        this.dateClaimExpiry = dateClaimExpiry;
    }

    public ClaimDetailsInfo withDateClaimExpiry(Object dateClaimExpiry) {
        this.dateClaimExpiry = dateClaimExpiry;
        return this;
    }

    @JsonProperty("dateLossReptCompany")
    public String getDateLossReptCompany() {
        return dateLossReptCompany;
    }

    @JsonProperty("dateLossReptCompany")
    public void setDateLossReptCompany(String dateLossReptCompany) {
        this.dateLossReptCompany = dateLossReptCompany;
    }

    public ClaimDetailsInfo withDateLossReptCompany(String dateLossReptCompany) {
        this.dateLossReptCompany = dateLossReptCompany;
        return this;
    }

    @JsonProperty("dateLossReportedAgent")
    public String getDateLossReportedAgent() {
        return dateLossReportedAgent;
    }

    @JsonProperty("dateLossReportedAgent")
    public void setDateLossReportedAgent(String dateLossReportedAgent) {
        this.dateLossReportedAgent = dateLossReportedAgent;
    }

    public ClaimDetailsInfo withDateLossReportedAgent(String dateLossReportedAgent) {
        this.dateLossReportedAgent = dateLossReportedAgent;
        return this;
    }

    @JsonProperty("claimProcTime")
    public String getClaimProcTime() {
        return claimProcTime;
    }

    @JsonProperty("claimProcTime")
    public void setClaimProcTime(String claimProcTime) {
        this.claimProcTime = claimProcTime;
    }

    public ClaimDetailsInfo withClaimProcTime(String claimProcTime) {
        this.claimProcTime = claimProcTime;
        return this;
    }

    @JsonProperty("statusChg")
    public BigInteger getStatusChg() {
        return statusChg;
    }

    @JsonProperty("statusChg")
    public void setStatusChg(BigInteger statusChg) {
        this.statusChg = statusChg;
    }

    public ClaimDetailsInfo withStatusChg(BigInteger statusChg) {
        this.statusChg = statusChg;
        return this;
    }

    @JsonProperty("flagSensitive")
    public String getFlagSensitive() {
        return flagSensitive;
    }

    @JsonProperty("flagSensitive")
    public void setFlagSensitive(String flagSensitive) {
        this.flagSensitive = flagSensitive;
    }

    public ClaimDetailsInfo withFlagSensitive(String flagSensitive) {
        this.flagSensitive = flagSensitive;
        return this;
    }

    @JsonProperty("flagCovered")
    public String getFlagCovered() {
        return flagCovered;
    }

    @JsonProperty("flagCovered")
    public void setFlagCovered(String flagCovered) {
        this.flagCovered = flagCovered;
    }

    public ClaimDetailsInfo withFlagCovered(String flagCovered) {
        this.flagCovered = flagCovered;
        return this;
    }

    @JsonProperty("dtEffctive")
    public Object getDtEffctive() {
        return dtEffctive;
    }

    @JsonProperty("dtEffctive")
    public void setDtEffctive(Object dtEffctive) {
        this.dtEffctive = dtEffctive;
    }

    public ClaimDetailsInfo withDtEffctive(Object dtEffctive) {
        this.dtEffctive = dtEffctive;
        return this;
    }

    @JsonProperty("dateLossReported")
    public String getDateLossReported() {
        return dateLossReported;
    }

    @JsonProperty("dateLossReported")
    public void setDateLossReported(String dateLossReported) {
        this.dateLossReported = dateLossReported;
    }

    public ClaimDetailsInfo withDateLossReported(String dateLossReported) {
        this.dateLossReported = dateLossReported;
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

    public ClaimDetailsInfo withExtRefNo(String extRefNo) {
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

    public ClaimDetailsInfo withLloydsRiskCode(String lloydsRiskCode) {
        this.lloydsRiskCode = lloydsRiskCode;
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

    public ClaimDetailsInfo withLobCode(String lobCode) {
        this.lobCode = lobCode;
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

    public ClaimDetailsInfo withSectionName(String sectionName) {
        this.sectionName = sectionName;
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

    public ClaimDetailsInfo withInceptionDate(String inceptionDate) {
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

    public ClaimDetailsInfo withExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ClaimDetailsInfo withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @JsonProperty("lineSizeVl")
    public String getLineSizeVl() {
        return lineSizeVl;
    }

    @JsonProperty("lineSizeVl")
    public void setLineSizeVl(String lineSizeVl) {
        this.lineSizeVl = lineSizeVl;
    }

    public ClaimDetailsInfo withLineSizeVl(String lineSizeVl) {
        this.lineSizeVl = lineSizeVl;
        return this;
    }

    @JsonProperty("totalPriceAm")
    public Object getTotalPriceAm() {
        return totalPriceAm;
    }

    @JsonProperty("totalPriceAm")
    public void setTotalPriceAm(Object totalPriceAm) {
        this.totalPriceAm = totalPriceAm;
    }

    public ClaimDetailsInfo withTotalPriceAm(Object totalPriceAm) {
        this.totalPriceAm = totalPriceAm;
        return this;
    }

    @JsonProperty("orderPrecVl")
    public String getOrderPrecVl() {
        return orderPrecVl;
    }

    @JsonProperty("orderPrecVl")
    public void setOrderPrecVl(String orderPrecVl) {
        this.orderPrecVl = orderPrecVl;
    }

    public ClaimDetailsInfo withOrderPrecVl(String orderPrecVl) {
        this.orderPrecVl = orderPrecVl;
        return this;
    }

    @JsonProperty("signingPercVl")
    public String getSigningPercVl() {
        return signingPercVl;
    }

    @JsonProperty("signingPercVl")
    public void setSigningPercVl(String signingPercVl) {
        this.signingPercVl = signingPercVl;
    }

    public ClaimDetailsInfo withSigningPercVl(String signingPercVl) {
        this.signingPercVl = signingPercVl;
        return this;
    }

    @JsonProperty("estimatedPremiumAM")
    public BigInteger getEstimatedPremiumAM() {
        return estimatedPremiumAM;
    }

    @JsonProperty("estimatedPremiumAM")
    public void setEstimatedPremiumAM(BigInteger estimatedPremiumAM) {
        this.estimatedPremiumAM = estimatedPremiumAM;
    }

    public ClaimDetailsInfo withEstimatedPremiumAM(BigInteger estimatedPremiumAM) {
        this.estimatedPremiumAM = estimatedPremiumAM;
        return this;
    }

    @JsonProperty("tempLloydsRiskCd")
    public String getTempLloydsRiskCd() {
        return tempLloydsRiskCd;
    }

    @JsonProperty("tempLloydsRiskCd")
    public void setTempLloydsRiskCd(String tempLloydsRiskCd) {
        this.tempLloydsRiskCd = tempLloydsRiskCd;
    }

    public ClaimDetailsInfo withTempLloydsRiskCd(String tempLloydsRiskCd) {
        this.tempLloydsRiskCd = tempLloydsRiskCd;
        return this;
    }

    @JsonProperty("prmSplitPercVl")
    public String getPrmSplitPercVl() {
        return prmSplitPercVl;
    }

    @JsonProperty("prmSplitPercVl")
    public void setPrmSplitPercVl(String prmSplitPercVl) {
        this.prmSplitPercVl = prmSplitPercVl;
    }

    public ClaimDetailsInfo withPrmSplitPercVl(String prmSplitPercVl) {
        this.prmSplitPercVl = prmSplitPercVl;
        return this;
    }

    @JsonProperty("premiumAmt")
    public BigInteger getPremiumAmt() {
        return premiumAmt;
    }

    @JsonProperty("premiumAmt")
    public void setPremiumAmt(BigInteger premiumAmt) {
        this.premiumAmt = premiumAmt;
    }

    public ClaimDetailsInfo withPremiumAmt(BigInteger premiumAmt) {
        this.premiumAmt = premiumAmt;
        return this;
    }

    @JsonProperty("buttonIndicator")
    public String getButtonIndicator() {
        return buttonIndicator;
    }

    @JsonProperty("buttonIndicator")
    public void setButtonIndicator(String buttonIndicator) {
        this.buttonIndicator = buttonIndicator;
    }

    public ClaimDetailsInfo withButtonIndicator(String buttonIndicator) {
        this.buttonIndicator = buttonIndicator;
        return this;
    }

    @JsonProperty("settlementDate")
    public Object getSettlementDate() {
        return settlementDate;
    }

    @JsonProperty("settlementDate")
    public void setSettlementDate(Object settlementDate) {
        this.settlementDate = settlementDate;
    }

    public ClaimDetailsInfo withSettlementDate(Object settlementDate) {
        this.settlementDate = settlementDate;
        return this;
    }

    @JsonProperty("prevpaidAmtIndemnityER")
    public Object getPrevpaidAmtIndemnityER() {
        return prevpaidAmtIndemnityER;
    }

    @JsonProperty("prevpaidAmtIndemnityER")
    public void setPrevpaidAmtIndemnityER(Object prevpaidAmtIndemnityER) {
        this.prevpaidAmtIndemnityER = prevpaidAmtIndemnityER;
    }

    public ClaimDetailsInfo withPrevpaidAmtIndemnityER(Object prevpaidAmtIndemnityER) {
        this.prevpaidAmtIndemnityER = prevpaidAmtIndemnityER;
        return this;
    }

    @JsonProperty("prevpaidAmtFeesER")
    public Object getPrevpaidAmtFeesER() {
        return prevpaidAmtFeesER;
    }

    @JsonProperty("prevpaidAmtFeesER")
    public void setPrevpaidAmtFeesER(Object prevpaidAmtFeesER) {
        this.prevpaidAmtFeesER = prevpaidAmtFeesER;
    }

    public ClaimDetailsInfo withPrevpaidAmtFeesER(Object prevpaidAmtFeesER) {
        this.prevpaidAmtFeesER = prevpaidAmtFeesER;
        return this;
    }

    @JsonProperty("prevpaidAmtExpensesER")
    public Object getPrevpaidAmtExpensesER() {
        return prevpaidAmtExpensesER;
    }

    @JsonProperty("prevpaidAmtExpensesER")
    public void setPrevpaidAmtExpensesER(Object prevpaidAmtExpensesER) {
        this.prevpaidAmtExpensesER = prevpaidAmtExpensesER;
    }

    public ClaimDetailsInfo withPrevpaidAmtExpensesER(Object prevpaidAmtExpensesER) {
        this.prevpaidAmtExpensesER = prevpaidAmtExpensesER;
        return this;
    }

    @JsonProperty("settlementAmtIndemnityER")
    public BigInteger getSettlementAmtIndemnityER() {
        return settlementAmtIndemnityER;
    }

    @JsonProperty("settlementAmtIndemnityER")
    public void setSettlementAmtIndemnityER(BigInteger settlementAmtIndemnityER) {
        this.settlementAmtIndemnityER = settlementAmtIndemnityER;
    }

    public ClaimDetailsInfo withSettlementAmtIndemnityER(BigInteger settlementAmtIndemnityER) {
        this.settlementAmtIndemnityER = settlementAmtIndemnityER;
        return this;
    }

    @JsonProperty("settlementAmtFeesER")
    public BigInteger getSettlementAmtFeesER() {
        return settlementAmtFeesER;
    }

    @JsonProperty("settlementAmtFeesER")
    public void setSettlementAmtFeesER(BigInteger settlementAmtFeesER) {
        this.settlementAmtFeesER = settlementAmtFeesER;
    }

    public ClaimDetailsInfo withSettlementAmtFeesER(BigInteger settlementAmtFeesER) {
        this.settlementAmtFeesER = settlementAmtFeesER;
        return this;
    }

    @JsonProperty("settlementAmtExpensesER")
    public BigInteger getSettlementAmtExpensesER() {
        return settlementAmtExpensesER;
    }

    @JsonProperty("settlementAmtExpensesER")
    public void setSettlementAmtExpensesER(BigInteger settlementAmtExpensesER) {
        this.settlementAmtExpensesER = settlementAmtExpensesER;
    }

    public ClaimDetailsInfo withSettlementAmtExpensesER(BigInteger settlementAmtExpensesER) {
        this.settlementAmtExpensesER = settlementAmtExpensesER;
        return this;
    }

    @JsonProperty("reserveAmountIndemnityER")
    public Object getReserveAmountIndemnityER() {
        return reserveAmountIndemnityER;
    }

    @JsonProperty("reserveAmountIndemnityER")
    public void setReserveAmountIndemnityER(Object reserveAmountIndemnityER) {
        this.reserveAmountIndemnityER = reserveAmountIndemnityER;
    }

    public ClaimDetailsInfo withReserveAmountIndemnityER(Object reserveAmountIndemnityER) {
        this.reserveAmountIndemnityER = reserveAmountIndemnityER;
        return this;
    }

    @JsonProperty("reserveAmountFeesER")
    public Object getReserveAmountFeesER() {
        return reserveAmountFeesER;
    }

    @JsonProperty("reserveAmountFeesER")
    public void setReserveAmountFeesER(Object reserveAmountFeesER) {
        this.reserveAmountFeesER = reserveAmountFeesER;
    }

    public ClaimDetailsInfo withReserveAmountFeesER(Object reserveAmountFeesER) {
        this.reserveAmountFeesER = reserveAmountFeesER;
        return this;
    }

    @JsonProperty("reserveAmountExpensesER")
    public Object getReserveAmountExpensesER() {
        return reserveAmountExpensesER;
    }

    @JsonProperty("reserveAmountExpensesER")
    public void setReserveAmountExpensesER(Object reserveAmountExpensesER) {
        this.reserveAmountExpensesER = reserveAmountExpensesER;
    }

    public ClaimDetailsInfo withReserveAmountExpensesER(Object reserveAmountExpensesER) {
        this.reserveAmountExpensesER = reserveAmountExpensesER;
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

    public ClaimDetailsInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @JsonProperty("policyTransactionsInfo")
    public List<PolicyTransactionsInfo> getPolicyTransactionsInfo() {
        return policyTransactionsInfo;
    }

    @JsonProperty("policyTransactionsInfo")
    public void setPolicyTransactionsInfo(List<PolicyTransactionsInfo> policyTransactionsInfo) {
        this.policyTransactionsInfo = policyTransactionsInfo;
    }

    public ClaimDetailsInfo withPolicyTransactionsInfo(List<PolicyTransactionsInfo> policyTransactionsInfo) {
        this.policyTransactionsInfo = policyTransactionsInfo;
        return this;
    }

    @JsonProperty("claimsCheckListInfo")
    public List<ClaimsCheckListInfo_> getClaimsCheckListInfo() {
        return claimsCheckListInfo;
    }

    @JsonProperty("claimsCheckListInfo")
    public void setClaimsCheckListInfo(List<ClaimsCheckListInfo_> claimsCheckListInfo) {
        this.claimsCheckListInfo = claimsCheckListInfo;
    }

    public ClaimDetailsInfo withClaimsCheckListInfo(List<ClaimsCheckListInfo_> claimsCheckListInfo) {
        this.claimsCheckListInfo = claimsCheckListInfo;
        return this;
    }

    @JsonProperty("claimsItemsInfo")
    public List<Object> getClaimsItemsInfo() {
        return claimsItemsInfo;
    }

    @JsonProperty("claimsItemsInfo")
    public void setClaimsItemsInfo(List<Object> claimsItemsInfo) {
        this.claimsItemsInfo = claimsItemsInfo;
    }

    public ClaimDetailsInfo withClaimsItemsInfo(List<Object> claimsItemsInfo) {
        this.claimsItemsInfo = claimsItemsInfo;
        return this;
    }

    @JsonProperty("claimsFileInfo")
    public List<Object> getClaimsFileInfo() {
        return claimsFileInfo;
    }

    @JsonProperty("claimsFileInfo")
    public void setClaimsFileInfo(List<Object> claimsFileInfo) {
        this.claimsFileInfo = claimsFileInfo;
    }

    public ClaimDetailsInfo withClaimsFileInfo(List<Object> claimsFileInfo) {
        this.claimsFileInfo = claimsFileInfo;
        return this;
    }

    @JsonProperty("claimReserveInfo")
    public List<Object> getClaimReserveInfo() {
        return claimReserveInfo;
    }

    @JsonProperty("claimReserveInfo")
    public void setClaimReserveInfo(List<Object> claimReserveInfo) {
        this.claimReserveInfo = claimReserveInfo;
    }

    public ClaimDetailsInfo withClaimReserveInfo(List<Object> claimReserveInfo) {
        this.claimReserveInfo = claimReserveInfo;
        return this;
    }

    @JsonProperty("claimNotesInfo")
    public List<ClaimNotesInfo_> getClaimNotesInfo() {
        return claimNotesInfo;
    }

    @JsonProperty("claimNotesInfo")
    public void setClaimNotesInfo(List<ClaimNotesInfo_> claimNotesInfo) {
        this.claimNotesInfo = claimNotesInfo;
    }

    public ClaimDetailsInfo withClaimNotesInfo(List<ClaimNotesInfo_> claimNotesInfo) {
        this.claimNotesInfo = claimNotesInfo;
        return this;
    }

    @JsonProperty("claimDetailInternalReferenceInfo")
    public List<Object> getClaimDetailInternalReferenceInfo() {
        return claimDetailInternalReferenceInfo;
    }

    @JsonProperty("claimDetailInternalReferenceInfo")
    public void setClaimDetailInternalReferenceInfo(List<Object> claimDetailInternalReferenceInfo) {
        this.claimDetailInternalReferenceInfo = claimDetailInternalReferenceInfo;
    }

    public ClaimDetailsInfo withClaimDetailInternalReferenceInfo(List<Object> claimDetailInternalReferenceInfo) {
        this.claimDetailInternalReferenceInfo = claimDetailInternalReferenceInfo;
        return this;
    }

    @JsonProperty("claimParticipantInfo")
    public Object getClaimParticipantInfo() {
        return claimParticipantInfo;
    }

    @JsonProperty("claimParticipantInfo")
    public void setClaimParticipantInfo(Object claimParticipantInfo) {
        this.claimParticipantInfo = claimParticipantInfo;
    }

    public ClaimDetailsInfo withClaimParticipantInfo(Object claimParticipantInfo) {
        this.claimParticipantInfo = claimParticipantInfo;
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
