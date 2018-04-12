package linkedList.util;

public class RandomPointerNode implements Cloneable {

	private int data;
	private RandomPointerNode next;
	private RandomPointerNode random;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public RandomPointerNode getNext() {
		return next;
	}

	public void setNext(RandomPointerNode next) {
		this.next = next;
	}

	public RandomPointerNode getRandom() {
		return random;
	}

	public void setRandom(RandomPointerNode random) {
		this.random = random;
	}
	
	public RandomPointerNode clone() {
		RandomPointerNode clone = new RandomPointerNode();
		clone.setData(getData());
		clone.setNext(getNext());
		clone.setRandom(getRandom());
		return clone;
	}

}
