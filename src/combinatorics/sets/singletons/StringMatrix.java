package combinatorics.sets.singletons;

import combinatorics.core.tools.typing.ElementTyper;

public class StringMatrix extends Matrix {

	public StringMatrix(String[][] value) {
		setElement(ElementTyper.toElement(value));
	}
	
}
