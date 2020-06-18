package combPackage;

import java.util.ArrayList;

public class Operation {
	
	//Empty constructor
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
					if (operateTypeIntegerArray(dummy) != null) {
						result.add(operateTypeIntegerArray(dummy));
					}
					if (operateTypeInteger(dummy) != null) {
						result.add(operateTypeInteger(dummy));
					}
				}
				if (set.get(i) instanceof Integer[]) {
					setInput( (Integer[]) set.get(i));
					Integer[] dummy = null;
					if (operateTypeIntegerArray(dummy) != null) {
						result.add(operateTypeIntegerArray(dummy));
					}
					if (operateTypeInteger(dummy) != null) {
						result.add(operateTypeInteger(dummy));
					}
				}
				if (set.get(i) instanceof Double) {
					setInput( (Double) set.get(i));
					Double dummy = null;
					if (operateTypeDoubleArray(dummy) != null) {
						result.add(operateTypeDoubleArray(dummy));
					}
					if (operateTypeDouble(dummy) != null) {
						result.add(operateTypeDouble(dummy));
					}
				}
				if (set.get(i) instanceof Double[]) {
					setInput( (Double[]) set.get(i));
					Double[] dummy = null;
					if (operateTypeDoubleArray(dummy) != null) {
						result.add(operateTypeDoubleArray(dummy));
					}
					if (operateTypeDouble(dummy) != null) {
						result.add(operateTypeDouble(dummy));
					}
				}
				if (set.get(i) instanceof String) {
					setInput( (String) set.get(i));
					String dummy = null;
					if (operateTypeStringArray(dummy) != null) {
						result.add(operateTypeStringArray(dummy));
					}
					if (operateTypeString(dummy) != null) {
						result.add(operateTypeString(dummy));
					}
				}
				if (set.get(i) instanceof String[]) {
					setInput( (String[]) set.get(i));
					String[] dummy = null;
					if (operateTypeStringArray(dummy) != null) {
						result.add(operateTypeStringArray(dummy));
					}
					if (operateTypeString(dummy) != null) {
						result.add(operateTypeString(dummy));
					}
				}
			}
		}
		if (set.size() == 0){
			System.out.println("Set is empty");
		}
		return result;
	}
	
	//Overridden operate type methods
	protected Integer operateTypeInteger(Integer dummy) {	
		return null;
	}
	protected Integer operateTypeInteger(Integer[] dummy) {	
		return null;
	}
	protected Integer[] operateTypeIntegerArray(Integer dummy) {	
		return null;
	}
	protected Integer[] operateTypeIntegerArray(Integer[] dummy) {	
		return null;
	}
	protected Double operateTypeDouble(Double dummy) {	
		return null;
	}
	protected Double operateTypeDouble(Double[] dummy) {	
		return null;
	}
	protected Double[] operateTypeDoubleArray(Double dummy) {	
		return null;
	}
	protected Double[] operateTypeDoubleArray(Double[] dummy) {	
		return null;
	}
	protected String[] operateTypeStringArray(String[] dummy) {	
		return null;
	}
	protected String operateTypeString(String[] dummy) {	
		return null;
	}
	protected Integer[] operateTypeIntegerArray(String[] dummy) {	
		return null;
	}
	protected String[] operateTypeStringArray(String dummy) {	
		return null;
	}
	protected String operateTypeString(String dummy) {	
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
	
	//Overridden description getter
	protected String getDescription() {
		return "";
	}
}

