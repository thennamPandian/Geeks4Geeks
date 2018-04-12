package tree;

import tree.traversal.LevelOrderTraversal;
import tree.util.Tree;
import tree.util.TreeUtil;

public class ReplaceNodeWithSumOfChildren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] values = new String[] { "1", "2", "3", "4", "5", "6", "7", "&", "&", "&","&", "&", "&","&","9" }; 
		Tree root = TreeUtil.createTree(values);
		replaceWithSum(root);
		LevelOrderTraversal.levelOrder(root);
		
		values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		root = TreeUtil.createTree(values);
		System.out.println("\n");
		replaceWithSum(root);
		LevelOrderTraversal.levelOrder(root);
		
		values = new String[] { "1"};
		root = TreeUtil.createTree(values);
		System.out.println("\n");
		replaceWithSum(root);
		LevelOrderTraversal.levelOrder(root);
		
		values = new String[] { "1","2","3"};
		root = TreeUtil.createTree(values);
		replaceWithSum(root);
		System.out.println("\n");
		LevelOrderTraversal.levelOrder(root);
		
		System.out.println("\n");
		System.out.println("replaceWithSum of tree : " + replaceWithSum(null));

	}
	
	public static int replaceWithSum(Tree root){
		
		if(root == null ) return 0;
		
		if(root.getLeft() == null && root.getRight() == null) return root.getData();
		
		if(root.getLeft() == null && root.getRight() != null){
			root.setData(root.getRight().getData());
			return root.getData();
		}
		
		if(root.getLeft() != null && root.getRight() == null){
			root.setData(root.getLeft().getData());
			return root.getData();
		}
		
		root.setData(root.getLeft().getData()+root.getRight().getData());
		
		replaceWithSum(root.getLeft());
		replaceWithSum(root.getRight());
		
		return 0;
	}

}
