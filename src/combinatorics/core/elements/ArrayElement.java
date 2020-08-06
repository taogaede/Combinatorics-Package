package combinatorics.core.elements;

import java.util.ArrayList;

import combinatorics.core.Comparer;

public class ArrayElement implements Element, Arithmetic {
	
	public Element[] value;
	
	public Integer dimension;
	public Integer[] size;
	
	public ArrayElement() {}
	
	public ArrayElement(Element[] value) {
		this.value = value;
	}
	public void blah(ArrayList<IntegerElement> hey) {
		new ArrayElement(hey);
	}
	public ArrayElement(ArrayList<?> value) {	//This constructor exists for the cases when it's easier to work with lists than arrays during a construction (eg appending when you don't know the size).s
		this.value = value.toArray(new Element[value.size()]);
	}
	
	public ArrayElement(Integer dimension, int[] sizes) {
		if (dimension == 1) {
			new ArrayElement(new Element[sizes[0]]);
			return;
		}
		ArrayElement[] iOrderArray = new ArrayElement[dimension];
		iOrderArray[0] = new ArrayElement(new Element[sizes[0]]); //Elements don't have values, so maybe this is the problem?
		for (int i = 1; i < dimension; i++) {
			iOrderArray[i] = new ArrayElement(new ArrayElement[sizes[i]]);
			for (int j = 0; j < sizes[i]; j++) {
				iOrderArray[i].value[j] = iOrderArray[i - 1];
				System.out.println(i + " " + j);
			}
		}
	}
	
	//-- n-dimensional array constructor section --//
	/*
	public ArrayElement(Integer dimension, int[] sizes) {
		nDimensionalArrayMaker(dimension, sizes);
	}
	
	private void nDimensionalArrayMaker(Integer dimension, int[] sizes) {
		new ArrayElement(new Element[sizes[ sizes.length - 1 ]]);
		nDimensionalArrayMakerHelper(this, dimension, sizes);
	}
	
	private void nDimensionalArrayMakerHelper(ArrayElement array, Integer currentDimension, int[] sizes) {
		
		if (currentDimension > 1) {
			for (int i = 0; i < sizes[currentDimension - 2]; i++) {
				array.value[i] = new ArrayElement( new Element[ sizes[currentDimension - 2] ] );
				nDimensionalArrayMakerHelper( (ArrayElement) array.value[i], currentDimension - 1, sizes );
			}
		}
	*/
		/*
		if (currentDimension == 1) {
			array.value = new Element[ sizes[currentDimension - 1] ];
			
			/*
			if (type == "integer") {
				array.value = new IntegerElement[ sizes[currentDimension - 1] ];
				//array = new ArrayElement( new IntegerElement[ sizes[currentDimension - 1] ]);
				System.out.println(array.toString() + " " + array.value.getClass() + " " + array.value.length );
				return;
			}
			*/
		/*
			if (type == "double") {
				
				array.value = new DoubleElement[ sizes[currentDimension] ];
				return;
			}
			if (type == "string") {
				array.value = new StringElement[ sizes[currentDimension] ];
				return;
			}
			
		}
		
	}
	*/
	//-- n-dimensional array constructor section --//
	
	public Element add(Element other) {
		ArrayElement sum = new ArrayElement( new Element[this.value.length] );
		if (other instanceof ArrayElement) {	//n-dimensional component-wise addition
			if (this.value.length == ( (ArrayElement) other).value.length) {	//makes sure the arrays are the same size
				for (int i = 0; i < this.value.length; i++) {
					sum.value[i] = this.value[i].add( ( (ArrayElement) other ).value[i]);
				}
			}
		}
		else {
			for (int i = 0; i < this.value.length; i++) {	//add other value to each component of array
				sum.value[i] = this.value[i].add(other);
			}
		}
		return sum;
	}
	
	@Override
	public Element multiply(Element other) { //untested
		ArrayElement product = new ArrayElement( new Element[this.value.length] );
		if (other instanceof ArrayElement) {	//n-dimensional component-wise multiplication
			if (this.value.length == ( (ArrayElement) other).value.length) {	//makes sure the arrays are the same size
				for (int i = 0; i < this.value.length; i++) {
					product.value[i] = this.value[i].multiply( ( (ArrayElement) other ).value[i]);
				}
			}
		}
		else {
			for (int i = 0; i < this.value.length; i++) {	//multiply other value to each component of array
				product.value[i] = this.value[i].multiply(other);
			}
		}
		return product;
	}

	@Override
	public boolean isEqualTo(Element other) {
		return Comparer.getIsEqual(this, other);
	}

	@Override
	public boolean isGreaterThan(Element other) { //element-wise compare.  If this has more entries that are larger than other, then this is greater.
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void print() {
		for (int i = 0; i < this.value.length; i++) {
			this.value[i].print();
			System.out.print("");
		}
		System.out.println();
	}

	public String getString() {
		String result = "";
		for (int i = 0; i < this.getValue().length; i++) {
			result = result.concat(this.getValue()[i].getString()) + "/n";
		}
		return result;
	}
	
	@Override
	public Element[] getValue() {
		return this.value;
	}
}
