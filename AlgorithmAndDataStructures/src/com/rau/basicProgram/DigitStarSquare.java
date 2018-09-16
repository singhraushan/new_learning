package com.rau.basicProgram;

public class DigitStarSquare {

	public static void main(String[] args) {
		//printStarDigit(6);
		printDigitStar(6);
	}
    public static void printStarDigit(int n) {
      int count =1;
		for(int i=1; i<=n; i++) {
			for(int j=1;j<=n;j++) {
				if(i+j>n) {
					System.out.print(count+" ");
					count++;
				}
				else 
					System.out.print("* ");
			}
			count =1;
			System.out.println();
		}
	}
    
    public static void printDigitStar(int n) {
    	
  		for(int i=1; i<=n; i++) {
  			for(int j=n;j>=1;j--) {
  				if(i+j>n+1) {//2+5>6+1
  					System.out.print("* ");
  				}
  				else 
  					System.out.print(j+" ");
  			}
  			System.out.println();
  		}
  	}

}
