package combinatorics.operations;

import combinatorics.core.CombinatorialSet;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class LexMinRotationOp extends Operation {

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
	private String description = "Return lexicographically minimal rotation of each sequence.";

	//Empty Constructor.
	public LexMinRotationOp(){
	}

	//Input Setter (casts as desired input type).
	protected void setInput(Integer[] input){
			this.integerArrayInput = input;
	}

	//Operate type method
	protected Integer[] operateTypeIntegerArray(Integer[] dummy){
		//Possible input type conditions etc.
		return lexMinRotation(this.integerArrayInput);
	}

	//Operation method
	private Integer[] lexMinRotation(Integer[] input){
		Integer[] minArray = new Integer[input.length];
		CombinatorialSet allRotations = new CombinatorialSet();
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
		return minArray;
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
		//Returns lexicographic minimum of array pair
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
