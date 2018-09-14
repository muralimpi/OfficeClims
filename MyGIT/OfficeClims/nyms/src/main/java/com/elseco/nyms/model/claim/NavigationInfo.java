
package com.elseco.nyms.model.claim;

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
    "applicationHandle",
    "moduleHandle",
    "screenHandle",
    "serverEnvOrIP"
})
public class NavigationInfo {

    @JsonProperty("applicationHandle")
    private String applicationHandle;
    @JsonProperty("moduleHandle")
    private String moduleHandle;
    @JsonProperty("screenHandle")
    private String screenHandle;
    @JsonProperty("serverEnvOrIP")
    private String serverEnvOrIP;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("applicationHandle")
    public String getApplicationHandle() {
        return applicationHandle;
    }

    @JsonProperty("applicationHandle")
    public void setApplicationHandle(String applicationHandle) {
        this.applicationHandle = applicationHandle;
    }

    public NavigationInfo withApplicationHandle(String applicationHandle) {
        this.applicationHandle = applicationHandle;
        return this;
    }

    @JsonProperty("moduleHandle")
    public String getModuleHandle() {
        return moduleHandle;
    }

    @JsonProperty("moduleHandle")
    public void setModuleHandle(String moduleHandle) {
        this.moduleHandle = moduleHandle;
    }

    public NavigationInfo withModuleHandle(String moduleHandle) {
        this.moduleHandle = moduleHandle;
        return this;
    }

    @JsonProperty("screenHandle")
    public String getScreenHandle() {
        return screenHandle;
    }

    @JsonProperty("screenHandle")
    public void setScreenHandle(String screenHandle) {
        this.screenHandle = screenHandle;
    }

    public NavigationInfo withScreenHandle(String screenHandle) {
        this.screenHandle = screenHandle;
        return this;
    }

    @JsonProperty("serverEnvOrIP")
    public String getServerEnvOrIP() {
        return serverEnvOrIP;
    }

    @JsonProperty("serverEnvOrIP")
    public void setServerEnvOrIP(String serverEnvOrIP) {
        this.serverEnvOrIP = serverEnvOrIP;
    }

    public NavigationInfo withServerEnvOrIP(String serverEnvOrIP) {
        this.serverEnvOrIP = serverEnvOrIP;
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
