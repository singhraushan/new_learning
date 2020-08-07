package com.rau.common;

public class AllPermutation {

	public static void main(String[] args) {
		permutation("ABC", 0, 2);
	}

	public static void permutation(String input, int startIndx, int endIndx) {
		if (startIndx == endIndx) {
			System.out.println("print :" + input);
		} else {
			for (int i = startIndx; i <= endIndx; i++) {
				input = swap(input, i, startIndx);
				permutation(input,startIndx+1,endIndx);
				input = swap( input, i, startIndx);
			}
		}
	}

	public static String swap(String input, int startIndx, int endIndx) {
		char temp = input.charAt(startIndx);
		StringBuilder sb = new StringBuilder(input);
		sb.setCharAt(startIndx, input.charAt(endIndx));
		sb.setCharAt(endIndx, temp);
		return sb.toString();
	}

}
