
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
    "claimNotesId",
    "claimNotesVersion",
    "claimHeaderId",
    "claimHeaderVersion",
    "claimDtlId",
    "claimVersion",
    "claimItemId",
    "claimItemVersion",
    "claimFileId",
    "claimFileVersion",
    "claimReserveId",
    "claimReserveVersion",
    "claimTransId",
    "claimTransVersion",
    "notesMessage",
    "notesDesc",
    "createdBy",
    "createdDate",
    "deleteFlag"
})
public class ClaimNotesInfo {

    @JsonProperty("claimNotesId")
    private BigInteger claimNotesId;
    @JsonProperty("claimNotesVersion")
    private String claimNotesVersion;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("claimHeaderVersion")
    private String claimHeaderVersion;
    @JsonProperty("claimDtlId")
    private BigInteger claimDtlId;
    @JsonProperty("claimVersion")
    private String claimVersion;
    @JsonProperty("claimItemId")
    private BigInteger claimItemId;
    @JsonProperty("claimItemVersion")
    private String claimItemVersion;
    @JsonProperty("claimFileId")
    private BigInteger claimFileId;
    @JsonProperty("claimFileVersion")
    private String claimFileVersion;
    @JsonProperty("claimReserveId")
    private BigInteger claimReserveId;
    @JsonProperty("claimReserveVersion")
    private String claimReserveVersion;
    @JsonProperty("claimTransId")
    private BigInteger claimTransId;
    @JsonProperty("claimTransVersion")
    private String claimTransVersion;
    @JsonProperty("notesMessage")
    private String notesMessage;
    @JsonProperty("notesDesc")
    private String notesDesc;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("claimNotesId")
    public BigInteger getClaimNotesId() {
        return claimNotesId;
    }

    @JsonProperty("claimNotesId")
    public void setClaimNotesId(BigInteger claimNotesId) {
        this.claimNotesId = claimNotesId;
    }

    public ClaimNotesInfo withClaimNotesId(BigInteger claimNotesId) {
        this.claimNotesId = claimNotesId;
        return this;
    }

    @JsonProperty("claimNotesVersion")
    public String getClaimNotesVersion() {
        return claimNotesVersion;
    }

    @JsonProperty("claimNotesVersion")
    public void setClaimNotesVersion(String claimNotesVersion) {
        this.claimNotesVersion = claimNotesVersion;
    }

