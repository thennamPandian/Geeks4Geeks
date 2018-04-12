package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class IdenticalTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] values = new String[] { "1" ,"2","3"};
		Tree root1 = TreeUtil.createTree(values);		
		values = new String[] { "1" ,"2","3","4","&","&","&"};
		Tree root2 = TreeUtil.createTree(values);
		System.out.println(identical(root1, root2));
		
		values = new String[] { "1" ,"2","3"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "1" ,"2","3"};
		root2 = TreeUtil.createTree(values);
		System.out.println(identical(root1, root2));
		
		values = new String[] { "1", "2", "&", "3", "&", "&", "&" };
		root1 = TreeUtil.createTree(values);	
		root2 = TreeUtil.createTree(values);	
		System.out.println(identical(root1, root2));
		
		System.out.println(identical(root1, null));
		
		System.out.println(identical(null, null));
	}

	public static boolean identical(Tree root1, Tree root2) {
		if (root1 == root2)
			return true;
		if (root1 == null || root2 == null)
			return false;
		

		
		return root1.getData() == root2.getData() && 
				identical(root1.getLeft(), root2.getLeft()) &&
				identical(root1.getRight(), root2.getRight());
	}

}
