package com.rau.linecorp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinecorpTest {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();// five value = 5 , capacity = 2
		int capacity = 0;
		int command = 0;
		if (input != null) {
			String commandAndCapacity[] = input.trim().split(" ");
			command = Integer.parseInt(commandAndCapacity[0]);
			capacity = Integer.parseInt(commandAndCapacity[1]);
		}
		/*6 2
		OFFER 1
		OFFER Hello
		OFFER 3
		SIZE
		TAKE
		TAKE*/
		MyQueue myQueue = new MyQueue(capacity);

		for (int i = 0; i < command; i++) {
			System.out.println("entrt: ");
			input = br.readLine();
			String commandValue[] = input.trim().split(" ");
			switch (commandValue[0]) {
			case "OFFER":
				System.out.println(myQueue.offer(commandValue[1]));
				break;
			case "TAKE":
				System.out.println(myQueue.take());
				break;
			case "SIZE":
				System.out.println(myQueue.size());
				break;
			}
		}
	}

	static class MyQueue {
		private int capacity;
		private int size = 0;
		MyNode head = null;
		MyNode currentNode = null;

		MyQueue(int capacity) {
			this.capacity = capacity;
		}

		public int size() {
			return size;
		}

		public String take() {
			if (size > 0) {
				MyNode node = head;
				head = head.prev;
				if(head!=null)
				head.next = null;
				--size;
				return node.value;
			}
			return "";
		}

		public boolean offer(String input) {
			if (size < capacity) {
				if (head == null) {
					head = new MyNode(input);
					currentNode = head;
				} else {
					MyNode node = new MyNode(input);
					node.next = currentNode;
					currentNode.prev = node;
					currentNode = node;
				}
				++size;
				return true;
			} else {
				return false;
			}
		}

		static class MyNode {
			String value;
			MyNode next;
			MyNode prev;

			public MyNode(String value) {
				this.value = value;
			}

		}

	}

}
