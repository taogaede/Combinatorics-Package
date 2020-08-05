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
	public Element operation(Element input){
		Integer[] inputSequence = (Integer[]) elementTyper.toValue(input);
		
		Integer[] minArray = new Integer[inputSequence.length];
		ArrayList<Integer[]> allRotations = new ArrayList<Integer[]>();
		if (inputSequence.length > 1) {
			for (int i = 0; i < inputSequence.length; i++) {
				Integer[] tempArray = new Integer[inputSequence.length];
				tempArray = inputSequence;
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
		if (inputSequence.length == 1 || inputSequence.length == 0) {
			minArray = inputSequence;
		}
		
		return elementTyper.toElement(minArray);
	}

	//Supporter methods
	private Integer[] arrayRotateRight(Integer[] array) {
		Integer[] rotRight = new Integer[array.length];
		rotRight[0] = array[array.length - 1];
		for(int i = 0; i < array.length - 1; i++) {
			rotRight[i+1] = array[i];
		}
		return rotRight;
	}
	
	private Integer[] minLexArray(Integer[] firstArray, Integer[] secondArray) {
		for (int i = 0; i < firstArray.length; i++) {
			if ( firstArray[i] < secondArray[i] ) {
				return firstArray;
			}
			if ( firstArray[i] > secondArray[i] ) {
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