    public ClaimNotesInfo withClaimNotesVersion(String claimNotesVersion) {
        this.claimNotesVersion = claimNotesVersion;
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

    public ClaimNotesInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("claimHeaderVersion")
    public String getClaimHeaderVersion() {
        return claimHeaderVersion;
    }

    @JsonProperty("claimHeaderVersion")
    public void setClaimHeaderVersion(String claimHeaderVersion) {
        this.claimHeaderVersion = claimHeaderVersion;
    }

    public ClaimNotesInfo withClaimHeaderVersion(String claimHeaderVersion) {
        this.claimHeaderVersion = claimHeaderVersion;
        return this;
    }

    @JsonProperty("claimDtlId")
    public BigInteger getClaimDtlId() {
        return claimDtlId;
    }

    @JsonProperty("claimDtlId")
    public void setClaimDtlId(BigInteger claimDtlId) {
        this.claimDtlId = claimDtlId;
    }

    public ClaimNotesInfo withClaimDtlId(BigInteger claimDtlId) {
        this.claimDtlId = claimDtlId;
        return this;
    }

    @JsonProperty("claimVersion")
    public String getClaimVersion() {
        return claimVersion;
    }

    @JsonProperty("claimVersion")
    public void setClaimVersion(String claimVersion) {
        this.claimVersion = claimVersion;
    }

    public ClaimNotesInfo withClaimVersion(String claimVersion) {
        this.claimVersion = claimVersion;
        return this;
    }

    @JsonProperty("claimItemId")
    public BigInteger getClaimItemId() {
        return claimItemId;
    }

    @JsonProperty("claimItemId")
    public void setClaimItemId(BigInteger claimItemId) {
        this.claimItemId = claimItemId;
    }

    public ClaimNotesInfo withClaimItemId(BigInteger claimItemId) {
        this.claimItemId = claimItemId;
        return this;
    }

    @JsonProperty("claimItemVersion")
    public String getClaimItemVersion() {
        return claimItemVersion;
    }

    @JsonProperty("claimItemVersion")
    public void setClaimItemVersion(String claimItemVersion) {
        this.claimItemVersion = claimItemVersion;
    }

    public ClaimNotesInfo withClaimItemVersion(String claimItemVersion) {
        this.claimItemVersion = claimItemVersion;
        return this;
    }

    @JsonProperty("claimFileId")
    public BigInteger getClaimFileId() {
        return claimFileId;
    }

    @JsonProperty("claimFileId")
    public void setClaimFileId(BigInteger claimFileId) {
        this.claimFileId = claimFileId;
    }

    public ClaimNotesInfo withClaimFileId(BigInteger claimFileId) {
        this.claimFileId = claimFileId;
        return this;
    }

    @JsonProperty("claimFileVersion")
    public String getClaimFileVersion() {
        return claimFileVersion;
    }

    @JsonProperty("claimFileVersion")
    public void setClaimFileVersion(String claimFileVersion) {
        this.claimFileVersion = claimFileVersion;
    }

    public ClaimNotesInfo withClaimFileVersion(String claimFileVersion) {
        this.claimFileVersion = claimFileVersion;
        return this;
    }

    @JsonProperty("claimReserveId")
    public BigInteger getClaimReserveId() {
        return claimReserveId;
    }

    @JsonProperty("claimReserveId")
    public void setClaimReserveId(BigInteger claimReserveId) {
        this.claimReserveId = claimReserveId;
    }

    public ClaimNotesInfo withClaimReserveId(BigInteger claimReserveId) {
        this.claimReserveId = claimReserveId;
        return this;
    }

    @JsonProperty("claimReserveVersion")
    public String getClaimReserveVersion() {
        return claimReserveVersion;
    }

    @JsonProperty("claimReserveVersion")
    public void setClaimReserveVersion(String claimReserveVersion) {
        this.claimReserveVersion = claimReserveVersion;
    }

    public ClaimNotesInfo withClaimReserveVersion(String claimReserveVersion) {
        this.claimReserveVersion = claimReserveVersion;
        return this;
    }

    @JsonProperty("claimTransId")
    public BigInteger getClaimTransId() {
        return claimTransId;
    }

    @JsonProperty("claimTransId")
    public void setClaimTransId(BigInteger claimTransId) {
        this.claimTransId = claimTransId;
    }

    public ClaimNotesInfo withClaimTransId(BigInteger claimTransId) {
        this.claimTransId = claimTransId;
        return this;
    }

    @JsonProperty("claimTransVersion")
    public String getClaimTransVersion() {
        return claimTransVersion;
    }

    @JsonProperty("claimTransVersion")
    public void setClaimTransVersion(String claimTransVersion) {
        this.claimTransVersion = claimTransVersion;
    }

    public ClaimNotesInfo withClaimTransVersion(String claimTransVersion) {
        this.claimTransVersion = claimTransVersion;
        return this;
    }

    @JsonProperty("notesMessage")
    public String getNotesMessage() {
        return notesMessage;
    }

    @JsonProperty("notesMessage")
    public void setNotesMessage(String notesMessage) {
        this.notesMessage = notesMessage;
    }

    public ClaimNotesInfo withNotesMessage(String notesMessage) {
        this.notesMessage = notesMessage;
        return this;
    }

    @JsonProperty("notesDesc")
    public String getNotesDesc() {
        return notesDesc;
    }

    @JsonProperty("notesDesc")
    public void setNotesDesc(String notesDesc) {
        this.notesDesc = notesDesc;
    }

    public ClaimNotesInfo withNotesDesc(String notesDesc) {
        this.notesDesc = notesDesc;
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

    public ClaimNotesInfo withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public ClaimNotesInfo withCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    public ClaimNotesInfo withDeleteFlag(String deleteFlag) {
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
