/**
 * 
 */
package com.raushan;

import java.util.Hashtable;
import java.util.LinkedList;

class A{
	class B{
		
	}
}
public class Test {
	
	
	public static  double getAveragePrice(LinkedList<Double> list) {
		if(list!=null) {
			double total=0;
			for(double tempPrice: list) {
				total = total + tempPrice;
			}
			System.out.println(total);
			return total/list.size();
		}
		return 0.0;
	}
  public static void main(String[] args) {
	  LinkedList<Double> ac =new LinkedList<Double>();
	  ac.add(66.66);
	  ac.add(44.44);
	  ac.add(22.22);
	 System.out.println("result:  "+getAveragePrice(ac));
	  /*StringBuffer sb =new StringBuffer("a");
	final char j='2';
	switch (1) {
	case j:
		
		break;

	default:
		break;
	}
	sb.append("12345678912345678");
	System.out.println(sb.length());
	System.out.println(sb.capacity());*/
	
	
	
	
	
  }
  
  /*
  public static void test1() {
	Hashtable<string, ""> A =new Hashtable<>();
	A.put(10,"");
	A.put("","");
	A.put("",15.2);
  }
  
  
  public static int test() {
		System.out.println();
		try {
			System.out.println("try");
			return 1;
		}catch(Exception ex){
			System.out.println("a");
			return 1;
		} finally {
			//System.exit(0);
			System.out.println("an");
			return 2;
		}
	  }*/
}

