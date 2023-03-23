/**
 * Definition for a binary tree node.
*/

// Time Complexity: O(n)
// Space Complexity: O(h)
// Did this code run on leetcode? : Yes
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode root, Integer low, Integer high) {
        if(root == null) {
            return true;
        }

        if(
            (high != null && root.val >= high) || 
            (low != null && root.val <= low)
        ) {
            return false;
        }

        return isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val, high);
    }
}