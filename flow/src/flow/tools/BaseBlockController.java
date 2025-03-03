package flow.tools;

/**
 * 
 * @author Stefano Spera
 * Base block controller implementation
 * @param <Request>
 * @param <Response>
 */
@SuppressWarnings("rawtypes")
public abstract class BaseBlockController<T extends BlockController> extends BlockController{
	
	/**
	 * execute controller method
	 */
	public abstract T execute(Request request, Response response);

	/**
	 * @return base block
	 */
	@Override
	StepBlockIF getStep(){
		return new StepBlock();
	}
}
