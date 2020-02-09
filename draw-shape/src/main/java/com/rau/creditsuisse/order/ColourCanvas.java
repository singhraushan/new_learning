package com.rau.creditsuisse.order;

import com.rau.creditsuisse.DrawShape;

public class ColourCanvas implements Order {
	private DrawShape drawShape;
	private char[][] canvas;
	private int x1;
	private int y1;
	private char colour;

	public ColourCanvas(DrawShape drawShape,char[][] canvas, int x1,int y1,char colour) {
		this.drawShape = drawShape;
		this.canvas=canvas;
		this.x1=x1;
		this.y1=y1;
		this.colour=colour;
	}

	@Override
	public char[][] execute() {
		return drawShape.colourCanvas(canvas, x1, y1, colour);
		
	}

}
