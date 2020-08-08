package combinatorics.core.elements;

public interface ArithmeticElement extends Element {

	public ArithmeticElement add(ArithmeticElement other);
	public ArithmeticElement subtract(ArithmeticElement other);
	public ArithmeticElement multiply(ArithmeticElement other);
	public ArithmeticElement raisedBy(ArithmeticElement other);
}
