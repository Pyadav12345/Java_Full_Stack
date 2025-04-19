package com.accenture.lkm;

public class Tester1005LambdasVSAnonymuosClass {
	public static void main(String[] args) {

		ArithmeticOpertionExecutor executor = new ArithmeticOpertionExecutor();
		int number = 45;
		
		
		// inpure first class function
		ArithmeticOperation arithmeticOperation = new ArithmeticOperation() {
			@Override
			public Integer calculate(Integer number1, Integer number2) {
				System.out.println("1 address inside anonymous class..." + this);
				return (number1 + number2) * number; // modification
			}
		};

		int number1 = 10;
		int number2 = 30;
		int result = executor.execute(arithmeticOperation, number1, number2); // number gets replaced with literal value 45 by jre..
		System.out.println("2 address inside anonymous class..." + arithmeticOperation);

		
		
		
		
		// above anonymous class as Lambda
		ArithmeticOperation arithmeticOperation2 = (num1, num2) -> {
			// Uncomment the below line and execute and Observe
			//System.out.println("address inside anonymous class..." + this);
			return (num1 + num2) * number;
		};
		
		result = executor.execute(arithmeticOperation2, number1, number2); // number gets replaced with literal value 45 by jre..
		System.out.println("address inside anonymous class..." + arithmeticOperation2);

	}

}



// Anonymous class is both object and definition
// whereas Lambda is just definition

// Anonymous class has the capability to overwrite this reference
// whereas Lambdas use the this reference from outer scope and cannot re-write

//Hence Lambda is not replacement of Anonymous class






//public class LambdaTest{
//	
//    private int instanceVar = 10;
//    
//    public void instanceMethod() {
//        // This works fine - 'this' refers to the current instance
//        Runnable r = () -> {
//            System.out.println(this.instanceVar);  // OK
//        };
//        r.run();
//    }
//    
//    public static void staticMethod() {
//        // This will not compile
//        Runnable r = () -> {
//            System.out.println(this.instanceVar);  // Error: Cannot use this in a static context
//        };
//        
//        // Even this won't work
//        Runnable r2 = () -> {
//            System.out.println(this);  // Error: Cannot use this in a static context
//        };
//    } 
//    
//}





//Solutions to this above problem:  4 solutions



//Use a regular (non-static) method where this is available



//Create an instance and reference variables through it:

//public static void staticMethod() {
//    LambdaTest instance = new LambdaTest();
//    Runnable r = () -> {
//        System.out.println(instance.instanceVar);  // OK
//    };
//}



//Use static variables instead:

//private static int staticVar = 10;
//
//public static void staticMethod() {
//    Runnable r = () -> {
//        System.out.println(staticVar);  // OK, no 'this' needed
//    };
//}



//Pass needed values as parameters:

//public static void staticMethod() {
//    final int localVar = 10;  // Must be effectively final
//    Runnable r = () -> {
//        System.out.println(localVar);  // OK
//    };
//}



//This limitation exists because lambda expressions in Java maintain the same scoping rules as regular Java code, 
//where this is unavailable in static contexts.







