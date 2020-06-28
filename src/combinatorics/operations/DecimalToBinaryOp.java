package combinatorics.operations;

import combinatorics.core.CombinatorialSet;
import combinatorics.core.Operation;

public class DecimalToBinaryOp extends Operation {

	/*	Implemented input/output combinations:
	 *
	 * 	Input : Output
	 *
	 * 	Integer : Integer[]
	 *
	 */

	//Input
	private Integer integerInput;

	//Operation description
	private String description = "Convert decimal integers into binary sequences.";

	//Constructor
	public DecimalToBinaryOp(){
	}

	//Input setter
	protected void setInput(Integer input){
		this.integerInput = input;
	}

	//Operate type method
	protected Integer[] operateTypeIntegerArray(Integer dummy){
		return decimalToBinary(this.integerInput);
	}

	//Operation method
	private Integer[] decimalToBinary(Integer input){ //Clean up.  Don't need CombSets in here.
			CombinatorialSet binaryList = new CombinatorialSet();
			Integer intCast = input;
			while(intCast > 0) {
				binaryList.add( (Integer) intCast % 2);
				intCast = intCast / 2;
			}
			Integer[] binarySequence = new Integer[binaryList.size()];
			for (int i = 0; i < binaryList.size(); i++) {
				binarySequence[i] = (Integer) binaryList.get(i);
			}
			return binarySequence;
	}

	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}
