package com.example.flowTest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import flow.tools.BaseBlockController;
import flow.tools.Request;
import flow.tools.Response;

@Component("controllerC")
public class ControllerC extends BaseBlockController<ControllerD> {
	
	@Autowired
	ControllerD controllerD;

	@Override
	public ControllerD execute(Request request, Response response) {		
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo passo PassoC, ");		
		return controllerD;
	}

}
