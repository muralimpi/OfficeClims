
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
    "CLAIM_HEADER_ID",
    "UCR",
    "UMR",
    "EL_CLAIM_ID",
    "PARTNER_ID",
    "DATE_LOSS",
    "APPOINTED_LOSS_ADJUSTER",
    "DETAILS",
    "HEADER_DATA_MARKET"
})
public class IMHEADERDATA {

    @JsonProperty("CLAIM_HEADER_ID")
    private BigInteger cLAIMHEADERID;
    @JsonProperty("UCR")
    private String uCR;
    @JsonProperty("UMR")
    private String uMR;
    @JsonProperty("EL_CLAIM_ID")
    private String eLCLAIMID;
    @JsonProperty("PARTNER_ID")
    private String pARTNERID;
    @JsonProperty("DATE_LOSS")
    private String dATELOSS;
    @JsonProperty("APPOINTED_LOSS_ADJUSTER")
    private String aPPOINTEDLOSSADJUSTER;
    @JsonProperty("DETAILS")
    private String dETAILS;
    @JsonProperty("HEADER_DATA_MARKET")
    private HEADERDATAMARKET hEADERDATAMARKET;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CLAIM_HEADER_ID")
    public BigInteger getCLAIMHEADERID() {
        return cLAIMHEADERID;
    }

    @JsonProperty("CLAIM_HEADER_ID")
    public void setCLAIMHEADERID(BigInteger cLAIMHEADERID) {
        this.cLAIMHEADERID = cLAIMHEADERID;
    }

    public IMHEADERDATA withCLAIMHEADERID(BigInteger cLAIMHEADERID) {
        this.cLAIMHEADERID = cLAIMHEADERID;
        return this;
    }

    @JsonProperty("UCR")
    public String getUCR() {
        return uCR;
    }

    @JsonProperty("UCR")
    public void setUCR(String uCR) {
        this.uCR = uCR;
    }

    public IMHEADERDATA withUCR(String uCR) {
        this.uCR = uCR;
        return this;
    }

    @JsonProperty("UMR")
    public String getUMR() {
        return uMR;
    }

    @JsonProperty("UMR")
    public void setUMR(String uMR) {
        this.uMR = uMR;
    }

    public IMHEADERDATA withUMR(String uMR) {
        this.uMR = uMR;
        return this;
    }

    @JsonProperty("EL_CLAIM_ID")
    public String getELCLAIMID() {
        return eLCLAIMID;
    }

    @JsonProperty("EL_CLAIM_ID")
    public void setELCLAIMID(String eLCLAIMID) {
        this.eLCLAIMID = eLCLAIMID;
    }

    public IMHEADERDATA withELCLAIMID(String eLCLAIMID) {
        this.eLCLAIMID = eLCLAIMID;
        return this;
    }

    @JsonProperty("PARTNER_ID")
    public String getPARTNERID() {
        return pARTNERID;
    }

    @JsonProperty("PARTNER_ID")
    public void setPARTNERID(String pARTNERID) {
        this.pARTNERID = pARTNERID;
    }

    public IMHEADERDATA withPARTNERID(String pARTNERID) {
        this.pARTNERID = pARTNERID;
        return this;
    }

    @JsonProperty("DATE_LOSS")
    public String getDATELOSS() {
        return dATELOSS;
    }

    @JsonProperty("DATE_LOSS")
    public void setDATELOSS(String dATELOSS) {
        this.dATELOSS = dATELOSS;
    }

    public IMHEADERDATA withDATELOSS(String dATELOSS) {
        this.dATELOSS = dATELOSS;
        return this;
    }

    @JsonProperty("APPOINTED_LOSS_ADJUSTER")
    public String getAPPOINTEDLOSSADJUSTER() {
        return aPPOINTEDLOSSADJUSTER;
    }

    @JsonProperty("APPOINTED_LOSS_ADJUSTER")
    public void setAPPOINTEDLOSSADJUSTER(String aPPOINTEDLOSSADJUSTER) {
        this.aPPOINTEDLOSSADJUSTER = aPPOINTEDLOSSADJUSTER;
    }

    public IMHEADERDATA withAPPOINTEDLOSSADJUSTER(String aPPOINTEDLOSSADJUSTER) {
        this.aPPOINTEDLOSSADJUSTER = aPPOINTEDLOSSADJUSTER;
        return this;
    }

    @JsonProperty("DETAILS")
    public String getDETAILS() {
        return dETAILS;
    }

    @JsonProperty("DETAILS")
    public void setDETAILS(String dETAILS) {
        this.dETAILS = dETAILS;
    }

    public IMHEADERDATA withDETAILS(String dETAILS) {
        this.dETAILS = dETAILS;
        return this;
    }

    @JsonProperty("HEADER_DATA_MARKET")
    public HEADERDATAMARKET getHEADERDATAMARKET() {
        return hEADERDATAMARKET;
    }

    @JsonProperty("HEADER_DATA_MARKET")
    public void setHEADERDATAMARKET(HEADERDATAMARKET hEADERDATAMARKET) {
        this.hEADERDATAMARKET = hEADERDATAMARKET;
    }

    public IMHEADERDATA withHEADERDATAMARKET(HEADERDATAMARKET hEADERDATAMARKET) {
        this.hEADERDATAMARKET = hEADERDATAMARKET;
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
