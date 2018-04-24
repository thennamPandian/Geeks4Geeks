package stack;

public class SnapProblem {

	public static void main(String[] args) {

		// 1. Null
		System.out.println("Null");
		display(snap(null));

		// 2. Zero length
		System.out.println("zero lentgth");
		display(snap(new int[0]));

		// 3. Sorted array
		// 3a. ascending
		System.out.println("\n");
		int[] elements = new int[] { 2, 4, 6, 8, 10 };
		display(snap(elements));

		// 3B. descending
		System.out.println("\n");
		elements = new int[] { 10, 8, 6, 4, 2 };
		display(snap(elements));

		// Unsorted array
		System.out.println("\n");
		elements = new int[] { 100, 80, 60, 70, 60, 75, 85 };
		display(snap(elements));

		// Unsorted array
		System.out.println("\n");
		elements = new int[] { 6,3,4,5,2};
		display(snap(elements));
	}

	public static void display(int[] values) {
		if (values == null || values.length == 0)
			return;
		else {

			for (int i = 0; i < values.length; i++) {
				System.out.print(values[i] + " , ");
			}

		}
	}

	public static int[] snap(int[] prices) {
		if (prices == null || prices.length == 0)
			return null;

		int[] span = new int[prices.length];
		span[0] = 1;

		Stack stack = new Stack(prices.length);
		stack.push(0);

		for (int i = 1; i < prices.length; i++) {

			while (!stack.isEmpty() && prices[stack.top()] <= prices[i])
				stack.pop();

			span[i] = stack.isEmpty() ? (i + 1) : (i - stack.top());

			stack.push(i);
		}

		return span;
	}

}
