package flow.tools;

/**
 * Final controller block abstract class
 * @author Stefano
 *
 * @param <Request>
 * @param <Response>
 */
public abstract class EndBlockController extends BlockController{

	public abstract void end(Request request, Response response);		

	@Override
	StepBlockIF getStep(){
		return new EndStepBlock();
	}
	
	BlockController execute(Request request, Response response){
		end(request,response);
		return null;
	}
}
