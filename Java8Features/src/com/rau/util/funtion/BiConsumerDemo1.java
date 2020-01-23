package com.rau.util.funtion;

import java.util.function.BiConsumer;

public interface BiConsumerDemo1 {
	public static void main(String[] args) {

		BiConsumer<Student, String> c1 = (s, grade) -> System.out
				.println("student name is: " + s.getName() + " and passed with grade: " + grade);

		BiConsumer<Student, String> c2 = (s, grade) -> System.out.println(s.getName() + "is topper of the class.");
		BiConsumer<Student, String> c3 = (s, grade) -> System.out.println(s.getName() + " is going to data base");
		BiConsumer<Student, String> cc = c1.andThen(c2).andThen(c3);

		// only one supply chain: andThen()
		c1.accept(new Student("Raushan", 99), "A");
		c2.accept(new Student("Raushan", 99), "A");
		c3.accept(new Student("Raushan", 99), "A");
		System.out.println("Applying andThen suppy chain ny cc: ");
		cc.accept(new Student("Raushan", 99), "A");
	}
}
