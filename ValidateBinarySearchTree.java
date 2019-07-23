package day15;

/*
Idea : 1. We recursively check whether the max value to the left of root node is less than root node.
	   2. We also check the min value to right of the root node to be more than root node.
	   3. Keep on checking till all subtree nodes are traversed.  
Time Complexity : O(n) where n is the number of nodes
Space Complexity : O(n) as we have traverse all the tree nodes.
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

public class ValidateBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {

		return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean isBSTUtil(TreeNode node, long min, long max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.val <= min || node.val >= max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.val) && isBSTUtil(node.right, node.val, max));
	}
}
