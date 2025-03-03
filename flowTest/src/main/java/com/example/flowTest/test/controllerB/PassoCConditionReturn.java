package com.example.flowTest.test.controllerB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.flowTest.test.ControllerC;

import flow.tools.BlockController;
import flow.tools.ConditionReturnIF;

@Component("passoCConditionReturn")
public class PassoCConditionReturn implements ConditionReturnIF {
	
	
	@Autowired
	private ControllerC controllerC;
	
	public PassoCConditionReturn() {}
			
	public BlockController resolve(){
		return controllerC;
	}
			
}
