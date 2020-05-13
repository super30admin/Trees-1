

// Time Complexity : O(n) ; n - number of nodes in the given tree
// Space Complexity : O(h) ; h - height of the given tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/*
	1. Maintain min and max at each node and ensure the node val between these min and max
	2. if going left
			min same and max = prev node val
	3. if going right
			min = prev node val and max same
*/

// Your code here along with comments explaining your approach

public class ValidBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// Aproach 2 : Maintain min and max allowed at each node and check if
	// the node value is between these values
	// Recursive approach
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	private boolean helper(TreeNode node, Integer min, Integer max) {
		// base
		if (node == null)
			return true;

		if ((max != null && node.val >= max) || (min != null && node.val <= min))
			return false;

		// logic
		return helper(node.left, min, node.val) && helper(node.right, node.val, max);
	}
}

