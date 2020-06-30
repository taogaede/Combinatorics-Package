package combinatorics.operations;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class AddOp extends Operation {

	//Input
	private Integer integerInput;
	private Double doubleInput;

	//Description
	private String description = ""; //(See constructors)

	//Constructors, where "n" is the number added.
	public AddOp(Integer n) {
		integerInput = n;
		this.description = "Add number " + integerInput + " to set element.";
	}
	public AddOp(Double n) {
		doubleInput = n;
		this.description = "Add number " + doubleInput + " to set element.";
	}

	//Operation methods
	public Element operation(Integer input) {
		return new IntegerElement(add(input, integerInput));
	}
	public Element operation(Integer[] input) {
		return new IntegerElement(add(input, integerInput));
	}
	public Element operation(Double input) {
		return new DoubleElement(add(input, doubleInput));
	}
	public Element operation(Double[] input) {
		return new DoubleElement(add(input, doubleInput));
	}
	
	//add methods
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
