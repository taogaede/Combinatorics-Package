package combPackage;

import java.util.Arrays;

/*
 * Workflow:
 * 
 * 1.	Define an initial CombSet (combinatorial set).  For example, a subset of integers.
 * 
 * 2.	Define elementary functions that will operate on the initial combSet to create a desired combSet using Operation subclasses (like converting decimal integers to binary sequences with the DecimalToBinary).
 * 			If the operation you need doesn't exist as an Operation subclass, consider making it yourself (using the template) and appending it to Operation.java
 * 
 * 3.	Once you have defined some elementary functions, you can define a new function that is the composition of these elementary ones. 
 * 			You can then use this new single function to create your desired CombSet.
 * 
 * 4.	Repeat step 2 until you have the desired domain combSet for your researching needs.  
 * 			To make it easier to find this set in the future, consider creating a CombSet subclass and include your construction algorithm in the subclass constructor (see the Composition class below).
 * 			Append your CombSet subclass code to the CombSet.java file.
 * 
 * 5.	Once you have your desired CombSet, you can use the CombSet methods to find various properties about this set.
 * 			- eg. getSubsets(), getKSubsets(), getCharacteristic(CombSet universe), size(), etc
 * 
 * 6.	There is no limit to the abstraction or quantity of functions contained within a single larger function.
 * 			So, ideally you can create various functions with which to study your and related sets without getting bogged down by the details of each functional step in your process. 
 * 			As with Operations and CombSets, if you come up with a useful/interesting Function consisting of multiple many subfunctions,
 * 			be sure to include it below as a subclass, so it can be called simply in the future.  (append your Function subclass to Function.java).
 * 			
 * Note on including new subclasses:
 * 		To prevent bugs, and ensure that this package is understandable to everyone, be sure to follow the respective templates in each of the .java files.
 */

public class Main {

	public static void main(String[] args) {
		//Domain Set
		/*
		CombSet integers = new CombSet(32, 63);
		Function coolio = new Function(integers,new Add(2));
		coolio.addRule(new Function(new Add(-5)));
		printSet(coolio.operate(), 4);
		*/
		
		CombSet compositions8 = new Composition(8);
		Function indicesOf3 = new Function(compositions8, new IndicesOfElement(3));
		
		Function lexMin = new Function(compositions8, new LexMinRotation());
		compositions8 = lexMin.operate();
		for (int i = 0; i < 2; i++) {
			lexMin.addRule(new Function(new RotateRight()));
		}
		CombSet newSet = lexMin.operate();
		lexMin.addRule(new Function(new Add(4)));
		printSet(compositions8,lexMin.operate(),1);
		
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
		System.out.println();
	}
	public static void printSet(CombSet set, CombSet set2) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof CombSet) {
				printSet( (CombSet) set.get(i));
				System.out.println();
			}
			else {
				System.out.print(i + ": ");	
				printElement(set.get(i)); System.out.print("	-->	");printElement(set2.get(i));
				System.out.print(" ");
			}
		}
		System.out.println();
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
		System.out.println();
	}
	public static void printSet(CombSet set, CombSet set2, int n) {
		if (set.size() != set2.size()) {
			System.out.println("Sets not of equal size.");
			return;
		}
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
				printElement(set.get(i)); System.out.print(" --> ");printElement(set2.get(i));
				System.out.print("  ");
			}
		}
		System.out.println();
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