package flow.tools;

/**
 * 
 * @author Stefano Spera
 *
 * Final step block
 * @param <Request>
 * @param <Response>
 */
class EndStepBlock extends BaseStepBlock {

	private BlockController controller;
	
	@Override
	public void setController(BlockController controller) {
		this.controller=controller;
	}
	
	@Override
	public void execute(FlowchartSpringHandler workFlow) {
		this.controller.execute(workFlow.getRequest(), workFlow.getResponse());
	}					
	
}
