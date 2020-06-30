package combinatorics.core.elements;

public class DoubleElement implements Element {

	private Double singleValue = null;
	private Double[] sequenceValue = null;
	private Double[][] matrixValue = null;
	
	public DoubleElement() {}
	
	public DoubleElement(Double value) {
		this.singleValue = value;
		this.sequenceValue = null;
		this.matrixValue = null;
	}
	
	public DoubleElement(Double[] value) {	
		this.singleValue = null;
		this.sequenceValue = value;
		this.matrixValue = null;
	}
	
	public DoubleElement(Double[][] value) {
		this.singleValue = null;
		this.sequenceValue = null;
		this.matrixValue = value;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreaterThan(Element other) {	//use lex ordering for arrays and matrices
		// TODO Auto-generated method stub
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

	public Double getSingleValue() {return this.singleValue;}
	
	public Double[] getSequenceValue() {return this.sequenceValue;}

	public Double[][] getMatrixValue() {return this.matrixValue;}
	
	public void setSingleValue(Double value) {
		this.singleValue = value;
		this.sequenceValue = null;
		this.matrixValue = null;
	}
	
	public void setSequenceValue(Double[] value) {
		this.singleValue = null;
		this.sequenceValue = value;
		this.matrixValue = null;
	}
	
	public void setMatrixValue(Double[][] value) {
		this.singleValue = null;
		this.sequenceValue = null;
		this.matrixValue = value;
	}

}
