package com.rau.creditsuisse.util;

public class TestUtil {
	public static char[][] emptyCanvasWithColour(int x,int y) {
		x = x + 2;
		y = y + 2; // incrementing by 2 to keep border in 2 D array.
		char[][] canvas = new char[y][x];
		for (int i = 0; i < x; i++) {
			canvas[0][i] = '-';
		}
		System.out.println();
		for (int i = 0; i < y - 2; i++) {
			canvas[i + 1][0] = '|';
			for (int j = 0; j < x - 2; j++) {
				canvas[i + 1][j + 1] = 'c';
			}
			canvas[i + 1][x - 1] = '|';
		}
		for (int i = 0; i < x; i++) {
			canvas[y - 1][i] = '-';
		}
		return canvas;
	}
	
	public static char[][] emptyCanvas(int x,int y) {
		x = x + 2;
		y = y + 2; // incrementing by 2 to keep border in 2 D array.
		char[][] canvas = new char[y][x];
		for (int i = 0; i < x; i++) {
			canvas[0][i] = '-';
		}
		System.out.println();
		for (int i = 0; i < y - 2; i++) {
			canvas[i + 1][0] = '|';
			for (int j = 0; j < x - 2; j++) {
				canvas[i + 1][j + 1] = ' ';
			}
			canvas[i + 1][x - 1] = '|';
		}
		for (int i = 0; i < x; i++) {
			canvas[y - 1][i] = '-';
		}
		return canvas;
	}
}
