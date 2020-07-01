package combinatorics.operations;

import java.util.ArrayList;

import combinatorics.core.Operation;
import combinatorics.core.elements.*;

public class DecimalToBinaryOp extends Operation {

	private String description = "Convert decimal integers into binary sequences.";

	//Constructor
	public DecimalToBinaryOp(){}

	//Operation method
	public ArrayElement operation(Element input) {
		Integer decimal = ( (IntegerElement) input ).getValue();
		ArrayList<IntegerElement> binaryList = new ArrayList<IntegerElement>();
		while( decimal > 0 ) {
			IntegerElement newBit = new IntegerElement( decimal % 2 );
			binaryList.add( newBit );
			decimal = decimal / 2;
		}		
		return new ArrayElement( binaryList );
	}
	/*
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
		
		IntegerElement[] arrayElementResult = new IntegerElement[arrayResult.length];
		for (int i = 0; i < arrayResult.length; i++) {
			arrayElementResult[i] = new IntegerElement(arrayResult[i]);
		}
		
		return new ArrayElement(arrayElementResult);
	}
	*/
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}
