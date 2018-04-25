package queue;

/*
 * Maximum element in every window of size k in un sorted  array of size n.

 i/p: 1 3 -1 -3 5 3 6 7
 k = 3

 0  1  2   3 4 5 6 7
 [1 3 -1] -3 5 3 6 7   = 3

 1 [3 -1 -3] 5 3 6 7   = 3

 1 3 [-1 -3 5] 3 6 7   = 5

 1 3 -1 [-3 5 3] 6 7   = 5

 1 3 -1 -3 [5 3 6] 7   = 6

 1 3 -1 -3 5 [3 6 7]   = 7

 */
public class MaxElementInWindowSizeK {

	public static void main(String[] args) {

		// un-sorted array
		int[] elements = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		findMaxInWindowSizeK(elements, 3);
		
		// k =1
		System.out.print("\n k = 1 : ");
		elements = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		findMaxInWindowSizeK(elements, 1);
		
		// k =n 
		System.out.print("\n k = n : ");
		elements = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		findMaxInWindowSizeK(elements, elements.length);
		
		// ascending order
		System.out.print("\n  ascending order : ");
		elements = new int[] { 1, 2,3,4,5 };
		findMaxInWindowSizeK(elements, elements.length);
		
		// descending order
		System.out.print("\n  descending order : ");
		elements = new int[] { 5,4,3,2,1 };
		findMaxInWindowSizeK(elements, elements.length);
		

		// null array
		System.out.println("\n Null Array : ");
		findMaxInWindowSizeK(null, 3);

		// 0 length
		System.out.println("\n Zero length Array : ");
		elements = new int[] {};
		findMaxInWindowSizeK(elements, 3);

		// Out of range
		elements = new int[] {1};
		System.out.println("\n Out of range : ");
		findMaxInWindowSizeK(elements, 0);

		// Out of range
		System.out.println("\n Out of range : ");
		findMaxInWindowSizeK(elements, -2);

		// Out of range
		System.out.println("\n Out of range : ");
		findMaxInWindowSizeK(elements, 15);
	}

	public static void findMaxInWindowSizeK(int[] elements, int k) {

		if (elements == null || elements.length == 0)
			return;
		
		if (k <= 0 || k > elements.length)
			return;

		int i = 0, j = 0;
		DoubleEndedQueue dQueue = new DoubleEndedQueue();
		ElementWithIndex data = null;
		for (; j < k; j++) {
			data = (ElementWithIndex) dQueue.getBack();
			while (!dQueue.isEmpty() && (data.getData() < elements[j])) {
				dQueue.deleteBack();
				data = (ElementWithIndex) dQueue.getBack();
			}

			data = new ElementWithIndex();
			data.setIndex(j);
			data.setData(elements[j]);
			dQueue.insertBack(data);
		}

		for (; j < elements.length; j++) {
			System.out.print(((ElementWithIndex) dQueue.getFront()).getData()
					+ " , ");
			i++;
			data = (ElementWithIndex) dQueue.getFront();

			if (data != null && data.getIndex() < i)
				dQueue.deleteFront();

			while (!dQueue.isEmpty() && (data.getData() < elements[j])) {
				dQueue.deleteBack();
				data = (ElementWithIndex) dQueue.getBack();
			}

			data = new ElementWithIndex();
			data.setIndex(j);
			data.setData(elements[j]);
			dQueue.insertBack(data);
		}

		System.out.print(((ElementWithIndex) dQueue.getFront()).getData());
	}
}
