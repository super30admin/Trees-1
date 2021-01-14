// Time Complexity : O(n)
// Space Complexity :  O (h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    boolean result = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {


        validate(root);
        return result;
    }

    void validate(TreeNode root){
        if(root == null) return;

        validate(root.left);

        if(prev != null && root.val <= prev.val)
        {
            result = false;
        }
        prev = root;
        validate(root.right);

    }
}
