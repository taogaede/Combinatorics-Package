package combinatorics.sets.singletons;

import combinatorics.core.tools.typing.ElementTyper;

public class IntegerMatrix extends Matrix {

	private Double determinant;
	private boolean isSingular;
	private Integer trace;
	
	public IntegerMatrix(Integer[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
}
