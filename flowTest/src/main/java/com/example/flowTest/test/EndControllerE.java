package com.example.flowTest.test;

import org.springframework.stereotype.Component;

import flow.tools.EndBlockController;
import flow.tools.Request;
import flow.tools.Response;

@Component("endControllerE")
public class EndControllerE extends EndBlockController {

	@Override
	public void end(Request request, Response response) {
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo passo finale PassoE");				
	}

	
	
}
