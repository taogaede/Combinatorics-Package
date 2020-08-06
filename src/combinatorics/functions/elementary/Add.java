package combinatorics.functions.elementary;

import combinatorics.core.elements.*;
import combinatorics.core.ElementaryFunction;

public class Add extends ElementaryFunction{

	//Constructor input
	private Element otherInput;

	//Constructors, where "n" is the number added.
	public Add(Integer n) {
		this.otherInput = new IntegerElement(n);
		setDescription(n);
	}
	public Add(Double n) {
		this.otherInput = new DoubleElement(n);
		setDescription(n);
	}
	
	//Operation method
	public Element operation(Element input) {
		return input.add(otherInput);
	}

	//Description setters
	private void setDescription(Integer n) {
		description = "Add number " + n + " to set element.";
	}
	private void setDescription(Double n) {
		description = "Add number " + n + " to set element.";
	}
}
