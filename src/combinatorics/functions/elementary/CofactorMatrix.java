package combinatorics.functions.elementary;

import combinatorics.core.math.functions.ElementaryFunction;
import combinatorics.core.tools.typing.ElementTyper;
import combinatorics.core.elements.Element;

public class CofactorMatrix extends ElementaryFunction {
	public CofactorMatrix() {
		setDescription();
	}
	
	protected Element operation(Element input) {		
		if (ElementTyper.toValue(input).getClass() == Integer[][].class) {
			return operation( (Integer[][]) ElementTyper.toValue(input));
		}
		if (ElementTyper.toValue(input).getClass() == Double[][].class) {
			return operation( (Double[][]) ElementTyper.toValue(input));
		}
		return null;
	}
	
	private Element operation(Integer[][] matrix) {
		Integer[][] cofactorMatrix = new Integer[matrix.length][matrix[0].length];		
	}
	
	private void setDescription() {
		description = "blah";
	}
}
