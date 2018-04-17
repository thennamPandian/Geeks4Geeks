package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class SubTreeBetterApproach {

	public static void main(String[] args) {

		// Both null
		System.out.println(subTreeBetterApproach(null, null));
		
		// Big is not null, small one is null
		String[] values = new String[] { "1" ,"2","3"};
		Tree root1 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, null));
		
		// Big is null, small one is not null
		System.out.println(subTreeBetterApproach(null, root1));
		
		System.out.println("\n############ Non-Null ############\n");
		
		// Same tree ==> true
		values = new String[] { "1" ,"2","3"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "1" ,"2","3"};
		Tree root2 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, root2));
		
		// Small tree is left sub tree of big ==> true
		values = new String[] { "1" ,"2","5","3","&","&","&"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "2","3","&"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, root2));
		
		// Small tree is right sub tree of big ==> true
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "5","&","6","&", "&", "&", "7"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, root2));
		
		// Small tree is not sub tree of big ==> false
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "15","&","16","&", "&", "&", "17"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, root2));
		
		// Small tree is not sub tree of big ==> false
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "5","&","6","&", "&", "12", "7"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, root2));
		
		// Small tree is sub tree of big, except the one element ==> false
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "5","&","6","&", "&", "&", "17"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, root2));
		
		// Small tree ( single element tree)  is sub tree of big, ==> true
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "5"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, root2));
		
		// Small tree ( single element tree)  is sub tree of big,==> false
		values = new String[] { "1" ,"2","5","3","&","&","6","&", "&", "&", "&", "&", "&","&","7"};
		root1 = TreeUtil.createTree(values);		
		values = new String[] { "15"};
		root2 = TreeUtil.createTree(values);
		System.out.println(subTreeBetterApproach(root1, root2));
		
	}

	
	public static boolean subTreeBetterApproach(Tree root1, Tree root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 == null)
			return true;
		if (root1 == null && root2 != null)
			return false;

		return preOrderString(root1).indexOf(preOrderString(root2)) != -1 &&
				inOrderString(root1).indexOf(inOrderString(root2)) != -1;
	}

	
	private static String preOrderString(Tree root){
		
		if(root == null) return "";
		
		if(root.getLeft() == null && root.getRight() == null) return String.valueOf(root.getData());
		
		StringBuffer sb = new StringBuffer();	
		sb.append(String.valueOf(root.getData()));
		sb.append(preOrderString(root.getLeft()));	
		sb.append(preOrderString(root.getRight()));		
		return sb.toString();
	}
	
	private static String inOrderString(Tree root){
		
		if(root == null) return "";
		
		if(root.getLeft() == null && root.getRight() == null) return String.valueOf(root.getData());
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(inOrderString(root.getLeft()));
		sb.append(String.valueOf(root.getData()));
		sb.append(inOrderString(root.getRight()));
		
		return sb.toString();
	}
}
