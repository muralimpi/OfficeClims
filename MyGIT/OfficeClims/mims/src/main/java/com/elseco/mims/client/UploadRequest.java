package com.elseco.mims.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadRequest {
	private List<File> files;

	private List<PropertyValue> propertyValues;

	@JsonProperty("Files")
	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	@JsonProperty("PropertyValues")
	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}

	@Override
	public String toString() {
		return "ClassPojo [Files = " + files + ", PropertyValues = " + propertyValues + "]";
	}
}
