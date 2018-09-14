
package com.elseco.nyms.model.claim.hybris;

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
    "CLAIM_TRANSACTION_ID",
    "TR_ID",
    "TR_TYP",
    "SETTLEMENT_AM_INDEM",
    "SETTLEMENT_AM_FEES",
    "SETTLEMENT_AM_EXP",
    "RESERVE_AM_INDEM",
    "RESERVE_AM_FEES",
    "RESERVE_AM_EXP",
    "INCURRED_AM",
    "CURRENCY",
    "PARTICIPATION_ID",
    "POLICY_TYPE",
    "HEADER_DATA_EXT"
})
public class HEADERDATAMARKET {

    @JsonProperty("CLAIM_TRANSACTION_ID")
    private BigInteger cLAIMTRANSACTIONID;
    @JsonProperty("TR_ID")
    private String tRID;
    @JsonProperty("TR_TYP")
    private String tRTYP;
    @JsonProperty("SETTLEMENT_AM_INDEM")
    private String sETTLEMENTAMINDEM;
    @JsonProperty("SETTLEMENT_AM_FEES")
    private String sETTLEMENTAMFEES;
    @JsonProperty("SETTLEMENT_AM_EXP")
    private String sETTLEMENTAMEXP;
    @JsonProperty("RESERVE_AM_INDEM")
    private String rESERVEAMINDEM;
    @JsonProperty("RESERVE_AM_FEES")
    private String rESERVEAMFEES;
    @JsonProperty("RESERVE_AM_EXP")
    private String rESERVEAMEXP;
    @JsonProperty("INCURRED_AM")
    private String iNCURREDAM;
    @JsonProperty("CURRENCY")
    private String cURRENCY;
    @JsonProperty("PARTICIPATION_ID")
    private String pARTICIPATIONID;
    @JsonProperty("POLICY_TYPE")
    private String pOLICYTYPE;
    @JsonProperty("HEADER_DATA_EXT")
    private HEADERDATAEXT hEADERDATAEXT;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CLAIM_TRANSACTION_ID")
    public BigInteger getCLAIMTRANSACTIONID() {
        return cLAIMTRANSACTIONID;
    }

    @JsonProperty("CLAIM_TRANSACTION_ID")
    public void setCLAIMTRANSACTIONID(BigInteger cLAIMTRANSACTIONID) {
        this.cLAIMTRANSACTIONID = cLAIMTRANSACTIONID;
    }

