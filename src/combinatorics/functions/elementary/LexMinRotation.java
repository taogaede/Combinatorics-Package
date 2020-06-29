package combinatorics.functions.elementary;

import combinatorics.core.Function;
import combinatorics.operations.LexMinRotationOp;

public class LexMinRotation extends Function {
	public LexMinRotation() {
		super(new LexMinRotationOp());
	}
}
