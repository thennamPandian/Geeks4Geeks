package tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import tree.util.Tree;
import tree.util.TreeUtil;

/**
 *  TODO : Find the first deepest node.  
 * 
 *
 */
public class DeepestNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = { "1", "2", "3", "4", "5", "6", "7", "&", "&", "&","9" };
		Tree root = TreeUtil.createTree(values);
		deepestNode(root);
	}

	public static void deepestNode(Tree root) {

		if (root == null)
			return;

		Queue<Tree> queue = new LinkedBlockingQueue<Tree>();
		queue.add(root);
		Tree temp = null;
		while (!queue.isEmpty()) {
			temp = queue.poll();

			if (temp.getLeft() != null)
				queue.add(temp.getLeft());
			if (temp.getRight() != null)
				queue.add(temp.getRight());
		}

		System.out.print(temp.getData());
	}

}
