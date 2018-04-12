package linkedList;

import linkedList.util.ListUtil;
import linkedList.util.Node;

/*
 * https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
 */
public class FindTheMiddleElment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] values = {1,2,3,4,5};
		Node headA = ListUtil.createList(values);

		System.out.println(" List ==> " );
		ListUtil.displayList(headA);
		System.out.println(" Middle Element : " + getMiddle(headA));
		
		
		values = new int[] {11,12,13,14};
		headA = ListUtil.createList(values);

		System.out.println(" List ==> ");
		ListUtil.displayList(headA);
		System.out.println(" Middle Element : " + getMiddle(headA));
		
		System.out.println(" List ==> ");
		ListUtil.displayList((Node)null);
		System.out.println(" Middle Element : " + getMiddle(null));
		
		values = new int[] {11,12};
		headA = ListUtil.createList(values);

		System.out.println(" List ==> ");
		ListUtil.displayList(headA);
		System.out.println(" Middle Element : " + getMiddle(headA));
		
		values = new int[] {21};
		headA = ListUtil.createList(values);

		System.out.println(" List ==> ");
		ListUtil.displayList(headA);
		System.out.println(" Middle Element : " + getMiddle(headA));

	}

	private static int getMiddle(Node head) {
	
		if (head != null) {

			Node p = head;
			Node q = head;

			while (q != null && q.getNext() != null) {
				p = p.getNext();
				q = q.getNext().getNext();
			}

			return p.getData();
		}

		return -1;
	}

}
