package queue;

public class DoubleEndedQueueOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleEndedQueue dQueue = new DoubleEndedQueue();
		dQueue.insertBack(5);
		dQueue.insertBack(10);
		dQueue.printElements();
		System.out.println(" \n last elment : "+ dQueue.getBack());
		
		dQueue.printElements();
		dQueue.deleteBack();
		System.out.println(" \n last elment after deletion: "+ dQueue.getBack());
		
		dQueue.printElements();
		dQueue.insertFront(15);
		dQueue.printElements();
		System.out.println(" \n Front one : "+dQueue.getFront());
		
		dQueue.printElements();
		dQueue.deleteFront();
		dQueue.printElements();
		System.out.println(" \n Front one after deletion : "+dQueue.getFront());
	}

}
