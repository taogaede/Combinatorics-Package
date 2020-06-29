package combinatorics.functions.elementary;

import combinatorics.core.Function;
import combinatorics.operations.IndicesOfElementOp;

public class IndicesOfElement extends Function {
	public IndicesOfElement(Integer element) {
		super(new IndicesOfElementOp(element));
	}
}
