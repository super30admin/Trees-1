/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 
// Time Complexity : O(n)
// Space Complexity : O(n) for recrsive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public boolean isValidBST(TreeNode root) {
       long min = Long.MIN_VALUE;
       long max = Long.MAX_VALUE;
        
        return checkBST(root, min, max);
        
    }
    
    
    public boolean checkBST(TreeNode root, long min, long max){
        if(root == null){
            return true;
        } if(root.val<=min || root.val >=max){
            return false;
        }
        
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}