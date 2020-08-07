package com.rau.ds;

import java.util.Arrays;
//simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
// always runs O(n^2) time even if the array is sorted
public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort();
	}
	public void sort() {
		int[] arr = { -1, 0,5, 12, 6, 3 };
		System.out.println("Before Bubble Sort : " + Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("After Bubble Sort : " + Arrays.toString(arr));

	}

	public void bubbleSort(int[] arr) {
		//only n-1 time becoz 2nd last will compare with last. last can't compare with anything.
		for (int i = 0; i < arr.length-1 ; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {// start from 0 & go (n-i-1)
				if (arr[j] > arr[j+1]) {// compare within inner loop 
					int temp =  arr[j];
                     arr[j]= arr[j+1];
                     arr[j+1]= temp;
				}
			}
		}
	}

}
