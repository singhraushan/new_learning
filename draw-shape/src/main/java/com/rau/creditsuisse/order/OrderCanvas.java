package com.rau.creditsuisse.order;

import com.rau.creditsuisse.DrawShape;

public class OrderCanvas implements Order {
	private DrawShape drawShape;
	private int x;
	private int y;

	public OrderCanvas(DrawShape drawShape) {
		this.drawShape = drawShape;
	}

	public char[][] execute() {
		return drawShape.drawCanvas(x, y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
