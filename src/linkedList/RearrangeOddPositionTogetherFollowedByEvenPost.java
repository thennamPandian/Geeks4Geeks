package linkedList;

import linkedList.util.ListUtil;
import linkedList.util.Node;

/*
 * https://practice.geeksforgeeks.org/problems/rearrange-a-linked-list/1
 */
public class RearrangeOddPositionTogetherFollowedByEvenPost {

	public static void main(String[] args) {
		// odd length
		int[] values = {1,2,3,4,5};
		Node headA = ListUtil.createList(values);
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(rearrange(headA));
	    
	    // Even lenth
	    System.out.println("\n ######### ");
		values = new int[]{1,2,3,4};
		headA = ListUtil.createList(values);
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(rearrange(headA));
	    
	    // 3 elements
	    System.out.println("\n ######### ");
		values = new int[]{1,2,3};
		headA = ListUtil.createList(values);
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(rearrange(headA));
	    
	    
	    // 2 elements
	    System.out.println("\n ######### ");
		values = new int[]{1,2};
		headA = ListUtil.createList(values);
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(rearrange(headA));
	    
	    // Single element
	    System.out.println("\n ######### ");
		values = new int[]{1};
		headA = ListUtil.createList(values);
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(rearrange(headA));
	    
	    // null
	    System.out.println("\n ######### ");
		headA = null;
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(rearrange(headA));
	}
	
	private static Node rearrange(Node head)
    {
		if(head == null) return head;

		Node odd = head;
		Node even = head.getNext();
		Node evenHead = even;
		
		while(odd != null && even != null && odd.getNext() != null && even.getNext() != null) {
			odd.setNext(even.getNext());
			odd = odd.getNext();
			even.setNext(odd.getNext());
			even = even.getNext();
		}
		
		odd.setNext(evenHead);
		
		
        return head;
    }

}
