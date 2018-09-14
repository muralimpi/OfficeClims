
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
    "intRefId",
    "stampId",
    "claimId",
    "claimHeaderId",
    "policyTransactionId",
    "marketTransactionId",
    "elsecoRiskCode",
    "intReferenceNo",
    "splitClaimPercVl",
    "splitClaimPercAmt",
    "premiumSplitVl",
    "stampName",
    "fundsCollected",
    "isCollected",
    "collectPayEnabled",
    "transactionType",
    "transactionSubType",
    "nwincurdclamt",
    "setlmntclamt",
    "comment",
    "prevpdclamt",
    "originalCurrency",
    "dueDate",
    "prevpaidAmtIndemnityIR",
    "prevpaidAmtFeesIR",
    "prevpaidAmtExpensesIR",
    "settlementAmtIndemnityIR",
    "settlementAmtFeesIR",
    "settlementAmtExpensesIR",
    "reserveAmountIndemnityIR",
    "reserveAmountFeesIR",
    "reserveAmountExpensesIR",
    "deleteFlag",
    "memberInfo",
    "hybrisPayHistoryInfo"
})
public class ClaimsInternalRefInfo {

    @JsonProperty("intRefId")
    private BigInteger intRefId;
    @JsonProperty("stampId")
    private BigInteger stampId;
    @JsonProperty("claimId")
    private BigInteger claimId;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("policyTransactionId")
    private BigInteger policyTransactionId;
    @JsonProperty("marketTransactionId")
    private BigInteger marketTransactionId;
    @JsonProperty("elsecoRiskCode")
    private String elsecoRiskCode;
    @JsonProperty("intReferenceNo")
    private String intReferenceNo;
    @JsonProperty("splitClaimPercVl")
    private String splitClaimPercVl;
    @JsonProperty("splitClaimPercAmt")
    private Object splitClaimPercAmt;
    @JsonProperty("premiumSplitVl")
    private String premiumSplitVl;
    @JsonProperty("stampName")
    private String stampName;
    @JsonProperty("fundsCollected")
    private String fundsCollected;
    @JsonProperty("isCollected")
    private String isCollected;
    @JsonProperty("collectPayEnabled")
    private Object collectPayEnabled;
    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("transactionSubType")
    private String transactionSubType;
    @JsonProperty("nwincurdclamt")
    private BigInteger nwincurdclamt;
    @JsonProperty("setlmntclamt")
    private BigInteger setlmntclamt;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("prevpdclamt")
    private Object prevpdclamt;
    @JsonProperty("originalCurrency")
    private String originalCurrency;
    @JsonProperty("dueDate")
    private String dueDate;
    @JsonProperty("prevpaidAmtIndemnityIR")
    private BigInteger prevpaidAmtIndemnityIR;
    @JsonProperty("prevpaidAmtFeesIR")
    private BigInteger prevpaidAmtFeesIR;
    @JsonProperty("prevpaidAmtExpensesIR")
    private BigInteger prevpaidAmtExpensesIR;
    @JsonProperty("settlementAmtIndemnityIR")
    private BigInteger settlementAmtIndemnityIR;
    @JsonProperty("settlementAmtFeesIR")
    private BigInteger settlementAmtFeesIR;
    @JsonProperty("settlementAmtExpensesIR")
    private BigInteger settlementAmtExpensesIR;
    @JsonProperty("reserveAmountIndemnityIR")
    private BigInteger reserveAmountIndemnityIR;
    @JsonProperty("reserveAmountFeesIR")
    private BigInteger reserveAmountFeesIR;
    @JsonProperty("reserveAmountExpensesIR")
    private BigInteger reserveAmountExpensesIR;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    @JsonProperty("memberInfo")
    private List<MemberInfo> memberInfo = new ArrayList<MemberInfo>();
    @JsonProperty("hybrisPayHistoryInfo")
    private List<Object> hybrisPayHistoryInfo = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("intRefId")
    public BigInteger getIntRefId() {
        return intRefId;
    }

    @JsonProperty("intRefId")
    public void setIntRefId(BigInteger intRefId) {
        this.intRefId = intRefId;
    }

    public ClaimsInternalRefInfo withIntRefId(BigInteger intRefId) {
        this.intRefId = intRefId;
        return this;
    }

    @JsonProperty("stampId")
    public BigInteger getStampId() {
        return stampId;
    }

    @JsonProperty("stampId")
    public void setStampId(BigInteger stampId) {
        this.stampId = stampId;
    }

    public ClaimsInternalRefInfo withStampId(BigInteger stampId) {
        this.stampId = stampId;
        return this;
    }

    @JsonProperty("claimId")
    public BigInteger getClaimId() {
        return claimId;
    }

    @JsonProperty("claimId")
    public void setClaimId(BigInteger claimId) {
        this.claimId = claimId;
    }

