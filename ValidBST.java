// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
class ValidBST {
    public boolean isValidBST(TreeNode root) {
        Integer min = null;
        Integer max = null;
        
        return validate(root,min,max);
    }
    
    private boolean validate(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
        
        if((min!=null && root.val<=min) || (max!=null && root.val>=max))
            return false;
        
        return (validate(root.left,min,root.val) && validate(root.right,root.val,max));
    }
}
