package combinatorics.functions.elementary;

import combinatorics.core.elements.*;
import combinatorics.core.math.functions.ElementaryFunction;
import combinatorics.core.tools.typing.ElementTyper;

import java.util.ArrayList;

public class BinarySequenceToComposition extends ElementaryFunction{

	//Constructor
	public BinarySequenceToComposition(){
		setDescription();
	}

	//Operation method
	public Element operation(Element input){
		Integer[] binarySequence = (Integer[]) ElementTyper.toValue(input);

		ArrayList<Integer> oneIndices = new ArrayList<Integer>();
		for (int i = 0; i < binarySequence.length; i++) {
			if (binarySequence[i] == 1) {
				oneIndices.add(i);
			}
		}
		Integer[] composition = new Integer[oneIndices.size()];
		composition[0] = oneIndices.get(0) + binarySequence.length - oneIndices.get(oneIndices.size() - 1);
		for (int i = 1; i < oneIndices.size(); i++) {
			composition[i] = oneIndices.get(i) - oneIndices.get(i - 1);
		}
		
		return ElementTyper.toElement(composition);
	}

	//Description setter
	private void setDescription() {
		description = "Return integer differences between consecutive 1s in binary sequence.";
	}
}
