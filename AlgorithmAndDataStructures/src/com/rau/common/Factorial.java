/**
 * 
 */
package com.rau.common;

/**
 * @author Raushan kumar
 *
 */
public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorialByRecursion(5));
	}
    
	public static int factorial(int input) {
		int result =1;
		for(int i=1;i<=input;i++) {
			result*=i;
		}
		return result;
	}
	
	public static int factorialByRecursion(int input) {
		if(input<0)
			return 0;
		else if(input<=1)
			return 1;
		else
			return input*factorial(input-1);
		
	}
	
}
