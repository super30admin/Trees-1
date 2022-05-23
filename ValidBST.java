/**
Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */
class Solution 
{
    
    private boolean isValid = true;
    private TreeNode prev = null;
    
    
    public boolean isValidBST(TreeNode root) 
    {
        inorder(root);
        
        return isValid;
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null)
            return;
        
        if(root.left != null)
            inorder(root.left);
        
        if(prev != null && prev.val >= root.val)
        {
            isValid = false;
            return;
        }
        prev = root;
        
        if(root.right != null)
            inorder(root.right);
    }
}