/*
 * Operation subclasses below.
 * Each newly defined Operation subclass must have the following components (refer to template immediately below):
 * 
 * 	1.	Private input fields
 * 
 * 	2.	A one sentence private String description field that succinctly describes what your operation does.
 * 
 *	3.	Public constructor method(s)
 *
 *	4.	Protected input setter methods for each of your inputs not initialized through a constructor.
 *			Input setter methods must override the corresponding Operation input setter method, so it must be named:
 *			protected void setInput(<InputType> input)
 *
 * 	5.	Protected operate methods for each of your inputs not initialized through a constructor.
 * 			Operate methods also override a corresponding Operation method, so they must be named as follows:
 * 			protected <OutputType> operateElementOutputType(<InputType> dummy)
 * 			We use an unused "dummy" variable here for method overloading purposes, because all this method does is select the correct input field to operate on
 * 
 * 	6.	Private operation method for each of your operate methods from (5).  It is in these methods where the substantial operation happens, that is, where the input gets converted to the corresponding output.
 * 			Can also include any necessary (private) supporter methods that will be called by the operation method.
 * 
 *	7.	Public description getter method.  This method overrides the Operation class description getter, so it must be called: public void getDescription().  
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
	
	//Empty constructor if there no additional input is required to complete the definition of the operation.
	public NewOperation(){
	}
	
	//Argumented constructors (if needed)
	public NewOperation(<Input2Type> input2, ..., <InputNType> inputN){
	}
	
	//Input setter(s) (Include more (overload) if your operation handles more than one input type)
	protected void setInput(<InputType> input){
		this.inputTypeInput = input;
	}
	
	//Operate type method(s) (Again, overload if your operation handles more than one input type)
	protected <OutputType> operateTypeOutputType(<InputType> dummy){
		return newOperation(this.inputTypeInput);
	}
	
	//Operation method (overload as needed)
	private <OutputType> newOperation(<Input Type> input){
		<Output type> result = new <Output Type>();
		//Statements bearing New Operation's effect on "result" depending on "input" value
		return result;
	}
	
	//Description getter
	public String getDescription(){
		return this.description;
	}
}

//				END TEMPLATE

*/

class Add extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input : Output
	 * 
	 * 	Integer : Integer
	 * 	Integer[] : Integer[]
	 *	Double : Double
	 * 	Double[] : Double[]
	 * 
	 */
	
	//Input
	private Integer integerInput;
	private Integer[] integerArrayInput;
	private Double doubleInput;
	private Double[] doubleArrayInput;
	
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
	
	//Input setters
	protected void setInput(Integer input) {
		this.integerInput = input;		
	}
	protected void setInput(Integer[] input) {
		this.integerArrayInput = input;		
	}
	protected void setInput(Double input) {
		this.doubleInput = input;		
	}
	protected void setInput(Double[] input) {
		this.doubleArrayInput = input;		
	}
	
	//Operate type methods
	protected Integer operateTypeInteger(Integer dummy) {
		return add(integerInput, integerInput2);
	}
	protected Double operateTypeDouble(Double dummy) {
		return add(doubleInput, doubleInput2);
	}
	protected Integer[] operateTypeIntegerArray(Integer[] dummy) {
		return add(integerArrayInput, integerInput2);
	}
	protected Double[] operateTypeDoubleArray(Double[] dummy) {
		return add(doubleArrayInput, doubleInput2);
	}
	
	//Operation methods
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
	
	//Description getter
	public String getDescription() {
		return this.description;
	}
}

