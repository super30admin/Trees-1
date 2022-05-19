// Time Complexity :O(h) - height of tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return helper(root);
    }
    
    private boolean helper(TreeNode root){
        if(root==null){
            return true;
        }
        if(helper(root.left)==false){
            return false;
        }
        if(prev!=null && prev.val>= root.val){
            return false;
        }
        prev = root;
        return helper(root.right);
    }
}