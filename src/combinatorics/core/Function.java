package combinatorics.core;

public class Function {

	public CombinatorialSet domain;
	public Function[] rule;
	public boolean elementary = true;
	public Operation op;
	public String description = "";
	
	/*
	 * CONSTRUCTOR METHODS
	 */
	
	//NOTE: need to clean up and do some thinking here to narrow down which constructors are needed.  Remember to design to constrain the user into using an intuitive workflow rather than give them "options" which then has them breaking something or getting confused.
	
		//Empty
	public Function() {}
	
		//Singles
	public Function(CombinatorialSet domain) {
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
		this.elementary = true;
		this.description = this.op.getDescription();
	}
	public Function(Function[] rule) {
		this.rule = rule;
		this.elementary = false;
	}
	
		//Doubles
	public Function(CombinatorialSet domain, boolean elementary) {
		this.domain = domain;
		this.elementary = elementary;
	}
	public Function(Operation op, String description) {
		this.op = op;
		this.elementary = true;
		this.description = description;
	}
	public Function(Function[] rule, boolean elementary) {
		this.rule = rule;
		this.elementary = elementary;
	}
	
	public Function(CombinatorialSet domain, Function[] rule) {
		this.domain = domain;
		this.rule = rule;
		this.elementary = false;
	}
	
	public Function(CombinatorialSet domain, boolean elementary, String description) {
		this.domain = domain;
		this.description = description;
		this.elementary = elementary;
	}
	
	public Function(CombinatorialSet domain, Operation op) {
		this.domain = domain;
		this.op = op;
		this.elementary = true;
		this.description = this.op.getDescription();
	}
	public Function(CombinatorialSet domain, Operation op, String description) {
		this.domain = domain;
		this.op = op;
		this.elementary = true;
		this.description = description;
	}
	
	//Prints description of current function and its immediate components (rule[] entry descriptions).
	public void printDescription() {
		System.out.println(this.description);
		System.out.println();
		if (this.elementary == false) {	
			for (int i = 0; i < rule.length; i++) {
				System.out.println("step " + i + ": " + " -------- " + rule[i].description);
			}
		}
	}
	//Prints descriptions of each function from highest level to lowest.  After each highest, prints lower function descriptions, all the way down to elementary function descriptions.  Recursive algorithm to get to bottom.
	public void printFullDescription() {
		if (this.elementary == false) {	
			System.out.println(this.description);
			for (int i = 0; i < rule.length; i++) {
				if (rule[i].elementary == true) {
					System.out.println(" -------- " + rule[i].description);
				}
				if (rule[i].elementary == false) {
					rule[i].printFullDescription();
				}
			}
		}
		else {
			printDescription();
		}
	}
	
