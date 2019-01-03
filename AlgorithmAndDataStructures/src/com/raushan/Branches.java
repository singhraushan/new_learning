package com.raushan;

import java.util.HashMap;

public class Branches {
	public static int count(int[] tree) {
        int result=0;
        
        for(int i=0;i<tree.length-1;i++){
          if(tree[i]<tree.length && tree[i]>0 && tree[tree[i]]==tree[i])  
              result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Branches.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}
