package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypedValue {
	private Integer dataType;
	private String value;
	private Lookup lookup;
	private Boolean hasValue;
	private String displayValue;
	private String serializedValue;
	private String SortingKey;
	private Boolean hasAutomaticPermission;

	@JsonProperty("DataType")
	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	@JsonProperty("Value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("Lookup")
	public Lookup getLookup() {
		return lookup;
	}

	public void setLookup(Lookup lookup) {
		this.lookup = lookup;
	}

	@JsonProperty("HasValue")
	public Boolean getHasValue() {
		return hasValue;
	}

	public void setHasValue(Boolean hasValue) {
		this.hasValue = hasValue;
	}

	@JsonProperty("DisplayValue")
	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	@JsonProperty("SerializedValue")
	public String getSerializedValue() {
		return serializedValue;
	}

	public void setSerializedValue(String serializedValue) {
		this.serializedValue = serializedValue;
	}

	@JsonProperty("SortingKey")
	public String getSortingKey() {
		return SortingKey;
	}

	public void setSortingKey(String sortingKey) {
		SortingKey = sortingKey;
	}

	@JsonProperty("HasAutomaticPermission")
	public Boolean getHasAutomaticPermission() {
		return hasAutomaticPermission;
	}

	public void setHasAutomaticPermission(Boolean hasAutomaticPermission) {
		this.hasAutomaticPermission = hasAutomaticPermission;
	}

}