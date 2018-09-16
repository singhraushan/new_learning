package com.rau.basicProgram;

public class DigitStarRectangle {

	public static void main(String[] args) {
		//printAcendingHorizontal(6);
		//printDescendingHorizontal(6);
		printAscendingHorizontalVertical(6);
		
	}

	public static void printAcendingHorizontal(int input) {
		for(int i=1; i<=input; i++) {//input number of line
			for(int j=1; j<input; j++) {//1st half part
				if(j<=i) {
					   System.out.print(j+" ");
				}
				else
					   System.out.print("* ");
			}
			for(int j=input; j>0; j--) {//2nd half part
				if(j<=i) {
					   System.out.print(j+" ");
				}
				else
					   System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void printDescendingHorizontal(int input) {
		for(int i=1; i<=input; i++) {//input number of line
			
			for(int j=input; j>0; j--) {//1st 1/4rth part i.e. star(*) part
				 if(j<=i)
				    break;
				System.out.print("* ");
				    	   
			}
			for(int j=input; j+i>input; j--) {//2nd 1/4rth part i.e. descending digit part
				      System.out.print(j+" ");
		    }
			
			for(int j=input-i+1; j<=input; j++) {//3rd 1/4rth part i.e. ascending digit part
			      System.out.print(j+" ");
	        }
			
			for(int j=input-i; j>0; j--) {//last part i.e. star(*) part
			      System.out.print("* ");
	        }
			
			System.out.println();//line change
		}
	}
	
	public static void printAscendingHorizontalVertical(int input) {
		
		for(int i=1; i<=input; i++) {//input number of line for 1st half
			
			for(int j=input; j>i; j--) {//star(*) part
				System.out.print("* ");
				    	   
			}
			for(int j=1; j<=i; j++) {//ascending digit part
				      System.out.print(j+" ");
		    }
			
			for(int j=i-1; j>0; j--) {//descending digit part
			      System.out.print(j+" ");
	        }
			
			for(int j=input-i; j>0; j--) {//last part i.e. star(*) part
			      System.out.print("* ");
	        }
			
			System.out.println();//line change
		}
		
        for(int i=1; i<=input; i++) {//input number of line for last part
			
			for(int j=i; j>1; j--) {//star(*) part
				System.out.print("* ");
				    	   
			}
			for(int j=1; j<=input-i+1; j++) {//ascending digit part
				      System.out.print(j+" ");
		    }
			
			for(int j=input-i; j>0; j--) {//descending digit part
			      System.out.print(j+" ");
	        }
			
			System.out.println();//line change
		}
		
	}
	/*Output:
	* * * * * 1 * * * * * 
	* * * * 1 2 1 * * * * 
	* * * 1 2 3 2 1 * * * 
	* * 1 2 3 4 3 2 1 * * 
	* 1 2 3 4 5 4 3 2 1 * 
	1 2 3 4 5 6 5 4 3 2 1 
	1 2 3 4 5 6 5 4 3 2 1 
	* 1 2 3 4 5 4 3 2 1 
	* * 1 2 3 4 3 2 1 
	* * * 1 2 3 2 1 
	* * * * 1 2 1 
	* * * * * 1 
	*/

	
	
}
