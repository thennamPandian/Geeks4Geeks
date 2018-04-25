package queue;

public class QueueOperation {

	public static void main(String[] args) {

		Queue queue = new Queue();
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.printContents();
		
		queue.deQueue();		
		queue.printContents();
		queue.deQueue();
		queue.printContents();
		queue.deQueue();
		queue.printContents();
		
		System.out.println("Queue contents");
		queue.printContents();
		
	}

}
