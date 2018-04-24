package stack;

public class Stack {

	private int top;
	private int[] values;
	private int capacity;

	public Stack() {
		this(5);
	}

	public Stack(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.values = new int[capacity];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int top() {
		return isEmpty() ? -1 : values[top];
	}

	public int size() {
		return capacity;
	}

	public boolean isFulll() {
		return top > capacity - 2;
	}

	public void reSize() {
		int newCapacity = capacity * 2;
		int[] elements = new int[newCapacity];
		for (top = 0; top <= capacity - 1; top++)
			elements[top] = values[top];
		this.values = elements;
		this.capacity = newCapacity;
		top--;
	}

	public void push(int data) {
		if (isFulll()) {
			reSize();
		}
		this.values[++top] = data;
	}

	public int pop() {
		if (isEmpty())
			return -1;
		return values[top--];
	}

}