	//Add/remove rule.  NOTE: overloading addRule using copy and paste - need to restructure so that the overloading methods call a private one that does the work.
	public void addRule(Function addFunction) {
		//add the operations of newFunction to the operation sequence of current function.
		if (this.elementary == true && addFunction.elementary == true) {
			Function newFunction = new Function(this.domain, new Function[2]);
			newFunction.rule[0] = new Function(this.domain, this.op, this.description);
			newFunction.rule[1] = addFunction;
			this.domain = newFunction.domain;
			this.elementary = newFunction.elementary;
			this.rule = newFunction.rule;
			this.op = newFunction.op;
			return;
		}
		
		if (this.elementary == true && addFunction.elementary == false) {
			Function newFunction = new Function(this.domain, new Function[1 + addFunction.rule.length]);
			newFunction.rule[0] = new Function(this.domain, this.op, this.description);		
			
			for (int i = 1; i < 1 + addFunction.rule.length; i++) {
				newFunction.rule[i] = addFunction.rule[i];
			}
			
			this.domain = newFunction.domain;
			this.elementary = newFunction.elementary;
			this.rule = newFunction.rule;
			this.op = newFunction.op;
			return;
		}
		if (this.elementary == false && addFunction.elementary == true) {
			Function[] newRule = new Function[this.rule.length + 1];
			for (int i = 0; i < this.rule.length; i++) {
				newRule[i] = this.rule[i];
			}	
			newRule[this.rule.length] = addFunction;
			//System.out.println(newRule[this.rule.length].description);
			this.rule = newRule;
			return;
		}
		if (this.elementary == false && addFunction.elementary == false) {
			int totalSteps = this.rule.length + addFunction.rule.length;
			Function[] newRule = new Function[totalSteps];
			for (int i = 0; i < rule.length; i++) {
				newRule[i] = this.rule[i];
			}
			for (int i = rule.length; i < totalSteps; i++) {
				newRule[i] = addFunction.rule[i];
			}
			this.rule = newRule;
			return;
		}
	}
	public void addRule(Function addFunction, String newDescription) {
		//add the operations of newFunction to the operation sequence of current function.
		Function[] newRule;
		if (this.elementary == true && addFunction.elementary == true) {
			Function newFunction = new Function(this.domain, new Function[2]);
			newFunction.rule[0] = new Function(this.domain, this.op, this.description);
			newFunction.rule[1] = addFunction;
			this.domain = newFunction.domain;
			this.elementary = newFunction.elementary;
			this.rule = newFunction.rule;
			this.op = newFunction.op;
			this.description = newDescription;
			return;
		}
		
		if (this.elementary == true && addFunction.elementary == false) {
			Function newFunction = new Function(this.domain, new Function[1 + addFunction.rule.length]);
			newFunction.rule[0] = new Function(this.domain, this.op, this.description);		
			
			for (int i = 1; i < 1 + addFunction.rule.length; i++) {
				newFunction.rule[i] = addFunction.rule[i];
			}
			
			this.domain = newFunction.domain;
			this.elementary = newFunction.elementary;
			this.rule = newFunction.rule;
			this.op = newFunction.op;
			this.description = newDescription;
			return;
		}
		if (this.elementary == false && addFunction.elementary == true) {
			newRule = new Function[this.rule.length + 1];
			for (int i = 0; i < rule.length; i++) {
				newRule[i] = this.rule[i];
			}	
			newRule[rule.length] = addFunction;
			this.rule = newRule;
			this.description = newDescription;
			return;
		}
		if (this.elementary == false && addFunction.elementary == false) {
			int totalSteps = this.rule.length + addFunction.rule.length;
			newRule = new Function[totalSteps];
			for (int i = 0; i < rule.length; i++) {
				newRule[i] = this.rule[i];
			}
			for (int i = rule.length; i < totalSteps; i++) {
				newRule[i] = addFunction.rule[i];
			}
			this.rule = newRule;
			this.description = newDescription;
			return;
		}
	}
	public void removeRule(Function removedFunction) {
		//Need to do
	}

	//If not elementary, then the rule is a sequence of ultimately elementary functions.
	public CombinatorialSet operate() {
		
		CombinatorialSet result = new CombinatorialSet();
		
		if (elementary == false) {
			rule[0].domain = this.domain;
			for (int i = 1; i < rule.length; i++) {
				rule[i].domain = rule[i - 1].operate();
			}
			result = rule[rule.length - 1].operate();
		}
		
		if (elementary == true) {
			result = op.operateSet(this.domain);
		}
		return result;
	}
}

/*
 * Composite Function Subclasses
 * 
 * This is where you add functions you've built and would like to reference later and elsewhere.
 * 
 * Each composite function subclass should have the following components:
 * 
 * 1.	A constructor containing:
 * 
 * 		1.	elementary = false;
 * 
 * 		2.	initialization of the rule array at a particular size, depending on how many subfunctions will be included.
 * 
 * 		3.	initialization of each index of the rule array to a particular Function instance.
 * 
 * 		4.	A one sentence description of what the function does.
 * 
 */
/*
					BEGIN TEMPLATE

class YourFunction extends Function{
	public YourFunction(){
		elementary = false;
		
		rule = new Function[N];
		
		rule[0] = new YourFirstFunction();
		rule[1] = new YourSecondFunction();
			...
		rule[N] = new YourNthFunction();
		
		description = "A succinct and accurate description of what Your Function does";
	}
}

					END TEMPLATE


*/


