// Time Complexity : O(n) where  n is number of nodes
// Space Complexity : O(h) where h is height of the tree. (Considering the recursion stack)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No. 


// Your code here along with comments explaining your approach
class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        if(root == null) return true;
        inorder(root);
        return isValid ;
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null ) return;
        
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            isValid = false;
            return ;   
        }
        prev = root;
        inorder(root.right);
        
    }
}