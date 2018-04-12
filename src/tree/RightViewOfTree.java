package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class RightViewOfTree {

	private static int max = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] values = new String[] { "1", "2", "3", "&", "&", "4", "5",
				"&", "&", "&", "&", "6", "7", "&", "&" };
		Tree root = TreeUtil.createTree(values);
		rightView(root, 0);

		System.out.println();
		max = -1;
		rightView(null, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1"};
		root = TreeUtil.createTree(values);
		rightView(root, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1","2","&"};
		root = TreeUtil.createTree(values);
		rightView(root, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1","&","3"};
		root = TreeUtil.createTree(values);
		rightView(root, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1", "2", "3", "&", "&", "4", "5",
				"&", "&", "&", "&", "&", "&", "&", "7" };
		root = TreeUtil.createTree(values);
		rightView(root, 0);
		
		System.out.println();
		max = -1;
		values = new String[] { "1", "2", "&", "4", "&", "&", "&" };
		root = TreeUtil.createTree(values);
		rightView(root, 0);

	}
	
	public static void rightView(Tree root, int level) {

		if (root == null)
			return;

		if (max < level) {
			System.out.print(root.getData() + "->");
			max = level;
		}

		rightView(root.getRight(), level + 1);
		rightView(root.getLeft(), level + 1);		

	}

}
