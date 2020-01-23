package com.rau.util.funtion;

import java.util.function.UnaryOperator;

public interface UnaryOperatorDemo1 {

	public static void main(String[] args) {
		int[] marks = {15,89,56,43,21,62};
		//if input and output are same data type then instead of using Function, use UnaryOperator.  
		UnaryOperator<Integer> unaryOperator1 = i -> i*i;
		for (int mark : marks) {
			System.out.println("square of "+mark +" is: "+unaryOperator1.apply(mark));
		}
	}
}
