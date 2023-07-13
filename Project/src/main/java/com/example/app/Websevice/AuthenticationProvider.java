package com.example.app.Websevice;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthenticationProvider {

    public String makeWebServiceCall() throws IOException {
       
       RestTemplate restTemplate = new RestTemplate();
       String url = "http://127.0.0.1:5001/register";
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

       HttpEntity<String> requestEntity = new HttpEntity<>(headers);
       ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
       if(responseEntity.getStatusCode().is2xxSuccessful()) {
           String responseBody = responseEntity.getBody();
           return responseBody;
       } else {
           System.out.println("Error: " + responseEntity.getStatusCode());
           return null;
       }
       

    	
    }



}
