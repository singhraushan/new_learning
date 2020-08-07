package com.rau.common;

import java.util.Arrays;

public class MergeTwoSortedArrayIntoExistingArray {

	public static void main(String[] args) {
		
		
		int[] nums1= new int[] { -1,0,0,0,3,0,0,0,0,0,0 }; 
		merge(nums1,5, new int[] { -1,-1,0,0,1,2},6);
		
		/*int[] nums1= new int[] { 4,0,0,0,0,0 }; 
		merge(nums1,1, new int[] { 1,2,3,5,6},5);*/
		
		/*int[] nums1= new int[] { 1,2,3,0,0,0 }; 
		merge(nums1,3, new int[] { 4,5,6},3);*/
		
		/*int[] nums1= new int[] { 1,2,3,0,0,0 }; 
		merge(nums1,3, new int[] { 2,5,6},3);*/
		
		/*int[] nums1= new int[] { 1,0 }; 
		merge(nums1,1, new int[] { 2},1);*/
		
		/*int[] nums1= new int[] { 2,0 }; 
		merge(nums1,1, new int[] { 1},1);*/
		
		/*int[] nums1= new int[] { 2 }; 
		merge(nums1,1, new int[] { },0);*/
		
		System.out.println("After merge: " + Arrays.toString(nums1));
	}
	
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
			
			int i=0,j=0;
			while(i<nums1.length && j<n){
				
				if(nums1[i] <= nums2[j]){
					if(i>=m && nums1[i]==0){
						nums1[i] = nums2[j];
							if(nums1[i]==nums2[j] && n>m){
							
						   }else
                              j++;
					}
				}else {
					if(nums1[i]> nums2[j])
					{move(nums1, m,i);
					nums1[i] = nums2[j];
					j++;
					}
				}
				 i++;
			}

		    }
		    public static void move(int[] nums1, int m, int i){
			int prev = nums1[i];
			while(i<nums1.length-1){
				int curr = nums1[i+1];
				nums1[i+1]= prev;
				prev = curr;
				i++;
			}
		}

}
