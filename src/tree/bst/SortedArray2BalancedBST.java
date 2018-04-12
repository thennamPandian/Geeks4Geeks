package tree.bst;

import tree.util.Tree;

public class SortedArray2BalancedBST {

	private static Tree root;

	public static void main(String[] args) {
		// Min Binary tree
		int[] values = new int[] { 2, 4, 6 };
		InOrderTraversal.inOrderTraversal(convertArrayToBST(values));
		
		// Null value
		InOrderTraversal.inOrderTraversal(convertArrayToBST(null));
		
		// Single Element
		values = new int[] { 2 };
		System.out.println();
		InOrderTraversal.inOrderTraversal(convertArrayToBST(values));
		
		// level 2 Binary Tree
		values = new int[] { 1,2,3,4,5,6,7 };
		System.out.println();
		InOrderTraversal.inOrderTraversal(convertArrayToBST(values));
		
		// Left sub tree has more children
		values = new int[] { 1,2,3,4,5,6 };
		System.out.println();
		InOrderTraversal.inOrderTraversal(convertArrayToBST(values));
		
	}

	public static Tree convertArrayToBST(int[] arr) {
		if (arr != null)
			return convertArrayToBST(arr, 0, arr.length - 1);

		return null;
	}

	public static Tree convertArrayToBST(int[] arr, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;

		Tree temp = new Tree();
		temp.setData(arr[mid]);

		temp.setLeft(convertArrayToBST(arr, start, mid - 1));
		temp.setRight(convertArrayToBST(arr, mid + 1, end));

		return temp;
	}

}
