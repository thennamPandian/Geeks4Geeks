package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class CheckTheNodesAreCousins {

	public static void main(String[] args) {

		// null tree
		System.out.println(isCousins(null, 1, 2));

		// single element B tree
		String[] values = new String[] { "1" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(isCousins(root, 1, 2));

		// Mini B tree
		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		System.out.println(isCousins(root, 2, 3));

		// level 2, B tree. Cousins
		values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(isCousins(root, 4, 7));

		// level 2, B tree. siblings
		System.out.println(isCousins(root, 4, 5));

		// level 2, B tree. nodes are in different level
		System.out.println(isCousins(root, 2, 5));

		// left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(isCousins(root, 50, 30));

		// Right skews
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root = TreeUtil.createTree(values);
		System.out.println(isCousins(root, 170, 180));

		// non-height balanced, B tree. siblings
		values = new String[] { "1", "2", "&", "4", "5", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(isCousins(root, 4, 5));
	}

	private static boolean isCousins(Tree root, int a, int b) {

		if (!CheckTheNodesAreSibiling.isItSibling(root, a, b)) {

			return LevelOfTheNode.levelOfNode(root, a, 0) == LevelOfTheNode
					.levelOfNode(root, b, 0);
		}

		return false;
	}

}
