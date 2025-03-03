package com.example.flowTest.test.controllerB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.flowTest.test.EndControllerE;

import flow.tools.BlockController;
import flow.tools.ConditionReturnIF;

@Component("EConditionReturn")
public class EConditionReturn implements ConditionReturnIF {
	
	
	@Autowired
	private EndControllerE endControllerE;
	
	public EConditionReturn() {}
			
	public BlockController resolve(){
		return endControllerE;
	}
			
}
