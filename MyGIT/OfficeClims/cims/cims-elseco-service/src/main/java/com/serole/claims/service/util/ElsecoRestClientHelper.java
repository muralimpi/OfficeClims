package com.serole.claims.service.util;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class ElsecoRestClientHelper {

	private static RestTemplate restTemplate = new RestTemplate();
	private static final String baseURL = "http://192.168.14.35:8083/wims";

	/**
	 * @param args
	 */
	public JSONObject invokeWimsStartProcessFlow() {

		JSONObject jsonObj = restTemplate.getForObject(baseURL + "/startprocessflow", JSONObject.class);
		System.out.println("Returned JSON from service is : " + jsonObj.toString());		
		return jsonObj;

	}
}
