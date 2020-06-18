package combPackage;

import java.util.ArrayList;

public class Operation {
	
	//Empty Constructor
	public Operation() {	
	}
	
	//CombSet operate set method
	protected CombSet operateSet(CombSet set) {	
		
		/*	Implemented input/output combinations:
		 * 
		 * 	Input CombSet contains:	 	Output CombSet contains:
		 * 							
		 * 		Integer 					Integer[]
		 * 		Integer						Integer
		 * 		Integer[]					Integer[]
		 * 		Integer[]					Integer
		 * 		Double						Double[]
		 * 		Double						Double
		 * 		Double[]					Double[]
		 * 		Double[]					Double
		 * 		String						String[]
		 * 		String						String
		 * 		String[]					String[]
		 * 		String[]					String
		 * 
		 */
		
		CombSet result = new CombSet();
		if (set.size() > 0) {	
			for (int i = 0; i < set.size(); i++) {
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
				if (set.get(i) instanceof Double) {
					setInput( (Double) set.get(i));
					Double dummy = null;
					if (operateElementDoubleArray(dummy) != null) {
						result.add(operateElementDoubleArray(dummy));
					}
					if (operateElementDouble(dummy) != null) {
						result.add(operateElementDouble(dummy));
					}
				}
				if (set.get(i) instanceof Double[]) {
					setInput( (Double[]) set.get(i));
					Double[] dummy = null;
					if (operateElementDoubleArray(dummy) != null) {
						result.add(operateElementDoubleArray(dummy));
					}
					if (operateElementDouble(dummy) != null) {
						result.add(operateElementDouble(dummy));
					}
				}
				if (set.get(i) instanceof String) {
					setInput( (String) set.get(i));
					String dummy = null;
					if (operateElementStringArray(dummy) != null) {
						result.add(operateElementStringArray(dummy));
					}
					if (operateElementString(dummy) != null) {
						result.add(operateElementString(dummy));
					}
				}
				if (set.get(i) instanceof String[]) {
					setInput( (String[]) set.get(i));
					String[] dummy = null;
					if (operateElementStringArray(dummy) != null) {
						result.add(operateElementStringArray(dummy));
					}
					if (operateElementString(dummy) != null) {
						result.add(operateElementString(dummy));
					}
				}
			}
		}
		if (set.size() == 0){
			System.out.println("Set is empty");
		}
		return result;
	}
	
	//Overridden operate element methods
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
	protected Double operateElementDouble(Double dummy) {	
		return null;
	}
	protected Double operateElementDouble(Double[] dummy) {	
		return null;
	}
	protected Double[] operateElementDoubleArray(Double dummy) {	
		return null;
	}
	protected Double[] operateElementDoubleArray(Double[] dummy) {	
		return null;
	}
	protected String[] operateElementStringArray(String[] dummy) {	
		return null;
	}
	protected String operateElementString(String[] dummy) {	
		return null;
	}
	protected String[] operateElementStringArray(String dummy) {	
		return null;
	}
	protected String operateElementString(String dummy) {	
		return null;
	}
	
	//Overridden input setters
	protected void setInput(CombSet input) {
	}
	protected void setInput(Object input) {
	}
	protected void setInput(Integer input) {
	}
	protected void setInput(Integer[] input) {
	}
	protected void setInput(Double input) {
	}
	protected void setInput(Double[] input) {
	}
	protected void setInput(String input) {
	}
	protected void setInput(String[] input) {
	}
	
	//Overridden Description Getter
	protected String getDescription() {
		return "";
	}
}

/*
 * Operation subclasses below.
 * Each newly defined Operation subclass must have the following components (refer to template immediately below):
 * 
 * 	1.	
 * 
 */

/*
//				BEGIN TEMPLATE
class NewOperation extends Operation{
	
	 //	Implemented input/output combinations:
	 // 
	 // Input: 		 	Output:
	 // 			
	 // InputType 		OutputType		(Elements)
	 // InputType[]		OutputType[]	(Sequences)
	 //	InputType[][]	OutputType[][]	(Matrices)
	 // 				
	 
	//Input
	private <InputType> inputTypeInput;
	
	//Input2 (If the operation subclass constructor has an argument.  Include additional input fields as needed depending on # of constructor arguments.
	private <Input2Type> input2TypeInput2;
	...
	//InputN
	private <InputNType> inputNTypeInputN;
	
	//Operation description
	private String description = "";
	
	//Empty Constructor.
	public NewOperation(){
	}
	
	//Argumented constructors (if needed)
	public NewOperation(<Input2Type> input2, ..., <InputNType> inputN){
	}
	
	//Input setters (Include more if your operation handles more than one input type)
	protected void setInput(<InputType> input){
		this.inputTypeInput = input;
	}
	
	//Operate methods.
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

//				END TEMPLATE
*/

class Identity extends Operation{
	public CombSet input;
	
	public CombSet operate() {
		return identity(input);
	}
	public CombSet identity(CombSet input) {
		return input;
	}
}

