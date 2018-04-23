package heap;

public class FindKthMinAmong2SortedArray {

	public static void main(String[] args) {

		// 1. Both null
		System.out.println("\n KthMin : " + getKthMin(null, null, 2));

		// 2. one of them is null
		// 2a. b is null
		int[] a = new int[] { 1, 2 };
		int[] b = null;
		System.out.println("\n KthMin : " + getKthMin(a, b, 1));

		// 2a. a is null
		a = null;
		b = new int[] { 1, 2, 3, 4 };
		System.out.println("\n KthMin : " + getKthMin(a, b, 3));

		// 2c. a is null and k out of range of b.
		System.out.println("\n KthMin : " + getKthMin(a, b, 5));

		// 3. Both not null and equal length
		// 3a. index is out of range of both length
		a = new int[] { 1, 2 };
		b = new int[] { 3, 4 };
		System.out.println("\n KthMin : " + getKthMin(a, b, 5));

		// 3b. kthMin is there in the a
		System.out.println("\n KthMin : " + getKthMin(a, b, 2));

		// 3c. kthMin is there in the b
		System.out.println("\n KthMin : " + getKthMin(a, b, 3));

		// 4. Both not null and different length
		// 4a. index is out of range of both length
		a = new int[] { 1, 2 };
		b = new int[] { 3, 4,5 };
		System.out.println("\n KthMin : " + getKthMin(a, b, 6));

		// 4b. kthMin is there in the a
		System.out.println("\n KthMin : " + getKthMin(a, b, 2));

		// 4c. kthMin is there in the b
		System.out.println("\n KthMin : " + getKthMin(a, b, 5));
		
		// 5 ZigZag arrays
		a = new int[] { 1, 3 };
		b = new int[] { 2, 4,5 };
		for (int i = 0; i <= (a.length + b.length); i++) {
			System.out.println("\n KthMin : " + getKthMin(a, b, i));
		}
		

	}

	public static int getKthMin(int[] a, int[] b, int k) {

		int kthMin = -1;

		if (a == null && b == null)
			return kthMin;
		else if (a == null) {
			if (k < b.length)
				return b[k - 1];
			else
				return kthMin;
		} else if (b == null) {
			if (k < a.length)
				return a[k - 1];
			else
				return kthMin;
		} else if (k > (a.length + b.length))
			return kthMin;
		else {

			int count = 0;
			int i = 0, j = 0;

			for (; ((i < a.length && j < b.length) && count < k); count++) {
				if (a[i] < b[j]) {
					kthMin = a[i];
					i++;
				} else {
					kthMin = b[j];
					j++;
				}
			}

			if (count < k) {
				if (i == a.length) {

					while ((j < b.length && count < k)) {
						kthMin = b[j];
						count++;
						j++;
					}
				} else {
					while ((i < a.length && count < k)) {
						kthMin = a[i];
						count++;
						i++;
					}
				}
			}

		}
		return kthMin;
	}

}
