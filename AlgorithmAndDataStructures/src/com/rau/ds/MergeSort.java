package com.rau.ds;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort();
	}
	public void sort() {
		int[] arr = { 3,2,1,0,-1 };
		System.out.println("Before Merge Sort : " + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("After Merge Sort : " + Arrays.toString(arr));

	}

	public void mergeSort(int[] arr, int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int midIndex = (lowerIndex + higherIndex) / 2;
			mergeSort(arr, lowerIndex, midIndex);
			mergeSort(arr, midIndex + 1, higherIndex);
			merge(arr, lowerIndex, midIndex, higherIndex);
		}
	}

	public void merge(int[] arr, int lowerIndex, int midIndex, int higherIndex) {
		int l = midIndex - lowerIndex + 1;
		int r = higherIndex - midIndex;

		int[] leftArr = new int[l];
		int[] rightArr = new int[r];

		for (int i = 0; i < l; i++) {
			leftArr[i] = arr[lowerIndex + i];
		}

		for (int j = 0; j < r; j++) {
			rightArr[j] = arr[midIndex + 1 + j];
		}

		int i = 0, j = 0, k = lowerIndex;
		while (i < l && j < r) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < l) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < r) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}

	}
}
