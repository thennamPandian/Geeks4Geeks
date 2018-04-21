package heap;

public class HeapUtil {

	public static Heap createHeap(int capacity, int[] elements) {
		Heap heap = new Heap(capacity);
		heap.setCount(capacity);
		heap.setElements(elements);
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

	public static void printHeap(Heap heap) {
		if (heap == null)
			return;
		for (int data : heap.getElements()) {
			System.out.print(data + " , ");
		}
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
			return;

		int[] elements = heap.getElements();

		int cur = elements[i];
		int next = -1;

		int maxChild = elements[l] > elements[r] ? elements[l] : elements[r];

		if (cur < maxChild) {
			elements[i] = maxChild;

			if (elements[l] == maxChild) {
				elements[l] = cur;
				next = l;
			} else {
				elements[r] = cur;
				next = r;
			}

			// heap.setElements(elements);
			heapify(heap, next);
		}
	}
}
