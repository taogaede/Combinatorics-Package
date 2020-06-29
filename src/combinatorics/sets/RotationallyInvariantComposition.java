package combinatorics.sets;

import combinatorics.core.CombinatorialSet;
import combinatorics.core.Function;
import combinatorics.functions.elementary.LexMinRotation;

public class RotationallyInvariantComposition extends CombinatorialSet {

	private CombinatorialSet initialSet;
	private Integer weight;
	private String initialSetDescription = "";
	private Function constructingFunction;
	private String setDescription = "";
	private String algorithmSource = "Author(s): ..." + " --- Reference: ...";

	public RotationallyInvariantComposition(Integer weight){
		this.weight = weight;

		initialSet = new Composition(this.weight);
		constructingFunction = new Function(initialSet, new Function[1]);

		constructingFunction.rule[0] = new LexMinRotation();

		addAll( (constructingFunction.operate()).removeDuplicates());

		initialSetDescription = "Integer compositions of " + this.weight;
		setDescription = "Rotationally invariant compositions of " + this.weight;
		constructingFunction.description = "Construct compositions, get lex min rotations, then remove duplicates.";
	}

	public void printDescription() {
		System.out.println();
		System.out.println("Set Description: " + setDescription);
		System.out.println("Set Construction:");
		System.out.println("Initial Set: " + initialSetDescription);
		constructingFunction.printFullDescription();
		System.out.println(algorithmSource);
	}
}
