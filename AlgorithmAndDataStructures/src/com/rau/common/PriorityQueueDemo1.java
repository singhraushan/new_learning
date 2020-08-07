package com.rau.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueDemo1 implements Serializable, Cloneable{

	public static void main(String[] args) {
		PriorityQueue<String> priorityQueue = new PriorityQueue<String>(); 
		priorityQueue.add("Java");
		priorityQueue.add("C");
		priorityQueue.add("CD");
		Iterator<String> r = priorityQueue.iterator();
		while(r.hasNext()){
			System.out.println(r.next());// c will come 1st.
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		System.out.println(map.put("ONE", 1));
		System.out.println(map.put("ONE", 1));
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		System.out.println("get based on index: "+list.get(0));// only one get methid taht find value based on only index not on object.
	}

}
