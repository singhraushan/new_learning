package com.rau.creditsuisse;

import static com.rau.creditsuisse.util.Constant.X;
import static com.rau.creditsuisse.util.Constant.SPACE;
import static com.rau.creditsuisse.util.Constant.HYPHEN;
import static com.rau.creditsuisse.util.Constant.PIPE;

import com.rau.creditsuisse.util.Line;
import com.rau.creditsuisse.util.Rectangle;

public class DrawShape {

	public char[][] drawCanvas(int x, int y) {
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

	public char[][] drawLine(char[][] canvas, Line line) {

		for (int row = 1; row < canvas.length - 1; row++) {

			for (int column = 1; column < canvas[row].length - 1; column++) {
				if (line != null && ((line.getY1() == row && line.getX1() <= column && line.getX2() >= column)
						|| (line.getX1() == column && line.getY1() <= row && line.getY2() >= row)))
					canvas[row][column] = X;
			}
		}
		return canvas;
	}

	public char[][] drawRectangle(char[][] canvas, Rectangle rectangle) {

		for (int row = 1; row < canvas.length - 1; row++) {
			for (int column = 1; column < canvas[row].length - 1; column++) {

				if (rectangle != null && rectangle.getHorizontalLine1() != null
						&& rectangle.getHorizontalLine1().getY1() == row
						&& rectangle.getHorizontalLine1().getX1() <= column
						&& rectangle.getHorizontalLine1().getX2() >= column) {
					canvas[row][column] = X;
				} else if (rectangle != null && rectangle.getHorizontalLine2() != null
						&& rectangle.getHorizontalLine2().getY1() == row
						&& rectangle.getHorizontalLine2().getX1() <= column
						&& rectangle.getHorizontalLine2().getX2() >= column) {
					canvas[row][column] = X;
				} else if (rectangle != null && rectangle.getVerticalLine1() != null
						&& rectangle.getVerticalLine1().getX1() == column && rectangle.getVerticalLine1().getY1() <= row
						&& rectangle.getVerticalLine1().getY2() >= row) {
					canvas[row][column] = X;
				} else if (rectangle != null && rectangle.getVerticalLine2() != null
						&& rectangle.getVerticalLine2().getX1() == column && rectangle.getVerticalLine2().getY1() <= row
						&& rectangle.getVerticalLine2().getY2() >= row) {
					canvas[row][column] = X;
				}
			}
		}
		return canvas;
	}
	
	public char[][] colourCanvas(char[][] canvas, int x1, int y1, char colour) {
		boolean[][] visited = new boolean[canvas.length][canvas[0].length];
		fillColour(canvas, visited, y1, x1, colour);
		return canvas;
	}
	
	private void fillColour(char[][] canvas, boolean[][] visited, int r, int c, char colour) {
		// quit if off the canvas:
		if (r < 0 || r >= canvas.length || c < 0 || c >= canvas[0].length)
			return;

		// quit if already visited:
		if (visited[r][c])
			return;
		visited[r][c] = true;

		// quit if hit wall:
		if (canvas[r][c] == PIPE || canvas[r][c] == HYPHEN || canvas[r][c] == X)
			return;

		if (canvas[r][c] == SPACE)
			canvas[r][c] = colour;

		// recursively check all directions
		fillColour(canvas, visited, r + 1, c, colour);
		fillColour(canvas, visited, r - 1, c, colour);
		fillColour(canvas, visited, r, c + 1, colour);
		fillColour(canvas, visited, r, c - 1, colour);
	}

}
