package com.rau.basicProgram;

public class DigitTriangle {

	public static void main(String[] args) {
		//printDescendingTriangle(6);
		//printAscendingTriangle(5);
		//printAscendingHorizontalTriangle(6);
		//printDescendingHorizontalTriangle(6);
		//printAscendingVerticalHorizontalRemainSameTriangle(6);
		printAscendingVerticalHorizontalTriangle(6);
	}

	public static void printDescendingTriangle(int n) {
       for(int i=n;i>0;i--) {
    	   for(int j=i;j>0;j--) {
        	   System.out.print(j+" ");
           } 
    	   System.out.println();
       }
	}
	
	public static void printAscendingTriangle(int n) {
	       for(int i=1;i<=n;i++) {
	    	   for(int j=1;j<=i;j++) {
	        	   System.out.print(j+" ");
	           } 
	    	   System.out.println();
	       }
		}
	
	public static void printAscendingHorizontalTriangle(int n) {
	       for(int i=1;i<=n;i++) {
	    	   for(int j=i;j<=n;j++) {
	        	   System.out.print(j+" ");
	           } 
	    	   System.out.println();
	       }
		}
	
	public static void printDescendingHorizontalTriangle(int n) {
	       for(int i=1;i<=n;i++) {
	    	   for(int j=n;j>=i;j--) {
	        	   System.out.print(j+" ");
	           } 
	    	   System.out.println();
	       }
		}
	
	public static void printAscendingVerticalHorizontalRemainSameTriangle(int n) {
		for(int i=1;i<=n;i++) {
	    	   for(int j=1; j<=i; j++) {
	        	   System.out.print(i+" ");
	           } 
	    	   System.out.println();
	       }
	}
	
	public static void printAscendingVerticalHorizontalTriangle(int n) {
	    int count=1;   
		for(int i=1;i<=n;i++) {
			 for(int j=1; j<=i; j++) {
	        	   System.out.print(count+" ");
	        	   count++;
	           }
	    	   System.out.println();
	       }
		}
	
}
