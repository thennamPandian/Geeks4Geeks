package heap;

public class Heapifying {

	public static void main(String[] args) {

		// null heap
		System.out.println();
		HeapUtil.heapify(null, 3);

		// Single element heap
		System.out.println();
		int[] elements = new int[] { 15 };
		Heap maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		HeapUtil.heapify(maxHeap, 3);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// heapify element in LST
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6, 12, 4, 2, 3 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		HeapUtil.heapify(maxHeap, 3);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// heapify element index in negative
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		HeapUtil.heapify(maxHeap, -3);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// heapify element index +Ve, out of range
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		HeapUtil.heapify(maxHeap, 23);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// heapify already heapified heap
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		HeapUtil.heapify(maxHeap, 0);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// heapify Root
		System.out.println("\n");
		elements = new int[] { 5, 10, 11, 8, 9, 7, 6, 2, 4, 2, 3 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		HeapUtil.heapify(maxHeap, 0);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);

		// heapify element in RST
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 17, 6, 2, 4, 2, 3 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		HeapUtil.heapify(maxHeap, 2);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);
		
		// heapify element in RST of LST
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6, 2, 4, 12, 3 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		HeapUtil.heapify(maxHeap, 4);
		System.out.println("");
		HeapUtil.printHeap(maxHeap);
	}

}
