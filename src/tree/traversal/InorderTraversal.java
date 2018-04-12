package tree.traversal;

import tree.util.Tree;
import tree.util.TreeUtil;

public class InorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = {"1", "2","3","4","5","6","7"};
		Tree root = TreeUtil.createTree(values);
		inOrder(root);

	}

	public static void inOrder(Tree root) {
		if (root == null) {
			return;
		}
		
		inOrder(root.getLeft());
		System.out.print(root.getData()+"->");
		inOrder(root.getRight());
		
	}

}
