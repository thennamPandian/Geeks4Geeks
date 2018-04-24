package stack;

public class ObjectStack {

	private int top;
	// Ideally it should be created as object
	private Object[] values;
	private int capacity;

	public ObjectStack() {
		this(5);
	}

	public ObjectStack(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.values = new Object[capacity];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public Object top() {
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
		Object[] elements = new Object[newCapacity];
		for (top = 0; top <= capacity - 1; top++)
			elements[top] = values[top];
		this.values = elements;
		this.capacity = newCapacity;
		top--;
	}

	public void push(Object data) {
		if (isFulll()) {
			reSize();
		}
		this.values[++top] = data;
	}

	public Object pop() {
		if (isEmpty())
			return -1;
		return values[top--];
	}
}
