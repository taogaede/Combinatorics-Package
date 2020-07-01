package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class AddOp extends Operation {

	//Input
	private Element otherInput;

	//Description
	private String description = ""; //(See constructors)

	//Constructors, where "n" is the number added.
	public AddOp(Integer n) {
		this.otherInput = new IntegerElement(n);
		this.description = "Add number " + n + " to set element.";
	}
	public AddOp(Double n) {
		this.otherInput = new DoubleElement(n);
		this.description = "Add number " + n + " to set element.";
	}
	
	//Operation method
	public Element operation(Element input) {
		return input.add(otherInput);
	}

	//Description getter
	public String getDescription() {
		return this.description;
	}
}
