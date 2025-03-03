package flow.tools;

/**
 * 
 * @author Stefano Spera
 *
 * flowchart block interface
 * 
 * @param <Request>
 * @param <Response>
 */
interface StepBlockIF {		
			
	/**
	 * execute block
	 * @param workFlow flow handler
	 */
	void execute(FlowchartSpringHandler workFlow);
	
	/**
	 * set block controller
	 * @param block controller
	 */
	void setController(BlockController c);

	void setRequest(Request request);
	
	void setResponse(Response response);
	
	public Request getRequest();
	public Response getResponse();	
}
