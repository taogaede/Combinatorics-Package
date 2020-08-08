package combinatorics.sets.singletons.matrices.tools;

import combinatorics.core.tools.typing.ElementTyper;
import combinatorics.sets.singletons.matrices.DoubleMatrix;
import combinatorics.sets.singletons.matrices.IntegerMatrix;
import combinatorics.sets.singletons.matrices.NumberMatrix;

public class DeterminantCalculator { 

	//Brute force determinant calculator I made using the general formula.  
	//Could make more efficient by including step that checks for most sparse row or column.
	//This approach always reduces from the top row.
	
	public static Number calculate(NumberMatrix input) {
		if (input.getClass() == IntegerMatrix.class) return calculate( (IntegerMatrix) input);
		if (input.getClass() == DoubleMatrix.class) return calculate( (DoubleMatrix) input);
		return null;
	}
	
	private static Double calculate(DoubleMatrix input) {		
		Double determinant = 0.0;
		
		if (input.isSquare() == false) return null;
		Double[][] matrix = (Double[][]) ElementTyper.toValue(input.getElement());
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
				determinant = determinant + matrix[0][i] * calculate(new DoubleMatrix(iSubMatrix)) * Math.pow(-1.0, i);
			}
		}
		if (matrixSize == 2) {
			determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		}
		if (matrixSize == 1) {
			determinant = matrix[0][0];
		}
		return determinant;
		
	}
	
	private static Integer calculate(IntegerMatrix input) {		
		Integer determinant = 0;
		
		if (input.isSquare() == false) return null;
		Integer[][] matrix = (Integer[][]) ElementTyper.toValue(input.getElement());
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
				determinant = determinant + matrix[0][i] * calculate(new IntegerMatrix(iSubMatrix)) * pow(-1, i);
			}
		}
		if (matrixSize == 2) {
			determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		}
		if (matrixSize == 1) {
			determinant = matrix[0][0];
		}
		return determinant;
	}
	
	private static Integer pow(Integer base, Integer exponent) {
		Integer result = 1;
		for (int i = 0; i < exponent; i++) {
			result = result*base;
		}
		return result;
	}
}
