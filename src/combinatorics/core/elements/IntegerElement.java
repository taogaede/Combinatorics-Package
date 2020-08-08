package combinatorics.core.elements;

import combinatorics.core.math.interfaces.Word;
import combinatorics.core.tools.comparing.Comparer;
import combinatorics.core.math.interfaces.Orderable;

public class IntegerElement implements Element, Word, Orderable, ArithmeticElement{
	
	private Integer value = null;
	
	public IntegerElement() {}
	
	public IntegerElement(Integer value) {
		this.value = value;
	}
	
	public ArithmeticElement add(ArithmeticElement other) {
		IntegerElement castedOther = (IntegerElement) other;
		return new IntegerElement( this.getValue() + castedOther.getValue() );
	}
	public ArithmeticElement subtract(ArithmeticElement other) {
		IntegerElement castedOther = (IntegerElement) other;
		return new IntegerElement( this.getValue() - castedOther.getValue() );
	}

	public ArithmeticElement multiply(ArithmeticElement other) {
		IntegerElement castedOther = (IntegerElement) other;
		return new IntegerElement( this.getValue() * castedOther.getValue() );
	}
	
	public ArithmeticElement divide(ArithmeticElement other) {
		IntegerElement castedOther = (IntegerElement) other;
		return new IntegerElement( this.getValue() / castedOther.getValue() );
	}

	public boolean isCoprime(IntegerElement other) {//NTI
		return false;
	}
	
	public boolean isPrime() {//NTI
		return false;
	}
	
	public boolean isEven() {//NTI
		return false;
	}
	
	public IntegerElement greatestCommonDivisor(IntegerElement other) {//NTI
		return null;
	}
	
	public IntegerElement lowestCommonMultiple(IntegerElement other) {//NTI
		return null;
	}
	
	public boolean divides(IntegerElement other) {//NTI
		return false;
	}
	
	public ArithmeticElement raisedBy(ArithmeticElement other) {
		Integer base = ((IntegerElement) this).value;
		Integer exponent = ((IntegerElement) other).getValue();
		Integer result = 1;
		for (int i = 0; i < exponent; i++) {
			result = result*base;
		}
		return new IntegerElement(result);
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
	public boolean isGreaterThan(Orderable other) {
		if ( this.getValue() > ((IntegerElement) other).getValue()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Orderable min(Orderable other) {
		if (this.isGreaterThan(other)) {
			return this;
		}
		else {
			return other;
		}
	}
	public Orderable max(Orderable other) {
		if (this.isGreaterThan(other)) {
			return other;
		}
		else {
			return this;
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
	public Integer numberOfDistinctSymbols() {//NTI
		return null;
	}
	public boolean isPalindrome() {//NTI
		return false;
	}
	public Word getLexMinRotation() {//NTI
		return null;
	}
	public Word getLexMinPermutation() {//NTI
		return null;
	}
	
}
