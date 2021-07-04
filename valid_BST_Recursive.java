// Time Complexity : O(n) where n= all values in the array 

// Space Complexity : O(h) height of the stack - Recursive Stack

class Solution {
    /* Global Variable */
    
    boolean result;
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        /* Recursive using inorder */
        
        result=true;
        prev=null;
        
        helper(root);
        
        return result;
    }
    
    public void helper(TreeNode root)
    {
        /* Base case */
        if(root==null)
            return;
        
        helper(root.left);
        
        /* Logic */
        if(prev!=null && prev.val>=root.val)
            result=false;
        
        prev=root;
        helper(root.right);
    }
}