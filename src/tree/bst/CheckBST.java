package tree.bst;

import tree.util.Tree;
import tree.util.TreeUtil;

public class CheckBST {

	private static int temp = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// Simple BST
		String[] values = new String[] { "4", "2", "6" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));

		// Null
		temp = Integer.MIN_VALUE;
		System.out.println(checkBST(null));

		// Single Element tree
		temp = Integer.MIN_VALUE;
		values = new String[] { "2" };
		root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));

		// Multi level BST
		temp = Integer.MIN_VALUE;
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));

		// Multi level non-BST
		temp = Integer.MIN_VALUE;
		values = new String[] { "4", "2", "16", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));
		
		// root node tree which has only right sub tree
		temp = Integer.MIN_VALUE;
		values = new String[] { "4", "&", "6", "&", "&", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));
				
		// node tree which has only left sub tree
		temp = Integer.MIN_VALUE;
		values = new String[] { "4", "2", "&", "1", "3", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));
		
		// left skews
		temp = Integer.MIN_VALUE;
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));
		
		// left skews
		temp = Integer.MIN_VALUE;
		values = new String[] { "50", "30", "&", "120", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));

		// Right skews
		temp = Integer.MIN_VALUE;
		values = new String[] { "50", "&", "170", "&", "&", "&", "80" };
		root = TreeUtil.createTree(values);
		System.out.println(checkBST(root));		

	}

	public static boolean checkBST(Tree root) {

		if (root == null)
			return true;

		if (temp == Integer.MIN_VALUE && root.getLeft() == null && root.getRight() == null ){
			temp = root.getData();
			return true;
		}	
		
		if (checkBST(root.getLeft())) {				
			if (temp <= root.getData()) {
				temp = root.getData();
				return checkBST(root.getRight());
			}
		}

		return false;
	}
}
