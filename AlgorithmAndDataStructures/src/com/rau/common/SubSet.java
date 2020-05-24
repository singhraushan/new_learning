package com.rau.common;

public class SubSet {
	public static void main(String[] args) {
		subSet(new int[] { 1, 2, 3, 4, 5 });
		subSet("abcd");
	}
// continuous sub set.
	public static void subSet(int[] inputArray) {
		int len = inputArray.length;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j <= len; j++) {
				printContinuousSubSet(inputArray,i,j);
			}
		}
	}
	
	public static void subSet(String input) {
		int len = input.length();
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j <= len; j++) {
				System.out.println(input.substring(i,j));
			}
		}
	}
	public static void printContinuousSubSet(int[] arr, int start, int end) {
		String result ="";
		for (int i = start; i < end; i++) {
			if(i!=end-1)
			result=result+arr[i]+",";
			else
				result=result+arr[i];
		}
		System.out.println(result);
	}
}
