package linkedList;

import java.util.Scanner;

import linkedList.util.ListUtil;
import linkedList.util.Node;

/**
 * 
 * Find the nth element from last
 * https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
 *
 */
public class FindNFromLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println("\n Enter the elements of linked list : ");
		try (Scanner scanner = new Scanner(System.in);) {

			String[] values = scanner.nextLine().split(" ");
			Node head = ListUtil.createList(values);

			// System.out.println("Enter the k : ");
			int k = scanner.nextInt();

			Node p = head;
			Node q = head;

			if (k <= 0) {
				// System.out.println(" Invalid value ");
				return;
			}

			while (k > 0 && q != null) {
				q = q.getNext();
				k--;
			}

			if (q == null) {
				if (k != 0) {
					System.out.println(-1);
					return;
				} else {
					System.out.println(p.getData());
				}
			}

			while (q != null) {
				p = p.getNext();
				q = q.getNext();
			}

			System.out.println(p.getData());

		}
	}

}
