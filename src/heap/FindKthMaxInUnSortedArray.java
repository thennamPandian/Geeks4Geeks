package heap;

public class FindKthMaxInUnSortedArray {

	public static void main(String[] args) {
		// 1. Null
		System.out.println("\n kthMax : " + getKthMax(null, 2));

		// 2. Not null,

		// 2a. unsorted array
		System.out.println("\n");
		int[] elements = new int[] { 9, 4, 7, 11, 3, 10, 15, 6, 2 };
		for (int i = 1; i <= elements.length; i++) {
			System.out.println("\n KthMax : " + getKthMax(elements, i));
		}

		// 2b. sorted rotated k items

		System.out.println("\n");
		elements = new int[] { 6, 4, 2, 3, 15, 11, 10, 9, 7 };
		for (int i = 1; i <= elements.length; i++) {
			System.out.println("\n KthMax : " + getKthMax(elements, i));
		}
		System.out.println("\n KthMax : " + getKthMax(elements, 22));
	}

	public static int getKthMax(int[] elements, int k) {
		if (elements == null)
			return -1;
		Heap heap = BuildHeap.buildHeap(null, elements);
		return FindKthMaxElement.findKthMax(heap, k);
	}

}
