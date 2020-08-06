package combinatorics.functions.elementary;

import java.util.ArrayList;
import combinatorics.core.elements.*;
import combinatorics.core.ElementaryFunction;

public class DecimalToBinary extends ElementaryFunction {

	//Constructor
	public DecimalToBinary(){
		setDescription();
	}

	//Operation method
	public Element operation(Element input) {

		Integer decimal = (Integer) ElementTyper.toValue(input);
		
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
		
		return ElementTyper.toElement(binaryArray);
	}
	
	//Description setter
	private void setDescription() {
		description = "Convert decimal integers into binary sequences.";
	}
}
