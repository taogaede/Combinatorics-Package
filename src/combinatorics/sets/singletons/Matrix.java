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
	private boolean isSquare;
	
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
		return rowNumber;
	}
	
	public Integer getColumnNumber() {
		return columnNumber;
	}
	
	public boolean isSquare() {
		return isSquare;
	}
}
