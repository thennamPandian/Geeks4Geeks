package tree;

import linkedList.util.Node;
import linkedList.util.TripleLL;
import tree.util.Tree;
import tree.util.TreeUtil;

public class VerticalTraversal {

	public static void main(String[] args) {
		// simple tree
		String[] values = new String[] { "1", "2", "3" };
		Tree root = TreeUtil.createTree(values);
		TripleLL cur = verticalTraversal(root, null, 0);
		cur.print();
		
		// multi level
		values = new String[] { "1", "2", "3" ,"4","5","6","7",
				"8","9","10","11","12","13","14","15"};
		root = TreeUtil.createTree(values);
		cur = verticalTraversal(root, null, 0);
		cur.print();

	}

	public static TripleLL verticalTraversal(Tree root, TripleLL cur,
			int direction) {

		if (root == null)
			return null;

		TripleLL temp = null;

		if (direction == 0) {
			temp = new TripleLL();

			Node node = new Node();
			node.setData(root.getData());
			temp.setChild(node);
			// temp.setData(root.getData());
		} else if (direction == -1) {
			temp = cur.getPrev();
			if (temp == null) {
				temp = new TripleLL();
				// temp.setData(root.getData());
				Node node = new Node();
				node.setData(root.getData());
				temp.setChild(node);

				temp.setNext(cur);
				cur.setPrev(temp);
			} else {
				// temp.setData(root.getData() + temp.getData());
				Node child = temp.getChild();
				Node node = new Node();
				node.setData(root.getData());

				if (child != null) {
					while (child.getNext() != null) {
						child = child.getNext();
					}
					child.setNext(node);
				} else {
					temp.setChild(node);
				}
			}
		} else if (direction == 1) {

			temp = cur.getNext();
			if (temp == null) {
				temp = new TripleLL();
				// temp.setData(root.getData());

				Node node = new Node();
				node.setData(root.getData());
				temp.setChild(node);

				temp.setPrev(cur);
				cur.setNext(temp);
			} else {
				// temp.setData(root.getData() + temp.getData());
				Node child = temp.getChild();
				Node node = new Node();
				node.setData(root.getData());

				if (child != null) {
					while (child.getNext() != null) {
						child = child.getNext();
					}
					child.setNext(node);
				} else {
					temp.setChild(node);
				}

			}
		}

		cur = temp;

		verticalTraversal(root.getLeft(), cur, -1);
		verticalTraversal(root.getRight(), cur, 1);

		return cur;

	}
}
