package com.rau.creditsuisse.order;

import org.junit.Assert;
import org.junit.Test;

import com.rau.creditsuisse.DrawShape;
import com.rau.creditsuisse.util.Line;
import com.rau.creditsuisse.util.TestUtil;

public class OrderLineTest {
	
	@Test
	public void testValidLineWithCanvas() {
		DrawShape drawShape =new DrawShape();
		OrderCanvas orderCanvas = new OrderCanvas(drawShape);
		orderCanvas.setX(20);
		orderCanvas.setY(4);
		char[][] canvas = orderCanvas.execute();
		
		OrderLine orderLine = new OrderLine(drawShape);
		orderLine.setCanvas(canvas);
		orderLine.setLine(new Line(1, 2, 6, 2));
		char[][] actualResult = orderLine.execute();
		
		char[][] expectedResult = TestUtil.emptyCanvas(20,4);
		expectedResult[2][1]='X';
		expectedResult[2][2]='X';
		expectedResult[2][3]='X';
		expectedResult[2][4]='X';
		expectedResult[2][5]='X';
		expectedResult[2][6]='X';
		for (int row = 0; row < actualResult.length; row++) {
			for (int column = 0; column < actualResult[row].length; column++) {
				Assert.assertEquals(expectedResult[row][column], actualResult[row][column]);
			}
		}
		
		
	}

}
