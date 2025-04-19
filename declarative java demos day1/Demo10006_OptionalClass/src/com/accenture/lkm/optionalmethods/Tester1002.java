package com.accenture.lkm.optionalmethods;

import java.util.Optional;

import com.accenture.lkm.sampleclasses.User;



public class Tester1002 {

	public static void main(String[] args) {
		
		Optional<String> optName = Optional.ofNullable(User.getUserName());


		// Check if value exists
//		if (optName.isPresent()) {
//		    System.out.println("Name is: " + optName.get());
//		}

		// Execute code only if value exists
		//optName.ifPresent(name -> System.out.println("Hello, " + name));


		// Provide default value if absent
		//String name = optName.orElse("Guest");
		//System.out.println(name);



		// Transform value if present
		//Optional<Integer> nameLength = optName.map(String::length);
		//System.out.println(nameLength);
		

		// Chain operations
		String greeting = optName.map(String::toUpperCase).orElse("HELLO, GUEST");
		System.out.println(greeting);

	}

}
