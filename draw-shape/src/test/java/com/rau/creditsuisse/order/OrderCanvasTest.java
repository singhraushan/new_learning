package com.rau.creditsuisse.order;

import org.junit.Assert;
import org.junit.Test;

import com.rau.creditsuisse.DrawShape;
import com.rau.creditsuisse.util.TestUtil;


public class OrderCanvasTest {


	@Test
	public void testNewCanvas() {
		DrawShape drawShape =new DrawShape();
		OrderCanvas orderCanvas = new OrderCanvas(drawShape);
		orderCanvas.setX(10);
		orderCanvas.setY(2);
		char[][] actualResult = orderCanvas.execute();
		char[][] expectedResult = TestUtil.emptyCanvas(10,2);
		for (int row = 0; row < actualResult.length; row++) {
			for (int column = 0; column < actualResult[row].length; column++) {
				Assert.assertEquals(expectedResult[row][column], actualResult[row][column]);
			}
		}
		
		
	}
}
