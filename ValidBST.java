import java.util.*;

// Time Complexity : O(n) ; n - number of nodes in the given tree
// Space Complexity : O(h) ; h - height of the given tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

/*
	1. while the current is not null, keep going to left/right by pushing nodes into a Stack
    2. Make sure the previous is greater than current and increment previous to current
	3. Go to right/left (opposite to the direction in Step 1) child of the current 
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
	// Iterative approach
	public boolean isValidBST(TreeNode root) {

		TreeNode prev = null;
		Stack<TreeNode> st = new Stack<>();

		while (root != null || !st.isEmpty()) {
			// left hop
			while (root != null) {
				st.push(root);
				root = root.left;
			}
			root = st.pop();

			// logic
			if (prev != null && prev.val >= root.val)
				return false;
			prev = root;

			// right hop
			root = root.right;
		}

		return true;
	}
}

