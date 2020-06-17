# Combinatorics Project
## What This is
Compartmentalization and annotation framework(?) and package(?) for studying constructions of, and functions on, finite sets of numbers/characters, as elements, in sequences, and in matrices.

It consists of Operation, Function, and CombSet (combinatorial set) classes.  The user can append subclass extensions of these classes to define their own operations, functions, and combinatorial sets that can be easily called by the main method in class Main.

The main advantage of this framework is that it allows the user to compartmentalize, annotate, and then abstract the code for their set constructions, transformation algorithms, and elementary set operations.
Compartmentalization and abstraction enables the user to confine the mathematical problem solving and intuition building strictly to high level procedural coding in the main method, which calls the underlying lower level code contained within the other classes and their subclasses.


## How To Use
1.	Using the provided template, create subclass extension of the *CombSet* class, and include your set construction code in the subclass constructor.  Your set of interest will then be the CombSet subclass instance called from this constructor by the main method in class Main.

2.	Using the provided template, create subclass extensions of the *Operation* class that contain the code for performing the desired operation on each element, sequence, or matrix in your set of interest.

3.	In the main method of class Main, 
	1.	create your initial domain CombSet of interest, 

			CombSet domain = new YourCombSetSubClass();

	2.	create a new Function object with your domain as its argument, 

			Function yourFunction = new Function(domain);

	3.	and use the following command to assign your operations in the order they are to be applied to the domain set (repeat this step for each operation):

			yourFunction.addRule(new Function(new YourOperation())); 

	4. To print the results, use

			printSet(yourFunction.operate());

4.	To preserve your function for later research sessions, you can create a new Function subclass (following the template provided) and place the relevant code from the main method of class Main into the subclass constructor.  
	Similarly, if you want to preserve a set that you've found in your current session for later, you can use the CombSet subclass template and place the construction code (from the main method of class Main) into the subclass constructor.

## Abstraction Control

There is also a system for recalling what a function (and consequently, set construction algorithm) of any level of abstraction does:
+	Since each Function instance has a corresponding String description specifying what it does, and all CombSets are constructed from a sequence of functions applied to a basic set, the steps of all CombSet construction algorithms within this framework are accessible.

To access the descriptions of the initial domain set and sequence of steps in the algorithm to create a given CombSet, use:

	yourCombSet.printDescription();

For Function descriptions, use:

	yourFunction.printDescription();

and

	yourFunction.printFullDescription();

The former prints the descriptions of only the functions making up yourFunction's rule array, which may themselves be composition functions (abstract).
The latter prints the descriptions of all functions contained within yourFunction.  This includes all functions in yourFunction's rule array as well as the functions in their rule arrays, and so on, until and including the elementary functions (those that only apply the operation described by an Operation subclass).



