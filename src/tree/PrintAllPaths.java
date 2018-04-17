package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class PrintAllPaths {

	public static void main(String[] args) {
		// Basic ones
		String[] values = new String[] { "1", "2", "3" };
		Tree root1 = TreeUtil.createTree(values);
		printPathToleaf(root1, "");

		// Right has more nodes
		System.out.println("\n");
		values = new String[] { "1", "2", "5", "3", "&", "&", "6", "&", "&",
				"&", "&", "&", "&", "&", "7" };
		root1 = TreeUtil.createTree(values);
		printPathToleaf(root1, "");

		// level 2 full tree
		System.out.println("\n");
		values = new String[] { "1", "2", "5", "3", "4", "7", "6" };
		root1 = TreeUtil.createTree(values);
		printPathToleaf(root1, "");

		// left skews
		System.out.println("\n");
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root1 = TreeUtil.createTree(values);
		printPathToleaf(root1, "");

		// Right skews
		System.out.println("\n");
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root1 = TreeUtil.createTree(values);
		printPathToleaf(root1, "");

		// Single element
		System.out.println("\n");
		values = new String[] { "50" };
		root1 = TreeUtil.createTree(values);
		printPathToleaf(root1, "");

		// null
		System.out.println("\n");
		printPathToleaf(null, "");

	}

	public static void printPathToleaf(Tree root, String str) {

		if (root == null)
			return;

		if (root.getLeft() == null && root.getRight() == null) {
			System.out.println(str + "," + root.getData());
			return;
		}

		printPathToleaf(root.getLeft(), str + "," + root.getData());
		printPathToleaf(root.getRight(), str + "," + root.getData());
	}

}
