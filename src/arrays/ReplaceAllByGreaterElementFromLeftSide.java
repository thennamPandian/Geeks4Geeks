package arrays;

import java.util.Scanner;

public class ReplaceAllByGreaterElementFromLeftSide {
	
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
			
			
			
			int maxOfRight = arr[0];
			arr[0] = -1;
			
			for(int i = 1; i <= size -1; i++) {
			   int temp = arr[i];
			   if(arr[i-1] > maxOfRight && maxOfRight >= 0) {
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
