package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.dto.Response;
import com.example.demo.service.RestTemplateService;

@RestController
@RequestMapping("/api")
public class RestTemplateController {

	@Autowired
	RestTemplateService rs;

	
	@PostMapping("/save") 
	public Response createData(@RequestBody BookRequest request) { 
		System.out.println("tes"); 
		return rs.saveBookData(request); 
	}
	 
    @GetMapping("getAll")
    public BookResponse [] getAllData() {
    	return rs.getAllBookData();
    }

}
