
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
    "claimReserveId",
    "reserveFlag",
    "reserveAmt",
    "balanceAmt",
    "initialDetails",
    "claimHeaderId",
    "claimDetId",
    "reserveType",
    "poolName",
    "memberName",
    "allocationPercent",
    "priviledgeType",
    "indemnityAmt",
    "feeReserveAmt",
    "deleteFlag"
})
public class ClaimReserveInfo {

    @JsonProperty("claimReserveId")
    private BigInteger claimReserveId;
    @JsonProperty("reserveFlag")
    private String reserveFlag;
    @JsonProperty("reserveAmt")
    private BigInteger reserveAmt;
    @JsonProperty("balanceAmt")
    private Object balanceAmt;
    @JsonProperty("initialDetails")
    private String initialDetails;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("claimDetId")
    private BigInteger claimDetId;
    @JsonProperty("reserveType")
    private String reserveType;
    @JsonProperty("poolName")
    private Object poolName;
    @JsonProperty("memberName")
    private Object memberName;
    @JsonProperty("allocationPercent")
    private Object allocationPercent;
    @JsonProperty("priviledgeType")
    private String priviledgeType;
    @JsonProperty("indemnityAmt")
    private BigInteger indemnityAmt;
    @JsonProperty("feeReserveAmt")
    private BigInteger feeReserveAmt;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("claimReserveId")
    public BigInteger getClaimReserveId() {
        return claimReserveId;
    }

    @JsonProperty("claimReserveId")
    public void setClaimReserveId(BigInteger claimReserveId) {
        this.claimReserveId = claimReserveId;
    }

    public ClaimReserveInfo withClaimReserveId(BigInteger claimReserveId) {
        this.claimReserveId = claimReserveId;
        return this;
    }

    @JsonProperty("reserveFlag")
    public String getReserveFlag() {
        return reserveFlag;
    }

    @JsonProperty("reserveFlag")
    public void setReserveFlag(String reserveFlag) {
        this.reserveFlag = reserveFlag;
    }

    public ClaimReserveInfo withReserveFlag(String reserveFlag) {
        this.reserveFlag = reserveFlag;
        return this;
    }

    @JsonProperty("reserveAmt")
    public BigInteger getReserveAmt() {
        return reserveAmt;
    }

    @JsonProperty("reserveAmt")
    public void setReserveAmt(BigInteger reserveAmt) {
        this.reserveAmt = reserveAmt;
    }

    public ClaimReserveInfo withReserveAmt(BigInteger reserveAmt) {
        this.reserveAmt = reserveAmt;
        return this;
    }

    @JsonProperty("balanceAmt")
    public Object getBalanceAmt() {
        return balanceAmt;
    }

    @JsonProperty("balanceAmt")
    public void setBalanceAmt(Object balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public ClaimReserveInfo withBalanceAmt(Object balanceAmt) {
        this.balanceAmt = balanceAmt;
        return this;
    }

    @JsonProperty("initialDetails")
    public String getInitialDetails() {
        return initialDetails;
    }

    @JsonProperty("initialDetails")
    public void setInitialDetails(String initialDetails) {
        this.initialDetails = initialDetails;
    }

    public ClaimReserveInfo withInitialDetails(String initialDetails) {
        this.initialDetails = initialDetails;
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

    public ClaimReserveInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("claimDetId")
    public BigInteger getClaimDetId() {
        return claimDetId;
    }

    @JsonProperty("claimDetId")
    public void setClaimDetId(BigInteger claimDetId) {
        this.claimDetId = claimDetId;
    }

    public ClaimReserveInfo withClaimDetId(BigInteger claimDetId) {
        this.claimDetId = claimDetId;
        return this;
    }

    @JsonProperty("reserveType")
    public String getReserveType() {
        return reserveType;
    }

    @JsonProperty("reserveType")
    public void setReserveType(String reserveType) {
        this.reserveType = reserveType;
    }

    public ClaimReserveInfo withReserveType(String reserveType) {
        this.reserveType = reserveType;
        return this;
    }

    @JsonProperty("poolName")
    public Object getPoolName() {
        return poolName;
    }

    @JsonProperty("poolName")
    public void setPoolName(Object poolName) {
        this.poolName = poolName;
    }

    public ClaimReserveInfo withPoolName(Object poolName) {
        this.poolName = poolName;
        return this;
    }

    @JsonProperty("memberName")
    public Object getMemberName() {
        return memberName;
    }

    @JsonProperty("memberName")
    public void setMemberName(Object memberName) {
        this.memberName = memberName;
    }

    public ClaimReserveInfo withMemberName(Object memberName) {
        this.memberName = memberName;
        return this;
    }

    @JsonProperty("allocationPercent")
    public Object getAllocationPercent() {
        return allocationPercent;
    }

    @JsonProperty("allocationPercent")
    public void setAllocationPercent(Object allocationPercent) {
        this.allocationPercent = allocationPercent;
    }

    public ClaimReserveInfo withAllocationPercent(Object allocationPercent) {
        this.allocationPercent = allocationPercent;
        return this;
    }

    @JsonProperty("priviledgeType")
    public String getPriviledgeType() {
        return priviledgeType;
    }

    @JsonProperty("priviledgeType")
    public void setPriviledgeType(String priviledgeType) {
        this.priviledgeType = priviledgeType;
    }

    public ClaimReserveInfo withPriviledgeType(String priviledgeType) {
        this.priviledgeType = priviledgeType;
        return this;
    }

    @JsonProperty("indemnityAmt")
    public BigInteger getIndemnityAmt() {
        return indemnityAmt;
    }

    @JsonProperty("indemnityAmt")
    public void setIndemnityAmt(BigInteger indemnityAmt) {
        this.indemnityAmt = indemnityAmt;
    }

    public ClaimReserveInfo withIndemnityAmt(BigInteger indemnityAmt) {
        this.indemnityAmt = indemnityAmt;
        return this;
    }

    @JsonProperty("feeReserveAmt")
    public BigInteger getFeeReserveAmt() {
        return feeReserveAmt;
    }

    @JsonProperty("feeReserveAmt")
    public void setFeeReserveAmt(BigInteger feeReserveAmt) {
        this.feeReserveAmt = feeReserveAmt;
    }

    public ClaimReserveInfo withFeeReserveAmt(BigInteger feeReserveAmt) {
        this.feeReserveAmt = feeReserveAmt;
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

    public ClaimReserveInfo withDeleteFlag(String deleteFlag) {
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
