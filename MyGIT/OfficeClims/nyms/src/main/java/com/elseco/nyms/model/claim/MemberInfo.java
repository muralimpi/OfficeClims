
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
    "memberId",
    "stampId",
    "intRefId",
    "policyTransactionId",
    "marketTransactionId",
    "claimId",
    "claimHeaderId",
    "memberBpId",
    "stampName",
    "stampStartDate",
    "stampEndDate",
    "stampStatusId",
    "stampDescription",
    "collectionType",
    "splitClaimPercVl",
    "splitClaimPercAmt",
    "frontier",
    "transactioning",
    "createdOn",
    "approvedOn",
    "createdBy",
    "submittedBy",
    "submittedOn",
    "approvedBy",
    "poolUWYId",
    "prevpaidAmtIndemnityMI",
    "prevpaidAmtFeesMI",
    "prevpaidAmtExpensesMI",
    "settlementAmtIndemnityMI",
    "settlementAmtFeesMI",
    "settlementAmtExpensesMI",
    "reserveAmountIndemnityMI",
    "reserveAmountFeesMI",
    "reserveAmountExpensesMI",
    "availableClmFund",
    "availableOffSetPrm",
    "memberName",
    "memberEmail",
    "dueDate",
    "collectedDate",
    "status",
    "isCollected",
    "notifyEnabled",
    "deleteFlag",
    "memberResultsInfo"
})
public class MemberInfo {

    @JsonProperty("memberId")
    private BigInteger memberId;
    @JsonProperty("stampId")
    private BigInteger stampId;
    @JsonProperty("intRefId")
    private BigInteger intRefId;
    @JsonProperty("policyTransactionId")
    private BigInteger policyTransactionId;
    @JsonProperty("marketTransactionId")
    private BigInteger marketTransactionId;
    @JsonProperty("claimId")
    private BigInteger claimId;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("memberBpId")
    private BigInteger memberBpId;
    @JsonProperty("stampName")
    private String stampName;
    @JsonProperty("stampStartDate")
    private Object stampStartDate;
    @JsonProperty("stampEndDate")
    private Object stampEndDate;
    @JsonProperty("stampStatusId")
    private BigInteger stampStatusId;
    @JsonProperty("stampDescription")
    private String stampDescription;
    @JsonProperty("collectionType")
    private String collectionType;
    @JsonProperty("splitClaimPercVl")
    private String splitClaimPercVl;
    @JsonProperty("splitClaimPercAmt")
    private Object splitClaimPercAmt;
    @JsonProperty("frontier")
    private String frontier;
    @JsonProperty("transactioning")
    private String transactioning;
    @JsonProperty("createdOn")
    private Object createdOn;
    @JsonProperty("approvedOn")
    private Object approvedOn;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("submittedBy")
    private String submittedBy;
    @JsonProperty("submittedOn")
    private Object submittedOn;
    @JsonProperty("approvedBy")
    private String approvedBy;
    @JsonProperty("poolUWYId")
    private String poolUWYId;
    @JsonProperty("prevpaidAmtIndemnityMI")
    private BigInteger prevpaidAmtIndemnityMI;
    @JsonProperty("prevpaidAmtFeesMI")
    private BigInteger prevpaidAmtFeesMI;
    @JsonProperty("prevpaidAmtExpensesMI")
    private BigInteger prevpaidAmtExpensesMI;
    @JsonProperty("settlementAmtIndemnityMI")
    private BigInteger settlementAmtIndemnityMI;
    @JsonProperty("settlementAmtFeesMI")
    private BigInteger settlementAmtFeesMI;
    @JsonProperty("settlementAmtExpensesMI")
    private BigInteger settlementAmtExpensesMI;
    @JsonProperty("reserveAmountIndemnityMI")
    private BigInteger reserveAmountIndemnityMI;
    @JsonProperty("reserveAmountFeesMI")
    private BigInteger reserveAmountFeesMI;
    @JsonProperty("reserveAmountExpensesMI")
    private BigInteger reserveAmountExpensesMI;
    @JsonProperty("availableClmFund")
    private BigInteger availableClmFund;
    @JsonProperty("availableOffSetPrm")
    private Double availableOffSetPrm;
    @JsonProperty("memberName")
    private String memberName;
    @JsonProperty("memberEmail")
    private String memberEmail;
    @JsonProperty("dueDate")
    private String dueDate;
    @JsonProperty("collectedDate")
    private Object collectedDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("isCollected")
    private String isCollected;
    @JsonProperty("notifyEnabled")
    private String notifyEnabled;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    @JsonProperty("memberResultsInfo")
    private List<Object> memberResultsInfo = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("memberId")
    public BigInteger getMemberId() {
        return memberId;
    }

