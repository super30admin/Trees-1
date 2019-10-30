// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



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
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE); // Using interger min amd max values
}
  
private boolean helper(TreeNode root, long min, long max) { //Helper function 
        if(root == null) { //edge case
            return true;
        }
        
        return root.val > min && root.val < max
            && helper(root.left, min, root.val) 
            && helper(root.right, root.val, max); 
}
}