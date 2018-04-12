package array.rearrangement;

import java.util.Scanner;

/*
 *  Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array.
 *  Since there is no element next to the last element, replace it with -1. For example, if the array is {16, 17, 4, 3, 5, 2}, 
 *  then it should be modified to {17, 5, 5, 5, 2, -1}.
 */
public class ReplaceAllByGreaterElementFromRightSide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Scanner scanner = new Scanner(System.in);) {
			
			System.out.println(" Enter the size of the array : ");
			int size = Integer.parseInt(scanner.nextLine().trim());
			int[] arr = new int[size];
			
			System.out.println("\n Enter the elements :  ");
			String[] values = scanner.nextLine().split(" ");
			
			int x =0;
			for(String value : values) {
				arr[x++] = Integer.parseInt(value);
			}
			
			
			
			int maxOfRight = arr[size-1];
			arr[size-1] = -1;
			
			for(int i = size-2; i >= 0; i--) {
			   int temp = arr[i];
			   if(arr[i+1] > maxOfRight) {
				   maxOfRight = arr[i-1];				   
			   }	   
			   
			   arr[i] = maxOfRight;
			   if(temp > maxOfRight){
				   maxOfRight = temp;
			   }
				   
			}
			
			for(int ai : arr){
				System.out.print(ai +" ");
			}
		}
	}

}
