package combinatorics.sets.singletons.matrices;

import combinatorics.core.tools.typing.ElementTyper;

public class StringMatrix extends Matrix {

	private String[][] value;
	
	public StringMatrix(String[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
	public String[][] getValue(){
		return value;
	}
	
}
