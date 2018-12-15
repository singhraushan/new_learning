/**
 * 
 */
package com.rau.goldManSachs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raushan kumar
 *
 */
public class Program {

	public static void main(String[] args) {

		List<Integer> netSaving = new ArrayList<>();
		netSaving.add(2);
		netSaving.add(4);
		netSaving.add(-3);
		System.out.println("requiredAmountAtStart result: " + requiredAmountAtStart(netSaving));

		List<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(5);
		System.out.println("countSubSequence result: " + countSubSequence(list, 6));
	}

	public static int requiredAmountAtStart(List<Integer> netSaving) {
		int total = 0;
		for (int i = 0; i < netSaving.size(); i++) {
			total = total + netSaving.get(i);
		}
		if (total >= 0)
			return 0;
		else
			return -1 * total;
	}

	static int countSubSequence(List<Integer> inputSeq, int targetSum) {
		int subTotal = 0;
		int totalOutput = 0;

		for (int i = 0; i < inputSeq.size(); i++) {
			if (inputSeq.get(i) == targetSum) {
				totalOutput++;
				continue;
			}
			subTotal += inputSeq.get(i);
			for (int j = i + 1; j < inputSeq.size(); j++) {
				subTotal += inputSeq.get(j);
				if (subTotal == targetSum) {
					totalOutput++;
					break;
				}
			}
			subTotal = 0;
		}
		return totalOutput;
	}
}
