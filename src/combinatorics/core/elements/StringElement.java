package combinatorics.core.elements;

import java.util.stream.*;

import combinatorics.core.math.interfaces.Word;
import combinatorics.core.tools.comparing.Comparer;

public class StringElement implements Element, Word {

	private String value = null;
	
	public StringElement() {}
	
	public StringElement(String value) {
		this.value = value;
	}
	
	@Override
	public Element add(Element other) {
		return this;
	}

	@Override
	public Element multiply(Element other) {
		return this;
	}

	@Override
	public Word concatenate(Word other) {
		return new StringElement( this.getValue().concat( ((StringElement) other).getValue()) );
	}

	@Override
	public boolean isEqualTo(Element other) {
		return Comparer.getIsEqual(this, other);
	}

	@Override
	public boolean isGreaterThan(Element other) {
		String[] stringArray = new String[2];
		stringArray[0] = this.getValue();
		stringArray[1] = ((StringElement) other).getValue();
		stringArray = Stream.of(stringArray).sorted().toArray(String[]::new);
		if (this.getValue() == stringArray[0]) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void print() { 
		System.out.print(this.value);
		System.out.print(" ");
	}
	
	public String getString() {
		return this.getValue();
	}

	public String getValue() {return this.value;}
	
	public void setValue(String value) {this.value = value;}

	public Integer length() {
		return this.getValue().length();
	}
	public Integer numberOfDistinctSymbols() {
		return null;
	}
	public boolean isPalindrome() {
		return false;
	}
	public Word getLexMinRotation() {
		return null;
	}
	public Word getLexMinPermutation() {
		return null;
	}
	
}
