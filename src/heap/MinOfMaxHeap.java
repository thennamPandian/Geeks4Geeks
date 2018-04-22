package heap;

public class MinOfMaxHeap {

	public static void main(String[] args) {

		// 0. Null heap
		System.out.print("\n min : " + getMin(null));

		// 1. Non-null heap

		// 1a. Non-leaf node is the left most element in the last level
		System.out.println("\n");
		int[] elements = new int[] { 1, 15, 10, 11, 8, 9, 7, 6 };
		Heap heap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(heap);
		System.out.print("\n min : " + getMin(heap));

		// 1b. Perfect Binary Tree min in the RST
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		heap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(heap);
		System.out.print("\n min : " + getMin(heap));

		// 1b. Perfect Binary Tree min in the LST
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 5, 7, 6 };
		heap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(heap);
		System.out.print("\n min : " + getMin(heap));

		// 1b. AVL Tree min in the RST
		System.out.println("\n");
		elements = new int[] { 15, 10, 6, 8, 7 };
		heap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(heap);
		System.out.print("\n min : " + getMin(heap));

		// 1b. AVL Tree min in the LST
		System.out.println("\n");
		elements = new int[] { 15, 10, 6, 8, 2 };
		heap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(heap);
		System.out.print("\n min : " + getMin(heap));
	}

	public static int getMin(Heap heap) {

		int min = Integer.MAX_VALUE;
		if (heap == null)
			return min;

		int i = heap.getCount() - 1;
		int leftChild = (2 * i) + 1;

		while (leftChild >= heap.getCount()) {

			if (heap.getElements()[i] < min)
				min = heap.getElements()[i];
			i--;
			leftChild = (2 * i) + 1;

		}

		return min;
	}

}
