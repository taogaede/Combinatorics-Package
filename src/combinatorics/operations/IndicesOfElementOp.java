package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class IndicesOfElementOp extends Operation {

	private Integer integerInput;
	private String stringInput;
	private Element elementInput;

	//Operation description
	private String description = "Return sequence of indices with element " + this.integerInput;

	//Constructors
	public IndicesOfElementOp(Integer input){
		this.integerInput = input;
	}
	public IndicesOfElementOp(String input){
		this.stringInput = input;
	}
	public IndicesOfElementOp(Element input) {
		this.elementInput = input;
	}

	//Operation method
	public Element operation(Integer[] input){
		Integer[] inputIndices = new Integer[input.length];
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(integerInput)) {
				inputIndices[i] = (Integer) i;
			}
			else {
				inputIndices[i] = -1;
			}
		}
		return new IntegerElement(inputIndices);
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
	
	public Element operation(Element input){
		//returns 1 when the input is equal to the chosen element, and 0 otherwise. (when type is identical)
		if (input.isEqualTo(elementInput)) {
			return new IntegerElement(1);
		}
		else {
			return new IntegerElement(0);
		}
		
		//returns binary sequence where 1s correspond to indices of input sequence that have value equal to chosen single value element, 0 otherwise.
		if (input.getType() == "sequence") {
			Integer[] indices = new Integer[input.getSequenceValue().length];
			for (int i = 0; i < input.getSequenceValue().length; i++) {
				if (input.getSequenceValue()[i] == elementInput.getSingleValue()) {
					indices[i] = 1;
				}
				else {
					indices[i] = 0;
				}
			}
			return new IntegerElement(indices);
		}
		
		//handles the cases where we check whether matrix rows are equal to given sequence, and when matrix entries are equal to given single value.
		if (input.getType() == "matrix") {
			//returns binary matrix where 1s correspond to indices of input matrix that have value equal to chosen single value element, 0 otherwise.
			if (elementInput.getType() == "single") {
				Integer[][] singleValueIndices = new Integer[input.getMatrixValue().length][input.getMatrixValue()[0].length];
				for (int i = 0; i < input.getMatrixValue().length; i++) {
					for (int j = 0; j < input.getMatrixValue()[0].length; j++) {
						if (input.getMatrixValue()[i][j] == elementInput.getSingleValue()) {
							singleValueIndices[i][j] = 1;
						}
						else {
							singleValueIndices[i][j] = 0;
						}
					}
				}
				return new IntegerElement(singleValueIndices);
			}
			//returns binary sequence where 1s correspond to indices of input matrix that have value equal to chosen sequence value element, 0 otherwise.
			if (elementInput.getType() == "sequence") {
				Integer[] sequenceValueIndices = new Integer[input.getMatrixValue().length];
				for (int i = 0; i < input.getMatrixValue().length; i++) {
					if (input.getMatrixValue()[i] == elementInput.getSequenceValue()) {
						sequenceValueIndices[i] = 1;
					}
					else {
						sequenceValueIndices[i] = 0;
					}
				}
				return new IntegerElement(sequenceValueIndices);
			}
		}
		
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
