package tree.generictree;

import java.util.ArrayList;
import java.util.List;

import tree.util.Tree;
import tree.util.TreeFactory;
import tree.util.TreeUtil;

public class GenericTreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Normal Generic Tree		
		Tree root = TreeFactory.createNormalGenericTree();
		System.out.println(sum(root));
		
		// Null 
		System.out.println(sum(null));
		
		// Single element generic tree
		root = TreeFactory.createSingleElementGenericTree();
		System.out.println(sum(root));
		
		// No sibling tree
		root = TreeFactory.createNoSiblingGenericTree();
		System.out.println(sum(root));
		
		// No child tree
		root = TreeFactory.createNoChildGenericTree();
		System.out.println(sum(root));

	}

	private static int sum(Tree root) {
		int total = 0;

		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return root.getData();

		return root.getData() + sum(root.getLeft()) + sum(root.getRight());

	}
}
