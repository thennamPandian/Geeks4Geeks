package heap;

public class Insertion {

	public static void main(String[] args) {

		// null heap
		System.out.println();
		Heap maxHeap = null;
		maxHeap = insert(maxHeap, 15);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// Insert into single element in heap
		System.out.println();
		int[] elements = new int[] { 25 };
		maxHeap = HeapUtil.createHeap(elements);
		maxHeap = insert(maxHeap, 105);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// Insert into non capacity fulled heap
		System.out.println();
		elements = new int[] { 35};
		maxHeap = HeapUtil.createHeap(2,elements);
		maxHeap = insert(maxHeap, 205);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// Insert into 2 elements in heap
		maxHeap = insert(maxHeap, 5);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// Insert element which is greater than all the nodes
		elements = new int[] { 15, 10, 11, 5, 9, 7, 6, 8, 4, 2, 3, 5, 6, 5 };
		maxHeap = HeapUtil.createHeap(elements);
		maxHeap = insert(maxHeap, 105);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// Insert element which is smaller than all the nodes
		elements = new int[] { 15, 10, 11, 5, 9, 7, 6, 8, 4, 2, 3, 5, 6, 5 };
		maxHeap = HeapUtil.createHeap(elements);
		maxHeap = insert(maxHeap, 0);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);
	}

	public static Heap insert(Heap heap, int data) {

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
				&& (elements[parentIndex] < elements[childIndex])) {
			elements[childIndex] = elements[parentIndex];
			elements[parentIndex] = data;
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}

		return heap;
	}

}
