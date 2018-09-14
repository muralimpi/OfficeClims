
package com.elseco.nyms.model.claim.hybris;

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
    "PAYEE",
    "PAYEE_ACC",
    "PAYEE_VL",
    "PAYEE_AM"
})
public class HEADERDATAPAY {

    @JsonProperty("PAYEE")
    private String pAYEE;
    @JsonProperty("PAYEE_ACC")
    private String pAYEEACC;
    @JsonProperty("PAYEE_VL")
    private String pAYEEVL;
    @JsonProperty("PAYEE_AM")
    private String pAYEEAM;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PAYEE")
    public String getPAYEE() {
        return pAYEE;
    }

    @JsonProperty("PAYEE")
    public void setPAYEE(String pAYEE) {
        this.pAYEE = pAYEE;
    }

    public HEADERDATAPAY withPAYEE(String pAYEE) {
        this.pAYEE = pAYEE;
        return this;
    }

    @JsonProperty("PAYEE_ACC")
    public String getPAYEEACC() {
        return pAYEEACC;
    }

    @JsonProperty("PAYEE_ACC")
    public void setPAYEEACC(String pAYEEACC) {
        this.pAYEEACC = pAYEEACC;
    }

    public HEADERDATAPAY withPAYEEACC(String pAYEEACC) {
        this.pAYEEACC = pAYEEACC;
        return this;
    }

    @JsonProperty("PAYEE_VL")
    public String getPAYEEVL() {
        return pAYEEVL;
    }

    @JsonProperty("PAYEE_VL")
    public void setPAYEEVL(String pAYEEVL) {
        this.pAYEEVL = pAYEEVL;
    }

    public HEADERDATAPAY withPAYEEVL(String pAYEEVL) {
        this.pAYEEVL = pAYEEVL;
        return this;
    }

    @JsonProperty("PAYEE_AM")
    public String getPAYEEAM() {
        return pAYEEAM;
    }

    @JsonProperty("PAYEE_AM")
    public void setPAYEEAM(String pAYEEAM) {
        this.pAYEEAM = pAYEEAM;
    }

    public HEADERDATAPAY withPAYEEAM(String pAYEEAM) {
        this.pAYEEAM = pAYEEAM;
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
