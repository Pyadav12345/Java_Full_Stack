package com.accenture.lkm.streamcreation;

import java.util.stream.Stream;

/**
 * Points to remember
 * @author deepali.shende
 *
 */
public class Tester1004StreamPointToRemember {

	public static void main(String[] args) {
		
		
		// When we create a stream from this array like this: Stream.of(nums), we are not creating a stream of 
		// Integers (Stream<Integer>), but a stream of int arrays (Stream<int[]>). This means that instead of
		// having a stream with five elements, we have a stream of one element:
		
		
//		Stream.of() behaves differently with primitive and object arrays
		
//		For primitive arrays, it treats the array as a single object
//		For object arrays, it creates a stream of individual elements
		
		
		
		int[] productIds = {1, 2, 3, 4, 5};
		System.out.println(Stream.of(productIds).count()); // It prints 1
		 
		 
		Integer[] productIds2 = {1, 2, 3, 4, 5};
		System.out.println(Stream.of(productIds2).count());		// It prints 5
	}
}
