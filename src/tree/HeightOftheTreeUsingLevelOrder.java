package tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import tree.util.Tree;
import tree.util.TreeUtil;

public class HeightOftheTreeUsingLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = new String[] { "1", "2", "3", "4", "5", "6", "7",
				"&", "&", "&", "&", "&", "&", "&", "9" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(levelOrderHeight(root));
		
		values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		root = TreeUtil.createTree(values);
		System.out.println(levelOrderHeight(root));
		
		values = new String[] { "1"};
		root = TreeUtil.createTree(values);
		System.out.println(levelOrderHeight(root));
		
		values = new String[] { "1", "2", "3" };
		root = TreeUtil.createTree(values);
		System.out.println(levelOrderHeight(root));
		
		System.out.println(levelOrderHeight(null));
	}

	public static int levelOrderHeight(Tree root) {

		if (root == null)
			return 0;

		Queue<Object> queue = new LinkedBlockingQueue<Object>();
		queue.add(root);
		queue.add("$");
		int count = 0;

		while (!queue.isEmpty()) {
			Object temp = queue.poll();

			if (temp.equals("$") && !queue.isEmpty()) {
				queue.add("$");
				count++;
			}

			if (temp instanceof Tree) {
				
				if (((Tree)temp).getLeft() != null)
					queue.add(((Tree)temp).getLeft());
				if (((Tree)temp).getRight() != null)
					queue.add(((Tree)temp).getRight());
			}
		}

		return count;
	}

}
