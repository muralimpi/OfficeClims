
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
    "claimItemId",
    "claimHeaderId",
    "subClaimId",
    "claimId",
    "version",
    "effectiveDate",
    "chngIndicator",
    "extClaimItemNo",
    "benefitType",
    "itemObjType",
    "covgType",
    "amtEvaluated",
    "currEval",
    "evalAmtPerUnit",
    "evalQuantity",
    "evalQuantUnit",
    "statusItem",
    "descriptionItem",
    "deleteFlag",
    "claimsCheckListInfo"
})
public class ClaimsItemsInfo {

    @JsonProperty("claimItemId")
    private BigInteger claimItemId;
    @JsonProperty("claimHeaderId")
    private BigInteger claimHeaderId;
    @JsonProperty("subClaimId")
    private BigInteger subClaimId;
    @JsonProperty("claimId")
    private BigInteger claimId;
    @JsonProperty("version")
    private String version;
    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("chngIndicator")
    private String chngIndicator;
    @JsonProperty("extClaimItemNo")
    private String extClaimItemNo;
    @JsonProperty("benefitType")
    private String benefitType;
    @JsonProperty("itemObjType")
    private String itemObjType;
    @JsonProperty("covgType")
    private String covgType;
    @JsonProperty("amtEvaluated")
    private BigInteger amtEvaluated;
    @JsonProperty("currEval")
    private String currEval;
    @JsonProperty("evalAmtPerUnit")
    private BigInteger evalAmtPerUnit;
    @JsonProperty("evalQuantity")
    private String evalQuantity;
    @JsonProperty("evalQuantUnit")
    private String evalQuantUnit;
    @JsonProperty("statusItem")
    private String statusItem;
    @JsonProperty("descriptionItem")
    private String descriptionItem;
    @JsonProperty("deleteFlag")
    private String deleteFlag;
    @JsonProperty("claimsCheckListInfo")
    private List<Object> claimsCheckListInfo = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("claimItemId")
    public BigInteger getClaimItemId() {
        return claimItemId;
    }

    @JsonProperty("claimItemId")
    public void setClaimItemId(BigInteger claimItemId) {
        this.claimItemId = claimItemId;
    }

