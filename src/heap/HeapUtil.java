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
		for (int i = 0; i < heap.getCount(); i++) {
			System.out.print(heap.getElements()[i] + " , ");
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
			r = -1;

		int[] elements = heap.getElements();

		int cur = elements[i];
		int next = -1;
		
		int maxChild = cur;
		
		if( maxChild < elements[l]){
			maxChild = elements[l];
			next = l;
		}
		
		if(r != -1 && maxChild < elements[r] ) {
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
}
