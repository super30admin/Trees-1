// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TreeNode prev=null;
    public boolean validate(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean left= validate(root.left);
        
        if(prev!=null && prev.val>=root.val){
            return false;
        }
        
        prev=root;

        boolean right=validate(root.right);
        
        return left && right;
        
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root);
    }
}