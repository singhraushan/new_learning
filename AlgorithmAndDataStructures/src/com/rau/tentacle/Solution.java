/**
 * 
 */
package com.rau.tentacle;

/**
 * @author Raushan kumar
 *
 */
public class Solution {
	int solution(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (A[m] > X) {
				r = m - 1;
				//r = m;
			} else {
				//l = m+1;
				l = m;
			}
		}
		if (A[l] == X) {
			return l;
		}
		return -1;
	}

	
	public static void main(String[] args) {
		Solution s = new Solution();
		//System.out.println("Result: " + s.solution("nice","niece"));//"nice","niece"
		int[] a = new int[] { 1, 2, 3};
		System.out.println("Result: " + s.solution(a, 3));
		// System.out.println("Result: " + s.solution("a0bb"));//
	}

	public String solution(String S, String T) {
		if (S.equals(T))
			return "NOTHING";
		else if (S.length() == T.length()) {
			int count = 0;
			String s1 = "", s2 = "";
			for (int i = 0; i < S.length(); i++) {
				if (!(S.charAt(i) == T.charAt(i))) {
					++count;
					s1 = s1 + S.charAt(i);
					s2 = s2 + T.charAt(i);
				}
				if (count > 2)
					break;
			}
			if (count == 2 && s1.equals(new StringBuilder(s2).reverse().toString()))
				return "SWAP " + s1.charAt(0) + " " + s1.charAt(1);

		} else if (S.length() + 1 == T.length()) {

			for (int i = 0; i < S.length(); i++) {
				if (!(S.charAt(i) == T.charAt(i))) {
					String s = S.substring(0, i) + T.charAt(i) + S.substring(i, S.length());
					if (s.equals(T)) {
						return "INSERT " + T.charAt(i);
					}
					break;
				}
			}
		} else if (S.length() == T.length() + 1) {

			for (int i = 0; i < T.length(); i++) {
				if (!(S.charAt(i) == T.charAt(i))) {
					String s = T.substring(0, i) + S.charAt(i) + T.substring(i, T.length());
					System.out.println("S: " + s);
					if (s.equals(S)) {
						return "DELETE " + S.charAt(i);
					}
					break;
				}
			}
		}
		return "IMPOSSIBLE";
	}

	// time complexity O(n)
	public int solution(String S) {

		String bakLongestSubstring = "";
		String longestSubstring = "";
		boolean isUpperCase = false;

		for (int i = 0; i < S.length(); i++) {
			char value = S.charAt(i);
			int asciiValue = value - '0';

			if (asciiValue >= 0 && asciiValue <= 9) {
				if (bakLongestSubstring.length() < longestSubstring.length() && isUpperCase) {
					bakLongestSubstring = longestSubstring;
				}
				longestSubstring = "";
				isUpperCase = false;
			} else {
				if (asciiValue >= 17 && asciiValue <= 42) {
					isUpperCase = true;
				}
				longestSubstring += value;
			}
		}
		if (!isUpperCase && bakLongestSubstring.length() > 0) {
			longestSubstring = bakLongestSubstring;
		} else if (!isUpperCase) {
			return -1;
		}

		if (longestSubstring.length() > 0)
			return longestSubstring.length();
		else
			return -1;
	}

}
