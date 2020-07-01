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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element multiply(Element other) { //cross product for sequences and matrix multiplication for matrices
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element concatenate(Element other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqualTo(Element other) {
		return (new Comparer(this, other)).getIsEqual();
	}

	@Override
	public boolean isGreaterThan(Element other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canArithmetic() {
		return true;
	}

	@Override
	public void print() { 
		System.out.print(this.value);
	}

	public Double getValue() {return this.value;}
	
	public void setValue(Double value) {
		this.value = value;
	}

}
