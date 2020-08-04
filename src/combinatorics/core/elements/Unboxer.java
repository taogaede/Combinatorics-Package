package combinatorics.core.elements;

import java.util.ArrayList;

public class Unboxer {

	private Integer integerValue = null;
	private Integer[] integerArrayValue = null;
	private Integer[][] integerMatrixValue = null;
	private Double doubleValue = null;
	private Double[] doubleArrayValue = null;
	private Double[][] doubleMatrixValue = null;
	private String stringValue = null;
	private String[] stringArrayValue = null;
	private String[][] stringMatrixValue = null;
	
	
	public Unboxer(Element boxed) {
		if (boxed.getClass() == IntegerElement.class) {
			integerValue = ( (IntegerElement) boxed).getValue();
		}
		if (boxed.getClass() == DoubleElement.class) {
			doubleValue = ( (DoubleElement) boxed).getValue();
		}
		if (boxed.getClass() == StringElement.class) {
			stringValue = ( (StringElement) boxed).getValue();
		}
		if (boxed.getClass() == ArrayElement.class) {
			ArrayElement temp = (ArrayElement) boxed;
			if (temp.getValue()[0].getClass() == IntegerElement.class) {
				integerArrayValue = 
			}
		}
	}
	
	/*
	private void dimensionAndSizeCounter(ArrayElement currentArray, Integer order, ArrayList<Integer> size) {
		order += 1;
		size.add(currentArray.getValue().length);
		if (currentArray.getValue()[0].getValue().getClass() == ArrayElement.class) {
			ArrayElement nextArray = (ArrayElement) currentArray.getValue()[0];
			dimensionAndSizeCounter( nextArray, order, size);
		}
	}
	*/
	
	public Object getValue() {
		if (integerValue != null) return integerValue;
		if (doubleValue != null) return doubleValue;
		if (stringValue != null) return stringValue;
		if (integerArrayValue != null) return integerArrayValue;
		if (doubleArrayValue != null) return doubleArrayValue;
		if (stringArrayValue != null) return stringArrayValue;
		return null;
	}
	
}
