/**
 * 
 */
package com.rau.rakuten;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Raushan kumar
 *
 */
 class PingPong {
   static int x = 0, y = 0;
   public static void main(String[] args) {
     
 		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
 		ArrayList<Integer> list;
 		Scanner sc = new Scanner(System.in);
 		int noOfPlayer = Integer.parseInt(sc.nextLine());
 		for (int i = 0; i < noOfPlayer; i++) {
 			String str = sc.nextLine();
 			String time[] = str.trim().split(" ");
 			if (map.get(Integer.parseInt(time[0])) == null) {
 				list = new ArrayList<Integer>();
 				list.add(Integer.parseInt(time[1]));
 				map.put(Integer.parseInt(time[0]), list);
 			} else {
 				list = map.get(Integer.parseInt(time[0]));
 				list.add(Integer.parseInt(time[1]));
 			}
 		}

 		for (int hour = 10; hour < 19; hour++) {
 			int count = 0;
 			for (Integer key : map.keySet()) {
 				if (key < hour) {
 					ArrayList<Integer> tempList = map.get(key);
 					for (int index = 0; index < tempList.size(); index++) {
 						if (tempList.get(index) >= hour) {
 							count++;
 						}
 					}
 				}
 			}
 			if (count >= 4)
 				y++;
 			else if (count >= 2)
 				x++;
 		}
 		System.out.println(x + " " + y);
   }
 }