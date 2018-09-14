
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
    "eventCategory",
    "eventType",
    "eventId",
    "eventFromDate",
    "eventToDate",
    "eventDescription",
    "eventDateNotif",
    "lossType",
    "dateOfLoss",
    "timeOfLoss",
    "lossTimeZone",
    "causeOfLoss"
})
public class IncidentInfo {

    @JsonProperty("eventCategory")
    private String eventCategory;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("eventId")
    private String eventId;
    @JsonProperty("eventFromDate")
    private String eventFromDate;
    @JsonProperty("eventToDate")
    private String eventToDate;
    @JsonProperty("eventDescription")
    private String eventDescription;
    @JsonProperty("eventDateNotif")
    private String eventDateNotif;
    @JsonProperty("lossType")
    private String lossType;
    @JsonProperty("dateOfLoss")
    private String dateOfLoss;
    @JsonProperty("timeOfLoss")
    private String timeOfLoss;
    @JsonProperty("lossTimeZone")
    private String lossTimeZone;
    @JsonProperty("causeOfLoss")
    private String causeOfLoss;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("eventCategory")
    public String getEventCategory() {
        return eventCategory;
    }

    @JsonProperty("eventCategory")
    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public IncidentInfo withEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
        return this;
    }

    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("eventType")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public IncidentInfo withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    @JsonProperty("eventId")
    public String getEventId() {
        return eventId;
    }

    @JsonProperty("eventId")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public IncidentInfo withEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    @JsonProperty("eventFromDate")
    public String getEventFromDate() {
        return eventFromDate;
    }

    @JsonProperty("eventFromDate")
    public void setEventFromDate(String eventFromDate) {
        this.eventFromDate = eventFromDate;
    }

    public IncidentInfo withEventFromDate(String eventFromDate) {
        this.eventFromDate = eventFromDate;
        return this;
    }

    @JsonProperty("eventToDate")
    public String getEventToDate() {
        return eventToDate;
    }

    @JsonProperty("eventToDate")
    public void setEventToDate(String eventToDate) {
        this.eventToDate = eventToDate;
    }

    public IncidentInfo withEventToDate(String eventToDate) {
        this.eventToDate = eventToDate;
        return this;
    }

    @JsonProperty("eventDescription")
    public String getEventDescription() {
        return eventDescription;
    }

    @JsonProperty("eventDescription")
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public IncidentInfo withEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
        return this;
    }

    @JsonProperty("eventDateNotif")
    public String getEventDateNotif() {
        return eventDateNotif;
    }

    @JsonProperty("eventDateNotif")
    public void setEventDateNotif(String eventDateNotif) {
        this.eventDateNotif = eventDateNotif;
    }

    public IncidentInfo withEventDateNotif(String eventDateNotif) {
        this.eventDateNotif = eventDateNotif;
        return this;
    }

    @JsonProperty("lossType")
    public String getLossType() {
        return lossType;
    }

    @JsonProperty("lossType")
    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public IncidentInfo withLossType(String lossType) {
        this.lossType = lossType;
        return this;
    }

    @JsonProperty("dateOfLoss")
    public String getDateOfLoss() {
        return dateOfLoss;
    }

    @JsonProperty("dateOfLoss")
    public void setDateOfLoss(String dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public IncidentInfo withDateOfLoss(String dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
        return this;
    }

    @JsonProperty("timeOfLoss")
    public String getTimeOfLoss() {
        return timeOfLoss;
    }

    @JsonProperty("timeOfLoss")
    public void setTimeOfLoss(String timeOfLoss) {
        this.timeOfLoss = timeOfLoss;
    }

    public IncidentInfo withTimeOfLoss(String timeOfLoss) {
        this.timeOfLoss = timeOfLoss;
        return this;
    }

    @JsonProperty("lossTimeZone")
    public String getLossTimeZone() {
        return lossTimeZone;
    }

    @JsonProperty("lossTimeZone")
    public void setLossTimeZone(String lossTimeZone) {
        this.lossTimeZone = lossTimeZone;
    }

    public IncidentInfo withLossTimeZone(String lossTimeZone) {
        this.lossTimeZone = lossTimeZone;
        return this;
    }

    @JsonProperty("causeOfLoss")
    public String getCauseOfLoss() {
        return causeOfLoss;
    }

    @JsonProperty("causeOfLoss")
    public void setCauseOfLoss(String causeOfLoss) {
        this.causeOfLoss = causeOfLoss;
    }

    public IncidentInfo withCauseOfLoss(String causeOfLoss) {
        this.causeOfLoss = causeOfLoss;
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
