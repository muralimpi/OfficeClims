package com.serole.wims;
/*package com.serole.wims.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; 

@Service
public class WimsRestclient {
	
	@Value("${wims.endpoint}")
	private static String endpoint;
	
	private static String endpoint="http://192.168.14.35:8082/nyms/mail/test";
		
	public static String sendMail() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		System.out.println("endpoint : " + endpoint);
		final ResponseEntity<String> result = restTemplate.exchange(endpoint, HttpMethod.GET, entity, String.class);

		final String response = result.getBody();
		// System.out.println("---------" +response);
		return response;
	}
}
*/