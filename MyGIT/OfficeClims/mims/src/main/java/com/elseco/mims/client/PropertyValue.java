package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyValue {
	private TypedValue typedValue;

	private Integer propertyDef;

	@JsonProperty("TypedValue")
	public TypedValue getTypedValue() {
		return typedValue;
	}

	public void setTypedValue(TypedValue TypedValue) {
		this.typedValue = TypedValue;
	}

	@JsonProperty("PropertyDef")
	public Integer getPropertyDef() {
		return propertyDef;
	}

	public void setPropertyDef(Integer PropertyDef) {
		this.propertyDef = PropertyDef;
	}

	@Override
	public String toString() {
		return "ClassPojo [TypedValue = " + typedValue + ", PropertyDef = " + propertyDef + "]";
	}
}
