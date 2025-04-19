package com.accenture.lkm.optionalmethods;

public class NoProductPresentException extends Exception  {
	public NoProductPresentException() {
		System.out.println("such a ...Product not present");
	}
}
