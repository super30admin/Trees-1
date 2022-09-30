class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        return isBST(root);
        
    }
    
    public boolean isBST(TreeNode root)
    {
        if(root==null) return true;
        
        if(!isBST(root.left))
            return false;
        
        if(prev!=null && prev.val>=root.val)
            return false;
        
        prev=root;
        
        return isBST(root.right);     
    }
    
}

// Time Complexity : O(N)
// Space Complexity : O(log N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no