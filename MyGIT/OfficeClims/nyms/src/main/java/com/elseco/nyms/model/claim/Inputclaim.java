
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
    "auditInfo",
    "userInfo",
    "claimsInfo",
    "navigationInfo",
    "dealInfo",
    "incidentInfo"
})
public class Inputclaim {

    @JsonProperty("auditInfo")
    private AuditInfo auditInfo;
    @JsonProperty("userInfo")
    private UserInfo userInfo;
    @JsonProperty("claimsInfo")
    private ClaimsInfo claimsInfo;
    @JsonProperty("navigationInfo")
    private NavigationInfo navigationInfo;
    @JsonProperty("dealInfo")
    private DealInfo dealInfo;
    @JsonProperty("incidentInfo")
    private IncidentInfo incidentInfo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("auditInfo")
    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    @JsonProperty("auditInfo")
    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Inputclaim withAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
        return this;
    }

    @JsonProperty("userInfo")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @JsonProperty("userInfo")
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Inputclaim withUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    @JsonProperty("claimsInfo")
    public ClaimsInfo getClaimsInfo() {
        return claimsInfo;
    }

    @JsonProperty("claimsInfo")
    public void setClaimsInfo(ClaimsInfo claimsInfo) {
        this.claimsInfo = claimsInfo;
    }

    public Inputclaim withClaimsInfo(ClaimsInfo claimsInfo) {
        this.claimsInfo = claimsInfo;
        return this;
    }

    @JsonProperty("navigationInfo")
    public NavigationInfo getNavigationInfo() {
        return navigationInfo;
    }

    @JsonProperty("navigationInfo")
    public void setNavigationInfo(NavigationInfo navigationInfo) {
        this.navigationInfo = navigationInfo;
    }

    public Inputclaim withNavigationInfo(NavigationInfo navigationInfo) {
        this.navigationInfo = navigationInfo;
        return this;
    }

    @JsonProperty("dealInfo")
    public DealInfo getDealInfo() {
        return dealInfo;
    }

    @JsonProperty("dealInfo")
    public void setDealInfo(DealInfo dealInfo) {
        this.dealInfo = dealInfo;
    }

    public Inputclaim withDealInfo(DealInfo dealInfo) {
        this.dealInfo = dealInfo;
        return this;
    }

    @JsonProperty("incidentInfo")
    public IncidentInfo getIncidentInfo() {
        return incidentInfo;
    }

    @JsonProperty("incidentInfo")
    public void setIncidentInfo(IncidentInfo incidentInfo) {
        this.incidentInfo = incidentInfo;
    }

    public Inputclaim withIncidentInfo(IncidentInfo incidentInfo) {
        this.incidentInfo = incidentInfo;
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
