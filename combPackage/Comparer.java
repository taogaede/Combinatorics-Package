package combPackage;

public class Comparer {
	private boolean isEqual;
	private String first;
	private String Second;
	
	public Comparer() {
		
	}
	public Comparer(Object first, Object second) {	

		//Sequences
		if (first instanceof Integer[] && second instanceof Integer[]) {
			this.isEqual = equals( (Integer[]) first, (Integer[]) second);
		}
		if (first instanceof Double[] && second instanceof Double[]) {
			this.isEqual = equals( (Double[]) first, (Double[]) second);
		}
		if (first instanceof String[] && second instanceof String[]) {
			this.isEqual = equals( (String[]) first, (String[]) second);
		}
		
		//Matrices
		if (first instanceof Integer[][] && second instanceof Integer[][]) {
			this.isEqual = equals( (Integer[][]) first, (Integer[][]) second);
		}
		if (first instanceof Double[][] && second instanceof Double[][]) {
			this.isEqual = equals( (Double[][]) first, (Double[][]) second);
		}
		if (first instanceof String[][] && second instanceof String[][]) {
			this.isEqual = equals( (String[][]) first, (String[][]) second);
		}

		this.isEqual = first.equals(second);
	}
	
	public boolean getIsEqual() {
		return this.isEqual;
	}

	//Equals methods
	public boolean equals(Integer first, Integer second) {
		if (first != second) return false;
		return true;
	}
	public boolean equals(Double first, Double second) {
		if (first != second) return false;
		return true;
	}	
	public boolean equals(String first, String second) {
		if (!first.equals(second)) return false;
		return true;
	}
	public boolean equals(Integer[] first, Integer[] second) {
		if (first.length != second.length) {
			return false;
		}
		for (int i = 0; i < second.length; i++) {
			if (first[i] != second[i]) {
				return false;
			}
		}
		return true;
	}
	public boolean equals(Double[] first, Double[] second) {
		if (first.length != second.length) {
			return false;
		}
		for (int i = 0; i < second.length; i++) {
			if (first[i] != second[i]) {
				return false;
			}
		}
		return true;
	}
	public boolean equals(String[] first, String[] second) {
		if (first.length != second.length) {
			return false;
		}
		for (int i = 0; i < second.length; i++) {
			if (first[i] != second[i]) {
				return false;
			}
		}
		return true;
	}
	public boolean equals(Integer[][] first, Integer[][] second) {
		if (first.length != second.length) return false;
		for (int i = 0; i < first.length; i++) {
			if (first[i].length != second[i].length) return false;
			for (int j = 0; j < first[i].length; j++) {
				if (first[i][j] != second[i][j]) return false;
			}
		}
		return true;
	}
	public boolean equals(Double[][] first, Double[][] second) {
		if (first.length != second.length) return false;
		for (int i = 0; i < first.length; i++) {
			if (first[i].length != second[i].length) return false;
			for (int j = 0; j < first[i].length; j++) {
				if (first[i][j] != second[i][j]) return false;
			}
		}
		return true;
	}
	public boolean equals(String[][] first, String[][] second) {
		if (first.length != second.length) return false;
		for (int i = 0; i < first.length; i++) {
			if (first[i].length != second[i].length) return false;
			for (int j = 0; j < first[i].length; j++) {
				if ( first[i][j].equals(second[i][j]) ) return false;
			}
		}
		return true;
	}
}