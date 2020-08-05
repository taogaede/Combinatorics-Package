package combinatorics.sets;

import combinatorics.core.CombinatorialSet;
import combinatorics.core.Function;
import combinatorics.functions.composite.CompositionMaker;
import combinatorics.core.Printable;
import combinatorics.core.elements.*;

public class Matrix extends CombinatorialSet implements Printable{

	public Matrix(Integer[][] matrix) {
		add(elementTyper.toElement(matrix));
	}
	public Matrix(Double[][] matrix) {
		add(elementTyper.toElement(matrix));
	}
	public Matrix(String[][] matrix) {
		add(elementTyper.toElement(matrix));
	}

	public void printDescription() {
	}
}
