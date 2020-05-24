package com.rau.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AllCombinationRecursively {

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3 };
		 subSet(input, new int[input.length], 0);

		subSet(input, new ArrayList<String>(), 0);
	}

	public static void subSet(int[] input, int[] result, int currentIndex) {
		if (result.length == currentIndex) {// condition should NOT be last
											// index
			printCombination(result);
		} else {
			result[currentIndex] = -1;
			subSet(input, result, currentIndex + 1);
			result[currentIndex] = input[currentIndex];
			subSet(input, result, currentIndex + 1);
		}
	}

	public static void subSet(int[] input, List<String> result, int currentIndex) {
		if (input.length == currentIndex) {// condition should NOT be result.size() bcoz , it'll be true if size is 0  or 1 or 2...So, it'll not run as tree return.  
										
			printCombination(result);
		} else {
			if (result.size() > currentIndex)// must add this condition 
				result.set(currentIndex, null);
			else // must add this condition
				result.add(currentIndex, null);
			subSet(input, result, currentIndex + 1);
			if (result.size() > currentIndex) // must add this condition
				result.set(currentIndex, input[currentIndex] + "");
			else // must add this condition
				result.add(currentIndex, input[currentIndex] + "");

			subSet(input, result, currentIndex + 1);
		}
	}

	public static void printCombination(int[] arr) {
		String result = "";
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] != -1)
				result = result + arr[i] + ",";
		}
		if (result.length() > 1)
			System.out.println(result.substring(0, result.length() - 1));
	}

	public static void printCombination(List<String> result) {
		List<String> output = result.stream().filter(Objects::nonNull).collect(Collectors.toList());
		System.out.println(output);
	}
}
