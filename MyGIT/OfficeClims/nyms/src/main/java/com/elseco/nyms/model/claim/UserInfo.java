
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
    "firstName",
    "lastName",
    "locale",
    "langCode",
    "country",
    "timeZone",
    "timeZoneOffSet",
    "company",
    "department",
    "email",
    "jobTitle",
    "loginName",
    "dateFormat",
    "timeFormat",
    "dateTimeFormat",
    "roles",
    "groups"
})
public class UserInfo {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("langCode")
    private String langCode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonProperty("timeZoneOffSet")
    private String timeZoneOffSet;
    @JsonProperty("company")
    private String company;
    @JsonProperty("department")
    private String department;
    @JsonProperty("email")
    private String email;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("loginName")
    private String loginName;
    @JsonProperty("dateFormat")
    private String dateFormat;
    @JsonProperty("timeFormat")
    private String timeFormat;
    @JsonProperty("dateTimeFormat")
    private String dateTimeFormat;
    @JsonProperty("roles")
    private Object roles;
    @JsonProperty("groups")
    private Object groups;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserInfo withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserInfo withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    public UserInfo withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    @JsonProperty("langCode")
    public String getLangCode() {
        return langCode;
    }

    @JsonProperty("langCode")
    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public UserInfo withLangCode(String langCode) {
        this.langCode = langCode;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public UserInfo withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public UserInfo withTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    @JsonProperty("timeZoneOffSet")
    public String getTimeZoneOffSet() {
        return timeZoneOffSet;
    }

    @JsonProperty("timeZoneOffSet")
    public void setTimeZoneOffSet(String timeZoneOffSet) {
        this.timeZoneOffSet = timeZoneOffSet;
    }

    public UserInfo withTimeZoneOffSet(String timeZoneOffSet) {
        this.timeZoneOffSet = timeZoneOffSet;
        return this;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    public UserInfo withCompany(String company) {
        this.company = company;
        return this;
    }

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    public UserInfo withDepartment(String department) {
        this.department = department;
        return this;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public UserInfo withEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public UserInfo withJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    @JsonProperty("loginName")
    public String getLoginName() {
        return loginName;
    }

    @JsonProperty("loginName")
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public UserInfo withLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    @JsonProperty("dateFormat")
    public String getDateFormat() {
        return dateFormat;
    }

    @JsonProperty("dateFormat")
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public UserInfo withDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    @JsonProperty("timeFormat")
    public String getTimeFormat() {
        return timeFormat;
    }

    @JsonProperty("timeFormat")
    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public UserInfo withTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
        return this;
    }

    @JsonProperty("dateTimeFormat")
    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    @JsonProperty("dateTimeFormat")
    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    public UserInfo withDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
        return this;
    }

    @JsonProperty("roles")
    public Object getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(Object roles) {
        this.roles = roles;
    }

    public UserInfo withRoles(Object roles) {
        this.roles = roles;
        return this;
    }

    @JsonProperty("groups")
    public Object getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(Object groups) {
        this.groups = groups;
    }

    public UserInfo withGroups(Object groups) {
        this.groups = groups;
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
