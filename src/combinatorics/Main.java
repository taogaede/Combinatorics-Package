package combinatorics;

import java.util.Arrays;

import combinatorics.core.math.functions.CompositeFunction;
import combinatorics.core.math.sets.FiniteSet;
import combinatorics.core.tools.printing.Printer;
import combinatorics.sets.*;
import combinatorics.sets.singletons.*;
import combinatorics.functions.composite.*;
import combinatorics.functions.elementary.*;

public class Main {
	
	public static void main(String[] args) {
		
		FiniteSet set = new FiniteSet(32, 63);
		
		CompositeFunction myFunction = new CompositeFunction(new DecimalToBinary(), set);
		myFunction.appendRule(new BinarySequenceToComposition());
		myFunction.appendRule(new Add(10));
		
		Printer.printSet(set, myFunction.operate());
		
		Printer.printSet(new RotationallyInvariantComposition(8));
	}
}