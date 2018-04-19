package tree.avl;

import tree.HeightOftheTree;
import tree.traversal.PostOrderTraversal;
import tree.util.Tree;
import tree.util.TreeUtil;

public class ConvertBst2AvlTree {

	public static void main(String[] args) {

		// Right skews
		String[] values = new String[] { "50", "&", "170", "&", "&", "&",
				"180", "&", "&", "&", "&", "&", "&", "&", "190" };
		Tree root = TreeUtil.createTree(values);
		PostOrderTraversal.postOrder(root);
		System.out.println("\nAVL");
		Tree avlconverted = convertBst2Avl(root);
		PostOrderTraversal.postOrder(avlconverted);
		System.out.println("\n IsAVL ==> " + CheckBSTisAVL.isAVL(avlconverted));

		// left skews
		System.out.println("\n");
		values = new String[] { "50", "30", "&", "20", "&", "&", "&", "10",
				"&", "&", "&", "&", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		PostOrderTraversal.postOrder(root);
		System.out.println("\nAVL");
		avlconverted = convertBst2Avl(root);
		PostOrderTraversal.postOrder(avlconverted);
		System.out.println("\n IsAVL ==> " + CheckBSTisAVL.isAVL(avlconverted));

		// Right of Right
		System.out.println("\n");
		values = new String[] { "4", "2", "7", "&", "&", "6", "9", "&", "&",
				"&", "&", "&", "&", "&", "11" };
		root = TreeUtil.createTree(values);
		PostOrderTraversal.postOrder(root);
		System.out.println("\nAVL");
		avlconverted = convertBst2Avl(root);
		PostOrderTraversal.postOrder(avlconverted);
		System.out.println("\n IsAVL ==> " + CheckBSTisAVL.isAVL(avlconverted));

		// left of left
		System.out.println("\n");
		values = new String[] { "8", "5", "9", "3", "6", "&", "&", "2", "&",
				"&", "&", "&", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		PostOrderTraversal.postOrder(root);
		System.out.println("\nAVL");
		avlconverted = convertBst2Avl(root);
		PostOrderTraversal.postOrder(avlconverted);
		System.out.println("\n IsAVL ==> " + CheckBSTisAVL.isAVL(avlconverted));

		// right of left
		System.out.println("\n");
		values = new String[] { "8", "5", "9", "3", "6", "&", "&", "&", "&",
				"&", "7", "&", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		PostOrderTraversal.postOrder(root);
		System.out.println("\nAVL");
		avlconverted = convertBst2Avl(root);
		PostOrderTraversal.postOrder(avlconverted);
		System.out.println("\n IsAVL ==> " + CheckBSTisAVL.isAVL(avlconverted));

		// left of right
		System.out.println("\n");
		values = new String[] { "4", "2", "7", "&", "&","6", "8", "&","&", "&",
				"&", "5", "&", "&", "&"};
		root = TreeUtil.createTree(values);
		PostOrderTraversal.postOrder(root);
		System.out.println("\nAVL");
		avlconverted = convertBst2Avl(root);
		PostOrderTraversal.postOrder(avlconverted);
		System.out.println("\n IsAVL ==> " + CheckBSTisAVL.isAVL(avlconverted));
	}

	public static Tree convertBst2Avl(Tree root) {
		if (root == null)
			return null;

		if (root.getLeft() == null && root.getRight() == null)
			return root;

		root.setLeft(convertBst2Avl(root.getLeft()));
		root.setRight(convertBst2Avl(root.getRight()));

		if (!CheckBSTisAVL.isHBT(root)) {

			int lstHeight = HeightOftheTree.height(root.getLeft());
			int rstHeight = HeightOftheTree.height(root.getRight());

			if (lstHeight > rstHeight) {
				Tree lst = root.getLeft();
				if (lst != null) {
					int lstHeightOfLst = HeightOftheTree.height(lst.getLeft());
					int rstHeightOfLst = HeightOftheTree.height(lst.getRight());

					if (lstHeightOfLst > rstHeightOfLst) {
						return RotationFactory.leftRotation(root);
					} else {
						return RotationFactory.leftRightRotation(root);
					}
				}

			} else {

				Tree rst = root.getRight();
				if (rst != null) {
					int lstHeightOfRst = HeightOftheTree.height(rst.getLeft());
					int rstHeightOfRst = HeightOftheTree.height(rst.getRight());

					if (lstHeightOfRst > rstHeightOfRst) {
						return RotationFactory.rightLeftRotation(root);
					} else {
						return RotationFactory.rightRotation(root);
					}
				}
			}
		}

		return root;
	}

}
