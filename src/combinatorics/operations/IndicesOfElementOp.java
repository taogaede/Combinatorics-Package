package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class IndicesOfElementOp extends Operation {

	/*	Implemented input/output combinations:
	 *
	 * 	Input : Output
	 *
	 * 	Integer[] : Integer[]
	 *
	 */

	//Input
	private Integer[] integerArrayInput;

	//Input2
	private Integer integerInput2;

	//Operation description
	private String description = "Return sequence of indices with element " + this.integerInput2;

	//Constructor
	public IndicesOfElementOp(Integer input2){
		this.integerInput2 = input2;
	}

	//Input setter.
	protected void setInput(Integer[] input){
		this.integerArrayInput = input;
	}

	//Operate type method.
	protected Integer[] operateTypeIntegerArray(Integer[] dummy){
		return indicesOfElement(this.integerArrayInput);
	}
	protected Integer[] operateTypeIntegerArray(String[] dummy){
		return indicesOfElement(this.integerArrayInput);
	}

	//Operation method.  Has Object[] input type because method only uses the fact that the input is an array and the Object ".equals()" method.
	private Integer[] indicesOfElement(Object[] input){
		Integer[] input2Indices = new Integer[input.length];

		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(integerInput2)) {
				input2Indices[i] = (Integer) i;
			}
			else {
				input2Indices[i] = -1;
			}
		}
		return input2Indices;
	}

	//Description getter
	public String getDescription(){
		return this.description;
	}
}
