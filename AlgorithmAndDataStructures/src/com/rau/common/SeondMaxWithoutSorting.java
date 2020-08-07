package com.rau.common;

public class SeondMaxWithoutSorting {

	public static void main(String[] args) {
		System.out.println("2nd max is : " + getSecondMax(new int[] { 12, 3, 8, 2, 9, 11 }));

	}

	public static int getSecondMax(int[] arr) {
		int len = arr.length;
		if (len <= 1)
			return -1;

		int max = arr[0], secondMax = Math.min(arr[0], arr[1]);
		for (int i = 1; i < len; i++) {
			int curr = arr[i];
			if (curr > max) {
				secondMax = max;
				max = curr;
			} else {
				secondMax = Math.max(curr, secondMax);
			}
		}
		return secondMax;
	}

}
