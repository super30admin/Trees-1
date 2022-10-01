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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        return isBSTMM(root,null,null);
        
    }
    
    public boolean isBSTMM(TreeNode root,Integer min, Integer max)
    {
        if(root==null) return true;
        if((min!=null && min>=root.val) || (max!=null && max<=root.val)) return false;
        if(isBSTMM(root.left,min,root.val))
            return isBSTMM(root.right,root.val,max);
        
        return false;
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