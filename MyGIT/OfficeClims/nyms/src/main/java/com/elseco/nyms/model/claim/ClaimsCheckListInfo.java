
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
    "checkListId",
    "checkListName",
    "checkListGroup",
    "claimHeaderId",
    "claimDetailId",
    "claimFileId",
    "claimItemId",
    "ucrNumber",
    "externalRef",
    "level",
    "isChecked",
    "checkedBy",
    "checkedDate",
    "deleteFlag"
})
public class ClaimsCheckListInfo {

    @JsonProperty("checkListId")
    private BigInteger checkListId;
    @JsonProperty("checkListName")
    private String checkListName;
    @JsonProperty("checkListGroup")
    private String checkListGroup;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("claimDetailId")
    private BigInteger claimDetailId;
    @JsonProperty("claimFileId")
    private BigInteger claimFileId;
    @JsonProperty("claimItemId")
    private BigInteger claimItemId;
    @JsonProperty("ucrNumber")
    private String ucrNumber;
    @JsonProperty("externalRef")
    private String externalRef;
    @JsonProperty("level")
    private String level;
    @JsonProperty("isChecked")
    private String isChecked;
    @JsonProperty("checkedBy")
    private String checkedBy;
    @JsonProperty("checkedDate")
    private String checkedDate;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("checkListId")
    public BigInteger getCheckListId() {
        return checkListId;
    }

    @JsonProperty("checkListId")
    public void setCheckListId(BigInteger checkListId) {
        this.checkListId = checkListId;
    }

    public ClaimsCheckListInfo withCheckListId(BigInteger checkListId) {
        this.checkListId = checkListId;
        return this;
    }

    @JsonProperty("checkListName")
    public String getCheckListName() {
        return checkListName;
    }

    @JsonProperty("checkListName")
    public void setCheckListName(String checkListName) {
        this.checkListName = checkListName;
    }

    public ClaimsCheckListInfo withCheckListName(String checkListName) {
        this.checkListName = checkListName;
        return this;
    }

    @JsonProperty("checkListGroup")
    public String getCheckListGroup() {
        return checkListGroup;
    }

    @JsonProperty("checkListGroup")
    public void setCheckListGroup(String checkListGroup) {
        this.checkListGroup = checkListGroup;
    }

    public ClaimsCheckListInfo withCheckListGroup(String checkListGroup) {
        this.checkListGroup = checkListGroup;
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

    public ClaimsCheckListInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
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

    public ClaimsCheckListInfo withClaimDetailId(BigInteger claimDetailId) {
        this.claimDetailId = claimDetailId;
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

    public ClaimsCheckListInfo withClaimFileId(BigInteger claimFileId) {
        this.claimFileId = claimFileId;
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

    public ClaimsCheckListInfo withClaimItemId(BigInteger claimItemId) {
        this.claimItemId = claimItemId;
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

    public ClaimsCheckListInfo withUcrNumber(String ucrNumber) {
        this.ucrNumber = ucrNumber;
        return this;
    }

    @JsonProperty("externalRef")
    public String getExternalRef() {
        return externalRef;
    }

    @JsonProperty("externalRef")
    public void setExternalRef(String externalRef) {
        this.externalRef = externalRef;
    }

    public ClaimsCheckListInfo withExternalRef(String externalRef) {
        this.externalRef = externalRef;
        return this;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    public ClaimsCheckListInfo withLevel(String level) {
        this.level = level;
        return this;
    }

    @JsonProperty("isChecked")
    public String getIsChecked() {
        return isChecked;
    }

    @JsonProperty("isChecked")
    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }

    public ClaimsCheckListInfo withIsChecked(String isChecked) {
        this.isChecked = isChecked;
        return this;
    }

    @JsonProperty("checkedBy")
    public String getCheckedBy() {
        return checkedBy;
    }

    @JsonProperty("checkedBy")
    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
    }

    public ClaimsCheckListInfo withCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
        return this;
    }

    @JsonProperty("checkedDate")
    public String getCheckedDate() {
        return checkedDate;
    }

    @JsonProperty("checkedDate")
    public void setCheckedDate(String checkedDate) {
        this.checkedDate = checkedDate;
    }

    public ClaimsCheckListInfo withCheckedDate(String checkedDate) {
        this.checkedDate = checkedDate;
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

    public ClaimsCheckListInfo withDeleteFlag(String deleteFlag) {
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
