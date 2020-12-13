// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Inorder traversal of BST gives our sorted elements so we check if
// the previous node is less than parent val. if this is violated then return false.

class ValidateBST {
	/*
  Definition for a binary tree node.
  */
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

  TreeNode prev;
  public boolean isValidBST(TreeNode root) {
  	prev = null;
  	return inorder(root);   
  }
  private boolean inorder(TreeNode root) {
  	if(root == null)
  		return true;
  	if (inorder(root.left)==false) {
  		return false;
  	}
  	if(prev!=null && prev.val>=root.val) {
  		return false;
  	}
  	prev = root;
  	return inorder(root.right);
  }

}