package com.example.demo.service;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.dto.Response;
import com.google.gson.Gson;


@Service 
public class RestTemplateService {
	
    @Autowired 
    private RestTemplate restTempl;
    
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
	
	public Response saveBookData (BookRequest request) {
		
	    Response response = new Response();	
		
		try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
			HttpEntity<BookRequest> entity = new HttpEntity<>(request,headers); 
			
            ResponseEntity<String> responseEntity = restTempl.exchange("http://localhost:8080/Books/api/save", HttpMethod.POST, entity, String.class);
//            String jsonStr = responseEntity.getBody();
//            bookResponse = new Gson().fromJson(jsonStr, BookResponse.class);		
        	response.setRc("000");	
    		response.setMessage("Insert Data Sukses");    
		} catch (HttpStatusCodeException e) {
            String errorpayload = e.getResponseBodyAsString();
            System.out.println("HttpStatusCodeException: "+errorpayload);
            response.setRc("500");
            response.setMessage("Internal Server Error");
		} catch (RestClientException e) {
			System.out.println("RestClientException: "+e.getLocalizedMessage());
		}
		
		
		return response;
		
	}
	
	public BookResponse [] getAllBookData() {
		
		
		BookResponse [] bookResponse = null;
		try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
			HttpEntity<BookRequest> entity = new HttpEntity<>(headers); 
			ResponseEntity<String> responseEntity = restTempl.exchange("http://localhost:8080/Books/api/getAllData", HttpMethod.GET, entity, String.class);
			String jsonStr = responseEntity.getBody();
			bookResponse = new Gson().fromJson(jsonStr, BookResponse[].class);	
			JSONArray jsonResult = new JSONArray(jsonStr);
			String bookName = jsonResult.getJSONObject(0).getString("bookname");
			System.out.println(bookName);
		} catch (HttpStatusCodeException e) {
            String errorpayload = e.getResponseBodyAsString();
            System.out.println("HttpStatusCodeException: "+errorpayload);		
		} catch (RestClientException e) {
			System.out.println("RestClientException: "+e.getLocalizedMessage());
		}
		return bookResponse;
		
	}

}
