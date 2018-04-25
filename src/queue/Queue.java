package queue;

import linkedList.util.Node;

public class Queue {

	private Node front;
	private Node rear;

	public Queue() {
		front = null;
		rear = null;
	}

	public void enQueue(int data) {
		if (rear == null) {
			rear = new Node();
			front = rear;
			rear.setData(data);
		} else {
			Node temp = new Node();
			temp.setData(data);
			rear.setNext(temp);
			rear = temp;
		}
	}
	
	public int deQueue(){
		if(front == null ){
			return -1;
		}
		
		int data = front.getData();
		front = front.getNext();
		return data;
	}
	
	public boolean isFull() {
		return false;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public void printContents() {
		System.out.println("\n");
		Node temp = front;
		while(temp != null) {
			System.out.print(temp.getData()+" , ");
			temp = temp.getNext();
		}
		
	}

}
