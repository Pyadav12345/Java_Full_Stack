package com.accenture.lkm.shortcircuit;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BasicDemo {

	public static void main(String[] args) {

		
//		Example 1: Using limit() with an infinite stream
//		---------------------------------------------------

		// Create an infinite stream of numbers
		Stream<Integer> infiniteNumbers = Stream.iterate(1, n -> n + 1);

		// Without limit(), this would run forever
		infiniteNumbers.limit(5)
		               .forEach(System.out::println);  // Prints: 1, 2, 3, 4, 5

		
		
		
		
//		Example 2: Using findFirst() to stop early
//		------------------------------------------------

		List<String> names = Arrays.asList("John", "Jane", "Alice", "Bob", "Charlie");

		// Finds the first name starting with 'J' without processing remaining elements
		Optional<String> firstJName = names.stream()
		                                  .filter(name -> name.startsWith("J"))
		                                  .findFirst();  // Returns: Optional[John]
		                                  
		// names.forEach(System.out::println);
		
		System.out.println(firstJName);
										  

		
		
		
//		Example 3: anyMatch() for early termination
//		------------------------------------------------

		List<Integer> numbers = Arrays.asList(2, 4, 6, 7, 8, 10);
		                             
		// Without examining every element (stops at 7)
		
		// Terminates as soon as it finds any odd number
		boolean hasOddNumber = numbers.stream()
	            .peek(num -> System.out.println("Checking number: " + num))
	            .anyMatch(n -> {
	                boolean isOdd = n % 2 != 0;
	                return isOdd;
	            });

	        // Print the final result
	        System.out.println("\nHas an odd number: " + hasOddNumber);
	        
	        
	        
	        
	        
//	        Example 4: allMatch() early termination on false
//	        ----------------------------------------------------


	        List<String> passwords = Arrays.asList("Secure123!", "StrongPwd1", "weak", "P@ssw0rd");

	        // Checks if all passwords are at least 6 characters
	        // Terminates as soon as it finds
	        
	        boolean allStrong = passwords.stream()
	            .peek(pwd -> System.out.println("Checking password: " + pwd))
	            .allMatch(pwd -> {
	                boolean isLongEnough = pwd.length() >= 6;
	                System.out.println(pwd + " is at least 6 characters: " + isLongEnough);
	                return isLongEnough;
	            });

	        // Print the final result
	        System.out.println("\nAll passwords are at least 6 characters long: " + allStrong);
	    
	

		
	
	
		//	Example 5: limit() and findAny() together
		//	---------------------------------------------------
		
		
			// Find first even number among first 3 elements
			List<Integer> nn = Arrays.asList(41, 6, 5, 2, 4, 6, 8, 10);
		
			Optional<Integer> firstEven = nn.stream()
			                                   .limit(3)  
	                                   .filter(n -> n % 2 == 0)
	                                   .findAny();  // Returns: Optional.empty
			
			
			System.out.println(firstEven);
			
			
	}
			

}













