package tree.avl;

import tree.util.AVLTree;

public class RotationFactory {

	public AVLTree leftRotation(AVLTree x) {
		AVLTree w = x.getLeft();
		x.setLeft(w.getRight());
		w.setRight(x);
		updateHeight(x);
		updateHeight(w);
		return w;
	}

	
	public AVLTree rightRotation(AVLTree x) {		
		AVLTree w = x.getRight();
		x.setRight(w.getLeft());
		w.setLeft(x);
		updateHeight(x);
		updateHeight(w);
		return w;
	}
	
	
	public AVLTree leftRightRotation(AVLTree z){
		z.setLeft(rightRotation(z.getLeft()));
		return leftRotation(z);	
	}
	
	public AVLTree rightLeftRotation(AVLTree z){
		z.setRight(leftRightRotation(z.getRight()));
		return rightRotation(z);	
	}
	
	private static void updateHeight(AVLTree x) {
		int lstHeight = x.getLeft() != null ? x.getLeft().getHeight() : 0;
		int rstHeight = x.getRight() != null ? x.getRight().getHeight() : 0;
		int height = Math.max(lstHeight, rstHeight) + 1;
		x.setHeight(height);
	}

}
