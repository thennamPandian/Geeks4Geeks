package tree.avl;

import tree.util.AVLTree;
import tree.util.Tree;

public class RotationFactory {

	public static Tree leftRotation(Tree x) {
		Tree w = x.getLeft();
		if (w != null) {
			x.setLeft(w.getRight());
			w.setRight(x);
			return w;
		}
		return null;
	}

	public static Tree rightRotation(Tree x) {
		Tree w = x.getRight();
		if (w != null) {
			x.setRight(w.getLeft());
			w.setLeft(x);
			return w;
		}
		return null;
	}

	public static Tree leftRightRotation(Tree z) {
		Tree left = rightRotation(z.getLeft());
		if (null != left) {
			z.setLeft(left);
		}
		return leftRotation(z);
	}

	public static Tree rightLeftRotation(Tree z) {
		Tree right = leftRotation(z.getRight());
		if (null != right) {
			z.setRight(right);
		}
		return rightRotation(z);
	}

	public static AVLTree leftRotation(AVLTree x) {
		AVLTree w = x.getLeft();
		if (null != w) {
			x.setLeft(w.getRight());
			w.setRight(x);
			updateHeight(x);
			updateHeight(w);
		}
		return w;
	}

	public static AVLTree rightRotation(AVLTree x) {
		AVLTree w = x.getRight();
		if (null != w) {
			x.setRight(w.getLeft());
			w.setLeft(x);
			updateHeight(x);
			updateHeight(w);
		}
		return w;
	}

	public static AVLTree leftRightRotation(AVLTree z) {
		AVLTree left = rightRotation(z.getLeft());
		if (null != left) {
			z.setLeft(left);
		}
		return leftRotation(z);
	}

	public static AVLTree rightLeftRotation(AVLTree z) {
		AVLTree right = leftRightRotation(z.getRight());
		if (null != right) {
			z.setRight(right);
		}
		return rightRotation(z);
	}

	private static void updateHeight(AVLTree x) {
		int lstHeight = x.getLeft() != null ? x.getLeft().getHeight() : 0;
		int rstHeight = x.getRight() != null ? x.getRight().getHeight() : 0;
		int height = Math.max(lstHeight, rstHeight) + 1;
		x.setHeight(height);
	}

}
