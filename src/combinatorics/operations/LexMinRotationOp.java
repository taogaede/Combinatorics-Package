package combinatorics.operations;

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
	public Element operation(Integer[] input){
		Integer[] minArray = new Integer[input.length];
		ArrayList<Integer[]> allRotations = new ArrayList<Integer[]>();
		if (input.length > 1) {
			for (int i = 0; i < input.length; i++) {
				Integer[] tempArray = new Integer[input.length];
				tempArray = input;
				for (int j = 0; j < i; j++) {
					tempArray = arrayRotateRight(tempArray);
				}
				allRotations.add(tempArray);
			}
			minArray = (Integer[]) allRotations.get(0);
			for (int i = 1; i < allRotations.size(); i++) {
				if (minLexArray( minArray, (Integer[]) allRotations.get(i)) == allRotations.get(i)) {
					minArray = (Integer[]) allRotations.get(i);
				}
			}
		}
		if (input.length == 1 || input.length == 0) {
			minArray = input;
		}
		return new IntegerElement(minArray);
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
			if (firstArray[i] < secondArray[i]) {
				return firstArray;
			}
			if (firstArray[i] > secondArray[i]) {
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
