package com.rau.creditsuisse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rau.creditsuisse.ctrl.CommandControl;
import com.rau.creditsuisse.exception.CreditSuisseException;
import com.rau.creditsuisse.order.ColourCanvas;
import com.rau.creditsuisse.order.OrderCanvas;
import com.rau.creditsuisse.order.OrderLine;
import com.rau.creditsuisse.order.OrderRectangle;
import com.rau.creditsuisse.util.Constant;
import com.rau.creditsuisse.util.Line;
import com.rau.creditsuisse.util.Rectangle;

/**
 * Hello world!
 *
 */
public class App {

	public static CommandControl commandControl = new CommandControl();
	public DrawShape drawShape = new DrawShape();
	public OrderCanvas orderCanvas = new OrderCanvas(drawShape);
	public OrderLine orderLine = new OrderLine(drawShape);
	public OrderRectangle orderRectangle = new OrderRectangle(drawShape);

	public static void main(String[] args) {
		String input = "";
		char[][] canvas = null;
		App app = new App();

		while (!input.equalsIgnoreCase(Constant.Q)) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter command: ");

			try {
				input = br.readLine().trim();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				app.identifyCommand(input.split(Constant.WHITE_SPACE));
			} catch (CreditSuisseException e) {
				e.printStackTrace();
			}

		}

	}

	// prepare proper order
	public void identifyCommand(String[] input) throws CreditSuisseException {

		switch (input[0]) {
		case Constant.C: {
			int x1 = Integer.parseInt(input[1]);
			int y1 = Integer.parseInt(input[2]);
			orderCanvas.setX(x1);
			orderCanvas.setY(y1);
			commandControl.setOrder(orderCanvas);
			commandControl.run();
			break;
		}
		case Constant.L: {
			int x1 = Integer.parseInt(input[1]);
			int y1 = Integer.parseInt(input[2]);
			int x2 = Integer.parseInt(input[3]);
			int y2 = Integer.parseInt(input[4]);
			Line line = new Line(x1, y1, x2, y2);
			orderLine.setCanvas(commandControl.getCh());
			orderLine.setLine(line);
			commandControl.setOrder(orderLine);
			commandControl.run();
			break;
		}
		case Constant.R: {
			Rectangle rectangle = new Rectangle();
			int x1 = Integer.parseInt(input[1]);
			int y1 = Integer.parseInt(input[2]);
			int x2 = Integer.parseInt(input[3]);
			int y2 = Integer.parseInt(input[4]);
			Line horizontalLine1 = new Line(x1, y1, x2, y1);
			Line horizontalLine2 = new Line(x1, y2, x2, y2);
			Line verticalLine1 = new Line(x1, y1, x1, y2);
			Line verticalLine2 = new Line(x2, y1, x2, y2);
			rectangle.setHorizontalLine1(horizontalLine1);
			rectangle.setHorizontalLine2(horizontalLine2);
			rectangle.setVerticalLine1(verticalLine1);
			rectangle.setVerticalLine2(verticalLine2);
			orderRectangle.setCanvas(commandControl.getCh());
			orderRectangle.setRectangle(rectangle);
			commandControl.setOrder(orderRectangle);
			commandControl.run();
			break;
		}
		case Constant.B: {
			int x1 = Integer.parseInt(input[1]);
			int y1 = Integer.parseInt(input[2]);
			commandControl.setOrder(new ColourCanvas(drawShape, commandControl.getCh(), x1, y1, input[3].charAt(0)));
			commandControl.run();
			break;
		}
		}

	}

}
