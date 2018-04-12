package tree;

import tree.traversal.LevelOrderTraversal;
import tree.util.Tree;
import tree.util.TreeUtil;

public class MirrorImageOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		Tree root = TreeUtil.createTree(values);
		mirror(root);
		LevelOrderTraversal.levelOrder(root);
		
		values = new String[] { "1"};
		root = TreeUtil.createTree(values);
		System.out.println("\n");
		mirror(root);
		LevelOrderTraversal.levelOrder(root);
		
		values = new String[] { "1","2","3"};
		root = TreeUtil.createTree(values);
		mirror(root);
		System.out.println("\n");
		LevelOrderTraversal.levelOrder(root);
		
		System.out.println("\n");
		mirror(null);		
		
		values = new String[] { "1", "2", "3", "4", "5", "&", "6" };
		root = TreeUtil.createTree(values);
		mirror(root);
		System.out.println("\n");
		LevelOrderTraversal.levelOrder(root);
	}
	
	public static void mirror(Tree root){
		
		if(root == null) return ;
		
		if(root.getLeft() == null && root.getRight() == null ) return;
		
		Tree temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		
		mirror(root.getLeft());
		mirror(root.getRight());
		
	}

}
