package flow.tools;

/**
 * Condition class for condition controller
 * @author Stefano Spera
 *
 * @param <Request>
 * @param <Response>
 */
public class Condition{				
	
	private Object resolveArg;
	private Object valueKey;
	private ConditionReturnIF clazz;
	
	public Condition(Object resolveArg, Object valueKey, ConditionReturnIF clazz) {
		super();
		this.resolveArg = resolveArg;
		this.valueKey = valueKey;
		this.clazz = clazz;
	}

	public Object getResolveArg() {
		return resolveArg;
	}

	public void setResolveArg(Object resolveArg) {
		this.resolveArg = resolveArg;
	}

	public Object getValueKey() {
		return valueKey;
	}

	public void setValueKey(Object valueKey) {
		this.valueKey = valueKey;
	}

	public ConditionReturnIF getClazz() {
		return clazz;
	}

	public void setClazz(ConditionReturnIF clazz) {
		this.clazz = clazz;
	}
	
	
	
}
