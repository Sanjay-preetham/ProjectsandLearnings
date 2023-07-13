package com.example.app.WebServiceCall;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WebService {
	
	RestTemplate restTemplate;
	HttpHeaders headers;
	public ResponseEntity<String> serviceCall(String details)
	{
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(details, headers);
        ResponseEntity<String> response = restTemplate.exchange("http://127.0.0.1:5001/registers", HttpMethod.POST, entity, String.class);
        return response;
		
	}
	public ResponseEntity<String> loginServicecall(String loginDetails)
	{
		 restTemplate = new RestTemplate();
	     headers = new HttpHeaders();
	     headers.setContentType(MediaType.APPLICATION_JSON);
	     HttpEntity<String> entity = new HttpEntity<>(loginDetails, headers);
	     ResponseEntity<String> response = restTemplate.exchange("http://127.0.0.1:5001/login", HttpMethod.POST, entity, String.class);
	     return response;
	}

}
