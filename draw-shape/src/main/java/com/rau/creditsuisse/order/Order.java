package com.rau.creditsuisse.order;

import java.util.Arrays;
import java.util.stream.Stream;

public interface Order {
	public char[][] execute();

	static void print(char[][] canvas) {
		Stream<char[]> rowStream = Arrays.asList(canvas).stream();
		
		rowStream.forEach(ch -> {
			Arrays.asList(ch).stream().forEach(value -> System.out.print(value));
			System.out.println();
		});
		
	}
}