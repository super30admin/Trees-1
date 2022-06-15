/* Time Complexity: O(n)
 * Space Complexity: O(h), h is the height of the tree
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

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
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        
        inorder(root.right);
        
    }
}