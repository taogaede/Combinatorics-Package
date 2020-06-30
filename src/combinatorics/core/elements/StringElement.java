package combinatorics.core.elements;

public class StringElement implements Element {

	private String singleValue = null;
	private String[] sequenceValue = null;
	private String[][] matrixValue = null;
	
	public StringElement() {}
	
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
	public Element add(Element other) { //do nothing
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element multiply(Element other) { //do nothing
		return this;
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
	public boolean isGreaterThan(Element other) { //Use lex ordering here
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canArithmetic() {
		return false;
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
