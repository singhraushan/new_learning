/**
 * 
 */
package com.rau.navis;

import java.util.LinkedList;

/**
 * @author Raushan kumar
 *
 */
public class TestProgram {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		subtractReplace(list);

		/*
		 * for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i)); }
		 */
		findPossibleCombination("1234567");
	}

	// subtract last with 1st and 2nd with 2nd last...so on
	public static void subtractReplace(LinkedList<Integer> list) {
		for (int i = 0; i < list.size() / 2; i++) {
			list.set(i, list.get(i) - list.get(list.size() - i - 1));
		}
	}

	// subtract last with 1st and 2nd with 2nd last...so on
	public static void findPossibleCombination(String input) {
		StringBuilder result = new StringBuilder("");
		;
		String temp = "";

		for (int i = 0; i < input.length(); i++) {
			result.append(Character.toString(input.charAt(i)));
			result.append(" ");
		}
		System.out.println("result: " + result.toString());
		for (int i = 0; i < input.length() - 1; i++) {
			result = new StringBuilder("");
			int count = 0;
			for (int j = 0; j < input.length(); j++) {

				if (i == j) {
					temp = Character.toString(input.charAt(j));
					count++;
				} else if (count == 1) {
					temp += Character.toString(input.charAt(j));
					result.append(temp + " ");
					count++;
				} else {
					temp = Character.toString(input.charAt(j));
					result.append(temp + " ");
					temp = "";
				}
			}

			System.out.println("result: " + result.toString());
		}
		System.out.println();
		temp = "";
		for (int i = 0; i < 2; i++) {
			boolean isEvenPos;
			if (i == 0)
				isEvenPos = true;
			else
				isEvenPos = false;
			
			result = new StringBuilder("");
			for (int j = 0; j < input.length(); j++) {
				if (isEvenPos) {
                        if(temp.length()==0 || temp.length()==2) {
                        	temp = Character.toString(input.charAt(j)); 
                        } else {
                        	temp += Character.toString(input.charAt(j));
                        	result.append(temp + " ");
        					temp = "";
                        }
				} else {
					
					if(j == 0) {
						temp = Character.toString(input.charAt(j));
                    	result.append(temp + " ");
    					temp = "";
					}
					else if(temp.length()==0 || temp.length()==2) {
                    	temp = Character.toString(input.charAt(j)); 
                    } else {
                    	temp += Character.toString(input.charAt(j));
                    	result.append(temp + " ");
    					temp = "";
                    }
				}
			}
			if(temp.length()>0)
				result.append(temp);
			System.out.println("result: " + result.toString());
		}
		
	}

	// input: 12345

	// output:
	// 1 2 3 4 5
	// 12 3 4 5
	// 1 23 4 5
	// 1 2 34 5
	// 1 2 3 45
	// 12 34 5
	// 1 23 45
	// 12 3 45

	// input: 123

	// output:
	// 1 2 3
	// 12 3
	// 1 23
	// 1 23 4 5

}
