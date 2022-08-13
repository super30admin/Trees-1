

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {

    
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root,long low,long high){
        
        if (root == null) {
            return true;
        }
    
        if (( root.val <= low) || ( root.val >= high)) {
            return false;
        }
        
        return helper(root.right, root.val, high) && helper(root.left, low, root.val);
    }
}
