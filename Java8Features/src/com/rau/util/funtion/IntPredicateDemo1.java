package com.rau.util.funtion;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public interface IntPredicateDemo1 {

	public static void main(String[] args) {
		int[] marks = {15,89,56,43,21,62};
		
		//Predicate<Integer> redicate = mark -> mark>30;// here autowiring will happenig so to avoid this use IntPredicate.
		IntPredicate in = mark -> mark>30;// lamda exression variable name can't be in.
		
		for(int mark: marks){
		if(in.test(mark))
			System.out.println(mark+" is pass mark.");
		}
		
		//Predicate<Integer> redicate = mark -> mark>30;// here autowiring will happenig so to avoid this use IntPredicate.
				DoublePredicate doub = mark -> mark>30;// lamda exression variable name can't be doub.
				
				for(int mark: marks){
				if(doub.test(mark))
					System.out.println(mark+" is pass mark.");
				}
		
				//Predicate<Integer> redicate = mark -> mark>30;// here autowiring will happenig so to avoid this use IntPredicate.
				LongPredicate longPredicate = mark -> mark>30;// lamda exression variable name can't be longPredicate.
				
				for(int mark: marks){
				if(longPredicate.test(mark))
					System.out.println(mark+" is pass mark.");
				}
		
	}
}
