// Time Complexity :O(n) touched all nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {

 //Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

    TreeNode prev=null;
    boolean isValid=true;
    // Recursive solution with global prev variable and boolean variable
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        
        inorder(root);
        return isValid;
    }
    private void inorder(TreeNode root){
        
        // base
        if(root==null)
            return;
        //logic
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            isValid=false;
        }
        prev=root;
        inorder(root.right);
    }
}