package heap;

public class Rope {

	public static void main(String[] args) {

		// 0. Null array
		System.out.println("\n maxCost " + getMaxCost(null));

		// 1. Non null array
		// 1a. un-sorted
		System.out.println("\n");
		int[] elements = new int[] { 4, 3, 2, 6 };
		Heap maxHeap = null;
		HeapUtil.printHeap(maxHeap);
		System.out.println("");
		maxHeap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(maxHeap);
		System.out.println("\n maxCost : " + getMaxCost(maxHeap));

		// 1b. sorted descending
		System.out.println("\n");
		elements = new int[] { 6, 4, 3, 2, };
		maxHeap = null;
		HeapUtil.printHeap(maxHeap);
		System.out.println("");
		maxHeap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(maxHeap);
		System.out.println("\n maxCost : " + getMaxCost(maxHeap));

		// 1ac. sorted ascending
		System.out.println("\n");
		elements = new int[] { 2, 3, 4, 6 };
		maxHeap = null;
		HeapUtil.printHeap(maxHeap);
		System.out.println("");
		maxHeap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(maxHeap);
		System.out.println("\n maxCost : " + getMaxCost(maxHeap));

	}

	public static int getMaxCost(Heap heap) {

		if (heap == null)
			return 0;
		int minCost = 0;
		while (heap.getCount() > 1) {
			int a = heap.getElements()[HeapUtil.max(heap)];
			DeleteMax.deleteMax(heap);
			int b = heap.getElements()[HeapUtil.max(heap)];
			DeleteMax.deleteMax(heap);
			int sum = a + b;
			Insertion.insert(heap, sum);
			minCost = minCost + sum;
		}

		return minCost;
	}

}
