package combinatorics.functions.elementary;

import combinatorics.core.elements.Element;
import combinatorics.core.elements.DoubleElement;
import combinatorics.core.math.functions.ElementaryFunction;
import combinatorics.core.tools.typing.ElementTyper;

public class Determinant extends ElementaryFunction {

	public Determinant() {
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
		Double determinant = 0.0;		
		Integer matrixSize = matrix.length;
		if (matrixSize > 2) {
			for (int i = 0; i < matrixSize; i++) {
				Integer[][] iSubMatrix = new Integer[matrixSize - 1][matrixSize - 1];
				for (int j = 0; j < i; j++) {
					for (int k = 1; k < matrixSize; k++) {
						iSubMatrix[k - 1][j] = matrix[k][j];
					}
				}
				for (int j = i + 1; j < matrixSize; j++) {
					for (int k = 1; k < matrixSize; k++) {
						iSubMatrix[k - 1][j - 1] = matrix[k][j];
					}
				}				
				Double subDeterminant = ( (DoubleElement) operation( ElementTyper.toElement(iSubMatrix) ) ).getValue();
				determinant = determinant + matrix[0][i] * subDeterminant * Math.pow(-1.0, i);
			}
		}
		if (matrixSize == 2) {
			Integer integerDeterminant = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
			determinant = integerDeterminant.doubleValue();
		}
		if (matrixSize == 1) {
			Integer integerDeterminant = matrix[0][0];
			determinant = integerDeterminant.doubleValue();
		}
		return new DoubleElement(determinant);
	}
	
	private Element operation(Double[][] matrix) {
		Double determinant = 0.0;		
		Integer matrixSize = matrix.length;
		if (matrixSize > 2) {
			for (int i = 0; i < matrixSize; i++) {
				Double[][] iSubMatrix = new Double[matrixSize - 1][matrixSize - 1];
				for (int j = 0; j < i; j++) {
					for (int k = 1; k < matrixSize; k++) {
						iSubMatrix[k - 1][j] = matrix[k][j];
					}
				}
				for (int j = i + 1; j < matrixSize; j++) {
					for (int k = 1; k < matrixSize; k++) {
						iSubMatrix[k - 1][j - 1] = matrix[k][j];
					}
				}				
				Double subDeterminant = ( (DoubleElement) operation( ElementTyper.toElement(iSubMatrix) ) ).getValue();
				determinant = determinant + matrix[0][i] * subDeterminant * Math.pow(-1.0, i);
			}
		}
		if (matrixSize == 2) {
			determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		}
		if (matrixSize == 1) {
			determinant = matrix[0][0];
		}
		return new DoubleElement(determinant);
	}
	
	private void setDescription() {
		description = "Calculates the determinant of the given numerical matrix.";
	}
}
