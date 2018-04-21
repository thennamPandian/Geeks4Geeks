package heap;

public class DeleteMax {

	public static void main(String[] args) {

		// null Heap
		Heap maxHeap = null;
		HeapUtil.printHeap(maxHeap);
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// Single element heap
		System.out.println(" \n Single Element");
		int[] elements = new int[] { 15 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// two elements heap
		System.out.println("\n 2 Elements");
		elements = new int[] { 15, 1 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// Leaves are in same level
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// delete one more time
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// delete one more time
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// delete one more time
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// delete one more time
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// delete one more time
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// delete one more time
		System.out.println("\nDelete last element");
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// Leaves are not in same level
		System.out.println("\n Leaves are not in same level");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6, 4, 3 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// delete one more time
		deleteMax(maxHeap);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

	}

	public static void deleteMax(Heap heap) {

		if (heap == null)
			return;

		if (heap.getCount() == 0)
			return;

		if (heap.getCount() == 1) {
			heap.setCount(0);
			return;
		}

		int[] elements = heap.getElements();
		int cur = elements[heap.getCount() - 1];
		heap.setCount(heap.getCount() - 1);
		elements[0] = cur;

		HeapUtil.heapify(heap, 0);

	}

}
