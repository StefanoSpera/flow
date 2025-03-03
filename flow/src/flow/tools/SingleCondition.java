package flow.tools;

/**
 * Condition class for single condition controller
 * @author Stefano Spera
 *
 * @param <Request>
 * @param <Response>
 */
public class SingleCondition{				
	
	private Object valueKey;
	private ConditionReturnIF clazz;
	
	public SingleCondition(Object valueKey, ConditionReturnIF clazz) {
		super();
		this.valueKey = valueKey;
		this.clazz = clazz;
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
