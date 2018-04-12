package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

/*
 * https://practice.geeksforgeeks.org/problems/size-of-binary-tree/1
 */

public class SizeOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] values = { "1", "2", "3", "4", "5", "6", "7", "&", "&", "&","9" };
		Tree root = TreeUtil.createTree(values);
		System.out.println("Size of tree : " + size(root));
		
		values = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		root = TreeUtil.createTree(values);
		System.out.println("Size of tree : " + size(root));
		
		values = new String[] { "1"};
		root = TreeUtil.createTree(values);
		System.out.println("Size of tree : " + size(root));
		
		values = new String[] { "1","2","3"};
		root = TreeUtil.createTree(values);
		System.out.println("Size of tree : " + size(root));
		
		System.out.println("Size of tree : " + size(null));
	}

	public static int size(Tree root){
		if(root == null) return 0;
		
		if(root.getLeft() == null && root.getRight() == null) return 1;
		
		int ls = size(root.getLeft());
		int rs = size(root.getRight());
		
		return ls+rs+1;
	}
}
