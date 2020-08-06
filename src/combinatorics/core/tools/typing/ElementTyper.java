package combinatorics.core.tools.typing;

import combinatorics.core.elements.ArrayElement;
import combinatorics.core.elements.DoubleElement;
import combinatorics.core.elements.Element;
import combinatorics.core.elements.IntegerElement;
import combinatorics.core.elements.StringElement;

public class ElementTyper {
	
	//ElementTyper converts values between the generic Element type (used in back-end) to the following particular types (used by users (front-end)):
	//
	//Back-end:		(Composite Design Pattern)
	//Element
	//ArrayElement
	//IntegerElement,	DoubleElement,	StringElement
	//
	//Front-end:	(Normal Java Types)
	//Integer,	Integer[],	Integer[][]
	//Double,	Double[],	Double[][]
	//String,	String[],	String[][]
	//
	//This approach to type handling was used because I needed a way to ensure users could use the above Java types, which are likely 
	//most familiar to them.  This hopefully reduces the barrier to entry!
	//
	//Specifically, the "Element" types are part of the back-end that enables the Operation framework to function.
	//The ElementTyper should be the only place where the user deals with "Element" types: 
	//(1) the user will tell ElementTyper to convert an input from Element to particular type at beginning of Operation subclass operation method
	//(2) the user will tell ElementTyper to convert an output from particular type to Element at end of Operation subclass operation method
	//
	//I think much work could be done to clean up the ElementTyper code, since there are several conditionals and copy-pasted sections, 
	//but at least this messy code is contained in one spot and in the back-end!
	//If you have bright ideas on how to drastically improve the implementation of ElementTyper, please let me know!
	//
	//In terms of development, it would be pretty straightforward to add 3d array and 4d array functionality.  
	//One would just need to add the appropriate conversion functionality to ElementTyper.
	//However, adding functionality to handle different Java types like Long, Float, and so on, would require the implementation of corresponding
	//Element types like "LongElement" and "FloatElement".  ElementTyper would then need to handle these new conversions as well.
	//This wouldn't be too hard to implement, but I just haven't had the time nor significant reason to do it yet.
	
	
	private static Integer integerValue = null;
	private static Integer[] integerArrayValue = null;
	private static Integer[][] integerMatrixValue = null;
	private static Double doubleValue = null;
	private static Double[] doubleArrayValue = null;
	private static Double[][] doubleMatrixValue = null;
	private static String stringValue = null;
	private static String[] stringArrayValue = null;
	private static String[][] stringMatrixValue = null;
	
	//Packages particular value type to Element type
	
