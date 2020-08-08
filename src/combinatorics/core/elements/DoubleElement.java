package combinatorics.core.elements;

import combinatorics.core.tools.comparing.Comparer;
import combinatorics.core.math.interfaces.Orderable;

public class DoubleElement implements Element, Orderable, ArithmeticElement{

	private Double value = null;
	
	public DoubleElement() {}
	
	public DoubleElement(Double value) {
		this.value = value;
	}
	
	public ArithmeticElement add(ArithmeticElement other) {
		return new DoubleElement( this.getValue() + ((DoubleElement) other).getValue() );
	}
	public ArithmeticElement subtract(ArithmeticElement other) {
		return new DoubleElement( this.getValue() - ((DoubleElement) other).getValue() );
	}

	public ArithmeticElement multiply(ArithmeticElement other) {
		return new DoubleElement( this.getValue() * ((DoubleElement) other).getValue() );
	}
	
	public ArithmeticElement raisedBy(ArithmeticElement other) {
		return new DoubleElement( Math.pow(this.getValue(), ((DoubleElement) other).getValue() ));
	}

	@Override
	public boolean isEqualTo(Element other) {
		return Comparer.getIsEqual(this, other);
	}

	public Orderable min(Orderable other) {
		return null;
	}
	
	public Orderable max(Orderable other) {
		return null;
	}
	
	@Override
	public boolean isGreaterThan(Orderable other) {
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
