package com.rau.util.funtion;

import java.util.function.Consumer;

public interface ConsumerDemo1 {
	public static void main(String[] args) {

		Consumer<Student> c1 = s-> System.out.println("student name is: "+s.getName());
		
		Consumer<Student> c2 = s-> System.out.println(s.getName()+"is topper of the class.");
		Consumer<Student> c3 = s-> System.out.println(s.getName()+" is going to data base");
		Consumer<Student> cc = c1.andThen(c2).andThen(c3);
		
		//only one supply chain: andThen()
		c1.accept(new Student("Raushan",99));
		c2.accept(new Student("Raushan",99));
		c3.accept(new Student("Raushan",99));
		System.out.println("Applying andThen suppy chain ny cc: ");
		cc.accept(new Student("Raushan",99));
	}
}
