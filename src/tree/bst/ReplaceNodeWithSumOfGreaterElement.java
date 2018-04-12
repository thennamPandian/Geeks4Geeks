package tree.bst;

import tree.util.Tree;
import tree.util.TreeUtil;

/*
 * 
 * Given a BST, replace a node value with  sum of all the nodes 
 * value greater then the given node.
 */
public class ReplaceNodeWithSumOfGreaterElement {

	private static int sum = 0;

	public static void main(String[] args) {
		// Min Binary tree
		String[] values = new String[] { "4", "2", "6" };
		Tree root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		replaceWithGreaterSum(root);
		InOrderTraversal.inOrderTraversal(root);

		sum = 0;
		// Example from Geeks for Geeks
		values = new String[] { "50", "30", "70", "20", "40", "60", "80" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		replaceWithGreaterSum(root);
		InOrderTraversal.inOrderTraversal(root);

		sum = 0;
		// left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		replaceWithGreaterSum(root);
		InOrderTraversal.inOrderTraversal(root);

		sum = 0;
		// Right skews
		values = new String[] { "50", "&", "70", "&", "&", "&", "80" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		replaceWithGreaterSum(root);
		InOrderTraversal.inOrderTraversal(root);

		sum = 0;
		// Single Element tree
		values = new String[] { "50" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		replaceWithGreaterSum(root);
		InOrderTraversal.inOrderTraversal(root);

		sum = 0;
		// Empty tree
		InOrderTraversal.inOrderTraversal(null);
		System.out.println();
		replaceWithGreaterSum(null);
		System.out.println(" Sum for null value  : " + sum);

		sum = 0;
		// Tree has only left sub tree
		values = new String[] { "4", "2", "&", "1", "3", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		replaceWithGreaterSum(root);
		InOrderTraversal.inOrderTraversal(root);
		
		sum = 0;
		// Tree has only right sub tree
		values = new String[] { "4", "&", "6", "&", "&", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		replaceWithGreaterSum(root);
		InOrderTraversal.inOrderTraversal(root);
	}

	public static void replaceWithGreaterSum(Tree root) {
		if (root == null)
			return;

		replaceWithGreaterSum(root.getRight());

		int temp = root.getData() + sum;
		if (sum != 0) {
			root.setData(temp);
		}
		sum = temp;

		replaceWithGreaterSum(root.getLeft());
		return;

	}

}
