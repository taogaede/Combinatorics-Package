package combinatorics.core.elements;

import combinatorics.core.Comparer;

public class DoubleElement implements Element, Arithmetic {

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
	public void print() { 
		System.out.print(this.value);
		System.out.print(" ");
	}
	
	public String getString() {
		return this.getValue().toString();
	}

	public Double getValue() {return this.value;}
	
	public void setValue(Double value) {
		this.value = value;
	}

}
