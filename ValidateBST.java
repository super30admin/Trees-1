// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * For every node, we define a left_limit and a right_limit under which the node can fall.
 * If there is a breach of the avove limits at any node, we return false.
 * For every time we go left, left_limit remains the same and right_limit is updated to the current root's value exclusive
 * For every time we go right, right_limit remains the same but left_limit is updated to current root's value
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
    
    private boolean validateBST(TreeNode root, Integer left_limit, Integer right_limit) {
        if(root == null) return true;
        
        if(left_limit != null && root.val <= left_limit){
            return false;
        }
        if(right_limit != null && root.val >= right_limit){
            return false;
        }
        
        return validateBST(root.left, left_limit, root.val) && validateBST(root.right, root.val, right_limit);
    }
    
}