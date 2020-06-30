package combinatorics.core.elements;

import combinatorics.core.Comparer;

public class IntegerElement implements Element{
	
	private Integer singleValue = null;
	private Integer[] sequenceValue = null;
	private Integer[][] matrixValue = null;
	
	public IntegerElement() {}
	
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
	public Element add(Element other) {  //elementwise add for sequences and matrices.  Always add to largest within pair.
		if (other instanceof IntegerElement) {
			Integer otherIntegerValue = ( (IntegerElement) other ).getSingleValue();
			Integer newIntegerValue = this.singleValue + otherIntegerValue;
			IntegerElement sumInteger = new IntegerElement(newIntegerValue);
			return sumInteger;
		}
		return this;
	}

	@Override
	public Element multiply(Element other) { //dot product for sequences and matrix multiplication for matrices
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
		if (this.getType() == "single") {
			return (new Comparer(this.getSingleValue(), other.getSingleValue())).getIsEqual();
		}
		if (this.getType() == "sequence") {
			return (new Comparer(this.getSequenceValue(), other.getSequenceValue())).getIsEqual();
		}
		if (this.getType() == "matrix") {
			return (new Comparer(this.getMatrixValue(), other.getMatrixValue())).getIsEqual();
		}
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
		//print element
		if (this.getType() == "single") System.out.print(this.singleValue);
		//print sequence
		if (this.getType() == "sequence") {
			System.out.print("(");
			for (int i = 0; i < this.sequenceValue.length - 1; i++) {
				System.out.print(this.sequenceValue[i] + ", ");
			}
			System.out.print(this.sequenceValue[this.sequenceValue.length - 1]);
			System.out.print(")");
		}
		//print matrix
		if (this.getType() == "matrix") {	
			for (int i = 0; i < this.matrixValue.length; i++) {
				System.out.print("| ");
				for (int j = 0; j < this.matrixValue[i].length; j++) {
					System.out.print(this.matrixValue[i][j] + " , ");
				}
				System.out.println();
			}
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
