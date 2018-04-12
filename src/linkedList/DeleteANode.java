package linkedList;

import linkedList.util.ListUtil;
import linkedList.util.Node;
import static linkedList.util.ListUtil.*;

/*
 * Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 */
public class DeleteANode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] values = { 1, 2, 3, 4, 5, 6, 7 };
		Node headA = ListUtil.createList(values);
		System.out.println(" List : ");
		ListUtil.displayList(headA);
		int data = 3;
		Node node = findNode(headA, data);
		delete(node);
		ListUtil.displayList(headA);

		System.out.println("\n\n ############## ");
		headA = null;
		ListUtil.displayList(headA);
		delete(node);
		ListUtil.displayList(headA);

		System.out.println("\n\n ############## ");
		values = new int[] { 1,2 };
		headA = ListUtil.createList(values);
		System.out.println(" List : ");
		ListUtil.displayList(headA);
		data = 1;
		node = findNode(headA, data);
		delete(node);
		ListUtil.displayList(headA);
	}

	private static void delete(Node p) {
		if (p != null) {
			while (p.getNext() != null && p.getNext().getNext() != null) {
				p.setData(p.getNext().getData());
				p = p.getNext();
			}

			if (p.getNext() != null) {
				p.setData(p.getNext().getData());
			}
			p.setNext(null);
		}
	}
}
