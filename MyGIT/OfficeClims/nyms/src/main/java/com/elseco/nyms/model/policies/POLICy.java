
package com.elseco.nyms.model.policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "RISK",
    "ORIGINAL_ASSRED",
    "UMR",
    "ELSECO_REFERENCE",
    "MEMBERS"
})
public class POLICy {

    @JsonProperty("RISK")
    private String rISK;
    @JsonProperty("ORIGINAL_ASSRED")
    private String oRIGINALASSRED;
    @JsonProperty("UMR")
    private String uMR;
    @JsonProperty("ELSECO_REFERENCE")
    private String eLSECOREFERENCE;
    @JsonProperty("MEMBERS")
    private List<MEMBER> mEMBERS = new ArrayList<MEMBER>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("RISK")
    public String getRISK() {
        return rISK;
    }

    @JsonProperty("RISK")
    public void setRISK(String rISK) {
        this.rISK = rISK;
    }

    public POLICy withRISK(String rISK) {
        this.rISK = rISK;
        return this;
    }

    @JsonProperty("ORIGINAL_ASSRED")
    public String getORIGINALASSRED() {
        return oRIGINALASSRED;
    }

    @JsonProperty("ORIGINAL_ASSRED")
    public void setORIGINALASSRED(String oRIGINALASSRED) {
        this.oRIGINALASSRED = oRIGINALASSRED;
    }

    public POLICy withORIGINALASSRED(String oRIGINALASSRED) {
        this.oRIGINALASSRED = oRIGINALASSRED;
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

    public POLICy withUMR(String uMR) {
        this.uMR = uMR;
        return this;
    }

    @JsonProperty("ELSECO_REFERENCE")
    public String getELSECOREFERENCE() {
        return eLSECOREFERENCE;
    }

    @JsonProperty("ELSECO_REFERENCE")
    public void setELSECOREFERENCE(String eLSECOREFERENCE) {
        this.eLSECOREFERENCE = eLSECOREFERENCE;
    }

    public POLICy withELSECOREFERENCE(String eLSECOREFERENCE) {
        this.eLSECOREFERENCE = eLSECOREFERENCE;
        return this;
    }

    @JsonProperty("MEMBERS")
    public List<MEMBER> getMEMBERS() {
        return mEMBERS;
    }

    @JsonProperty("MEMBERS")
    public void setMEMBERS(List<MEMBER> mEMBERS) {
        this.mEMBERS = mEMBERS;
    }

    public POLICy withMEMBERS(List<MEMBER> mEMBERS) {
        this.mEMBERS = mEMBERS;
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
