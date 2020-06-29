package combinatorics.functions.elementary;

import combinatorics.core.Function;
import combinatorics.operations.AddOp;

/*
 * Operation Calling Function Subclasses
 *
 * (Make sure there is a class for every operation subclass, and that there is a function subclass constructor for each corresponding operation subclass constructor.
 *
 * These subclasses exist to make it so the user doesn't have to interact with Operation subclasses, only CombSets and Functions.
 *
 * Without these operation calling function subclasses, initializing an elementary function would look like this:
 *
 * Function yourFunction = new Function(new yourOperation());
 *
 * With operation calling function subclasses, initializing looks like this:
 *
 * Function yourFunction = new YourFunction();
 *
 * For example:
 * To create a function that adds 13 to every element in my CombSet, I would write:
 *
 * Function myAddFunction = new Add(13);
 *
 */
/*
					BEGIN TEMPLATE

class OperationName extends Function{
	//Make sure there is a constructor here with arguments identical to every constructor in the corresponding Operation subclass
	public OperationName(){
		super(new OperationNameOp());
	}
}

					END TEMPLATE

 */
public class Add extends Function {
	public Add(Integer n) {
		super(new AddOp(n));
	}
	public Add(Double n) {
		super(new AddOp(n));
	}
}
