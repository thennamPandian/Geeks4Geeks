package linkedList;

import static linkedList.util.ListUtil.reverse;
import linkedList.util.ListUtil;
import linkedList.util.Node;

/**
 * https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
 * 
 * @author Thennam Karthi Lachu
 *
 */
public class ReverseAList {

	public static void main(String[] args) {
		// more elements
		int[] values = { 1, 2, 3, 4, 5 };
		Node headA = ListUtil.createList(values);
		ListUtil.displayList(headA);
		System.out.println("\n After reverse");
		ListUtil.displayList(reverse(headA));
		
		// 2 - elements
	    System.out.println("\n ######### ");
		values = new int[]{1,2};
		headA = ListUtil.createList(values);
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(reverse(headA));
	    
	    // 1 - element
	    System.out.println("\n ######### ");
		values = new int[]{1};
		headA = ListUtil.createList(values);
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(reverse(headA));
	    
	    // null
	    System.out.println("\n ######### ");
		headA = null;
	    ListUtil.displayList(headA);
	    System.out.println("\n After rearrangement");
	    ListUtil.displayList(reverse(headA));
	}

	
}
