
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
    "POLICIES"
})
public class InputPolicies {

    @JsonProperty("POLICIES")
    private List<POLICy> pOLICIES = new ArrayList<POLICy>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("POLICIES")
    public List<POLICy> getPOLICIES() {
        return pOLICIES;
    }

    @JsonProperty("POLICIES")
    public void setPOLICIES(List<POLICy> pOLICIES) {
        this.pOLICIES = pOLICIES;
    }

    public InputPolicies withPOLICIES(List<POLICy> pOLICIES) {
        this.pOLICIES = pOLICIES;
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
