package combinatorics.functions.elementary;

import java.util.Arrays;
import combinatorics.core.elements.*;
import combinatorics.core.math.functions.ElementaryFunction;
import combinatorics.core.math.sets.FiniteSet;
import combinatorics.core.tools.typing.ElementTyper;

import java.util.ArrayList;

public class LexMinRotation extends ElementaryFunction {

	//Constructor
	public LexMinRotation(){
		setDescription();
	}

	//Operation method
	protected Element operation(Element input){
		Integer[] inputSequence = (Integer[]) ElementTyper.toValue(input);
		
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
		
		return ElementTyper.toElement(minArray);
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

	private void setDescription() {
		description = "Return lexicographically minimal rotation of each sequence.";
	}
}
