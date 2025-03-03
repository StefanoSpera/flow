package flow.tools;

/**
 * 
 * @author Spera Stefano
 *
 * Flowchart Handler implementation
 * @param <Request>
 * @param <Response>
 */
public class FlowchartSpringHandler{
	
	/**
	 * Generic request object
	 */	
	private Request request;
	/**
	 * Generic response object
	 */
	private Response response;
	
	/**
	 * Constructor Flowchart Handler implementation
	 * @param request Generic request object
	 * @param response Generic response object
	 * @throws Exception
	 */
	public FlowchartSpringHandler(Request request,Response response) throws Exception{							
		
		this.request=request;
		this.response=response;
	}
	
	/**
	 * 
	 * @return Generic request object
	 */
	Request getRequest(){
		return request;
	}
	
	/**
	 * 
	 * @return Generic request object
	 */
	public Response getResponse(){
		return response;
	}					
	
	/**
	 * Star flowchart method
	 * @param controller Flowchart block controller
	 */
	public void start(BlockController controller) {
		StepBlockIF stepIF = controller.getStep();
		stepIF.setController(controller);
		stepIF.setResponse(response);
		stepIF.setRequest(request);
		stepIF.execute(this);
	}

	/**
	 * Next block flowchart method
	 * @param controller previous flowchart controller
	 * @return next Flowchart block controller
	 */
	StepBlockIF next(BlockController controller) {
		
		StepBlockIF stepIF = controller.getStep();
		stepIF.setController(controller);
		stepIF.setResponse(response);
		stepIF.setRequest(request);
		return stepIF; 
	}
	
}
