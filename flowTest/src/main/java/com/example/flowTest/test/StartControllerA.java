package com.example.flowTest.test;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.flowTest.utils.Utils;

import flow.tools.BaseBlockController;
import flow.tools.Request;
import flow.tools.Response;


@Component("startControllerA")
public class StartControllerA extends BaseBlockController<ConditionalControllerB>{
		
	@Autowired
	private ConditionalControllerB conditionalsControllerB;

	@Override
	public ConditionalControllerB execute(Request request, Response response) {
		
		RequestHandler requestHandler = (RequestHandler) request;
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("eseguo PassoA, ");
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(requestHandler.getRequest().getData());
		requestHandler.setEta(Utils.checkEta(calendar));
		
		return conditionalsControllerB;
	}
	


}
