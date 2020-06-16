package setTheory;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
public class CombSet extends ArrayList<Object>{
	
	public int size;
	public Iterator<Object> iterator;
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
			CombSet intHolder = new CombSet();
			intHolder.add(i);
			add(intHolder);
		}
	}
}

class Composition extends CombSet{
	public Composition(int weight) {
		CombSet decimalSet = new CombSet(pow(2,weight - 1), pow(2,weight) - 1);
		Function toComposition = new Function(decimalSet, new Function[2],false);
		toComposition.rule[0] = new Function(new DecimalToBinary(),true);
		toComposition.rule[1] = new Function(new BinarySequenceToComposition(),true);
		CombSet newSet = toComposition.operate();
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
}