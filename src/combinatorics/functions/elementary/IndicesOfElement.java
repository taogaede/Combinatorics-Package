package combinatorics.functions.elementary;

import combinatorics.core.elements.*;
import combinatorics.core.math.functions.ElementaryFunction;

public class IndicesOfElement extends ElementaryFunction {

	//Constructor Input(s)
	private Element elementInput;

	//Constructors
	public IndicesOfElement(Integer input){
		this.elementInput = new IntegerElement( input );
		setDescription();
	}
	public IndicesOfElement(String input){
		this.elementInput = new StringElement( input );
		setDescription();
	}
	public IndicesOfElement(Element input) {
		this.elementInput = input;
		setDescription();
	}

	//Operation method	
	protected Element operation(Element input){
		//returns 1 when the input is equal to the chosen element, and 0 otherwise. (when type is identical)
		if (input.isEqualTo(elementInput)) {
			return new IntegerElement(1);
		}
		else {
			return new IntegerElement(0);
		}
	}
	
	//Description setter.
	private void setDescription() {
		description = "Return sequence of indices with element " + this.elementInput.getString();
	}
}
