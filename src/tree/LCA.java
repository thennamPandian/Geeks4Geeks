package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class LCA {

	public static void main(String[] args) {
		// Level 2 B tree
		String[] values = { "1", "2", "3", "4", "5", "6", "7" };
		Tree root = TreeUtil.createTree(values);
		Tree lca = lca(root, 4, 7);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// lca in left sub tree
		lca = lca(root, 4, 5);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// lca in right sub tree
		lca = lca(root, 6, 7);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// lca is not there
		lca = lca(root, 4, 17);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// parent is lca
		lca = lca(root, 4, 1);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// null tree
		lca = lca(null, 4, 17);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// Single Element
		values = new String[] { "1" };
		root = TreeUtil.createTree(values);
		lca = lca(root, 4, 17);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// left skews
		System.out.println("\n");
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		lca = lca(root, 30, 20);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// Right skews
		System.out.println("\n");
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root = TreeUtil.createTree(values);
		lca = lca(root, 170, 180);
		System.out.println(lca != null ? lca.getData() : "Not present");

		// tree with duplicate node in left sub tree
		values = new String[] { "1", "14", "3", "4", "7", "4", "17" };
		root = TreeUtil.createTree(values);
		lca = lca(root, 4, 7);
		System.out.println(" duplicate ==> " + lca != null ? lca.getData()
				: "Not present");

		// tree with duplicate node in right sub tree
		values = new String[] { "1", "4", "3", "4", "17", "4", "7" };
		root = TreeUtil.createTree(values);
		lca = lca(root, 4, 7);
		System.out.println(lca != null ? lca.getData() : "Not present");

	}

	public static Tree lca(Tree root, int n1, int n2) {
		if (TreeUtil.findNodeInTree(root, n1) != null
				&& TreeUtil.findNodeInTree(root, n2) != null)
			return findLCA(root, n1, n2);
		else
			return null;
	}

	private static Tree findLCA(Tree root, int n1, int n2) {

		if (root == null)
			return null;

		if (root.getData() == n1 || root.getData() == n2)
			return root;

		Tree left = findLCA(root.getLeft(), n1, n2);
		Tree right = findLCA(root.getRight(), n1, n2);

		if (left != null && right != null)
			return root;
		else if (left == null && right != null)
			return right;
		else if (left != null && right == null)
			return left;

		return null;
	}
}
