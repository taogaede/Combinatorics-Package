package combinatorics.sets.singletons.matrices;

import combinatorics.core.tools.typing.ElementTyper;
import combinatorics.sets.singletons.matrices.tools.DeterminantCalculator;

public class DoubleMatrix extends NumberMatrix{
	
	public DoubleMatrix(Double[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
	public Double[][] getValue(){
		return (Double[][]) ElementTyper.toValue(value);
	}
	
}
