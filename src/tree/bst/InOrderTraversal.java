package tree.bst;

import tree.util.Tree;
import tree.util.TreeUtil;

public class InOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = new String[] { "4","2","6","1","3","5","7" };
		Tree root = TreeUtil.createTree(values);
		inOrderTraversal(root);

	}
	
	public static void inOrderTraversal(Tree root) {
		if(root == null ) return;
		
		inOrderTraversal(root.getLeft());
		System.out.print(root.getData()+"=>");
		inOrderTraversal(root.getRight());
	}

}
