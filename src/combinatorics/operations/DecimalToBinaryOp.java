package combinatorics.operations;

import java.util.ArrayList;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class DecimalToBinaryOp extends Operation {

	/*	Implemented input/output combinations:
	 *
	 * 	Input : Output
	 *
	 * 	Integer : Integer[]
	 *
	 */

	//Input
	private Element input;

	//Operation description
	private String description = "Convert decimal integers into binary sequences.";

	//Constructor
	public DecimalToBinaryOp(){
	}

	//Input operator
	public Element operate(Element input){
		Element result = null;
		
		if (input instanceof IntegerElement && input.getType() == "single") {
			IntegerElement castedInput = (IntegerElement) input;	//cast input Element to appropriate Element type
			
			Integer operationInput = castedInput.getSingleValue();	//extract desired value from the input
			
			Integer[] operationResult = decimalToBinary(operationInput);	//Invoke operation on this desired value
			
			result = new IntegerElement(operationResult);	//package operation result into new Element of appropriate type
		}
		return result;
	}

	//Operation method
	private Integer[] decimalToBinary(Integer decimal){
		ArrayList<Integer> binaryList = new ArrayList<Integer>();
		
		while(decimal > 0) {
			binaryList.add( decimal % 2);
			decimal = decimal / 2;
		}
		Integer[] result = new Integer[binaryList.size()];
		for (int i = 0; i < binaryList.size(); i++) {
			result[i] = binaryList.get(i);
		}
		
		return result;
	}

	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}
