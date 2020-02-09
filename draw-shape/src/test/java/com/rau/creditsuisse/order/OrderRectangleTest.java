package com.rau.creditsuisse.order;

import org.junit.Assert;
import org.junit.Test;

import com.rau.creditsuisse.DrawShape;
import com.rau.creditsuisse.util.Line;
import com.rau.creditsuisse.util.Rectangle;
import com.rau.creditsuisse.util.TestUtil;

public class OrderRectangleTest {

	@Test
	public void testValidLineWithCanvas() {
		DrawShape drawShape =new DrawShape();
		OrderCanvas orderCanvas = new OrderCanvas(drawShape);
		orderCanvas.setX(20);
		orderCanvas.setY(4);
		char[][] canvas = orderCanvas.execute();
		
		OrderRectangle orderRectangle = new OrderRectangle(drawShape);
		orderRectangle.setCanvas(canvas);
		Rectangle rectangle = new Rectangle();
		Line horizontalLine1 = new Line(14, 1, 18, 1);
		Line horizontalLine2 = new Line(14, 3, 18, 3);
		Line verticalLine1 = new Line(14, 1, 14, 3);
		Line verticalLine2 = new Line(18, 1, 18, 3);
		rectangle.setHorizontalLine1(horizontalLine1);
		rectangle.setHorizontalLine2(horizontalLine2);
		rectangle.setVerticalLine1(verticalLine1);
		rectangle.setVerticalLine2(verticalLine2);
		orderRectangle.setRectangle(rectangle);
		
		char[][] actualResult = orderRectangle.execute();
		
		char[][] expectedResult = TestUtil.emptyCanvas(20,4);
		expectedResult[1][14]='X';
		expectedResult[1][15]='X';
		expectedResult[1][16]='X';
		expectedResult[1][17]='X';
		expectedResult[1][18]='X';
		
		expectedResult[2][14]='X';
		
		expectedResult[3][14]='X';
		expectedResult[3][15]='X';
		expectedResult[3][16]='X';
		expectedResult[3][17]='X';
		expectedResult[3][18]='X';
		
		expectedResult[2][18]='X';
		
		for (int row = 0; row < actualResult.length; row++) {
			for (int column = 0; column < actualResult[row].length; column++) {
				Assert.assertEquals(expectedResult[row][column], actualResult[row][column]);
			}
		}
		
		
	}
}
