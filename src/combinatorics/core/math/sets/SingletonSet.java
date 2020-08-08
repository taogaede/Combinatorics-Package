package combinatorics.core.math.sets;

import combinatorics.core.elements.Element;
import java.lang.IllegalStateException;
import combinatorics.core.tools.printing.Printable;
import combinatorics.core.tools.serializing.Serializable;
import combinatorics.core.tools.typing.ElementTyper;
import combinatorics.core.math.interfaces.NaiveSetTheory;

public class SingletonSet extends FiniteSet implements NaiveSetTheory, Serializable, Printable {
	
	protected Element value;
	
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
	
	public Object getValue() {
		return ElementTyper.toValue(value);
	}
	
	public void print() {
		getElement().print();
	}
	
	public String getString() {
		return getElement().getString();
	}
}
