package setTheory;

import java.util.Arrays;

/*
 * Workflow:
 * 
 * 1.	Define a base domain combSet (like integers)
 * 
 * 2.	Define elementary functions that will operate on the base domain combSet to create a more complex desired domain combSet (like converting decimal integers to binary integers to get a set of binary sequences)
 * 
 * 3.	Repeat step 2 until you have the desired domain combSet for your researching needs (eg could select the binary sequences with the same number of 1s and then convert them to decimal integer sequences where the decimal integers are the index differences between consecutive 1s in the binary sequences - these will all be compositions of the same size.
 * 
 * 4.	Once you have your desired combSet, you can use the combSet methods to find various properties about this set.
 * 
 * 5.	You can also define more functions to act on your set to study related sets.
 */

public class Main {

	public static void main(String[] args) {
		
		
		//Define Domain Set
		CombSet eightSet = new CombSet(8);
		
		//Define Elementary Functions
		int ruleCount = 2;
		Function[] adding = new Function[ruleCount];
		for (int i = 0; i < ruleCount; i++) {
			adding[i] = new Function();
			Add add = new Add(2*i);
			adding[i].op = add;
			adding[i].description = "Adds " + 2*i + " to the previous.";
			adding[i].elementary = true;
		}
		
		//Define other elementary Function
		Function decimalToBinary = new Function();
		decimalToBinary.elementary = true;
		decimalToBinary.op = new DecimalToBinary();
		decimalToBinary.description = "Converts decimal integers into binary sequences.";
		
		//Define high level function
		Function crazyAdd = new Function(eightSet);
		crazyAdd.description = "Adds a bunch of fricken times in crazy ways.";
		crazyAdd.elementary = false;
		crazyAdd.rule = adding;
		
		//Apply the high level function to the domain set
		CombSet newSet = crazyAdd.operate();
		
		//Print results
		crazyAdd.printFullDescription();
		printElements(newSet);
		
		//Make higher level function.
		Function addIntsThenBinary = new Function(eightSet);
		addIntsThenBinary.elementary = false;
		addIntsThenBinary.rule = new Function[2];
		addIntsThenBinary.rule[0] = crazyAdd;
		addIntsThenBinary.rule[1] = decimalToBinary;
		
		//CombSet newSet2 = addIntsThenBinary.operate();
		//printElements(newSet2);
		CombSet set = new CombSet(16 + 1, 32);
		
		Function oneIndices = new Function(new IndicesOfElement(1),true);
		Function consecDiff = new Function(new ConsecutiveDifferences(true), true);
		Function superFunction = new Function(set, false);
		superFunction.rule = new Function[3];
		superFunction.rule[0] = decimalToBinary;
		superFunction.rule[1] = oneIndices;
		superFunction.rule[2] = consecDiff;
		
		CombSet newSet3 = superFunction.operate();
		printElements(newSet3);
	}
	
	
	public static void printElements(CombSet set) {
		boolean elementIsArray = false;
		if (set.get(0).getClass().isArray() == true) {
			elementIsArray = true;
		}
		
		if (elementIsArray == true) {
			for (int i = 0; i < set.size(); i++) {
				Object[] iArray = (Object[]) set.get(i);
				for (int j = 0; j < iArray.length; j++) {	
					if (iArray[j].getClass() == Integer.class)
						System.out.print((Integer) iArray[j]);
					if (iArray[j].getClass() == int.class)
						System.out.print((int) iArray[j]);
					if (iArray[j].getClass() == Double.class)
						System.out.print((Double) iArray[j]);
					if (iArray[j].getClass() == double.class)
						System.out.print((double) iArray[j]);
					if (iArray[j].getClass() == long.class)
						System.out.print((long) iArray[j]);
					if (iArray[j].getClass() == Long.class)
						System.out.print((Long) iArray[j]);
					if (iArray[j].getClass() == float.class)
						System.out.print((float) iArray[j]);
					if (iArray[j].getClass() == Float.class)
						System.out.print((Float) iArray[j]);
					
					if (iArray[j].getClass() == String.class)
						System.out.print((String) iArray[j]);
				}
				System.out.println();
			}
		}
		if (elementIsArray == false) {
			System.out.println(Arrays.toString(set.toArray()));
		}
	}
}
