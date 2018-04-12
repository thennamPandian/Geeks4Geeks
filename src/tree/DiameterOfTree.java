package tree;

import tree.traversal.LevelOrderTraversal;
import tree.util.Tree;
import tree.util.TreeUtil;

public class DiameterOfTree {

	private static int dia = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] values = new String[] { "5", "6", "7", "9", "&", "&", "8",
				"10", "&", "&", "&" };

		Tree root = TreeUtil.createTree(values);
		height(root);
		System.out.println(dia);

		dia = 0;
		values = new String[] { "1", "2", "3", "4", "5", "11", "&", "6", "&",
				"&", "&", "&", "&", "&", "&", "7", "&", "&", "&", "&", "&",
				"&", "&", "&", "&", "&", "&", "&", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		height(root);
		System.out.println(dia);

		dia = 0;
		values = new String[] { "1", "2", "&", "3", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		height(root);
		System.out.println(dia);

		dia = 0;
		height(null);
		System.out.println(dia);

		dia = 0;
		values = new String[] { "1" };
		root = TreeUtil.createTree(values);
		height(root);
		System.out.println(dia);

		dia = 0;
		values = new String[] { "1", "2", "9", "3", "5", "&", "&","4", "&", "&", "6",
				"&", "&", "&", "&", "15", "&", "&", "&", "&", "&", "&", "7",
				"&", "&", "&", "&", "&", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		height(root);
		System.out.println(dia);

		dia = 0;
		values = new String[] { "1", "&", "3", "&", "&", "4", "5", "&", "&",
				"&", "&", "6", "&", "&", "7", "&", "&", "&", "&", "&", "&",
				"&", "&", "9", "&", "&", "&", "&", "&", "&", "10" };
		root = TreeUtil.createTree(values);
		height(root);
		System.out.println(dia);

	}

	public static int height(Tree root) {

		if (root == null)
			return 0;

		if (root.getLeft() == null && root.getRight() == null)
			return 0;

		int lh = height(root.getLeft());
		int rh = height(root.getRight());

		dia = dia > lh + rh + 2 ? dia : lh + rh + 2;

		return lh > rh ? lh + 1 : rh + 1;
	}

}
