package com.rau.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapBasedOnValues {
	
	public static void main(String[] args) {
		Map<Integer,String> countryCodeAndNameMap = new HashMap<Integer,String>();
		   
		   countryCodeAndNameMap.put(1,"USA");
		   countryCodeAndNameMap.put(91,"India");
		   countryCodeAndNameMap.put(61,"Australia");
		   countryCodeAndNameMap.put(86,"China");
		   countryCodeAndNameMap.put(33,"France");
		   countryCodeAndNameMap.put(852,"Hong Kong");
		   countryCodeAndNameMap.put(92,"Pakistan");
		   
		   countryCodeAndNameMap.entrySet().stream().forEach(entry-> System.out.println("key:"+entry.getKey()+", value:"+entry.getValue()));
		   System.out.println("-----------------------------");
		  
		   Map<Integer,String> sorted = sortByValue(countryCodeAndNameMap);
		   sorted.entrySet().stream().forEach(entry-> System.out.println("key:"+entry.getKey()+", value:"+entry.getValue()));
	}
	
	public static Map<Integer,String> sortByValue(Map<Integer,String> map) {
		
		    List<Map.Entry<Integer, String>> list = map.entrySet().stream().collect(Collectors.toList());
		
		    List<Map.Entry<Integer, String>> sortedList = list.stream().sorted((entry1,entry2)->entry1.getValue().compareTo(entry2.getValue())).collect(Collectors.toList());
		   
		    Map<Integer,String> sortedCountryCodeAndNameMap = new  LinkedHashMap<>();//must be LinkedHashMap
		    sortedList.stream().forEach(entry->sortedCountryCodeAndNameMap.put(entry.getKey(), entry.getValue()));
		   
		    return sortedCountryCodeAndNameMap;
	}
   
   
}
