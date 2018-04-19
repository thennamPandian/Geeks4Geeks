package tree.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class TreeFactory {

	public static Tree createNormalGenericTree() {
		List<List<Integer>> values = new ArrayList<List<Integer>>();

		List<Integer> list = new ArrayList<>();
		list.add(1);
		values.add(list);

		list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		values.add(list);

		values.add(null);

		list = new ArrayList<>();
		list.add(5);
		list.add(6);
		values.add(list);

		values.add(null);
		values.add(null);

		list = new ArrayList<>();
		list.add(7);
		values.add(list);

		return TreeUtil.createGenericNode(values);
	}

	public static Tree createSingleElementGenericTree() {
		List<List<Integer>> values = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		values.add(list);
		return TreeUtil.createGenericNode(values);
	}

	public static Tree createNoSiblingGenericTree() {

		List<List<Integer>> values = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		values.add(list);

		list = new ArrayList<>();
		list.add(2);
		values.add(list);

		list = new ArrayList<>();
		list.add(3);
		values.add(list);

		return TreeUtil.createGenericNode(values);
	}

	public static Tree createNoChildGenericTree() {

		List<List<Integer>> values = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		values.add(list);

		list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		values.add(list);

		
		return TreeUtil.createGenericNode(values);
	}

	
	public static AVLTree createAVLTree(String[] values) {
		AVLTree root = null;
		int index = 0;
		Queue<AVLTree> queue = new LinkedBlockingQueue<AVLTree>();

		int value = Integer.parseInt(values[index]);

		AVLTree cur = null;
		AVLTree temp = null;

		temp = new AVLTree();
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
				temp = new AVLTree();
				temp.setData(Integer.parseInt(values[lIndex]));
				cur.setLeft(temp);
				queue.add(temp);
			}

			if (values[rIndex] != "&") {
				temp = new AVLTree();
				temp.setData(Integer.parseInt(values[rIndex]));
				cur.setRight(temp);
				queue.add(temp);
			}

			index++;

		}

		populateHeight(root);
		return root;
	}
	
	public static void populateHeight(AVLTree root){
		
		if(root == null )return;
		
		if(root.getLeft() == null && root.getRight()== null ) {
			root.setHeight(0);
			return;
		}
		
		populateHeight(root.getLeft());
		populateHeight(root.getRight());
		
		int lstHeight = root.getLeft() == null ? 0: root.getLeft().getHeight();
		int rstHeight = root.getRight() == null ? 0: root.getRight().getHeight();
		int height = 1 + Math.max(lstHeight, rstHeight);
		root.setHeight(height);
	}
}
