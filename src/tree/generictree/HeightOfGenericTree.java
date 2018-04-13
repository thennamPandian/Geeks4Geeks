package tree.generictree;

import tree.HeightOftheTree;
import tree.util.Tree;
import tree.util.TreeFactory;

public class HeightOfGenericTree {

	public static void main(String[] args) {
		// Normal Generic Tree
		Tree root = TreeFactory.createNormalGenericTree();
		System.out.println(HeightOftheTree.height(root));

		// Null
		System.out.println(HeightOftheTree.height(null));

		// Single element generic tree
		root = TreeFactory.createSingleElementGenericTree();
		System.out.println(HeightOftheTree.height(root));

		// No sibling tree
		root = TreeFactory.createNoSiblingGenericTree();
		System.out.println(HeightOftheTree.height(root));

		// No child tree
		root = TreeFactory.createNoChildGenericTree();
		System.out.println(HeightOftheTree.height(root));
	}
}
