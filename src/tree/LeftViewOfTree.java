package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class LeftViewOfTree {

	private static int max = -1;

	public static void main(String[] args) {

		String[] values = new String[] { "1", "2", "3", "&", "&", "4", "5",
				"&", "&", "&", "&", "6", "7", "&", "&" };
		Tree root = TreeUtil.createTree(values);
		leftView(root, 0);

		System.out.println();
		max = -1;
		leftView(null, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1"};
		root = TreeUtil.createTree(values);
		leftView(root, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1","2","&"};
		root = TreeUtil.createTree(values);
		leftView(root, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1","&","3"};
		root = TreeUtil.createTree(values);
		leftView(root, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1", "2", "3", "&", "&", "4", "5",
				"&", "&", "&", "&", "&", "&", "&", "7" };
		root = TreeUtil.createTree(values);
		leftView(root, 0);
	}

	public static void leftView(Tree root, int level) {

		if (root == null)
			return;

		if (max < level) {
			System.out.print(root.getData() + "->");
			max = level;
		}

		leftView(root.getLeft(), level + 1);
		leftView(root.getRight(), level + 1);

	}
}
