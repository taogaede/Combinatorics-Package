package combinatorics.functions.composite;

import combinatorics.core.Function;
import combinatorics.functions.elementary.BinarySequenceToComposition;
import combinatorics.functions.elementary.DecimalToBinary;

public class CompositionMaker extends Function {
	public CompositionMaker() {
		elementary = false;

		rule = new Function[2];

		rule[0] = new DecimalToBinary();
		rule[1] = new BinarySequenceToComposition();

		description = "Converts decimal integers into integer compositions.";
	}
}
