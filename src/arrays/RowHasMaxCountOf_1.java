package arrays;

import java.util.Scanner;

/*
 * Given an sorted row wise  2d array having 0s and 1s . find the row no which have maximum no of 1s.

i/p:

  0 1 2 3
0: 0 1 1 1
1: 0 0 1 1
2: 1 1 1 1
3: 0 0 0 0

o/p: 2

*
*/
public class RowHasMaxCountOf_1 {

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
			int rowIndx = -1;
			
			for (int i = 0; i < row; i++) {
				for (int j = maxIndex-1; j >= 0; j--) {				
					if(arr[i][j] == 1) {
						maxIndex = j;
						rowIndx = i;
						if(j == 0) {
							break;
						}
					}
				}
			}
			
			System.out.println("Row which has max Idex = "+ rowIndx);
		}
	}

}
