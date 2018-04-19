package tree.avl;

import tree.HeightOftheTree;
import tree.util.Tree;
import tree.util.TreeUtil;

public class CheckBSTisAVL {

	public static void main(String[] args) {

		// null element as tree
		System.out.println(isAVL(null));

		// single element B tree
		String[] values = new String[] { "1" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(isAVL(root));

		// Mini B tree
		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		System.out.println(isAVL(root));

		// level 2, B tree.
		values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(isAVL(root));

		// non-height balanced, B tree.
		values = new String[] { "1", "2", "&", "4", "5", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(isAVL(root));

		// left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" ,"10",
				"&", "&", "&", "&", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(isAVL(root));

		// Right skews
		values = new String[] { "50", "&", "170", "&", "&", "&", "180", "&",
				"&", "&", "&", "&", "&", "&", "190" };
		root = TreeUtil.createTree(values);
		System.out.println(isAVL(root));
		
		// non-height balancing tree
		values = new String[] { "50", "30", "170", "&", "&", "&", "180", "&",
				"&", "&", "&", "&", "&", "&", "190" };
		root = TreeUtil.createTree(values);
		System.out.println(isAVL(root));
	}

	public static boolean isAVL(Tree root) {
		if (root == null)
			return true;
		boolean isAVL = isAVL(root.getLeft());

		if (isAVL) {
			isAVL = isAVL(root.getRight());
		}

		return isAVL && isHBT(root);
	}

	public static boolean isHBT(Tree root) {
		if (root == null)
			return true;
		int lstHeight = HeightOftheTree.height(root.getLeft());
		int rstHeight = HeightOftheTree.height(root.getRight());

		int hbt = Math.abs(lstHeight - rstHeight);
		return hbt == 0 || hbt == 1;
	}

}
