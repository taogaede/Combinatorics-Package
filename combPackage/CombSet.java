package combPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class CombSet extends ArrayList<Object>{
	
	public CombSet[] subsets;	
	
	public CombSet() {
	}
	
	public CombSet(int n) {
		for (int i = 1; i <= n; i++) {
			add(i);
		}
	}
	
	public CombSet(int min, int max) {
		for (int i = min; i <= max; i++) {
			add(i);
		}
	}

	public CombSet union(CombSet[] sets) {
		CombSet setUnion = new CombSet();
		//
		return setUnion;
	}
	
	public CombSet intersection(CombSet[] sets) {
		CombSet setIntersection = new CombSet();
		//
		return setIntersection;
	}
	
	public CombSet complement(CombSet set, CombSet universe) {
		CombSet setComplement = new CombSet();
		//
		return setComplement;
	}
	
	public CombSet difference(CombSet subtractee, CombSet subtractor) {
		CombSet setDifference = new CombSet();
		//
		return setDifference;
	}
	
	public CombSet[] allSubsets(CombSet set) {
		CombSet[] subsets = new CombSet[set.size()];
		//
		return subsets;
	}
	
	public CombSet[] kSubsets(CombSet set, int k) {
		CombSet[] subsets = allSubsets(set);
		CombSet[] kSubsets = new CombSet[0];
		// iterate over subsets and add (append) subsets of size k to kSubsets.
		return kSubsets;
	}
	
	public int[] characteristic(CombSet set, CombSet universe) {
		//returns a binary array in which each index corresponds to an element in universe set.  
		//1 means the element at its index is in subset, while 0 means the element at its index is not in subset.  
		//NOTE: The first argument need not be a subset of the second, since the method only checks for element inclusion.  
		
		Object[] array = universe.toArray();
		int[] binaryArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (set.contains(array[i])) {
				binaryArray[i] = 1;
			}
			else {
				binaryArray[i] = 0;
			}
		}
		return binaryArray;
	}
	
	public CombSet removeDuplicates() { 
		CombSet set = new CombSet();
        // Add the elements to set 
		for (int i = 0; i < this.size(); i++) {
			
			if (this.get(i) instanceof Integer) {
				set.add( (Integer) this.get(i));
			}
			if (this.get(i) instanceof Integer[]) {
				Integer[] temp = (Integer[]) this.get(i);
				this.set(i, null);
				if (this.contains( (Integer[]) temp)) {
					this.set(this.indexOf( (Integer[]) temp), null);
				}
				set.add( (Integer[]) temp);
			}
			if (this.get(i) instanceof Integer[][]) {
				set.add( (Integer[][]) this.get(i));
			}
			if (this.get(i) instanceof Double) {
				set.add( (Double) this.get(i));
			}
			if (this.get(i) instanceof Double[]) {
				set.add( (Double[]) this.get(i));
			}
			if (this.get(i) instanceof Double[][]) {
				set.add( (Double[][]) this.get(i));
			}
			if (this.get(i) instanceof String) {
				set.add( (String) this.get(i));
			}
			if (this.get(i) instanceof String[]) {
				set.add( (String[]) this.get(i));
			}
			if (this.get(i) instanceof String[][]) {
				set.add( (String[][]) this.get(i));
			}
		} 
  
        // Clear the list 
        this.clear(); 
  
        // add the elements of set 
        // with no duplicates to the list 
        this.addAll(set); 
        
        return this;

	}
	
	
	public void printDescription() {
		
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

class Composition extends CombSet{
	
	private Integer weight;
	private CombSet initialSet;
	private Function constructingFunction;
	private String initialSetDescription = "{integers in [2^(" + this.weight + " - 1), 2^(" + this.weight + ") - 1]}";
	private String algorithmSource = "Author(s): Tao Gaede" + " --- Reference: ";
	
	public Composition(Integer weight) {
		this.weight = weight;
		initialSet = new CombSet(pow(2,this.weight - 1), pow(2,this.weight) - 1);
		
		constructingFunction = new Function(initialSet, new Function[1]);
		
		constructingFunction.rule[0] = new CompositionMaker();
		
		addAll(constructingFunction.operate());
	}
	
	private int pow(int base, int exponent) {
		int c = 1;
		for(int i = 0; i < exponent; i++) {
			c = c*base;
		}
		return c;
	}
	public void printDescription() { 
		System.out.println("Construction of integer compositions of " + this.weight);
		System.out.print("Initial Set: " + initialSetDescription);
		constructingFunction.printFullDescription();
		System.out.println(algorithmSource);
	}
}