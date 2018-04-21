package heap;

public class Heap {

	private int capacity;
	private int count;
	private int[] elements;
	
	public Heap(int capacity) {
		this.capacity = capacity;
		this.elements = new int[capacity];
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int[] getElements() {
		return elements;
	}
	
	public void setElements(int[] elements) {
		this.elements = elements;
	}
	
	
}


