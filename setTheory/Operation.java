package setTheory;

import java.util.*;

public class Operation {
	public Object input;
	public Operation() {
		input = new Object();
	}
	
	public Object operate() {
		return identity(input);
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

class Add 
/*	Adds two numbers together.
 * 
 * 	Numbers can be int, double, long, or float.  If a different type is specified, the input will be converted to type int using (int)input.
 * 	The operation is defined using method overloading to capture all addable data types within one operation class.
 * 	NOTE: 	An alternative approach here would be to define an adder interface and reference the interface for each data type, 
 * 			but such an approach would be more abstract and would not be simpler.
 */
extends Operation{
	
	public Number[] input = new Number[2];
	
	public Object operate() {
		if (input[0].getClass() == int.class) {
			int first = (int)input[0];
			int second = (int)input[1];
			return add(first,second);
		}
		if (input[0].getClass() == double.class) {
			double first = (double)input[0];
			double second = (double)input[1];
			return add(first,second);
		}
		if (input[0].getClass() == long.class) {
			long first = (long)input[0];
			long second = (long)input[1];
			return add(first,second);
		}
		if (input[0].getClass() == float.class) {
			float first = (float)input[0];
			float second = (float)input[1];
			return add(first,second);
		}
		
		return add((int)input[0],(int)input[1]);
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

}

class RotateRight
/*	Shifts the values for each index in a sequence one step to the right.
 * 
 */
extends Operation{
	
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