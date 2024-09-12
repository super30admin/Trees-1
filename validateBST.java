/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class validateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);    
    }
    private boolean helper(TreeNode node, Integer min, Integer max) {
        // base case
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        // logic
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}