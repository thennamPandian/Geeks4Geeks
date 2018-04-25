package arrays;

import java.util.Scanner;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */

public class RainTrapProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner scanner = new Scanner(System.in);) {

			System.out.println(" Enter the size of the array : ");
			int size = Integer.parseInt(scanner.nextLine().trim());
			int[] arr = new int[size];

			System.out.println("\n Enter the elements :  ");
			String[] values = scanner.nextLine().split(" ");

			int x = 0;
			for (String value : values) {
				arr[x++] = Integer.parseInt(value);
			}
			
			System.out.println("\n Given elevation of map :  ");
			for(int ai : arr){
				System.out.print(ai +" ");
			}
			
			// Left max for each element including the current element
			int[] lMax = new int[size];
			int max = -1;
            for(int i = 0; i < size;i++)  {
            	if(arr[i] > max) {
            		max=arr[i];
            	}
            	lMax[i] = max;
            }
			
            
            // Right max for each element including the current element
            int[] rMax = new int[size];
			max = -1;
            for(int i = size-1; i >= 0;i--)  {
            	if(arr[i] > max) {
            		max=arr[i];
            	}
            	rMax[i] = max;
            }
			
            System.out.println("\n Lmax :  ");
			for(int ai : lMax){
				System.out.print(ai +" ");
			}
			
			System.out.println("\n rMax :  ");
			for(int ai : rMax){
				System.out.print(ai +" ");
			}
			
			int sum = 0;
			
			for(int i =1; i< size-1;i++) {
				sum += (Math.min(lMax[i], rMax[i])-arr[i]);
			}
			
			System.out.println( "\n Total Water == " + sum);
		}
	}

}
