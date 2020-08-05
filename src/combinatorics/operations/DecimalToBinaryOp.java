package combinatorics.operations;

import java.util.ArrayList;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class DecimalToBinaryOp extends Operation {

	private String description = "Convert decimal integers into binary sequences.";

	//Constructor
	public DecimalToBinaryOp(){}

	//Operation method
	public Element operation(Element input) {
		Integer decimal = (Integer) elementTyper.toValue(input);
		
		ArrayList<Integer> binaryList = new ArrayList<Integer>();
		while( decimal > 0 ) {
			Integer newBit = decimal % 2;
			binaryList.add( newBit );
			decimal = decimal / 2;
		}
		Integer[] binaryArray = new Integer[binaryList.size()];
		for (int i = 0; i < binaryList.size(); i++) {
			binaryArray[i] = binaryList.get(i);
		}
		
		return elementTyper.toElement(binaryArray);
	}

	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}
