package com.rau.common;

public class PascalTriangle {

	public static void main(String[] args) {
		printPascalTriangle(5);
	}
	
	// using array
	public static void printPascalTriangleUsingArray(int n) {
		int arr[][] = new int[n][n];//default value 0
		
		for(int row = 0; row<n ;row++) {
			for(int column=0; column<=row;column++) {
				if(column==0 || row==column)
					arr[row][column]=1;
				else
					arr[row][column] = arr[row-1][column-1] + arr[row-1][column];
			}
		}
		
		
		for(int row = 0; row<arr.length ;row++) {
			for(int column=0; column<arr[row].length;column++) {
				if(arr[row][column]==0)
					System.out.print("  ");
				else 
			     	System.out.print(arr[row][column]+"  ");
			}
			System.out.println();
		}
	}

	// without array
		public static void printPascalTriangle(int n) {
			 int number;
			for(int row = 0; row<n ;row++) {
				
				number =1;
				
                for(int column=0; column<=n-row;column++) {
					System.out.print("  ");
				}

				for(int column=0; column<=row;column++) {
					System.out.print(number+"  ");
					number = number*(row-column)/(column+1);
				     	
				}
				System.out.println();
			}
		}
		
}
