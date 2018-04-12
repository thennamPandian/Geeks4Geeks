package tree.generictree;

import java.util.ArrayList;
import java.util.List;

import tree.util.Tree;
import tree.util.TreeFactory;
import tree.util.TreeUtil;

public class CountSiblingOfANodeInGenericTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Normal Generic Tree
		Tree root = TreeFactory.createNormalGenericTree();
		System.out.println(countSiblings(root, 1));

		System.out.println(countSiblings(root, 2));
		System.out.println(countSiblings(root, 5));
		System.out.println(countSiblings(root, 7));

		// Node which is not there in the node
		System.out.println("Node which is not there in the node : "
				+ countSiblings(root, 16));

		// null tree
		System.out.println(" Null Tree : " + countSiblings(null, 16));

		// Single element generic tree
		root = TreeFactory.createSingleElementGenericTree();
		System.out.println(" Single element generic tree : "
				+ countSiblings(root, 1));

		// No sibling tree
		root = TreeFactory.createNoSiblingGenericTree();
		System.out.println("No Sibling tree :  " + countSiblings(root, 1));

		// No child tree
		root = TreeFactory.createNoChildGenericTree();
		System.out.println(" No child tree " + countSiblings(root, 2));

	}

	private static int countSiblings(Tree root, int data) {

		Tree node = TreeUtil.findRootOfNode(root, data);
		int childCount = 0;
		if (node != null) {
			Tree firstChild = node.getLeft();

			while (firstChild != null) {
				childCount++;
				firstChild = firstChild.getRight();
			}
		}

		return childCount == 0 ? 0 : childCount - 1;
	}

}
