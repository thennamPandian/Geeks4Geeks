package tree.traversal;

import tree.util.Tree;
import tree.util.TreeUtil;

public class PreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = {"1", "2","3","4","5","6","7"};
		Tree root = TreeUtil.createTree(values);
		preOrder(root);
	}
	
	public static void preOrder(Tree root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.getData()+"->");
		preOrder(root.getLeft());		
		preOrder(root.getRight());
		
	}

}
