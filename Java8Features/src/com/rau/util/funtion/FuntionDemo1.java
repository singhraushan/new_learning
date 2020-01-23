package com.rau.util.funtion;

import java.util.function.Function;
import static java.lang.System.out;

public interface FuntionDemo1 {

	public static void main(String[] args) {
		
		Function<String, Boolean> f1= s->{
			if(s.length()>10)
				return true;
			else
				return false;
		};
		Function<Boolean, Integer> f01= s->{
			if(s)
				return 1;
			else
				return 0;
		};
		Function<Student, String> f2= s->{
			if(s.getMarks()>30)
			    return s.getName()+" is passed!";
			else 
				return s.getName()+" is failed!";
		};
		
		
		out.println(f1.apply("patna"));
		
		out.println(f2.apply(new Student("Amit", 75)));
		//supply chain: andThen()/compose()
		
		f1.andThen(f01).apply(""); 
		//f1.andThen(f2).apply(""); //Not compitable becoz: output of f1 should be same type of input of f2
		Function<Integer, Integer> f3= i-> i*2;
		Function<Integer, Integer> f4= i-> i*i*i;
		out.println("after applying supply chain andThen: "+f3.andThen(f4).apply(2));// 1st execute f3 then return of f3 will act as input of f4.
		
		out.println("after applying supply chain compose: "+f3.compose(f4).apply(2));// 1st execute f4 then return of f4 will act as input of f3.
		
	}
}
