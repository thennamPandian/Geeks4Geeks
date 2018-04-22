package heap;

public class BuildHeap {

	public static void main(String[] args) {

		// 1. heap and element are null
		System.out.println();
		Heap maxHeap = null;
		maxHeap = buildHeap(maxHeap, null);
		HeapUtil.printHeap(maxHeap);
				
		// 2. heap is null and elements is not null
		System.out.println("\n");
		maxHeap = null;
		int[] elements = new int[] { 15, 10, 11, 5, 9, 7, 6, 8, 4, 2, 3, 5, 6, 5 };
		maxHeap = buildHeap(maxHeap, elements);
		HeapUtil.printHeap(maxHeap);
		
		// 3. heap is not null and elements is null
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6, 4, 3 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		System.out.println("");
		maxHeap = buildHeap(maxHeap, null);
		HeapUtil.printHeap(maxHeap);
		
		// 4. Both are not null
		
		// 4a. after adding to the heap new elements are satisfy the heap property
		System.out.println("\n");
		elements = new int[] { 2,3 };
		HeapUtil.printHeap(maxHeap);
		System.out.println("");
		maxHeap = buildHeap(maxHeap, elements);
		HeapUtil.printHeap(maxHeap);
		
		// 4b. capacity of heap is enough to hold the elements, However new elements violates the heap property.
		System.out.println("\n");
		elements = new int[] { 15, 10, 11, 8, 9, 7, 6, 4, 3 };
		// Creating the heap with more capacity
		maxHeap = HeapUtil.createHeap(15,elements);
		HeapUtil.printHeap(maxHeap);
		System.out.println("");
		elements = new int[] { 22,25 };
		maxHeap = buildHeap(maxHeap, elements);
		HeapUtil.printHeap(maxHeap);
	}

	public static Heap buildHeap(Heap heap, int[] values) {

		if (values == null)
			return heap;

		if (heap == null) {
			heap = HeapUtil.createHeap(values);
		} else {
			// Re-size of the heap capacity is not enough
			int newCapacity = heap.getCount() + values.length;
			if (newCapacity > heap.getCapacity()) {
				int size = newCapacity * 2;
				int[] elements = new int[size];
				int i = 0;
				for (; i < heap.getElements().length; i++) {
					elements[i] = heap.getElements()[i];
				}

				for (; i < heap.getCount() + values.length; i++) {
					elements[i] = values[i - heap.getCount()];
				}
				heap.setCount(i);
				heap.setCapacity(size);
				heap.setElements(elements);
			} else {
				int i = heap.getCount();
				for(; i < heap.getCount()+values.length ; i++){
					heap.getElements()[i] = values[i-heap.getCount()];
				}
				heap.setCount(i);
			}
		}

		for (int i = ((heap.getCount() - 1) / 2); i >= 0; i--) {
			HeapUtil.heapify(heap, i);
		}
		
		return heap;

	}

}
