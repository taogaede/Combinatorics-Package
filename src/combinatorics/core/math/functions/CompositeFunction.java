package combinatorics.core.math.functions;

import combinatorics.core.math.sets.FiniteSet;

public class CompositeFunction extends Function {
	
	public Function[] rule;
	
	public CompositeFunction() {}
	
	public CompositeFunction(FiniteSet domain, Function[] rule) {
		this.domain = domain;
		this.rule = rule;
	}
	
	public CompositeFunction(Function[] rule, FiniteSet domain) {
		this.domain = domain;
		this.rule = rule;
	}
	
	public CompositeFunction(Function singletonRule, FiniteSet domain) {
		this.domain = domain;
		Function[] rule = new Function[1];
		rule[0] = singletonRule;
		this.rule = rule;
	}
	
	public CompositeFunction(FiniteSet domain, Function singletonRule) {
		this.domain = domain;
		Function[] rule = new Function[1];
		rule[0] = singletonRule;
		this.rule = rule;
	}
	
	public CompositeFunction(Function[] rule) {
		this.rule = rule;
	}
	
	public void setRule(Function[] rule) {
		this.rule = rule;
	}
	
	public void appendRule(Function newFunction) {
		Integer currentRuleLength = rule.length;
		Function[] newRule = new Function[currentRuleLength + 1];
		for (int i = 0; i < rule.length; i++) {
			newRule[i] = rule[i];
		}
		newRule[currentRuleLength] = newFunction;
		this.rule = newRule;
	}
	
	public FiniteSet operate() {
		rule[0].domain = this.domain;
		for (int i = 1; i < rule.length; i++) {
			rule[i].domain = rule[i - 1].operate();
		}
		return rule[rule.length - 1].operate();
	}
	
	public void print() {
		System.out.println(this.description);
		for (int i = 0; i < rule.length; i++) {
			rule[i].print();
		}
	}
}
