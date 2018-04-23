package heap;

public class FindKthMaxIn2UnSortedArray {

	public static void main(String[] args) {
		// 1. Both null
		System.out.println("\n KthMax : " + getKthMax(null, null, 2));

		// 2. one of them is null
		// 2a. b is null
		int[] a = new int[] { 1, 2 };
		int[] b = null;
		System.out.println("\n KthMax : " + getKthMax(a, b, 1));

		// 2a. a is null
		a = null;
		b = new int[] { 1, 2, 3, 4 };
		System.out.println("\n KthMax : " + getKthMax(a, b, 3));

		// 2c. a is null and k out of range of b.
		System.out.println("\n KthMax : " + getKthMax(a, b, 5));

		// 3. Both not null and equal length
		// 3a. index is out of range of both length
		a = new int[] { 1, 2 };
		b = new int[] { 3, 4 };
		System.out.println("\n KthMax : " + getKthMax(a, b, 5));

		// 3b. KthMax is there in the a
		System.out.println("\n KthMax : " + getKthMax(a, b, 2));

		// 3c. KthMax is there in the b
		System.out.println("\n KthMax : " + getKthMax(a, b, 3));

				
		// 4. Both not null and different length
		// 4a. index is out of range of both length
		a = new int[] { 1, 2 };
		b = new int[] { 3, 4, 5 };
		System.out.println("\n KthMax : " + getKthMax(a, b, 6));

		// 4b. KthMax is there in the a
		System.out.println("\n KthMax : " + getKthMax(a, b, 2));

		// 4c. KthMax is there in the b
		System.out.println("\n KthMax : " + getKthMax(a, b, 5));

		// 5 ZigZag arrays
		a = new int[] { 1, 3 };
		b = new int[] { 2, 4, 5 };
		for (int i = 0; i <= (a.length + b.length); i++) {
			System.out.println("\n KthMax : " + getKthMax(a, b, i));
		}
	}

	public static int getKthMax(int[] a, int[] b, int k) {

		if (a == null & b == null)
			return -1;
		if (k <= 0)
			return -1;
		if (a == null) {
			if (k <= b.length) {
				return FindKthMaxInUnSortedArray.getKthMax(b, k);
			} else {
				return -1;
			}
		} else if (b == null) {
			if (k <= a.length) {
				return FindKthMaxInUnSortedArray.getKthMax(a, k);
			} else {
				return -1;
			}
		} else {
			int newCapacity = a.length + b.length;
			if (k <= a.length + b.length) {
				int[] values = new int[a.length + b.length];
				int c = 0;
				int i = 0;
				for (; i < a.length; i++, c++)
					values[c] = a[i];
				for (i = 0; i < b.length; i++, c++)
					values[c] = b[i];
				return FindKthMaxInUnSortedArray.getKthMax(values, k);
			}
		}

		return -1;
	}

}
