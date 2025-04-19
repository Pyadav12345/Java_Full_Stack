package com.accenture.lkm.mr.custom.interfaces;

import com.accenture.lkm.Customer;
import com.accenture.lkm.Product;
import com.accenture.lkm.a.interfaces.DefaultCustomerConstructorInterface;
import com.accenture.lkm.a.interfaces.DefaultProductConstructorInterface;
import com.accenture.lkm.a.interfaces.ParameterizedCustomerConstructorInterface;
import com.accenture.lkm.a.interfaces.ParameterizedProductConstructorInterface;

public class Tester1003NeedOfMethodReferenceConstructor {

	// Need of MR for Constructor
	
	public static void req1() {
		// Req1: Lambda Expression to get the product instance (object) using
		// Default Constructor
		DefaultProductConstructorInterface productObj = () -> new Product();
		Product p = productObj.getProductObject();
		System.out.println(p);

		// Req1: Method Reference to get the product instance (object) using
		// Default Constructor
		DefaultProductConstructorInterface productObj2 = Product::new;
		Product p2 = productObj2.getProductObject();
		System.out.println(p2);

		// Req1: Lambda Expression to get the customer instance (object) using
		// Default Constructor
		DefaultCustomerConstructorInterface customerObj = () -> new Customer();
		Customer c = customerObj.getCustomerObject();
		System.out.println(c);


		// Req1: Method Reference to get the customer instance (object) using
		// Default Constructor
		DefaultCustomerConstructorInterface customerObj2 = Customer::new;
		Customer c2 = customerObj2.getCustomerObject();
		System.out.println(c2);

	}

	
	
	public static void req2() {
		// Req2: Lambda Expression to get the product instance (object) using
		// parameterized Constructor
		ParameterizedProductConstructorInterface productObj2 = (id, name) -> new Product(id, name);
		Product p2 = productObj2.getProductObject(11, "Jackson");
		System.out.println(p2);


		// Req2: Method Reference to get the product instance (object) using
		// parameterized Constructor
		ParameterizedProductConstructorInterface productObj3 = Product::new;
		Product p3 = productObj3.getProductObject(11, "Jackson");
		System.out.println(p3);


		// Req2: Lambda Expression to get the customer instance (object) using
		// parameterized Constructor
		ParameterizedCustomerConstructorInterface customerObj2 = (id, name) -> new Customer(id, name);
		Customer c2 = customerObj2.getCustomerObject(101, "Jackson");
		System.out.println(c2);

		
		// Req2: Method Reference to get the customer instance (object) using
		// parameterized Constructor
		ParameterizedCustomerConstructorInterface customerObj3 = Customer::new;
		Customer c3 = customerObj3.getCustomerObject(101, "Jackson");
		System.out.println(c3);

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		req1();

		System.out.println();
		
		req2();

	}

}
