package combinatorics.core.elements;

import combinatorics.core.Printable;

public interface Element extends Printable{	
	
	Element add(Element other);
	Element multiply(Element other);
	Element concatenate(Element other);
	boolean isEqualTo(Element other);
	boolean isGreaterThan(Element other);
	boolean canArithmetic();
	void print();
	
	Object getValue();
}
