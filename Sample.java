//Problem 98- Validate BST
//TC-O(n)
//SC-O(n)

Solution-
  
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
    TreeNode prev=null;
    Boolean isValid=true;
    public boolean isValidBST(TreeNode root) {
        //TreeNode prev=null;
        //Boolean isValid=true;
        traverse(root);
        return isValid;
    }
    private void traverse(TreeNode root)
    {
        //int prev=null;
        //Boolean isValid;
        if(root==null) return;
        
        traverse(root.left);
        if(prev!=null&&prev.val>=root.val )
        {
            isValid= false;
            return;
        }
        prev=root;
        traverse(root.right);
    }
}
