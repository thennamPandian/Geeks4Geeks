package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import tree.util.Tree;
import tree.util.TreeUtil;

public class VerticalTraversalWithOrder {

	public static void main(String[] args) {

		// null tree
		HashMap<Integer, List<Integer>> map = verticalTraversal(null);
		System.out.println(map);

		// simple element tree
		String[] values = new String[] { "1" };
		Tree root = TreeUtil.createTree(values);
		map = verticalTraversal(root);
		System.out.println(map);

		// simple tree
		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		map = verticalTraversal(root);
		System.out.println(map);

		// level 2 tree
		values = new String[] { "0", "1", "2", "3", "4", "5", "6" };
		root = TreeUtil.createTree(values);
		map = verticalTraversal(root);
		System.out.println(map);

		// multi level
		values = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"13", "14", "9", "10", "11", "12" };
		root = TreeUtil.createTree(values);
		map = verticalTraversal(root);
		System.out.println(map);

		// Right skews
		values = new String[] { "50", "&", "170", "&", "&", "&", "180", "&",
				"&", "&", "&", "&", "&", "&", "190" };

		root = TreeUtil.createTree(values);
		map = verticalTraversal(root);
		System.out.println(map);

		// Left skews
		values = new String[] { "50", "30", "&", "20", "&", "&", "&", "10",
				"&", "&", "&", "&", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		map = verticalTraversal(root);
		System.out.println(map);

		// non-height balanced, B tree.
		values = new String[] { "1", "2", "&", "4", "5", "&", "&" };
		root = TreeUtil.createTree(values);
		map = verticalTraversal(root);
		System.out.println(map);
	}

	private static void putInMap(HashMap<Integer, List<Integer>> map, int key,
			int value) {

		List<Integer> values = null;
		if (map.get(key) == null) {
			values = new ArrayList<Integer>();
			map.put(key, values);
		} else {
			values = map.get(key);
		}

		values.add(value);
	}

	public static HashMap<Integer, List<Integer>> verticalTraversal(Tree root) {

		if (root == null)
			return null;
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		Queue<Object> queue = new LinkedBlockingQueue<Object>();

		int curVDist = 0;
		queue.add(root);
		putInMap(map, curVDist, root.getData());

		while (!queue.isEmpty()) {
			Object cur = queue.poll();
			if (cur instanceof Tree) {
				Tree temp = (Tree) cur;
				if (temp.getLeft() != null) {
					queue.add(curVDist - 1);
					queue.add(temp.getLeft());
					putInMap(map, curVDist - 1, temp.getLeft().getData());
				}

				if (temp.getRight() != null) {
					queue.add(curVDist + 1);
					queue.add(temp.getRight());
					putInMap(map, curVDist + 1, temp.getRight().getData());
				}
			} else {
				curVDist = (Integer) cur;
			}
		}

		return map;

	}

}
