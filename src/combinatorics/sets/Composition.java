package combinatorics.sets;

import combinatorics.core.CombinatorialSet;
import combinatorics.core.Function;
import combinatorics.functions.composite.CompositionMaker;
import combinatorics.core.Printable;

public class Composition extends CombinatorialSet implements Printable{

	private Integer weight;
	private CombinatorialSet initialSet;
	private Function constructingFunction;
	private String initialSetDescription = "{integers in [2^(" + this.weight + " - 1), 2^(" + this.weight + ") - 1]}";
	private String algorithmSource = "Author(s): Tao Gaede" + " --- Reference: ";

	public Composition(Integer weight) {
		this.weight = weight;
		initialSet = new CombinatorialSet(pow(2,this.weight - 1), pow(2,this.weight) - 1);

		constructingFunction = new Function(initialSet, new Function[1]);

		constructingFunction.rule[0] = new CompositionMaker();

		addAll(constructingFunction.operate());
	}

	private int pow(int base, int exponent) {
		int c = 1;
		for(int i = 0; i < exponent; i++) {
			c = c*base;
		}
		return c;
	}
	public void printDescription() {
		System.out.println("Construction of integer compositions of " + this.weight);
		System.out.print("Initial Set: " + initialSetDescription);
		constructingFunction.printFullDescription();
		System.out.println(algorithmSource);
	}
}
