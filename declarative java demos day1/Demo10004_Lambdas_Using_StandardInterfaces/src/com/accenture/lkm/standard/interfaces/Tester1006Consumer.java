package com.accenture.lkm.standard.interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.accenture.lkm.a.pojo.Product;

public class Tester1006Consumer {
	public static void main(String[] args) {

		// Product - print Product Name in upper case
		Consumer<String> product4 = (pname) -> new Product().printProductNameUpper(pname);// tie to an object new Product()
		product4.accept("LG");

		// Its not a good practice to tie to an object
		
		//Violates functional programming principles: 
		//True functional programming emphasizes stateless functions that operate only on their inputs 
		//rather than relying on external state.

		//Instead, it's preferable to design lambdas that receive all their dependencies as parameters, 
		//making them more self-contained, predictable, and aligned with functional programming principles.
		
		// This can be resolved by using accept() of BiConsumer by passing object and data to the Lambda as below

		
		// Alternative:
		BiConsumer<Product, String> product5 = (productL, name) -> productL.printProductNameUpper(name);
		// class on which to invoke the method
		// parameter data type to be passed to function
		product5.accept(new Product(), "Samsung");
	}

}




//Functional Programming Principles
//====================================
//
//
//
//core principles of functional programming:
//	
//	
//1. Pure Functions
//
//Functions should always return the same output for the same input
//No side effects (no changing state outside the function's scope)
//No mutation of input parameters
//
//
//
//2. Immutability
//
//Data cannot be changed after creation
//Instead of modifying existing data, create new data structures with the desired changes
//
//
//
//3. Function Composition
//
//Building complex functions by combining simpler functions
//Output of one function becomes input to another: f(g(x))
//
//
//
//4. First-Class and Higher-Order Functions
//
//Functions can be assigned to variables
//Functions can be passed as arguments
//Functions can be returned from other functions
//
//
//
//5. Recursion Over Iteration
//
//Prefer recursive approaches to solve problems rather than loops
//
//
//
//6. Declarative Over Imperative
//
//Express what should be done, not how to do it
//Focus on the result, not the step-by-step process
//
//
//
//7. Referential Transparency
//
//Expressions can be replaced with their values without changing program behavior
//A consequence of using pure functions
//
//
//
//8. Lazy Evaluation
//
//Compute values only when needed
//
//
//
//9. Type Systems
//
//Many functional languages have strong, static type systems
//Algebraic data types enable composition of types
//
//
//
//10. Pattern Matching
//
//Decompose data structures based on their shape
//Handle different cases explicitly and exhaustively



//These principles work together to create code that's more predictable, testable, and 
//often more concise than traditional imperative approaches.



