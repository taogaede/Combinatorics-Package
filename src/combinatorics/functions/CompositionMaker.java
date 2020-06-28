package combinatorics.functions;

import combinatorics.core.Function;

public class CompositionMaker extends Function {
	public CompositionMaker() {
		elementary = false;

		rule = new Function[2];

		rule[0] = new DecimalToBinary();
		rule[1] = new BinarySequenceToComposition();

		description = "Converts decimal integers into integer compositions.";
	}
}
