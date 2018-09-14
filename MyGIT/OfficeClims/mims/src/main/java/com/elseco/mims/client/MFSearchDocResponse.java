package com.elseco.mims.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class MFSearchDocResponse {

	private List<Item> items;

	private String moreResults;

	@JsonProperty("Items")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@JsonProperty("MoreResults")
	public String getMoreResults() {
		return moreResults;
	}

	public void setMoreResults(String moreResults) {
		this.moreResults = moreResults;
	}

	@Override
	public String toString() {
		return "ClassPojo [Items = " + items + ", MoreResults = " + moreResults + "]";
	}
}