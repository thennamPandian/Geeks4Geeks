package tree;

import tree.traversal.LevelOrderTraversal;
import tree.util.Tree;
import tree.util.TreeUtil;

public class SumOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		Tree root = TreeUtil.createTree(values);
		sum(root);
		LevelOrderTraversal.levelOrder(root);
		
		values = new String[] { "1"};
		root = TreeUtil.createTree(values);
		System.out.println("\n");
		sum(root);
		LevelOrderTraversal.levelOrder(root);
		
		values = new String[] { "1","2","3"};
		root = TreeUtil.createTree(values);
		sum(root);
		System.out.println("\n");
		LevelOrderTraversal.levelOrder(root);
		
		System.out.println("\n");
		System.out.println("sum of tree : " + sum(null));
	}
	
	public static int sum(Tree root){
		
		if(root == null ) return 0;
		
		if(root.getLeft() == null && root.getRight() == null) return root.getData();
		
		int ls= sum(root.getLeft());
		int rs = sum(root.getRight());
		
		root.setData(ls+rs+root.getData());
		
		return root.getData();
	}

}
