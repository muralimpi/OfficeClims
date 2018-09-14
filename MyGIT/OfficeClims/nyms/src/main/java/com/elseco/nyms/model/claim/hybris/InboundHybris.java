
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
    "IM_HEADER_DATA"
})
public class InboundHybris {

    @JsonProperty("IM_HEADER_DATA")
    private IMHEADERDATA iMHEADERDATA;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("IM_HEADER_DATA")
    public IMHEADERDATA getIMHEADERDATA() {
        return iMHEADERDATA;
    }

    @JsonProperty("IM_HEADER_DATA")
    public void setIMHEADERDATA(IMHEADERDATA iMHEADERDATA) {
        this.iMHEADERDATA = iMHEADERDATA;
    }

    public InboundHybris withIMHEADERDATA(IMHEADERDATA iMHEADERDATA) {
        this.iMHEADERDATA = iMHEADERDATA;
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
