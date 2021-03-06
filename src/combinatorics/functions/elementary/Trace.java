package combinatorics.functions.elementary;

import combinatorics.core.elements.Element;
import combinatorics.core.math.functions.ElementaryFunction;
import combinatorics.core.tools.typing.ElementTyper;

public class Trace extends ElementaryFunction {

	public Trace() {
		setDescription();
	}
	
	protected Element operation(Element matrix) {
		if (ElementTyper.toValue(matrix).getClass() == Integer[][].class) return operation( (Integer[][]) ElementTyper.toValue(matrix));
		if (ElementTyper.toValue(matrix).getClass() == Double[][].class) return operation( (Double[][]) ElementTyper.toValue(matrix));
		return null;
	}
	
	private Element operation(Integer[][] matrix) {
		Double trace = 0.0;
		for (int i = 0; i < matrix.length; i++) {
			trace = trace + matrix[i][i];
		}
		return ElementTyper.toElement(trace);
	}
	
	private Element operation(Double[][] matrix) {
		Double trace = 0.0;
		for (int i = 0; i < matrix.length; i++) {
			trace = trace + matrix[i][i];
		}
		return ElementTyper.toElement(trace);
	}
	
	private void setDescription() {
		description = "Calculates the trace of numerical matrix";
	}
}
