package com.accenture.lkm;

public class Tester1001WithoutTypeInference {
	public static void main(String[] args) {
		ArithmeticOpertionExecutor executor = new ArithmeticOpertionExecutor();

		ArithmeticOperation addition = (Integer number1, Integer number2) -> {
			int result = number1 + number2;
			System.out.println("From Lambda Result is: " + result);
			return result;
		};

		//ArithmeticOperation addition = (Integer number1, Integer number2) -> { return number1 + number2; };

		int num1 = 90;
		int num2 = 480;
		int sum = executor.execute(addition, num1, num2);
		//System.out.println(sum);
	}
}

// popup
// Any object created - no
// can access this ref - no....
// now this became as pure first class function and high order function.