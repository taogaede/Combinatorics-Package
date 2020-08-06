package combinatorics.core.elements;

import combinatorics.core.Printable;
import combinatorics.core.Serializable;

public interface Element extends Printable, Serializable{	
	
	Element add(Element other);
	Element multiply(Element other);
	boolean isEqualTo(Element other);
	boolean isGreaterThan(Element other);
	void print();
	
	Object getValue();
}
