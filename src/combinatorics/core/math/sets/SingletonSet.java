package combinatorics.core.math.sets;

import combinatorics.core.elements.Element;
import java.lang.IllegalStateException;

public class SingletonSet extends FiniteSet {
	
	private Element value;
	
	public void setElement(Element value) {
		clear();
		this.value = value;
		super.add(value);
	}
	
	//Converts current SingletonSet into FiniteSet with this set's Element value and operand's Elements.
	public FiniteSet union(FiniteSet operand) {
		FiniteSet newSet = new FiniteSet();
		newSet.add(this.getElement());
		
		if (operand.getClass() == SingletonSet.class) {
			newSet.add( ((SingletonSet) operand).getElement());
		}
		else {
			newSet = newSet.union(operand);
		}
		
		return newSet;
	}
	
	//prevents user from adding elements to Singleton sets
	//java.lang.IllegalStateException
	//Not really sure how exceptions work yet.
	public boolean add(Element dummy) {
		System.out.println("Cannot add element to a Singleton set, please use setElement(Element yourElement) to change or add the only element to this set");
		throw new IllegalStateException();
	}
	
	public Element getElement() {
		return value;
	}
}
