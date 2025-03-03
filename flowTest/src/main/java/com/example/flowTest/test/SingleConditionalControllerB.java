package com.example.flowTest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.flowTest.test.controllerB.Id2ConditionReturn;
import com.example.flowTest.test.controllerB.PassoD1ConditionReturn;

import flow.tools.BlockController;
import flow.tools.Request;
import flow.tools.Response;
import flow.tools.SingleCondition;
import flow.tools.SingleConditionalBlockController;

@Component("singleConditionalControllerB")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SingleConditionalControllerB extends SingleConditionalBlockController {	
	
	
	@Autowired
	Id2ConditionReturn id2ConditionReturn;
	
	@Autowired
	PassoD1ConditionReturn passoD1ConditionReturn;
	
	@Autowired
	ControllerD1 controllerD1;
	
	@Autowired
	ConditionalControllerId1 conditionalControllerId1;	
	
	@Autowired
	public SingleConditionalControllerB(TestSpringResolver resolver) {		
		super(resolver);
	}

	@Override
	public BlockController setDefaultReturn(Request request, Response response) {
		return conditionalControllerId1;
	}	

	@Override
	public SingleConditionList addConditions(Response response) {		
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo passo condizionale singolo PassoB, ");	
		
		SingleConditionList list = new SingleConditionList(); 
		
		/**
		 * 1 - condizione della variabile (si potrebbe mettere la stringa prefissata di ritorno)
		 * 2 - invocazione controller o conditionReturn in caso metch variabile-condizione 
		 * 		
		 */
		
		list.add(new SingleCondition("PassoC", id2ConditionReturn));		
		list.add(new SingleCondition("PassoD", passoD1ConditionReturn));										
		list.add(new SingleCondition("PassoD1", controllerD1));				
		
		return list;
		
	}

	@Override
	public Object getResolveArg(Request request) {
		RequestHandler requestHandler = (RequestHandler) request;
		return requestHandler.getRequest().getPasso();
	}
	
}
