// Time Complexity : Need help
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean result = checkValidBST(root, null, null);
        return result;
    }
    
    public boolean checkValidBST(TreeNode root, TreeNode left, TreeNode right){
        if(root == null){
            return true;
        }
        if(left != null && root.val <= left.val){
            return false;
        }
        if(right != null && root.val >= right.val){
            return false;
        }
        return checkValidBST(root.left, left, root) && checkValidBST(root.right, root, right);
        
    }
}