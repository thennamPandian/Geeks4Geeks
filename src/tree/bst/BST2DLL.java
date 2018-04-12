package tree.bst;

import linkedList.util.DoublyLL;
import linkedList.util.ListUtil;
import tree.util.Tree;
import tree.util.TreeUtil;

public class BST2DLL {

	private static DoublyLL head = null;;
	public static void main(String[] args) {
		// Min Binary tree
		String[] values = new String[] { "4", "2", "6" };
		Tree root = TreeUtil.createTree(values);
		convertBST2DLL(root, null);
		ListUtil.displayList(head);
		
		// Null
		System.out.println();
		head = null;
		convertBST2DLL(null, null);
		ListUtil.displayList(head);
		
		// Single element 
		System.out.println();
		head = null;
		values = new String[] { "4" };
		root = TreeUtil.createTree(values);
		convertBST2DLL(root, null);
		ListUtil.displayList(head);
		
		// 2nd level tree 
		System.out.println();
		head = null;
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		convertBST2DLL(root, null);
		ListUtil.displayList(head);
		
				
		// left has more height
		System.out.println();
		head = null;
		values = new String[] { "4", "2", "6", "1", "3", "&", "&" };
		root = TreeUtil.createTree(values);
		convertBST2DLL(root, null);
		ListUtil.displayList(head);
		
		// left skews
		System.out.println();
		head = null;;
		values = new String[] { "150", "130", "&", "120", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		convertBST2DLL(root, null);
		ListUtil.displayList(head);

		// Right skews
		System.out.println();
		head = null;
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root = TreeUtil.createTree(values);
		convertBST2DLL(root, null);
		ListUtil.displayList(head);	
	}

	public static DoublyLL convertBST2DLL(Tree root, DoublyLL prev) {

		if (root == null)
			return null;

		DoublyLL lTree =  convertBST2DLL(root.getLeft(), prev) ;
		if(lTree != null ) {
			if(head == null ){
				head = lTree;
			}
			prev = lTree;
		}

		DoublyLL temp = new DoublyLL();
		temp.setData(root.getData());
		temp.setPrev(prev);
		temp.setNext(null);

		if (prev != null) {
			prev.setNext(temp);
		}

		if(head == null ){
			head = temp;
		}
		prev = temp;

	
		DoublyLL rTree =  convertBST2DLL(root.getRight(), prev) ;
		if(rTree != null ) {
			prev = rTree;
		}

		return prev;
	}

}
