package com.accenture.lkm.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person{
	
	private int id;
    private String name;
    private int age;
    
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
    
    
    
}



public class BasicDemo {

	public static void main(String[] args) {

		
		List<Person> people = Arrays.asList(
			    new Person(1, "Alice", 30),
			    new Person(2, "Bob", 25),
			    new Person(3, "Charlie", 35)
			);

			Map<Integer, Person> idToPerson = people.stream()
			    .collect(Collectors.toMap(
			        Person::getId,      // Key mapper: what becomes the key
			        person -> person    // Value mapper: what becomes the value
			    ));
			
			// Print out the resulting map
	        idToPerson.forEach((id, person) -> System.out.println("ID: " + id + " -> " + person));
	        
	        
	        
	        
	        
	        //Req-Maybe we just want names as values instead of entire Person objects

	     // Method references (original)
	        Map<Integer, String> idToNameMethodRef = people.stream()
	            .collect(Collectors.toMap(
	                Person::getId,   // Method reference for key
	                Person::getName  // Method reference for value
	            ));

	        // Using lambda expressions
	        Map<Integer, String> idToNameLambda = people.stream()
	            .collect(Collectors.toMap(
	                person -> person.getId(),   // Lambda for key
	                person -> person.getName() // Lambda for value
	            ));

	        // Print both maps
	        System.out.println("Method Reference Map: " + idToNameMethodRef);
	        System.out.println("Lambda Map: " + idToNameLambda);
	        
	        
	        //iterate both the maps using foreach
	        idToNameMethodRef.forEach((id, name) -> System.out.println("ID: " + id + " -> Name: " + name));
	        idToNameLambda.forEach((id, name) -> System.out.println("ID: " + id + " -> Name: " + name));
	        
	        
	        
	        
	        
	        
	        
	        //Req-Handling Duplicate Keys
	        
	        System.out.println("=========================================================================");
	        List<Person> peopleWithDuplicates = Arrays.asList(
	        	    new Person(1, "Alice", 30),
	        	    new Person(2, "Bob", 25),
	        	    new Person(1, "Alice new", 31) // Note: duplicate ID
	        	);

	        	Map<Integer, Person> idToPersonResolved = peopleWithDuplicates.stream()
	        	    .collect(Collectors.toMap(
	        	        Person::getId,                 // Key mapper
	        	        person -> person,              // Value mapper
	        	        (existing, replacement) -> replacement  // Merge function: keep the latest one
	        	    ));

	        
		     // Print out the resulting map
		        idToPersonResolved.forEach((id, person) -> System.out.println("ID: " + id + " -> " + person));
		        
		        
		        
		        
		        
		        
		        //Req- Merge operation
		        
		        System.out.println("=================================");
		        Map<String, Integer> map1 = new HashMap<>();
		        map1.put("apple", 10);
		        map1.put("banana", 5);

		        Map<String, Integer> map2 = new HashMap<>();
		        map2.put("apple", 5);
		        map2.put("cherry", 7);


		     // Print initial state of map1
		        System.out.println("Before merging:");
		        System.out.println("map1: " + map1);
		        System.out.println("map2: " + map2);

		        // Merging map2 into map1
		        map2.forEach((key, value) ->
		            map1.merge(key, value, Integer::sum)
		        );

		        // Print result after merging
		        System.out.println("\nAfter merging:");
		        System.out.println("map1: " + map1);
		        System.out.println("map2: " + map2);



	}

}
