package combinatorics.operations;

import java.util.Arrays;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;
import java.util.ArrayList;

public class LexMinRotationOp extends Operation {

	//Operation description
	private String description = "Return lexicographically minimal rotation of each sequence.";

	//Empty Constructor.
	public LexMinRotationOp(){
	}

	//Operation method
	public Element operation(ArrayElement uncastedInput){
		IntegerElement[] input = (IntegerElement[]) uncastedInput.getValue();
		IntegerElement[] minArray = new IntegerElement[input.length];
		ArrayList<IntegerElement[]> allRotations = new ArrayList<IntegerElement[]>();
		if (input.length > 1) {
			for (int i = 0; i < input.length; i++) {
				IntegerElement[] tempArray = new IntegerElement[input.length];
				tempArray = input;
				for (int j = 0; j < i; j++) {
					tempArray = arrayRotateRight(tempArray);
				}
				allRotations.add(tempArray);
			}
			minArray = allRotations.get(0);
			for (int i = 1; i < allRotations.size(); i++) {
				if (Arrays.deepEquals(minLexArray( minArray,  allRotations.get(i)) , (allRotations.get(i) ) )) {
					minArray = allRotations.get(i);
				}
			}
		}
		if (input.length == 1 || input.length == 0) {
			minArray = input;
		}
		return new ArrayElement(minArray);
	}

	//Supporter methods
	private IntegerElement[] arrayRotateRight(IntegerElement[] array) {
		IntegerElement[] rotRight = new IntegerElement[array.length];
		rotRight[0] = array[array.length - 1];
		for(int i = 0; i < array.length - 1; i++) {
			rotRight[i+1] = array[i];
		}
		return rotRight;
	}
	
	private IntegerElement[] minLexArray(IntegerElement[] firstArray, IntegerElement[] secondArray) {
		for (int i = 0; i < firstArray.length; i++) {
			if ( firstArray[i].getValue() < secondArray[i].getValue() ) {
				return firstArray;
			}
			if ( firstArray[i].getValue() > secondArray[i].getValue() ) {
				return secondArray;
			}
		}
		return firstArray;
	}

	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}
