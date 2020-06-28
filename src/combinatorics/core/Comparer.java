package combinatorics.core;

import java.util.Arrays;

public class Comparer {
	private final Object first;
	private final Object second;
	
	public Comparer(Object first, Object second) {
		this.first = first;
		this.second = second;
	}

	public boolean getIsEqual() {
		if (first.getClass().isArray() && second.getClass().isArray()) {
			return Arrays.deepEquals((Object[]) first, (Object[]) second);
		} else {
			return first.equals(second);
		}
	}
}