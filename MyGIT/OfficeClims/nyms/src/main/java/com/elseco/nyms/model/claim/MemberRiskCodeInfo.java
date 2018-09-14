
package com.elseco.nyms.model.claim;

import java.math.BigInteger;
import java.util.HashMap;
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
    "llRiskCodeId",
    "resultId",
    "memberId",
    "intRefId",
    "policyTransactionId",
    "marketTransactionId",
    "claimId",
    "claimHeaderId",
    "elRiskCode",
    "elRiskDescription",
    "lobId",
    "segmentId",
    "deleteFlag"
})
public class MemberRiskCodeInfo {

    @JsonProperty("llRiskCodeId")
    private BigInteger llRiskCodeId;
    @JsonProperty("resultId")
    private BigInteger resultId;
    @JsonProperty("memberId")
    private BigInteger memberId;
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
    @JsonProperty("elRiskCode")
    private String elRiskCode;
    @JsonProperty("elRiskDescription")
    private String elRiskDescription;
    @JsonProperty("lobId")
    private BigInteger lobId;
    @JsonProperty("segmentId")
    private BigInteger segmentId;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("llRiskCodeId")
    public BigInteger getLlRiskCodeId() {
        return llRiskCodeId;
    }

    @JsonProperty("llRiskCodeId")
    public void setLlRiskCodeId(BigInteger llRiskCodeId) {
        this.llRiskCodeId = llRiskCodeId;
    }

    public MemberRiskCodeInfo withLlRiskCodeId(BigInteger llRiskCodeId) {
        this.llRiskCodeId = llRiskCodeId;
        return this;
    }

    @JsonProperty("resultId")
    public BigInteger getResultId() {
        return resultId;
    }

    @JsonProperty("resultId")
    public void setResultId(BigInteger resultId) {
        this.resultId = resultId;
    }

    public MemberRiskCodeInfo withResultId(BigInteger resultId) {
        this.resultId = resultId;
        return this;
    }

    @JsonProperty("memberId")
    public BigInteger getMemberId() {
        return memberId;
    }

    @JsonProperty("memberId")
    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
    }

    public MemberRiskCodeInfo withMemberId(BigInteger memberId) {
        this.memberId = memberId;
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

    public MemberRiskCodeInfo withIntRefId(BigInteger intRefId) {
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

    public MemberRiskCodeInfo withPolicyTransactionId(BigInteger policyTransactionId) {
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

    public MemberRiskCodeInfo withMarketTransactionId(BigInteger marketTransactionId) {
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

    public MemberRiskCodeInfo withClaimId(BigInteger claimId) {
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

    public MemberRiskCodeInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("elRiskCode")
    public String getElRiskCode() {
        return elRiskCode;
    }

    @JsonProperty("elRiskCode")
    public void setElRiskCode(String elRiskCode) {
        this.elRiskCode = elRiskCode;
    }

    public MemberRiskCodeInfo withElRiskCode(String elRiskCode) {
        this.elRiskCode = elRiskCode;
        return this;
    }

    @JsonProperty("elRiskDescription")
    public String getElRiskDescription() {
        return elRiskDescription;
    }

    @JsonProperty("elRiskDescription")
    public void setElRiskDescription(String elRiskDescription) {
        this.elRiskDescription = elRiskDescription;
    }

    public MemberRiskCodeInfo withElRiskDescription(String elRiskDescription) {
        this.elRiskDescription = elRiskDescription;
        return this;
    }

    @JsonProperty("lobId")
    public BigInteger getLobId() {
        return lobId;
    }

    @JsonProperty("lobId")
    public void setLobId(BigInteger lobId) {
        this.lobId = lobId;
    }

    public MemberRiskCodeInfo withLobId(BigInteger lobId) {
        this.lobId = lobId;
        return this;
    }

    @JsonProperty("segmentId")
    public BigInteger getSegmentId() {
        return segmentId;
    }

    @JsonProperty("segmentId")
    public void setSegmentId(BigInteger segmentId) {
        this.segmentId = segmentId;
    }

    public MemberRiskCodeInfo withSegmentId(BigInteger segmentId) {
        this.segmentId = segmentId;
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

    public MemberRiskCodeInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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
