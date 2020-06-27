# Combinatorics Project 

 Work In Progress.  Early development: contains bugs.  Suggestions welcome :).

 **WARNING**: readme may contain LIES (descriptions of obsolete content)

## What This is
Compartmentalization and annotation framework for studying constructions of, and functions on, finite sets of numbers/strings, as elements, in sequences, and in matrices.

At the moment, this project mainly exists to assist my own learning of mathematics and software development.  However, if you're interested in using the framework, and want to help build the operation library, I would be thrilled to hear from you!

## Who This is For
Anyone interested in studying finite sets and their constructions using java, and who feels they'd benefit from having a framework to compartmentalize and annotate their code.

(I would be interested in making this work in other languages, but I don't know other languages at this time, so that would be a later project)



## More Details
Other than the Main class, the framework consists of *Operation*, *Function*, and *CombSet* (combinatorial set) classes.  The user can append subclass extensions of these classes to define their own operations, functions, and combinatorial sets that can be easily called by the main method in class *Main*.

The advantages of this framework are that it allows the user to compartmentalize, annotate, and then abstract the code for their set constructions, transformation algorithms, and elementary set operations.
Compartmentalization and abstraction enables the user to confine the mathematical problem solving and intuition building strictly to high level procedural coding in the main method, which calls the underlying lower level code contained within the other classes and their subclasses.


## How To Use
1.	Using the provided template, create subclass extension of the *CombSet* class, and include your set construction code in the subclass constructor.  Your set of interest will then be the *CombSet* subclass instance called from this constructor by the main method in class *Main*.

2.	Using the provided template, create subclass extensions of the *Operation* class that contain the code for performing the desired operation on each element, sequence, or matrix in your set of interest.

3.	In the main method of class *Main*, 
	1.	create your initial domain *CombSet* of interest, 

			CombSet domain = new YourCombSetSubClass();

	2.	create a new *Function* object with your domain as its argument, 

			Function yourFunction = new Function(domain);

	3.	and use the following command to assign your operations in the order they are to be applied to the domain set (repeat this step for each operation):

			yourFunction.addRule(new Function(new YourOperation())); 

	4. To print the results, use

			printSet(yourFunction.operate());

4.	To preserve your function for later research sessions, you can create a new *Function* subclass (following the template provided) and place the relevant code from the main method of class *Main* into the subclass constructor.  
	Similarly, if you want to preserve a set that you've found in your current session for later, you can use the *CombSet* subclass template and place the construction code (from the main method of class *Main*) into the subclass constructor.

## Abstraction Control

There is also a system for recalling what a function (and consequently, set construction algorithm) of any level of abstraction does:
+	Since each *Function* instance has a corresponding *String* description specifying what it does, and all CombSets are constructed from a sequence of functions applied to a basic set, the steps of all CombSet construction algorithms within this framework are accessible.

To access the descriptions of the initial domain set and sequence of steps in the algorithm to create a given *CombSet*, use:

	yourCombSet.printDescription();

For *Function* descriptions, use:

	yourFunction.printDescription();

and

	yourFunction.printFullDescription();

+	The former prints the descriptions of only the functions making up yourFunction's rule array, which may themselves be composition functions (abstract).
+	The latter prints the descriptions of all functions contained within yourFunction.  This includes all functions in yourFunction's rule array as well as the functions in their rule arrays, and so on, until and including the elementary functions (those that only apply the operation described by an *Operation* subclass).


## *Operation* Subclass Components and Template
### Components
Each newly defined *Operation* subclass must have the following components (refer to template immediately below):
  
1.	Private input fields
  
2.	A one sentence private *String* description field that succinctly describes what your operation does.
  
3.	Public constructor method(s)
 
4.	Protected input setter methods for each of your inputs not initialized through a constructor.
	Input setter methods must override the corresponding *Operation* input setter method, so it must be named:

		protected void setInput(<InputType> input)

5.	Protected operate type methods for each of your inputs not initialized through a constructor.
	Operate type methods also override a corresponding *Operation* superclass method, so they must be named as follows:

		protected <OutputType> operateTypeOutputType(<InputType> dummy)

	We use an unused "dummy" variable here for method overloading purposes, 
	because all this method does is select the correct input field to operate on.
  
6.	Private operation method for each of your operate methods from (5).  
	It is in these methods where the substantial operation happens, that is, 
	where the input gets converted to the corresponding output.
		Can also include any necessary (private) supporter methods that will be called by the operation method.
  
7.	Public description getter method.  This method overrides the *Operation* class description getter, 
	so it must be called: 

		public void getDescription()

### Template
	class NewOperation extends Operation{
		// Implemented input/output combinations:
		// 
		// Input : Output
		// 			
		// InputType : OutputType
		// 				
	 
		//Input
		private <InputType> inputTypeInput;
	
		//Input2 (If the operation subclass constructor has an argument.  Include additional input fields as needed depending on # of constructor arguments.
		private <Input2Type> input2TypeInput2;
	
		...
	
		//InputN
		private <InputNType> inputNTypeInputN;
	
		//Operation description
		private String description = "";
	
		//Empty constructor if there no additional input is required to complete the definition of the operation.
		public NewOperation(){
		}
	
		//Argumented constructors (if needed)
		public NewOperation(<Input2Type> input2, ..., <InputNType> inputN){
		}
	
		//Input setter(s) (Include more (overload) if your operation handles more than one input type)
		protected void setInput(<InputType> input){
			this.inputTypeInput = input;
		}
	
		//Operate type method(s) (Again, overload if your operation handles more than one input type)
		protected <OutputType> operateTypeOutputType(<InputType> dummy){
			return newOperation(this.inputTypeInput);
		}
	
		//Operation method (overload as needed)
		private <OutputType> newOperation(<Input Type> input){
			<Output type> result = new <Output Type>();
			//Statements bearing New Operation's effect on "result" depending on "input" value
			return result;
		}
	
		//Description getter
		public String getDescription(){
			return this.description;
		}
	}

## *CombSet* Subclass Components and Template
### Components
Each newly defined *CombSet* subclass must have the following components:
 
1.	Private initialSet *CombSet* field.  
 	The initial set is a *CombSet* from which your construction algorithm begins
 		
2.	Private initialSetDescription *String* field.  
 	This is a one sentence description of exactly what is contained within the initial set.
 	Abstract set notation can also be used as in: {positive integers in [2^(n-1), 2^(n) - 1], where n is also a positive integer}.
 
3.	Private constructingFunction *Function* field.  
 	Each step in the construction algorithm will be a less abstract function element in constructingFunction's rule[] array.
 	It will be within the *CombSet* subclass constructor that the rule[] array elements will be defined.
 
4.	Private setDescription *String* field.  
 	This field is a one sentence abstract description of exactly what elements are contained within the resulting set of the construction algorithm.
 
5.	Private algorithmSource *String* field.
	This field contains the name of both the author of the algorithm used, as well as a literature, or other acceptable reference source for the algorithm.
 
6.	Public constructor(s).
 	The constructor method is where the actual construction algorithm takes place, and the manner by which it takes place is as follows:

	1.	Initialize the initialSet.
	2.	Build the constructingFunction, one rule at a time:

			Step 1.	constructingFunction = new Function(initialSet, new Function(new FirstOperation()));
			Step 2.	constructingFunction.addRule(new Function(new SecondOperation()));
				...
			Step N.	constructingFunction.addRule(new Function(new NthOperation()));

	3.	Add the elements to the constructed CombSet using the for loop shown in the below template.

 7.	Private supporter methods (if needed).
 	If you need any additional methods to assist in initializing the initialSet or for building the constructingFunction, then add them here.
 	Try to avoid making supporter methods that transform the elements of the set being constructed, because such behavior should be performed by an Operation subclass, which is then called here.
 	If you find that you're building with code that isn't centered around 

		constructingFunction.addRule(new Function(new SomeOperation()));
 
 	then it may be the case that what your writing could be better done by some new *Operation* subclass.
 
 8.	Public printDescription void method.
 	This method overrides a *CombSet* method.  This method prints all the relevant details your new *CombSet* subclass' construction.
 	You can use the template's printDescription method as is, unless you would like to add or remove anything.

### Template
	class YourCombSet extends CombSet{

		//Initial set on which the construction begins
		private CombSet initialSet;
	
		//Initial set description
		private String initialSetDescription = "";
	
		//The function that performs the construction algorithm
		private Function constructingFunction;
	
		//Description of the set that results from the algorithm
		private String setDescription = ""
	
		//Author of the algorithm, as well as a reference (if applicable)
		private String algorithmSource = "Author(s): ..." + " --- Reference: ";
	
		//Constructor method(s).
		public YourCombSet(){
			//Initialize initialSet and constructingFunction;
			//Build constructingFunction;
		
			//Add the resulting elements from the constructingFunction acting on initialSet to the YourCombSet instance that the constructor creates:
			CombSet newSet = constructingFunction.operate();
			for (int i = 0; i < newSet.size(); i++) {
				add(newSet.get(i));
			}
		}
	
		//Any private supporter methods needed by constructor method(s)
	
		//Printer method that displays aspects of the set's construction when called
		public void printDescription() { 
			System.out.println("Set Description: " + setDescription);
			System.out.println();
			System.out.println("Set Construction:");
			System.out.print("Initial Set: " + initialSetDescription);
			constructingFunction.printFullDescription();
			System.out.println(algorithmSource);
		}
	}

## Function Subclasses
### Operation Calling Function Subclasses

*Operation* Calling *Function* Subclasses simply call the corresponding *Operation* subclass constructor.

These subclasses exist out of convenience for the user, to make it so the user doesn't have to interact with *Operation* subclasses, only *CombSet*s and *Functions*.

Without these operation calling function subclasses, initializing an elementary function would look like this:

	Function yourFunction = new Function(new yourOperation());

With operation calling function subclasses, initializing looks like this:

	Function yourFunction = new YourFunction();

For example:
To create a function that adds 13 to every element in my *CombSet*, I would write:
 
	Function myAddFunction = new Add(13);

### Template for *Operation* Calling *Function* Subclasses

	class OperationName extends Function{
		//Make sure there is a constructor here with arguments identical to every constructor in the corresponding Operation subclass
		public OperationName(){
			super(new OperationNameOp());
		}
	}

### Composite *Function* Subclasses

Composite *Function* Subclasses are what you use to create functions consisting of multiple other functions.

There may be occasions where you wish to use a sequence of functions in multiple sessions, and having to reconstruct the sequence of functions each session is inconvenient.

It is for these occasions that you would probably want to create a composite function subclass, so that you can call just one function in multiple sessions instead of a sequence.

Each composite function subclass should have the following components:

1.	A constructor containing:

	1.	elementary = false;

	2.	initialization of the rule array at a particular size, depending on how many subfunctions will be included.

	3.	initialization of each index of the rule array to a particular *Function* instance.

	4.	A one sentence description of what the function does.

### Template for Composite *Function* Subclasses

	class YourFunction extends Function{
		public YourFunction(){
			elementary = false;
		
			rule = new Function[N];
		
			rule[0] = new YourFirstFunction();
			rule[1] = new YourSecondFunction();
			...
			rule[N] = new YourNthFunction();
		
			description = "A succinct and accurate description of what Your Function does";
		}
	}

## Unit Tests

See [./docs/runningUnitTests.md](docs/runningUnitTests.md)

## Copyright
Copyright 2020 Tao Gaede. All rights reserved.