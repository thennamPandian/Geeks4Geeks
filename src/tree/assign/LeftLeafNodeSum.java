package tree.assign;

import tree.util.Tree;
import tree.util.TreeUtil;

public class LeftLeafNodeSum {

	public static void main(String[] args) {

		// Min complete B tree
		String[] values = new String[] { "1", "2", "3" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(leftLeafSum(root, 0));

		// Left Skew Tree
		values = new String[] { "1", "2", "&", "4", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(leftLeafSum(root, 0));

		// Right Skew Tree
		values = new String[] { "1", "&", "3", "&", "&", "&", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(leftLeafSum(root, 0));

		// Null case
		System.out.println(leftLeafSum(null, 0));

		// Single node Tree
		values = new String[] { "1" };
		root = TreeUtil.createTree(values);
		System.out.println(leftLeafSum(root, 0));
		
		// Leaf node only in left
		values = new String[] { "1", "2", "3", "&", "&","4","5", "&", "&", "&", "&", "&", "&" ,"6", "&"};
		root = TreeUtil.createTree(values);
		System.out.println(leftLeafSum(root, 0));
		
		// Complete Binary Tree
		values = new String[] { "1", "2", "3", "4", "5", "6", "7","8","9","10","11","12","13","14","15" };
		root = TreeUtil.createTree(values);
		System.out.println(leftLeafSum(root, 0));
				
		// Left node only in right sub tree
		values = new String[] { "1", "2", "3", "4", "5", "6", "7","&","9","&","11","&","13","&","&" };
		root = TreeUtil.createTree(values);
		System.out.println(leftLeafSum(root, 0));
		
		// Left node only in left sub tree
		values = new String[] { "1", "2", "3", "4", "5", "6", "7","8","&","10","&","&","&","14","&" };
		root = TreeUtil.createTree(values);
		System.out.println(leftLeafSum(root, 0));
	}

	public static int leftLeafSum(Tree root, int sum) {

		if (root == null)
			return sum;

		sum = leftLeafSum(root.getLeft(), sum);
		sum = leftLeafSum(root.getRight(), sum);

		if (root.getLeft() != null && root.getLeft().getLeft() == null
				&& root.getLeft().getRight() == null)
			return sum + root.getLeft().getData();
		
		return sum;
	}

}
