package com.rau.util.funtion;

import java.util.function.BiFunction;
import java.util.function.Function;
import static java.lang.System.out;

public interface BiFuntionDemo1 {

	public static void main(String[] args) {
		
		BiFunction<String,String, Boolean> f1= (s, s2)->{
			if(s.length()>10)
				return true;
			else
				return false;
		};
		BiFunction<Student, String, String> f2= (s, s2)->{
			if(s.getMarks()>30)
			    return s.getName()+" is passed!";
			else 
				return s.getName()+" is failed!";
		};
		
		
		out.println(f1.apply("patna","noUse"));
		
		out.println(f2.apply(new Student("Amit", 75),"noUse"));
		//supply chain: andThen(accept Function<> not BiFunction<>) only not compose
		
		BiFunction<Integer,Integer, Integer> f3 = (i,j)-> i+j;
		BiFunction<Integer,Integer, Integer> f4 = (i,j)-> i*j;
		out.println("after applying supply chain  andThen(accept Function<> not BiFunction<>): "+f3.andThen(a->2*a).apply(3, 5));
		//out.println("after applying supply chain andThen: "+f3.andThen(f4).apply(2,15));// andThen(accept Function<> not BiFunction<>).because input of 2nd accept 2 input but output of 1st only one
		
		//out.println("after applying supply chain compose: "+f3.compose(f4).apply(2));// compose not applicable for BiFuntion. because input of 2nd accept 2 input but output of 1st only one 
		
	}
}
