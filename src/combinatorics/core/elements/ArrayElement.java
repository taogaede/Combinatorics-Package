package combinatorics.core.elements;

import java.util.ArrayList;

import combinatorics.core.tools.comparing.Comparer;

public class ArrayElement implements Element {
	
	public Element[] value;
	
	public ArrayElement() {}
	
	public ArrayElement(Element[] value) {
		this.value = value;
	}

	public ArrayElement(ArrayList<Element> value) {	//This constructor exists for the cases when it's easier to work with lists than arrays during a construction (eg appending when you don't know the size).s
		this.value = value.toArray(new Element[value.size()]);
	}

	@Override
	public boolean isEqualTo(Element other) {
		return Comparer.getIsEqual(this, other);
	}

	public Integer length() {
		return this.getValue().length;
	}
	
	@Override
	public void print() {
		for (int i = 0; i < this.value.length; i++) {
			this.value[i].print();
			if (this.value[i].getClass() != ArrayElement.class) System.out.print("	");
		}
		System.out.println();
	}

	public String getString() {
		String result = "";
		for (int i = 0; i < this.getValue().length; i++) {
			result = result.concat(this.getValue()[i].getString()) + "/n";
		}
		return result;
	}
	
	@Override
	public Element[] getValue() {
		return this.value;
	}
}
