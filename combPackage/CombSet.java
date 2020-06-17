package combPackage;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class CombSet extends ArrayList<Object>{
	
	public CombSet[] subsets;	
	
	public CombSet() {
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
	public void printDescription() {
		
	}
}

@SuppressWarnings("serial")
class Composition extends CombSet{
	private Function constructingFunction;
	private CombSet initialSet;
	private String initialSetDescription = "{integers in [2^(n - 1), 2^(n) - 1]}";
	private String algorithmSource = "Author(s): Tao Gaede" + " --- Reference: ";
	
	public Composition(int weight) {
		initialSet = new CombSet(pow(2,weight - 1), pow(2,weight) - 1);
		constructingFunction = new Function(initialSet, new Function[2]);
		constructingFunction.rule[0] = new Function(new DecimalToBinary());
		constructingFunction.rule[1] = new Function(new BinarySequenceToComposition());
		CombSet newSet = constructingFunction.operate();
		for (int i = 0; i < newSet.size(); i++) {
			add(newSet.get(i));
		}
	}
	
	private int pow(int base, int exponent) {
		int c = 1;
		for(int i = 0; i < exponent; i++) {
			c = c*base;
		}
		return c;
	}
	public void printDescription() { 
		System.out.println("Construction of Composition(n) set:");
		System.out.print("Initial Set: " + initialSetDescription);
		constructingFunction.printFullDescription();
		System.out.println(algorithmSource);
	}
}