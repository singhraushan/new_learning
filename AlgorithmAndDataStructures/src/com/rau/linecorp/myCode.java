package com.rau.linecorp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class myCode {
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] sticks = input.trim().split(" ");// 1 2 3 4 5

		// 6
		input = br.readLine();
		int[] intSticks = new int[sticks.length];
		
		for(int i =0;i<sticks.length;i++){
			intSticks[i]= Integer.parseInt(sticks[i]);
		}

		pairOfLength(intSticks, Integer.parseInt(input.trim()));
		
		
		//int[]  intSticks = new int[]{1, 2, 3, 4};
		//pairOfLength(intSticks, 7);
	}

	public static void pairOfLength(int[] sticks, int target) {
		int oldMatchL1 = 0;
		int oldMatchL2 = 0;
		for (int i = 0; i < sticks.length; i++) {

			for (int j = i + 1; j < sticks.length; j++) {
				System.out.println("sticks[i]: "+sticks[i] + " sticks[j] " +sticks[j]);
				if (sticks[i] + sticks[j] == target) {
					if (oldMatchL1 + oldMatchL2 == target) {
						int smaller = oldMatchL1 > oldMatchL2 ? oldMatchL2 : oldMatchL1;
						if (smaller < sticks[i] && smaller < sticks[j]) {

						} else {
							oldMatchL1 = sticks[i];
							oldMatchL2 = sticks[j];
						}
					} else {
						oldMatchL1 = sticks[i];
						oldMatchL2 = sticks[j];
					}
				}
			}
		}
		System.out.println(oldMatchL1 + " 2: " +oldMatchL2);
		if (oldMatchL1 + oldMatchL2 != 0) {
			int smaller = oldMatchL1 > oldMatchL2 ? oldMatchL2 : oldMatchL1;
			System.out.println(smaller + " " + (target - smaller));
		} else {
			System.out.println("-1");
		}

	}

}