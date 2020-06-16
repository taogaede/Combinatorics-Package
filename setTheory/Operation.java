package setTheory;

import java.util.ArrayList;
import java.util.Arrays;

public class Operation {
	//Empty Constructor
	public Operation() {	
	}
	//CombSet Operator Method (not overridden)
	
	protected CombSet operateSet(CombSet set) {	
		CombSet result = new CombSet();
		if (set.size() > 0) {	
			for (int i = 0; i < set.size(); i++) {
				//if (set.get(i) instanceof CombSet) operateSet( (CombSet) set.get(i));
				if (set.get(i) instanceof Integer) {
					setInput( (Integer) set.get(i));
					Integer dummy = null;
					if (operateElementIntegerArray(dummy) != null) {
						result.add(operateElementIntegerArray(dummy));
					}
					if (operateElementInteger(dummy) != null) {
						result.add(operateElementInteger(dummy));
					}
				}
				if (set.get(i) instanceof Integer[]) {
					setInput( (Integer[]) set.get(i));
					Integer[] dummy = null;
					if (operateElementIntegerArray(dummy) != null) {
						result.add(operateElementIntegerArray(dummy));
					}
					if (operateElementInteger(dummy) != null) {
						result.add(operateElementInteger(dummy));
					}
				}
				//result.add(operateElementIntegerArray());
				//if (set.get(i) instanceof Integer[])	System.out.println(i + " eeeeeh" + Arrays.toString( (Integer[]) set.get(i)) + " heeeeee");
				//System.out.println(set.get(i));
				//if (set.get(i) instanceof Integer == false && set.get(i) instanceof CombSet == false) setInput( (Integer[]) set.get(i));
				
				//result.add(operateElement());
			}
		}
		if (set.size() == 0){
			System.out.println("uh oh)");
		}
		Main.printSet(result);
		return result;
	}
	//Overridden Operate Method
	protected CombSet operateElement() {	
		return new CombSet();
	}
	protected Integer operateElementInteger(Integer dummy) {	
		return null;
	}
	protected Integer operateElementInteger(Integer[] dummy) {	
		return null;
	}
	protected Integer[] operateElementIntegerArray(Integer dummy) {	
		return null;
	}
	protected Integer[] operateElementIntegerArray(Integer[] dummy) {	
		return null;
	}
	//Overridden Input Setter
	protected void setInput(CombSet input) {
	}
	protected void setInput(Object input) {
	}
	protected void setInput(Integer input) {
	}
	protected void setInput(Integer[] input) {
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
	public CombSet input;
	
	public CombSet operate() {
		return identity(input);
	}
	public CombSet identity(CombSet input) {
		return input;
	}
}

/*
 * 
 */

class Add extends Operation{  //Input: Integer || Output: Integer
	/*	Adds two numbers together.
	 * 
	 * 	Numbers can be int, double, long, or float.  If a different type is specified, the input will be converted to type int using (int)input.
	 * 	The operation is defined using method overloading to capture all addible data types within one operation class.
	 * 	NOTE: 	An alternative approach here would be to define an adder interface and reference the interface for each data type, 
	 * 			but such an approach would be more abstract and would not be simpler.
	 */
	private Integer input;
	private Integer input2;
	private String description = "";
	//Constructor, where "n" is the number added.
	public Add(Integer n) {
		input2 = n;
		this.description = "Add number " + input2 + " to set element.";
	}
	//Input Setter
	@Override
	protected void setInput(Integer input) {
		this.input = input;		
	}
	//Operate Method
	protected Integer operateElementInteger(Integer dummy) {
		return add(input, input2);
	}
		/*
		if (input.size() > 1) {
			for (int i = 0; i < input.size(); i++) {
				if (input.get(i).getClass() == int.class) {
					int first = (int) input.get(i);
					int second = (int) input2.get(0);
					result.add(add(first,second));
				}
				if (input.get(i).getClass() == double.class) {
					double first = (double) input.get(i);
					double second = (double) input2.get(0);
					result.add(add(first,second));
				}
				if (input.get(i).getClass() == long.class) {
					long first = (long) input.get(i);
					long second = (long) input2.get(0);
					result.add(add(first,second));
				}
				if (input.get(i).getClass() == float.class) {
					float first = (float) input.get(i);
					float second = (float) input2.get(0);
					result.add(add(first,second));
				}
				
				//System.out.println("input " + input + " + " + (int)input2 + " = " + add((int)input,(int)input2));
				result.add( add( input, input2));
			}
		}
		
		return result;
	}
	*/
	//Operation Method (Variants for overloading, depending on input type)
	private CombSet add(CombSet firstNumber, CombSet secondNumber) {
		CombSet result = new CombSet();
		Integer sum = (int) firstNumber.get(0) + (int) secondNumber.get(0);
		result.add(sum);
		return result;
	}
	private Object add(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}
	private Object add(long firstNumber, long secondNumber) {
		return firstNumber + secondNumber;
	}
	private Integer add(Integer firstNumber, Integer secondNumber) {
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
	
	private CombSet input;
	private String description = "Rotate sequences rightward.";
	
	public RotateRight() {
	}
	protected void setInput(CombSet input){
		this.input = input;
	}
	protected CombSet operateElement() {
		return rotateRight(input);
	}
	
	private CombSet rotateRight(CombSet set) {
		CombSet result = new CombSet();
		result.add( set.get(set.size() - 1) );
		for (int i = 0; i < set.size() - 1; i++) {
			result.add( set.get(i) );
		}
		return result;
	}
	public String getDescription() {
		return this.description;
	}
}

/*
 * 
 */

class DecimalToBinary extends Operation{ //Input: Integer || Output: Integer[]
	private Integer input;
	private String description = "Convert decimal integers into binary sequences.";
	//Empty Constructor.
	public DecimalToBinary(){
	}
	//Input Setter.
	protected void setInput(Integer input){
		this.input = input;
	}
	//Operate Method.
	protected Integer[] operateElementIntegerArray(Integer dummyInput){
		return decimalToBinary(this.input);
	}
	//Operation Methods.  Integer and long overloading would be good.
	private Integer[] decimalToBinary(Integer input){
		//for (int i = 0; i < input.size(); i++) {
			CombSet binaryList = new CombSet();
			Integer intCast = input;
			while(intCast > 0) {
				binaryList.add( (Integer) intCast % 2);
				intCast = intCast / 2;
			}
			Integer[] binarySequence = new Integer[binaryList.size()];
			for (int i = 0; i < binaryList.size(); i++) {
				binarySequence[i] = (Integer) binaryList.get(i);
			}
			//result.add(binarySequence);
			//System.out.println(Arrays.toString( (Integer[]) result.get(0)));
		//}
			return binarySequence;
		//return result;
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
	private CombSet input;
	private CombSet input2;
	private String description = "Return sequence indices with element " + this.input2;
	//Empty Constructor.
	public IndicesOfElement(Object elementObject){
		CombSet elementHolder = new CombSet();
		elementHolder.add(elementObject);
		this.input2 = elementHolder;
	}
	public IndicesOfElement(CombSet elementSet){
		this.input2 = elementSet;
	}
	//Input Setter.
	protected void setInput(CombSet input){
		this.input = input;
	}
	//Operate Method.
	protected CombSet operateElement(){
		return indicesOfElement(this.input);
	}
	//Operation Method.
	private CombSet indicesOfElement(CombSet input){
		CombSet input2Indices = new CombSet();
		
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).equals(input2)) {
				input2Indices.add(i);
			}
			else {
				input2Indices.add(-1);
			}
		}		
		return input2Indices;
	}
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}

