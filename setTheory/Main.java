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

		//CombSet compositionSet = new Composition(6);
		//Function lexMinRotation = new Function(compositionSet, new LexMinRotation(), true);
		//compositionSet = lexMinRotation.operate();
		//lexMinRotation.printFullDescription();
		//printSet(compositionSet);
		
		//Domain Set
		CombSet integers = new CombSet(32, 63);
		
		//Elementary Functions
		Function decimalToBinaryRule = new Function(new DecimalToBinary(), true);
		Function binarySequenceToCompositionRule = new Function(new BinarySequenceToComposition(), true);
		Function lexMinRotationRule = new Function(new LexMinRotation(), true);
		
		//Higher Level Function
		Function decimalToComposition = new Function(integers, new Function[2], false);
		decimalToComposition.description = "Converts decimal integers into integer compositions";
		decimalToComposition.rule[0] = decimalToBinaryRule;
		decimalToComposition.rule[1] = binarySequenceToCompositionRule;
		CombSet compositions = decimalToComposition.operate();
		
		Function compositionToLexMinComposition = new Function(compositions, new Function[1], false);
		compositionToLexMinComposition.description = "Returns lexicographically minimal rotation for each composition";
		compositionToLexMinComposition.rule[0] = lexMinRotationRule;
		//decimalToComposition.printFullDescription();
		
		//Even higher level function
		Function decimalToLexMinComposition = new Function(integers,new Function[2],false);
		decimalToLexMinComposition.description = "Converts decimal integers into corresponding lexicographic minimal integer compositions";
		decimalToLexMinComposition.rule[0] = decimalToComposition;
		decimalToLexMinComposition.rule[1] = compositionToLexMinComposition;
		//decimalToLexMinComposition.printFullDescription();
		
		CombSet blah = decimalToLexMinComposition.operate();
		printSet(blah,1);
	}
	
	public static void printSet(CombSet set) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof CombSet) {
				printSet( (CombSet) set.get(i));
				System.out.println();
			}
			else {
				System.out.print(i + ": ");	
				printElement(set.get(i));
				System.out.print(" ");
			}
		}
	}
	public static void printSet(CombSet set, int n) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof CombSet) {
				printSet( (CombSet) set.get(i));
				System.out.println();
			}
			else {
				if (i > 0 && i % n == 0) {
					System.out.println();
				}
				System.out.print(i + ": ");
				printElement(set.get(i));
				System.out.print("  ");
			}
		}
	}
	private static void printElement(Object element) {
		if (element instanceof Object[]) {
			System.out.print(Arrays.toString( (Object[]) element));
		}
		else {
			System.out.print(element + ", ");
		}
	}
}
