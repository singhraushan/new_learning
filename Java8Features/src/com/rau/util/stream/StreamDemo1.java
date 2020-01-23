package com.rau.util.stream;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(55);
		list.add(50);
		list.add(12);
		list.add(7);
		list.add(85);
		list.add(40);
		
		// collection is used to store group of element. Where as stream is used to process that data.
		// Stream is interface in java.util.steam pkg
		
		Stream<Integer> s = list.stream();
		
		ArrayList<Integer> list2 = (ArrayList<Integer>) s.filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("list2: "+list2);
		
		// if you try to use same string twice then throw IllegalStateException: stream has already been operated upon or closed.
		// but no C.E.
		//ArrayList<Integer> list3 = (ArrayList<Integer>) s.filter(i->i%2==0).collect(Collectors.toList());
		//System.out.println("list3: "+list3);
		
	}

}
