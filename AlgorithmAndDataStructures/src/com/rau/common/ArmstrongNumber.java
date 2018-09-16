package com.rau.common;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             System.out.println(isArmstrongNumber(370));
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
    
    private static int findLength(long input) {
	  	int length = 1;
	  	if(input==0)// to avoid ArithmeticException
	  		return length;
	  	while((input=input/10)!=0) {
	  		++length;	  	}
	  	return length;
    }
    

}