    public HEADERDATAMARKET withCLAIMTRANSACTIONID(BigInteger cLAIMTRANSACTIONID) {
        this.cLAIMTRANSACTIONID = cLAIMTRANSACTIONID;
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

    public HEADERDATAMARKET withTRID(String tRID) {
        this.tRID = tRID;
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

    public HEADERDATAMARKET withTRTYP(String tRTYP) {
        this.tRTYP = tRTYP;
        return this;
    }

    @JsonProperty("SETTLEMENT_AM_INDEM")
    public String getSETTLEMENTAMINDEM() {
        return sETTLEMENTAMINDEM;
    }

    @JsonProperty("SETTLEMENT_AM_INDEM")
    public void setSETTLEMENTAMINDEM(String sETTLEMENTAMINDEM) {
        this.sETTLEMENTAMINDEM = sETTLEMENTAMINDEM;
    }

    public HEADERDATAMARKET withSETTLEMENTAMINDEM(String sETTLEMENTAMINDEM) {
        this.sETTLEMENTAMINDEM = sETTLEMENTAMINDEM;
        return this;
    }

    @JsonProperty("SETTLEMENT_AM_FEES")
    public String getSETTLEMENTAMFEES() {
        return sETTLEMENTAMFEES;
    }

    @JsonProperty("SETTLEMENT_AM_FEES")
    public void setSETTLEMENTAMFEES(String sETTLEMENTAMFEES) {
        this.sETTLEMENTAMFEES = sETTLEMENTAMFEES;
    }

    public HEADERDATAMARKET withSETTLEMENTAMFEES(String sETTLEMENTAMFEES) {
        this.sETTLEMENTAMFEES = sETTLEMENTAMFEES;
        return this;
    }

    @JsonProperty("SETTLEMENT_AM_EXP")
    public String getSETTLEMENTAMEXP() {
        return sETTLEMENTAMEXP;
    }

    @JsonProperty("SETTLEMENT_AM_EXP")
    public void setSETTLEMENTAMEXP(String sETTLEMENTAMEXP) {
        this.sETTLEMENTAMEXP = sETTLEMENTAMEXP;
    }

    public HEADERDATAMARKET withSETTLEMENTAMEXP(String sETTLEMENTAMEXP) {
        this.sETTLEMENTAMEXP = sETTLEMENTAMEXP;
        return this;
    }

    @JsonProperty("RESERVE_AM_INDEM")
    public String getRESERVEAMINDEM() {
        return rESERVEAMINDEM;
    }

    @JsonProperty("RESERVE_AM_INDEM")
    public void setRESERVEAMINDEM(String rESERVEAMINDEM) {
        this.rESERVEAMINDEM = rESERVEAMINDEM;
    }

    public HEADERDATAMARKET withRESERVEAMINDEM(String rESERVEAMINDEM) {
        this.rESERVEAMINDEM = rESERVEAMINDEM;
        return this;
    }

    @JsonProperty("RESERVE_AM_FEES")
    public String getRESERVEAMFEES() {
        return rESERVEAMFEES;
    }

    @JsonProperty("RESERVE_AM_FEES")
    public void setRESERVEAMFEES(String rESERVEAMFEES) {
        this.rESERVEAMFEES = rESERVEAMFEES;
    }

    public HEADERDATAMARKET withRESERVEAMFEES(String rESERVEAMFEES) {
        this.rESERVEAMFEES = rESERVEAMFEES;
        return this;
    }

    @JsonProperty("RESERVE_AM_EXP")
    public String getRESERVEAMEXP() {
        return rESERVEAMEXP;
    }

    @JsonProperty("RESERVE_AM_EXP")
    public void setRESERVEAMEXP(String rESERVEAMEXP) {
        this.rESERVEAMEXP = rESERVEAMEXP;
    }

    public HEADERDATAMARKET withRESERVEAMEXP(String rESERVEAMEXP) {
        this.rESERVEAMEXP = rESERVEAMEXP;
        return this;
    }

    @JsonProperty("INCURRED_AM")
    public String getINCURREDAM() {
        return iNCURREDAM;
    }

    @JsonProperty("INCURRED_AM")
    public void setINCURREDAM(String iNCURREDAM) {
        this.iNCURREDAM = iNCURREDAM;
    }

    public HEADERDATAMARKET withINCURREDAM(String iNCURREDAM) {
        this.iNCURREDAM = iNCURREDAM;
        return this;
    }

    @JsonProperty("CURRENCY")
    public String getCURRENCY() {
        return cURRENCY;
    }

    @JsonProperty("CURRENCY")
    public void setCURRENCY(String cURRENCY) {
        this.cURRENCY = cURRENCY;
    }

    public HEADERDATAMARKET withCURRENCY(String cURRENCY) {
        this.cURRENCY = cURRENCY;
        return this;
    }

    @JsonProperty("PARTICIPATION_ID")
    public String getPARTICIPATIONID() {
        return pARTICIPATIONID;
    }

    @JsonProperty("PARTICIPATION_ID")
    public void setPARTICIPATIONID(String pARTICIPATIONID) {
        this.pARTICIPATIONID = pARTICIPATIONID;
    }

    public HEADERDATAMARKET withPARTICIPATIONID(String pARTICIPATIONID) {
        this.pARTICIPATIONID = pARTICIPATIONID;
        return this;
    }

    @JsonProperty("POLICY_TYPE")
    public String getPOLICYTYPE() {
        return pOLICYTYPE;
    }

    @JsonProperty("POLICY_TYPE")
    public void setPOLICYTYPE(String pOLICYTYPE) {
        this.pOLICYTYPE = pOLICYTYPE;
    }

    public HEADERDATAMARKET withPOLICYTYPE(String pOLICYTYPE) {
        this.pOLICYTYPE = pOLICYTYPE;
        return this;
    }

    @JsonProperty("HEADER_DATA_EXT")
    public HEADERDATAEXT getHEADERDATAEXT() {
        return hEADERDATAEXT;
    }

    @JsonProperty("HEADER_DATA_EXT")
    public void setHEADERDATAEXT(HEADERDATAEXT hEADERDATAEXT) {
        this.hEADERDATAEXT = hEADERDATAEXT;
    }

    public HEADERDATAMARKET withHEADERDATAEXT(HEADERDATAEXT hEADERDATAEXT) {
        this.hEADERDATAEXT = hEADERDATAEXT;
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
