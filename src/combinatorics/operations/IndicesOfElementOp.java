package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class IndicesOfElementOp extends Operation {

	private Integer integerInput;
	private String stringInput;

	//Operation description
	private String description = "Return sequence of indices with element " + this.integerInput;

	//Constructors
	public IndicesOfElementOp(Integer input){
		this.integerInput = input;
	}
	public IndicesOfElementOp(String input){
		this.stringInput = input;
	}

	//Operation method
	public Element operation(Integer[] input){
		Integer[] input2Indices = new Integer[input.length];
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(integerInput)) {
				input2Indices[i] = (Integer) i;
			}
			else {
				input2Indices[i] = -1;
			}
		}
		return new IntegerElement(input2Indices);
	}
	
	public Element operation(String[] input){
		Integer[] input2Indices = new Integer[input.length];

		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(stringInput)) {
				input2Indices[i] = (Integer) i;
			}
			else {
				input2Indices[i] = -1;
			}
		}
		return new IntegerElement(input2Indices);
	}

	//Description getter
	public String getDescription(){
		return this.description;
	}
}
