package com.rau.util.funtion;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public interface IntFuntionDemo1 {
	public static void main(String[] args) {
		int[] marks = {15,89,56,43,21,62};
        
		IntFunction<String> intFunction = mark -> mark+ " is obtained mark";
        for(int mark : marks) {
        	 System.out.println(intFunction.apply(mark)); 	
        }
        //like above you can use for LongFunction & DoubleFunction also.
       
        
        //here is opposite of IntFunction<R>
        ToIntFunction<String> toIntFunction =  s -> Integer.parseInt(s);
        
        System.out.println(toIntFunction.applyAsInt("12"));
        
	}
}
