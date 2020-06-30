package combinatorics.core.elements;

public class StringElement implements Element {

	private String singleValue = null;
	private String[] sequenceValue = null;
	private String[][] matrixValue = null;
	
	public StringElement(String value) {
		this.singleValue = value;
		this.sequenceValue = null;
		this.matrixValue = null;
	}
	
	public StringElement(String[] value) {
		this.singleValue = null;
		this.sequenceValue = value;
		this.matrixValue = null;
	}
	
	public StringElement(String[][] value) {
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

	public String getSingleValue() {return this.singleValue;}
	
	public String[] getSequenceValue() {return this.sequenceValue;}

	public String[][] getMatrixValue() {return this.matrixValue;}
	
	public void setSingleValue(String value) {
		this.singleValue = value;
		this.sequenceValue = null;
		this.matrixValue = null;
	}
	
	public void setSequenceValue(String[] value) {
		this.singleValue = null;
		this.sequenceValue = value;
		this.matrixValue = null;
	}
	
	public void setMatrixValue(String[][] value) {
		this.singleValue = null;
		this.sequenceValue = null;
		this.matrixValue = value;
	}

}
