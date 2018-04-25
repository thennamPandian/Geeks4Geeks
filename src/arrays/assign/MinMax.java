package arrays.assign;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the
 * respective minimum and maximum values as a single line of two space-separated
 * long integers.
 * 
 * Each integer is in the inclusive range .
 * 
 * i/p : 1 2 3 4 5 
 * 
 * o/p : 10 14
 * 
 * URL : https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class MinMax {

	/*
	 * Complete the miniMaxSum function below.
	 */
	static void miniMaxSum(int[] arr) {
		long total = 0;		
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		
		long min = total;
		long max = 0;		
		
		for(int i = 0; i < arr.length; i++) {
			
			long sum = total-arr[i];
			
			if(max < sum) {
				max = sum;
			}
			
			if(min > sum ) {
				min = sum;
			}
		}
		
        System.out.println(min + " " + max);
	}


	public static void main(String[] args) {
		int[] arr = new int[5];

		try (Scanner scan = new Scanner(System.in);) {
			System.out.println("\n Enter the elements of array : ");
			String[] arrItems = scan.nextLine().split(" ");

			for (int arrItr = 0; arrItr < 5; arrItr++) {
				int arrItem = Integer.parseInt(arrItems[arrItr].trim());
				arr[arrItr] = arrItem;
			}

			miniMaxSum(arr);
		}
	}
}
