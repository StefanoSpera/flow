package flow.tools;

/**
 * 
 * @author Stefano Spera
 * base block abstract class
 * @param <Request>
 * @param <Response>
 */
abstract class BaseStepBlock implements StepBlockIF{
	
	protected Request request;
	protected Response response;

	@Override
	public Request getRequest() {
		return request;
	}
	
	@Override
	public Response getResponse() {
		return response;
	}
	
	@Override
	public void setRequest(Request request) {
		this.request=request;
	}
	
	@Override
	public void setResponse(Response response) {
		this.response=response;
	}
	
	@Override
	public void setController(BlockController c) {		
	}
	
	@Override
	public abstract void execute(FlowchartSpringHandler workFlow);

}
