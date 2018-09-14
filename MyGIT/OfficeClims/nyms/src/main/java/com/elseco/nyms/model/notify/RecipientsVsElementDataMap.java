/**
 * 
 */
package com.elseco.nyms.model.notify;

import java.util.Arrays;
import java.util.Map;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
public class RecipientsVsElementDataMap {

	private String[] recipients; 
	private Map<String,String> htmlMapElementsForEmailBody; 
	private Map<String,String> htmlMapElementsForAttachments; 
	
	/**
	 * 
	 */
	public RecipientsVsElementDataMap() {
		// TODO Auto-generated constructor stub
	}

	public RecipientsVsElementDataMap(String[] recipients, Map<String, String> htmlMapElementsForEmailBody,
			Map<String, String> htmlMapElementsForAttachments) {
		super();
		this.recipients = recipients;
		this.htmlMapElementsForEmailBody = htmlMapElementsForEmailBody;
		this.htmlMapElementsForAttachments = htmlMapElementsForAttachments;
	}

	/**
	 * @return the recipients
	 */
	public String[] getRecipients() {
		return recipients;
	}

	/**
	 * @param recipients the recipients to set
	 */
	public void setRecipients(String[] recipients) {
		this.recipients = recipients;
	}

	/**
	 * @return the htmlMapElementsForEmailBody
	 */
	public Map<String, String> getHtmlMapElementsForEmailBody() {
		return htmlMapElementsForEmailBody;
	}

	/**
	 * @param htmlMapElementsForEmailBody the htmlMapElementsForEmailBody to set
	 */
	public void setHtmlMapElementsForEmailBody(Map<String, String> htmlMapElementsForEmailBody) {
		this.htmlMapElementsForEmailBody = htmlMapElementsForEmailBody;
	}

	/**
	 * @return the htmlMapElementsForAttachments
	 */
	public Map<String, String> getHtmlMapElementsForAttachments() {
		return htmlMapElementsForAttachments;
	}

	/**
	 * @param htmlMapElementsForAttachments the htmlMapElementsForAttachments to set
	 */
	public void setHtmlMapElementsForAttachments(Map<String, String> htmlMapElementsForAttachments) {
		this.htmlMapElementsForAttachments = htmlMapElementsForAttachments;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((htmlMapElementsForAttachments == null) ? 0 : htmlMapElementsForAttachments.hashCode());
		result = prime * result + ((htmlMapElementsForEmailBody == null) ? 0 : htmlMapElementsForEmailBody.hashCode());
		result = prime * result + Arrays.hashCode(recipients);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipientsVsElementDataMap other = (RecipientsVsElementDataMap) obj;
		if (htmlMapElementsForAttachments == null) {
			if (other.htmlMapElementsForAttachments != null)
				return false;
		} else if (!htmlMapElementsForAttachments.equals(other.htmlMapElementsForAttachments))
			return false;
		if (htmlMapElementsForEmailBody == null) {
			if (other.htmlMapElementsForEmailBody != null)
				return false;
		} else if (!htmlMapElementsForEmailBody.equals(other.htmlMapElementsForEmailBody))
			return false;
		if (!Arrays.equals(recipients, other.recipients))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecipientsVsElementDataMap [recipients=" + Arrays.toString(recipients)
				+ ", htmlMapElementsForEmailBody=" + htmlMapElementsForEmailBody + ", htmlMapElementsForAttachments="
				+ htmlMapElementsForAttachments + "]";
	}

	
}
