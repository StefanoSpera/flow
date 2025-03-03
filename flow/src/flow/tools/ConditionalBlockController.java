package flow.tools;

import java.util.ArrayList;

/**
 * 
 * @author Stefano Spera
 * Conditional block controller abstract class
 * @param <Request>
 * @param <Response>
 */
public abstract class ConditionalBlockController extends BlockController{

	private Resolver r;
		
	private ConditionList conditions;
	
	public ConditionalBlockController(){	
		this.r= new Resolver();
	}
	
	public ConditionalBlockController(Resolver r){	
		this.r= r;
	}
	
	public abstract BlockController setDefaultReturn(Request request, Response response);				
					
	public class ConditionList extends ArrayList<Condition>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Override
		public boolean add(Condition condition){
			super.add(condition);
			r.addCondition(condition.getValueKey(), condition.getClazz());
			return true;
		}
	}
	
	public abstract ConditionList addConditions(Request request, Response response);			
	
	public Resolver getResolver(){
		return this.r;
	}

	@Override
	StepBlockIF getStep(){
		return new StepBlock();
	}
	
	BlockController execute(Request request, Response response){
		
		this.conditions = addConditions(request, response);
			
		for (Condition condition : conditions) {
			try {				
				return r.resolve(condition.getResolveArg());
			} catch (Exception e) {
				
			}	
		}
		
		
		return setDefaultReturn(request,response);
	}
}


