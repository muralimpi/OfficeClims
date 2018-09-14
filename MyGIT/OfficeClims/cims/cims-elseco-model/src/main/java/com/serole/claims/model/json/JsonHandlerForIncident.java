package com.serole.claims.model.json;

import org.springframework.stereotype.Component;


/**
 * This Entity supports both the JPA Repository to perform Crud operations
 * And also a regular Spring JDBCTemplate process 
 * 
 */
@Component
public class JsonHandlerForIncident {
	public JsonHandlerForIncident(){  }
	     
	private String eventCategory = "";	
	private String eventType = "";		
	private String eventId = "";		
	private String eventFromDate = "";		
	private String eventToDate = "";	
	private String eventDescription = "";	
	private String eventDateNotif = "";	
	private String lossType = "";	
	private String dateOfLoss = "";	
	private String timeOfLoss = "";	
	private String lossTimeZone = "";	
	private String causeOfLoss = "";
	
	
	/**
	 * @return the eventCategory
	 */
	public String getEventCategory() {
		return eventCategory;
	}
	/**
	 * @param eventCategory the eventCategory to set
	 */
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the eventFromDate
	 */
	public String getEventFromDate() {
		return eventFromDate;
	}
	/**
	 * @param eventFromDate the eventFromDate to set
	 */
	public void setEventFromDate(String eventFromDate) {
		this.eventFromDate = eventFromDate;
	}
	/**
	 * @return the eventToDate
	 */
	public String getEventToDate() {
		return eventToDate;
	}
	/**
	 * @param eventToDate the eventToDate to set
	 */
	public void setEventToDate(String eventToDate) {
		this.eventToDate = eventToDate;
	}
	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}
	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	/**
	 * @return the eventDateNotif
	 */
	public String getEventDateNotif() {
		return eventDateNotif;
	}
	/**
	 * @param eventDateNotif the eventDateNotif to set
	 */
	public void setEventDateNotif(String eventDateNotif) {
		this.eventDateNotif = eventDateNotif;
	}
	/**
	 * @return the lossType
	 */
	public String getLossType() {
		return lossType;
	}
	/**
	 * @param lossType the lossType to set
	 */
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}
	/**
	 * @return the dateOfLoss
	 */
	public String getDateOfLoss() {
		return dateOfLoss;
	}
	/**
	 * @param dateOfLoss the dateOfLoss to set
	 */
	public void setDateOfLoss(String dateOfLoss) {
		this.dateOfLoss = dateOfLoss;
	}
	/**
	 * @return the timeOfLoss
	 */
	public String getTimeOfLoss() {
		return timeOfLoss;
	}
	/**
	 * @param timeOfLoss the timeOfLoss to set
	 */
	public void setTimeOfLoss(String timeOfLoss) {
		this.timeOfLoss = timeOfLoss;
	}
	/**
	 * @return the lossTimeZone
	 */
	public String getLossTimeZone() {
		return lossTimeZone;
	}
	/**
	 * @param lossTimeZone the lossTimeZone to set
	 */
	public void setLossTimeZone(String lossTimeZone) {
		this.lossTimeZone = lossTimeZone;
	}
	/**
	 * @return the causeOfLoss
	 */
	public String getCauseOfLoss() {
		return causeOfLoss;
	}
	/**
	 * @param causeOfLoss the causeOfLoss to set
	 */
	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}	
}
