package tree.generictree;

import tree.MirrorImageOfTree;
import tree.traversal.InorderTraversal;
import tree.traversal.LevelOrderTraversal;
import tree.util.Tree;
import tree.util.TreeFactory;

public class MirrorImagesOfGenericTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Normal Generic Tree
		Tree root = TreeFactory.createNormalGenericTree();
		InorderTraversal.inOrder(root);
		System.out.println();
		MirrorImageOfTree.mirror(root);
		InorderTraversal.inOrder(root);
		System.out.println("\n");

		// Null
		MirrorImageOfTree.mirror(null);
		InorderTraversal.inOrder(null);
		System.out.println(); 

		// Single element generic tree
		root = TreeFactory.createSingleElementGenericTree();		
		MirrorImageOfTree.mirror(root);
		InorderTraversal.inOrder(root);
		System.out.println();

		// No sibling tree
		root = TreeFactory.createNoSiblingGenericTree();
		InorderTraversal.inOrder(root);
		System.out.println();
		MirrorImageOfTree.mirror(root);
		InorderTraversal.inOrder(root);
		System.out.println("\n");

		// No child tree
		root = TreeFactory.createNoChildGenericTree();
		InorderTraversal.inOrder(root);
		System.out.println();
		MirrorImageOfTree.mirror(root);
		InorderTraversal.inOrder(root);
		System.out.println("\n");
	}

}
