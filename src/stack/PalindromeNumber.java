package stack;

public class PalindromeNumber {

	public static void main(String[] args) {
		// null
		System.out.println(isPalindrome(null));

		// zero length
		System.out.println(isPalindrome(new int[0]));

		// PalindromeNumber
		// odd length
		System.out.println(isPalindrome(new int[] { 1, 2, 3, 2, 1 }));
		// even length
		System.out.println(isPalindrome(new int[] { 1, 2, 2, 1 }));

		// Non-palindromeNumber
		// odd length
		System.out.println(isPalindrome(new int[] { 1, 2, 3, 12, 1 }));
		// even length
		System.out.println(isPalindrome(new int[] { 1, 12, 2, 1 }));

	}

	public static boolean isPalindrome(int[] arr) {

		if (arr == null || arr.length == 0)
			return true;

		int mid = arr.length / 2;
		int nextIndex = arr.length % 2 == 0 ? mid : mid + 1;

		Stack span = new Stack(mid);
		int i = 0;
		for (; i < mid; i++) {
			span.push(arr[i]);
		}

		i = nextIndex;

		for (; i < arr.length; i++) {
			if (arr[i] != span.pop())
				return false;
		}

		return true;
	}

}
