package tree.avl;

import tree.util.AVLTree;
import tree.util.TreeFactory;

public class FindHeightOfAVLTree {

	public static void main(String[] args) {

		// null AVL tree
		System.out.println("\n heightOfAVLTree ==> "+ heightOfAVLTree(null));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(null,1));

		// single element AVL tree
		String[] values = new String[] { "1" };
		AVLTree root = TreeFactory.createAVLTree(values);
		System.out.println("\n heightOfAVLTree ==> "+ heightOfAVLTree(root));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,1));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,11));

		// Mini AVL tree
		values = new String[] { "2", "1", "3" };
		root = TreeFactory.createAVLTree(values);
		System.out.println("\n heightOfAVLTree ==> "+ heightOfAVLTree(root));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,2));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,3));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,4));

		// level 2, B tree.
		values = new String[] { "4","2","6","1","3","5","7"};
		root = TreeFactory.createAVLTree(values);
		System.out.println("\n heightOfAVLTree ==> "+ heightOfAVLTree(root));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,1));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,2));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,3));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,4));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,5));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,6));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,7));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,13));
		
		

		// non-height balanced, B tree.
		values = new String[] { "4","2","6","1","3","&","&"};
		root = TreeFactory.createAVLTree(values);
		System.out.println("\n heightOfAVLTree ==> "+ heightOfAVLTree(root));		
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,1));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,2));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,3));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,4));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,5));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,6));
		System.out.println(" heightOfNodeInAVLTree ==> "+ heightOfNodeInAVLTree(root,7));
		

	}

	public static int heightOfAVLTree(AVLTree root) {
		if (root == null)
			return -1;
		return root.getHeight();
	}

	public static int heightOfNodeInAVLTree(AVLTree root, int data) {
		if (root == null)
			return -1;
		
		if (root.getData() == data)
			return root.getHeight();
		
		if(root.getData() >= data ) {
			return heightOfNodeInAVLTree(root.getLeft(), data);
		} else {
			return heightOfNodeInAVLTree(root.getRight(), data);
		}

	}

}
