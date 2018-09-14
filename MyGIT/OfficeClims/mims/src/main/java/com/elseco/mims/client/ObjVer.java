package com.elseco.mims.client;

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
public class ObjVer {

	private Integer Type;

	private Integer ID;

	private Integer Version;

	@JsonProperty("Type")
	public Integer getType() {
		return Type;
	}

	public void setType(Integer Type) {
		this.Type = Type;
	}

	@JsonProperty("ID")
	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	@JsonProperty("Version")
	public Integer getVersion() {
		return Version;
	}

	public void setVersion(Integer Version) {
		this.Version = Version;
	}

	@Override
	public String toString() {
		return "ClassPojo [Type = " + Type + ", ID = " + ID + ", Version = " + Version + "]";
	}
}
