package heap;

public class FindKthMaxElement {

	public static void main(String[] args) {

		// 1. Heap is null
		System.out.println("\n KthMax : " + findKthMax(null, 3));
		
		//2. Heap is not null
		System.out.println("\n");
		int[] elements = new int[] { 15, 11, 9, 10, 4, 7, 6, 2, 3 };
		Heap maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		System.out.println("\n");
		
		// 2a. KthMax is present in LST
		System.out.println("\n KthMax : " + findKthMax(maxHeap, 3));
		System.out.println("\n KthMax : " + findKthMax(maxHeap, 7));
		
		// 2a. KthMax is present in RST
		System.out.println("\n KthMax : " + findKthMax(maxHeap, 5));
		System.out.println("\n KthMax : " + findKthMax(maxHeap, 6));
		
		//2b. KthMax is root node
		System.out.println("\n KthMax : " + findKthMax(maxHeap, 1));
		
		//2b. KthMax is leaf node
		System.out.println("\n KthMax : " + findKthMax(maxHeap, 9));
		
		
		//2c. KthMax is the kth element of array reprsentation of heap
		System.out.println("\n");
		elements = new int[] { 15, 11,10, 9, 7, 6, 4,2, 3 };
		maxHeap = HeapUtil.createHeap(elements);
		HeapUtil.printHeap(maxHeap);
		System.out.println("\n");
		
		for (int i = 1; i <= elements.length; i++) {
			System.out.println("\n KthMax : " + findKthMax(maxHeap, i));
		}
		
	}

	public static int findKthMax(Heap heap, int k) {
		int kthMax = -1;
		if (heap == null || k <= 0)
			return kthMax;

		int[] elements = heap.getElements();
		Heap auxHeap = HeapUtil.createHeap(k,
				new int[] { elements[HeapUtil.max(heap)] });

		int count = 1;

		while (true) {
			int data = auxHeap.getElements()[HeapUtil.max(auxHeap)];
			if (count == k) {
				kthMax = data;
				break;
			}

			DeleteMax.deleteMax(auxHeap);
			int i = HeapUtil.findPositionOfElement(heap, data);
			int lChildIndex = (2 * i + 1);
			int rChildIndex = (2 * i + 2);

			if (lChildIndex < heap.getCount()) {
				Insertion.insert(auxHeap, elements[(2 * i + 1)]);
				if(rChildIndex < heap.getCount() )
				Insertion.insert(auxHeap, elements[(2 * i + 2)]);
			}
			count++;
		}

		return kthMax;
	}
}
