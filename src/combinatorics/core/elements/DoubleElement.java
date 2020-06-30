package combinatorics.core.elements;

public class DoubleElement implements Element {

	private Double singleValue = null;
	private Double[] sequenceValue = null;
	private Double[][] matrixValue = null;
	
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
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub

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
