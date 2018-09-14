
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
    "claimFileId",
    "claimId",
    "claimHeaderId",
    "version",
    "claimFileType",
    "changeIndicator",
    "statusChangeReason",
    "fileStatus",
    "statusChangeBy",
    "statusChangeTime",
    "deleteFlag",
    "claimsCheckListInfo"
})
public class ClaimsFileInfo {

    @JsonProperty("claimFileId")
    private BigInteger claimFileId;
    @JsonProperty("claimId")
    private BigInteger claimId;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("version")
    private String version;
    @JsonProperty("claimFileType")
    private String claimFileType;
    @JsonProperty("changeIndicator")
    private String changeIndicator;
    @JsonProperty("statusChangeReason")
    private String statusChangeReason;
    @JsonProperty("fileStatus")
    private String fileStatus;
    @JsonProperty("statusChangeBy")
    private String statusChangeBy;
    @JsonProperty("statusChangeTime")
    private String statusChangeTime;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    @JsonProperty("claimsCheckListInfo")
    private List<Object> claimsCheckListInfo = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("claimFileId")
    public BigInteger getClaimFileId() {
        return claimFileId;
    }

    @JsonProperty("claimFileId")
    public void setClaimFileId(BigInteger claimFileId) {
        this.claimFileId = claimFileId;
    }

    public ClaimsFileInfo withClaimFileId(BigInteger claimFileId) {
        this.claimFileId = claimFileId;
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

    public ClaimsFileInfo withClaimId(BigInteger claimId) {
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

    public ClaimsFileInfo withClaimHeaderId(BigInteger claimHeaderId) {
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

    public ClaimsFileInfo withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("claimFileType")
    public String getClaimFileType() {
        return claimFileType;
    }

    @JsonProperty("claimFileType")
    public void setClaimFileType(String claimFileType) {
        this.claimFileType = claimFileType;
    }

    public ClaimsFileInfo withClaimFileType(String claimFileType) {
        this.claimFileType = claimFileType;
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

    public ClaimsFileInfo withChangeIndicator(String changeIndicator) {
        this.changeIndicator = changeIndicator;
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

    public ClaimsFileInfo withStatusChangeReason(String statusChangeReason) {
        this.statusChangeReason = statusChangeReason;
        return this;
    }

    @JsonProperty("fileStatus")
    public String getFileStatus() {
        return fileStatus;
    }

    @JsonProperty("fileStatus")
    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public ClaimsFileInfo withFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
        return this;
    }

    @JsonProperty("statusChangeBy")
    public String getStatusChangeBy() {
        return statusChangeBy;
    }

    @JsonProperty("statusChangeBy")
    public void setStatusChangeBy(String statusChangeBy) {
        this.statusChangeBy = statusChangeBy;
    }

    public ClaimsFileInfo withStatusChangeBy(String statusChangeBy) {
        this.statusChangeBy = statusChangeBy;
        return this;
    }

    @JsonProperty("statusChangeTime")
    public String getStatusChangeTime() {
        return statusChangeTime;
    }

    @JsonProperty("statusChangeTime")
    public void setStatusChangeTime(String statusChangeTime) {
        this.statusChangeTime = statusChangeTime;
    }

    public ClaimsFileInfo withStatusChangeTime(String statusChangeTime) {
        this.statusChangeTime = statusChangeTime;
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

    public ClaimsFileInfo withDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @JsonProperty("claimsCheckListInfo")
    public List<Object> getClaimsCheckListInfo() {
        return claimsCheckListInfo;
    }

    @JsonProperty("claimsCheckListInfo")
    public void setClaimsCheckListInfo(List<Object> claimsCheckListInfo) {
        this.claimsCheckListInfo = claimsCheckListInfo;
    }

    public ClaimsFileInfo withClaimsCheckListInfo(List<Object> claimsCheckListInfo) {
        this.claimsCheckListInfo = claimsCheckListInfo;
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
