package com.rau.basicProgram;

public class DigitAndStarTriangle {

	public static void main(String[] args) {
		//printHorizontalAscending(6);
		printHorizontalAscendingMixed(6);
	}

    public static void printHorizontalAscending(int input) {
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=i; j++) {
				if(i%2==0) 
					System.out.print("* ");
				else 
					System.out.print(j+" ");
			}
			System.out.println();
		}
	}
    
    public static void printHorizontalAscendingMixed(int input) {
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=i; j++) {
				if(i%2==0){
					if(j%2==0) 
						System.out.print(j+" ");
					else 
						System.out.print("* ");
				} else {
					if(j%2==0) 
						System.out.print("* ");
					else 
						System.out.print(j+" ");
				}	
			}
			System.out.println();
		}
	}
}
