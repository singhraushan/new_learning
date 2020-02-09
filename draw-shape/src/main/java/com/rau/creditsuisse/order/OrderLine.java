package com.rau.creditsuisse.order;

import com.rau.creditsuisse.DrawShape;
import com.rau.creditsuisse.util.Line;

public class OrderLine implements Order {
	private DrawShape drawShape;
	private Line line;
	private char[][] canvas;

	public OrderLine(DrawShape drawShape) {
		this.drawShape = drawShape;
	}

	public char[][] execute() {
		return drawShape.drawLine(canvas, line);
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public void setCanvas(char[][] canvas) {
		this.canvas = canvas;
	}

}
