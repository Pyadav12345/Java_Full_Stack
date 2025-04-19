package com.accenture.lkm.shortcircuit;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Short circuit operations in Stream
 * @author deepali.shende
 *
 */
public class Tester1002FindFirst {
	
	public static void main(String[] args) {
		
		//Req 1 : find the first product which has price >= 30000
		req1();
	}

	
	
	
	//-------------------------------------------------------------------------------------------------
	// find the first product which has price >= 30000. 
	//-------------------------------------------------------------------------------------------------
	private static void req1() {
		// using lambda
		Product product = ProductUtility.getProductList()
					.stream()
					.filter(products -> products.getProductPrice() >= 30000 )
					.findFirst()
					.orElse(new Product(0, "", "", 0.0, null));
		if(product.getProductId() == 0) {
			System.out.println("No product having price > 30000");
		}
		else {
			System.out.println(product);
		}
		
		System.out.println("--------------------------------------------------------");
		
		// using method reference
		Product product1 = ProductUtility.getProductList()
					  					.stream()
					  					.filter(Tester1002FindFirst::checkProductPrice )
					  					.findFirst()
					  					.orElse(new Product(0, "", "", 0.0, null));
		if(product1.getProductId() == 0) {
			System.out.println("No product having price > 30000");
		}
		else {
			System.out.println(product);
		}
	}

	public static boolean checkProductPrice(Product product) {
		return product.getProductPrice()>30000;
	}
	
}





