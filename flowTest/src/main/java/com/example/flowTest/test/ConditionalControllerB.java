package com.example.flowTest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.flowTest.test.controllerB.EConditionReturn;
import com.example.flowTest.test.controllerB.Id2ConditionReturn;
import com.example.flowTest.test.controllerB.PassoD1ConditionReturn;
import com.example.flowTest.utils.Eta;

import flow.tools.BlockController;
import flow.tools.Condition;
import flow.tools.ConditionalBlockController;
import flow.tools.Request;
import flow.tools.Response;

@Component("conditionalsControllerB")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConditionalControllerB extends ConditionalBlockController {	
	
	
	@Autowired
	Id2ConditionReturn id2ConditionReturn;
	
	@Autowired
	PassoD1ConditionReturn passoD1ConditionReturn;
	
	@Autowired
	ControllerD1 controllerD1;
	
	@Autowired
	ConditionalControllerId1 conditionalControllerId1;	
	
	@Autowired
	EConditionReturn eConditionReturn;
	
	@Autowired
	MaggiorenneController maggiorenneController;
	
	@Autowired
	public ConditionalControllerB(TestSpringResolver resolver) {		
		super(resolver);
	}

	@Override
	public BlockController setDefaultReturn(Request request, Response response) {
		return conditionalControllerId1;
	}	

	@Override
	public ConditionList addConditions(Request request, Response response) {
		
		RequestHandler requestHandler = (RequestHandler) request;
		StringResponse stringResponse = (StringResponse) response;				
		stringResponse.getResponse().append("Eseguo passo condizionale multiplo PassoB, ");	
		
		ConditionList list = new ConditionList(); 
		
		/**
		 * 1 - argomento varaibile (potrebbe essere anche il ritorno di un metodo, ad es una stringa prefissata)
		 * 2 - condizione della variabile (si potrebbe mettere la stringa prefissata di ritorno)
		 * 3 - invocazione controller o conditionReturn in caso metch variabile-condizione 
		 * 
		 *  ATTENZIONE!!!: i controlli vengono eseguiti in sequenza il controller successivo ritornato è il primo valido
		 *  es: passo=PassoD1 e id=3, sarà eseguito passoD1ConditionReturn e non controllerD1.
		 */
		//prova condizione di &&		
		list.add(new Condition(requestHandler.getRequest().getPasso(),"PassoC", id2ConditionReturn));		
		//fine prova &&
		//prova di ||
		list.add(new Condition(requestHandler.getRequest().getPasso(),"PassoD", passoD1ConditionReturn));
		list.add(new Condition(requestHandler.getRequest().getId(),3L, passoD1ConditionReturn));				
		//fine prova ||
		
		//ritorno diretto del controller
		list.add(new Condition(requestHandler.getRequest().getPasso(),"PassoD1", controllerD1));
		
		//utilizzo di un metodo con enum
//		GregorianCalendar calendar = new GregorianCalendar();
//	    calendar.setTime(requestHandler.getRequest().getData());
//		list.add(new Condition<RequestHandler, StringResponse>(
//				Utils.checkEta(calendar),Eta.ISMAGGIORENNE, maggiorenneController));
		
		list.add(new Condition(requestHandler.getEta(),Eta.MAGGIORENNE, maggiorenneController));
	
		return list;
		
	}
	
}
