package setTheory;
import java.util.TreeSet;
import java.util.Iterator;

@SuppressWarnings("serial")
public class CombSet extends TreeSet<Object>{
	
	public int size;
	public Iterator<Object> iterator;
	public CombSet[] subsets;
	
	
	
	
	public CombSet() {
		// TODO Auto-generated constructor stub
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
}
