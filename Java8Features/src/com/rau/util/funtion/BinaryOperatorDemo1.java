package com.rau.util.funtion;

import java.util.function.BinaryOperator;

public interface BinaryOperatorDemo1 {
  public static void main(String[] args) {
	  
	  
	//if input and output are same data type then instead of using BiFunction, use BinaryOperator.
	BinaryOperator<Integer> binaryOperator = (i,j)->i+j;
	
	
		System.out.println("sum of 2 & 3 is: "+ binaryOperator.apply(2, 3));
	
	
	
}
}
