
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
    "riskObjId",
    "riskObjName",
    "riskObjDesc",
    "riskObjRegNo",
    "riskObjStDt",
    "riskObjEdDt",
    "riskSumInsured",
    "claimHeaderId",
    "ucrNo",
    "claimDetailId",
    "externalRefNo",
    "createdDt",
    "createdBy",
    "modifiedDate",
    "modifiedBy",
    "deleteFlag"
})
public class ClaimRiskInfo {

    @JsonProperty("riskObjId")
    private BigInteger riskObjId;
    @JsonProperty("riskObjName")
    private String riskObjName;
    @JsonProperty("riskObjDesc")
    private String riskObjDesc;
    @JsonProperty("riskObjRegNo")
    private String riskObjRegNo;
    @JsonProperty("riskObjStDt")
    private String riskObjStDt;
    @JsonProperty("riskObjEdDt")
    private String riskObjEdDt;
    @JsonProperty("riskSumInsured")
    private BigInteger riskSumInsured;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("ucrNo")
    private String ucrNo;
    @JsonProperty("claimDetailId")
    private BigInteger claimDetailId;
    @JsonProperty("externalRefNo")
    private String externalRefNo;
    @JsonProperty("createdDt")
    private Object createdDt;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("modifiedDate")
    private Object modifiedDate;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("riskObjId")
    public BigInteger getRiskObjId() {
        return riskObjId;
    }

    @JsonProperty("riskObjId")
    public void setRiskObjId(BigInteger riskObjId) {
        this.riskObjId = riskObjId;
    }

    public ClaimRiskInfo withRiskObjId(BigInteger riskObjId) {
        this.riskObjId = riskObjId;
        return this;
    }

    @JsonProperty("riskObjName")
    public String getRiskObjName() {
        return riskObjName;
    }

    @JsonProperty("riskObjName")
    public void setRiskObjName(String riskObjName) {
        this.riskObjName = riskObjName;
    }

    public ClaimRiskInfo withRiskObjName(String riskObjName) {
        this.riskObjName = riskObjName;
        return this;
    }

    @JsonProperty("riskObjDesc")
    public String getRiskObjDesc() {
        return riskObjDesc;
    }

    @JsonProperty("riskObjDesc")
    public void setRiskObjDesc(String riskObjDesc) {
        this.riskObjDesc = riskObjDesc;
    }

    public ClaimRiskInfo withRiskObjDesc(String riskObjDesc) {
        this.riskObjDesc = riskObjDesc;
        return this;
    }

    @JsonProperty("riskObjRegNo")
    public String getRiskObjRegNo() {
        return riskObjRegNo;
    }

    @JsonProperty("riskObjRegNo")
    public void setRiskObjRegNo(String riskObjRegNo) {
        this.riskObjRegNo = riskObjRegNo;
    }

    public ClaimRiskInfo withRiskObjRegNo(String riskObjRegNo) {
        this.riskObjRegNo = riskObjRegNo;
        return this;
    }

    @JsonProperty("riskObjStDt")
    public String getRiskObjStDt() {
        return riskObjStDt;
    }

    @JsonProperty("riskObjStDt")
    public void setRiskObjStDt(String riskObjStDt) {
        this.riskObjStDt = riskObjStDt;
    }

    public ClaimRiskInfo withRiskObjStDt(String riskObjStDt) {
        this.riskObjStDt = riskObjStDt;
        return this;
    }

    @JsonProperty("riskObjEdDt")
    public String getRiskObjEdDt() {
        return riskObjEdDt;
    }

    @JsonProperty("riskObjEdDt")
    public void setRiskObjEdDt(String riskObjEdDt) {
        this.riskObjEdDt = riskObjEdDt;
    }

    public ClaimRiskInfo withRiskObjEdDt(String riskObjEdDt) {
        this.riskObjEdDt = riskObjEdDt;
        return this;
    }

    @JsonProperty("riskSumInsured")
    public BigInteger getRiskSumInsured() {
        return riskSumInsured;
    }

    @JsonProperty("riskSumInsured")
    public void setRiskSumInsured(BigInteger riskSumInsured) {
        this.riskSumInsured = riskSumInsured;
    }

    public ClaimRiskInfo withRiskSumInsured(BigInteger riskSumInsured) {
        this.riskSumInsured = riskSumInsured;
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

    public ClaimRiskInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("ucrNo")
    public String getUcrNo() {
        return ucrNo;
    }

    @JsonProperty("ucrNo")
    public void setUcrNo(String ucrNo) {
        this.ucrNo = ucrNo;
    }

    public ClaimRiskInfo withUcrNo(String ucrNo) {
        this.ucrNo = ucrNo;
        return this;
    }

    @JsonProperty("claimDetailId")
    public BigInteger getClaimDetailId() {
        return claimDetailId;
    }

    @JsonProperty("claimDetailId")
    public void setClaimDetailId(BigInteger claimDetailId) {
        this.claimDetailId = claimDetailId;
    }

    public ClaimRiskInfo withClaimDetailId(BigInteger claimDetailId) {
        this.claimDetailId = claimDetailId;
        return this;
    }

    @JsonProperty("externalRefNo")
    public String getExternalRefNo() {
        return externalRefNo;
    }

    @JsonProperty("externalRefNo")
    public void setExternalRefNo(String externalRefNo) {
        this.externalRefNo = externalRefNo;
    }

    public ClaimRiskInfo withExternalRefNo(String externalRefNo) {
        this.externalRefNo = externalRefNo;
        return this;
    }

    @JsonProperty("createdDt")
    public Object getCreatedDt() {
        return createdDt;
    }

    @JsonProperty("createdDt")
    public void setCreatedDt(Object createdDt) {
        this.createdDt = createdDt;
    }

    public ClaimRiskInfo withCreatedDt(Object createdDt) {
        this.createdDt = createdDt;
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

    public ClaimRiskInfo withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @JsonProperty("modifiedDate")
    public Object getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(Object modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public ClaimRiskInfo withModifiedDate(Object modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    @JsonProperty("modifiedBy")
    public String getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ClaimRiskInfo withModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
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

    public ClaimRiskInfo withDeleteFlag(String deleteFlag) {
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
