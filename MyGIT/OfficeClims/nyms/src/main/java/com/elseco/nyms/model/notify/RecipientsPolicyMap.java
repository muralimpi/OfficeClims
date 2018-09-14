/**
 * 
 */
package com.elseco.nyms.model.notify;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.elseco.nyms.model.Member;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
public class RecipientsPolicyMap {

	private Member recipients; 
	private Map<String,String> htmlMapElementsForEmailBody; 
	private Map<String,Object> htmlMapElementsForAttachments; 
	private Map<String,String> subjectElements; 
	
	/**
	 * 
	 */
	public RecipientsPolicyMap() {
		// TODO Auto-generated constructor stub
	}

	public RecipientsPolicyMap(Member recipients, Map<String, String> htmlMapElementsForEmailBody,
			Map<String, Object> htmlMapElementsForAttachments, Map<String, String> subjectElements) {
		super();
		this.recipients = recipients;
		this.htmlMapElementsForEmailBody = htmlMapElementsForEmailBody;
		this.htmlMapElementsForAttachments = htmlMapElementsForAttachments;
		this.subjectElements = subjectElements;
	}

	/**
	 * @return the recipients
	 */
	public Member getRecipients() {
		return recipients;
	}

	/**
	 * @param recipients the recipients to set
	 */
	public void setRecipients(Member recipients) {
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
	public Map<String, Object> getHtmlMapElementsForAttachments() {
		return htmlMapElementsForAttachments;
	}

	/**
	 * @param htmlMapElementsForAttachments the htmlMapElementsForAttachments to set
	 */
	public void setHtmlMapElementsForAttachments(Map<String, Object> htmlMapElementsForAttachments) {
		this.htmlMapElementsForAttachments = htmlMapElementsForAttachments;
	}

	/**
	 * @return the subjectElements
	 */
	public Map<String, String> getSubjectElements() {
		return subjectElements;
	}

	/**
	 * @param subjectElements the subjectElements to set
	 */
	public void setSubjectElements(Map<String, String> subjectElements) {
		this.subjectElements = subjectElements;
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
		result = prime * result + ((recipients == null) ? 0 : recipients.hashCode());
		result = prime * result + ((subjectElements == null) ? 0 : subjectElements.hashCode());
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
		RecipientsPolicyMap other = (RecipientsPolicyMap) obj;
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
		if (recipients == null) {
			if (other.recipients != null)
				return false;
		} else if (!recipients.equals(other.recipients))
			return false;
		if (subjectElements == null) {
			if (other.subjectElements != null)
				return false;
		} else if (!subjectElements.equals(other.subjectElements))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecipientsMap [recipients=" + recipients + ", htmlMapElementsForEmailBody="
				+ htmlMapElementsForEmailBody + ", htmlMapElementsForAttachments=" + htmlMapElementsForAttachments
				+ ", subjectElements=" + subjectElements + "]";
	}


	
}
