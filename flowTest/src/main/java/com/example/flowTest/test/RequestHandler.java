package com.example.flowTest.test;

import com.example.flowTest.utils.Eta;

import flow.tools.Request;

public class RequestHandler implements Request{
	
	private StringRequest request;	
	private Eta eta;
	
	public StringRequest getRequest() {
		return request;
	}
	public void setRequest(StringRequest request) {
		this.request = request;
	}
	public Eta getEta() {
		return eta;
	}
	public void setEta(Eta eta) {
		this.eta = eta;
	}
	
	

}
