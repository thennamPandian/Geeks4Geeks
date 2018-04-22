package heap;

public class Merging2MaxHeap {

	public static void main(String[] args) {

		// 0. Both heaps are null
		Heap heap = mergeHeaps(null, null);
		HeapUtil.printHeap(heap);

		// 1. One of them is not null
		System.out.println("\n");
		int[] elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		Heap firstHeap = HeapUtil.createHeap(elements);
		heap = mergeHeaps(firstHeap, null);
		HeapUtil.printHeap(heap);

		// 2. Both heaps are not null
		// 2a. All elements in 2nd Heap is less than the first heap
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		firstHeap = HeapUtil.createHeap(elements);
		elements = new int[] { -15, -10, -11, -8, -9, -7, -6 };
		Heap secondHeap = HeapUtil.createHeap(elements);
		heap = mergeHeaps(firstHeap, secondHeap);
		HeapUtil.printHeap(heap);

		// 2b. All elements in 2nd Heap is greater than the first heap
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		firstHeap = HeapUtil.createHeap(elements);
		elements = new int[] { -15, -10, -11, -8, -9, -7, -6 };
		secondHeap = HeapUtil.createHeap(elements);
		heap = mergeHeaps(secondHeap, firstHeap);
		HeapUtil.printHeap(heap);

		// 23. Some of 2nd heap elements are greater than first heap elements
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		firstHeap = HeapUtil.createHeap(elements);
		elements = new int[] { 2, 3, 5, 25, 26 };
		secondHeap = HeapUtil.createHeap(elements);
		heap = mergeHeaps(firstHeap, secondHeap);
		HeapUtil.printHeap(heap);

	}

	public static Heap mergeHeaps(Heap heap1, Heap heap2) {
		if (heap1 == null)
			return heap2;
		if (heap2 == null)
			return heap1;
		return BuildHeap.buildHeap(heap1, heap2.getElements());
	}

}
