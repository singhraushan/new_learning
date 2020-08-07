package com.rau.transferwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransferWiseTest {

	static class A {
		int i, j;

		A(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			return String.valueOf(i).hashCode() + String.valueOf(j).hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return i == ((A) obj).i && j == ((A) obj).j;
		}

	}

	public static int countPairs(List<Integer> arr, long k) {

		Map<A, Boolean> map = new HashMap<A, Boolean>();
		for (int i = 0; i < arr.size(); i++) {

			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(i) + arr.get(j) == k) {
					map.put(new A(arr.get(i), arr.get(j)), true);
				}
			}
		}

		return map.size();
	}

	public static void main(String[] args) {

		Integer a[] = new Integer[] { 5, 7, 9, 13, 11, 6, 6, 3, 3 };
		Arrays.asList(a);
		System.out.println(countPairs(Arrays.asList(a), 12));
	}

	public static List<String> romanizer2(List<Integer> numbers) {

		String[] romanArr10 = { "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };

		// int []input = {2, 7, 10, 12, 20, 24, 30, 50, 75, 80, 85, 90, 95,
		// 100};
		// String []output = new String[numbers.size()];
		List<String> output = new ArrayList<String>();
		for (int i = 0; i < numbers.size(); i++) {
			int val = numbers.get(i);

			String res = "";

			if (val <= 10) {
				res += romanArr10[val];
			} else {
				if (val == 100) {
					res += "C";
				} else if (val == 50) {
					res += "L";
				} else {
					int temp1 = val / 10;
					int temp2 = val % 10;
					if (temp1 == 4) {
						res += "XL" + (temp2 > 0 ? romanArr10[temp2] : "");
					} else if (temp1 == 9) {
						res += "XC" + (temp2 > 0 ? romanArr10[temp2] : "");
					} else {
						if (temp1 > 5) {
							temp1 = temp1 - 5;
						}
						for (; temp1 > 0; temp1--) {
							res += "X";
						}
						res += (temp2 > 0 ? romanArr10[temp2] : "");
					}

				}
			}

			output.add(res);

		}
		return output;
	}

	
	/*Select t1.ID, 
	CASE WHEN t1.P_ID = null THEN 'ROOT'
	WHEN t1.P_ID = t1.ID THEN 'INNER'
	ELSE 'LEAF' 
	from TREE t1
	order by t1.ID; */

	public static List<String> romanizer(List<Integer> numbers) {

		String[] romanArr10 = { "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };

		// int []input = {2, 7, 10, 12, 20, 24, 30, 50, 75, 80, 85, 90, 95,
		// 100};
		// String []output = new String[input.length];
		List<String> output = new ArrayList<String>();
		for (int i = 0; i < numbers.size(); i++) {
			int val = numbers.get(i);

			String res = "";

			if (val <= 10) {
				res += romanArr10[val];
			} else {
				if (val == 100) {
					res += "C";
				} else if (val == 50) {
					res += "L";
				} else {
					int temp1 = val / 10;
					int temp2 = val % 10;
					if (temp1 == 4) {
						res += "XL" + (temp2 > 0 ? romanArr10[temp2] : "");
					} else if (temp1 == 9) {
						res += "XC" + (temp2 > 0 ? romanArr10[temp2] : "");
					} else {
						if (temp1 > 5) {
							temp1 = temp1 - 5;
							res += "L";

						}
						for (; temp1 > 0; temp1--) {
							res += "X";
						}
						res += (temp2 > 0 ? romanArr10[temp2] : "");
					}

				}
			}
			output.add(res);
		}
		return output;
	}
}
