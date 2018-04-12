package tree.util;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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

			// if (values[lIndex] != "&" || values[rIndex] != "&" )
			if (values[index] != "&")
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

	public static Tree createGenericNode(List<List<Integer>> values) {

		if (values == null)
			return null;
		// Right pointer represents sibling
		// Left pointer represents children
		Tree root = new Tree();
		root.setData(values.get(0).get(0));
		root.setRight(null);

		Tree temp = root;
		Tree nonNullSibHead = null;
		int i = 1;

		while (i < values.size()) {

			List<Integer> siblings = values.get(i);
			Tree sibHead = null;
			Tree prev = null;
			while (siblings != null && !siblings.isEmpty()) {
				Tree cur = new Tree();
				cur.setData(siblings.remove(0));

				if (sibHead == null) {
					sibHead = cur;
					nonNullSibHead = cur;
				} else {
					prev.setRight(cur);
				}

				prev = cur;
			}

			temp.setLeft(sibHead);
			if (temp.getRight() == null)
				temp = nonNullSibHead;
			else
				temp = temp.getRight();
			
			i++;
		}

		return root;
	}
	
	public static Tree findNodeInTree(Tree root, int data) {
		
		if(root == null ) return null;
		
		if( root.getData() == data ) return root;
		
		Tree node = findNodeInTree(root.getLeft(), data);
		
		if(node == null )
			node = findNodeInTree(root.getRight(), data);		
		return node;
	}
	
	public static Tree findRootOfNode(Tree root, int data) {
		
		if(root == null) return null;
		
		if(root.getLeft() == null && root.getRight() == null) return null;
		
		if( root.getLeft()  != null && root.getLeft().getData() == data || 
			root.getRight() != null && root.getRight().getData() == data ) return root;
		
		Tree node = findRootOfNode(root.getLeft(), data);
		
		if(node == null )
			node = findRootOfNode(root.getRight(), data);		
		return node;	
	}

}

