package com.rau.util.funtion;

import java.util.function.IntConsumer;

public interface IntConsumerDemo1 {
	public static void main(String[] args) {
		
		//IntConsumer<Integer> consumer = i-> System.out.println("consuming i*i: "+i*i);// here auto-boxing & auto-unboxing will happeing to avoid this use IntConsumer
		IntConsumer intConsumer = i-> System.out.println("consuming i*i: "+i*i);
		intConsumer.accept(15);
		// like above can use LongConsumer & DoubleConsumer also
	}
}
