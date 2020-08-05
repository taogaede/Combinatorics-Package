package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class IndicesOfElementOp extends Operation {

	private Element elementInput;

	//Operation description
	private String description = "Return sequence of indices with element " + this.elementInput;

	//Constructors
	public IndicesOfElementOp(Integer input){
		
		this.elementInput = new IntegerElement( input );
	}
	public IndicesOfElementOp(String input){
		this.elementInput = new StringElement( input );
	}
	public IndicesOfElementOp(Element input) {
		this.elementInput = input;
	}

	//Operation method	
	public Element operation(Element input){
		//returns 1 when the input is equal to the chosen element, and 0 otherwise. (when type is identical)
		if (input.isEqualTo(elementInput)) {
			return new IntegerElement(1);
		}
		else {
			return new IntegerElement(0);
		}
	}

	//Description getter
	public String getDescription(){
		return this.description;
	}
}
