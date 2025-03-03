package flow.tools;

/**
 * 
 * @author Stefano Spera
 * base block implementation
 * @param <Request>
 * @param <Response>
 */
class StepBlock extends BaseStepBlock {
	
	private BlockController controller;
	
	/**
	 * set base block icontroller
	 */
	@Override
	public void setController(BlockController controller) {
		this.controller=controller;
	}
	
	/**
	 * execute base block
	 */
	@Override
	public void execute(FlowchartSpringHandler workFlow) {
		BlockController next = this.controller.execute(workFlow.getRequest(), workFlow.getResponse());
		workFlow.next(next).execute(workFlow);
	}

}
