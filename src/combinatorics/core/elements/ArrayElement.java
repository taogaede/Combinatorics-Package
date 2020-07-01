package combinatorics.core.elements;

import java.util.ArrayList;

import combinatorics.core.Comparer;

public class ArrayElement implements Element {
	
	public Element[] value;
	
	public ArrayElement(Element[] value) {
		this.value = value;
	}
	
	public ArrayElement(ArrayList<?> value) {	//This constructor exists for the cases when it's easier to work with lists than arrays during a construction (eg appending when you don't know the size).
		this.value = new Element[value.size()];
		for (int i = 0; i < value.size(); i++) {
			this.value[i] = (Element) value.get(i);
		}
	}

	public Element add(Element other) {
		if (other instanceof ArrayElement) {	//n-dimensional component-wise addition
			if (this.value.length == ( (ArrayElement) other).value.length) {	//makes sure the arrays are the same size
				for (int i = 0; i < this.value.length; i++) {
					this.value[i] = this.value[i].add( ( (ArrayElement) other ).value[i]);
				}
			}
		}
		else {
			for (int i = 0; i < this.value.length; i++) {	//add other value to each component of array
				this.value[i] = this.value[i].add(other);
			}
		}
		return this;
	}
	@Override
	public Element multiply(Element other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element concatenate(Element other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqualTo(Element other) {
		return ( new Comparer(this, other).getIsEqual() );
	}

	@Override
	public boolean isGreaterThan(Element other) {  //needs to be something that generalizes from sequences to n dimensional arrays.  Determinant?
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canArithmetic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	@Override
	public Element[] getValue() {
		return this.value;
	}
}
