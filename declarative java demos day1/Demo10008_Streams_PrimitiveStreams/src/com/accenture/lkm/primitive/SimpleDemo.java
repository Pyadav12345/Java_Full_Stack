package com.accenture.lkm.primitive;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleDemo {

	public static void main(String[] args) {
		
		
		//    public static IntStream rangeClosed(int startInclusive, int endInclusive) 
		// Create IntStream from range (5 numbers from 1-5)
		IntStream numbers = IntStream.rangeClosed(1, 5);

		// Sum operation (only available on primitive streams)
		int sum = numbers.sum();  // Returns: 15
		System.out.println(sum);
		

		// If using regular Stream<Integer>, you'd need:

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int sum1 = list.stream()
						.mapToInt(i -> i).sum();
		System.out.println(sum1);
						
		int sum2 = list.stream()
							.reduce(0, Integer::sum);
		System.out.println(sum2);
		
		
		
		
		
		// Performance test with 10 million numbers


		long start = System.currentTimeMillis();

		// Using regular Stream<Integer> (with boxing)
		int t1 = Stream.iterate(0, i -> i + 1)
		                .limit(10_000_000)
		                .reduce(0, Integer::sum);

		System.out.println("Regular stream time: " + (System.currentTimeMillis() - start) + "ms");


		// Reset timer
		start = System.currentTimeMillis();

		// Using IntStream (no boxing)
		int t2 = IntStream.range(0, 10_000_000).sum();

		System.out.println("IntStream time: " + (System.currentTimeMillis() - start) + "ms");
		// IntStream is significantly faster
		
		
		
		

		
		//Returns an IntSummaryStatistics describing varioussummary data about the elements of this stream. 
		
		//This is a special case of a reduction. 

		//This is a terminal operation.

		
		int[] scores = {85, 90, 72, 95, 88};
		IntStream scoreStream = Arrays.stream(scores);

		// Statistical summary (only available in primitive streams)
		IntSummaryStatistics stats = scoreStream.summaryStatistics();

		System.out.println("Count: " + stats.getCount());
		System.out.println("Average: " + stats.getAverage());
		System.out.println("Max: " + stats.getMax());
		System.out.println("Min: " + stats.getMin());
		System.out.println("Sum: " + stats.getSum());
		
		
		
		
		
		//Converting Between Stream Types

		List<String> numberStrings = Arrays.asList("1", "2", "3", "4");

		// Regular stream to IntStream

		IntStream intStream = numberStrings.stream()
		                                 .mapToInt(Integer::parseInt);

		// IntStream to regular Stream<Integer> (boxing)

		Stream<Integer> boxedStream = intStream.boxed();
        //boxedStream.forEach(System.out::println);
        boxedStream.forEach(s->System.out.println(s));

		
		


	}

}
