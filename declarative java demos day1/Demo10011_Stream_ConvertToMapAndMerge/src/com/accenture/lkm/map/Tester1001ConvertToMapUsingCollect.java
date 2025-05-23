package com.accenture.lkm.map;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.accenture.lkm.sampleclasses.Product;
import com.accenture.lkm.sampleclasses.ProductUtility;

/**
 * Convert Stream to Map
 * @author deepali.shende
 *
 */
public class Tester1001ConvertToMapUsingCollect {
	
	public static void main(String[] args) {
		
		
		// Req 1 : Collect the products into map having id as key and name as value. Assume ids are unique.
		//req1();
		

		// Req 2: Collect the products having price >= 30000 into map. Use id as key and name as value. Assume ids are unique.
		//req2();

		
		// Req 3 : Collect the products into map having id as key and name as value. If ids are same, keep the old value.
		 //req3();
		

		// Req 4 : Collect the products into map having id as key and name as value. If ids are same, keep both the values. 
		//req4();
		

		// Req 5 : Collect the products into map having id as key and name as value. If ids are same, keep both the
		// values. Sort the map according to the keys.
		
		req5();
	}

	
	
	
	// -----------------------------------------------------------------------------------------------
	// Collect the products into map having id as key and name as value. 
	// Works only if no duplicate keys, else throw IllegalStateException for duplicate key. Comment line nos 20 to 23 in ProductUtility.java.
	// -----------------------------------------------------------------------------------------------
	private static void req1() {
		// using lambda
		Map<Integer, String> productMap1 = 
				ProductUtility.getProductList()
						 	  .stream()
						 	  .collect(
						 			  	Collectors.toMap(
						 			  			product -> product.getProductId(), product -> product.getProductName()
						 			  	)
						 	 );
		productMap1.forEach((id, name) -> System.out.println(id + " ---> " + name));

		System.out.println("---------------------------------------------------------");
		
		// using method reference
		Map<Integer, String> productMap2 = 
				ProductUtility.getProductList()
					 		  .stream()
				              .collect(
				            		  Collectors.toMap(
				            				  Product::getProductId, Product::getProductName
				            		   )
				               );
		productMap2.forEach((id, name) -> System.out.println(id + " ---> " + name));
	}
	
	
	
	

	// -----------------------------------------------------------------------------------------------
	// Collect the products having price >= 30000 into map. Use id as key and name as value. Assume ids are unique.
	// Works only if no duplicate keys, else throw IllegalStateException for duplicate key. Comment line nos 20 to 23 in ProductUtility.java.
	// -----------------------------------------------------------------------------------------------
	private static void req2() {
		// using lambda
		Map<Integer, String> productMap1 = 
				ProductUtility.getProductList()
				              .stream()
				              .filter(
				            		  product -> product.getProductPrice()>=30000
				            		 )
				              .collect(
				            		  Collectors.toMap(
				            				  product -> product.getProductId(), product -> product.getProductName()
				            		   )
				               );
		productMap1.forEach((id, name) -> System.out.println(id + " ---> " + name));

		System.out.println("-------------------------------------------------------------");
		
		// using method reference
		Map<Integer, String> productMap2 = 
				ProductUtility.getProductList()
				              .stream()
				              .filter(Tester1001ConvertToMapUsingCollect::checkProductOnPrice)
				              .collect(Collectors.toMap(Product::getProductId, Product::getProductName));
		productMap2.forEach(Tester1001ConvertToMapUsingCollect::displayIdAndNameMap);
	}

	public static boolean checkProductOnPrice(Product product) {
		return product.getProductPrice() >= 30000;
	}

	public static void displayIdAndNameMap(Integer id, String name) {
		System.out.println(id + " ---> " + name);
	}

	
	
	
	
	// -----------------------------------------------------------------------------------------------
	// Collect the products into map having id as key and name as value. If ids are same, keep the old value.
	// Uncomment line nos 20 to 23 in ProductUtility.java.
	// -----------------------------------------------------------------------------------------------
	private static void req3() {
		// using lambda
		Map<Integer, String> productMap1 = 
				ProductUtility.getProductList()
				              .stream()
				              .collect(
				            		  Collectors.toMap(
				            				  			product -> product.getProductId(), 
				            				  			product -> product.getProductName(), 
				            				  			(idOld, idNew) -> idOld
				            				  		  )
				            		  );
		productMap1.forEach((id, name) -> System.out.println(id + " ---> " + name));

		System.out.println("-------------------------------------------");
		
		// using method reference
		Map<Integer, String> productMap2 = 
				ProductUtility.getProductList()
				              .stream()
				              .collect(
				            		  Collectors.toMap(
				            				  			Product::getProductId, 
				            				  			Product::getProductName, 
				            				  			Tester1001ConvertToMapUsingCollect::mergeFunction1
				            				  			)
				            		  );
		productMap2.forEach((id, name) -> System.out.println(id + " ---> " + name));
	}

	public static String mergeFunction1(String oldName, String newName) {
		return oldName;
	}
	
	
	
	
	

	// -----------------------------------------------------------------------------------------------
	// Collect the products into map having id as key and name as value. If ids are same, keep both the values.
	// Uncomment line nos 20 to 23 in ProductUtility.java.
	// -----------------------------------------------------------------------------------------------
	private static void req4() {
		// using lambda
		Map<Integer, String> productMap1 = 
				ProductUtility.getProductList()
				              .stream()
				              .collect(
				            		  Collectors.toMap(
				            				  			product -> product.getProductId(), 
				            				  			product -> product.getProductName(),
				            				  			(nameOld, nameNew) -> nameOld + ", " + nameNew
				            				  			)
				            		  );
		productMap1.forEach((id, name) -> System.out.println(id + " ---> " + name));

		System.out.println("------------------------------------------------------------");
		
		// using method reference
		Map<Integer, String> productMap2 = 
				ProductUtility.getProductList()
				              .stream()
				              .collect(
				            		  Collectors.toMap(
				            				  			Product::getProductId, 
				            				  			Product::getProductName, 
				            				  			Tester1001ConvertToMapUsingCollect::mergeFunction2
				            				  			)
				            		  );
		productMap2.forEach((id, name) -> System.out.println(id + " ---> " + name));
	}

	public static String mergeFunction2(String oldName, String newName) {
		return oldName + ", " + newName;
	}

	
	
	
	
	// -----------------------------------------------------------------------------------------------
	// Collect the products into map having id as key and name as value. If ids are same, keep both the
	// values. Sort the map according to keys
	// Uncomment line nos 20 to 23 in ProductUtility.java.
	// -----------------------------------------------------------------------------------------------
	private static void req5() {
		// using lambda
		TreeMap<Integer, String> productMap1 = 
				ProductUtility.getProductList()
							  .stream()
							  .collect(
									  Collectors.toMap(
											  			product -> product.getProductId(), 
											  			product -> product.getProductName(),
											  			(nameOld, nameNew) -> nameOld + ", " + nameNew, 
											  			() -> new TreeMap()
											  		  )
									  );
		productMap1.forEach((id, name) -> System.out.println(id + " ---> " + name));

		System.out.println("-------------------------------------------------------------");
		
		// using method reference
		Map<Integer, String> productMap2 = 
				ProductUtility.getProductList()
				              .stream()
				              .collect(
				            		  Collectors.toMap(
				            				  			Product::getProductId, 
				            				  			Product::getProductName,
				            				  			Tester1001ConvertToMapUsingCollect::mergeFunction2, 
				            				  			TreeMap::new
				            				  			)
				            		  );
		productMap2.forEach((id, name) -> System.out.println(id + " ---> " + name));
	}
}






