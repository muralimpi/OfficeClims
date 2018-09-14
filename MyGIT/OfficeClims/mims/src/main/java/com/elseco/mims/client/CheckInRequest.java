package com.elseco.mims.client;

public class CheckInRequest {
	private int value;

	
	public int isValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CheckInRequest(int value) {
		super();
		this.value = value;
	}

}
