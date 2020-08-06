package combinatorics.sets.singletons;

import combinatorics.functions.composite.CompositionMaker;
import combinatorics.core.elements.*;
import combinatorics.core.math.functions.Function;
import combinatorics.core.math.sets.FiniteSet;
import combinatorics.core.math.sets.SingletonSet;
import combinatorics.core.tools.printing.Printable;
import combinatorics.core.tools.typing.ElementTyper;

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
