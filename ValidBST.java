/* Time Complexity :  O(n)
   Space Complexity :  O(h) where h is height of the tree
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return helper(root,null,null);
        
    }
    private boolean helper(TreeNode root,Integer min, Integer max){
        if(root==null) return true;
        if((min!=null && min>= root.val) || (max!=null && max <= root.val))
            return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}