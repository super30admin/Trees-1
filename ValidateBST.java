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
    // Time Complexity: O(N)
    // Space Complexity: O(H)
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
       if ( root == null ) {
        return true;
       }
        dfs (root, null, null);
        return isValid;
    }
    public void dfs(TreeNode root, Integer min, Integer max) {
        if (root == null ){
            return;
        }
        if ((min != null && root.val <= min) || (max !=null &&root.val >= max  )){
        isValid = false;
        return ;
        }
    dfs (root.left, min,root.val);
   dfs (root.right,root.val,max);
    }
}