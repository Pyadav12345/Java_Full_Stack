package com.accenture.lkm.sampleclasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductUtility {
	public static List<Product> getProductList() {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(1, "HP Laptop", "N", 25000.0, LocalDate.of(2000, 2, 24)));
		products.add(new Product(2, "TV", "O", 30000.0, LocalDate.of(2021, 1, 1)));
		products.add(new Product(3, "Sony Handy Cam", "N", 28000.0, LocalDate.of(2020, 7, 7)));
		products.add(new Product(4, "Washing Machine", "O", 28000.0, LocalDate.of(2019, 11, 27)));
		products.add(new Product(5, "Ipod", "N", 90000.0, LocalDate.of(2000, 12, 12)));
		products.add(new Product(6, "IPhone", "N", 33333.0, LocalDate.of(2015, 6, 12)));
		products.add(new Product(7, "Ipad", "N", 25000.0, LocalDate.of(2015, 6, 12)));
		products.add(new Product(8, "A.C.", "O", 30000.0, LocalDate.of(2015, 6, 12)));
		products.add(new Product(9, "Fan", "N", 28000.0, LocalDate.now()));
		products.add(new Product(10, "Table", "O", 28000.0, LocalDate.now()));
		products.add(new Product(11, "HP Laptop", "N", 25000.0, LocalDate.of(1999, 2, 24)));

		
		return products;
	}
	
	// get product prices
	public static List<Double> getProductPriceList() {
		List<Product> products = ProductUtility.getProductList();
		List<Double> productPrices = new ArrayList<>();
		
		for(int i=0; i<products.size(); i++) {
			productPrices.add(products.get(i).getProductPrice());
		}
		
		return productPrices;
	}
}
