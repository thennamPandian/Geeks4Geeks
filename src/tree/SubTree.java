package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class SubTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subTree(null, null));
		
		String[] values = new String[] { "1" ,"2","3"};
		Tree root1 = TreeUtil.createTree(values);
		System.out.println(subTree(root1, null));
		
		System.out.println(subTree(null, root1));
		
		
		values = new String[] { "1" ,"2","3"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "1" ,"2","3"};
		Tree root2 = TreeUtil.createTree(values);
		System.out.println(subTree(root1, root2));
		
		values = new String[] { "1" ,"2","5","3","&","&","&"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "2","3","&"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTree(root1, root2));
		
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "5","&","6","&", "&", "&", "7"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTree(root1, root2));
		
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "15","&","16","&", "&", "&", "17"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTree(root1, root2));
		
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "5","&","6","&", "&", "12", "7"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTree(root1, root2));
		
	}

	public static boolean subTree(Tree root1, Tree root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 == null)
			return true;
		if (root1 == null && root2 != null)
			return false;

		if (IdenticalTrees.identical(root1, root2))
			return true;

		if (IdenticalTrees.identical(root1.getLeft(), root2))
			return true;

		if (IdenticalTrees.identical(root1.getRight(), root2))
			return true;

		return false;
	}

}
