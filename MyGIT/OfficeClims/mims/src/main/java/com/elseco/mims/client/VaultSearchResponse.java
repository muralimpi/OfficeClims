package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class VaultSearchResponse {
	private String name;
	private String guid;
	private String authentication;

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("GUID")
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@JsonProperty("Authentication")
	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "VaultSearchResponse [name=" + name + ", guid=" + guid + ", authentication=" + authentication + "]";
	}

	
	

}