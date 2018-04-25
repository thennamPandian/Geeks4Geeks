package heap.assignment;

import java.util.Scanner;

import heap.Heap;
import heap.HeapUtil;

/**
 * https://www.hackerrank.com/challenges/qheap1/problem
 */
public class QHeap1 {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in);) {
			int numberOfQ = Integer.parseInt(scan.nextLine().trim());
			
			Heap minHeap = null;
			for(int i =1 ; i <= numberOfQ; i++) {
				String[] arrItems = scan.nextLine().split(" ");
				switch (arrItems[0]) {
				case "1":
					minHeap = HeapUtil.insertIntoMinHeap(minHeap, Integer.valueOf(arrItems[1]));
					break;

				case "2":
					HeapUtil.deleteElement(minHeap, Integer.valueOf(arrItems[1]));
					break;
					
				case "3":
					System.out.println(minHeap.getElements()[HeapUtil.min(minHeap)]);
					break;	
				default:
					break;
				}
			}

		}
	}
}
