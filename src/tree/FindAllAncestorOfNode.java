package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class FindAllAncestorOfNode {

	public static void main(String[] args) {
		// Mini B tree
		String[] values = new String[] { "1", "2", "3" };
		Tree root = TreeUtil.createTree(values);
		System.out.println(findAncestor(root, 3, ""));

		// level 2, B tree. find ancestor for leaf node in left sub tree
		values = new String[] { "1", "2", "3","4","5","6","7" };
		root = TreeUtil.createTree(values);
		System.out.println(findAncestor(root, 4, ""));
		
		// level 2, B tree. find ancestor for leaf node in right sub tree		
		System.out.println(findAncestor(root, 7, ""));
		
		// level 2, B tree. find ancestor for non-leaf node in right sub tree		
		System.out.println(findAncestor(root, 3, ""));
		
		
		// null, B tree. find ancestor for node
		System.out.println(" null tree ==> "+ findAncestor(null, 3, ""));
		
		// level 2, B tree. find ancestor for node which is not part of the tree	
		System.out.println(" element does not exist == > " + findAncestor(root, 13, ""));
		

		// left skews
		System.out.println("\n");
		values = new String[] { "50", "30", "&", "20", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println(findAncestor(root, 20, ""));
		

		// Right skews
		System.out.println("\n");
		values = new String[] { "50", "&", "170", "&", "&", "&", "180" };
		root = TreeUtil.createTree(values);
		System.out.println(findAncestor(root, 180, ""));

		
	}

	public static String findAncestor(Tree root, int data, String s) {
		if (root == null)
			return "";

		if (root.getData() == data)
			return s;

		String value = findAncestor(root.getLeft(), data, s + ","+root.getData());
		if ( value.equals("")) {
			return findAncestor(root.getRight(), data, s + ","+ root.getData());
		}

		return value;
	}

}
