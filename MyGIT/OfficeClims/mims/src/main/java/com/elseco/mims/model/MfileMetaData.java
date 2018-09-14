package com.elseco.mims.model;

import com.elseco.mims.client.TypedValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MfileMetaData {
	private Integer propertyDef;
	private Integer contentType;
	private TypedValue typedValue;

	@JsonProperty("PropertyDef")
	public Integer getPropertyDef() {
		return propertyDef;
	}

	public void setPropertyDef(Integer propertyDef) {
		this.propertyDef = propertyDef;
	}

	public Integer getContentType() {
		return contentType;
	}

	@JsonProperty("ContentType")
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	@JsonProperty("TypedValue")
	public TypedValue getTypedValue() {
		return typedValue;
	}

	public void setTypedValue(TypedValue typedValue) {
		this.typedValue = typedValue;
	}

}
