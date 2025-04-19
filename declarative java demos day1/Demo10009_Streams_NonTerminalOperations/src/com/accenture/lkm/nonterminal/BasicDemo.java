package com.accenture.lkm.nonterminal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicDemo {

	public static void main(String[] args) {

		
		//1. filter()

		//Filters elements based on a predicate.
		
		List<String> names = Arrays.asList("John", "Jane", "Jack", "James", "Jill");

		// Get names starting with "Ja"
		Stream<String> jaNames = names.stream()
		    						  .filter(name -> name.startsWith("Ja"));
		    // Nothing happens yet! (lazy evaluation)

		// When terminal operation is called:
		jaNames.forEach(System.out::println);  // Outputs: Jane, Jack, James
		
		
		
		
		
		//2. map()

		//Transforms each element using a function.
		
		List<String> words = Arrays.asList("hello", "world", "java");

		// Convert to uppercase
		Stream<String> upperCaseWords = words.stream()
		    								 .map(String::toUpperCase);
			    // Nothing happens yet! (lazy evaluation)
			
			
			// When terminal operation is called:
		upperCaseWords.forEach(System.out::println);  // Outputs: HELLO, WORLD, JAVA
		
		
		
		
		
		//3. flatMap()

		//Transforms each element into a stream and flattens the resulting streams.
		
		List<List<Integer>> nestedLists = Arrays.asList(Arrays.asList(1, 2, 3),Arrays.asList(4, 5),Arrays.asList(6, 7, 8));

		// Flatten nested lists
		Stream<Integer> flatStream = nestedLists.stream()
		    									.flatMap(Collection::stream);

			    // Nothing happens yet! (lazy evaluation)


		flatStream.forEach(System.out::println);  // Outputs: 12345678
		
		
		
		
		
		//4. distinct()

		//Removes duplicate elements.
		
		List<Integer> numbers = Arrays.asList(100, 200, 200, 300, 300, 300, 400, 500, 500);

		Stream<Integer> uniqueNumbers = numbers.stream()
		    								   .distinct();
			    // Nothing happens yet! (lazy evaluation)


		uniqueNumbers.forEach(System.out::print);  // Outputs: 12345
		
		
		
		

		//5. sorted()

		//Sorts elements according to natural order or a provided comparator.

		System.out.println("Sort by natural ordering......");
		List<String> fruits = Arrays.asList("banana", "apple", "orange", "kiwi");

		Stream<String> sortedFruits = fruits.stream()
		    								.sorted();
			    // Nothing happens yet! (lazy evaluation)

		sortedFruits.forEach(System.out::println);  // Outputs: apple, banana, kiwi, orange


		// Sort by length
		System.out.println("Sort by length......");
		Stream<String> sortedByLength = fruits.stream()
		    								  .sorted(Comparator.comparing(String::length));
			    // Nothing happens yet! (lazy evaluation)

		sortedByLength.forEach(System.out::println);  // Outputs: kiwi, apple, banana, orange
		
		
		
		
		
		//6. limit() and skip()

		//Control the number of elements in the stream.
		
		List<Integer> numberss = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		
		// Get first 7 elements
		System.out.println("Get first 7 elements");
		Stream<Integer> firstFive = numberss.stream()
		    								.limit(7);

		firstFive.forEach(System.out::println);  // Outputs: 12345


		// Skip first 7 elements
		System.out.println(" Skip first 7 elements");
		Stream<Integer> afterSeven = numberss.stream()
		    								.skip(7);

		afterSeven.forEach(System.out::println);  // Outputs: 8910
		
		
		
		
		
		
		//7. peek()

		//Performs an action on each element "without modifying the stream".

		List<String> n = Arrays.asList("John", "Jane", "Jack");

		// Use peek for debugging
		List<String> upperNames = n.stream()
		    							.peek(name -> System.out.println("Processing: " + name))
		    							.map(String::toUpperCase)
		    							.peek(name -> System.out.println("Mapped to: " + name))
		    							.collect(Collectors.toList());

		// Outputs:

		// Processing: John
		// Mapped to: JOHN
		// Processing: Jane
		// Mapped to: JANE
		// Processing: Jack
		// Mapped to: JACK


	}

}