	public static Element toElement(Integer unboxed) {return new IntegerElement(unboxed);}
	public static Element toElement(Double unboxed) {return new DoubleElement(unboxed);}
	public static Element toElement(String unboxed) {return new StringElement(unboxed);}
	public static Element toElement(Integer[] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.getValue()[i] = new IntegerElement(unboxed[i]);
		}
		return temp;
	}
	public static Element toElement(Double[] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.getValue()[i] = new DoubleElement(unboxed[i]);
		}
		return temp;
	}
	public static Element toElement(String[] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.getValue()[i] = new StringElement(unboxed[i]);
		}
		return temp;
	}
	public static Element toElement(Integer[][] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.value[i] = new ArrayElement();
			ArrayElement iTemp = ((ArrayElement) temp.value[i]);
			iTemp.value = new Element[unboxed[0].length];
			
			for (int j = 0; j < iTemp.value.length; j++) {
				iTemp.value[j] = new IntegerElement(unboxed[i][j]);
			}
			temp.value[i] = iTemp;
		}	
		return temp;
	}
	public static Element toElement(Double[][] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.value[i] = new ArrayElement();
			ArrayElement iTemp = ((ArrayElement) temp.value[i]);
			iTemp.value = new Element[unboxed[0].length];
			
			for (int j = 0; j < iTemp.value.length; j++) {
				iTemp.value[j] = new DoubleElement(unboxed[i][j]);
			}
			temp.value[i] = iTemp;
		}	
		return temp;
	}
	public static Element toElement(String[][] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.value[i] = new ArrayElement();
			ArrayElement iTemp = ((ArrayElement) temp.value[i]);
			iTemp.value = new Element[unboxed[0].length];
			
			for (int j = 0; j < iTemp.value.length; j++) {
				iTemp.value[j] = new StringElement(unboxed[i][j]);
			}
			temp.value[i] = iTemp;
		}	
		return temp;
	}
	
	//Unpackages particular value type from Element type
	
	public static Object toValue(Element input) { //Need to cast after unboxing at beginning of operation code
		empty(input);
		if (integerValue != null) return integerValue;
		if (doubleValue != null) return doubleValue;
		if (stringValue != null) return stringValue;
		if (integerArrayValue != null) return integerArrayValue;
		if (doubleArrayValue != null) return doubleArrayValue;
		if (stringArrayValue != null) return stringArrayValue;
		if (integerMatrixValue != null) return integerMatrixValue;
		if (doubleMatrixValue != null) return doubleMatrixValue;
		if (stringMatrixValue != null) return stringMatrixValue;
		return null;
	}
	private static void empty(Element boxed) {
		if (boxed.getClass() != ArrayElement.class) unboxSingleton(boxed);
		if (boxed.getClass() == ArrayElement.class) {
			if ( ( (ArrayElement) boxed).getValue()[0].getClass() == ArrayElement.class) {
				unboxMatrix(boxed);
			}
			else {
				unboxArray(boxed);
			}
		}
	}
	private static void unboxSingleton(Element boxed) {
		if (boxed.getClass() == IntegerElement.class) {
			setNull();
			integerValue = ( (IntegerElement) boxed).getValue();
		}
		if (boxed.getClass() == DoubleElement.class) {
			setNull();
			doubleValue = ( (DoubleElement) boxed).getValue();
		}
		if (boxed.getClass() == StringElement.class) {
			setNull();
			stringValue = ( (StringElement) boxed).getValue();
		}
	}
	private static void unboxArray(Element boxed) {
		setNull();
		ArrayElement temp = (ArrayElement) boxed;
		if (temp.getValue()[0].getClass() == IntegerElement.class) {
			integerArrayValue = new Integer[temp.getValue().length];
			for (int i = 0; i < temp.getValue().length; i++) {
				integerArrayValue[i] = (Integer) temp.getValue()[i].getValue();
			}
		}
		if (temp.getValue()[0].getClass() == DoubleElement.class) {
			doubleArrayValue = new Double[temp.getValue().length];
			for (int i = 0; i < temp.getValue().length; i++) {
				doubleArrayValue[i] = (Double) temp.getValue()[i].getValue();
			}
		}
		if (temp.getValue()[0].getClass() == StringElement.class) {
			stringArrayValue = new String[temp.getValue().length];
			for (int i = 0; i < temp.getValue().length; i++) {
				stringArrayValue[i] = (String) temp.getValue()[i].getValue();
			}
		}
	}
	private static void unboxMatrix(Element boxed) {
		setNull();
		ArrayElement temp = (ArrayElement) boxed;
		if ( ( (ArrayElement) temp.getValue()[0]).getValue()[0].getClass() == IntegerElement.class) {
			Integer rows = temp.getValue().length;
			Integer columns = ( (ArrayElement) temp.getValue()[0]).getValue().length;
			integerMatrixValue = new Integer[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					ArrayElement iArray = (ArrayElement) temp.getValue()[i];
					IntegerElement ijInteger = (IntegerElement) iArray.getValue()[j];
					integerMatrixValue[i][j] = ijInteger.getValue();
				}
			}
		}
		if ( ( (ArrayElement) temp.getValue()[0]).getValue()[0].getClass() == DoubleElement.class) {
			Integer rows = temp.getValue().length;
			Integer columns = ( (ArrayElement) temp.getValue()[0]).getValue().length;
			doubleMatrixValue = new Double[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					ArrayElement iArray = (ArrayElement) temp.getValue()[i];
					DoubleElement ijDouble = (DoubleElement) iArray.getValue()[j];
					doubleMatrixValue[i][j] = ijDouble.getValue();
				}
			}
		}
		if ( ( (ArrayElement) temp.getValue()[0]).getValue()[0].getClass() == StringElement.class) {
			Integer rows = temp.getValue().length;
			Integer columns = ( (ArrayElement) temp.getValue()[0]).getValue().length;
			stringMatrixValue = new String[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					ArrayElement iArray = (ArrayElement) temp.getValue()[i];
					StringElement ijString = (StringElement) iArray.getValue()[j];
					stringMatrixValue[i][j] = ijString.getValue();
				}
			}
		}
	}

	//Resets all values to null
	
	private static void setNull() {
		integerValue = null;
		integerArrayValue = null;
		integerMatrixValue = null;
		doubleValue = null;
		doubleArrayValue = null;
		doubleMatrixValue = null;
		stringValue = null;
		stringArrayValue = null;
		stringMatrixValue = null;
	}
	
	
}
