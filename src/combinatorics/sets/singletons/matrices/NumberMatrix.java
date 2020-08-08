package combinatorics.sets.singletons.matrices;

import combinatorics.core.elements.ArrayElement;
import combinatorics.core.tools.typing.ElementTyper;
import combinatorics.sets.singletons.matrices.tools.DeterminantCalculator;
import combinatorics.core.elements.DoubleElement;
import combinatorics.core.elements.ArithmeticElement;

public class NumberMatrix extends Matrix {
	
	public Double getTrace() {
		ArrayElement matrix = (ArrayElement) value;
		
		//Assign traceElement to top left corner entry of matrix
		ArithmeticElement traceElement = (ArithmeticElement) ( (ArrayElement) matrix.getValue()[0]).getValue()[0];
		
		//Sum the remaining entries along the top left to bottom right diagonal
		for (int i = 1; i < matrix.length(); i++) {
			ArrayElement iRow = (ArrayElement) matrix.getValue()[i];
			for (int j = i; j < iRow.length(); j++) {
				ArithmeticElement ijEntry = (ArithmeticElement) iRow.getValue()[j];
				traceElement = traceElement.add(ijEntry);
			}
		}
		return (Double) ((DoubleElement) traceElement).getValue();
	}
	
	public Number getDeterminant() {
		return DeterminantCalculator.calculate(this);
	}
	
	public boolean isSingular() {
		if (getDeterminant().intValue() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
