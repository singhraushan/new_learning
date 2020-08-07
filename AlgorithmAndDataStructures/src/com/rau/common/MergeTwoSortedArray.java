package com.rau.common;

import java.util.Arrays;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int result[] = merge(new int[] { 0, 5, 9, 25, 70 }, new int[] { 2, 8, 12 });
		System.out.println("After merge: " + Arrays.toString(result));
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int result[] = new int[arr1.length + arr2.length];

		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[k++] = arr1[i++];
			} else {
				result[k++] = arr2[j++];
			}
		}

		while (i < arr1.length) {
			result[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			result[k++] = arr2[j++];
		}

		return result;
	}

}
