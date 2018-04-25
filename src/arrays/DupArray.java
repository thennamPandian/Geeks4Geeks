package arrays;

import java.util.Scanner;

/**
 * 
 * 
Given an array of n+1 elements in range 0 to n-1 , you have to wheather duplicates or not.
assup : single dup

     0 1 2 3 4
i/p: 3 2 1 0 3
o/p: yes

 *
 */
public class DupArray {

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
			
			System.out.println("\n Given array :  ");
			for(int ai : arr){
				System.out.print(ai +" ");
			}
			
			int dupElement = -1;
			for(int i = 0; i < size; i++) {
				
				int value = arr[Math.abs(arr[i]) % size ];
				if(value >= 0 ){
					if(value != 0) {
						arr[Math.abs(arr[i]) % size ] *= -1;
					}else {
						arr[Math.abs(arr[i])] = -size;
					}
				}else {
					dupElement =Math.abs(arr[i]);
					break;
				}				
			}
			
			System.out.println("\n Dup Element :" + dupElement);
		}

	}

}
