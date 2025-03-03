package com.example.flowTest.test;

import org.springframework.stereotype.Component;

import flow.tools.Response;

@Component("stringResponse")
public class StringResponse implements Response{
	
	private StringBuffer response;
	
	public StringResponse() {
		this.response = new StringBuffer(); 
		this.response.append("");
	}

	public StringBuffer getResponse() {
		return response;
	}

	public void setResponse(StringBuffer response) {
		this.response = response;
	}
	
	

}
