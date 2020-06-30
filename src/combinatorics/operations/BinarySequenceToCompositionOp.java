package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;
import java.util.ArrayList;

public class BinarySequenceToCompositionOp extends Operation {

	//Operation description
	private String description = "Return integer differences between consecutive 1s in binary sequence.";

	//Empty constructor
	public BinarySequenceToCompositionOp(){}

	//Operation method
	public Element operation(Integer[] input){
		Integer[] binarySequence = input;
		ArrayList<Integer> oneIndices = new ArrayList<Integer>();
		for (int i = 0; i < binarySequence.length; i++) {
			if (binarySequence[i] == 1) {
				oneIndices.add(i);
			}
		}
		ArrayList<Integer> decimalSet = new ArrayList<Integer>();
		decimalSet.add(oneIndices.get(0) + binarySequence.length - oneIndices.get(oneIndices.size() - 1));
		for (int i = 1; i < oneIndices.size(); i++) {
			decimalSet.add(oneIndices.get(i) - oneIndices.get(i - 1));
		}
		Integer[] decimalArray = new Integer[decimalSet.size()];
		for (int i = 0; i < decimalSet.size(); i++) {
			decimalArray[i] = (Integer) decimalSet.get(i);
		}
		return new IntegerElement(decimalArray);
	}

	//Description getter
	public String getDescription(){
		return this.description;
	}
}
