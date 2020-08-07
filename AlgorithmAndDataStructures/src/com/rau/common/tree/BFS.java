package com.rau.common.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BFS {

	static class Node{
		List<Node> childs;
		Object value;
		Node(Object value, List<Node> childs){
			this.childs= childs;
			this.value=value;
		}
		
		Node(Object value){
			this.value=value;
		}
		Node(){
			
		}
	}
	
	public static void levelOrderQueue(Node root){
		Queue<Node> q= new LinkedList<Node>();
		q.add(root);//visit
		System.out.println("levelValues: "+root.value);//printing
	
		while(!q.isEmpty()){
			
			int size = q.size(); 
			String levelValues ="";
			
			for(int i=0;i<size;i++){
				
				Node currNode = q.poll();//get 1st node from queue & remove
				
				if(currNode.childs!=null){
				q.addAll(currNode.childs);// like adding left & right if not null
				levelValues=levelValues+" "+currNode.childs.stream().map(n->n.value+" ").collect(Collectors.toList()).toString().replace("[", "").replace("]", "");
				}
				//q.poll();//removing 1st node from queue
			}
			System.out.println("levelValues: "+levelValues);
			levelValues="";
		}
	}
	public static void main(String[] args) {
		List<Node> childs= new ArrayList<Node>();
		
		List<Node> child2= new ArrayList<Node>();
		child2.add(new Node(4));
		child2.add(new Node(5));
		Node n1 = new Node(2,child2);
		childs.add(n1);
		
		List<Node> child3= new ArrayList<Node>();
		child3.add(new Node(6));
		child3.add(new Node(7));
		Node n2 = new Node(3,child3);
		childs.add(n2);
		
		childs.add(new Node(9));
		childs.add(new Node(10));
		Node n = new Node(1,childs);
		levelOrderQueue(n);
	}

}
