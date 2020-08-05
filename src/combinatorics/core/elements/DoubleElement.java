package combinatorics.core.elements;

import combinatorics.core.Comparer;

public class DoubleElement implements Element {

	private Double value = null;
	
	public DoubleElement() {}
	
	public DoubleElement(Double value) {
		this.value = value;
	}
	
	@Override
	public Element add(Element other) {
		return new DoubleElement( this.getValue() + ((DoubleElement) other).getValue() );
	}

	@Override
	public Element multiply(Element other) {
		return new DoubleElement( this.getValue() * ((DoubleElement) other).getValue() );
	}

	@Override
	public Element concatenate(Element other) {
		String concatenatedDoubles = this.getValue().toString();
		concatenatedDoubles.concat( other.getValue().toString() );
		return new DoubleElement( Double.parseDouble(concatenatedDoubles) );
	}

	@Override
	public boolean isEqualTo(Element other) {
		return Comparer.getIsEqual(this, other);
	}

	@Override
	public boolean isGreaterThan(Element other) {
		if ( this.getValue() > ((DoubleElement) other).getValue()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean canArithmetic() {
		return true;
	}

	@Override
	public void print() { 
		System.out.print(this.value);
		System.out.print(" ");
	}

	public Double getValue() {return this.value;}
	
	public void setValue(Double value) {
		this.value = value;
	}

}
