package combinatorics;

import java.util.Arrays;

import combinatorics.core.math.functions.CompositeFunction;
import combinatorics.core.math.sets.FiniteSet;
import combinatorics.core.tools.printing.Printer;
import combinatorics.sets.*;
import combinatorics.sets.singletons.*;
import combinatorics.sets.singletons.matrices.Matrix;
import combinatorics.sets.singletons.matrices.IntegerMatrix;
import combinatorics.sets.singletons.matrices.DoubleMatrix;
import combinatorics.functions.composite.*;
import combinatorics.functions.elementary.*;
import combinatorics.sets.singletons.matrices.tools.DeterminantCalculator;

public class Main {
	
	public static void main(String[] args) {
		
		Double[][] temp = new Double[6][6];
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = Double.valueOf(i + j*j - i*j);
			}
		}
		
		DoubleMatrix coolio = new DoubleMatrix(temp);
		System.out.println(coolio.getDeterminant());
		coolio.print();
	}
}