package combinatorics.sets.singletons.matrices;

import combinatorics.core.tools.typing.ElementTyper;

public class StringMatrix extends Matrix {
	
	public StringMatrix(String[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
	public String[][] getValue(){
		return (String[][]) ElementTyper.toValue(value);
	}
	
	public void setValue(String[][] newValue) {
		setElement(ElementTyper.toElement(newValue));
	}
	
}
