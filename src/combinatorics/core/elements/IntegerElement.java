package combinatorics.core.elements;

import combinatorics.core.Comparer;

public class IntegerElement implements Element{
	
	private Integer singleValue = null;
	private Integer[] sequenceValue = null;
	private Integer[][] matrixValue = null;
	
	public IntegerElement(Integer value) {
		this.singleValue = value;
		this.sequenceValue = null;
		this.matrixValue = null;
	}
	
	public IntegerElement(Integer[] value) {
		this.singleValue = null;
		this.sequenceValue = value;
		this.matrixValue = null;
	}
	
	public IntegerElement(Integer[][] value) {
		this.singleValue = null;
		this.sequenceValue = null;
		this.matrixValue = value;
	}
	
	@Override
	public Element add(Element other) {
		if (other instanceof IntegerElement) {
			Integer otherIntegerValue = ( (IntegerElement) other ).getSingleValue();
			Integer newIntegerValue = this.singleValue + otherIntegerValue;
			IntegerElement sumInteger = new IntegerElement(newIntegerValue);
			return sumInteger;
		}
		return this;
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
	public boolean isGreaterThan(Element other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canArithmetic() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void print() { 
		//print element
		System.out.print("Element: ");
		System.out.print(this.singleValue);
		
		//print sequence
		System.out.print("Sequence: ");
		System.out.print("(");
		for (int i = 0; i < this.sequenceValue.length; i++) {
			System.out.print(this.sequenceValue[i] + " , ");
		}
		System.out.println(")");
		
		//print matrix
		System.out.println("Matrix: ");
		for (int i = 0; i < this.matrixValue.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < this.matrixValue[i].length; j++) {
				System.out.print(this.matrixValue[i][j] + " , ");
			}
			System.out.println();
		}
	}
	
	public void printElement() {
		System.out.print(this.singleValue);
	}
	
	public void printSequence() {
		System.out.print("(");
		for (int i = 0; i < this.sequenceValue.length; i++) {
			System.out.print(this.sequenceValue[i] + " , ");
		}
		System.out.println(")");
	}
	
	public void printMatrix() {
		for (int i = 0; i < this.matrixValue.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < this.matrixValue[i].length; j++) {
				System.out.print(this.matrixValue[i][j] + " , ");
			}
			System.out.println();
		}
	}

	public String getType() {
		if (this.singleValue != null) return "single";
		if (this.sequenceValue != null) return "sequence";
		if (this.matrixValue != null) return "matrix";
		return null;
	}
	
	public Integer getSingleValue() {return this.singleValue;}
	
	public Integer[] getSequenceValue() {return this.sequenceValue;}

	public Integer[][] getMatrixValue() {return this.matrixValue;}
	
	public void setSingleValue(Integer value) {
		this.singleValue = value;
		this.sequenceValue = null;
		this.matrixValue = null;
	}
	
	public void setSequenceValue(Integer[] value) {
		this.singleValue = null;
		this.sequenceValue = value;
		this.matrixValue = null;
	}
	
	public void setMatrixValue(Integer[][] value) {
		this.singleValue = null;
		this.sequenceValue = null;
		this.matrixValue = value;
	}

}
