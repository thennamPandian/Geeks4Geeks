package heap;

public class FindAllElementsMinAndMaxOfK {

	public static void main(String[] args) {

		//0. Heap is null
		System.out.println("\n max : ");
		findMax(null, 0, 9);
		System.out.println("\n min :");
		findMin(null,0,10);
		
		// 1.Heap is not null
		
		// 1a. Max and min is there in other sub tree
		System.out.println("\n");
		int[] elements = new int[] { 1, 15, 10, 11, 8, 9, 7, 6 };
		Heap heap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(heap);
		System.out.print("\n max : ");
		findMax(heap, 0, 9);
		System.out.print("\n min : ");
		findMin(heap,0,10);

		// 1a. same as above 
		System.out.println("\n");
		elements = new int[] { 15, 14, 11, 12, 13, 9, 10 };
		heap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(heap);
		System.out.print("\n max : ");
		findMax(heap, 0, 9);
		System.out.print("\n min :");
		findMin(heap, 0, 14);
		
		// 1b. min and max of root
		System.out.println("\n");
		HeapUtil.printHeap(heap);
		System.out.print("\n max : ");
		findMax(heap, 0, 15);
		System.out.print("\n min :");
		findMin(heap, 0, 15);
		
		// 1c. max an min of leaf
		System.out.println("\n");
		elements = new int[] { 15, 14, 8, 12, 13, 6, 5 };
		heap = BuildHeap.buildHeap(null, elements);
		HeapUtil.printHeap(heap);
		System.out.print("\n max : ");
		findMax(heap, 0, 6);
		System.out.print("\n min :");
		findMin(heap, 0, 12);
		
		System.out.println("\n");
		System.out.print("\n max : ");
		findMax(heap, 0, 5);
		System.out.print("\n min :");
		findMin(heap, 0, 5);
	}

	public static void findMax(Heap heap, int index, int k) {
		if (heap == null)
			return;

		if (heap.getCount() <= index)
			return;

		int[] elements = heap.getElements();

		if (k >= elements[index])
			return;

		System.out.print(elements[index] + " , ");

		findMax(heap, (2 * index) + 1, k);
		findMax(heap, (2 * index) + 2, k);

	}

	public static void findMin(Heap heap, int index, int k) {
		if (heap == null)
			return;

		if (heap.getCount() <= index)
			return;

		int[] elements = heap.getElements();

		if (k > elements[index])
			System.out.print(elements[index] + " , ");

		findMin(heap, (2 * index) + 1, k);
		findMin(heap, (2 * index) + 2, k);

	}

}
