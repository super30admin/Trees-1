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

// Time Complexity :  O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class ValidateBST {
    
    TreeNode prev=null;
    boolean flag=true;
    public boolean isValidBST(TreeNode root) {
        
        if(root==null) return flag;   // base condition will return true first time else whatever was set to flag
        flag=isValidBST(root.left); // iterate left subtree using inorder
        // in inorder elements are sorted so just check if current elemnt is greater than previous element. If not print false
        if(prev!=null && root.val<=prev.val) return false; 
        prev=root; // reassign prev element to root
        flag=isValidBST(root.right); // check for right subtree
        return flag; // return flag value
    }
    
}