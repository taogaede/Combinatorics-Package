package combinatorics.core.elements;

public class StringElement implements Element {

	private String value = null;
	
	public StringElement() {}
	
	public StringElement(String value) {
		this.value = value;
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
		System.out.print(this.value);
		System.out.print(" ");
	}

	public String getValue() {return this.value;}
	
	public void setValue(String value) {this.value = value;}

}
