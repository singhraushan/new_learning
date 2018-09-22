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
		System.out.println(factorial(5));
	}
    
	public static int factorial(int input) {
		int result =1;
		for(int i=1;i<=input;i++) {
			result*=i;
		}
		return result;
	}
	
}
