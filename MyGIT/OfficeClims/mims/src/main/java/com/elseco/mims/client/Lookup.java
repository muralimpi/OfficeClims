package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lookup {
	private Integer item;

	private Integer version;

	@JsonProperty("Item")
	public Integer getItem() {
		return item;
	}

	public void setItem(Integer Item) {
		this.item = Item;
	}

    @JsonProperty("Version")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer Version) {
		this.version = Version;
	}

	@Override
	public String toString() {
		return "ClassPojo [Item = " + item + ", Version = " + version + "]";
	}
}
