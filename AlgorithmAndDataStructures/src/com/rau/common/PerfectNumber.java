package com.rau.common;

public class PerfectNumber {

	public static void main(String[] args) {
	    //System.out.println(isPerfectNumber(6));
	    printNumberOfPerfectNumber(4);
    }
 //positive number, sum of all +ve divisor(excluding number itself) is same as number. ex: 6,28.. 
    public static boolean isPerfectNumber(long input ) {
	  	long sum=0;
	  	if(input<=1)
	  		return false;
	  	for(int i=1; i<input/2; i++) {
	  		if(input%i==0)
	  			sum+=i;
	  	}
	  	if(sum == input)
	  		return true;
	  	else
	  		return false;
    }
 
    public static void printNumberOfPerfectNumber(int n) {
    	int count = 0;
    	int sum = 0;
    	for(int number=1;count<=n;number++) {
    		
    		for(int j=1; j<=number/2; j++) {
    			if(number%j==0)
    				sum+=j;
    		}
    		if(sum==number){
    			System.out.print("PerfectNumber: "+number+" ");
    			count++;
    			if(count==n)
    				break;
    		}
    		sum=0;
    	}
    }
  
 
}
