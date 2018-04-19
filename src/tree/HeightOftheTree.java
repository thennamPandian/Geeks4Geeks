package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class HeightOftheTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = new String[] { "1", "2", "3", "4", "5", "6", "7",
				"&", "&", "&", "&", "&", "&", "&", "9" };
		Tree root = TreeUtil.createTree(values);
		System.out.println("height of tree : " + height(root));

		values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		root = TreeUtil.createTree(values);
		System.out.println("\n");
		System.out.println("height of tree : " + height(root));
		;

		values = new String[] { "1" };
		root = TreeUtil.createTree(values);
		System.out.println("\n");
		System.out.println("height of tree : " + height(root));
		;

		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		System.out.println("height of tree : " + height(root));
		;
		System.out.println("\n");

		System.out.println("\n");
		System.out.println("height of tree : " + height(null));

		// left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println("height of left skew tree : " + height(root));
	}

	public static int height(Tree root) {

		if (root == null)
			return 0;

		if (root.getLeft() == null && root.getRight() == null)
			return 0;

		int lh = height(root.getLeft());
		int rh = height(root.getRight());

		return 1 + Math.max(lh, rh);
	}

}
