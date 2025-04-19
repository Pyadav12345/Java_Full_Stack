package com.accenture.lkm.standard.interfaces.exact.signature.match;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.accenture.lkm.a.pojo.Product;


public class Tester1013UnaryOperator {

	public static void main(String[] args) {
		
		//UnaryOperator<Double> finalPrice = (price) -> new Product().computeFinalPriceAfterFixedDiscount(price);
		//System.out.println(finalPrice.apply(1000.0));
		
		
		
		UnaryOperator<Double> square = x -> x * x;
		Double result = square.apply(4.0);  // Returns: 16.0
		System.out.println(result);

		// Composing UnaryOperators
		UnaryOperator<Double> sqrt = Math::sqrt;
		UnaryOperator<Double> roundTwoDecimals = x -> Math.round(x * 100) / 100.0;
		Double value1 = roundTwoDecimals.apply(555.4390);  // Returns: 5.0
		System.out.println("value1="+value1);


		// First square, then take sqrt, then round
		Function<Double, Double> composed =  roundTwoDecimals.compose(sqrt).compose(square);
		//UnaryOperator<Double> composed = (UnaryOperator<Double>) roundTwoDecimals.compose(sqrt).compose(square);

		Double value2 = composed.apply(5.0);  // Returns: 5.0
		System.out.println(value2);
	}
}
