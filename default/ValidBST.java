
//Definition for a binary tree node.
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

public class ValidBST {

	// Recursive approach
	// Time complexity - o(n) n - number of nodes
	// Space complexity - o(1) or if we consider recursive stack space then o(h) h-
	// height of the tree
	TreeNode prev;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return inorderValidBST(root);
	}

	public boolean inorderValidBST(TreeNode root) {
		// base
		if (root == null)
			return true;

		// logic
		if (inorderValidBST(root.left) == false)
			return false;

		if (prev != null && prev.val >= root.val)
			return false;
		prev = root;

		return inorderValidBST(root.right);
	}

	/*
	 * public boolean isValidBST(TreeNode root) {
	 * 
	 * if(root == null) return true;
	 * 
	 * //iterative approach 
	 * // Time complexity - o(n) n - number of nodes 
	 * //Space complexity - o(h) h- height of the tree Stack<TreeNode> st = new Stack<>();
	 * TreeNode prev = null;
	 * 
	 * while(root != null || !st.isEmpty()) {
	 * while(root != null){ 
	 * st.push(root);
	 * root = root.left; 
	 * } 
	 * root = st.pop(); 
	 * if(prev != null && prev.val >= root.val) return false; 
	 * prev = root;
	 * root = root.right; 
	 * } 
	 * 
	 * return true; 
	 * }
	 */

}
