package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class LevelOfTheNode {

	public static void main(String[] args) {

		int level = 0;

		// null tree
		System.out.println(levelOfNode(null, 1, level));

		// single element B tree
		String[] values = new String[] { "1" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(levelOfNode(root, 1, level));

		// Mini B tree, level of a node in LST
		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		System.out.println(levelOfNode(root, 2, level));

		// Mini B tree, level of a node in RST
		System.out.println(levelOfNode(root, 3, level));

		// Mini B tree, level of a node which is not present in the tree
		System.out.println(levelOfNode(root, 5, level));

		// level 2, B tree. siblings
		values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(levelOfNode(root, 4, level));
		System.out.println(levelOfNode(root, 7, level));

		// level 2 B tree, level of a node which is not present in the tree
		System.out.println(levelOfNode(root, 17, level));

		// left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(levelOfNode(root, 20, level));

		// left skews, level of a node which is not present in the tree
		System.out.println(levelOfNode(root, 120, level));

		// Right skews
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root = TreeUtil.createTree(values);
		System.out.println(levelOfNode(root, 170, level));

		// left skews, level of a node which is not present in the tree
		System.out.println(levelOfNode(root, 120, level));

		// non-height balanced, B tree. siblings
		values = new String[] { "1", "2", "&", "4", "5", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(levelOfNode(root, 4, level));
	}

	public static int levelOfNode(Tree root, int data, int level) {

		if (root == null)
			return -1;

		if (root.getData() == data)
			return level;

		int newLevel = levelOfNode(root.getLeft(), data, level + 1);

		if (newLevel == -1) {
			newLevel = levelOfNode(root.getRight(), data, level + 1);
		}

		return newLevel;
	}

}
