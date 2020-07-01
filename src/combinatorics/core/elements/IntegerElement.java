package combinatorics.core.elements;

import combinatorics.core.Comparer;

public class IntegerElement implements Element{
	
	private Integer value = null;
	
	public IntegerElement() {}
	
	public IntegerElement(Integer value) {
		this.value = value;
	}
	
	@Override
	public Element add(Element other) {
		Integer otherIntegerValue = ( (IntegerElement) other ).getValue();
		Integer newIntegerValue = this.value + otherIntegerValue;
		IntegerElement sumInteger = new IntegerElement(newIntegerValue);
		return sumInteger;
	}

	@Override
	public Element multiply(Element other) {
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
	public boolean isGreaterThan(Element other) { //use lex ordering for arrays and matrices
		
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
	
	public Integer getValue() {return this.value;}
	
	public void setValue(Integer value) {this.value = value;}

}
