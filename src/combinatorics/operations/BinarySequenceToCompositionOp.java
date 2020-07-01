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
	public ArrayElement operation(ArrayElement input){
		IntegerElement[] binarySequence = (IntegerElement[]) input.getValue();

		ArrayList<Integer> oneIndices = new ArrayList<Integer>();
		for (int i = 0; i < binarySequence.length; i++) {
			if (binarySequence[i].getValue() == 1) {
				oneIndices.add(i);
			}
		}
		ArrayList<IntegerElement> composition = new ArrayList<IntegerElement>();
		composition.add( new IntegerElement( oneIndices.get(0) + binarySequence.length - oneIndices.get(oneIndices.size() - 1) ) );
		for (int i = 1; i < oneIndices.size(); i++) {
			composition.add( new IntegerElement( oneIndices.get(i) - oneIndices.get(i - 1) ) );
		}

		return new ArrayElement(composition);
	}

	//Description getter
	public String getDescription(){
		return this.description;
	}
}
