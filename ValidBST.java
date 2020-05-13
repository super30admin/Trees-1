

// Time Complexity : O(n) ; n - number of nodes in the given tree
// Space Complexity : O(h) ; h - height of the given tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/*
	1. Go to the left child
    2. Make sure the previous is greater than current and increment previous to current
	3. Go to the right child
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

	// Aproach 1 : Have current and previous pointer and ensure previous > current always
	// Recursive approach

	TreeNode prev = null;

	public boolean isValidBST(TreeNode root) {
		return inOrder(root);
	}

	private boolean inOrder(TreeNode node) {

		if (node == null)
			// If there are no nodes, it's a Valid BST
			return true;

		// left hop
		if (inOrder(node.left) == false)
			return false;

		// logic
		if (prev != null && prev.val >= node.val)
			return false;
		prev = node;

		// right hop
		return inOrder(node.right);
	}
}

