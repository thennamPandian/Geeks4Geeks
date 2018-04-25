package arrays;

import java.util.Scanner;

/**
 * Refer the problem RowHasMaxCountOf_1 for the question
 */

public class RowHasMaxCountOf_1_UsingBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner scanner = new Scanner(System.in);) {

			System.out.println("\n Enter the column of the array : ");
			int col = Integer.parseInt(scanner.nextLine());

			System.out.println("\n Enter the row of the array : ");
			int row = Integer.parseInt(scanner.nextLine());

			int[][] arr = new int[row][col];

			for (int i = 0; i < row; i++) {
				System.out.println("\n Enter the elements of next row ");
				for (int j = 0; j < col; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}

			System.out.println("\n Given 2D array ");

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

			int maxIndex = col;
			int rowIndx = colIndexUsingBinarySearch(arr[0],0,col,1);

			for (int i = 1; i < row; i++) {
				for (int j = maxIndex - 1; j >= 0; j--) {
					if (arr[i][j] == 1) {
						maxIndex = j;
						rowIndx = i;
						if (j == 0) {
							break;
						}
					}
				}
			}

			System.out.println("Row which has max Idex = " + rowIndx);
		}
	}

	private static int colIndexUsingBinarySearch(int[] a, int start, int end, int e) {
		int index = -1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (a[mid] == e) {
				index = mid;
				end = mid-1;
			} else {

				if (a[mid] < e) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}

			}
		}
		return index;
	}
}
