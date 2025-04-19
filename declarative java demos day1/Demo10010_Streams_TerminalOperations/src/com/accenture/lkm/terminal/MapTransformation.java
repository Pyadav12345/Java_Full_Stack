package com.accenture.lkm.terminal;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class User {
	
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

    
}






public class MapTransformation {
	
    public static void main(String[] args) {
    	
    	
        // 1. String Transformations
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        List<String> transformedNames = names.stream()
            .map(String::toUpperCase)  // Convert to uppercase
            .collect(Collectors.toList());
        System.out.println("String Transformation (Uppercase): " + transformedNames);

        
        
        // 2. Numeric Calculations
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = numbers.stream()
            .map(n -> n * n)  // Square each number
            .collect(Collectors.toList());
        System.out.println("Numeric Calculation (Squared): " + squaredNumbers);

        
        
        
        // 3. Object Property Extraction
        List<User> users = Arrays.asList(
            new User("Alice", 25),
            new User("Bob", 30),
            new User("Charlie", 35)
        );
        List<String> extractedNames = users.stream()
            .map(User::getName)  // Extract name property
            .collect(Collectors.toList());
        System.out.println("Object Property Extraction: " + extractedNames);

        
        
        
        // 4. Type Conversions
        List<String> numberStrings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> convertedNumbers = numberStrings.stream()
            .map(Integer::parseInt)  // Convert String to Integer
            .collect(Collectors.toList());
        System.out.println("Type Conversion (String to Integer): " + convertedNumbers);
    }
}




