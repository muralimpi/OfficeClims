
package com.elseco.nyms.model.policies;

import java.util.HashMap;
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
    "SHARE_VL",
    "LINE_SIZE",
    "CURRENCY",
    "TOTAL_PREMIUM",
    "MEMBER_NAME"
})
public class MEMBER {

    @JsonProperty("SHARE_VL")
    private String sHAREVL;
    @JsonProperty("LINE_SIZE")
    private String lINESIZE;
    @JsonProperty("CURRENCY")
    private String cURRENCY;
    @JsonProperty("TOTAL_PREMIUM")
    private String tOTALPREMIUM;
    @JsonProperty("MEMBER_NAME")
    private String mEMBERNAME;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SHARE_VL")
    public String getSHAREVL() {
        return sHAREVL;
    }

    @JsonProperty("SHARE_VL")
    public void setSHAREVL(String sHAREVL) {
        this.sHAREVL = sHAREVL;
    }

    public MEMBER withSHAREVL(String sHAREVL) {
        this.sHAREVL = sHAREVL;
        return this;
    }

    @JsonProperty("LINE_SIZE")
    public String getLINESIZE() {
        return lINESIZE;
    }

    @JsonProperty("LINE_SIZE")
    public void setLINESIZE(String lINESIZE) {
        this.lINESIZE = lINESIZE;
    }

    public MEMBER withLINESIZE(String lINESIZE) {
        this.lINESIZE = lINESIZE;
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

    public MEMBER withCURRENCY(String cURRENCY) {
        this.cURRENCY = cURRENCY;
        return this;
    }

    @JsonProperty("TOTAL_PREMIUM")
    public String getTOTALPREMIUM() {
        return tOTALPREMIUM;
    }

    @JsonProperty("TOTAL_PREMIUM")
    public void setTOTALPREMIUM(String tOTALPREMIUM) {
        this.tOTALPREMIUM = tOTALPREMIUM;
    }

    public MEMBER withTOTALPREMIUM(String tOTALPREMIUM) {
        this.tOTALPREMIUM = tOTALPREMIUM;
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

    public MEMBER withMEMBERNAME(String mEMBERNAME) {
        this.mEMBERNAME = mEMBERNAME;
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
