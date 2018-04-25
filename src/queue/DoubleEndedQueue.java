package queue;

import linkedList.util.DoublyLLWithObject;

public class DoubleEndedQueue {

	private DoublyLLWithObject front;
	private DoublyLLWithObject rear;

	public DoubleEndedQueue() {
		front = null;
		rear = null;
	}

	public void insertFront(Object data) {
		if (front == null) {
			DoublyLLWithObject temp = new DoublyLLWithObject();
			temp.setData(data);
			front = temp;
			front.setNext(null);
			front.setPrev(null);
			rear = front;

		} else {
			DoublyLLWithObject temp = new DoublyLLWithObject();
			temp.setData(data);
			temp.setPrev(null);
			temp.setNext(front);
			front.setPrev(temp);
			front = temp;
		}
	}

	public void insertBack(Object data) {
		if (rear == null) {
			DoublyLLWithObject temp = new DoublyLLWithObject();
			temp.setData(data);
			front= temp;
			front.setNext(null);
			front.setPrev(null);
			rear = front;
		} else {
			DoublyLLWithObject temp = new DoublyLLWithObject();
			temp.setData(data);
			rear.setNext(temp);
			temp.setPrev(rear);
			rear = temp;
		}
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public Object getFront() {
		return front != null ? front.getData(): null;		
	}
	
	public Object getBack() {
		return rear != null ? rear.getData(): null;		
	}
	
	public void deleteFront() {
		if (!isEmpty()) {
			if (front == rear) {
				front = null;
				rear = null;
			} else {
				DoublyLLWithObject temp = front;
				front = front.getNext();
				temp.setNext(null);
				temp = null;
			}
		}
	}

	public void deleteBack() {
		if (!isEmpty()) {
			if (front == rear) {
				front = null;
				rear = null;
			} else {
				DoublyLLWithObject temp = rear;
				rear = rear.getPrev();
				temp.setPrev(null);
				temp = null;
			}
		}
	}
	
	public void printElements() {
		DoublyLLWithObject temp =  front;
		System.out.println();
		while(temp != null ){
			System.out.print(temp.getData()+" , ");
			temp = temp.getNext();
		}
	}

}
