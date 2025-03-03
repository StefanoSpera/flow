package com.example.flowTest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.flowTest.test.controllerB.PassoCConditionReturn;
import com.example.flowTest.test.controllerB.PassoDConditionReturn;

import flow.tools.BlockController;
import flow.tools.Condition;
import flow.tools.ConditionalBlockController;
import flow.tools.Request;
import flow.tools.Response;

@Component("conditionalControllerId2")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConditionalControllerId2 extends ConditionalBlockController {	
	
	@Autowired
	PassoCConditionReturn passoCConditionReturn;
	
	@Autowired
	PassoDConditionReturn passoDConditionReturn;
	
	@Autowired
	ControllerD controllerD;	
	
//	@Autowired
//	public ConditionalControllerId2(TestSpringResolver resolver) {		
//		super(resolver);
//	}

	@Override
	public BlockController setDefaultReturn(Request request, Response response) {		
		return controllerD;
	}

	@Override
	public ConditionList addConditions(Request request, Response response) {
		RequestHandler requestHandler = (RequestHandler) request;
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo passo condizionale conditionalControllerId2, ");
		
		ConditionList list = new ConditionList(); 
		
		list.add(new Condition(requestHandler.getRequest().getId(),2L, passoCConditionReturn));
		
		return list;
		
	}
	
}
