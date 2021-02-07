//Time complexity-O(n)
//Space complecxity-O(logn)(Recursion space)
//Did the code run on leetcode- NO 
//Aproach- remember the roor and pass root's left and right to a function which validates the subtree.
        //I was not able to pass all the test cases.

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
    public boolean isValidBST(TreeNode root) {
        TreeNode prev=null;
            if(root==null)
                return true;
        if(root.left!=null && root.left.val>=root.val)
            return false;
        
        if(root.right!=null && root.right.val<=root.val)
            return false;
        
        return (BST(root.left, root) && BST(root.right,root));        
    }
    public boolean BST(TreeNode root, TreeNode prev)
    {
        
        if(root == null )
                return true;
    
        if(root.left!=null && root.left.val>=root.val)     return false;
        else
        {
            if(prev.left!=null && root.val==prev.left.val && root.right!=null && root.right.val>=prev.val)  return false;
            prev=root;
            BST(root.left,prev);
        }
        if(root.right!=null && root.right.val<=root.val)    return false;
        else
        { 
           if(prev.right!=null && root.val==prev.right.val && root.left!=null && root.left.val<=prev.val) return false;
            prev=root;
            BST(root.right,prev);
        }
            
        return true;
    }
}