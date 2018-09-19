package com.rau.common;

public class PrimeNumber {
  public static void main(String[] args) {
	//System.out.println(isPrimeNumber(14));
	primeNumberBweteenTwoNumber(2,26);
  }
  //A prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers.
  public static boolean isPrimeNumber(int input) {
	  
	  if(input<2)
		  return false;
	  else {
		  for(int i=2;i<=input/2;i++) {
			  if(input%i==0)
				  return false;
		  }
	  }
		return true;
  }
  
  public static void primeNumberBweteenTwoNumber(int input1,int input2) {//assuming both args are +ve and in order 
 	  
	  for(int i=input1;i<=input2;i++) {
		  
		  if(i==2 || i==3) {
			  System.out.print(i+" ");
			  continue;
		  }
		  for(int j=1;j<=i/2;j++) {// it won't work for 2 & 3
			  if(j!=1 && i%j==0)
				  break;
			  if(j!=1 && i%j!=0 && j==i/2)
				  System.out.print(i+" ");				  
		  }
	  }
	  
  }
}
