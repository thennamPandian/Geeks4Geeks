package linkedList;

import linkedList.util.RandomPointerNode;

/*
 * https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
 */

public class CloneNodeWithRandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private RandomPointerNode clone(RandomPointerNode head) {

		if (head == null)
			return head;

		RandomPointerNode cur = head;
		RandomPointerNode next = null;
		RandomPointerNode curClone = null;
		while (cur != null) {
			next = cur.getNext();
			curClone = cur.clone();
			cur.setNext(curClone);
			curClone.setNext(next);
			cur = next;
		}

		RandomPointerNode org = head;
		RandomPointerNode clone = head.getNext();
		RandomPointerNode cloneHead = clone;

		while (org != null) {

			RandomPointerNode cloneRandom = org.getRandom() != null ? org
					.getRandom().getNext() : null;
			clone.setRandom(cloneRandom);
			org = (clone != null) ? clone.getNext() : null;
			clone = (org != null) ? org.getNext() : null;

		}

		org = head;
		clone = head.getNext();

		while (org != null) {
			org.setNext(clone.getNext());
			RandomPointerNode cloneNext = (clone.getNext() != null) ? clone
					.getNext().getNext() : null;
			clone.setNext(cloneNext);

			org = org.getNext();
			clone = clone.getNext();

		}

		return cloneHead;
	}
}
