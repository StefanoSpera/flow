package com.example.flowTest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import flow.tools.BlockController;
import flow.tools.Condition;
import flow.tools.ConditionalBlockController;
import flow.tools.Request;
import flow.tools.Response;

@Component("conditionalControllerId1")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConditionalControllerId1 extends ConditionalBlockController {	
		
	@Autowired
	SingleConditionalMaggiorenneController singleConditionalMaggiorenneController;
	
	@Autowired
	EndControllerE endControllerE;	

	@Override
	public BlockController setDefaultReturn(Request reques, Response response) {		
		return endControllerE;
	}

	@Override
	public ConditionList addConditions(Request request, Response response) {
		RequestHandler requestHandler = (RequestHandler) request;
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo passo condizionale conditionalControllerId1, ");
		
		ConditionList list = new ConditionList(); 				
		list.add(new Condition(requestHandler.getRequest().getId(),1L, singleConditionalMaggiorenneController));						
		
		return list;
	}
	
}
