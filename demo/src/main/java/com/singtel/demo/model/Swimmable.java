package com.singtel.demo.util;

public interface Swimmable {

	//To avoid duplicate code using this
	default boolean IsSwimmable() {
		System.out.println("I am swimming");
		return true;
	}
}
