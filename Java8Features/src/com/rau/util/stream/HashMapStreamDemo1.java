package com.rau.util.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapStreamDemo1 {

	public static void main(String[] args) {
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("Gold",1);
		hmap.put("Silver",2);
		hmap.put("Iron",3);
		// Filter "Gold"key
		Map<String, Integer> filterdMap = hmap.entrySet().stream().filter(m-> m.getKey().equalsIgnoreCase("Gold")).collect(Collectors.toMap(e1-> e1.getKey(), e2-> e2.getValue()));
		filterdMap.forEach((e1,e2)->{System.out.println(e1+"--"+e2);});
		
		
		Map<String, String> newMap = hmap.entrySet().stream().collect(Collectors.toMap(key->{return key.getKey()+"1";}, value->{ return String.valueOf(value.getValue()+"Val");}));
		newMap.entrySet().forEach(e-> System.out.println("key: "+e.getKey()+"--value: "+e.getValue()));

	}

}

