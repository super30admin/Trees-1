// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Recursively Iterating over every node with min and max values
// and checking if the sub tree is a valid BST too by checking if the value 
// for root node lies in the specified range

// LC- 98. Validate Binary Search Tree

public class ValidateBST {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  public boolean helper(TreeNode root, Integer min, Integer max) {
    if (root == null) {
      return true;
    }

    if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
      return false;
    }

    return helper(root.left, min, root.val) && helper(root.right, root.val, max);
  }
}
