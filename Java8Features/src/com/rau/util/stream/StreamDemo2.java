package com.rau.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo2 {

	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(5);
		marks.add(55);
		marks.add(50);
		marks.add(12);
		marks.add(7);
		marks.add(85);
		marks.add(40);
		
		List l2 = marks.stream().map(i->i>30).collect(Collectors.toList());// create new collection with new data
		System.out.println("student result: "+l2);// will print boolean, beacuse inside map(), you your passing boolean.
		
		l2 = marks.stream().map(i->i+5).collect(Collectors.toList());// create new collection with new data
		System.out.println("updtaed marks with grace mark: "+l2);
		
		
		
	}

}
