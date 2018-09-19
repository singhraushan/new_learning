package com.rau.common;

public class ArmstrongNumber {

	public static void main(String[] args) {
             System.out.println(isArmstrongNumber(310));
             nNumbereOfArmstrongNumber(15);
	}
	
	//sum of its own digits each raised to the power of the number of digit ex: 153= 1^3+5^3+3^3; ,370= 3^3+7^3; if two digit input number then power on each number would be 2.
    public static boolean isArmstrongNumber(long input) {
	  	long sum=0;
	  	long originalInput=input;
	  	int power=findLength(input);
	  	System.out.println("power: "+power);
	  	int lastDigit =0;
	  	while(input!=0)
	  	{
	  		lastDigit = (int)input%10;
	  		int temp=0;
	  		for(int i=0;i<power;i++) {
	  			if(i==0)
	  			  temp = lastDigit;
	  			else
	  			  temp = temp*lastDigit;
	  		}
	  		sum= sum+temp;
	  		input=input/10;
	  		
	  	}	  	
	  	if(sum == originalInput)
	  		return true;
	  	else
	  		return false;
    }
    public static void nNumbereOfArmstrongNumber(int n) {
    	int count =0;
    	for(int originalNumber=1; count <=n; originalNumber++) {
    		int power = findLength(originalNumber);
    		int sum = 0,number=originalNumber;
    		while(number!=0) {
    			int digit = number%10;
    			int tem=1;
    			for(int mul=0;mul<power;mul++) {
    				tem= tem*digit;
    			}
    			sum+=tem;
    			number=number/10;
    		}
    		if(sum==originalNumber) {
    			count++;
    			System.out.print("ArmstrongNumber: "+originalNumber+" ");
    			if(count==n)
    				break;
    		}
    	}
    }
    
    private static int findLength(long input) {
	  	int length = 1;
	  	if(input==0)// to avoid ArithmeticException
	  		return length;
	  	while((input=input/10)!=0) {
	  		++length;	  	}
	  	return length;
    }
    

}
