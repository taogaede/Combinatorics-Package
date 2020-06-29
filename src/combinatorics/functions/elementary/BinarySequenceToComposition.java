package combinatorics.functions.elementary;

import combinatorics.core.Function;
import combinatorics.operations.BinarySequenceToCompositionOp;

public class BinarySequenceToComposition extends Function {
	public BinarySequenceToComposition() {
		super(new BinarySequenceToCompositionOp());
	}
}