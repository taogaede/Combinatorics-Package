package setTheory;

public class Function {

	public CombSet domain;
	public CombSet range;
	public CombSet codomain;
	public Function[] rule;
	public boolean elementary = false;
	public Object input;
	public Object action;
	public Operation op = new Operation();
	
	
	public Function() {}
	public Function(CombSet domain) {
		//  This constructor is used when user wants to set function's action after initialization:
		/*
		 * CombSet dom = {2,1,5,7};
		 * Function decToBin = new Function(dom);
		 * decToBin.action = decimalToBinary(input);
		 * 
		 * decToBin.apply(dom);
		 */
		this.domain = domain;
	}
	public Function(CombSet domain, CombSet range, Object action) {
		this.domain = domain;
		this.range = range;
		this.action = action; //User selects which Function method to call as the elementary function's operation.
		
		this.op.action = op.identity(op.input); 
		//User should change the function's operation method to whatever they want after construction.  
		//The identity operation is initialized by default.
		//Example:
		/*
		 * CombSet dom = [5,6,7,8];
		 * CombSet ran = [5,6,7,8];
		 * Function function = new Function(dom,ran)
		 * function.op.action = op.decimalToBinary(op.input);
		 */
	}

	public Function(CombSet domain, CombSet range, Function[] rule) {
		this.domain = domain;
		this.range = range;
		this.rule = rule;
	}
	public void addRule(Function newFunction) {
		//add the operations of newFunction to the operation sequence of current function.
		//NOTE: need to include domain and range checks!
		if (this.range != newFunction.domain) {
			//EXPLODE
		}
		int totalSteps = rule.length + newFunction.rule.length;
		Function[] newRule = new Function[totalSteps];
		for (int i = 0; i < rule.length; i++) {
			newRule[i] = rule[i];
		}
		for (int i = rule.length; i < totalSteps; i++) {
			newRule[i] = newFunction.rule[i];
		}
		this.rule = newRule;
	}
	
	public void removeRule(Function removedFunction) {
		
	}
	//This method gets overridden when function is constructed as elementary.
	//If not elementary, then the rule is sequence of ultimately elementary functions.
	public CombSet operate() {
		CombSet result = new CombSet();
		for (int i = 0; i < rule.length; i++) {
			result = rule[i].operate();
		}
		return result;
	}
	
	public CombSet apply(CombSet set) {
		CombSet newSet = new CombSet();
		for (int i = 0; i < rule.length; i++) {
			if (rule[i].elementary == true) {
				for (int j = 0; j < set.size(); j++) {
					rule[i].op.input = set.get(j);
					set.get(j) = rule[i].op.operate();
			
				}
			}
			rule[i].operate();
		}
		return newSet;
	}
	
	public Object test(Object integer) {
		int number = 0;
		return test(number);
	}
	
	public Object identity(Object element) {
		return element;
	}
	
}