/*
 * 
 */
/*  OUT OF ORDER
class ConsecutiveDifferences extends Operation{  //Problem with rotational invariant aspect.  Not really working.
	private CombSet input;
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
	protected CombSet operateElement(){
		//Possible input type conditions etc.
		return consecutiveDifferences(this.input);
	}
	//Operation Method.
	private CombSet consecutiveDifferences(CombSet input){  // Still need to make casting generic
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
*/
/*
 * 
 */

class BinarySequenceToComposition extends Operation{
	private Integer[] input;	
	private String description = "Return integer differences between consecutive 1s in binary sequence.";
	//Empty Constructor.
	public BinarySequenceToComposition(){
	}
	//Input Setter (casts as desired input type).
	protected void setInput(Integer[] input){
		this.input = input;
	}
	//Operate Method.
	protected Integer[] operateElementIntegerArray(Integer[] dummy){
		//Possible input type conditions etc.
		return binarySequenceToComposition(this.input);
	}
	//Operation Method.
	private Integer[] binarySequenceToComposition(Integer[] input){
		Integer[] binarySequence = input;
		ArrayList<Integer> oneIndices = new ArrayList<Integer>();
		
		for (int i = 0; i < binarySequence.length; i++) {
			if (binarySequence[i] == 1) {
				oneIndices.add(i);
			}
		}
		//System.out.println(oneIndices.toString());
		
		
		
		CombSet decimalSet = new CombSet(); 
		decimalSet.add(oneIndices.get(0) + binarySequence.length - oneIndices.get(oneIndices.size() - 1));
		for (int i = 1; i < oneIndices.size(); i++) {
			decimalSet.add(oneIndices.get(i) - oneIndices.get(i - 1));
		}
		Integer[] decimalArray = new Integer[decimalSet.size()];
		for (int i = 0; i < decimalSet.size(); i++) {
			decimalArray[i] = (Integer) decimalSet.get(i);
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
/*
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

*/

/*
 * 
 */



class LexMinRotation extends Operation{ //Input: Integer[] || Output: Integer[]
	private Integer[] input;	
	private String description = "Return lexicographically minimal rotation of each sequence.";
	//Empty Constructor.
	public LexMinRotation(){
	}
	//Input Setter (casts as desired input type).
	protected void setInput(Integer[] input){
			this.input = input;
	}
	//Operate Method.
	protected Integer[] operateElementIntegerArray(Integer[] dummy){
		//Possible input type conditions etc.
		return lexMinRotation(this.input);
	}
	//Operation Method.
	private Integer[] lexMinRotation(Integer[] input){
		Integer[] minArray = new Integer[input.length];
		CombSet allRotations = new CombSet(); 
		if (input.length > 1) {
			for (int i = 0; i < input.length; i++) {
				Integer[] tempArray = new Integer[input.length];
				tempArray = input;
				//System.out.println("Do we get here? " + Arrays.toString(tempArray));
				for (int j = 0; j < i; j++) {
					tempArray = arrayRotateRight(tempArray);
				}
				//System.out.println("Do we get here? " + Arrays.toString(tempArray));
				allRotations.add(tempArray);
			}
			minArray = (Integer[]) allRotations.get(0);
			for (int i = 1; i < allRotations.size(); i++) {
				if (minLexArray( minArray, (Integer[]) allRotations.get(i)) == allRotations.get(i)) {
					minArray = (Integer[]) allRotations.get(i);
				}
			}
		}
		if (input.length == 1) {
			minArray = input;
		}
		if (input.length == 0) {
			minArray = input;
		}
		return minArray;	
	}
	//Supporter Methods.
	private Integer[] arrayRotateRight(Integer[] array) {
		Integer[] rotRight = new Integer[array.length];
		rotRight[0] = array[array.length - 1];
		for(int i = 0; i < array.length - 1; i++) {
			rotRight[i+1] = array[i];
		}
		return rotRight;
	}
	
	private Integer[] minLexArray(Integer[] firstArray, Integer[] secondArray) {
		Integer[] smallArray;
		Integer[] largeArray;
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
			if (smallArray[i] < largeArray[i]) {
				return smallArray;
			}
			if (smallArray[i] > largeArray[i]) {
				return largeArray;
			}
		}
		return smallArray;
	}
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}