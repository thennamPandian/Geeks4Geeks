package searching;

public class FindingThePivotInTheRotatedArray {

	public static void main(String[] args) {

		// Rotated arrary
		int[] elements = new int[] { 9, 10, 11, 14, 1, 3, 4, 6 };
		int pivot = findPivot(elements, 0, elements.length - 1);
		System.out.println(" Index : " + pivot);

		// null array
		pivot = findPivot(null, 0, 0);
		System.out.println(" Index : " + pivot);

		// zero length
		elements = new int[0];
		pivot = findPivot(elements, 0, 0);
		System.out.println(" Index : " + pivot);

		// single element
		elements = new int[] { 1 };
		pivot = findPivot(elements, 0, elements.length - 1);
		System.out.println(" Index : " + pivot);

		// single element
		elements = new int[] { 1, 2 };
		pivot = findPivot(elements, 0, elements.length - 1);
		System.out.println(" Index : " + pivot);

		// non-rotated array
		elements = new int[] { 1, 2, 3, 4, 5 };
		pivot = findPivot(elements, 0, elements.length - 1);
		System.out.println(" Index : " + pivot);

		// single right rotated
		System.out.println("right rotated");
		elements = new int[] { 5, 1, 2, 3, 4 };
		pivot = findPivot(elements, 0, elements.length - 1);
		System.out.println(" Index : " + pivot);
		
		// double right rotated
		System.out.println("right rotated");
		elements = new int[] { 4, 5, 1, 2, 3 };
		pivot = findPivot(elements, 0, elements.length - 1);
		System.out.println(" Index : " + pivot);

	}

	public static int findPivot(int[] arr, int start, int end) {
		if (arr == null || arr.length == 0)
			return -1;

		if (arr.length == 1 || arr.length == 2)
			return 0;

		if (start > end)
			return -1;

		int mid = (start + end) / 2;

		if (mid == 0)
			return 0;

		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
			return mid;
		else if (arr[mid] > arr[end]) {
			return findPivot(arr, mid + 1, end);
		} else if (arr[mid] < arr[start]) {
			return findPivot(arr, start, mid - 1);
		} else {
			return 0;
		}
	}

}
