package com.rau.reliance;

public class Test {
	public static void main(String[] args) {
		//int[] input = new int[] { 4, 3, 7, 8, 6, 2, 1};
//{3, 7, 4, 8, 2, 6, 1}
		
		int[] input = new int[] {1, 4, 3, 2};
		 //{1, 4, 2, 3}
		boolean isLess = true;
		int len = input.length;
		for(int i=1;i<len;i++){
			if(isLess){//<
				
				if(!(input[i-1] < input[i])){
					int temp = input[i-1];
					input[i-1] = input[i];
					input[i] = temp;
				}
				isLess = false;	
			}else{//>
				
				if(!(input[i-1] > input[i])){
					int temp = input[i-1];
					input[i-1] = input[i];
					input[i] = temp;
				}
				isLess = true;
			}
		}
		
		for(int i=0;i<len;i++){
			if(i==len-1)
			System.out.print(input[i]);
			else
				System.out.print(input[i]+",");
		}
		
	}
}
