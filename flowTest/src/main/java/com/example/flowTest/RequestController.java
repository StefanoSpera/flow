package com.example.flowTest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flowTest.test.RequestHandler;
import com.example.flowTest.test.StartControllerA;
import com.example.flowTest.test.StringRequest;
import com.example.flowTest.test.StringResponse;

import flow.tools.FlowchartSpringHandler;

@RestController
public class RequestController {
	
	@Autowired
	StartControllerA startControllerA;
	
	@GetMapping("/flowTest")
	public StringResponse flowTest(@RequestParam(value = "passo", defaultValue = "") String passo,
			@RequestParam(value = "id", defaultValue = "0") Long id,
			@RequestParam(value = "data", defaultValue = "01/01/1900") @DateTimeFormat(pattern = "dd/MM/yyyy") Date data) {
		
		StringRequest request = new StringRequest();
		request.setPasso(passo);
		request.setId(id);
		request.setData(data);
		
		RequestHandler requestHandler = new RequestHandler();
		requestHandler.setRequest(request);
		StringResponse response = new StringResponse();
		
		FlowchartSpringHandler flow;
		try {
			flow = new FlowchartSpringHandler(requestHandler,response);
			
			flow.start(startControllerA);
			
			response = (StringResponse) flow.getResponse();
		} catch (Exception e) {
			response.setResponse(new StringBuffer(e.getMessage()));
			
		}																
		
		return response;
	}
}
