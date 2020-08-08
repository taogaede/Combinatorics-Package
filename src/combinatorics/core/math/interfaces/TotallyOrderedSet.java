package combinatorics.core.math.interfaces;

import combinatorics.core.elements.Element;

public interface TotallyOrderedSet extends PartiallyOrderedSet {

	public Element min();
	public Element max();
	
}
