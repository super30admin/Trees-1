
// Time Complexity : O(N)
// Space Complexity : O(H), where H is height of tree
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
import java.util.Stack;

class TreeNode {
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

class Iterative_Valid_BST {
	public boolean isValidBST(TreeNode root) {
		return inorder(root);
	}

	public boolean inorder(TreeNode root) {
		TreeNode prev = null;
		Stack<TreeNode> st = new Stack<TreeNode>();
		while (root != null || !st.isEmpty()) {
			while (root != null) {
				st.push(root);
				root = root.left;
			}
			root = st.pop();
			if (prev != null && prev.val >= root.val) {
				return false;
			}
			prev = root;
			root = root.right;
		}
		return true;
	}
}