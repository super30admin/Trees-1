// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
 
// Definition for a binary tree node.
 class TreeNode {
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
 
public class ValidateBinarySearchTree {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        validate(root);
        return flag;
    }

    private void validate(TreeNode root){
        if (root == null) return;
        validate(root.left);
        if (prev != null && prev.val >= root.val) {
            flag = false;
            return;   
        }
        prev = root;
        validate(root.right);
    }

}