// Time Complexity : O(N)
// Space Complexity : O(H), where H is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1() {
	}

	TreeNode1(int val) {
		this.val = val;
	}

	TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Recursive_Valid_BST {
	TreeNode1 prev;

	public boolean isValidBST(TreeNode1 root) {
		return inorder(root);
	}

	public boolean inorder(TreeNode1 root) {
		// base
		if (root == null) {
			return true;
		}
		// logic
		if (inorder(root.left) == false)
			return false;
		if (prev != null && prev.val >= root.val) {
			return false;
		}
		prev = root;
		return inorder(root.right);
	}
}