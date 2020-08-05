package combinatorics.core;

import combinatorics.Main;
import combinatorics.core.elements.*;

import java.util.ArrayList;

public class CombinatorialSet extends ArrayList<Element> implements Printable{
	
	public CombinatorialSet[] subsets;
	protected ElementTyper elementTyper = new ElementTyper();
	
	public CombinatorialSet() {
	}
	
	public CombinatorialSet(int n) {
		for (int i = 1; i <= n; i++) {
			IntegerElement temp = new IntegerElement(i);
			add(temp);
		}
	}
	
	public CombinatorialSet(int min, int max) {
		for (int i = min; i <= max; i++) {
			IntegerElement temp = new IntegerElement(i);
			add(temp);
		}
	}

	public CombinatorialSet union(CombinatorialSet other) {  //untested
		CombinatorialSet setUnion = new CombinatorialSet();
		for (int i = 0; i < this.size(); i++) {
			setUnion.add(this.get(i));
		}
		for (int i = 0; i < other.size(); i++) {
			setUnion.add(other.get(i));
		}
		return setUnion.removeDuplicates();
	}
	
	public CombinatorialSet intersection(CombinatorialSet other) {  //untested
		CombinatorialSet setIntersection = new CombinatorialSet();
		Comparer comparitron;
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < other.size(); j++) {
				comparitron = new Comparer(this.get(i), other.get(j));
				if (comparitron.getIsEqual() == true) {
					setIntersection.add(this.get(i));
				}
			}
		}
		return setIntersection.removeDuplicates();
	}
	
	public CombinatorialSet complement(CombinatorialSet universe) {  //untested
		for (int i = 0; i < this.size(); i++) {
			if (universe.contains(this.get(i))) {
				universe.remove(this.get(i));
			}
		}
		return universe;
	}
	
	public CombinatorialSet removeElements(CombinatorialSet subtractor) {  //untested
		CombinatorialSet setDifference = new CombinatorialSet();
		for (int i = 0; i < subtractor.size(); i++) {
			this.remove(subtractor.get(i));
		}
		return setDifference;
	}
	
	/* Need good way to do subsets. 
	 * Method below is a random gross recursive thing from the internet.  
	 * I probably could fiddle around with it more to get it to work, but since it will take me a long time to interpret and properly understand it, 
	 * it's likely others using this package would also have a hard time with it too.  Better to keep things as readable as possible for majority.
	 * Worry about efficient algorithms later.
	 */
	
	/*
	private void getSubsets(CombinatorialSet superSet, int k, int index, CombinatorialSet current, ArrayList<CombinatorialSet> solution) {
	    //successful stop clause
	    if (current.size() == k) {
	    	solution.add(current);
	        return;
	    }
	    //unsuccessful stop clause
	    if (index == superSet.size()) {
	    	return;
	    }
	    Object x = superSet.get(index);
	    current.add(x);
	    //"guess" x is in the subset
	    getSubsets(superSet, k, index+1, current, solution);
	    current.remove(x);
	    //"guess" x is not in the subset
	    getSubsets(superSet, k, index+1, current, solution);
	}

	public ArrayList<CombinatorialSet> getSubsets(CombinatorialSet superSet, int k) {
		ArrayList<CombinatorialSet> result = new ArrayList<CombinatorialSet>();
	    getSubsets(superSet, k, 0, new CombinatorialSet(), result);
	    System.out.println();
	    return result;
	}
	
	
	public CombinatorialSet[] allSubsets(CombinatorialSet set) {
		int numberOfSubsets = pow(2 , set.size());
		CombinatorialSet[] subsets = new CombinatorialSet[numberOfSubsets];
		for (int i = 0; i < set.size(); i++) {
			for (int j = 0; j < set.size(); j++) {
				
			}
		}
		
		return subsets;
	}
	
	private int pow(int base, int exponent) {
		int c = 1;
		for(int i = 0; i < exponent; i++) {
			c = c*base;
		}
		return c;
	}
	
	public CombinatorialSet[] kSubsets(CombinatorialSet set, int k) {
		CombinatorialSet[] subsets = allSubsets(set);
		CombinatorialSet[] kSubsets = new CombinatorialSet[0];
		// iterate over subsets and add (append) subsets of size k to kSubsets.
		return kSubsets;
	}
	*/
	public ArrayElement characteristic(CombinatorialSet universe) {
		//returns a binary array in which each index corresponds to an element in universe set.  
		//1 means the element is in this set, while 0 means the element is not in this set.  
		
		IntegerElement[] characteristic = new IntegerElement[universe.size()];
		for (int i = 0; i < universe.size(); i++) {
			for (int j = 0; j < this.size(); j++) {
				if ( universe.get(i).isEqualTo(this.get(j)) ) {
					characteristic[i].setValue(1);
				}
				else {
					characteristic[i].setValue(0);
				}
			}
		}
		return new ArrayElement(characteristic);
	}
	
	public CombinatorialSet removeDuplicates() { 
		Comparer comparitron;
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < this.size(); j++) {
				comparitron = new Comparer(this.get(i),this.get(j));
				if (i != j && comparitron.getIsEqual() == true) {
					this.set(j, null);
				}
			}
		}
		CombinatorialSet newSet = new CombinatorialSet();
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i) != null) {
				newSet.add(this.get(i));
			}
		}
        return newSet;

	}
	
	public void printDescription() {
		
	}
	
	public void print() {
		for (int i = 0; i < this.size(); i++) {
			this.get(i).print();
		}
	}
}
/*
 * CombSet subclasses below.
 * Each newly defined CombSet subclass must have the following components:
 * 
 * 1.	Private initialSet CombSet field.  
 * 		The initial set is a CombSet from which your construction algorithm begins
 * 		
 * 2.	Private initialSetDescription String field.  
 * 		This is a one sentence description of exactly what is contained within the initial set.
 * 		Abstract set notation can also be used as in: {positive integers in [2^(n-1), 2^(n) - 1], where n is also a positive integer}.
 * 
 * 3.	Private constructingFunction Function field.  
 * 		Each step in the construction algorithm will be a less abstract function element in constructingFunction's rule[] array.
 * 		It will be within the CombSet subclass constructor that the rule[] array elements will be defined.
 * 
 * 4.	Private setDescription String field.  
 * 		This field is a one sentence abstract description of exactly what elements are contained within the resulting set of the construction algorithm.
 * 
 * 5.	Private algorithmSource String field.
 * 		This field contains the name of both the author of the algorithm used, as well as a literature, or other acceptable reference source for the algorithm.
 * 
 * 6.	Public constructor(s).
 * 		The constructor method is where the actual construction algorithm takes place, and the manner by which it takes place is as follows:
 * 		1.	Initialize the initialSet.
 *		2.	Build the constructingFunction, one rule at a time:
 *				Step 1.	constructingFunction = new Function(initialSet, new Function(new FirstOperation()));
 *				Step 2.	constructingFunction.addRule(new Function(new SecondOperation()));
 *						...
 *				Step N.	constructingFunction.addRule(new Function(new NthOperation()));
 *		3.	Add the elements to the constructed CombSet using the for loop shown in the below template.
 *
 * 7.	Private supporter methods (if needed).
 * 		If you need any additional methods to assist in initializing the initialSet or for building the constructingFunction, then add them here.
 * 		Try to avoid making supporter methods that transform the elements of the set being constructed, because such behavior should be performed by an Operation subclass, which is then called here.
 * 		If you find that you're building with code that isn't centered around "constructingFunction.addRule(new Function(new SomeOperation()));" 
 * 		then it may be the case that what your writing could be better done by some new operation subclass.
 * 
 * 8.	Public printDescription method.
 * 		This method overrides a CombSet method.  This method prints all the relevant details your new CombSet subclass' construction.
 * 		You can use the template's printDescription method as is, unless you would like to add or remove anything.  
 * 

//					BEGIN TEMPLATE

class YourCombSet extends CombSet{

	//Initial set on which the construction begins
	private CombSet initialSet;
	
	//Initial set description
	private String initialSetDescription = "";
	
	//The function that performs the construction algorithm
	private Function constructingFunction;
	
	//Description of the set that results from the algorithm
	private String setDescription = ""
	
	//Author of the algorithm, as well as a reference (if applicable)
	private String algorithmSource = "Author(s): ..." + " --- Reference: ";
	
	//Constructor method(s).
	public YourCombSet(){
		//Initialize initialSet and constructingFunction;
		//Build constructingFunction;
		
		//Add the resulting elements from the constructingFunction acting on initialSet to the YourCombSet instance that the constructor creates:
		CombSet newSet = constructingFunction.operate();
		for (int i = 0; i < newSet.size(); i++) {
			add(newSet.get(i));
		}
	}
	
	//Any private supporter methods needed by constructor method(s)
	
	//Printer method that displays aspects of the set's construction when called
	public void printDescription() { 
		System.out.println("Set Description: " + setDescription);
		System.out.println();
		System.out.println("Set Construction:");
		System.out.print("Initial Set: " + initialSetDescription);
		constructingFunction.printFullDescription();
		System.out.println(algorithmSource);
	}
}

//					END TEMPLATE
*/

