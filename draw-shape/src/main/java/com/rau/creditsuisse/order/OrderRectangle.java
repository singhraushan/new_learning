package com.rau.creditsuisse.order;

import com.rau.creditsuisse.DrawShape;
import com.rau.creditsuisse.util.Rectangle;

public class OrderRectangle implements Order {
	private DrawShape drawShape;
	private char[][] canvas;
	private Rectangle rectangle;

	public OrderRectangle(DrawShape drawShape) {
		this.drawShape = drawShape;
	}

	public char[][] execute() {
		return drawShape.drawRectangle(canvas, rectangle);
	}

	public void setCanvas(char[][] canvas) {
		this.canvas = canvas;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

}
