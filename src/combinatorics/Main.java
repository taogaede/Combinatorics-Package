package combinatorics;

import java.util.Arrays;

import combinatorics.core.FiniteSet;
import combinatorics.core.Function;
import combinatorics.core.elements.*;
import combinatorics.functions.composite.*;
import combinatorics.functions.elementary.*;
import combinatorics.sets.*;
import combinatorics.sets.singletons.*;
import combinatorics.core.Printer;

public class Main {
	
	public static void main(String[] args) {
		
		Integer[][] array2D = new Integer[4][4];
		for(int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[0].length; j++) {
				array2D[i][j] = i*j;
			}
		}
		SingletonSet matrix = new Matrix(array2D);
		matrix.print();
	}
}
