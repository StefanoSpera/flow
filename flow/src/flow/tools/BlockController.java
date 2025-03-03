package flow.tools;

/**
 * 
 * @author Stefano Spera
 * base block controller abstract class 
 * @param <Request>
 * @param <Response>
 */
public abstract class BlockController implements ConditionReturnIF {				
	
	/**
	 * 
	 * @return handler block by controller
	 */
	abstract StepBlockIF getStep();
	
	/**
	 * execute controller
	 * @param request
	 * @param response
	 * @return
	 */
	abstract BlockController execute(Request request, Response response);
	
	
	public BlockController resolve(){
		return this;
	}
	
}
