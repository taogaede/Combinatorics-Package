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
		
		//Define Elementary Functions

		//Define other elementary Function

		//Define high level function

		//Apply the high level function to the domain set

		//Print results

		//Make higher level function.

		CombSet compositionSet = new Composition(6);
		//System.out.println(compositionSet.size());
		printElements(compositionSet);
		Function indicesOf3 = new Function(compositionSet,new IndicesOfElement(3),true);
		printElements(indicesOf3.operate());
		//Function lexMinRotation = new Function(compositionSet, new LexMinRotation(), true);
		//System.out.println(lexMinRotation.op.getDescription());
		//lexMinRotation.operate();
		//printElements(lexMinRotation.operate());
	}
	
	public static void printElements(CombSet set) {
		boolean elementIsArray = false;
		if (set.size() > 0) {
			if (set.get(0).getClass().isArray() == true) { //Need to figure out how to ignore index out of bounds exception here.
				elementIsArray = true;
			}
			if (elementIsArray == true) {
				for (int i = 0; i < set.size(); i++) {
					Object[] iArray = (Object[]) set.get(i);
					if (1 == 1) {	
						for (int j = 0; j < iArray.length; j++) {	
							if (iArray[j].getClass() == Integer.class)
								System.out.print((Integer) iArray[j] + " ");
							if (iArray[j].getClass() == int.class)
								System.out.print((int) iArray[j] + " ");
							if (iArray[j].getClass() == Double.class)
								System.out.print((Double) iArray[j] + " ");
							if (iArray[j].getClass() == double.class)
								System.out.print((double) iArray[j] + " ");
							if (iArray[j].getClass() == long.class)
								System.out.print((long) iArray[j] + " ");
							if (iArray[j].getClass() == Long.class)
								System.out.print((Long) iArray[j] + " ");
							if (iArray[j].getClass() == float.class)
								System.out.print((float) iArray[j] + " ");
							if (iArray[j].getClass() == Float.class)
								System.out.print((Float) iArray[j] + " ");
							
							if (iArray[j].getClass() == String.class)
								System.out.print((String) iArray[j] + " ");
						}
						System.out.println();
					}
				}
			}
			if (elementIsArray == false) {
				System.out.println(Arrays.toString(set.toArray()));
			}
		}
		
	}
}
