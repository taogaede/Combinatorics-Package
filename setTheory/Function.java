package setTheory;

public class Function {

	public CombSet domain;
	public CombSet range;
	public CombSet codomain;
	public Function[] rule;
	
	
	
	public Function() {
		// TODO Auto-generated constructor stub
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
}
