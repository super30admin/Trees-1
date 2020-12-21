/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private TreeNode prev;
    public bool IsValidBST(TreeNode root) {
        
        prev = null;
        return inorder(root);
        
    }
    
    private bool inorder(TreeNode root)
    {
        if(root==null)
        {
            return true;
        }
       
        if(!inorder(root.left))
        {
            return false;
        }
        if(prev!=null && root.val <=prev.val)
        {
            return false;
        }
        prev= root;
        return inorder(root.right);
    }
}
