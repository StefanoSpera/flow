package com.example.flowTest.test;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("stringRequest")
public class StringRequest {
	
	private String passo;
	
	private Long id;
	
	private Date data;

	public String getPasso() {
		return passo;
	}

	public void setPasso(String passo) {
		this.passo = passo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
