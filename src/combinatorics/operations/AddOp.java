package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class AddOp extends Operation {

	/*	Implemented input/output combinations:
	 *
	 * 	Input : Output
	 *
	 * 	Integer : Integer
	 * 	Integer[] : Integer[]
	 *	Double : Double
	 * 	Double[] : Double[]
	 *
	 */

	//Input
	private Integer integerInput;
	private Integer[] integerArrayInput;
	private Double doubleInput;
	private Double[] doubleArrayInput;

	//Input2
	private Integer integerInput2;
	private Double doubleInput2;

	//Description
	private String description = ""; //(See constructors)

	//Constructors, where "n" is the number added.
	public AddOp(Integer n) {
		integerInput2 = n;
		this.description = "Add number " + integerInput2 + " to set element.";
	}
	public AddOp(Double n) {
		doubleInput2 = n;
		this.description = "Add number " + doubleInput2 + " to set element.";
	}

	//Input setters
	protected void setInput(Integer input) {
		this.integerInput = input;
	}
	protected void setInput(Integer[] input) {
		this.integerArrayInput = input;
	}
	protected void setInput(Double input) {
		this.doubleInput = input;
	}
	protected void setInput(Double[] input) {
		this.doubleArrayInput = input;
	}

	//Operate type methods
	protected Integer operateTypeInteger(Integer dummy) {
		return add(integerInput, integerInput2);
	}
	protected Double operateTypeDouble(Double dummy) {
		return add(doubleInput, doubleInput2);
	}
	protected Integer[] operateTypeIntegerArray(Integer[] dummy) {
		return add(integerArrayInput, integerInput2);
	}
	protected Double[] operateTypeDoubleArray(Double[] dummy) {
		return add(doubleArrayInput, doubleInput2);
	}

	//Operation methods
	private Double[] add(Double[] array, Double number) {
		Double[] newArray = new Double[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i] + number;
		}
		return newArray;
	}
	private Double add(Double firstNumber, Double secondNumber) {
		return firstNumber + secondNumber;
	}
	private Integer[] add(Integer[] array, Integer number) {
		Integer[] newArray = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i] + number;
		}
		return newArray;
	}
	private Integer add(Integer firstNumber, Integer secondNumber) {
		return firstNumber + secondNumber;
	}

	//Description getter
	public String getDescription() {
		return this.description;
	}
}
