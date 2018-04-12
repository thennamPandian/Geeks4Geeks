package tree.assign;

import tree.util.Tree;
import tree.util.TreeUtil;

public class SumRoot2Leaf {

	// private static int total = 0;
	public static void main(String[] args) {

		// Leaf in same level
		String[] values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(rootToLeafSum(root, 0));

		// min Complete B tree
		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		System.out.println(rootToLeafSum(root, 0));

		// null
		System.out.println(rootToLeafSum(null, 0));

		// single node tree
		values = new String[] { "1" };
		root = TreeUtil.createTree(values);
		System.out.println(rootToLeafSum(root, 0));

		// Left Skew Tree
		values = new String[] { "1", "2", "&", "4", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(rootToLeafSum(root, 0));

		// Right Skew Tree
		values = new String[] { "1", "&", "3", "&", "&", "&", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(rootToLeafSum(root, 0));
		
		// Leafs are in diff level
		values = new String[] { "1", "2", "3", "&", "&","4","5", "&", "&", "&", "&", "&", "&" ,"6", "&"};
		root = TreeUtil.createTree(values);
		System.out.println(rootToLeafSum(root, 0));

	}

	public static int rootToLeafSum(Tree root, int sum) {

		if (root == null)
			return 0;

		sum = (sum * 10) + root.getData();

		if (root.getLeft() == null && root.getRight() == null) {
			return sum;
		}

		return rootToLeafSum(root.getLeft(), sum)
				+ rootToLeafSum(root.getRight(), sum);

	}
}
