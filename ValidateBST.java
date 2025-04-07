// Time Complexity : O(n)
// Space Complexity : O(h) where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
This code validates whether a binary tree is a Binary Search Tree (BST) using an in-order traversal
approach. It has a time complexity of O(n), as each node is visited once, and a space complexity of O(h),
 where h is the height of the tree due to recursive stack space.
 The traversal ensures that node values are strictly increasing by comparing each node with
  the previously visited one. A boolean flag is used to terminate early if the BST property is violated.
   The solution ran successfully on LeetCode without any issues during implementation.


*/

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
class ValidateBST {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        helper(root);
        return flag;
    }
    private void helper(TreeNode root)
    {
        if(root==null)
            return;
        if(flag)
            isValidBST(root.left);
        if(prev!=null && prev.val>=root.val)
            flag=false;
        prev=root;


        if(flag)
            isValidBST(root.right);
    }
}