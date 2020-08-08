package combinatorics.functions.elementary;

import combinatorics.core.elements.ArrayElement;
import combinatorics.core.elements.Element;
import combinatorics.core.math.functions.ElementaryFunction;
import combinatorics.core.tools.typing.ElementTyper;

public class Transpose extends ElementaryFunction {

	public Transpose() {
		setDescription();
	}
	
	public Element operation(Element input) {
		ArrayElement matrix = (ArrayElement) input;
		Integer rows = matrix.getMatrixDimensions()[0];
		Integer columns = matrix.getMatrixDimensions()[1];
		ArrayElement transposed = new ArrayElement(rows, columns);
		for (int i = 0; i < matrix.length(); i++) {
			for (int j = 0; j < matrix.length(); j++) {
				transposed.setMatrixEntry(i, j, matrix.getMatrixEntry(j, i));
			}
		}
		return transposed;
	}
	
	private void setDescription() {
		description = "Calculates the transpose of a matrix.";
	}
}
