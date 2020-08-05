package combinatorics;

import java.util.Arrays;

import combinatorics.core.CombinatorialSet;
import combinatorics.core.Function;
import combinatorics.core.elements.*;
import combinatorics.functions.composite.*;
import combinatorics.functions.elementary.*;
import combinatorics.sets.*;

public class Main {

	public static void main(String[] args) {
		Integer[][] array2D = new Integer[4][4];
		for(int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[0].length; j++) {
				array2D[i][j] = i*j;
			}
		}
		
		CombinatorialSet matrix = new Matrix(array2D);
		matrix.print();
	}
	
	public static void printSet(CombinatorialSet set) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof CombinatorialSet) { //Need to have it so it prints an arraylist<combinatoricsSet> :D
				printSet( (CombinatorialSet) set.get(i));
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
	public static void printSet(CombinatorialSet set, CombinatorialSet set2) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof CombinatorialSet) {
				printSet( (CombinatorialSet) set.get(i));
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
	public static void printSet(CombinatorialSet set, int n) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof CombinatorialSet) {
				printSet( (CombinatorialSet) set.get(i));
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
	public static void printSet(CombinatorialSet set, CombinatorialSet set2, int n) {
		if (set.size() != set2.size()) {
			System.out.println("Sets not of equal size.");
			return;
		}
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) instanceof CombinatorialSet) {
				printSet( (CombinatorialSet) set.get(i));
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
}
