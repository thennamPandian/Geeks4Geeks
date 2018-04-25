package arrays;

import java.util.Scanner;

/*
 * Given an array of n integers and a number, d perform  left rotations on the array. 
 * Then print the updated array as a single line of space-separated integers.
 * 
 * I/P : 1 2 3 4 5 . d =4
 * O/P : 5 1 2 3 4
 * 
 */
public class LeftRotation {

	public static void main(String[] args) {
				
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Please enter the size of the array and rotation elements : ");
		String[] values = scanner.nextLine().split(" ");
		
		int size = Integer.parseInt(values[0].trim());
		int rotation = Integer.parseInt(values[1].trim());
		int[] a = new int[size];
		
		System.out.println("\n Input the array elements \n");
		values = scanner.nextLine().split(" ");
		int x = 0;
		for(String value:values) {
			a[x++] = Integer.parseInt(value);
		}
		
		System.out.println("\n Before rotation : ");
		for(int ai : a){
			System.out.print(ai +" ");
		}
		
		for(int i = 0, j=rotation-1; j > i ; i++,j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		for(int i = rotation, j=size-1; j > i ; i++,j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		for(int i = 0, j = size-1; j > i; i++,j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		System.out.println("\n After rotation : ");
		for(int ai : a){
			System.out.print(ai +" ");
		}
		
	}
}
