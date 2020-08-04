package combinatorics.core.elements;

import java.util.ArrayList;

public class Unboxer {

	private Integer integerValue;
	private Integer[] integerArrayValue;
	private Integer[][] integerMatrixValue;
	private Double doubleValue;
	private Double[] doubleArrayValue;
	private Double[][] doubleMatrixValue;
	private String stringValue;
	private String[] stringArrayValue;
	private String[][] stringMatrixValue;
	
	
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
			
			Integer dimension = 1;
			ArrayList<Integer> size = new ArrayList<Integer>();
			dimensionAndSizeCounter(temp, dimension, size);
			
			//With dimension and sizes, make a while loop that creates the array list from ArrayElement
			Integer order = dimension;
			ArrayList<Element> tempAsList = new ArrayList<Element>();
			
			
			
			while (order > 0) {
				for (int i = 0; i < temp.getValue().length; i++) {
					
				}
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
