package com.accenture.lkm.standard.interfaces.exact.signature.match;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import com.accenture.lkm.a.pojo.Product;


class Employee {
	
    private String name;
    private double salary;
    
    
	public Employee(String name, int salary) {
		this.name=name;
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}




public class Tester1014BinaryOperator {
	
	public static void main(String[] args) {
		BinaryOperator<Double> finalPrice = (price, discount) -> new Product().computeFinalPriceAfterCustomDiscount(price, discount);
		//System.out.println(finalPrice.apply(1000.0,10.0));
		
		
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// Sum all numbers using BinaryOperator
		BinaryOperator<Integer> sum = (a, b) -> a + b;
		int total = numbers.stream().reduce(0, sum);  // Returns: 15
		System.out.println("total=:"+total);

		// Find maximum value
		BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
		int maxValue = numbers.stream().reduce(3, max);  // Returns: 5
		System.out.println("maxValue=:"+maxValue);
		
		
		
		// Find employee with highest salary

		Comparator<Employee> bySalaryComparator = Comparator.comparing(Employee::getSalary);
		BinaryOperator<Employee> highestPaid = BinaryOperator.maxBy(bySalaryComparator); 
		//Returns a BinaryOperator which returns the greater of two elements according to the specified Comparator.


		Employee emp1 = new Employee("Alice", 75000);
		Employee emp2 = new Employee("Allisa", 85000);
		Employee highest = highestPaid.apply(emp1, emp2);  
		
		System.out.println("highest=:"+highest.getSalary());


		
	}
}




