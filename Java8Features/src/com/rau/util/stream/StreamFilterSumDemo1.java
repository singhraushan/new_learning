package com.rau.util.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFilterSumDemo1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(55);
		list.add(50);
		list.add(12);
		list.add(7);
		list.add(85);
		list.add(40);
		
		// get sum of all values which is divisible by 5.
		System.out.println(list.stream().filter(e -> e % 5 == 0).mapToInt(e -> e.intValue()).sum());

		// sort the element of list.
		System.out.println(list.stream().sorted().collect(Collectors.toList()));

		Set<Integer> set = new HashSet<Integer>();
		set.add(5);
		set.add(55);
		set.add(50);
		set.add(12);
		set.add(7);
		set.add(85);
		set.add(40);
		// sort the set and return as List because set will print randomly even its sorted.
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		
	}

}
