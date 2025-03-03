package com.example.flowTest.test.controllerB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.flowTest.test.ControllerD;

import flow.tools.BlockController;
import flow.tools.ConditionReturnIF;

@Component("passoDConditionReturn")
public class PassoDConditionReturn implements ConditionReturnIF {
	
	@Autowired
	private ControllerD controllerD;
	
	public PassoDConditionReturn() {}
		
	public BlockController resolve(){
		return controllerD;	
	}
			
}
