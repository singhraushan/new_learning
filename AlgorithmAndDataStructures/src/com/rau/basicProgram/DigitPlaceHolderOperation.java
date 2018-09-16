package com.rau.basicProgram;

public class DigitPlaceHolderOperation {

	public static void main(String[] args) {
		System.out.println(findSumof1stAndLastDigit(12574));
	}
	
	public static int findSumof1stAndLastDigit(int input) {
     	int result = 0;
     	while(input>0) {
     		if(result==0)
     		    result = input%10;
     		else if(input<10 && input>0)
     			result= result+input;
     		input =input/10;
     	}
		return result;
	}
}
