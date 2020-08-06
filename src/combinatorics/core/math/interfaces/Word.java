package combinatorics.core.math.interfaces;

import combinatorics.core.elements.Element;

public interface Word extends Element {
	
	public Word concatenate(Word other);
	public Integer length();
	public Integer numberOfDistinctSymbols();
	public boolean isPalindrome();
	public Word getLexMinRotation();
	public Word getLexMinPermutation();
}
