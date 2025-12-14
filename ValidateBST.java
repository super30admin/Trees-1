// TC: O(n) => number of nodes
// SC: O(h) => height of the tree

// 1: We use recursion to solve this problem by pre-order traversal
// 2: By checking that each node is in the allowed range (using BST rules) we are able to solve the problem
// 3: We have optimized the solution by only traversing if the conditions are met to continue with traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        // base case
        if (root == null)
            return true;

        if ((max != null && root.val >= max) || (min != null && root.val <= min))
            return false;
        boolean left = helper(root.left, min, root.val);
        if (left == true) {
            return helper(root.right, root.val, max);
        } else
            return false;
    }
}