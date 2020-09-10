package combinatorics.sets.singletons.matrices;

import combinatorics.core.tools.typing.ElementTyper;

public class IntegerMatrix extends NumericalMatrix{
	
	public IntegerMatrix(Integer[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
	public Integer[][] getValue(){
		return (Integer[][]) ElementTyper.toValue(value);
	}
	
	public void setValue(Integer[][] newValue) {
		setElement(ElementTyper.toElement(newValue));
	}
	
	/*
	public IntegerMatrix getCofactor() {
		
	}
	*/
	
}
