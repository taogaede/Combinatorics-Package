package combinatorics.sets.singletons;

import combinatorics.core.tools.typing.ElementTyper;

public class DoubleMatrix extends Matrix {

	private Double[][] value;
	private Double determinant;
	private boolean isSingular;
	
	public DoubleMatrix(Double[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
	public Double getTrace() {
		Double trace = 0.;
		for (int i = 0; i < this.getValue().length; i++) {
			for (int j = 0; j < this.getValue()[0].length; j++) {
				trace = trace + this.getValue()[i][j];
			}
		}
		return trace;
	}
	
	public Double getDeterminant() {
		
	}
	
	public boolean isSingu
	
	public Double[][] getValue(){
		return this.value;
	}
	
}
