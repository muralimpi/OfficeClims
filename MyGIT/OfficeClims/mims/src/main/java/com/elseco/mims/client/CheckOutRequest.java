package com.elseco.mims.client;

/**
 * 
 * @author vadivel
 *
 */
public class CheckOutRequest {
	private Integer value;

	public CheckOutRequest(Integer value) {
		super();
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
