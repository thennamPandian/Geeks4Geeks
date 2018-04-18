package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class CheckTheNodesAreSibiling {

	public static void main(String[] args) {

		// Null tree
		System.out.println(isItSibling(null, 2, 3));

		// single element B tree
		String[] values = new String[] { "1" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(isItSibling(root, 2, 3));

		// Mini B tree, siblings
		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		System.out.println(isItSibling(root, 2, 3));

		// Mini B tree, non siblings
		System.out.println(isItSibling(root, 2, 4));

		// level 2, B tree. siblings
		values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(isItSibling(root, 4, 5));

		// changing the order of nodes
		System.out.println(isItSibling(root, 5, 4));

		// non siblings
		System.out.println(isItSibling(root, 5, 7));
		

		// left skews
		System.out.println("\n");
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(isItSibling(root, 50, 30));

		// Right skews
		System.out.println("\n");
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root = TreeUtil.createTree(values);
		System.out.println(isItSibling(root, 170, 180));

	}

	public static boolean isItSibling(Tree root, int a, int b) {

		if (root == null)
			return false;

		if (root.getLeft() == null && root.getRight() == null)
			return false;

		if (root.getLeft() != null && root.getRight() != null) {
			if (root.getLeft().getData() == a && root.getRight().getData() == b)
				return true;
			if (root.getLeft().getData() == b && root.getRight().getData() == a)
				return true;
		}

		boolean isSibling = isItSibling(root.getLeft(), a, b);
		if (!isSibling) {
			isSibling = isItSibling(root.getRight(), a, b);
		}

		return isSibling;
	}

}