    public ClaimsInternalRefInfo withClaimId(BigInteger claimId) {
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

    public ClaimsInternalRefInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("policyTransactionId")
    public BigInteger getPolicyTransactionId() {
        return policyTransactionId;
    }

    @JsonProperty("policyTransactionId")
    public void setPolicyTransactionId(BigInteger policyTransactionId) {
        this.policyTransactionId = policyTransactionId;
    }

    public ClaimsInternalRefInfo withPolicyTransactionId(BigInteger policyTransactionId) {
        this.policyTransactionId = policyTransactionId;
        return this;
    }

    @JsonProperty("marketTransactionId")
    public BigInteger getMarketTransactionId() {
        return marketTransactionId;
    }

    @JsonProperty("marketTransactionId")
    public void setMarketTransactionId(BigInteger marketTransactionId) {
        this.marketTransactionId = marketTransactionId;
    }

    public ClaimsInternalRefInfo withMarketTransactionId(BigInteger marketTransactionId) {
        this.marketTransactionId = marketTransactionId;
        return this;
    }

    @JsonProperty("elsecoRiskCode")
    public String getElsecoRiskCode() {
        return elsecoRiskCode;
    }

    @JsonProperty("elsecoRiskCode")
    public void setElsecoRiskCode(String elsecoRiskCode) {
        this.elsecoRiskCode = elsecoRiskCode;
    }

    public ClaimsInternalRefInfo withElsecoRiskCode(String elsecoRiskCode) {
        this.elsecoRiskCode = elsecoRiskCode;
        return this;
    }

    @JsonProperty("intReferenceNo")
    public String getIntReferenceNo() {
        return intReferenceNo;
    }

    @JsonProperty("intReferenceNo")
    public void setIntReferenceNo(String intReferenceNo) {
        this.intReferenceNo = intReferenceNo;
    }

    public ClaimsInternalRefInfo withIntReferenceNo(String intReferenceNo) {
        this.intReferenceNo = intReferenceNo;
        return this;
    }

    @JsonProperty("splitClaimPercVl")
    public String getSplitClaimPercVl() {
        return splitClaimPercVl;
    }

    @JsonProperty("splitClaimPercVl")
    public void setSplitClaimPercVl(String splitClaimPercVl) {
        this.splitClaimPercVl = splitClaimPercVl;
    }

    public ClaimsInternalRefInfo withSplitClaimPercVl(String splitClaimPercVl) {
        this.splitClaimPercVl = splitClaimPercVl;
        return this;
    }

    @JsonProperty("splitClaimPercAmt")
    public Object getSplitClaimPercAmt() {
        return splitClaimPercAmt;
    }

    @JsonProperty("splitClaimPercAmt")
    public void setSplitClaimPercAmt(Object splitClaimPercAmt) {
        this.splitClaimPercAmt = splitClaimPercAmt;
    }

    public ClaimsInternalRefInfo withSplitClaimPercAmt(Object splitClaimPercAmt) {
        this.splitClaimPercAmt = splitClaimPercAmt;
        return this;
    }

    @JsonProperty("premiumSplitVl")
    public String getPremiumSplitVl() {
        return premiumSplitVl;
    }

    @JsonProperty("premiumSplitVl")
    public void setPremiumSplitVl(String premiumSplitVl) {
        this.premiumSplitVl = premiumSplitVl;
    }

    public ClaimsInternalRefInfo withPremiumSplitVl(String premiumSplitVl) {
        this.premiumSplitVl = premiumSplitVl;
        return this;
    }

    @JsonProperty("stampName")
    public String getStampName() {
        return stampName;
    }

    @JsonProperty("stampName")
    public void setStampName(String stampName) {
        this.stampName = stampName;
    }

    public ClaimsInternalRefInfo withStampName(String stampName) {
        this.stampName = stampName;
        return this;
    }

    @JsonProperty("fundsCollected")
    public String getFundsCollected() {
        return fundsCollected;
    }

    @JsonProperty("fundsCollected")
    public void setFundsCollected(String fundsCollected) {
        this.fundsCollected = fundsCollected;
    }

    public ClaimsInternalRefInfo withFundsCollected(String fundsCollected) {
        this.fundsCollected = fundsCollected;
        return this;
    }

    @JsonProperty("isCollected")
    public String getIsCollected() {
        return isCollected;
    }

    @JsonProperty("isCollected")
    public void setIsCollected(String isCollected) {
        this.isCollected = isCollected;
    }

    public ClaimsInternalRefInfo withIsCollected(String isCollected) {
        this.isCollected = isCollected;
        return this;
    }

    @JsonProperty("collectPayEnabled")
    public Object getCollectPayEnabled() {
        return collectPayEnabled;
    }

    @JsonProperty("collectPayEnabled")
    public void setCollectPayEnabled(Object collectPayEnabled) {
        this.collectPayEnabled = collectPayEnabled;
    }

    public ClaimsInternalRefInfo withCollectPayEnabled(Object collectPayEnabled) {
        this.collectPayEnabled = collectPayEnabled;
        return this;
    }

    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("transactionType")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public ClaimsInternalRefInfo withTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    @JsonProperty("transactionSubType")
    public String getTransactionSubType() {
        return transactionSubType;
    }

    @JsonProperty("transactionSubType")
    public void setTransactionSubType(String transactionSubType) {
        this.transactionSubType = transactionSubType;
    }

    public ClaimsInternalRefInfo withTransactionSubType(String transactionSubType) {
        this.transactionSubType = transactionSubType;
        return this;
    }

    @JsonProperty("nwincurdclamt")
    public BigInteger getNwincurdclamt() {
        return nwincurdclamt;
    }

    @JsonProperty("nwincurdclamt")
    public void setNwincurdclamt(BigInteger nwincurdclamt) {
        this.nwincurdclamt = nwincurdclamt;
    }

    public ClaimsInternalRefInfo withNwincurdclamt(BigInteger nwincurdclamt) {
        this.nwincurdclamt = nwincurdclamt;
        return this;
    }

    @JsonProperty("setlmntclamt")
    public BigInteger getSetlmntclamt() {
        return setlmntclamt;
    }

    @JsonProperty("setlmntclamt")
    public void setSetlmntclamt(BigInteger setlmntclamt) {
        this.setlmntclamt = setlmntclamt;
    }

    public ClaimsInternalRefInfo withSetlmntclamt(BigInteger setlmntclamt) {
        this.setlmntclamt = setlmntclamt;
        return this;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    public ClaimsInternalRefInfo withComment(String comment) {
        this.comment = comment;
        return this;
    }

    @JsonProperty("prevpdclamt")
    public Object getPrevpdclamt() {
        return prevpdclamt;
    }

    @JsonProperty("prevpdclamt")
    public void setPrevpdclamt(Object prevpdclamt) {
        this.prevpdclamt = prevpdclamt;
    }

    public ClaimsInternalRefInfo withPrevpdclamt(Object prevpdclamt) {
        this.prevpdclamt = prevpdclamt;
        return this;
    }

    @JsonProperty("originalCurrency")
    public String getOriginalCurrency() {
        return originalCurrency;
    }

    @JsonProperty("originalCurrency")
    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public ClaimsInternalRefInfo withOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
        return this;
    }

    @JsonProperty("dueDate")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("dueDate")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public ClaimsInternalRefInfo withDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @JsonProperty("prevpaidAmtIndemnityIR")
    public BigInteger getPrevpaidAmtIndemnityIR() {
        return prevpaidAmtIndemnityIR;
    }

    @JsonProperty("prevpaidAmtIndemnityIR")
    public void setPrevpaidAmtIndemnityIR(BigInteger prevpaidAmtIndemnityIR) {
        this.prevpaidAmtIndemnityIR = prevpaidAmtIndemnityIR;
    }

    public ClaimsInternalRefInfo withPrevpaidAmtIndemnityIR(BigInteger prevpaidAmtIndemnityIR) {
        this.prevpaidAmtIndemnityIR = prevpaidAmtIndemnityIR;
        return this;
    }

    @JsonProperty("prevpaidAmtFeesIR")
    public BigInteger getPrevpaidAmtFeesIR() {
        return prevpaidAmtFeesIR;
    }

    @JsonProperty("prevpaidAmtFeesIR")
    public void setPrevpaidAmtFeesIR(BigInteger prevpaidAmtFeesIR) {
        this.prevpaidAmtFeesIR = prevpaidAmtFeesIR;
    }

    public ClaimsInternalRefInfo withPrevpaidAmtFeesIR(BigInteger prevpaidAmtFeesIR) {
        this.prevpaidAmtFeesIR = prevpaidAmtFeesIR;
        return this;
    }

    @JsonProperty("prevpaidAmtExpensesIR")
    public BigInteger getPrevpaidAmtExpensesIR() {
        return prevpaidAmtExpensesIR;
    }

    @JsonProperty("prevpaidAmtExpensesIR")
    public void setPrevpaidAmtExpensesIR(BigInteger prevpaidAmtExpensesIR) {
        this.prevpaidAmtExpensesIR = prevpaidAmtExpensesIR;
    }

    public ClaimsInternalRefInfo withPrevpaidAmtExpensesIR(BigInteger prevpaidAmtExpensesIR) {
        this.prevpaidAmtExpensesIR = prevpaidAmtExpensesIR;
        return this;
    }

    @JsonProperty("settlementAmtIndemnityIR")
    public BigInteger getSettlementAmtIndemnityIR() {
        return settlementAmtIndemnityIR;
    }

    @JsonProperty("settlementAmtIndemnityIR")
    public void setSettlementAmtIndemnityIR(BigInteger settlementAmtIndemnityIR) {
        this.settlementAmtIndemnityIR = settlementAmtIndemnityIR;
    }

    public ClaimsInternalRefInfo withSettlementAmtIndemnityIR(BigInteger settlementAmtIndemnityIR) {
        this.settlementAmtIndemnityIR = settlementAmtIndemnityIR;
        return this;
    }

    @JsonProperty("settlementAmtFeesIR")
    public BigInteger getSettlementAmtFeesIR() {
        return settlementAmtFeesIR;
    }

    @JsonProperty("settlementAmtFeesIR")
    public void setSettlementAmtFeesIR(BigInteger settlementAmtFeesIR) {
        this.settlementAmtFeesIR = settlementAmtFeesIR;
    }

    public ClaimsInternalRefInfo withSettlementAmtFeesIR(BigInteger settlementAmtFeesIR) {
        this.settlementAmtFeesIR = settlementAmtFeesIR;
        return this;
    }

    @JsonProperty("settlementAmtExpensesIR")
    public BigInteger getSettlementAmtExpensesIR() {
        return settlementAmtExpensesIR;
    }

    @JsonProperty("settlementAmtExpensesIR")
    public void setSettlementAmtExpensesIR(BigInteger settlementAmtExpensesIR) {
        this.settlementAmtExpensesIR = settlementAmtExpensesIR;
    }

    public ClaimsInternalRefInfo withSettlementAmtExpensesIR(BigInteger settlementAmtExpensesIR) {
        this.settlementAmtExpensesIR = settlementAmtExpensesIR;
        return this;
    }

    @JsonProperty("reserveAmountIndemnityIR")
    public BigInteger getReserveAmountIndemnityIR() {
        return reserveAmountIndemnityIR;
    }

    @JsonProperty("reserveAmountIndemnityIR")
    public void setReserveAmountIndemnityIR(BigInteger reserveAmountIndemnityIR) {
        this.reserveAmountIndemnityIR = reserveAmountIndemnityIR;
    }

    public ClaimsInternalRefInfo withReserveAmountIndemnityIR(BigInteger reserveAmountIndemnityIR) {
        this.reserveAmountIndemnityIR = reserveAmountIndemnityIR;
        return this;
    }

    @JsonProperty("reserveAmountFeesIR")
    public BigInteger getReserveAmountFeesIR() {
        return reserveAmountFeesIR;
    }

    @JsonProperty("reserveAmountFeesIR")
    public void setReserveAmountFeesIR(BigInteger reserveAmountFeesIR) {
        this.reserveAmountFeesIR = reserveAmountFeesIR;
    }

    public ClaimsInternalRefInfo withReserveAmountFeesIR(BigInteger reserveAmountFeesIR) {
        this.reserveAmountFeesIR = reserveAmountFeesIR;
        return this;
    }

    @JsonProperty("reserveAmountExpensesIR")
    public BigInteger getReserveAmountExpensesIR() {
        return reserveAmountExpensesIR;
    }

    @JsonProperty("reserveAmountExpensesIR")
    public void setReserveAmountExpensesIR(BigInteger reserveAmountExpensesIR) {
        this.reserveAmountExpensesIR = reserveAmountExpensesIR;
    }

    public ClaimsInternalRefInfo withReserveAmountExpensesIR(BigInteger reserveAmountExpensesIR) {
        this.reserveAmountExpensesIR = reserveAmountExpensesIR;
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

    public ClaimsInternalRefInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @JsonProperty("memberInfo")
    public List<MemberInfo> getMemberInfo() {
        return memberInfo;
    }

    @JsonProperty("memberInfo")
    public void setMemberInfo(List<MemberInfo> memberInfo) {
        this.memberInfo = memberInfo;
    }

    public ClaimsInternalRefInfo withMemberInfo(List<MemberInfo> memberInfo) {
        this.memberInfo = memberInfo;
        return this;
    }

    @JsonProperty("hybrisPayHistoryInfo")
    public List<Object> getHybrisPayHistoryInfo() {
        return hybrisPayHistoryInfo;
    }

    @JsonProperty("hybrisPayHistoryInfo")
    public void setHybrisPayHistoryInfo(List<Object> hybrisPayHistoryInfo) {
        this.hybrisPayHistoryInfo = hybrisPayHistoryInfo;
    }

    public ClaimsInternalRefInfo withHybrisPayHistoryInfo(List<Object> hybrisPayHistoryInfo) {
        this.hybrisPayHistoryInfo = hybrisPayHistoryInfo;
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
