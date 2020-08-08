package combinatorics.sets.singletons.matrices;

import combinatorics.core.tools.typing.ElementTyper;
import combinatorics.sets.singletons.matrices.tools.DeterminantCalculator;

public class IntegerMatrix extends NumberMatrix{
	
	protected Integer[][] matrixValue = (Integer[][]) this.getValue();
	
	public IntegerMatrix(Integer[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
	public Integer[][] getValue(){
		return matrixValue;
	}
	
}
