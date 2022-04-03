//Time Complexity : O(n)
//Space Complexity : O(h)


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
class Solution {
    
    boolean flag;
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        
        flag = true;
        
        if(root == null)
        {
            return false;
        }
        
        helper(root);
        
        return flag;
        
    }
    
    private void helper(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        if(flag)
        {
            helper(root.left);
        }
            
        if(prev!=null && prev.val >= root.val)
        {
            flag = false;
            return;
        }
        
        prev = root;
        
        if(flag)
        {
            helper(root.right);
        }
        
        return;
    }
}