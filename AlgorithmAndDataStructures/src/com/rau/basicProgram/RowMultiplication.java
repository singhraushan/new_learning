package com.rau.basicProgram;

public class RowMultiplication {

	public static void main(String[] args) {
		calculate(2,10);
	}
	
    public static void calculate(int multi,int row) {
		for(int i=1;i<=row;i++) {
			System.out.println(multi+"*"+i+"="+(multi*i));
		}
	}

}