    @JsonProperty("memberId")
    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
    }

    public MemberInfo withMemberId(BigInteger memberId) {
        this.memberId = memberId;
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

    public MemberInfo withStampId(BigInteger stampId) {
        this.stampId = stampId;
        return this;
    }

    @JsonProperty("intRefId")
    public BigInteger getIntRefId() {
        return intRefId;
    }

    @JsonProperty("intRefId")
    public void setIntRefId(BigInteger intRefId) {
        this.intRefId = intRefId;
    }

    public MemberInfo withIntRefId(BigInteger intRefId) {
        this.intRefId = intRefId;
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

    public MemberInfo withPolicyTransactionId(BigInteger policyTransactionId) {
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

    public MemberInfo withMarketTransactionId(BigInteger marketTransactionId) {
        this.marketTransactionId = marketTransactionId;
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

    public MemberInfo withClaimId(BigInteger claimId) {
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

    public MemberInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("memberBpId")
    public BigInteger getMemberBpId() {
        return memberBpId;
    }

    @JsonProperty("memberBpId")
    public void setMemberBpId(BigInteger memberBpId) {
        this.memberBpId = memberBpId;
    }

    public MemberInfo withMemberBpId(BigInteger memberBpId) {
        this.memberBpId = memberBpId;
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

    public MemberInfo withStampName(String stampName) {
        this.stampName = stampName;
        return this;
    }

    @JsonProperty("stampStartDate")
    public Object getStampStartDate() {
        return stampStartDate;
    }

    @JsonProperty("stampStartDate")
    public void setStampStartDate(Object stampStartDate) {
        this.stampStartDate = stampStartDate;
    }

    public MemberInfo withStampStartDate(Object stampStartDate) {
        this.stampStartDate = stampStartDate;
        return this;
    }

    @JsonProperty("stampEndDate")
    public Object getStampEndDate() {
        return stampEndDate;
    }

    @JsonProperty("stampEndDate")
    public void setStampEndDate(Object stampEndDate) {
        this.stampEndDate = stampEndDate;
    }

    public MemberInfo withStampEndDate(Object stampEndDate) {
        this.stampEndDate = stampEndDate;
        return this;
    }

    @JsonProperty("stampStatusId")
    public BigInteger getStampStatusId() {
        return stampStatusId;
    }

    @JsonProperty("stampStatusId")
    public void setStampStatusId(BigInteger stampStatusId) {
        this.stampStatusId = stampStatusId;
    }

    public MemberInfo withStampStatusId(BigInteger stampStatusId) {
        this.stampStatusId = stampStatusId;
        return this;
    }

    @JsonProperty("stampDescription")
    public String getStampDescription() {
        return stampDescription;
    }

    @JsonProperty("stampDescription")
    public void setStampDescription(String stampDescription) {
        this.stampDescription = stampDescription;
    }

    public MemberInfo withStampDescription(String stampDescription) {
        this.stampDescription = stampDescription;
        return this;
    }

    @JsonProperty("collectionType")
    public String getCollectionType() {
        return collectionType;
    }

    @JsonProperty("collectionType")
    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public MemberInfo withCollectionType(String collectionType) {
        this.collectionType = collectionType;
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

    public MemberInfo withSplitClaimPercVl(String splitClaimPercVl) {
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

    public MemberInfo withSplitClaimPercAmt(Object splitClaimPercAmt) {
        this.splitClaimPercAmt = splitClaimPercAmt;
        return this;
    }

    @JsonProperty("frontier")
    public String getFrontier() {
        return frontier;
    }

    @JsonProperty("frontier")
    public void setFrontier(String frontier) {
        this.frontier = frontier;
    }

    public MemberInfo withFrontier(String frontier) {
        this.frontier = frontier;
        return this;
    }

    @JsonProperty("transactioning")
    public String getTransactioning() {
        return transactioning;
    }

    @JsonProperty("transactioning")
    public void setTransactioning(String transactioning) {
        this.transactioning = transactioning;
    }

    public MemberInfo withTransactioning(String transactioning) {
        this.transactioning = transactioning;
        return this;
    }

    @JsonProperty("createdOn")
    public Object getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(Object createdOn) {
        this.createdOn = createdOn;
    }

    public MemberInfo withCreatedOn(Object createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @JsonProperty("approvedOn")
    public Object getApprovedOn() {
        return approvedOn;
    }

    @JsonProperty("approvedOn")
    public void setApprovedOn(Object approvedOn) {
        this.approvedOn = approvedOn;
    }

    public MemberInfo withApprovedOn(Object approvedOn) {
        this.approvedOn = approvedOn;
        return this;
    }

    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public MemberInfo withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @JsonProperty("submittedBy")
    public String getSubmittedBy() {
        return submittedBy;
    }

    @JsonProperty("submittedBy")
    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public MemberInfo withSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
        return this;
    }

    @JsonProperty("submittedOn")
    public Object getSubmittedOn() {
        return submittedOn;
    }

    @JsonProperty("submittedOn")
    public void setSubmittedOn(Object submittedOn) {
        this.submittedOn = submittedOn;
    }

    public MemberInfo withSubmittedOn(Object submittedOn) {
        this.submittedOn = submittedOn;
        return this;
    }

    @JsonProperty("approvedBy")
    public String getApprovedBy() {
        return approvedBy;
    }

    @JsonProperty("approvedBy")
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public MemberInfo withApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
        return this;
    }

    @JsonProperty("poolUWYId")
    public String getPoolUWYId() {
        return poolUWYId;
    }

    @JsonProperty("poolUWYId")
    public void setPoolUWYId(String poolUWYId) {
        this.poolUWYId = poolUWYId;
    }

    public MemberInfo withPoolUWYId(String poolUWYId) {
        this.poolUWYId = poolUWYId;
        return this;
    }

    @JsonProperty("prevpaidAmtIndemnityMI")
    public BigInteger getPrevpaidAmtIndemnityMI() {
        return prevpaidAmtIndemnityMI;
    }

    @JsonProperty("prevpaidAmtIndemnityMI")
    public void setPrevpaidAmtIndemnityMI(BigInteger prevpaidAmtIndemnityMI) {
        this.prevpaidAmtIndemnityMI = prevpaidAmtIndemnityMI;
    }

    public MemberInfo withPrevpaidAmtIndemnityMI(BigInteger prevpaidAmtIndemnityMI) {
        this.prevpaidAmtIndemnityMI = prevpaidAmtIndemnityMI;
        return this;
    }

    @JsonProperty("prevpaidAmtFeesMI")
    public BigInteger getPrevpaidAmtFeesMI() {
        return prevpaidAmtFeesMI;
    }

    @JsonProperty("prevpaidAmtFeesMI")
    public void setPrevpaidAmtFeesMI(BigInteger prevpaidAmtFeesMI) {
        this.prevpaidAmtFeesMI = prevpaidAmtFeesMI;
    }

    public MemberInfo withPrevpaidAmtFeesMI(BigInteger prevpaidAmtFeesMI) {
        this.prevpaidAmtFeesMI = prevpaidAmtFeesMI;
        return this;
    }

    @JsonProperty("prevpaidAmtExpensesMI")
    public BigInteger getPrevpaidAmtExpensesMI() {
        return prevpaidAmtExpensesMI;
    }

    @JsonProperty("prevpaidAmtExpensesMI")
    public void setPrevpaidAmtExpensesMI(BigInteger prevpaidAmtExpensesMI) {
        this.prevpaidAmtExpensesMI = prevpaidAmtExpensesMI;
    }

    public MemberInfo withPrevpaidAmtExpensesMI(BigInteger prevpaidAmtExpensesMI) {
        this.prevpaidAmtExpensesMI = prevpaidAmtExpensesMI;
        return this;
    }

    @JsonProperty("settlementAmtIndemnityMI")
    public BigInteger getSettlementAmtIndemnityMI() {
        return settlementAmtIndemnityMI;
    }

    @JsonProperty("settlementAmtIndemnityMI")
    public void setSettlementAmtIndemnityMI(BigInteger settlementAmtIndemnityMI) {
        this.settlementAmtIndemnityMI = settlementAmtIndemnityMI;
    }

    public MemberInfo withSettlementAmtIndemnityMI(BigInteger settlementAmtIndemnityMI) {
        this.settlementAmtIndemnityMI = settlementAmtIndemnityMI;
        return this;
    }

    @JsonProperty("settlementAmtFeesMI")
    public BigInteger getSettlementAmtFeesMI() {
        return settlementAmtFeesMI;
    }

    @JsonProperty("settlementAmtFeesMI")
    public void setSettlementAmtFeesMI(BigInteger settlementAmtFeesMI) {
        this.settlementAmtFeesMI = settlementAmtFeesMI;
    }

    public MemberInfo withSettlementAmtFeesMI(BigInteger settlementAmtFeesMI) {
        this.settlementAmtFeesMI = settlementAmtFeesMI;
        return this;
    }

    @JsonProperty("settlementAmtExpensesMI")
    public BigInteger getSettlementAmtExpensesMI() {
        return settlementAmtExpensesMI;
    }

    @JsonProperty("settlementAmtExpensesMI")
    public void setSettlementAmtExpensesMI(BigInteger settlementAmtExpensesMI) {
        this.settlementAmtExpensesMI = settlementAmtExpensesMI;
    }

    public MemberInfo withSettlementAmtExpensesMI(BigInteger settlementAmtExpensesMI) {
        this.settlementAmtExpensesMI = settlementAmtExpensesMI;
        return this;
    }

    @JsonProperty("reserveAmountIndemnityMI")
    public BigInteger getReserveAmountIndemnityMI() {
        return reserveAmountIndemnityMI;
    }

    @JsonProperty("reserveAmountIndemnityMI")
    public void setReserveAmountIndemnityMI(BigInteger reserveAmountIndemnityMI) {
        this.reserveAmountIndemnityMI = reserveAmountIndemnityMI;
    }

    public MemberInfo withReserveAmountIndemnityMI(BigInteger reserveAmountIndemnityMI) {
        this.reserveAmountIndemnityMI = reserveAmountIndemnityMI;
        return this;
    }

    @JsonProperty("reserveAmountFeesMI")
    public BigInteger getReserveAmountFeesMI() {
        return reserveAmountFeesMI;
    }

    @JsonProperty("reserveAmountFeesMI")
    public void setReserveAmountFeesMI(BigInteger reserveAmountFeesMI) {
        this.reserveAmountFeesMI = reserveAmountFeesMI;
    }

    public MemberInfo withReserveAmountFeesMI(BigInteger reserveAmountFeesMI) {
        this.reserveAmountFeesMI = reserveAmountFeesMI;
        return this;
    }

    @JsonProperty("reserveAmountExpensesMI")
    public BigInteger getReserveAmountExpensesMI() {
        return reserveAmountExpensesMI;
    }

    @JsonProperty("reserveAmountExpensesMI")
    public void setReserveAmountExpensesMI(BigInteger reserveAmountExpensesMI) {
        this.reserveAmountExpensesMI = reserveAmountExpensesMI;
    }

    public MemberInfo withReserveAmountExpensesMI(BigInteger reserveAmountExpensesMI) {
        this.reserveAmountExpensesMI = reserveAmountExpensesMI;
        return this;
    }

    @JsonProperty("availableClmFund")
    public BigInteger getAvailableClmFund() {
        return availableClmFund;
    }

    @JsonProperty("availableClmFund")
    public void setAvailableClmFund(BigInteger availableClmFund) {
        this.availableClmFund = availableClmFund;
    }

    public MemberInfo withAvailableClmFund(BigInteger availableClmFund) {
        this.availableClmFund = availableClmFund;
        return this;
    }

    @JsonProperty("availableOffSetPrm")
    public Double getAvailableOffSetPrm() {
        return availableOffSetPrm;
    }

    @JsonProperty("availableOffSetPrm")
    public void setAvailableOffSetPrm(Double availableOffSetPrm) {
        this.availableOffSetPrm = availableOffSetPrm;
    }

    public MemberInfo withAvailableOffSetPrm(Double availableOffSetPrm) {
        this.availableOffSetPrm = availableOffSetPrm;
        return this;
    }

    @JsonProperty("memberName")
    public String getMemberName() {
        return memberName;
    }

    @JsonProperty("memberName")
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public MemberInfo withMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }

    @JsonProperty("memberEmail")
    public String getMemberEmail() {
        return memberEmail;
    }

    @JsonProperty("memberEmail")
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public MemberInfo withMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
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

    public MemberInfo withDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @JsonProperty("collectedDate")
    public Object getCollectedDate() {
        return collectedDate;
    }

    @JsonProperty("collectedDate")
    public void setCollectedDate(Object collectedDate) {
        this.collectedDate = collectedDate;
    }

    public MemberInfo withCollectedDate(Object collectedDate) {
        this.collectedDate = collectedDate;
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

    public MemberInfo withStatus(String status) {
        this.status = status;
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

    public MemberInfo withIsCollected(String isCollected) {
        this.isCollected = isCollected;
        return this;
    }

    @JsonProperty("notifyEnabled")
    public String getNotifyEnabled() {
        return notifyEnabled;
    }

    @JsonProperty("notifyEnabled")
    public void setNotifyEnabled(String notifyEnabled) {
        this.notifyEnabled = notifyEnabled;
    }

    public MemberInfo withNotifyEnabled(String notifyEnabled) {
        this.notifyEnabled = notifyEnabled;
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

    public MemberInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @JsonProperty("memberResultsInfo")
    public List<Object> getMemberResultsInfo() {
        return memberResultsInfo;
    }

    @JsonProperty("memberResultsInfo")
    public void setMemberResultsInfo(List<Object> memberResultsInfo) {
        this.memberResultsInfo = memberResultsInfo;
    }

    public MemberInfo withMemberResultsInfo(List<Object> memberResultsInfo) {
        this.memberResultsInfo = memberResultsInfo;
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
