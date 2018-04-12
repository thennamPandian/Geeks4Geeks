package tree.util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import linkedList.util.Node;

public class TreeUtil {

	public static Tree createTree(String[] values) {
		Tree root = null;
		int index = 0;
		Queue<Tree> queue = new LinkedBlockingQueue<Tree>();

		int value = Integer.parseInt(values[index]);

		Tree cur = null;
		Tree temp = null;

		temp = new Tree();
		temp.setData(value);

		root = temp;
		cur = temp;
		queue.add(temp);

		while (true) {
			int lIndex = (index * 2) + 1;
			if (lIndex >= values.length) {
				break;
			}

			int rIndex = lIndex + 1;
			
			//if (values[lIndex] != "&" || values[rIndex] != "&" )
			if(values[index] != "&")
			cur = queue.poll();

			if (values[lIndex] != "&") {
				temp = new Tree();
				temp.setData(Integer.parseInt(values[lIndex]));
				cur.setLeft(temp);
				queue.add(temp);
			}

			if (values[rIndex] != "&") {
				temp = new Tree();
				temp.setData(Integer.parseInt(values[rIndex]));
				cur.setRight(temp);
				queue.add(temp);
			}
			
			index++;

		}
	
		return root;
	}
}
