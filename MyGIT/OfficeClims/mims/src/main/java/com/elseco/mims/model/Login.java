package com.elseco.mims.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author vadivel
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {
	private String username;
	private String password;
    private String value;

	public Login() {
		super();
	}
	
	
    @JsonProperty("Value")
	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public Login(final String username, final String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@JsonProperty("Username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("Password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public String getValue() { return value; }
	 * 
	 * public void setValue(String value) { this.value = value; }
	 */

}
