package heap;

public class HeapUtil {

	public static Heap createHeap(int capacity, int[] elements) {
		Heap heap = new Heap(capacity);
		if (elements != null) {
			heap.setCount(elements.length);

			int size = capacity;
			int[] values = new int[size];
			for (int i = 0; i < elements.length; i++) {
				values[i] = elements[i];
			}
			heap.setElements(values);
		} else
			heap.setCount(0);
		return heap;
	}

	public static Heap createHeap(int[] elements) {
		if (elements != null)
			return createHeap(elements.length, elements);
		return createHeap(0, elements);
	}

	public static int getParent(Heap heap, int i) {
		if (heap != null && i >= 0 && i < heap.getCount()) {
			return (i - 1) / 2;
		} else
			return -1;
	}

	public static int leftChild(Heap heap, int i) {
		if (heap == null)
			return -1;

		if (i < 0 || i > heap.getCount() - 1)
			return -1;
		return (2 * i + 1) < heap.getCount() ? (2 * i + 1) : -1;
	}

	public static int rightChild(Heap heap, int i) {
		if (heap == null)
			return -1;
		if (i < 0 || i > heap.getCount() - 1)
			return -1;

		return (2 * i + 2) < heap.getCount() ? (2 * i + 2) : -1;
	}

	public static int max(Heap heap) {
		if (heap == null)
			return -1;
		return heap.getCount() > 0 ? 0 : -1;
	}
	
	public static int min(Heap heap) {
		if (heap == null)
			return -1;
		return heap.getCount() > 0 ? 0 : -1;
	}

	public static void printHeap(Heap heap) {
		if (heap == null)
			return;
		for (int i = 0; i < heap.getCount(); i++) {
			System.out.print(heap.getElements()[i] + " , ");
		}
	}

	public static int findPositionOfElement(Heap heap, int data) {
		int pos = -1;
		if (heap == null)
			return pos;

		for (int i = 0; i < heap.getCount(); i++) {
			if (heap.getElements()[i] == data) {
				pos = i;
				break;
			}
		}

		return pos;
	}

	public static void heapify(Heap heap, int i) {
		if (heap == null)
			return;

		if (i < 0 || i > heap.getCount() - 1)
			return;

		int l = (2 * i) + 1;
		int r = (2 * i) + 2;

		if (l > heap.getCount() - 1)
			return;
		if (r > heap.getCount() - 1)
			r = -1;

		int[] elements = heap.getElements();

		int cur = elements[i];
		int next = -1;

		int maxChild = cur;

		if (maxChild < elements[l]) {
			maxChild = elements[l];
			next = l;
		}

		if (r != -1 && maxChild < elements[r]) {
			maxChild = elements[r];
			next = r;
		}

		if (cur < maxChild) {
			elements[i] = maxChild;

			if (elements[l] == maxChild) {
				elements[l] = cur;

			} else {
				elements[r] = cur;
			}

			// heap.setElements(elements);
			heapify(heap, next);
		}
	}
	
	public static void heapifyMinHeap(Heap heap, int i) {
		if (heap == null)
			return;

		if (i < 0 || i > heap.getCount() - 1)
			return;

		int l = (2 * i) + 1;
		int r = (2 * i) + 2;

		if (l > heap.getCount() - 1)
			return;
		if (r > heap.getCount() - 1)
			r = -1;

		int[] elements = heap.getElements();

		int cur = elements[i];
		int next = -1;

		int minChild = cur;

		if (minChild > elements[l]) {
			minChild = elements[l];
			next = l;
		}

		if (r != -1 && minChild > elements[r]) {
			minChild = elements[r];
			next = r;
		}

		if (cur > minChild) {
			elements[i] = minChild;

			if (elements[l] == minChild) {
				elements[l] = cur;

			} else {
				elements[r] = cur;
			}

			heapifyMinHeap(heap, next);
		}
	}
	
	public static void deleteElement(Heap heap, int data) {
		int index = findPositionOfElement(heap, data);
		
		if(index != -1) {
			int[] elements = heap.getElements();
			int lastElement = elements[ heap.getCount()-1];
			elements[index] = lastElement;
			heap.setCount(heap.getCount()-1);
			heapify(heap, index);
					
		}
	}
	
	public static Heap insertIntoMinHeap(Heap heap, int data) {

		// if the heap is empty
		if (heap == null) {
			heap = HeapUtil.createHeap(new int[] { data });
			return heap;
		}

		// if it is full
		if (heap.getCount() == heap.getCapacity()) {
			int size = heap.getCount() * 2;
			int[] elements = new int[size];
			int i = 0;
			for (; i < heap.getElements().length; i++) {
				elements[i] = heap.getElements()[i];
			}
			heap.setCount(i);
			heap.setCapacity(size);
			heap.setElements(elements);
		}

		int childIndex = heap.getCount();
		heap.setCount(heap.getCount() + 1);
		int[] elements = heap.getElements();
		int parentIndex = (childIndex - 1) / 2;
		elements[childIndex] = data;

		while (parentIndex >= 0
				&& (elements[parentIndex] > elements[childIndex])) {
			elements[childIndex] = elements[parentIndex];
			elements[parentIndex] = data;
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}

		return heap;
	}
}
