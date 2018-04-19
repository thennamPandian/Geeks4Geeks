package tree.util;

public class AVLTree {

	private AVLTree left;
	private AVLTree right;
	private int data;
	private int height;

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AVLTree getLeft() {
		return left;
	}

	public void setLeft(AVLTree left) {
		this.left = left;
	}

	public AVLTree getRight() {
		return right;
	}

	public void setRight(AVLTree right) {
		this.right = right;
	}

}
