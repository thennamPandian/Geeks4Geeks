package tree.traversal;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import tree.util.Tree;
import tree.util.TreeUtil;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = {"1", "2","3","4","5","6","7"};
		Tree root = TreeUtil.createTree(values);
		levelOrder(root);
	}

	public static void levelOrder(Tree root) {

		if (root == null)
			return;

		Queue<Tree> queue = new LinkedBlockingQueue<Tree>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Tree temp = queue.poll();
			System.out.print(temp.getData() + "->");

			if (temp.getLeft() != null)
				queue.add(temp.getLeft());
						
			if (temp.getRight() != null)
				queue.add(temp.getRight());

		}
	}

}
