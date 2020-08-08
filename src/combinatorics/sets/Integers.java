package combinatorics.sets;

import combinatorics.core.math.sets.FiniteSet;
import combinatorics.core.math.interfaces.PartiallyOrderedSet;
import combinatorics.core.math.interfaces.TotallyOrderedSet;
import combinatorics.core.elements.IntegerElement;
import combinatorics.core.elements.Element;


public class Integers extends FiniteSet implements TotallyOrderedSet{

	public Integers(Integer n) {
		for (int i = 1; i <= n; i++) {
			IntegerElement temp = new IntegerElement(i);
			add(temp);
		}
	}
	
	public Integers(Integer min, Integer max) {
		for (int i = min; i <= max; i++) {
			IntegerElement temp = new IntegerElement(i);
			add(temp);
		}
	}
	
	public boolean isGreaterThan(Element first, Element second) {
		return false;
	}
	public IntegerElement min() {
		return null;
	}
	public IntegerElement max() {
		return null;
	}
	/*
	public IntegerElement min() {
		IntegerElement min;
		for (int i = 0; i < this.size(); i++) {
			for (int j = i; j < this.size(); j++) {
				if ()
			}
		}
	}
	*/
}
