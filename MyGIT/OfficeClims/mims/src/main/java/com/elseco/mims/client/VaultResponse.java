package com.elseco.mims.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
public class VaultResponse {
	private String name;
	private String[] guid;
	private String authenticaion;

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("GUID")
	public String[] getGuid() {
		return guid;
	}

	public void setGuid(String[] guid) {
		this.guid = guid;
	}

	@JsonProperty("Authenticaion")
	public String getAuthenticaion() {
		return authenticaion;
	}

	public void setAuthenticaion(String authenticaion) {
		this.authenticaion = authenticaion;
	}

}