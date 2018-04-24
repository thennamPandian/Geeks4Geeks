package stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {

		// Null array
		System.out.println(largestRectangle(null));
		
		// empty array
		System.out.println(largestRectangle(new int[]{}));
		
		// Highest histogram is coming in the middle
		int[] elements = new int[] { 10, 8, 9, 11, 8, 6, 7 };
		System.out.println(largestRectangle(elements));
		
		// unsorted		
		elements = new int[] { 6,2,5,4,5,1,6};
		System.out.println(largestRectangle(elements));
		
		// unsorted	
		elements = new int[] { 2,1,2,3,1};
		System.out.println(largestRectangle(elements));
		
		// ascending order
		elements = new int[] { 1,2,3,4,5};
		System.out.println(largestRectangle(elements));
		
		// descending order
		elements = new int[] { 5,4,3,2,1};
		System.out.println(largestRectangle(elements));
	}

	public static int largestRectangle(int[] histograms) {
		int maxArea = 0;
		if (histograms == null || histograms.length == 0)
			return maxArea;

		Stack stack = new Stack(histograms.length);
		stack.push(0);
		int i = 1;
		for (; i < histograms.length; i++) {

			while (!stack.isEmpty() && histograms[i] <= histograms[stack.top()]) {
				int index = stack.pop();
				int area = 0;

				if (stack.isEmpty()) {
					area = histograms[index] * i;
				} else {
					area = histograms[index] * (i - stack.top() - 1);
				}

				if (area > maxArea) {
					maxArea = area;
				}
			}
			
			stack.push(i);

		}

		while (!stack.isEmpty()) {
			int index = stack.pop();
			int area = 0;

			if (stack.isEmpty()) {
				area = histograms[index] * i;
			} else {
				area = histograms[index] * (i - stack.top() - 1);
			}

			if (area > maxArea) {
				maxArea = area;
			}

		}

		return maxArea;
	}
}
