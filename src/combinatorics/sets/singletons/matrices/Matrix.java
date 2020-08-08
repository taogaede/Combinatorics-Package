package combinatorics.sets.singletons.matrices;

import combinatorics.functions.composite.CompositionMaker;
import combinatorics.core.elements.*;
import combinatorics.core.math.functions.Function;
import combinatorics.core.math.sets.FiniteSet;
import combinatorics.core.math.sets.SingletonSet;
import combinatorics.core.tools.printing.Printable;
import combinatorics.core.tools.typing.ElementTyper;

public class Matrix extends SingletonSet{
	
	protected Matrix() {};
	
	public Matrix(Integer[][] matrix) {
		new IntegerMatrix(matrix);
	}
	public Matrix(Double[][] matrix) {
		new DoubleMatrix(matrix);
	}
	public Matrix(String[][] matrix) {
		new StringMatrix(matrix);
	}
	
	public Integer getRowNumber() {
		Object[][] abstractMatrix = ( (Object[][]) ElementTyper.toValue(value));
		return abstractMatrix[0].length;
	}
	
	public Integer getColumnNumber() {
		Object[][] abstractMatrix = ( (Object[][]) ElementTyper.toValue(value));
		return abstractMatrix.length;
	}
	
	public boolean isSquare() {
		if ( getRowNumber() == getColumnNumber()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Object[][] getValue() {
		return null;
	}
	
	public void print() {
		this.getElement().print();
	}
	
}
