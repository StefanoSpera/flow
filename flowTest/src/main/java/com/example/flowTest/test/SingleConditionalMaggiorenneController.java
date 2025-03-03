package com.example.flowTest.test;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.flowTest.utils.Eta;
import com.example.flowTest.utils.Utils;

import flow.tools.BlockController;
import flow.tools.Request;
import flow.tools.Response;
import flow.tools.SingleCondition;
import flow.tools.SingleConditionalBlockController;

@Component("singleConditionalMaggiorenneController")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SingleConditionalMaggiorenneController extends SingleConditionalBlockController {	

	
	@Autowired
	EndControllerE endControllerE;
	
	@Autowired
	MaggiorenneController maggiorenneController;
	
	@Autowired
	MinorenneController minorenneController;
	
	@Autowired
	public SingleConditionalMaggiorenneController(TestSpringResolver resolver) {		
		super(resolver);
	}

	@Override
	public BlockController setDefaultReturn(Request request, Response response) {
		return endControllerE;
	}	

	@Override
	public SingleConditionList addConditions(Response response) {
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo passo condizionale singolo SingleConditionalMaggiorenneController, ");	
		
		SingleConditionList list = new SingleConditionList(); 
		
		/**
		 * 1 - condizione della variabile (si potrebbe mettere la stringa prefissata di ritorno)
		 * 2 - invocazione controller o conditionReturn in caso metch variabile-condizione 
		 * 		
		 */
								
		list.add(new SingleCondition(
				Eta.MAGGIORENNE, maggiorenneController));
		
		list.add(new SingleCondition(
				Eta.MINORENNE, minorenneController));

		
		return list;
		
	}

	@Override
	public Object getResolveArg(Request request) {
		RequestHandler requestHandler = (RequestHandler) request;
		GregorianCalendar calendar = new GregorianCalendar();
	    calendar.setTime(requestHandler.getRequest().getData());
		return Utils.checkEta(calendar);
	}
	
}
