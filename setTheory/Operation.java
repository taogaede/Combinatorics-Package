package setTheory;

import java.util.*;

public class Operation {
	
	public Operation() {
	}
	
	public Object operateElement() {
		//Overridden
		return new Object();
	}
	
	public String getDescription() {
		return "";
	}
	
	public CombSet operateSet(CombSet set) {
		CombSet result = new CombSet();
		for (int i = 0; i < set.size(); i++) {
			setInput(set.get(i));
			result.add(operateElement());
		}
		return result;
	}
	
	public void setInput(Object input) {
		//Overridden
	}
	public Object getInput() {
		return new Object();
	}
	
	public Object identity(Object input) {
		return input;
	}
}

/*
 * Operation subclasses below.
 * Each operation subclass needs to have FIVE components:
 * 	1.	An intuitive name:
 * 			Users of this package need to be focused on mathematics, and not on figuring out acronyms or vague operation names.  
 * 			A guiding principle:  Try to think of a name that is so intuitive that it almost wouldn't need a description (it's self-explanatory).
 * 			For example: if you're making an operation that rotates the elements in a sequence one step to the right, don't name it something like "Rot" or "RR".
 * 			Naming it "Rotate" might be fine, but "RotateRight" would be more descriptive.  
 * 			Fortunately, renaming operation subclasses is easy, so it's not a big deal if the name is not perfect.
 * 
 * 	2.	An accurate and succinct (single sentence) description of what the operation outputs, given the input.
 * 
 * 	3.	Overriding public <type> input field:	
 * 			Override the "public Object input" field of the Operation class with the desired input required for the operation subclass.
 * 			You can override with array inputs as well, as in: "public int[][][] input".
 * 
 * 	4.	Method(s) that perform(s) the desired operation: 
 * 			There must be a single method that is called by the overriding operate() method (described in (5)).  
 * 			This method can either perform the desired operation, or if the operation is more complex, call other methods within the subclass. 
 * 			The method must use the overridden input field as input and returns the desired output (which is then called by the overridden operate() method).
 * 
 * 	5.	Overriding operate() method:	
 * 			A "public Object operate()" method that overrides the Operation class "public Object operate()" method.
 * 			The overriding method in the subclass should return the 	
 */
class Identity extends Operation{
	public Object input;
	
	public Object operate() {
		return identity(input);
	}
	public Object identity(Object input) {
		return input;
	}
}


class Add 
/*	Adds two numbers together.
 * 
 * 	Numbers can be int, double, long, or float.  If a different type is specified, the input will be converted to type int using (int)input.
 * 	The operation is defined using method overloading to capture all addable data types within one operation class.
 * 	NOTE: 	An alternative approach here would be to define an adder interface and reference the interface for each data type, 
 * 			but such an approach would be more abstract and would not be simpler.
 */
extends Operation{
	
	public String description = "Add numbers together.";
	public Number input;
	public Number input2;
	
	public Add(Number n) {
		input2 = n;
	}
	public Object operateElement() {
		
		if (input != null && input.getClass() == int.class) {
			int first = (int)input;
			int second = (int)input2;
			return add(first,second);
		}
		if (input != null && input.getClass() == double.class) {
			double first = (double)input;
			double second = (double)input2;
			return add(first,second);
		}
		if (input != null && input.getClass() == long.class) {
			long first = (long)input;
			long second = (long)input2;
			return add(first,second);
		}
		if (input != null && input.getClass() == float.class) {
			float first = (float)input;
			float second = (float)input2;
			return add(first,second);
		}
		
		//System.out.println("input " + input + " + " + (int)input2 + " = " + add((int)input,(int)input2));
		return add((int)input,(int)input2);
	}
	
	private int add(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}
	
	private double add(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}
	
	private long add(long firstNumber, long secondNumber) {
		return firstNumber + secondNumber;
	}
	
	private float add(float firstNumber, float secondNumber) {
		return firstNumber + secondNumber;
	}
	
	@Override
	public void setInput(Object input) {
		this.input = (int) input;
	}

}

class RotateRight
/*	Shifts the values for each index in a sequence one step to the right.
 * 
 */
extends Operation{
	
	public String description = "Rotate sequences rightward.";
	public Object[] input;
	
	public Object[] operate() {
		return rotateRight(input);
	}
	
	public Object[] rotateRight(Object[] array) {
		Object[] newArray = new Object[array.length];
		newArray[0] = array[array.length - 1];
		
		for (int i = 0; i < array.length - 1; i++) {
			newArray[i + 1] = array[i];
		}
		return newArray;
	}
}