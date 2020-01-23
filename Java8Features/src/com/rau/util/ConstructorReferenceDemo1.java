package com.rau.util;

public class ConstructorReferenceDemo1 {
	ConstructorReferenceDemo1(String s) {
		System.out.println(s+" constructor from ConstructorReferenceDemo1 class.");
	}
	ConstructorReferenceDemo1() {
		System.out.println("Zero arg constructor of ConstructorReferenceDemo1 class.");
	}
	public static void main(String[] args) {
		// if method of Funtional interface has return type of a class then you can  implement Constructor Reference
		// method of interface T constructor should have same number of parameter & type of parameter.
		FuntionalInterf2 fi2 = ConstructorReferenceDemo1 :: new;
		fi2.print("hello");
	}
}
