package com.rau.util.funtion;

import java.util.function.IntToDoubleFunction;
import java.util.function.ToIntFunction;

public interface IntToDoubleFunctionDemo1 {
 public static void main(String[] args) {
	 // no auto boxing and unboxing, so performance better.
	 IntToDoubleFunction intToDoubleFunction = i -> i+0.5;
	 
	 System.out.println("result:  "+intToDoubleFunction.applyAsDouble(15));
	 
	 // like above, there is many just explore others.
	 
}
}
