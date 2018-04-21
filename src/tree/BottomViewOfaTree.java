package tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import tree.util.Tree;
import tree.util.TreeUtil;

public class BottomViewOfaTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Null element
		bottomViewOfTree(null);

		// simple element tree
		System.out.println();
		String[] values = new String[] { "1" };
		Tree root = TreeUtil.createTree(values);
		bottomViewOfTree(root);

		// simple tree
		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		System.out.println();
		bottomViewOfTree(root);

		// level 2 tree
		values = new String[] { "0", "1", "2", "3", "4", "5", "6" };
		root = TreeUtil.createTree(values);
		System.out.println();
		bottomViewOfTree(root);

		// multi level
		System.out.println();
		values = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"13", "14", "9", "10", "11", "12" };
		root = TreeUtil.createTree(values);
		bottomViewOfTree(root);

		// Right skews
		values = new String[] { "50", "&", "170", "&", "&", "&", "180", "&",
				"&", "&", "&", "&", "&", "&", "190" };

		root = TreeUtil.createTree(values);
		System.out.println();
		bottomViewOfTree(root);

		// Left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&", "10",
				"&", "&", "&", "&", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println();
		bottomViewOfTree(root);

		// non-height balanced, B tree.
		values = new String[] { "1", "2", "&", "4", "5", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println();
		bottomViewOfTree(root);
	}

	public static void bottomViewOfTree(Tree root) {
		if (root == null)
			return;

		HashMap<Integer, List<Integer>> map = VerticalTraversalWithOrder
				.verticalTraversal(root);
		TreeSet<Integer> set = new TreeSet<>(map.keySet());
		Iterator<Integer> it = set.iterator();

		while (it.hasNext()) {
			List<Integer> values = map.get(it.next());
			if (values != null && !values.isEmpty()) {
				System.out.print(values.get(values.size()-1) + " , ");
			}
		}

	}

}
