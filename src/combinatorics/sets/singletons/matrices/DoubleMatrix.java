package combinatorics.sets.singletons.matrices;

import combinatorics.core.tools.typing.ElementTyper;

public class DoubleMatrix extends NumericalMatrix{
	
	public DoubleMatrix(Double[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
	public Double[][] getValue(){
		return (Double[][]) ElementTyper.toValue(value);
	}
	
	public void setValue(Double[][] newValue) {
		setElement(ElementTyper.toElement(newValue));
	}
}
