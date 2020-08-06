package combinatorics.core.elements;

import combinatorics.core.tools.printing.Printable;
import combinatorics.core.tools.serializing.Serializable;

public interface Element extends Printable, Serializable{	
	
	Element add(Element other);
	Element multiply(Element other);
	boolean isEqualTo(Element other);
	boolean isGreaterThan(Element other);
	void print();
	
	Object getValue();
}
