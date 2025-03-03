package com.example.flowTest.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import flow.tools.BaseBlockController;
import flow.tools.Request;
import flow.tools.Response;

@Component("controllerD1")
public class ControllerD1 extends BaseBlockController<ControllerD> {
	@Autowired
	ControllerD controllerD;
	
	@Override
	public ControllerD  execute(Request request, Response response) {
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo PassoD1, ");		
		return controllerD;
	}

}