class Add extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input 		|| 		Output
	 * 
	 * 	Integer 	||		Integer
	 * 	Integer[]	||		Integer[]
	 * 	Double		||		Double
	 * 	Double[]	||		Double[]
	 */
	
	//Input
	private Integer integerInput;
	private Integer[] arrayIntegerInput;
	private Double doubleInput;
	private Double[] arrayDoubleInput;
	
	//Input2
	private Integer integerInput2;
	private Double doubleInput2;
	
	//Description
	private String description = ""; //(See constructors)
	
	//Constructors, where "n" is the number added.
	public Add(Integer n) {
		integerInput2 = n;
		this.description = "Add number " + integerInput2 + " to set element.";
	}
	public Add(Double n) {
		doubleInput2 = n;
		this.description = "Add number " + doubleInput2 + " to set element.";
	}
	
	//Input Setters
	protected void setInput(Integer input) {
		this.integerInput = input;		
	}
	protected void setInput(Integer[] input) {
		this.arrayIntegerInput = input;		
	}
	protected void setInput(Double input) {
		this.doubleInput = input;		
	}
	protected void setInput(Double[] input) {
		this.arrayDoubleInput = input;		
	}
	
	//Operate Methods
	protected Integer operateElementInteger(Integer dummy) {
		return add(integerInput, integerInput2);
	}
	protected Double operateElementInteger(Double dummy) {
		return add(doubleInput, doubleInput2);
	}
	protected Integer[] operateElementIntegerArray(Integer[] dummy) {
		return add(arrayIntegerInput, integerInput2);
	}
	protected Double[] operateElementIntegerArray(Double[] dummy) {
		return add(arrayDoubleInput, doubleInput2);
	}
	
	//Operation Methods
	private Double[] add(Double[] array, Double number) {
		Double[] newArray = new Double[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i] + number;
		}
		return newArray;
	}
	private Double add(Double firstNumber, Double secondNumber) {
		return firstNumber + secondNumber;
	}
	private Integer[] add(Integer[] array, Integer number) {
		Integer[] newArray = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i] + number;
		}
		return newArray;
	}
	private Integer add(Integer firstNumber, Integer secondNumber) {
		return firstNumber + secondNumber;
	}
	
	//Description Getter
	public String getDescription() {
		return this.description;
	}
}

class RotateRight extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input 		|| 		Output
	 * 
	 * 	Integer[] 	||		Integer[]
	 * 
	 */
	
	//Input
	private Integer[] input;
	private String[] stringInput;
	
	//Operation description
	private String description = "Rotate sequences rightward.";
	
	//Constructor
	public RotateRight() {
	}
	
	//Input setters
	protected void setInput(Integer[] input){
		this.input = input;
	}
	protected void setInput(String[] input){
		this.stringInput = input;
	}
	
	//Operate Methods
	protected Integer[] operateElementIntegerArray(Integer[] dummy) {
		return rotateRight(input);
	}
	protected String[] operateElementStringArray(String[] dummy) {
		return rotateRight(stringInput);
	}
	
	//Operation Methods
	private Integer[] rotateRight(Integer[] set) {
		Integer[] result = new Integer[set.length];
		result[0] = set[set.length - 1];
		for (int i = 0; i < set.length - 1; i++) {
			result[i + 1] = set[i];
		}
		return result;
	}
	private String[] rotateRight(String[] set) {
		String[] result = new String[set.length];
		result[0] = set[set.length - 1];
		for (int i = 0; i < set.length - 1; i++) {
			result[i + 1] = set[i];
		}
		return result;
	}
	
	//Description getter
	public String getDescription() {
		return this.description;
	}
}

/*
 * 
 */

class DecimalToBinary extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input 		|| 		Output
	 * 
	 * 	Integer 	||		Integer[]
	 * 
	 */
	
	//Input
	private Integer input;
	
	//Operation description
	private String description = "Convert decimal integers into binary sequences.";
	
	//Constructor
	public DecimalToBinary(){
	}
	
	//Input setter
	protected void setInput(Integer input){
		this.input = input;
	}
	
	//Operate method
	protected Integer[] operateElementIntegerArray(Integer dummyInput){
		return decimalToBinary(this.input);
	}
	
	//Operation methods
	private Integer[] decimalToBinary(Integer input){ //Clean up.  Don't need CombSets in here.
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
			return binarySequence;
	}
	
	//Description Getter.
	public String getDescription(){
		return this.description;
	}
}

class IndicesOfElement extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input 		|| 		Output
	 * 
	 * 	Integer[] 	||		Integer[]
	 * 
	 */	
	
	//Input
	private Integer[] input;
	
	//Input2
	private Integer input2;
	
	//Operation description
	private String description = "Return sequence of indices with element " + this.input2;
	
	//Constructor
	public IndicesOfElement(Integer elementObject){
		this.input2 = elementObject;
	}
	//Input Setter.
	protected void setInput(Integer[] input){
		this.input = input;
	}
	//Operate Method.
	protected Integer[] operateElementIntegerArray(Integer[] dummy){
		return indicesOfElement(this.input);
	}
	protected Integer[] operateElementIntegerArray(String[] dummy){
		return indicesOfElement(this.input);
	}
	//Operation Method.
	private Integer[] indicesOfElement(Object[] input){
		Integer[] input2Indices = new Integer[input.length];
		
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(input2)) {
				input2Indices[i] = (Integer) i;
			}
			else {
				input2Indices[i] = -1;
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