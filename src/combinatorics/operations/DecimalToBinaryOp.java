package combinatorics.operations;

import java.util.ArrayList;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class DecimalToBinaryOp extends Operation {

	private String description = "Convert decimal integers into binary sequences.";

	//Constructor
	public DecimalToBinaryOp(){}

	//Operation method
	public Element operation(Integer decimal){
		ArrayList<Integer> binaryList = new ArrayList<Integer>();
		while(decimal > 0) {
			binaryList.add( decimal % 2);
			decimal = decimal / 2;
		}
		Integer[] arrayResult = new Integer[binaryList.size()];
		for (int i = 0; i < binaryList.size(); i++) {
			arrayResult[i] = binaryList.get(i);
		}
		return new IntegerElement(arrayResult);
	}

	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}
