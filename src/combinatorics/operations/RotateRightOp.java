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
	public Element operation(ArrayElement input) {
		Element[] result = new Element[input.getValue().length];
		result[0] = input.getValue()[input.getValue().length - 1];
		for (int i = 0; i < input.getValue().length - 1; i++) {
			result[i + 1] = input.getValue()[i];
		}
		return new ArrayElement(result);
	}

	//Description getter
	public String getDescription() {
		return this.description;
	}
}
