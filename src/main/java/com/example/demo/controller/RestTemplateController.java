package com.example.demo.controller;


import com.example.demo.dto.BookId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.dto.Response;
import com.example.demo.service.RestTemplateService;

import java.util.List;

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

	@PutMapping("/edit")
	public Response editData(@RequestBody BookRequest request) {
		System.out.println("tes");
		return rs.editBookData(request);
	}

	@DeleteMapping("/deleteById/{id}")
	public Response deleteData(@PathVariable(value="id")Integer id){
		return rs.deleteBookData(id);
	}

	@PostMapping("saveAll")
	public Response saveAll(@RequestBody List<BookRequest> request){
		return rs.saveAllBookData(request);
	}

	@DeleteMapping("/deleteByQueryParam")
	public Response deleteByQueryParam(@RequestParam("bookid") List<Integer> ids){
		return rs.deleteMultipleBookData(ids);
	}

	@DeleteMapping("/deleteMany")
	public Response deleteMany(@RequestBody List<Integer> ids){
		return rs.deleteManyBookData(ids);
	}

	@DeleteMapping("/deleteManyKey")
	public Response deleteManyKey(@RequestBody BookId ids){
		return rs.deleteManyWithKey(ids.getBookid());
	}

}
