package tree.bst;

import tree.util.Tree;
import tree.util.TreeUtil;

public class DeleteNodeInBST {

	private static Tree root = null;

	public static void main(String[] args) {
		// Left node deletion
		String[] values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(1);
		InOrderTraversal.inOrderTraversal(root);

		// Root node deletion
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(4);
		InOrderTraversal.inOrderTraversal(root);

		// Delete root node, it left node is the max of left sub tree
		values = new String[] { "4", "2", "6", "1", "&", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(4);
		InOrderTraversal.inOrderTraversal(root);

		// Delete a node which has only left sub tree
		values = new String[] { "4", "2", "6", "1", "&", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(2);
		InOrderTraversal.inOrderTraversal(root);

		// Delete a node which has only left sub tree
		values = new String[] { "4", "2", "6", "&", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(2);
		InOrderTraversal.inOrderTraversal(root);

		// Delete a node which has both left and right sub trees
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(2);
		InOrderTraversal.inOrderTraversal(root);

		// Delete a node which does not exist in the tree
		values = new String[] { "4", "2", "6", "1", "3", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(11);
		InOrderTraversal.inOrderTraversal(root);

		// Delete a node from the tree which has only the single element in the tree
		values = new String[] { "4" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println("\nO/p =>");
		deleteNode(4);
		InOrderTraversal.inOrderTraversal(root);
		
		// Deleting root node tree which has only left sub tree
		values = new String[] { "4", "2", "&", "1", "3", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(4);
		InOrderTraversal.inOrderTraversal(root);
		
		// Deleting root node tree which has only right sub tree
		values = new String[] { "4", "&", "6", "&", "&", "5", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println();
		deleteNode(4);
		InOrderTraversal.inOrderTraversal(root);
		
		// Deleting node tree which has only left sub tree
		values = new String[] { "4", "2", "&", "1", "3", "&", "&" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println("\nO/p =>");
		deleteNode(2);
		InOrderTraversal.inOrderTraversal(root);
		
		// Deleting node tree which has only right sub tree
		values = new String[] { "4", "&", "6", "&", "&", "&", "7" };
		root = TreeUtil.createTree(values);
		System.out.println();
		InOrderTraversal.inOrderTraversal(root);
		System.out.println("\nO/p =>");
		deleteNode(6);
		InOrderTraversal.inOrderTraversal(root);


	}

	public static void deleteNode(int data) {
		if (root == null)
			return;

		Tree p = root;
		Tree cur = p;
		boolean isFound = false;

		// Find the node
		if (p.getData() != data) {
			cur = p.getData() < data ? p.getRight() : p.getLeft();

			while (cur != null) {

				if (cur.getData() == data) {
					isFound = true;
					break;
				} else if (cur.getData() < data) {
					cur = cur.getRight();
					p = p.getRight();
				} else {
					cur = cur.getLeft();
					p = p.getLeft();
				}
			}
		} else {
			isFound = true;
		}

		if (isFound) {
			if (cur.getLeft() == null && cur.getRight() == null) { // Leaf node
				if (p != cur) {
					if (p.getData() > data) {
						p.setLeft(null);
					} else {
						p.setRight(null);
					}
				}else{ 
					// Deleting single node tree
					root = null;
				}				
			} else if (cur.getLeft() != null && cur.getRight() == null) { // Node has only left sub tree
				if (p != cur) {
					if (p.getData() > data) {
						p.setLeft(cur.getLeft());
					} else {
						p.setRight(cur.getLeft());
					}
				} else {
					// Deleting root node tree which has only left sub tree
					root = p.getLeft();
				}
			} else if (cur.getRight() != null && cur.getLeft() == null) { // Node has only right sub tree
				if (p != cur) {
					if (p.getData() > data) {
						p.setLeft(cur.getRight());
					} else {
						p.setRight(cur.getRight());
					}
				} else {
					// Deleting root node tree which has only right sub tree
					root = p.getRight();
				}
			} else { // Node has both sub trees

				Tree tempP = cur;
				Tree maxElement = cur.getLeft();

				if (maxElement.getRight() != null) {
					// Max element is not cur node's left child
					while (maxElement.getRight() != null) {
						tempP = maxElement;
						maxElement = maxElement.getRight();
					}

					tempP.setRight(maxElement.getLeft());
					maxElement.setLeft(cur.getLeft());
					maxElement.setRight(cur.getRight());

					if (p != cur) {
						if (p.getData() > data) {
							p.setLeft(maxElement);
						} else {
							p.setRight(maxElement);
						}
					} else {
						p = maxElement;
						root = maxElement;
					}
					cur = null;
				} else {
                   // Max element is cur node's left child
					if (root == tempP) {
						maxElement.setRight(tempP.getRight());
						root = maxElement;
					} else {
						if (p.getData() > data) {
							p.setLeft(maxElement);
						} else {
							p.setRight(maxElement);
						}
						maxElement.setRight(tempP.getRight());
					}
				}

			}
		}

	}

}
