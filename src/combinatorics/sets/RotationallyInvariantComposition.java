package combinatorics.sets;

import combinatorics.core.FiniteSet;
import combinatorics.core.CompositeFunction;
import combinatorics.functions.elementary.LexMinRotation;

public class RotationallyInvariantComposition extends FiniteSet {

	private FiniteSet initialSet;
	private Integer weight;
	private String initialSetDescription = "";
	private CompositeFunction constructingFunction;
	private String setDescription = "";
	private String algorithmSource = "Author(s): ..." + " --- Reference: ...";

	public RotationallyInvariantComposition(Integer weight){
		this.weight = weight;

		initialSet = new Composition(this.weight);
		constructingFunction = new CompositeFunction(new LexMinRotation(), initialSet);

		addAll((constructingFunction.operate()).removeDuplicates());

		initialSetDescription = "Integer compositions of " + this.weight;
		setDescription = "Rotationally invariant compositions of " + this.weight;
		constructingFunction.description = "Construct compositions, get lex min rotations, then remove duplicates.";
	}

	public void printDescription() {
		System.out.println();
		System.out.println("Set Description: " + setDescription);
		System.out.println("Set Construction:");
		System.out.println("Initial Set: " + initialSetDescription);
		System.out.println(algorithmSource);
	}
}
