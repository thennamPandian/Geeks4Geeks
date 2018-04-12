package tree;

import linkedList.util.DoublyLL;
import tree.util.Tree;
import tree.util.TreeUtil;

public class VerticalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] values = new String[] { "1", "2", "3" };
		Tree root = TreeUtil.createTree(values);
		DoublyLL cur = verticalSum(root, null, 0);
		printSum(cur);

		System.out.println();
		values = new String[] { "1", "2", "3", "4", "5", "&", "7", "&",
				"&", "6", "11", "&", "&", "8", "3", "&", "&", "&", "&", "&", "&", "&",
				"12","&","&","&","&","&","&","&","&",
				"&", "&", "&", "&", "&", "&", "&", "&", "&", "&",
				"&", "&", "&", "&", "&", "13",
				"&", "&", "&", "&", "&", "&", "&", "&", "&", "&",
				"&", "&", "&", "&", "&","&"};
		root = TreeUtil.createTree(values);
		cur = verticalSum(root, null, 0);
		printSum(cur);
		
		System.out.println();
		cur = verticalSum(null, null, 0);
		printSum(cur);
		
		System.out.println();
		values = new String[] { "1"};
		root = TreeUtil.createTree(values);
		cur = verticalSum(root, null, 0);
		printSum(cur);
		
		System.out.println();
		values = new String[] { "1", "2", "3", "4", "5","6","7"};
		root = TreeUtil.createTree(values);
		cur = verticalSum(root, null, 0);
		printSum(cur);
		
		System.out.println();
		values = new String[] { "1", "2", "&", "4", "&","&","&"};
		root = TreeUtil.createTree(values);
		cur = verticalSum(root, null, 0);
		printSum(cur);
		
		System.out.println();
		values = new String[] { "1", "&", "3", "&", "&","&","7"};
		root = TreeUtil.createTree(values);
		cur = verticalSum(root, null, 0);
		printSum(cur);
	}

	public static void printSum(DoublyLL cur) {

		if (cur != null) {
			while (cur.getPrev() != null)
				cur = cur.getPrev();

			while (cur != null) {
				System.out.print(cur.getData() + "->");
				cur = cur.getNext();
			}
		}

	}

	public static DoublyLL verticalSum(Tree root, DoublyLL cur, int direction) {

		if (root == null)
			return null;

		DoublyLL temp = null;

		if (direction == 0) {
			temp = new DoublyLL();
			temp.setData(root.getData());
		} else if (direction == -1) {
			temp = cur.getPrev();
			if (temp == null) {
				temp = new DoublyLL();
				temp.setData(root.getData());
				temp.setNext(cur);
				cur.setPrev(temp);
			} else {
				temp.setData(root.getData() + temp.getData());
			}
		} else if (direction == 1) {

			temp = cur.getNext();
			if (temp == null) {
				temp = new DoublyLL();
				temp.setData(root.getData());
				temp.setPrev(cur);
				cur.setNext(temp);
			} else {
				temp.setData(root.getData() + temp.getData());
			}
		}

		cur = temp;

		verticalSum(root.getLeft(), cur, -1);
		verticalSum(root.getRight(), cur, 1);

		return cur;

	}

}
