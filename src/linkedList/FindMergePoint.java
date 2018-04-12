package linkedList;

import java.util.Scanner;

import linkedList.util.ListUtil;
import linkedList.util.Node;

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 */
public class FindMergePoint {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {

			System.out.println("\n Enter the elements of linked list : ");
			String[] values = scanner.nextLine().trim().split(" ");
			Node headA = ListUtil.createList(values);

			System.out.println("\n Enter the elements of linked list : ");
			values = scanner.nextLine().trim().split(" ");
			Node headB = ListUtil.createList(values);

			Node tempB = headB;
			if (tempB != null) {
				while (tempB.getNext() != null) {
					tempB = tempB.getNext();
				}
			}

			Node tempA = headA;

			System.out.println(" enter the merging position ");
			int mp = scanner.nextInt();

			if (mp > 0) {
				while (mp > 1) {
					tempA = tempA.getNext();
					mp--;
				}

				tempB.setNext(tempA);
			}

			ListUtil.displayList(headA);
			ListUtil.displayList(headB);
			System.out.println(" \n merging point ==>  "
					+ findMergeNode(headA, headB));
		}
	}

	private static int findMergeNode(Node headA, Node headB) {
		// Complete this function
		// Do not write the main method.

		if (headA == null || headB == null)
			return Integer.MIN_VALUE;

		Node p = headA;
		int lengthA = 0;
		while (p != null) {
			p = p.getNext();
			lengthA++;
		}

		Node q = headB;
		int lengthB = 0;
		while (q != null) {
			q = q.getNext();
			lengthB++;
		}

		int diff = 0;
		if (lengthA <= lengthB) {
			diff = lengthB - lengthA;
			p = headB;
			q = headA;
		} else {
			diff = lengthA - lengthB;
			p = headA;
			q = headB;
		}

		while (diff > 0) {
			p = p.getNext();
			diff--;
		}

		while ((p != null || q != null) && p.getNext() != q.getNext()) {
			p = p.getNext();
			q = q.getNext();
		}

		if (p != null && p.getNext() != null)
			return p.getNext().getData();
		else
			return Integer.MIN_VALUE;
	}

}
