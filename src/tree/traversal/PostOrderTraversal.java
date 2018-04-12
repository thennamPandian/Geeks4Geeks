package tree.traversal;

import tree.util.Tree;
import tree.util.TreeUtil;

public class PostOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = {"1", "2","3","4","5","6","7"};
		Tree root = TreeUtil.createTree(values);
		postOrder(root);
	}
	
	public static void postOrder(Tree root) {
		if (root == null) {
			return;
		}
				
		postOrder(root.getLeft());		
		postOrder(root.getRight());
		System.out.print(root.getData()+"->");		
	}

}
