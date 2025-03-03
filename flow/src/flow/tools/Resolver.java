package flow.tools;

import java.util.HashMap;

/**
 * Conditions Resolver
 * @author Stefano Spera
 *
 * @param <Request>
 * @param <Response>
 */
public class Resolver {
	
	private HashMap<Object,Object> clazzs;
	
	
	public Resolver() {
		clazzs = new HashMap<Object,Object>();
	}
	
	public Resolver addCondition(Object valueKey,Object clazz) {
		clazzs.put(valueKey, clazz);
		return this;
	}
		
	public BlockController resolve(Object arg) throws InstantiationException, IllegalAccessException, ClassNotFoundException {														
		ConditionReturnIF condition =  (ConditionReturnIF) clazzs.get(arg); 
		return condition.resolve();
	}
		
}
