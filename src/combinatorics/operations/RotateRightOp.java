package combinatorics.operations;

import combinatorics.core.Operation;

public class RotateRightOp extends Operation {

	/*	Implemented input/output combinations:
	 *
	 * 	Input : Output
	 *
	 * 	Integer[] : Integer[]
	 *
	 */

	//Input
	private Integer[] integerArrayInput;
	private String[] stringArrayInput;

	//Operation description
	private String description = "Rotate sequences rightward.";

	//Constructor
	public RotateRightOp() {
	}

	//Input setters
	protected void setInput(Integer[] input){
		this.integerArrayInput = input;
	}
	protected void setInput(String[] input){
		this.stringArrayInput = input;
	}

	//Operate type methods
	protected Integer[] operateTypeIntegerArray(Integer[] dummy) {
		return rotateRight(integerArrayInput);
	}
	protected String[] operateTypeStringArray(String[] dummy) {
		return rotateRight(stringArrayInput);
	}

	//Operation Methods
	private Integer[] rotateRight(Integer[] set) {
		Integer[] result = new Integer[set.length];
		result[0] = set[set.length - 1];
		for (int i = 0; i < set.length - 1; i++) {
			result[i + 1] = set[i];
		}
		return result;
	}
	private String[] rotateRight(String[] set) {
		String[] result = new String[set.length];
		result[0] = set[set.length - 1];
		for (int i = 0; i < set.length - 1; i++) {
			result[i + 1] = set[i];
		}
		return result;
	}

	//Description getter
	public String getDescription() {
		return this.description;
	}
}
