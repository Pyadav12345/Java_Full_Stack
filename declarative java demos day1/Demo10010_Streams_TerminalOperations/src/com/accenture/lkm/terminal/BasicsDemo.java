package com.accenture.lkm.terminal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicsDemo {

	public static void main(String[] args) {

//		2. forEach()


		//Performs an action on each element.
		List<Integer> numbers = Arrays.asList(100, 200, 300, 400, 500);

		// Print each number
		numbers.stream()
		       .forEach(System.out::println);
		
		numbers.stream()
				.forEach(s->System.out.println(s));
		    
		    
		    
		   
		
		//1. collect()

		
		//Transforms the stream elements into another form like a List, Set, or Map.
		
		
//		map()
//		-map() is a core intermediate stream operation (returns a stream)
//		-It transforms each element of the stream using the provided function
//		-Creates a new stream with the transformed elements
//		-Does not modify the original collection
//		-One-to-one mapping (each input element produces one output element)
//		-Can be chained with other stream operations
//		-Lazy evaluation (transformation happens only when terminal operation is called)
//		-Requires a terminal operation like collect() to execute
//		-Powerful for data transformation without modifying original data
//		
//		used for following purposes-
//		-String transformations
//		-Numeric calculations
//		-Object property extraction
//		-Type conversions


		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");

		// Collect into a new List
		List<String> upperNames = names.stream()
		    							.map(String::toUpperCase)
		    							.collect(Collectors.toList());
		System.out.println(upperNames);
		// upperNames contains: [ALICE, BOB, CHARLIE, DAVE]



		// Collect into a Set (removes duplicates)
		Set<Integer> nameLengths = names.stream()
		    							.map(String::length)
		    							.collect(Collectors.toSet());
		System.out.println(nameLengths);
		// nameLengths contains: [3, 4, 5, 7]



		// Collect into Map (names as keys, lengths as values)
		Map<String, Integer> nameLengthMap = names.stream()
		    									  .collect(Collectors.toMap(name -> name,String::length));
		System.out.println(nameLengthMap);
		// nameLengthMap: {Alice=5, Bob=3, Charlie=7, Dave=4}
		
		
		
		
		
		//3. reduce()

		//Combines elements into a single result.
		
		System.out.println("==========================================================================");
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);

		// Sum all numbers
		int sum = num.stream()
		    			 .reduce(0, Integer::sum);
		System.out.println(sum);
		// sum: 15


		// Concatenate strings with a separator
		//String snames = Stream.of("Alice", "Bob", "Charlie")
		    //.reduce("", (result, name) -> result.isEmpty() ? name : result + ", " + name);
		//System.out.println(snames);
		
		String snames = Stream.of("Alice", "Bob", "Charlie")
			    .reduce((result, name) -> {
			        if (result.isEmpty()) {
			            return name;
			        } else {
			            return result + ", " + name;
			        }
			    }).orElse("");
		System.out.println(snames);
		    
		// names: "Alice, Bob, Charlie"
		
		
		
		
		
		//4. count(), min(), max()

		
		System.out.println("=======================================================================");

		//Return basic statistics about the stream.
		List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi");

		// Count elements
		long count = words.stream()
						  .count();
		System.out.println(count);
		// count: 4


		// Find minimum (lexicographically- alphabetical order)
		Optional<String> minWord = words.stream()
										.min(String::compareTo);
		System.out.println(minWord);
		// minWord: Optional[apple]


		// Find maximum by length   (lexicographically- alphabetical order)
		Optional<String> longestWord = words.stream()
		    								.max(Comparator.comparing(String::length));
		System.out.println(longestWord);
		// longestWord: Optional[banana]
		
		
		
		
		
		
		
		
		//5. anyMatch(), allMatch(), noneMatch()


		System.out.println("=======================================================================");

		//Check if elements match a predicate.

		List<String> fruits = Arrays.asList("apple", "banana", "orange", "kiwi");


		// Check if any fruit starts with 'a'
		boolean hasAFruit = fruits.stream()
		    					  .anyMatch(fruit -> fruit.startsWith("a"));
		System.out.println(hasAFruit);
		// hasAFruit: true


		// Check if all fruits have length > 3
		boolean allLongFruits = fruits.stream()
		    						  .allMatch(fruit -> fruit.length() > 3);
		System.out.println(allLongFruits);
		// allLongFruits: true


		// Check if no fruit contains 'z'
		boolean noZFruits = fruits.stream()
		    					  .noneMatch(fruit -> fruit.contains("z"));
		System.out.println(noZFruits);
		// noZFruits: true
		
		
		
		
		
		
		//6. findFirst(), findAny()*****

		System.out.println("==============================================");

		//Return an element from the stream.

		List<String> namess = Arrays.asList("Alice", "Bob", "Charlie");
		System.out.println(namess);

		// Find first element
		Optional<String> firstName = namess.stream()
										  .findFirst();
		System.out.println(firstName);
		// firstName: Optional[Alice]


		// Find any element (useful in parallel streams)
		Optional<String> anyName = namess.stream()
										.findAny();
		System.out.println(anyName);
		// anyName: typically Optional[Alice] in sequential streams
		
		
		
		
		//7. toArray()

		
		System.out.println("======================================================");

		//Converts stream to an array.
		
		List<String> fruitss = Arrays.asList("apple", "banana", "orange");

		// Convert to array
		String[] fruitArray = fruitss.stream()
									.toArray(String[]::new);
		System.out.println(fruitArray.length);
		// fruitArray: ["apple", "banana", "orange"]

		
	}

}








