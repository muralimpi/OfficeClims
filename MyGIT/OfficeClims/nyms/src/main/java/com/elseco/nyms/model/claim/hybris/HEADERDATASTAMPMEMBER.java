
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
    "MEMBER_ID",
    "MEMBER_NAME",
    "MEMBER_SPLIT",
    "MEMBER_EMAIL",
    "COLL_TYPE"
})
public class HEADERDATASTAMPMEMBER {

    @JsonProperty("MEMBER_ID")
    private BigInteger mEMBERID;
    @JsonProperty("MEMBER_NAME")
    private String mEMBERNAME;
    @JsonProperty("MEMBER_SPLIT")
    private String mEMBERSPLIT;
    @JsonProperty("MEMBER_EMAIL")
    private String mEMBEREMAIL;
    @JsonProperty("COLL_TYPE")
    private String cOLLTYPE;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("MEMBER_ID")
    public BigInteger getMEMBERID() {
        return mEMBERID;
    }

    @JsonProperty("MEMBER_ID")
    public void setMEMBERID(BigInteger mEMBERID) {
        this.mEMBERID = mEMBERID;
    }

    public HEADERDATASTAMPMEMBER withMEMBERID(BigInteger mEMBERID) {
        this.mEMBERID = mEMBERID;
        return this;
    }

    @JsonProperty("MEMBER_NAME")
    public String getMEMBERNAME() {
        return mEMBERNAME;
    }

    @JsonProperty("MEMBER_NAME")
    public void setMEMBERNAME(String mEMBERNAME) {
        this.mEMBERNAME = mEMBERNAME;
    }

    public HEADERDATASTAMPMEMBER withMEMBERNAME(String mEMBERNAME) {
        this.mEMBERNAME = mEMBERNAME;
        return this;
    }

    @JsonProperty("MEMBER_SPLIT")
    public String getMEMBERSPLIT() {
        return mEMBERSPLIT;
    }

    @JsonProperty("MEMBER_SPLIT")
    public void setMEMBERSPLIT(String mEMBERSPLIT) {
        this.mEMBERSPLIT = mEMBERSPLIT;
    }

    public HEADERDATASTAMPMEMBER withMEMBERSPLIT(String mEMBERSPLIT) {
        this.mEMBERSPLIT = mEMBERSPLIT;
        return this;
    }

    @JsonProperty("MEMBER_EMAIL")
    public String getMEMBEREMAIL() {
        return mEMBEREMAIL;
    }

    @JsonProperty("MEMBER_EMAIL")
    public void setMEMBEREMAIL(String mEMBEREMAIL) {
        this.mEMBEREMAIL = mEMBEREMAIL;
    }

    public HEADERDATASTAMPMEMBER withMEMBEREMAIL(String mEMBEREMAIL) {
        this.mEMBEREMAIL = mEMBEREMAIL;
        return this;
    }

    @JsonProperty("COLL_TYPE")
    public String getCOLLTYPE() {
        return cOLLTYPE;
    }

    @JsonProperty("COLL_TYPE")
    public void setCOLLTYPE(String cOLLTYPE) {
        this.cOLLTYPE = cOLLTYPE;
    }

    public HEADERDATASTAMPMEMBER withCOLLTYPE(String cOLLTYPE) {
        this.cOLLTYPE = cOLLTYPE;
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
