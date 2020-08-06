package combinatorics.core.math.sets;

import combinatorics.Main;
import combinatorics.core.elements.*;
import combinatorics.core.tools.comparing.Comparer;
import combinatorics.core.tools.printing.Printable;

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

	public void print() {
		for (int i = 0; i < this.size(); i++) {
			this.get(i).print();
		}
	}
}