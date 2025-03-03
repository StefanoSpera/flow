package com.example.flowTest.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import flow.tools.BaseBlockController;
import flow.tools.Request;
import flow.tools.Response;

@Component("controllerD")
public class ControllerD extends BaseBlockController<EndControllerE> {
	
	@Autowired
	EndControllerE endControllerE;

	@Override
	public EndControllerE execute(Request request, Response response) {
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo PassoD, ");		
		return endControllerE;
	}

}
