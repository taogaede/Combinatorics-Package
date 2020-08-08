package combinatorics.core.tools.comparing;

import java.util.Arrays;
import combinatorics.core.math.interfaces.Orderable;

public class Comparer {
	private static Object first = null;
	private static Object second = null;

	public static boolean getIsEqual(Object firstValue, Object secondValue) {
		first = firstValue;
		second = secondValue;
		if (first.getClass().isArray() && second.getClass().isArray()) {
			return Arrays.deepEquals((Object[]) first, (Object[]) second);
		} else {
			return first.equals(second);
		}
	}
}