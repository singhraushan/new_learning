package com.rau.smartNews;

/**
 * @author Raushan kumar
 *
 */
public class TestDemo {

	public static void main(String[] args) {
		System.out.println("result: " + solution(new int[] { 5, 4, 4, 5, 0, 12 }));

	}

	public static int solution(int[] A) {
		int maxLength = 0, currentLength = 0;
		int prevToPrevValue = 0, prevValue = 0;
		for (int i = 0; i < A.length; i++) {
			if (i == 0 || i == 1) {
				if (i == 0)
					prevToPrevValue = A[i];
				else
					prevValue = A[i];
				currentLength++;
			} else if (A[i] == prevToPrevValue || A[i] == prevValue) {
				currentLength++;
			} else {
				currentLength = 0;
				prevToPrevValue = prevValue;
				prevValue = A[i];
			}
			if (currentLength > maxLength)
				maxLength = currentLength;
		}
		return maxLength;
	}

	public static int solution2(int[] A) {
		int maxDistance = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i != j && A[i] != A[j]) {
					boolean isAdjecent = true;

					int val1 = A[i] < A[j] ? A[i] : A[j];
					int val2 = A[i] > A[j] ? A[i] : A[j];

					for (int k = 0; k < A.length; k++) {
						if (A[k] > val1 && A[k] < val2) {
							isAdjecent = false;
							break;
						}
					}

					if (isAdjecent) {
						int distance = i - j < 0 ? j - i : i - j;
						if (distance > maxDistance)
							maxDistance = distance;
					}

				}
			}
		}
		return maxDistance;
	}
}
