package combinatorics.sets.singletons;

import combinatorics.core.FiniteSet;
import combinatorics.core.Function;
import combinatorics.functions.composite.CompositionMaker;
import combinatorics.core.Printable;
import combinatorics.core.SingletonSet;
import combinatorics.core.elements.*;

public class Matrix extends SingletonSet{

	//Matrix Properties
	private Integer rowNumber;
	private Integer columnNumber;
	private Integer determinant;
	private Integer trace;
	private boolean isSquare;
	private boolean isSingular;
	//hashmap eigenvectorsAndValues
	
	public Matrix(Integer[][] matrix) {
		setElement(ElementTyper.toElement(matrix));
	}
	public Matrix(Double[][] matrix) {
		setElement(ElementTyper.toElement(matrix));
	}
	public Matrix(String[][] matrix) {
		setElement(ElementTyper.toElement(matrix));
	}

	public Matrix multiply(Matrix operand) {
		
		return null;
	}
	
	public Matrix add(Matrix operand) {
	
		return null;
	}
	
	public Integer getDeterminant() {
		//calculate
		return determinant;
	}
	
	public void printDescription() {
	}
}
