package com.serole.claims.model.json;

import org.springframework.stereotype.Component;

@Component
public class JsonHandlerForAuditTrace {
	public JsonHandlerForAuditTrace(){  }
	
	private String fieldName="";
	private String aliasName="";
	private String oldValue="";
	private String newValue="";
	private String isChanged="";
	
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * @return the oldValue
	 */
	public String getOldValue() {
		return oldValue;
	}
	/**
	 * @param oldValue the oldValue to set
	 */
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	/**
	 * @return the newValue
	 */
	public String getNewValue() {
		return newValue;
	}
	/**
	 * @param newValue the newValue to set
	 */
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}	
	/**
	 * @return the aliasName
	 */
	public String getAliasName() {
		return aliasName;
	}
	/**
	 * @param aliasName the aliasName to set
	 */
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	/**
	 * @return the isChanged
	 */
	public String getIsChanged() {
		return isChanged;
	}
	/**
	 * @param isChanged the isChanged to set
	 */
	public void setIsChanged(String isChanged) {
		this.isChanged = isChanged;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonHandlerForAuditTrace [" + (fieldName != null ? "fieldName=" + fieldName + ", " : "")
				+ (aliasName != null ? "aliasName=" + aliasName + ", " : "")
				+ (oldValue != null ? "oldValue=" + oldValue + ", " : "")
				+ (newValue != null ? "newValue=" + newValue + ", " : "")
				+ (isChanged != null ? "isChanged=" + isChanged : "") + "]";
	}	
}
