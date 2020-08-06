package combinatorics.core;

import combinatorics.core.elements.Element;

public class Printer {	
	public static void printSet(FiniteSet set) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof FiniteSet) { //Need to have it so it prints an arraylist<combinatoricsSet> :D
				printSet( (FiniteSet) set.get(i));
				System.out.println();
			}
			else {
				System.out.print(i + ": ");	
				printElement(set.get(i));
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	public static void printSet(FiniteSet set, FiniteSet set2) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof FiniteSet) {
				printSet( (FiniteSet) set.get(i));
				System.out.println();
			}
			else {
				System.out.print(i + ": ");	
				printElement(set.get(i)); System.out.print("--- ");printElement(set2.get(i));
				System.out.print(" ");
				System.out.println();
			}
		}
		System.out.println();
	}
	public static void printSet(FiniteSet set, int n) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof FiniteSet) {
				printSet( (FiniteSet) set.get(i));
				System.out.println();
			}
			else {
				if (i > 0 && i % n == 0) {
					System.out.println();
				}
				System.out.print(i + ": ");
				printElement(set.get(i));
				System.out.print("  ");
			}
		}
		System.out.println();
	}
	public static void printSet(FiniteSet set, FiniteSet set2, int n) {
		if (set.size() != set2.size()) {
			System.out.println("Sets not of equal size.");
			return;
		}
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof FiniteSet) {
				printSet( (FiniteSet) set.get(i));
				System.out.println();
			}
			else {
				if (i > 0 && i % n == 0) {
					System.out.println();
				}
				System.out.print(i + ": ");
				printElement(set.get(i)); System.out.print(" --> ");printElement(set2.get(i));
				System.out.print("  ");
				System.out.println();
			}
		}
		System.out.println();
	}
	private static void printElement(Element element) {
		element.print();
	}
	public static void printFunction(Function function) {
		function.print();
	}
	public static void printFunctionFull(Function function) {
		
	}

}
