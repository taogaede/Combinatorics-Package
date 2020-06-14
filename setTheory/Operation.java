package setTheory;

import java.util.ArrayList;

public class Operation {
	//Empty Constructor
	public Operation() {	
	}
	//CombSet Operator Method (not overridden)
	protected CombSet operateSet(CombSet set) {	
		CombSet result = new CombSet();
		if (set.size() > 0) {	
			for (int i = 0; i < set.size(); i++) {
				setInput(set.get(i));
				result.add(operateElement());
			}
		}
		return result;
	}
	//Overridden Operate Method
	protected Object operateElement() {	
		return new Object();
	}
	//Overridden Input Setter
	protected void setInput(Object input) {
	}
	//Overridden Description Getter
	protected String getDescription() {
		return "";
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

//				BEGIN TEMPLATE
/*

class NewOperation extends Operation{
	private <type> input;
	//Possible other needed inputs given by arguments of a constructor method
	
	private String description = "";
	
	//Empty Constructor.
	public NewOperation(){
	}
	
	//Input Setter (casts as desired input type).
	protected void setInput(Object input){
		this.input = (input type) input;
	}
	
	//Operate Method.
	protected Object operateElement(){
		//Possible input type conditions etc.
		return newOperation(this.input);
	}
	
	//Operation Method.
	private Object newOperation(<Input Type> input){
		<Output type> result = new <Output Type>();
		//New Operation's effect on "result" depending on "input" value
		return result;
	}
	
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}

/*
 * 
 */

//				END TEMPLATE

class Identity extends Operation{
	public Object input;
	
	public Object operate() {
		return identity(input);
	}
	public Object identity(Object input) {
		return input;
	}
}

/*
 * 
 */

class Add extends Operation{
	/*	Adds two numbers together.
	 * 
	 * 	Numbers can be int, double, long, or float.  If a different type is specified, the input will be converted to type int using (int)input.
	 * 	The operation is defined using method overloading to capture all addible data types within one operation class.
	 * 	NOTE: 	An alternative approach here would be to define an adder interface and reference the interface for each data type, 
	 * 			but such an approach would be more abstract and would not be simpler.
	 */
	private Number input;
	private Number input2;
	private String description = "Add number " + input2 + " to set element.";
	//Constructor, where "n" is the number added.
	public Add(Number n) {
		input2 = n;
	}
	//Input Setter
	@Override
	protected void setInput(Object input) {
		this.input = (int) input;
	}
	//Operate Method
	protected Object operateElement() {
		
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
	//Operation Method (Variants for overloading, depending on input type)
	private Object add(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}
	private Object add(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}
	private Object add(long firstNumber, long secondNumber) {
		return firstNumber + secondNumber;
	}
	private Object add(float firstNumber, float secondNumber) {
		return firstNumber + secondNumber;
	}
	//Description Getter
	public String getDescription() {
		return this.description;
	}
}

/*
 *
 */

class RotateRight
/*	Shifts the values for each index in a sequence one step to the right.
 * 
 */
extends Operation{
	
	public Object[] input;
	public String description = "Rotate sequences rightward.";
	
	public Object[] operateElement() {
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

/*
 * 
 */

class DecimalToBinary extends Operation{
	private Number input;
	private String description = "Convert decimal integers into binary sequences.";
	//Empty Constructor.
	public DecimalToBinary(){
	}
	//Input Setter.
	protected void setInput(Object input){
		this.input = (Number) input;
	}
	//Operate Method.
	protected Object[] operateElement(){
		
		if (input.getClass() == int.class) {
			return decimalToBinary((int) input);
		}
		if (input.getClass() == long.class) {
			return decimalToBinary((long) input);
		}
		
		return decimalToBinary((int) this.input);
	}
	//Operation Methods.  Integer and long overloading.
	private Object[] decimalToBinary(int input){
		ArrayList<Integer> binaryList = new ArrayList<Integer>();
		while(input > 0) {
			binaryList.add(input % 2);
			input = input / 2;
		}
		Integer[] binaryInt = new Integer[binaryList.size()];
		for (int i = 0; i < binaryInt.length; i++) {
			binaryInt[i] = binaryList.get(i);
		}
		return binaryInt;
	}
	private Object[] decimalToBinary(long input){
		ArrayList<Long> binaryList = new ArrayList<Long>();
		while(input > 0) {
			binaryList.add(input % 2);
			input = input / 2;
		}
		Long[] binaryLong = new Long[binaryList.size()];
		for (int i = 0; i < binaryLong.length; i++) {
			binaryLong[i] = binaryList.get(i);
		}
		return binaryLong;
	}
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}

/*
 * 
 */

class IndicesOfElement extends Operation{
	private Object[] input;
	private Object input2;
	private String description = "Return sequence indices with element " + this.input2;
	//Empty Constructor.
	public IndicesOfElement(Object element){
		this.input2 = (Object) element;
	}
	//Input Setter.
	protected void setInput(Object input){
		this.input = (Object[]) input;
	}
	//Operate Method.
	protected Object[] operateElement(){
		return indicesOfElement(this.input);
	}
	//Operation Method.
	private Object[] indicesOfElement(Object[] input){
		ArrayList<Object> input2Indices = new ArrayList<Object>();
		
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(input2)) {
				input2Indices.add(i);
			}
		}
		
		Object[] indexArray = new Object[input2Indices.size()];
		for (int i = 0; i < input2Indices.size(); i++) {
			indexArray[i] = (int) input2Indices.get(i);
		}
		
		return indexArray;
	}
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}

/*
 * 
 */

class ConsecutiveDifferences extends Operation{  //Problem with rotational invariant aspect.  Not really working.
	private Object[] input;
	private boolean rotationalInvariance = false;
	private String description = "Return sequence of differences between consecutive elements of " + rotationalInvariance() + " sequence.";
	//Empty Constructor.
	public ConsecutiveDifferences(boolean rotationalInvariance){
		this.rotationalInvariance = rotationalInvariance;
	}
	//Input Setter (casts as desired input type).
	protected void setInput(Object input){
		this.input = (Object[]) input;
	}
	//Operate Method.
	protected Object[] operateElement(){
		//Possible input type conditions etc.
		return consecutiveDifferences(this.input);
	}
	//Operation Method.
	private Object[] consecutiveDifferences(Object[] input){  // Still need to make casting generic
		//Object[] result = new Object[input.length];
		
		ArrayList<Number> differenceArray = new ArrayList<Number>();
		for (int i = 1; i < input.length; i++) {
			differenceArray.add((int) input[i]);
		}
		
		if (rotationalInvariance == true) {
			differenceArray.add((int) input[0] - (int) input[input.length - 1]);
			for (int i = 0; i < input.length - 1; i++) {
				differenceArray.add((int) input[i + 1] - (int) input[i]);
			}
		}
		if (rotationalInvariance == false) {
			for (int i = 0; i < input.length - 1; i++) {
				differenceArray.add((int) input[i + 1] - (int) input[i]);
			}
		}
		
		Object[] result = new Object[differenceArray.size()];
		
		for(int i = 0; i < differenceArray.size(); i++) {
			result[i] = differenceArray.get(i);
		}
		
		return result;
	}
	//Rotational Invariance Check.
	private String rotationalInvariance() {
		if (rotationalInvariance == true) {
			return "rotationally invariant";
		}
		return "non rotationally invariant";
	}
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}

/*
 * 
 */

class BinarySequenceToComposition extends Operation{
	private Object[] input;	
	private String description = "Return integer differences between consecutive 1s in binary sequence.";
	//Empty Constructor.
	public BinarySequenceToComposition(){
	}
	//Input Setter (casts as desired input type).
	protected void setInput(Object input){
		this.input = (Object[]) input;
	}
	//Operate Method.
	protected Object[] operateElement(){
		//Possible input type conditions etc.
		return binarySequenceToComposition(this.input);
	}
	//Operation Method.
	private Object[] binarySequenceToComposition(Object[] input){
		ArrayList<Integer> oneIndices = new ArrayList<Integer>();
		
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(1)) {
				oneIndices.add(i);
			}
		}
		Object[] decimalArray = new Object[oneIndices.size()]; 
		decimalArray[0] = oneIndices.get(0) + input.length - oneIndices.get(oneIndices.size() - 1);
		for (int i = 1; i < oneIndices.size(); i++) {
			decimalArray[i] = oneIndices.get(i) - oneIndices.get(i - 1);
		}
		return decimalArray;
	}
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}

/*
 * 
 */

class LexMinRotation extends Operation{
	private Integer[] input;
	//Possible other needed inputs given by arguments of a constructor method
	
