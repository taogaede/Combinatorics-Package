package combinatorics.functions.composite;

import combinatorics.core.Function;
import combinatorics.functions.elementary.*;
import combinatorics.core.CompositeFunction;
import combinatorics.core.FiniteSet;

public class CompositionMaker extends CompositeFunction {
	public CompositionMaker(FiniteSet domain) {
		this.domain = domain;
		
		rule = new Function[2];
		rule[0] = new DecimalToBinary();
		rule[1] = new BinarySequenceToComposition();

		description = "Converts decimal integers into integer compositions.";
	}
}
