package setTheory;

public class Function {

	public CombSet domain;
	public Function[] rule;
	public boolean elementary = true;
	public Operation op;
	public String description = "";
	
	/*
	 * CONSTRUCTOR METHODS
	 */
		//Empty
	public Function() {}
	
		//Singles
	public Function(CombSet domain) {
		this.domain = domain;
	}
	public Function(boolean elementary) {
		this.elementary = elementary;
	}
	public Function(String description) {
		this.description = description;
	}
	public Function(Operation op) {
		this.op = op;
	}
	public Function(Function[] rule) {
		this.rule = rule;
	}
	
		//Doubles
	public Function(CombSet domain, boolean elementary) {
		this.domain = domain;
		this.elementary = elementary;
	}
	
	public Function(CombSet domain, boolean elementary, String description) {
		this.domain = domain;
		this.description = description;
		this.elementary = elementary;
	}
	
	public Function(CombSet domain, Operation op) {
		this.domain = domain;
		this.op = op; //User selects which Function method to call as the elementary function's operation.
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

	public Function(CombSet domain, boolean elementary, Function[] rule) {
		this.domain = domain;
		this.elementary = elementary;
		this.rule = rule;
	}
	
	/*
	 * PRINT METHODS
	 */
	
	public void printDescription() {
		System.out.println(this.description);
		System.out.println();
		for (int i = 0; i < rule.length; i++) {
			System.out.println("step " + i + ": " + " -------- " + rule[i].description);
		}
	}
	
	//Prints descriptions of each function from highest level to lowest.  After each highest, prints lower function descriptions, all the way down to elementary function descriptions.  Recursive algorithm to get to bottom.
	public void printFullDescription() {
		System.out.println(this.description);
		for (int i = 0; i < rule.length; i++) {
			if (rule[i].elementary == true) {
				System.out.println("step " + i + ": " + " -------- " + rule[i].description);
			}
			if (rule[i].elementary == false) {
				rule[i].printFullDescription();
			}
		}
	}
	
	/*
	 * RULE METHODS
	 */
	
	public void addRule(Function newFunction) {
		//add the operations of newFunction to the operation sequence of current function.
		
		int totalSteps = this.rule.length + newFunction.rule.length;
		Function[] newRule = new Function[totalSteps];
		for (int i = 0; i < rule.length; i++) {
			newRule[i] = this.rule[i];
		}
		for (int i = rule.length; i < totalSteps; i++) {
			newRule[i] = newFunction.rule[i];
		}
		this.rule = newRule;
	}
	
	public void removeRule(Function removedFunction) {
		
	}
	
	/*
	 * OPERATE METHODS
	 */
	
	//If not elementary, then the rule is a sequence of ultimately elementary functions.
	public CombSet operate() {
		
		CombSet result = new CombSet();
		
		if (elementary == false) {
			rule[0].domain = this.domain;
			for (int i = 1; i < rule.length; i++) {
				System.out.println("Step " + i + ":");
				System.out.println(rule[i - 1].description);
				rule[i].domain = rule[i - 1].operate();
			}
			System.out.println("Step " + rule.length + ":");
			System.out.println(rule[rule.length - 1].description);
			return rule[rule.length - 1].operate();
		}
		
		if (elementary == true) {
			Main.printElements(this.domain);
			System.out.println();
			result = op.operateSet(this.domain);
		}
		return result;
	}
}
