package com.example.flowTest.test.controllerB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.flowTest.test.ConditionalControllerId2;

import flow.tools.BlockController;
import flow.tools.ConditionReturnIF;

@Component("id2ConditionReturn")
public class Id2ConditionReturn implements ConditionReturnIF {
	
	
	@Autowired
	private ConditionalControllerId2 conditionalControllerId2;
	
	public Id2ConditionReturn() {}
			
	public BlockController resolve(){
		return conditionalControllerId2;
	}
			
}
