package tree;

import tree.util.Tree;
import tree.util.TreeUtil;

public class DistanceBetween2Nodes {

	public static int distance(Tree lca, int n1, int n2) {
		return TreeUtil.countNodes(lca, n1) + TreeUtil.countNodes(lca, n2);
	}
}
