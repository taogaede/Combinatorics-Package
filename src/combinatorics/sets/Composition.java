package combinatorics.sets;

import combinatorics.core.math.functions.Function;
import combinatorics.core.math.sets.FiniteSet;
import combinatorics.functions.composite.CompositionMaker;

public class Composition extends FiniteSet{

	private Integer weight;
	private FiniteSet initialSet;
	private Function constructingFunction;
	private String initialSetDescription = "{integers in [2^(" + this.weight + " - 1), 2^(" + this.weight + ") - 1]}";
	private String algorithmSource = "Author(s): Tao Gaede" + " --- Reference: ";

	public Composition(Integer weight) {
		this.weight = weight;
		initialSet = new Integers(pow(2,this.weight - 1), pow(2,this.weight) - 1);

		constructingFunction = new CompositionMaker(initialSet);

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
		System.out.println(algorithmSource);
	}
}
