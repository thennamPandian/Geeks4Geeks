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
		
		System.out.println(" Distance between 4 and 7  : " + DistanceBetween2Nodes.distance(lca, 4, 7));

		// lca in left sub tree
		lca = lca(root, 4, 5);
		System.out.println(lca != null ? lca.getData() : "Not present");
		System.out.println(" Distance between 4 and 5  : " + DistanceBetween2Nodes.distance(lca, 4, 5));

		// lca in right sub tree
		lca = lca(root, 6, 7);
		System.out.println(lca != null ? lca.getData() : "Not present");
		System.out.println(" Distance between 6 and 7  : " + DistanceBetween2Nodes.distance(lca, 6, 7));

		// lca is not there
		lca = lca(root, 4, 17);
		System.out.println(lca != null ? lca.getData() : "Not present");
		System.out.println(" Distance between 4 and 17  : " + DistanceBetween2Nodes.distance(lca, 4, 17));

		// parent is lca
		lca = lca(root, 4, 1);
		System.out.println(lca != null ? lca.getData() : "Not present");
		System.out.println(" Distance between 4 and 1  : " + DistanceBetween2Nodes.distance(lca, 4, 1));

		// null tree
		lca = lca(null, 4, 17);
		System.out.println(lca != null ? lca.getData() : "Not present");
		System.out.println(" Distance between 4 and 17  : " + DistanceBetween2Nodes.distance(lca, 4, 17));

		// Single Element
		values = new String[] { "1" };
		root = TreeUtil.createTree(values);
		lca = lca(root, 4, 17);
		System.out.println(lca != null ? lca.getData() : "Not present");
		System.out.println(" Distance between 4 and 17  : " + DistanceBetween2Nodes.distance(lca, 4, 17));

		// left skews
		System.out.println("\n");
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		lca = lca(root, 30, 20);
		System.out.println(lca != null ? lca.getData() : "Not present");
		System.out.println(" Distance between 30 and 20  : " + DistanceBetween2Nodes.distance(lca, 30, 20));

		// Right skews
		System.out.println("\n");
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root = TreeUtil.createTree(values);
		lca = lca(root, 170, 180);
		System.out.println(lca != null ? lca.getData() : "Not present");
		System.out.println(" Distance between 170 and 180  : " + DistanceBetween2Nodes.distance(lca, 170, 180));
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
