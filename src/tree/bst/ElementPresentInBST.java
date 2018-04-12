package tree.bst;

import tree.util.Tree;
import tree.util.TreeUtil;

public class ElementPresentInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Simple BST
		String[] values = new String[] { "4", "2", "6" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(isPresent(root, 2));

		// Null
		System.out.println(isPresent(null, 2));

		// Single Element tree
		values = new String[] { "2" };
		root = TreeUtil.createTree(values);
		System.out.println(isPresent(root, 2));

		// Multi level BST
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(isPresent(root, 7));
		System.out.println(isPresent(root, 17));

		// Multi level BST
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(isPresent(root, 7));

		// left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(isPresent(root, 20));

		// Right skews
		values = new String[] { "50", "&", "170", "&", "&", "&", "80" };
		root = TreeUtil.createTree(values);
		System.out.println(isPresent(root, 170));
	}

	public static boolean isPresent(Tree root, int data) {

		if (root == null)
			return false;

		if (root.getData() == data)
			return true;

		if (data < root.getData())
			return isPresent(root.getLeft(), data);
		else
			return isPresent(root.getRight(), data);
	}
}
