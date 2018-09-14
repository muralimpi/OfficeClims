package com.elseco.nyms.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; 

@Service
public class NymsRestClient {
	
		
	private static String endpoint="http://192.168.14.35:8081/mims/uploadWithMeta";
		
	public static String uploadMfile() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		System.out.println("endpoint : " + endpoint);
		final ResponseEntity<String> result = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);

		final String response = result.getBody();
		// System.out.println("---------" +response);
		return response;
	}
}