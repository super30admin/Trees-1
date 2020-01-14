// Time complexity is O(n) as we going through all the nodes
// Space complexity is if we consider recursive stack then it is the height of the tree O(h)
// this solution is submitted on leetcode

public class BigN42IsValidateBSTMinAndMaxSolutionUsingNull {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	private boolean isValid(TreeNode root, Integer max, Integer min) {
		// base case
		if (root == null)
			return true;
		if (min != null && root.val <= min)
			return false;
		if (max != null && root.val >= max)
			return false;
		// logic
		return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
	}
}
