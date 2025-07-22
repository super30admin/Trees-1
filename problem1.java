// Time Complexity: O(n) number of nodes
// Space Complexity: O(H) height of the tree

// we recursively traverse tree with min as -infinity, and max as +infinity
// while going left, we carry the min from parent and set max as parent's val
// while going right, we carry the max from the parent, and set min as parent's val


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean validateBST(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (! (root.val > min && root.val < max)) return false;

        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }
}
