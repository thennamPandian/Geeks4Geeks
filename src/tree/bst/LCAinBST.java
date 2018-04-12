package tree.bst;

import tree.util.Tree;
import tree.util.TreeUtil;

public class LCAinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Simple BST
		String[] values = new String[] { "4", "2", "6" };
		Tree root = TreeUtil.createTree(values);
		Tree temp = lca(root, 2,6);
		System.out.println(temp == null ? null : temp.getData());

		// Null
		temp = lca(null, 2,6);
		System.out.println(temp == null ? null : temp.getData());

		// Single Element tree
		values = new String[] { "2" };
		root = TreeUtil.createTree(values);
		temp = lca(root, 2,6);
		System.out.println(temp == null ? null : temp.getData());

		// Multi level BST
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		temp = lca(root, 2,7);
		System.out.println(temp == null ? null : temp.getData());
		temp = lca(root, 5,7); 
		System.out.println(temp == null ? null : temp.getData());

		// Multi level BST
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		temp = lca(root, 1,7);
		System.out.println(temp == null ? null : temp.getData());

		// left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		temp = lca(root, 30,20); 
		System.out.println(temp == null ? null : temp.getData());

		// Right skews
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root = TreeUtil.createTree(values);
		temp = lca(root, 170,180); 
		System.out.println(temp == null ? null : temp.getData());

	}

	public static Tree lca(Tree root, int a, int b) {

		if (ElementPresentInBST.isPresent(root, a)
				&& ElementPresentInBST.isPresent(root, b)) {
			return lcaRecurseive(root, a, b);
		}
		return null;
	}

	public static Tree lcaRecurseive(Tree root, int a, int b) {

		if (root == null)
			return null;

		if (root.getData() == a || root.getData() == b)
			return root;

		if (root.getData() >= a && root.getData() >= b) {
			root = lcaRecurseive(root.getLeft(), a, b);
		}

		if (root.getData() < a && root.getData() < b) {
			root = lcaRecurseive(root.getRight(), a, b);
		}
		return root;
	}

}
