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
		
		
		System.out.println("---------------------");
		
		int sum = marks.stream().filter(e-> {
			if(e%2==0){return true;}
			else {return false;}
			}
		).map(e-> 2*e ).collect(Collectors.summingInt(Integer::intValue));
		
		System.out.println("sum is: "+sum);
		 ArrayList<Ps> persons = new ArrayList<Ps>();
		persons.add(new Ps("AB"));
		persons.add(new Ps("CD"));
		List<Emp> emps = persons.stream().map(ps->{
			Emp emp= new Emp(ps.getpName()+"E");
			return emp;
		}).collect(Collectors.toList());
		
		emps.stream().forEach(e->System.out.println(e.geteName()));
	}

}

class Emp {
	private String eName;
	private String eNam2;

	public Emp(String eName) {
		super();
		this.eName = eName;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

}

class Ps {

	public Ps(String pName) {
		super();
		this.pName = pName;
	}

	private String pName;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
}
