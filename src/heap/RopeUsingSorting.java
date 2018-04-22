package heap;

import java.util.Arrays;

public class RopeUsingSorting {

	public static void main(String[] args) {

		int[] elements = new int[] { 4, 3, 2, 6 };
		System.out.println("\n Min Cost : " + getMinCost(elements));
		
		elements = new int[] { 4, 1, 2, 5};
		System.out.println("\n Min Cost : " + getMinCost(elements));
		
		elements = new int[] { 4, 1, 2, 1};
		System.out.println("\n Min Cost : " + getMinCost(elements));
		
		elements = new int[] { 4, 1};
		System.out.println("\n Min Cost : " + getMinCost(elements));

	}

	public static int getMinCost(int[] elements) {

		if (elements == null)
			return 0;

		Arrays.sort(elements);
		int sum = 0;
		int minCost = sum;

		if (elements.length >= 2) {
			sum = elements[0]+elements[1];
			minCost += sum;
			
			for (int i = 2; i < elements.length ; i++) {
				sum += elements[i];
				minCost += sum;
			}
		}

		return minCost;
	}
}
