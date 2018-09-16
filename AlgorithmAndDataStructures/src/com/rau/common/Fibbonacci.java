package com.rau.common;

import java.util.Arrays;

public class Fibbonacci {
  public static void main(String[] args) {
	  Fibbonacci fibbonacci = new Fibbonacci();
	 // System.out.println(fibbonacci.isFibbonacciNumber(7));
	  //fibbonacci.printFibbonacci(21);
	  //System.out.println(fibbonacci.fibbonacciNumberBetweenTwoNumber(-123,123));
	  fibbonacci.firstNfibbonacciNumber(15);
  }
  
  public boolean isFibbonacciNumber(int n) {
      if(n==0 || n==1) {
    	  return true;
      }
	  int prevPrev=0, prev=1, current=1;
	  if(n>1) {
		  while(n>current) {
			  current =  prev + prevPrev;
			  if(current==n)
				  return true;
			  prevPrev = prev;
			  prev = current;
		  }
	  }
     return false;
  }
  
  public void printFibbonacci(int n) {
	  int[] fibbArray = new int[n];
	  
	  if(n>1) {
	      fibbArray[0]=0;
	      fibbArray[1]=1;
	      System.out.print(fibbArray[0]+" "+fibbArray[1]+" ");
		  for(int i=2;i<n;i++) {
			  fibbArray[i]=fibbArray[i-2]+fibbArray[i-1];  
			  System.out.print(fibbArray[i]+" ");
		  }
	  }
	  
	  
  }
  
  public String fibbonacciNumberBetweenTwoNumber(int n1,int n2) {
      String result = "";
	  int prevPrev=0, prev=1, current=1;
	  if(n1<=0)
	  result = result+prevPrev+ " "+prev+" ";
		  while(current<n2) {
			  current =  prev + prevPrev;
			  prevPrev = prev;
			  prev = current;
			  if(current>n1 && current<n2)
			  result = result+current+ " ";
		  }
     return result;
  }
  
  public void firstNfibbonacciNumber(int n) {
	  int prevPrev = 0 , prev = 1, current = prevPrev + prev;
	  System.out.print(prevPrev+" ");
	  System.out.print(prev+" ");
	  while(prevPrev + prev<n) {
		  current = prevPrev + prev;
		  System.out.print(current+" ");
		  prevPrev = prev;
		  prev = current;
	  }
  }
  
  
}
