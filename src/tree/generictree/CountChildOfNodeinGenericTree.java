package tree.generictree;

import java.util.ArrayList;
import java.util.List;

import tree.util.Tree;
import tree.util.TreeFactory;
import tree.util.TreeUtil;

public class CountChildOfNodeinGenericTree {

	public static void main(String[] args) {

		// Normal Generic Tree
		Tree root = TreeFactory.createNormalGenericTree();
		System.out.println(countChild(root, 1));
		System.out.println(countChild(root, 2));
		System.out.println(countChild(root, 3));
		System.out.println(countChild(root, 6));

		// Node which is not there in the node
		System.out.println("Node which is not there in the node : "
				+ countChild(root, 16));

		// null tree
		System.out.println(" Null Tree : " + countChild(null, 16));

		// Single element generic tree
		root = TreeFactory.createSingleElementGenericTree();
		System.out.println(" Single element generic tree : "
				+ countChild(root, 1));

		// No sibling tree
		root = TreeFactory.createNoSiblingGenericTree();
		System.out.println("No Sibling tree :  "+countChild(root, 1));

		// No child tree
		root = TreeFactory.createNoChildGenericTree();
		System.out.println(" No child tree " + countChild(root, 2));

	}

	private static int countChild(Tree root, int data) {
		int childCount = 0;
		Tree node = TreeUtil.findNodeInTree(root, data);
		if (node != null) {
			Tree firstChild = node.getLeft();

			while (firstChild != null) {
				childCount++;
				firstChild = firstChild.getRight();
			}
		}

		return childCount;
	}

}
