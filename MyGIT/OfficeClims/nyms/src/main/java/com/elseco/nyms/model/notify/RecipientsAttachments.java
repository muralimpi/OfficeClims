/**
 * 
 */
package com.elseco.nyms.model.notify;

import java.util.Arrays;

import org.springframework.core.io.FileSystemResource;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
public class RecipientsAttachments {

	private String[] recipients; 
	private String emailSubject; 
	private String emailBody; 
	private FileSystemResource attachments;

	public RecipientsAttachments() {
		// TODO Auto-generated constructor stub
	}

	public RecipientsAttachments(String[] recipients, String emailSubject, String emailBody,
			FileSystemResource attachments) {
		super();
		this.recipients = recipients;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
		this.attachments = attachments;
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
	 * @return the emailSubject
	 */
	public String getEmailSubject() {
		return emailSubject;
	}

	/**
	 * @param emailSubject the emailSubject to set
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	/**
	 * @return the emailBody
	 */
	public String getEmailBody() {
		return emailBody;
	}

	/**
	 * @param emailBody the emailBody to set
	 */
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	/**
	 * @return the attachments
	 */
	public FileSystemResource getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(FileSystemResource attachments) {
		this.attachments = attachments;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachments == null) ? 0 : attachments.hashCode());
		result = prime * result + ((emailBody == null) ? 0 : emailBody.hashCode());
		result = prime * result + ((emailSubject == null) ? 0 : emailSubject.hashCode());
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
		RecipientsAttachments other = (RecipientsAttachments) obj;
		if (attachments == null) {
			if (other.attachments != null)
				return false;
		} else if (!attachments.equals(other.attachments))
			return false;
		if (emailBody == null) {
			if (other.emailBody != null)
				return false;
		} else if (!emailBody.equals(other.emailBody))
			return false;
		if (emailSubject == null) {
			if (other.emailSubject != null)
				return false;
		} else if (!emailSubject.equals(other.emailSubject))
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
		return "RecipientsAttachments [recipients=" + Arrays.toString(recipients) + ", emailSubject=" + emailSubject
				+ ", emailBody=" + emailBody + ", attachments=" + attachments + "]";
	}
	

	
}
