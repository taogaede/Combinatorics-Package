package combinatorics.functions.composite;

import combinatorics.functions.elementary.*;
import combinatorics.core.math.functions.CompositeFunction;
import combinatorics.core.math.functions.Function;
import combinatorics.core.math.sets.FiniteSet;

public class CompositionMaker extends CompositeFunction {
	public CompositionMaker(FiniteSet domain) {
		this.domain = domain;
		
		rule = new Function[2];
		rule[0] = new DecimalToBinary();
		rule[1] = new BinarySequenceToComposition();

		description = "Converts decimal integers into integer compositions.";
	}
}
