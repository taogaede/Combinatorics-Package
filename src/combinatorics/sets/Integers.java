package combinatorics.sets;

import combinatorics.core.math.sets.FiniteSet;
import combinatorics.core.elements.IntegerElement;


public class Integers extends FiniteSet{

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
}
