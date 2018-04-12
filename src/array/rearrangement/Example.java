package array.rearrangement;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ts = sc.nextInt();
		for (int w = 0; w < ts; w++) {
			int n = sc.nextInt();

			int[] arr = new int[n];
			for (int p = 0; p < n; p++) {
				arr[p] = sc.nextInt();
			}

			for (int i = 0; i < n - 1; i++) {
				if (i % 2 == 0) {
					if (arr[i] < arr[i + 1]) {

					} else {
						int t = arr[i + 1];
						arr[i + 1] = arr[i];
						arr[i] = t;
					}
				} else if (i % 2 == 1) {
					if (arr[i] > arr[i + 1]) {

					} else {
						int p = arr[i + 1];
						arr[i + 1] = arr[i];
						arr[i] = p;
					}

				}
			}

			for (int z = 0; z < n; z++) {
				System.out.print(arr[z] + " ");
			}
			System.out.println();
		}

	}

}
