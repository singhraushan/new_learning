/**
 * 
 */
package com.rau.ds;

/**
 * @author Raushan kumar
 *
 */
public class SinglyLinkedList {
	private Node rear, front;

	public void add(Object value) {
		Node currNode = new Node(value);
		if (front == null) {
			rear = front = currNode;
		} else {
			front.next = currNode;
			front = currNode;
		}
	}

	public int size() {
		Node currNode = rear;
		int count = 0;
		while (currNode != null) {
			currNode = currNode.next;
			++count;
		}
		return count;
	}

	public boolean remove(Object value) {
		Node prevNode = null, currNode = rear;
		while (currNode != null) {
			if (currNode.value.equals(value)) {
				if (prevNode == null) {
					rear = currNode.next;
				} else
					prevNode.next = currNode.next;
				return true;
			}
			prevNode = currNode;
			currNode = currNode.next;

		}
		return false;
	}

	public void clear() {
		rear = null;
	}

	public int indexOf(Object value) {
		Node currNode = rear;
		int index = 0;
		while (currNode != null) {
			if (currNode.value.equals(value))
				break;
			currNode = currNode.next;
			++index;
		}
		if (size() == index + 1 || size() == 0)
			return -1;
		return index;
	}

	public void reverse() {
		Node prevNode = null, currNode = rear, nextNode = null;
		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		rear = prevNode;
	}

	public void iterate() {
		Node currNode = rear;
		while (currNode != null) {
			System.out.println(currNode.value);
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list.iterate();
		System.out.println("-------------");
		list.reverse();
		list.iterate();
		System.out.println("-------------");
		list.remove(1);
		list.iterate();
		System.out.println("-------------");
		System.out.println("Size: " + list.size());
	}

}

class Node {
	Node next;
	Object value;

	Node(Object value) {
		this.value = value;
	}

}
