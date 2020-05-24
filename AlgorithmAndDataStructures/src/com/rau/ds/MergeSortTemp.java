package com.rau.ds;

import java.util.Arrays;

public class MergeSortTemp {

	public static void main(String[] args) {
		int[] arr = { 3,2,1,0,-1 };
		merge(arr, 0, arr.length - 1);
		System.out.println("After Merge Sort : " + Arrays.toString(arr));
	}

	public static void merge(int[] arr, int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int midIndex = (lowerIndex + higherIndex) / 2;
			merge(arr, lowerIndex, midIndex);
			merge(arr, midIndex + 1, higherIndex);
			mergeSort(arr, lowerIndex, midIndex, higherIndex);
		}
	}

	public static void mergeSort(int[] arr, int lowerIndex, int midIndex, int higherIndex) {
		int[] lArr = new int[midIndex - lowerIndex + 1];
		int[] rArr = new int[higherIndex - midIndex];

		for (int i = 0; i < lArr.length; i++) {
			lArr[i] = arr[lowerIndex + i];
		}
		for (int i = 0; i < rArr.length; i++) {
			rArr[i] = arr[midIndex + 1 + i];
		}

		int i = 0, j = 0, k = lowerIndex;
		while (i < lArr.length && j < rArr.length) {
			if (lArr[i] <= rArr[j]) {
				arr[k++] = lArr[i++];
			} else {
				arr[k++] = rArr[j++];
			}
		}

		while (i < lArr.length) {
			arr[k++] = lArr[i++];
		}

		while (j < rArr.length) {
			arr[k++] = rArr[j++];
		}

	}

}
