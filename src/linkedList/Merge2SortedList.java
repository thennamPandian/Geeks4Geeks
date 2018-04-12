package linkedList;

import linkedList.util.ListUtil;
import linkedList.util.Node;

/*
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 */

public class Merge2SortedList {

	public static void main(String[] args) {
		//Non-equal length
		int[] values = {1,5,6,7,9,11,12,13};
		Node headA = ListUtil.createList(values);
		
		values = new int[] {2,3,4,8,10};
		Node headB = ListUtil.createList(values);
		
		System.out.println("\n List1 ==>");
		ListUtil.displayList(headA);
		System.out.println("\n List2 ==>");
		ListUtil.displayList(headB);
		System.out.println("\n Merged List ==>");
		ListUtil.displayList(sortedMerged(headA, headB));
		
		//Both null
		System.out.println("\n #################### ");
		headA = null;
		headB = null;
		System.out.println("\n List1 ==>");
		ListUtil.displayList(headA);
		System.out.println("\n List2 ==>");
		ListUtil.displayList(headB);
		System.out.println("\n Merged List ==>");
		ListUtil.displayList(sortedMerged(headA, headB));
		
		//A null
		System.out.println("\n #################### ");
		headA = null;
		values = new int[] {2,3,4,8,10};
		headB = ListUtil.createList(values);
		System.out.println("\n List1 ==>");
		ListUtil.displayList(headA);
		System.out.println("\n List2 ==>");
		ListUtil.displayList(headB);
		System.out.println("\n Merged List ==>");
		ListUtil.displayList(sortedMerged(headA, headB));
		
		//B null
		System.out.println("\n #################### ");
		values = new int[] {2,3,4,8,10};
		headA = ListUtil.createList(values);
		headB = null;
		System.out.println("\n List1 ==>");
		ListUtil.displayList(headA);
		System.out.println("\n List2 ==>");
		ListUtil.displayList(headB);
		System.out.println("\n Merged List ==>");
		ListUtil.displayList(sortedMerged(headA, headB));
		
		//equal length
		System.out.println("\n #################### ");
		values = new int[] {2,3,4,8,10};
		headA = ListUtil.createList(values);
		values = new int[] {12,13,14,18,110};
		headB = ListUtil.createList(values);
		System.out.println("\n List1 ==>");
		ListUtil.displayList(headA);
		System.out.println("\n List2 ==>");
		ListUtil.displayList(headB);
		System.out.println("\n Merged List ==>");
		ListUtil.displayList(sortedMerged(headA, headB));
		
		//duplicate elements
		System.out.println("\n #################### ");
		values = new int[] {2,3,4,8,10};
		headA = ListUtil.createList(values);
		values = new int[] {2,3,4,8,10};
		headB = ListUtil.createList(values);
		System.out.println("\n List1 ==>");
		ListUtil.displayList(headA);
		System.out.println("\n List2 ==>");
		ListUtil.displayList(headB);
		System.out.println("\n Merged List ==>");
		ListUtil.displayList(sortedMerged(headA, headB));
		
	}

	private static Node sortedMerged(Node headA, Node headB) {

		if (headA == null && headB == null)
			return null;

		if (headA == null)
			return headB;

		if (headB == null)
			return headA;

		Node newHead = null;
		Node curA = headA;
		Node curB = headB;
		Node cur = null;
		Node temp = null;

		while (curA != null && curB != null) {
			if (curA.getData() <= curB.getData()) {
				temp = curA;
				curA = curA.getNext();
			} else {
				temp = curB;
				curB = curB.getNext();
			}

			if (cur != null) {
				cur.setNext(temp);
			}
			cur = temp;
			
			if(newHead == null ){
				newHead = cur;
			}
		}
		
		if(curA != null ){
			cur.setNext(curA);
		} else {
			cur.setNext(curB);
		}

		return newHead;
	}
}