class RotateRight extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input : Output
	 * 
	 * 	Integer[] : Integer[]
	 * 
	 */
	
	//Input
	private Integer[] integerArrayInput;
	private String[] stringArrayInput;
	
	//Operation description
	private String description = "Rotate sequences rightward.";
	
	//Constructor
	public RotateRight() {
	}
	
	//Input setters
	protected void setInput(Integer[] input){
		this.integerArrayInput = input;
	}
	protected void setInput(String[] input){
		this.stringArrayInput = input;
	}
	
	//Operate type methods
	protected Integer[] operateTypeIntegerArray(Integer[] dummy) {
		return rotateRight(integerArrayInput);
	}
	protected String[] operateTypeStringArray(String[] dummy) {
		return rotateRight(stringArrayInput);
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

class DecimalToBinary extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input : Output
	 * 
	 * 	Integer : Integer[]
	 * 
	 */
	
	//Input
	private Integer integerInput;
	
	//Operation description
	private String description = "Convert decimal integers into binary sequences.";
	
	//Constructor
	public DecimalToBinary(){
	}
	
	//Input setter
	protected void setInput(Integer input){
		this.integerInput = input;
	}
	
	//Operate type method
	protected Integer[] operateTypeIntegerArray(Integer dummy){
		return decimalToBinary(this.integerInput);
	}
	
	//Operation method
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
	 * 	Input : Output
	 * 
	 * 	Integer[] : Integer[]
	 * 
	 */	
	
	//Input
	private Integer[] integerArrayInput;
	
	//Input2
	private Integer integerInput2;
	
	//Operation description
	private String description = "Return sequence of indices with element " + this.integerInput2;
	
	//Constructor
	public IndicesOfElement(Integer input2){
		this.integerInput2 = input2;
	}
	
	//Input setter.
	protected void setInput(Integer[] input){
		this.integerArrayInput = input;
	}
	
	//Operate type method.
	protected Integer[] operateTypeIntegerArray(Integer[] dummy){
		return indicesOfElement(this.integerArrayInput);
	}
	protected Integer[] operateTypeIntegerArray(String[] dummy){
		return indicesOfElement(this.integerArrayInput);
	}
	
	//Operation method.  Has Object[] input type because method only uses the fact that the input is an array and the Object ".equals()" method.
	private Integer[] indicesOfElement(Object[] input){
		Integer[] input2Indices = new Integer[input.length];
		
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(integerInput2)) {
				input2Indices[i] = (Integer) i;
			}
			else {
				input2Indices[i] = -1;
			}
		}		
		return input2Indices;
	}
	
	//Description getter
	public String getDescription(){
		return this.description;
	}
}

class BinarySequenceToComposition extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input : Output
	 * 
	 * 	Integer[] : Integer[]
	 * 
	 */	
	
	//Input
	private Integer[] integerArrayInput;
	
	//Operation description
	private String description = "Return integer differences between consecutive 1s in binary sequence.";
	
	//Empty constructor
	public BinarySequenceToComposition(){
	}
	
	//Input setter
	protected void setInput(Integer[] input){
		this.integerArrayInput = input;
	}
	
	//Operate type method
	protected Integer[] operateTypeIntegerArray(Integer[] dummy){
		return binarySequenceToComposition(this.integerArrayInput);
	}
	
	//Operation method
	private Integer[] binarySequenceToComposition(Integer[] input){ //Clean up.  Don't need CombSets in here.
		Integer[] binarySequence = input;
		ArrayList<Integer> oneIndices = new ArrayList<Integer>();
		
		for (int i = 0; i < binarySequence.length; i++) {
			if (binarySequence[i] == 1) {
				oneIndices.add(i);
			}
		}	
		
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
	
	//Description getter
	public String getDescription(){
		return this.description;
	}
}

class LexMinRotation extends Operation{
	
	/*	Implemented input/output combinations:
	 * 
	 * 	Input : Output
	 * 
	 * 	Integer[] : Integer[]
	 * 
	 */	
	
	//Input
	private Integer[] integerArrayInput;	
	
	//Operation description
	private String description = "Return lexicographically minimal rotation of each sequence.";
	
	//Empty Constructor.
	public LexMinRotation(){
	}
	
	//Input Setter (casts as desired input type).
	protected void setInput(Integer[] input){
			this.integerArrayInput = input;
	}
	
	//Operate type method
	protected Integer[] operateTypeIntegerArray(Integer[] dummy){
		//Possible input type conditions etc.
		return lexMinRotation(this.integerArrayInput);
	}
	
	//Operation method
	private Integer[] lexMinRotation(Integer[] input){
		Integer[] minArray = new Integer[input.length];
		CombSet allRotations = new CombSet(); 
		if (input.length > 1) {
			for (int i = 0; i < input.length; i++) {
				Integer[] tempArray = new Integer[input.length];
				tempArray = input;
				for (int j = 0; j < i; j++) {
					tempArray = arrayRotateRight(tempArray);
				}
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
	
		//Supporter methods
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