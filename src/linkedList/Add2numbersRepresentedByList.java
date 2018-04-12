package linkedList;

import linkedList.util.ListUtil;
import linkedList.util.Node;

/*
 * https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 */

public class Add2numbersRepresentedByList {

	public static void main(String[] args) {
		// equal length with Carry in middle and last
	int[] values = {5,6,3};
		Node headA = ListUtil.createList(values);
		values = new int[]{8,4,2};
		Node headB = ListUtil.createList(values);
		/*	System.out.println("\n Given IP : ");
		ListUtil.displayList(headA);
		ListUtil.displayList(headB);
		System.out.println("\n sum ");
		ListUtil.displayList(addTwoLists(headA, headB));
		
		// non-equal length with Carry in middle 
		values = new int[]{5,6,3};
		headA = ListUtil.createList(values);
		values = new int[]{9,9};
		headB = ListUtil.createList(values);
		System.out.println("\n Given IP : ");
		ListUtil.displayList(headA);
		ListUtil.displayList(headB);
		System.out.println("\n sum ");
		ListUtil.displayList(addTwoLists(headA, headB));
		
		// non-equal length with Carry in middle and last
		values = new int[]{5,6,3};
		headA = ListUtil.createList(values);
		values = new int[]{9,9,9};
		headB = ListUtil.createList(values);
		System.out.println("\n Given IP : ");
		ListUtil.displayList(headA);
		ListUtil.displayList(headB);
		System.out.println("\n sum ");
		ListUtil.displayList(addTwoLists(headA, headB));
		
		// A is null
		headA = null;
		values = new int[]{9,9,9};
		headB = ListUtil.createList(values);
		System.out.println("\n Given IP : ");
		ListUtil.displayList(headA);
		ListUtil.displayList(headB);
		System.out.println("\n sum ");
		ListUtil.displayList(addTwoLists(headA, headB));
		
		// B is null
		values = new int[]{5,6,3};
		headA = ListUtil.createList(values);		
		headB = null;
		System.out.println("\n Given IP : ");
		ListUtil.displayList(headA);
		ListUtil.displayList(headB);
		System.out.println("\n sum ");
		ListUtil.displayList(addTwoLists(headA, headB));
		
		// Both are null
		headA = null;		
		headB = null;
		System.out.println("\n Given IP : ");
		ListUtil.displayList(headA);
		ListUtil.displayList(headB);
		System.out.println("\n sum ");
		ListUtil.displayList(addTwoLists(headA, headB));*/
		
		values = new int[] {7,7,5,3,5,6,2,9,1,2,7,0,9,3,6,0,6,2,6,1,8,7,9,2,0,2,3,7,5,9,2,2,8,9,7,3,6,1,2,9,3,1,9,4,7,8,4,5,0,3,6,1,0,6,3,2,0,6,1,5,5,4,7,6,5,6,9,3,7,4,5,2,5,4,7,4,4,3,0,7,8,6,8,8};
		headA = ListUtil.createList(values);
		values = new int[] {4,1,4,9,2,0,6,8,9,2,6,6,4,9,5,0,4,8,7,1,7,2,7,2,2,6,1,0,6,1,5,9,4,9,0,9,1,7,7,1,1,5,9,7,7,6,7,3,6,5,6,3,9,4,8,1,2,9,3,9,0,8,8,5,0,9,6,3,8,5,6,1,1,5,9,8,4,8,1,0,3,0,4,4,4};
		headB = ListUtil.createList(values);
		ListUtil.displayList(addTwoLists(headA, headB));
	}

	private static Node addTwoLists(Node first, Node second) {
		if (first == null && second == null)
			return null;

		if (first == null)
			return second;

		if (second == null)
			return first;

		Node newA = ListUtil.reverse(first);
		Node newB = ListUtil.reverse(second);
		Node newHead = null;
		Node temp = null;

		int value = 0;
		int sum = 0;
		int c = 0;

		while (newA != null || newB != null) {

			int valueA = newA == null ? 0 : newA.getData();
			int valueB = newB == null ? 0 : newB.getData();
			sum = c + valueA + valueB;

			value = sum % 10;
			c = sum / 10;

			temp = new Node();
			temp.setData(value);
			temp.setNext(newHead);
			newHead = temp;

			
			newA = newA != null ? newA.getNext() : null;
			newB = newB != null ? newB.getNext(): null;
		}

		if (c != 0) {
			temp = new Node();
			temp.setData(c);
			temp.setNext(newHead);
			newHead = temp;
		}

		return newHead;
	}
}
