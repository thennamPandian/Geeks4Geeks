package linkedList;

import static linkedList.util.ListUtil.reverse;
import linkedList.util.ListUtil;
import linkedList.util.Node;

/*
 * https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 */

public class Palindrom {

	public static void main(String[] args) {
		// Palindrom list - odd length
		int[] values = { 1, 2, 3, 2, 1 };
		Node headA = ListUtil.createList(values);
		ListUtil.displayList(headA);
		//System.out.println("\n is Palindrom : " + isPalindrome(headA));

		// Palindrom list - even length
		values = new int[] { 1, 2, 3, 3, 2, 1 };
		headA = ListUtil.createList(values);
		ListUtil.displayList(headA);
		System.out.println("\n is Palindrom : " + isPalindrome(headA));
	}

	private static boolean isPalindrome(Node head) {

		if (head == null || head.getNext() == null) {
			return false;
		}

		int n = 0;
		Node cur = head;
		while (cur != null) {
			n++;
			cur = cur.getNext();
		}

		int mid = n / 2;
		boolean isOdd = (n % 2 == 1) ? true : false;

		//mid = isOdd ? mid - 1 : mid;
		cur = head;

		int c = 1;

		while (c != mid) {
			cur = cur.getNext();
			c++;
		}

		Node _2ndHalfHead = isOdd ? cur.getNext().getNext() : cur.getNext();

		return isPalindromeRe(head, head, _2ndHalfHead);
	}

	private static boolean isPalindromeRe(Node head, Node cur, Node start) {
		if (start == null)
			return false;

		if (start.getNext() == null) {
			return start.getData() == head.getData();
		} else {
			if (isPalindromeRe(head, cur.getNext(),start.getNext())) {				
				return cur.getData() == start.getData();
			}
		}

		return false;
	}
}
