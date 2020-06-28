package combinatorics.operations;

import combinatorics.core.CombinatorialSet;
import combinatorics.core.Operation;

import java.util.ArrayList;

public class BinarySequenceToCompositionOp extends Operation {

	/*	Implemented input/output combinations:
	 *
	 * 	Input : Output
	 *
	 * 	Integer[] : Integer[]
	 *
	 */

	//Input
	private Integer[] integerArrayInput;

	//Operation description
	private String description = "Return integer differences between consecutive 1s in binary sequence.";

	//Empty constructor
	public BinarySequenceToCompositionOp(){
	}

	//Input setter
	protected void setInput(Integer[] input){
		this.integerArrayInput = input;
	}

	//Operate type method
	protected Integer[] operateTypeIntegerArray(Integer[] dummy){
		return binarySequenceToComposition(this.integerArrayInput);
	}

	//Operation method
	private Integer[] binarySequenceToComposition(Integer[] input){ //Clean up.  Don't need CombSets in here.
		Integer[] binarySequence = input;
		ArrayList<Integer> oneIndices = new ArrayList<Integer>();

		for (int i = 0; i < binarySequence.length; i++) {
			if (binarySequence[i] == 1) {
				oneIndices.add(i);
			}
		}

		CombinatorialSet decimalSet = new CombinatorialSet();
		decimalSet.add(oneIndices.get(0) + binarySequence.length - oneIndices.get(oneIndices.size() - 1));
		for (int i = 1; i < oneIndices.size(); i++) {
			decimalSet.add(oneIndices.get(i) - oneIndices.get(i - 1));
		}
		Integer[] decimalArray = new Integer[decimalSet.size()];
		for (int i = 0; i < decimalSet.size(); i++) {
			decimalArray[i] = (Integer) decimalSet.get(i);
		}
		return decimalArray;
	}

	//Description getter
	public String getDescription(){
		return this.description;
	}
}
