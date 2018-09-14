
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
    "CLAIM_INTREF_ID",
    "INT_REF",
    "SPLIT_VL",
    "DUE_DATE",
    "STAMP_ID",
    "TR_ID",
    "TR_TYP",
    "HEADER_DATA_STAMP_MEMBER"
})
public class HEADERDATAINT {

    @JsonProperty("CLAIM_INTREF_ID")
    private BigInteger cLAIMINTREFID;
    @JsonProperty("INT_REF")
    private String iNTREF;
    @JsonProperty("SPLIT_VL")
    private String sPLITVL;
    @JsonProperty("DUE_DATE")
    private String dUEDATE;
    @JsonProperty("STAMP_ID")
    private BigInteger sTAMPID;
    @JsonProperty("TR_ID")
    private String tRID;
    @JsonProperty("TR_TYP")
    private String tRTYP;
    @JsonProperty("HEADER_DATA_STAMP_MEMBER")
    private List<HEADERDATASTAMPMEMBER> hEADERDATASTAMPMEMBER = new ArrayList<HEADERDATASTAMPMEMBER>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CLAIM_INTREF_ID")
    public BigInteger getCLAIMINTREFID() {
        return cLAIMINTREFID;
    }

    @JsonProperty("CLAIM_INTREF_ID")
    public void setCLAIMINTREFID(BigInteger cLAIMINTREFID) {
        this.cLAIMINTREFID = cLAIMINTREFID;
    }

    public HEADERDATAINT withCLAIMINTREFID(BigInteger cLAIMINTREFID) {
        this.cLAIMINTREFID = cLAIMINTREFID;
        return this;
    }

    @JsonProperty("INT_REF")
    public String getINTREF() {
        return iNTREF;
    }

    @JsonProperty("INT_REF")
    public void setINTREF(String iNTREF) {
        this.iNTREF = iNTREF;
    }

    public HEADERDATAINT withINTREF(String iNTREF) {
        this.iNTREF = iNTREF;
        return this;
    }

    @JsonProperty("SPLIT_VL")
    public String getSPLITVL() {
        return sPLITVL;
    }

    @JsonProperty("SPLIT_VL")
    public void setSPLITVL(String sPLITVL) {
        this.sPLITVL = sPLITVL;
    }

    public HEADERDATAINT withSPLITVL(String sPLITVL) {
        this.sPLITVL = sPLITVL;
        return this;
    }

    @JsonProperty("DUE_DATE")
    public String getDUEDATE() {
        return dUEDATE;
    }

    @JsonProperty("DUE_DATE")
    public void setDUEDATE(String dUEDATE) {
        this.dUEDATE = dUEDATE;
    }

    public HEADERDATAINT withDUEDATE(String dUEDATE) {
        this.dUEDATE = dUEDATE;
        return this;
    }

    @JsonProperty("STAMP_ID")
    public BigInteger getSTAMPID() {
        return sTAMPID;
    }

    @JsonProperty("STAMP_ID")
    public void setSTAMPID(BigInteger sTAMPID) {
        this.sTAMPID = sTAMPID;
    }

    public HEADERDATAINT withSTAMPID(BigInteger sTAMPID) {
        this.sTAMPID = sTAMPID;
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

    public HEADERDATAINT withTRID(String tRID) {
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

    public HEADERDATAINT withTRTYP(String tRTYP) {
        this.tRTYP = tRTYP;
        return this;
    }

    @JsonProperty("HEADER_DATA_STAMP_MEMBER")
    public List<HEADERDATASTAMPMEMBER> getHEADERDATASTAMPMEMBER() {
        return hEADERDATASTAMPMEMBER;
    }

    @JsonProperty("HEADER_DATA_STAMP_MEMBER")
    public void setHEADERDATASTAMPMEMBER(List<HEADERDATASTAMPMEMBER> hEADERDATASTAMPMEMBER) {
        this.hEADERDATASTAMPMEMBER = hEADERDATASTAMPMEMBER;
    }

    public HEADERDATAINT withHEADERDATASTAMPMEMBER(List<HEADERDATASTAMPMEMBER> hEADERDATASTAMPMEMBER) {
        this.hEADERDATASTAMPMEMBER = hEADERDATASTAMPMEMBER;
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
