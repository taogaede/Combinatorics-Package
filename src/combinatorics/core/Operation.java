package combinatorics.core;

public class Operation {
	
	//Empty constructor
	public Operation() {	
	}
	
	//CombSet operate set method
	protected CombinatorialSet operateSet(CombinatorialSet set) {	
		
		/*	Implemented input/output combinations (these are by set element, so a CombSet may contain multiple input types):
		 * 
		 * 	Input CombSet contains : Output CombSet contains:
		 * 							
		 * 		Integer : Integer[]
		 * 		Integer : Integer
		 * 		Integer[] : Integer[]
		 * 		Integer[] : Integer
		 * 		Double : Double[]
		 * 		Double : Double
		 * 		Double[] : Double[]
		 * 		Double[] : Double
		 * 		String : String[]
		 * 		String : String
		 * 		String[] : String[]
		 * 		String[] : String
		 * 
		 */
		
		CombinatorialSet result = new CombinatorialSet();
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
	protected void setInput(CombinatorialSet input) {
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

