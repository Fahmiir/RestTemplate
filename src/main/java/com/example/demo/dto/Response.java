package com.example.demo.dto;

import java.io.Serializable;

public class Response implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rc;
	private String message;
	public String getRc() {
		return rc;
	}
	public void setRc(String rc) {
		this.rc = rc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
