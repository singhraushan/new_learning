/**
 * 
 */
package com.raushan;

import java.util.Arrays;

/**
 * @author Raushan kumar
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(solution(new int[] {-1,-1,-2,1}));
	}
	
	public static int solution(int[] A) {
		Arrays.sort(A);
		int result=1;
		for(int i=0;i<A.length ;i++) {
		  if(A[i]==result){
			  if(!(i+1<=A.length-1 && A[i]==A[i+1]))
				  ++result;
		  }	else {
			  if(A[i]>1)
			  return result;
		  }
		}
        return result;
    }

}
