package combinatorics.sets.singletons.matrices;

import combinatorics.core.elements.ArrayElement;
import combinatorics.core.tools.typing.ElementTyper;
import combinatorics.core.elements.DoubleElement;
import combinatorics.core.math.sets.SingletonSet;
import combinatorics.core.elements.ArithmeticElement;
import combinatorics.functions.elementary.Determinant;
import combinatorics.functions.elementary.Trace;

public class NumericalMatrix extends Matrix {
	
	public Double getTrace() {
		Trace trace = new Trace();
		trace.setDomain(this);
		return (Double) ElementTyper.toValue(trace.operate().get(0));
	}
	
	public Double getDeterminant() {
		Determinant det = new Determinant();
		det.setDomain(this);
		return (Double) ElementTyper.toValue(det.operate().get(0));
	}
	
	public boolean isSingular() {
		if (getDeterminant() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public NumericalMatrix getInverse() {
		return null;
	}
	
}
