package combinatorics.functions.elementary;

import combinatorics.core.elements.*;
import combinatorics.core.math.functions.ElementaryFunction;
import combinatorics.core.tools.typing.ElementTyper;

public class Add extends ElementaryFunction{

	//Constructor input
	protected Element otherInput;

	protected Add() {}
	
	//Constructors, where "n" is the number added.
	public Add(Integer n) {
		new AddInteger(n);
		setDescription(n);
	}
	public Add(Double n) {
		new AddDouble(n);
		setDescription(n);
	}
	
	//Operation method
	public Element operation(Element input) {
		return null;
	}
	
	//Description setters
	private void setDescription(Integer n) {
		description = "Add number " + n + " to set element.";
	}
	private void setDescription(Double n) {
		description = "Add number " + n + " to set element.";
	}
}

class AddInteger extends Add{
	protected AddInteger(Integer n) {
		this.otherInput = new IntegerElement(n);
	}
	public Element operation(Element input) {
		return ((IntegerElement) input).add( (IntegerElement) otherInput);
	}
}

class AddDouble extends Add{
	protected AddDouble(Double n) {
		this.otherInput = new DoubleElement(n);
	}
	public Element operation(Element input) {
		return ((DoubleElement) input).add( (DoubleElement) otherInput);
	}
}
