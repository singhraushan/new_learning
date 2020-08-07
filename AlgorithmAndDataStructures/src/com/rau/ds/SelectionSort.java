package com.rau.ds;

import java.util.Arrays;

/*Time Complexity
Best: ?(n^2)
Average: ?(n^2)
Worst: O(n^2)
Space Complexity
O(1)*/
public class SelectionSort {

	public static void main(String[] args) {
		new SelectionSort().sort();
	}

	public void sort() {
		int[] arr = { -2,5, 0, 6, 3 };
		System.out.println("Before Selection Sort: " + Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("After Selection Sort: " + Arrays.toString(arr));

	}

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length ; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp =  arr[i];
                     arr[i]= arr[j];
                     arr[j]= temp;
				}
			}
		}
	}

}