    public ClaimsItemsInfo withClaimItemId(BigInteger claimItemId) {
        this.claimItemId = claimItemId;
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

    public ClaimsItemsInfo withClaimHeaderId(BigInteger claimHeaderId) {
        this.claimHeaderId = claimHeaderId;
        return this;
    }

    @JsonProperty("subClaimId")
    public BigInteger getSubClaimId() {
        return subClaimId;
    }

    @JsonProperty("subClaimId")
    public void setSubClaimId(BigInteger subClaimId) {
        this.subClaimId = subClaimId;
    }

    public ClaimsItemsInfo withSubClaimId(BigInteger subClaimId) {
        this.subClaimId = subClaimId;
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

    public ClaimsItemsInfo withClaimId(BigInteger claimId) {
        this.claimId = claimId;
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

    public ClaimsItemsInfo withVersion(String version) {
        this.version = version;
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

    public ClaimsItemsInfo withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    @JsonProperty("chngIndicator")
    public String getChngIndicator() {
        return chngIndicator;
    }

    @JsonProperty("chngIndicator")
    public void setChngIndicator(String chngIndicator) {
        this.chngIndicator = chngIndicator;
    }

    public ClaimsItemsInfo withChngIndicator(String chngIndicator) {
        this.chngIndicator = chngIndicator;
        return this;
    }

    @JsonProperty("extClaimItemNo")
    public String getExtClaimItemNo() {
        return extClaimItemNo;
    }

    @JsonProperty("extClaimItemNo")
    public void setExtClaimItemNo(String extClaimItemNo) {
        this.extClaimItemNo = extClaimItemNo;
    }

    public ClaimsItemsInfo withExtClaimItemNo(String extClaimItemNo) {
        this.extClaimItemNo = extClaimItemNo;
        return this;
    }

    @JsonProperty("benefitType")
    public String getBenefitType() {
        return benefitType;
    }

    @JsonProperty("benefitType")
    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public ClaimsItemsInfo withBenefitType(String benefitType) {
        this.benefitType = benefitType;
        return this;
    }

    @JsonProperty("itemObjType")
    public String getItemObjType() {
        return itemObjType;
    }

    @JsonProperty("itemObjType")
    public void setItemObjType(String itemObjType) {
        this.itemObjType = itemObjType;
    }

    public ClaimsItemsInfo withItemObjType(String itemObjType) {
        this.itemObjType = itemObjType;
        return this;
    }

    @JsonProperty("covgType")
    public String getCovgType() {
        return covgType;
    }

    @JsonProperty("covgType")
    public void setCovgType(String covgType) {
        this.covgType = covgType;
    }

    public ClaimsItemsInfo withCovgType(String covgType) {
        this.covgType = covgType;
        return this;
    }

    @JsonProperty("amtEvaluated")
    public BigInteger getAmtEvaluated() {
        return amtEvaluated;
    }

    @JsonProperty("amtEvaluated")
    public void setAmtEvaluated(BigInteger amtEvaluated) {
        this.amtEvaluated = amtEvaluated;
    }

    public ClaimsItemsInfo withAmtEvaluated(BigInteger amtEvaluated) {
        this.amtEvaluated = amtEvaluated;
        return this;
    }

    @JsonProperty("currEval")
    public String getCurrEval() {
        return currEval;
    }

    @JsonProperty("currEval")
    public void setCurrEval(String currEval) {
        this.currEval = currEval;
    }

    public ClaimsItemsInfo withCurrEval(String currEval) {
        this.currEval = currEval;
        return this;
    }

    @JsonProperty("evalAmtPerUnit")
    public BigInteger getEvalAmtPerUnit() {
        return evalAmtPerUnit;
    }

    @JsonProperty("evalAmtPerUnit")
    public void setEvalAmtPerUnit(BigInteger evalAmtPerUnit) {
        this.evalAmtPerUnit = evalAmtPerUnit;
    }

    public ClaimsItemsInfo withEvalAmtPerUnit(BigInteger evalAmtPerUnit) {
        this.evalAmtPerUnit = evalAmtPerUnit;
        return this;
    }

    @JsonProperty("evalQuantity")
    public String getEvalQuantity() {
        return evalQuantity;
    }

    @JsonProperty("evalQuantity")
    public void setEvalQuantity(String evalQuantity) {
        this.evalQuantity = evalQuantity;
    }

    public ClaimsItemsInfo withEvalQuantity(String evalQuantity) {
        this.evalQuantity = evalQuantity;
        return this;
    }

    @JsonProperty("evalQuantUnit")
    public String getEvalQuantUnit() {
        return evalQuantUnit;
    }

    @JsonProperty("evalQuantUnit")
    public void setEvalQuantUnit(String evalQuantUnit) {
        this.evalQuantUnit = evalQuantUnit;
    }

    public ClaimsItemsInfo withEvalQuantUnit(String evalQuantUnit) {
        this.evalQuantUnit = evalQuantUnit;
        return this;
    }

    @JsonProperty("statusItem")
    public String getStatusItem() {
        return statusItem;
    }

    @JsonProperty("statusItem")
    public void setStatusItem(String statusItem) {
        this.statusItem = statusItem;
    }

    public ClaimsItemsInfo withStatusItem(String statusItem) {
        this.statusItem = statusItem;
        return this;
    }

    @JsonProperty("descriptionItem")
    public String getDescriptionItem() {
        return descriptionItem;
    }

    @JsonProperty("descriptionItem")
    public void setDescriptionItem(String descriptionItem) {
        this.descriptionItem = descriptionItem;
    }

    public ClaimsItemsInfo withDescriptionItem(String descriptionItem) {
        this.descriptionItem = descriptionItem;
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

    public ClaimsItemsInfo withDeleteFlag(String deleteFlag) {
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

    public ClaimsItemsInfo withClaimsCheckListInfo(List<Object> claimsCheckListInfo) {
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
