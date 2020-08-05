package combinatorics.core.elements;

import combinatorics.core.Printable;

public interface Element extends Printable{	
	
	Element add(Element other);
	Element multiply(Element other);
	boolean isEqualTo(Element other);
	boolean isGreaterThan(Element other);
	void print();
	
	Object getValue();
}