	private String description = "Return lexicographically minimal rotation of sequences";
	
	//Empty Constructor.
	public LexMinRotation(){
	}
	
	//Input Setter (casts as desired input type).
	protected void setInput(Object[] input){
		this.input = (Integer[]) input;
	}
	
	//Operate Method.
	protected Object[] operateElement(){
		//Possible input type conditions etc.
		/*
		if (input[0].getClass() == String.class) {
			return lexMinRotation( (String[]) this.input);
		}
		*/
		if (input[0].getClass() == Integer.class) {
			return lexMinRotation( (Integer[]) this.input);
		}
		return lexMinRotation( (Integer[]) this.input);
	}
	
	//Operation Method.
	private Object[] lexMinRotation(String[] input){
		String[] minArray = new String[input.length];
		
		if (input.length > 0) {
			Object[] allRotations = new String[input.length - 1];
			for (int i = 0; i < input.length - 1; i++) {
				String[] tempArray = input;
					for (int j = 0; j < i; j++) {
						tempArray = (String[]) arrayRotateRight(tempArray);
					}
				allRotations[i] = (String[]) tempArray;
			}
			minArray = (String[]) allRotations[0];
			for (int i = 1; i < allRotations.length; i++) {
				if (minLexArray( (String[]) minArray, (String[]) allRotations[i]) == allRotations[i]) {
					minArray = (String[]) allRotations[i];
				}
			}
		}
		
		return (Object[]) minArray;	
	}
	private Object[] lexMinRotation(Number[] input){
		Number[] minArray = new Number[input.length];
		
		if (input.length > 0) {
			Object[] allRotations = new Number[input.length - 1];
			for (int i = 0; i < input.length - 1; i++) {
				Number[] tempArray = input;
					for (int j = 0; j < i; j++) {
						tempArray = (Number[]) arrayRotateRight(tempArray);
					}
				allRotations[i] = (Number[]) tempArray;
			}
			minArray = (Number[]) allRotations[0];
			for (int i = 1; i < allRotations.length; i++) {
				if (minLexArray( (Number[]) minArray, (Number[]) allRotations[i]) == allRotations[i]) {
					minArray = (Number[]) allRotations[i];
				}
			}
		}
		
		return (Object[]) minArray;	
	}
	
