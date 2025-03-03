package flow.tools;

import java.util.ArrayList;

/**
 * 
 * @author Stefano Spera
 * Conditional single block controller abstract class
 * @param <Request>
 * @param <Response>
 */
public abstract class SingleConditionalBlockController extends BlockController{

	private Resolver r;
			
	public SingleConditionalBlockController(){	
		this.r= new Resolver();
	}
	
	public SingleConditionalBlockController(Resolver r){	
		this.r= r;
	}
	
	public abstract BlockController setDefaultReturn(Request request, Response response);				
					
	public class SingleConditionList extends ArrayList<SingleCondition>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Override
		public boolean add(SingleCondition condition){
			super.add(condition);
			r.addCondition(condition.getValueKey(), condition.getClazz());
			return true;
		}
	}
	
	public abstract SingleConditionList addConditions(Response response);			
	
	public Resolver getResolver(){
		return this.r;
	}

	@Override
	StepBlockIF getStep(){
		return new StepBlock();
	}
	
	public abstract Object getResolveArg(Request request);
	
		BlockController execute(Request request, Response response){
		
		addConditions(response);
					
		try {				
			return r.resolve(getResolveArg(request));
		} catch (Exception e) {
			
		}			
		
		
		return setDefaultReturn(request,response);
	}
}


