
package com.elseco.nyms.model.claim.hybris;

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
    "CLAIM_DETAIL_ID",
    "EXT_REF",
    "LINE_SPLIT_VL",
    "TR_TYP",
    "TR_ID",
    "PMT_TYP",
    "HEADER_DATA_INT"
})
public class HEADERDATAEXT {

    @JsonProperty("CLAIM_DETAIL_ID")
    private BigInteger cLAIMDETAILID;
    @JsonProperty("EXT_REF")
    private String eXTREF;
    @JsonProperty("LINE_SPLIT_VL")
    private String lINESPLITVL;
    @JsonProperty("TR_TYP")
    private String tRTYP;
    @JsonProperty("TR_ID")
    private String tRID;
    @JsonProperty("PMT_TYP")
    private String pMTTYP;
    @JsonProperty("HEADER_DATA_INT")
    private List<HEADERDATAINT> hEADERDATAINT = new ArrayList<HEADERDATAINT>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CLAIM_DETAIL_ID")
    public BigInteger getCLAIMDETAILID() {
        return cLAIMDETAILID;
    }

    @JsonProperty("CLAIM_DETAIL_ID")
    public void setCLAIMDETAILID(BigInteger cLAIMDETAILID) {
        this.cLAIMDETAILID = cLAIMDETAILID;
    }

    public HEADERDATAEXT withCLAIMDETAILID(BigInteger cLAIMDETAILID) {
        this.cLAIMDETAILID = cLAIMDETAILID;
        return this;
    }

    @JsonProperty("EXT_REF")
    public String getEXTREF() {
        return eXTREF;
    }

    @JsonProperty("EXT_REF")
    public void setEXTREF(String eXTREF) {
        this.eXTREF = eXTREF;
    }

    public HEADERDATAEXT withEXTREF(String eXTREF) {
        this.eXTREF = eXTREF;
        return this;
    }

    @JsonProperty("LINE_SPLIT_VL")
    public String getLINESPLITVL() {
        return lINESPLITVL;
    }

    @JsonProperty("LINE_SPLIT_VL")
    public void setLINESPLITVL(String lINESPLITVL) {
        this.lINESPLITVL = lINESPLITVL;
    }

    public HEADERDATAEXT withLINESPLITVL(String lINESPLITVL) {
        this.lINESPLITVL = lINESPLITVL;
        return this;
    }

    @JsonProperty("TR_TYP")
    public String getTRTYP() {
        return tRTYP;
    }

    @JsonProperty("TR_TYP")
    public void setTRTYP(String tRTYP) {
        this.tRTYP = tRTYP;
    }

    public HEADERDATAEXT withTRTYP(String tRTYP) {
        this.tRTYP = tRTYP;
        return this;
    }

    @JsonProperty("TR_ID")
    public String getTRID() {
        return tRID;
    }

    @JsonProperty("TR_ID")
    public void setTRID(String tRID) {
        this.tRID = tRID;
    }

    public HEADERDATAEXT withTRID(String tRID) {
        this.tRID = tRID;
        return this;
    }

    @JsonProperty("PMT_TYP")
    public String getPMTTYP() {
        return pMTTYP;
    }

    @JsonProperty("PMT_TYP")
    public void setPMTTYP(String pMTTYP) {
        this.pMTTYP = pMTTYP;
    }

    public HEADERDATAEXT withPMTTYP(String pMTTYP) {
        this.pMTTYP = pMTTYP;
        return this;
    }

    @JsonProperty("HEADER_DATA_INT")
    public List<HEADERDATAINT> getHEADERDATAINT() {
        return hEADERDATAINT;
    }

    @JsonProperty("HEADER_DATA_INT")
    public void setHEADERDATAINT(List<HEADERDATAINT> hEADERDATAINT) {
        this.hEADERDATAINT = hEADERDATAINT;
    }

    public HEADERDATAEXT withHEADERDATAINT(List<HEADERDATAINT> hEADERDATAINT) {
        this.hEADERDATAINT = hEADERDATAINT;
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
