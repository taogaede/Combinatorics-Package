package combinatorics.core.elements;

import combinatorics.core.Comparer;

public class IntegerElement implements Element, Arithmetic, Word{
	
	private Integer value = null;
	
	public IntegerElement() {}
	
	public IntegerElement(Integer value) {
		this.value = value;
	}
	
	@Override
	public Element add(Element other) {
		IntegerElement castedOther = (IntegerElement) other;
		return new IntegerElement( this.getValue() + castedOther.getValue() );
	}

	@Override
	public Element multiply(Element other) {
		IntegerElement castedOther = (IntegerElement) other;
		return new IntegerElement( this.getValue() * castedOther.getValue() );
	}

	@Override
	public Word concatenate(Word other) {
		String concatenatedIntegers = this.getValue().toString();
		concatenatedIntegers.concat( other.getValue().toString() );
		return new IntegerElement( Integer.parseInt(concatenatedIntegers) );
	}

	@Override
	public boolean isEqualTo(Element other) {
		return Comparer.getIsEqual(this, other);
	}

	@Override
	public boolean isGreaterThan(Element other) {
		if ( this.getValue() > ((IntegerElement) other).getValue()) {
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
		return this.getValue().toString();
	}
	
	public Integer getValue() {return this.value;}
	
	public void setValue(Integer value) {this.value = value;}

	public Integer length() {
		return this.getValue().toString().length();
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
