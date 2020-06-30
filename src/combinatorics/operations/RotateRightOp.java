package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class RotateRightOp extends Operation {

	//Operation description
	private String description = "Rotate sequences rightward.";

	//Constructor
	public RotateRightOp() {
	}

	//Operation Methods
	public Element operation(Integer[] set) {
		Integer[] result = new Integer[set.length];
		result[0] = set[set.length - 1];
		for (int i = 0; i < set.length - 1; i++) {
			result[i + 1] = set[i];
		}
		return new IntegerElement(result);
	}
	public Element operation(String[] set) {
		String[] result = new String[set.length];
		result[0] = set[set.length - 1];
		for (int i = 0; i < set.length - 1; i++) {
			result[i + 1] = set[i];
		}
		return new StringElement(result);
	}

	//Description getter
	public String getDescription() {
		return this.description;
	}
}
