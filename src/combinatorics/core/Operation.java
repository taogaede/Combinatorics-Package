package combinatorics.core;

import combinatorics.core.elements.*;

public class Operation implements Printable{
	private String description = "This is the base Operation description.  It's not very interesting.";
	
	public CombinatorialSet operateSet(CombinatorialSet set) {	
		
		CombinatorialSet result = new CombinatorialSet();
		if (set.size() > 0) {	
			for (int i = 0; i < set.size(); i++) {
				Element elementOutput = operate(set.get(i));
				if (elementOutput != null){
					result.add(elementOutput);
				}
			}
		}
		if (set.size() == 0){
			System.out.println("Set is empty");
		}
		return result;
	}
	
	public Element operate(Element input) {
		if (input instanceof IntegerElement) {
			IntegerElement castedInput = (IntegerElement) input;	//cast input Element to appropriate Element type
			if (input.getType() == "single") return operation(castedInput.getSingleValue());	//operate on Integer 		(integer element)
			if (input.getType() == "sequence") return operation(castedInput.getSequenceValue());//operate on Integer[]		(integer sequence)
			if (input.getType() == "matrix") return operation(castedInput.getMatrixValue());	//operate on Integer[][]	(integer matrix)
		}
		if (input instanceof DoubleElement) {
			DoubleElement castedInput = (DoubleElement) input;	//cast input Element to appropriate Element type
			if (input.getType() == "single") return operation(castedInput.getSingleValue());	//operate on Double			(rational element)
			if (input.getType() == "sequence") return operation(castedInput.getSequenceValue());//operate on Double[]		(rational sequence)
			if (input.getType() == "matrix") return operation(castedInput.getMatrixValue());	//operate on Double[][]		(rational matrix)
		}
		if (input instanceof StringElement) {
			StringElement castedInput = (StringElement) input;	//cast input Element to appropriate Element type
			if (input.getType() == "single") return operation(castedInput.getSingleValue());	//operate on String			(string element)
			if (input.getType() == "sequence") return operation(castedInput.getSequenceValue());//operate on String[]		(string sequence)
			if (input.getType() == "matrix") return operation(castedInput.getMatrixValue());	//operate on String[][]		(string matrix)
		}
		return null;
	}
	
	public Element operation(Integer dummy) {return null;};
	public Element operation(Integer[] dummy) {return null;};
	public Element operation(Integer[][] dummy) {return null;};
	public Element operation(String dummy) {return null;};
	public Element operation(String[] dummy) {return null;};
	public Element operation(String[][] dummy) {return null;};
	public Element operation(Double dummy) {return null;};
	public Element operation(Double[] dummy) {return null;};
	public Element operation(Double[][] dummy) {return null;};
	
	//Overridden description getter
	protected String getDescription() {
		return "";
	}
	
	public void print() {
		System.out.println(this.description);
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
 * 			We use an unused "dummy" variable here for method overloading purposes, 
 * 			because all this method does is select the correct input field to operate on.
 * 
 * 	6.	Private operation method for each of your operate methods from (5).  
 * 		It is in these methods where the substantial operation happens, that is, 
 * 		where the input gets converted to the corresponding output.
 * 			Can also include any necessary (private) supporter methods that will be called by the operation method.
 * 
 *	7.	Public description getter method.  This method overrides the Operation class description getter, 
 *		so it must be called: public void getDescription().  
 * 
 */

/*

//				BEGIN TEMPLATE
class NewOperation extends Operation{
	
	 // Implemented input/output combinations:
	 // 
	 // Input : Output
	 // 			
	 // InputType : OutputType
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
	private <OutputType> newOperation(<InputType> input){
		<OutputType> result = new <Output Type>();
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

