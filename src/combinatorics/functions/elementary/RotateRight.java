package combinatorics.functions.elementary;

import combinatorics.core.elements.*;
import combinatorics.core.math.functions.ElementaryFunction;

public class RotateRight extends ElementaryFunction {

	//Constructor
	public RotateRight() {
		setDescription();
	}

	//Operation method
	public Element operation(Element input) {
		ArrayElement inputArray = (ArrayElement) input;
		Element[] result = new Element[inputArray.getValue().length];
		result[0] = inputArray.getValue()[inputArray.getValue().length - 1];
		for (int i = 0; i < inputArray.getValue().length - 1; i++) {
			result[i + 1] = inputArray.getValue()[i];
		}
		return new ArrayElement(result);
	}

	//Description setter
	private void setDescription() {
		description = "Rotate sequences rightward.";
	}
}
