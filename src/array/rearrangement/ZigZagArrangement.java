package array.rearrangement;

import java.util.Scanner;

/*
 * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. 
 * The converted array should be in form a < b > c < d > e < f.
 */
public class ZigZagArrangement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\n Enter the number of inputs : ");
        try(Scanner scanner = new Scanner(System.in);){
        	int size = Integer.parseInt(scanner.nextLine().trim());
        	int[] arr = new int[size];
        	System.out.println("\n Enter the elements of the array : ");
        	String[] values = scanner.nextLine().split(" ");
        	
			int x =0;
			for(String value : values) {
				arr[x++] = Integer.parseInt(value);
			}
			
			for(int i = 0, j = 1; j< size;i++,j++) {
				
				if(i % 2 == 0 ) {
					if(arr[i] > arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					} 
				} else {
					if(arr[i] < arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					} 
				}
			}
			
			for(int ai : arr){
				System.out.print(ai +" ");
			}
        }
	}

}
