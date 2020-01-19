package com.singtel.demo.model;

public interface Swimmable {

	//To avoid duplicate code using this
	default boolean IsSwimmable() {
		System.out.println("I am swimming");
		return true;
	}
}
