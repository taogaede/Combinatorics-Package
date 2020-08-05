package combinatorics.core.elements;

public class ElementTyper {

	private Integer integerValue = null;
	private Integer[] integerArrayValue = null;
	private Integer[][] integerMatrixValue = null;
	private Double doubleValue = null;
	private Double[] doubleArrayValue = null;
	private Double[][] doubleMatrixValue = null;
	private String stringValue = null;
	private String[] stringArrayValue = null;
	private String[][] stringMatrixValue = null;
	private Element elementValue = null;
	
	public ElementTyper() {}
	
	//Need to fill at end of operation code
	
	public Element asElement(Integer unboxed) {return new IntegerElement(unboxed);}
	public Element asElement(Double unboxed) {return new DoubleElement(unboxed);}
	public Element asElement(String unboxed) {return new StringElement(unboxed);}
	public Element asElement(Integer[] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.getValue()[i] = new IntegerElement(unboxed[i]);
		}
		return temp;
	}
	public Element asElement(Double[] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.getValue()[i] = new DoubleElement(unboxed[i]);
		}
		return temp;
	}
	public Element asElement(String[] unboxed) {
		ArrayElement temp = new ArrayElement();
		temp.value = new Element[unboxed.length];
		for (int i = 0; i < unboxed.length; i++) {
			temp.getValue()[i] = new StringElement(unboxed[i]);
		}
		return temp;
	}
	public Element asElement(Integer[][] unboxed) {
		ArrayElement temp = new ArrayElement();
		for (int i = 0; i < temp.value.length; i++) {
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
	public Element asElement(Double[][] unboxed) {
		ArrayElement temp = new ArrayElement();
		for (int i = 0; i < temp.value.length; i++) {
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
	public Element asElement(String[][] unboxed) {
		ArrayElement temp = new ArrayElement();
		for (int i = 0; i < temp.value.length; i++) {
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
	
	//Need to empty at beginning of operation code
	
	public void empty(Element boxed) {
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
	private void unboxSingleton(Element boxed) {
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
	private void unboxArray(Element boxed) {
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
	private void unboxMatrix(Element boxed) {
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

	private void setNull() {
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
	
	public Object asValue(Element input) { //Need to cast after unboxing at beginning of operation code
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
	public Element getElement() {
		return elementValue;
	}
}