	private Object[] minLexArray(String[] firstArray, String[] secondArray) {
		String[] smallArray;
		String[] largeArray;
		if (firstArray.length <= secondArray.length) {
			smallArray = firstArray;
			largeArray = secondArray;
		}
		else {
			smallArray = firstArray;
			largeArray = secondArray;
		}
		//lex min check
		for (int i = 0; i < smallArray.length; i++) {
			if (smallArray[i].compareTo(largeArray[i]) < 0) {
				return smallArray;
			}
			if (smallArray[i].compareTo(largeArray[i]) > 0) {
				return largeArray;
			}
		}
		return (Object[]) smallArray;
	}
	
	private Object[] minLexArray(Number[] firstArray, Number[] secondArray) {
		Number[] smallArray;
		Number[] largeArray;
		if (firstArray.length <= secondArray.length) {
			smallArray = firstArray;
			largeArray = secondArray;
		}
		else {
			smallArray = firstArray;
			largeArray = secondArray;
		}
		//lex min check
		for (int i = 0; i < smallArray.length; i++) {
			if ((double) smallArray[i] < (double) largeArray[i]) {
				return (Object[]) smallArray;
			}
			if ((double) smallArray[i] > (double) largeArray[i]) {
				return (Object[]) largeArray;
			}
		}
		return smallArray;
	}
	
	private Object[] arrayRotateRight(Object[] array) {
		Object[] rotRight = new Object[array.length];
		rotRight[0] = array[array.length - 1];
		for(int i = 0; i < array.length - 1; i++) {
			rotRight[i+1] = array[i];
		}
		return rotRight;
	}
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}

/*
 * 
 */