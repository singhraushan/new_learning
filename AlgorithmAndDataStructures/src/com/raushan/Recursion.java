/**
 * 
 */
package com.raushan;

/**
 * @author Raushan kumar
 *
 */
public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//recursionTest1();
		System.out.println(power(2,4));
	}
	
	static int s=3;
	public static void recursionTest1() {
	   	int a=++s;
	   	System.out.println("1st a: "+a+"--s: "+s);
	   	if(a<=5)
	   		recursionTest1();
	   	System.out.println("last a: "+a+"--s: "+s);
	}
	
	public static int power(int base,int exponential) {
	   	if(exponential<0)
	   		return 0;
	   	else if(exponential==0)
	   		return 1;//1
	   	else
	   		return base*power(base,exponential-1);//2*p(2,3)  //2*p(2,2) // 2*p(2,1)  // 2*p(2,0) //1
	   	//2*2*2*2*1 
	}
	
	public static int factorial(int input) {
		if(input<0)
			return 0;
		else if(input<=1)
			return 1;
		else
			return input*factorial(input-1);
		
	}
	
}
