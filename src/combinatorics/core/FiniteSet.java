package combinatorics.core;

import combinatorics.Main;
import combinatorics.core.elements.*;

import java.util.ArrayList;

public class FiniteSet extends ArrayList<Element> implements Printable{
	
	public FiniteSet[] subsets;
	
	public FiniteSet() {
	}
	
	public FiniteSet(int n) {
		for (int i = 1; i <= n; i++) {
			IntegerElement temp = new IntegerElement(i);
			add(temp);
		}
	}
	
	public FiniteSet(int min, int max) {
		for (int i = min; i <= max; i++) {
			IntegerElement temp = new IntegerElement(i);
			add(temp);
		}
	}

	public FiniteSet union(FiniteSet other) {  //untested
		FiniteSet setUnion = new FiniteSet();
		for (int i = 0; i < this.size(); i++) {
			setUnion.add(this.get(i));
		}
		for (int i = 0; i < other.size(); i++) {
			setUnion.add(other.get(i));
		}
		return setUnion.removeDuplicates();
	}
	
	public FiniteSet intersection(FiniteSet other) {  //untested
		FiniteSet setIntersection = new FiniteSet();
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < other.size(); j++) {
				if (Comparer.getIsEqual(this.get(i), other.get(j)) == true) {
					setIntersection.add(this.get(i));
				}
			}
		}
		return setIntersection.removeDuplicates();
	}
	
	public FiniteSet complement(FiniteSet universe) {  //untested
		for (int i = 0; i < this.size(); i++) {
			if (universe.contains(this.get(i))) {
				universe.remove(this.get(i));
			}
		}
		return universe;
	}
	
	public FiniteSet removeElements(FiniteSet subtractor) {  //untested
		FiniteSet setDifference = new FiniteSet();
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
	public ArrayElement characteristic(FiniteSet universe) {
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
	
	public FiniteSet removeDuplicates() { 
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < this.size(); j++) {
				if (i != j && Comparer.getIsEqual(this.get(i),this.get(j)) == true) {
					this.set(j, null);
				}
			}
		}
		FiniteSet newSet = new FiniteSet();
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