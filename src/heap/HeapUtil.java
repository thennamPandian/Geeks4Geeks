package heap;

public class HeapUtil {

	public static Heap createHeap(int capacity, int[] elements) {
		Heap heap = new Heap(capacity);
		heap.setCount(capacity);
		heap.setElements(elements);
		return heap;
	}

	public static int getParent(Heap heap, int i) {
		if (i >= 0 && i < heap.getCount()) {
			return (i - 1) / 2;
		} else
			return -1;
	}

	public static int leftChild(Heap heap, int i) {
		if (i < 0 || i > heap.getCount()) return -1;
		return (2 * i + 1) < heap.getCount() ? (2 * i + 1) : -1;
	}

	public static int rightChild(Heap heap, int i) {
		if (i < 0 || i > heap.getCount()) return -1;
			
		return (2 * i + 2) < heap.getCount() ? (2 * i + 2) : -1;
	}

	public static int max(Heap heap) {
		return heap.getCount() > 0 ? 0 : -1;
	}

	public static void printHeap(Heap heap) {
		for (int data : heap.getElements()) {
			System.out.print(data + " , ");
		}
	}
}
