package linkedList;

import java.util.Scanner;

import linkedList.util.ListUtil;
import linkedList.util.Node;

/*
 * https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 * 
 * Verified for circular linked list and with single node pointing to it-self.
 */
public class CycleDetection {

	private static Node f, s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(System.in);) {
			System.out.println("\n Enter the elements of linked list : ");
			String[] values = scanner.nextLine().trim().split(" ");
			Node headA = ListUtil.createList(values);

			System.out.println(" enter the merging position ");
			int mp = scanner.nextInt();

			Node tempA = headA;
			Node last = headA;

			while (last.getNext() != null) {
				last = last.getNext();
			}

			if (mp > 0) {
				while (mp > 1) {
					tempA = tempA.getNext();
					mp--;
				}

				last.setNext(tempA);
			}

			f = headA;
			s = f;
			System.out.println(" isCycle found :  " + findCycle());
			f = headA;
			//Node lastNode = s;
			System.out.println(" element :  " + findTheCycleElemet(headA));
			System.out.println(" size of the loop :  " + sizeOfLoop());
			removeLoop();
			ListUtil.displayList(headA);
		}

	}

	
	private static void removeLoop() {
		s.setNext(null);		
	}
	
	
	private static int findTheCycleElemet(Node head) {
		if (head == s) {
			return s.getData();
		}

		while (f.getNext() != s.getNext()) {
			f = f.getNext();
			s = s.getNext();
		}

		return f.getNext().getData();
	}

	private static int sizeOfLoop() {
		int size = 1;
		f = s.getNext();
		while (f != s) {
			f = f.getNext();
			size++;
		}
		return size;
	}

	private static boolean findCycle() {
		boolean isCyclic = false;

		while ((f != null && s != null) && f.getNext() != null) {
			f = f.getNext().getNext();
			s = s.getNext();

			if (f.getNext() == s.getNext()) {
				isCyclic = true;
				break;
			}
		}
		return isCyclic;
	}

}
