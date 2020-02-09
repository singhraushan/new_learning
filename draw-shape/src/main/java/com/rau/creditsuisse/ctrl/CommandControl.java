package com.rau.creditsuisse.ctrl;

import com.rau.creditsuisse.order.Order;

public class CommandControl {
	private Order order;
	private char ch[][];

	public void setOrder(Order order) {
		this.order = order;
	}

	public void run() {
		ch = order.execute();
		Order.print(ch);
	}

	public char[][] getCh() {
		return ch;
	}

}
