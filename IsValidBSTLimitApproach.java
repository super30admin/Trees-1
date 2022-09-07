// Approach: Compare the node value with its upper and lower limits if they are available. Repeats the same step recursively for left and right subtrees.

// Time complexity: O(N)
// Space complexity: O(H)

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max) {
        // base
        if (root == null) return true; // Empty trees are valid BSTs.
        // // The current node's value must be between low and high.
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        
        // logic
        // The left and right subtree must also be valid.
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}