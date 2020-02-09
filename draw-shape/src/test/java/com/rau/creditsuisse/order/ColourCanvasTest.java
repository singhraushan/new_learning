package com.rau.creditsuisse.order;

import org.junit.Assert;
import org.junit.Test;

import com.rau.creditsuisse.DrawShape;
import com.rau.creditsuisse.util.TestUtil;

public class ColourCanvasTest {

	@Test
	public void testColourFulCanvas() {
		DrawShape drawShape =new DrawShape();
		OrderCanvas orderCanvas = new OrderCanvas(drawShape);
		orderCanvas.setX(20);
		orderCanvas.setY(4);
		char[][] canvas = orderCanvas.execute();
		ColourCanvas colourCanvas = new ColourCanvas(drawShape,canvas,10,4,'c');
		char[][] actualResult = colourCanvas.execute();
		char[][] expectedResult = TestUtil.emptyCanvasWithColour(20,4);
		for (int row = 0; row < actualResult.length; row++) {
			for (int column = 0; column < actualResult[row].length; column++) {
				Assert.assertEquals(expectedResult[row][column], actualResult[row][column]);
			}
		}
		
		
	}
	
}
