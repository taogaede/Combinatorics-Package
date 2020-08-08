package combinatorics.core.elements;

import combinatorics.core.tools.printing.Printable;
import combinatorics.core.tools.serializing.Serializable;

public interface Element extends Printable, Serializable{	
	
	boolean isEqualTo(Element other);
	void print();
	String getString();
	
	Object getValue();
}
