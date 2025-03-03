package com.example.flowTest.test.controllerB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.flowTest.test.ControllerD1;

import flow.tools.BlockController;
import flow.tools.ConditionReturnIF;

@Component("passoD1ConditionReturn")
public class PassoD1ConditionReturn implements ConditionReturnIF {
	
	@Autowired
	private ControllerD1 controllerD1;
	
	public PassoD1ConditionReturn() {}
		
	public BlockController resolve(){
		return controllerD1;	
	}
			
}
